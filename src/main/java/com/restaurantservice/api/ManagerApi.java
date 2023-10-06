/**
 * 
 */
package com.restaurantservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantservice.dto.ManagerDto;
import com.restaurantservice.service.ManagerService;

/**
 * @author Rajiv Adhav
 *
 */
@RestController
@RequestMapping("/api/manager/")
public class ManagerApi {

	@Autowired
	ManagerService managerService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllManagers(){
		return managerService.getAllManagers();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveManager(@RequestBody ManagerDto managerDto){
		return managerService.saveManager(managerDto);
	}
}
