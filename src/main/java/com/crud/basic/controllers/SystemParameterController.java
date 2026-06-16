package com.crud.basic.controllers;

import java.time.LocalTime;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.basic.services.ISystemParameterService;

@RestController
@RequestMapping("system/parameters")
public class SystemParameterController {
  private ISystemParameterService service;

  @GetMapping("/deadline")
  public ResponseEntity<Map<String, String>> getDeadline() {
    return ResponseEntity.ok(Map.of(
      "deadline", service.getOperationDeadline().toString(),
      "message", "Operations are only allowed before this time"
    ));
  }
    
  @PutMapping("/deadline")
  public ResponseEntity<Map<String, String>> updateDeadline(
    @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime deadline) {
  
    service.updateOperationDeadline(deadline);
  
    return ResponseEntity.ok(Map.of(
      "message", "Operation deadline updated successfully",
      "new_deadline", deadline.toString()
    ));
  }
}
