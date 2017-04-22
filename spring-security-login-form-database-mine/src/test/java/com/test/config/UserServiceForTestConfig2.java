package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mkyong.dao.UserDao;
import com.test.beans.UserDaoForTestImpl;

@Configuration
@ComponentScan({ "com.mkyong.service" })
public class UserServiceForTestConfig2 {
	@Bean
	public UserDao getUserDao(){
		return new UserDaoForTestImpl();
	}
}
