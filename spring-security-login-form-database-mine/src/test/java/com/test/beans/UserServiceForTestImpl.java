package com.test.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mkyong.models.UserModel;
import com.mkyong.models.UserRolesModel;
import com.mkyong.service.UserService;

public class UserServiceForTestImpl implements UserService {
	
	private Map<String, UserModel> map=new HashMap<>();	

	public UserServiceForTestImpl() {
		String user1="Sasuke";
		String user2="Naruto";
		List<UserRolesModel> url=new ArrayList<>();
		UserRolesModel ur1=new UserRolesModel(1,user1,"ROLE_ADMIN");url.add(ur1);
		UserRolesModel ur2=new UserRolesModel(1,user1,"ROLE_DBA");url.add(ur2);
		UserRolesModel ur3=new UserRolesModel(1,user1,"ROLE_USER");url.add(ur3);
		
		UserModel u1=new UserModel(user1,"",true,true,true,true,url);
		UserModel u2=new UserModel(user2,"",true,true,true,true,url);
		map.put(user1, u1);
		map.put(user2, u2);
	}

	@Override
	public List<UserModel> getAllUser(){
		String user1="Sasuke";
		String user2="Naruto";
		
		List<UserModel> ull=new ArrayList<>();
		UserModel u1=map.get(user1);ull.add(u1);
		UserModel u2=map.get(user2);ull.add(u2);
		
		return ull;
	}
	
	@Override
	public UserModel getUserModel(String username) {
		return map.get(username);
	}
}
