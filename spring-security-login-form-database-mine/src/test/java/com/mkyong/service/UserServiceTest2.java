package com.mkyong.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mkyong.dao.UserDao;
import com.mkyong.models.UserModel;
import com.test.config.UserServiceForTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={UserServiceForTestConfig.class})
public class UserServiceTest2 {
	@Autowired
	private UserDao userDao;
	
	private UserService userService;
	private UserDetailService userDetailService;
	/*@Autowired
	public void setUserService(UserDao userDao) {
		this.userService = new UserServiceImpl(userDao);
	}	
	@Autowired
	public void setUserDetailService(UserService userService){
		this.userDetailService = new UserDetailService(this.userService);
	}*/
	@Before
	public void init123(){
		this.userService = new UserServiceImpl(this.userDao);
		this.userDetailService = new UserDetailService(this.userService);
	}
	
	@Test
	public final void testGetAllUser() {
		List<UserModel> ul=userService.getAllUser();
		assertEquals(ul.size(),2);
	}

	
	@Test
	public final void testGetUserModel() {
		UserModel sasuke=userService.getUserModel("sasuke");
		assertEquals("sasuke",sasuke.getUsername());
	}
	
	@Test
	public final void testloadUserByUsername() {
		UserDetails userDetails=userDetailService.loadUserByUsername("sasuke");
		assertEquals("sasuke",userDetails.getUsername());
	}
	
}
