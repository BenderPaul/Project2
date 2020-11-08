package com.web.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.web.dao.UserDao;
import com.web.model.User;

@Transactional
public class UserDaoTest {
	private UserDao ud;
	private User user;
	private ApplicationContext ac;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("config-test.xml");
		ud = ac.getBean(UserDao.class);
		user = new User(1, "some username", "some pass", "some email", "some first", "some last", "some num",
				"some occupation", "some bio", "some address", LocalDate.now(), null);
		ud.save(user);
	}
	
	@Test
	@Rollback(true)
	public void testAddUser() {
		User u = new User();
		assertNotNull(ud.save(u));
	}
	
	@Test
	public void testFindAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(user);
		assertEquals(users.get(0).toString(), ud.findAll().get(0).toString());
	}
	
//	@Test
//	public void testFindUserByUsername() {
//		assertEquals("some username", ud.findByUsername("some username").getUsername());
//	}
//	
//	@Test
//	@Rollback(true)
//	public void testUpdateUser() {
//		user.setFirstname("changed");
//		assertNotNull(ud.update(user));
//		assertEquals("changed", ud.findByUsername(user.getUsername()).getFirstname());
//	}
//	
	@Test
	@Rollback(true)
	public void testDeleteUserSuccessfully() {
		assertNotNull(ud.delete(user.getUsername()));
	}

	@Test
	public void testDeleteUserUnsuccessfully() {
		User u = new User();
		u.setUsername("this should fail");
		assertNull(ud.delete(u.getUsername()));
	}
	
//	@Test(expected = HibernateException.class)
//	@Rollback(true)
//	public void testDuplicateUserThrowsException() {
//		ud.save(user);
//		ud.save(user);
//	}
	
}
