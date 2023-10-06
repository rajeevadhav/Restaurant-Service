package com.restaurantservice.util;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

	private T data;
	private HttpStatus status;
	private String message;
	 
}
