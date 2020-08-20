package com.nikhil.userservice.service;

import com.nikhil.userservice.shared.UserRequestModel;
import com.nikhil.userservice.shared.UserResponseModel;

public interface UserService {
	public UserResponseModel createNewUser(UserRequestModel userRequestModel); 
}
