package com.mkyong.dao;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.mkyong.config.HibernateConfiguration;
import com.mkyong.models.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={HibernateConfiguration.class})
//@Sql("/sql/userInfo.sql")
@Transactional
public class UserDaoTest{
	@Autowired
	private UserDao userDao;
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	 
    @Before
    public void setUp() { 
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

	@Test
	@Sql("/sql/userInfo.sql")
	//@Rollback
	public void testGetAllUser() throws Exception{
		List<UserModel> ul=userDao.getAllUser();
		assertTrue(ul.size()>=3);
	}

	@Test
	@Sql("/sql/userInfo.sql")
	@Rollback
	public void testGetUserModel() throws Exception {
		UserModel um=userDao.getUserModel("sasuke1");
		assertNotNull(um);
	}

}
