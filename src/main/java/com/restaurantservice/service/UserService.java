package com.restaurantservice.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restaurantservice.dto.UserDto;

@Service
public interface UserService{

	ResponseEntity<?>  getUsers();

	ResponseEntity<?> saveUser(UserDto userDto);

	ResponseEntity<?> deleteUser(Integer id);

	ResponseEntity<?> updateUser(Integer id, UserDto userDto);

}
