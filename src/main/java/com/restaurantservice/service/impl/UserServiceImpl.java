package com.restaurantservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restaurantservice.dto.UserDto;
import com.restaurantservice.entity.User;
import com.restaurantservice.repository.RestaurantRepository;
import com.restaurantservice.repository.UserRepository;
import com.restaurantservice.service.UserService;
import com.restaurantservice.util.ApiResponse;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> getUsers() {
		return  ResponseEntity.ok(new ApiResponse(userRepository.findAll(), HttpStatus.FOUND, null));
	}

	@Override
	public ResponseEntity<?> saveUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setRestaurantDetails(restaurantRepository.findById(userDto.getRestaurantId()).orElse(null));
		return  ResponseEntity.ok(new ApiResponse(userRepository.save(user), HttpStatus.FOUND, null));
	}

	@Override
	public ResponseEntity<?> deleteUser(Integer id) {
		userRepository.deleteById(id);
		return  ResponseEntity.ok(new ApiResponse(null, HttpStatus.OK, null));
	}

	@Override
	public ResponseEntity<?> updateUser(Integer id, UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setRestaurantDetails(restaurantRepository.findById(userDto.getRestaurantId()).orElse(null));
		return  ResponseEntity.ok(new ApiResponse(userRepository.save(user), HttpStatus.FOUND, null));
	}

}
