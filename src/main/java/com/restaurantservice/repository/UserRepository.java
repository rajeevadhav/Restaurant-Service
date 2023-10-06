package com.restaurantservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
