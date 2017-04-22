package com.mkyong.dao;

import java.util.List;

import com.mkyong.models.UserModel;

public interface UserDao {
	public List<UserModel> getAllUser();
	public UserModel getUserModel(String username);
}
