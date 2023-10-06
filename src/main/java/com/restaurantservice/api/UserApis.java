package com.restaurantservice.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantservice.dto.UserDto;
import com.restaurantservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApis {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
		return ResponseEntity.ok(userService.saveUser(userDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
		return ResponseEntity.ok(userService.deleteUser(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @RequestBody UserDto userDto){
		return ResponseEntity.ok(userService.updateUser(id, userDto));
	}
}
