package com.mkyong.web.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mkyong.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SpringMvcTestLoginControllerTest {

	/*@Configuration
	static class LoginControllerTestConfiguration {

		@Bean
		public UserService accountService() {
			return Mockito.mock(UserService.class);
		}

		@Bean
		public LoginController loginController() {
			return new LoginController();
		}
	}*/

	@Autowired
	private UserServiceImpl accountService;
	
	@Before
	public void setup() throws Exception {
		
	}
}