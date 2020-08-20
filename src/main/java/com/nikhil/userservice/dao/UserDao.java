package com.nikhil.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.userservice.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
