/**
 * 
 */
package com.restaurantservice.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Rajiv Adhav
 *
 */
@Entity
@Table(name = "restaurant")
@Data
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String owner;
	private String location;

	@JsonBackReference
	@OneToOne(mappedBy = "restaurantDetails", cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.DETACH)
	private List<Manager> managers;
}
