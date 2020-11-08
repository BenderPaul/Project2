package com.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.web.dao.UserDao;
import com.web.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	private UserDao udMock;
	@InjectMocks
	private UserService us;
	private User user;
	
	@Before
	public void init() {
		us = new UserService();
		us.setUd(udMock);
		user = new User(1, "some username", "some pass", "some email", "some first", "some last", "some num",
				"some occupation", "some bio", "some address", LocalDate.now(), null);
	}
	
	@Test
	public void testAddUser() {
		when(udMock.save(user)).thenReturn(user);
		assertEquals(user.toString(), us.addUser(user).toString());
	}
	
	@Test
	public void testFindAll() {
		List<User> users = new ArrayList<>();
		users.add(user);
		when(udMock.findAll()).thenReturn(users);
		assertEquals(users.get(0).toString(), us.findAll().get(0).toString());
	}
	
	@Test
	public void testFindUserByUsername() {
		when(udMock.findById(user.getUsername())).thenReturn(user);
		assertEquals(user.toString(), us.findById(user.getUsername()).toString());
	}
	
	@Test
	public void testUpdateUser() {
		when(udMock.update(user)).thenReturn(user);
		assertEquals(user.toString(), us.updateUserInformation(user).toString());
	}
	
	@Test
	public void testDeleteUser() {
		when(udMock.delete(user.getUsername())).thenReturn(user);
		assertNotNull(us.deleteUser(user.getUsername()));
	}
	
}
