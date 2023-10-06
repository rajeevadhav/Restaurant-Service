package com.restaurantservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restaurantservice.dto.ManagerDto;

@Service
public interface ManagerService {

	ResponseEntity<?> getAllManagers();

	ResponseEntity<?> saveManager(ManagerDto managerDto);

}
