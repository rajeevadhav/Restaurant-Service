/**
 * 
 */
package com.restaurantservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantservice.entity.Restaurant;

/**
 * @author Rajiv Adhav
 *
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

	public List<Restaurant> getById(int id);
}
