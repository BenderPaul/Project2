package com.web.controller;

import java.util.List;

import com.web.model.User;
import com.web.service.UserService;

public class UserController {

	private UserService us;

	public void setUs(UserService us) {
		this.us = us;
	}
	
	/**
	 * Finds all users within the DB
	 * @return list of all users
	 */
	public List<User> findAll(){
		return us.findAll();
	}
	
	/**
	 * Finds a user by their username
	 * @param username the id of the user
	 * @return User with matching username, null if not
	 */
	public User findById(String username) {
		return us.findById(username);
	}
	
	/**
	 * Updates user information
	 * @param user new User object to update existing user
	 * @return New user information, or null if no user with the username exists
	 */
	public User updateUserInformation(User user) {
		return us.updateUserInformation(user);
	}
	
	/**
	 * Deletes user from DB
	 * @param username id of the user
	 * @return the User object that was removed from the DB
	 */
	public User deleteUser(String username) {
		return us.deleteUser(username);
	}
	
	/**
	 * Creates new user in DB
	 * @param User to be added
	 * @return the user that was added
	 */
	public User addUser(User user) {
		return us.addUser(user);
	}



}
