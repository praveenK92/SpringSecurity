package com.mkyong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.models.UserModel;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<UserModel> getAllUser(){
		Session session=sessionFactory.getCurrentSession();
		List<UserModel> userList=session.createCriteria(UserModel.class).list();
		return userList;
	}
	public UserModel getUserModel(String username){
		Session session=sessionFactory.getCurrentSession();
		return session.get(UserModel.class, username);
	}
}
