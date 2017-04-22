/**
 * 
 */
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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mkyong.config.AppConfig;
import com.mkyong.config.HibernateConfiguration;
import com.mkyong.config.SecurityConfig;
import com.mkyong.models.UserModel;
import com.test.config.UserServiceForTestConfig2;

/**
 * @author Praveen
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes={HibernateConfiguration.class,SecurityConfig.class,AppConfig.class})
//@ContextConfiguration(classes={HibernateConfiguration.class,AppConfig.class})
//@ContextConfiguration(classes={HibernateConfiguration.class})
@ContextConfiguration(classes={UserServiceForTestConfig2.class})
public class UserServiceTest {

	/**
	 * Test method for {@link com.mkyong.service.UserServiceImpl#getAllUser()}.
	 */
	@Autowired
	private UserService userService;
	
	private UserDetailService userDetailService;
	@Autowired
	public void setUserDetailService() {
		this.userDetailService = new UserDetailService(this.userService);
	}
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	 
    @Before
    public void setUp() { 
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	@Test
	public final void testGetAllUser() {
		List<UserModel> ul=userService.getAllUser();
		assertEquals(ul.size(),2);
	}

	/**
	 * Test method for {@link com.mkyong.service.UserServiceImpl#getUserModel(java.lang.String)}.
	 */
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
