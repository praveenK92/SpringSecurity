package com.mkyong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.UserDao;
import com.mkyong.models.UserModel;

@Service
@Transactional
public class UserService{
	@Autowired
	private UserDao userDao;
	
	public List<UserModel> getAllUser(){
		return userDao.getAllUser();
	}
	public UserModel getUserModel(String username){
		return userDao.getUserModel(username);
	}
}
