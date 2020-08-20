package com.nikhil.userservice.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nikhil.userservice.dao.UserDao;
import com.nikhil.userservice.model.User;
import com.nikhil.userservice.shared.UserRequestModel;
import com.nikhil.userservice.shared.UserResponseModel;

@Component
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public UserResponseModel createNewUser(UserRequestModel userRequestModel) {
		String str = UUID.randomUUID().toString();
		String str1[] = str.split("-");
		userRequestModel.setUserId(str1[0]);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = userDao.save(mapper.map(userRequestModel, User.class));
		return mapper.map(user, UserResponseModel.class);
	}
	
}
