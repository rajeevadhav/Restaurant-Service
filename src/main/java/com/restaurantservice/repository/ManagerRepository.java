/**
 * 
 */
package com.restaurantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantservice.entity.Manager;

/**
 * @author Rajiv Adhav
 *
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
