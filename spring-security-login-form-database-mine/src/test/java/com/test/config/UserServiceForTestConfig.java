package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mkyong.dao.UserDao;
import com.test.beans.UserDaoForTestImpl;

@Configuration
public class UserServiceForTestConfig {
	@Bean
	public UserDao getUserDao(){
		return new UserDaoForTestImpl();
	}
	/*@Bean
	public UserService getUserService(){
		return new UserServiceImpl(getUserDao());
	}*/
}
