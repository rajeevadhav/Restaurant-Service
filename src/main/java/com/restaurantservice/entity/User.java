/**
 * 
 */
package com.restaurantservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Rajiv Adhav
 *
 */
@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;
	private String lastName;
	private String email;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id", referencedColumnName = "id")
	private Restaurant restaurantDetails;
}
