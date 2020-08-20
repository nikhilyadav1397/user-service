package com.nikhil.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.userservice.service.UserService;
import com.nikhil.userservice.shared.UserRequestModel;
import com.nikhil.userservice.shared.UserResponseModel;

@RestController
@RequestMapping("/api")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel){
		return new ResponseEntity<UserResponseModel>(userService.createNewUser(userRequestModel), HttpStatus.CREATED);
	}
}
