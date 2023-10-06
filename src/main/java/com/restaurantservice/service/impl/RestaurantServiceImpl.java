/**
 * 
 */
package com.restaurantservice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restaurantservice.dto.RestaurantDto;
import com.restaurantservice.entity.Restaurant;
import com.restaurantservice.repository.RestaurantRepository;
import com.restaurantservice.service.RestaurantService;
import com.restaurantservice.util.ApiResponse;

/**
 * @author Rajiv Adhav
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired 
	ModelMapper modelMapper;
	
	@Override
	public ResponseEntity<Map<String, Object>> getAllRestaurants() {
		Map<String, Object> map = new HashMap<>();
		map.put("data", restaurantRepository.findAll());
		map.put("status", HttpStatus.FOUND);
		return ResponseEntity.ok(map);
	}

	@Override
	public List<Restaurant> getRestaurantUserById(int id) {
		return restaurantRepository.getById(id);
	}

	@Override
	public ResponseEntity<?> saveRestaurant(RestaurantDto restaurantDto) {
		Map<String, Object> map = new HashMap<>();
		Restaurant restaurant = modelMapper.map(restaurantDto, Restaurant.class);
		map.put("Data", restaurantRepository.save(restaurant));
		map.put("Status", HttpStatus.OK);
		return ResponseEntity.ok(map);
	}

	@Override
	public ResponseEntity<?> deleteRestaurant(Integer id) {
		restaurantRepository.deleteById(id);
		return ResponseEntity.ok(new ApiResponse(id, HttpStatus.OK ,"Record deleted successfully"));
	}
	
}
