package com.web.service;

import java.util.List;

import com.web.dao.UserDao;
import com.web.model.User;

public class UserService {

	private UserDao ud;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	/**
	 * Finds all users within the DB
	 * @return list of all users
	 */
	public List<User> findAll(){
		return ud.findAll();
	}
	
	/**
	 * Finds a user by their username
	 * @param username the id of the user
	 * @return User with matching username, null if not
	 */
	public User findById(String username) {
		return ud.findById(username);
	}
	
	/**
	 * Updates user information
	 * @param user new User object to update existing user
	 * @return New user information, or null if no user with the username exists
	 */
	public User updateUserInformation(User user) {
		return ud.update(user);
	}
	
	/**
	 * Deletes user from DB
	 * @param username id of the user
	 * @return the User object that was removed from the DB
	 */
	public User deleteUser(String username) {
		return ud.delete(username);
	}
	
	/**
	 * Adds user to DB
	 * @param user to be added
	 * @return use that was added
	 */
	public User addUser(User user) {
		return ud.save(user);
	}
}
