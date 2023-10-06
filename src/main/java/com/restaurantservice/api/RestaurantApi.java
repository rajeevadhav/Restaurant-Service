/**
 * 
 */
package com.restaurantservice.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantservice.dto.RestaurantDto;
import com.restaurantservice.entity.Restaurant;
import com.restaurantservice.service.RestaurantService;

/**
 * @author Rajiv Adhav
 *
 */
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantApi {

	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
	@GetMapping("/{id}")
	public List<Restaurant> getRestaurantUserById(@PathVariable("id") int id) {
		return restaurantService.getRestaurantUserById(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantDto restaurantDto){
		return restaurantService.saveRestaurant(restaurantDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable("id") Integer id){
		return restaurantService.deleteRestaurant(id);
	} 
	
	
}
