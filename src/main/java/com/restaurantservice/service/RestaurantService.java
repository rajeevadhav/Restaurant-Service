/**
 * 
 */
package com.restaurantservice.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restaurantservice.dto.RestaurantDto;
import com.restaurantservice.entity.Restaurant;

/**
 * @author Rajiv Adhav
 *
 */
@Service
public interface RestaurantService {

	ResponseEntity<Map<String, Object>> getAllRestaurants();

	List<Restaurant> getRestaurantUserById(int id);

	ResponseEntity<?> saveRestaurant(RestaurantDto restaurantDto);

	ResponseEntity<?> deleteRestaurant(Integer id);
}
