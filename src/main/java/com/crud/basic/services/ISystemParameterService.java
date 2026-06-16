package com.crud.basic.services;

import java.time.LocalTime;

public interface ISystemParameterService {
  String getParameterValue(String key);
  LocalTime getOperationDeadline();
  void updateOperationDeadline(LocalTime newDeadLine);
  void evictCache(String key);
}
