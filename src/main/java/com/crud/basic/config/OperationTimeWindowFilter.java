package com.crud.basic.config;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.crud.basic.exceptions.OperationTimeWindowException;
import com.crud.basic.services.ISystemParameterService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(1) // Para que se ejecute antes que cualquier otro filtro
public class OperationTimeWindowFilter extends OncePerRequestFilter {    
  private ISystemParameterService service;

  public OperationTimeWindowFilter(ISystemParameterService service){
    this.service = service;
  }

  // Excluir ciertos endpoints si es necesario (ej. health checks)
  private static final List<String> EXCLUDED_PATHS = List.of(
    "/actuator/health",
    "/system/parameters",  // Para poder modificar el parámetro incluso fuera de horario
    "/api/v1/subjects"
  );

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String path = request.getRequestURI();
  
    // Si el path está excluido, permitir acceso
    if (EXCLUDED_PATHS.stream().anyMatch(path::startsWith)) {
      filterChain.doFilter(request, response);
      return;
    }
  
    // Verificar si estamos en horario permitido
    if (!isWithinOperationWindow()) {
      throw new OperationTimeWindowException(service.getOperationDeadline());
    }
  
    // Si está en horario, continuar
    filterChain.doFilter(request, response);
  }

  private boolean isWithinOperationWindow() {
    LocalTime now = LocalTime.now();
    LocalTime deadline = service.getOperationDeadline();
  
    // Permite operaciones solo si es ANTES de la hora límite
    return now.isBefore(deadline);
  }
}

