package com.restaurantservice.dto;

import lombok.Data;

@Data
public class UserDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Integer restaurantId;
}
