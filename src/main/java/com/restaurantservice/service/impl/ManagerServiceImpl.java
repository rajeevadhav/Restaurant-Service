/**
 * 
 */
package com.restaurantservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restaurantservice.dto.ManagerDto;
import com.restaurantservice.entity.Manager;
import com.restaurantservice.repository.ManagerRepository;
import com.restaurantservice.repository.RestaurantRepository;
import com.restaurantservice.service.ManagerService;
import com.restaurantservice.util.ApiResponse;

/**
 * @author Rajiv Adhav
 *
 */
@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ResponseEntity<?> getAllManagers() {
		return ResponseEntity.ok(new ApiResponse(managerRepository.findAll(), HttpStatus.FOUND, "Manager Record feched successfully"));
	}

	@Override
	public ResponseEntity<?> saveManager(ManagerDto managerDto) {
		Manager manager = modelMapper.map(managerDto, Manager.class);
		manager.setRestaurant(restaurantRepository.findById(managerDto.getRestaurantId()).orElse(null));
		return ResponseEntity.ok(new ApiResponse(managerRepository.save(manager), HttpStatus.FOUND, "Manager Record save successfully"));
	}

}
