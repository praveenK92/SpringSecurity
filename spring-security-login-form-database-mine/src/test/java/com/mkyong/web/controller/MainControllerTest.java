package com.mkyong.web.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mkyong.config.AppConfig;
import com.mkyong.config.HibernateConfiguration;
import com.mkyong.config.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={HibernateConfiguration.class,SecurityConfig.class,AppConfig.class})
public class MainControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	@BeforeClass
	public void setup(){
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testTest() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testTest2() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testLogin() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDefaultPage() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testAdminPage() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDbaPage() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testLoginStringString() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testAccesssDenied() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
