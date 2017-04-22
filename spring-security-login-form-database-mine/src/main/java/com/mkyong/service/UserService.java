package com.mkyong.service;

import java.util.List;

import com.mkyong.models.UserModel;

public interface UserService {
	public List<UserModel> getAllUser();
	public UserModel getUserModel(String username);
}
