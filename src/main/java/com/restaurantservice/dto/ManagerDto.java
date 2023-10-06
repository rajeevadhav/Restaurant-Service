package com.restaurantservice.dto;

import lombok.Data;

@Data
public class ManagerDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer restaurantId;
}
