package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.User;


@Repository
@Transactional
public class UserDao implements DaoContract<User, String> {

	private SessionFactory sessfact;
	
	
	
//	@Autowired
//	public UserDao(SessionFactory sessfact) {
//		this.sessfact = sessfact;
//	}
//
	public UserDao() {
	}

	@Autowired
	public void setSessfact(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	/**
	 * @returns a list of all users in the DB
	 */
	@Override
	public List<User> findAll() {
		return sessfact.openSession().createQuery("from User", User.class).list();
	}

	/**
	 * @param an integer correlating to the user id
	 * @return user associated with the id
	 */
	@Override
	public User findById(String i) {
		return sessfact.openSession().get(User.class, i);
	}

	/**
	 * @param user for which to delete
	 * @return the user that was deleted
	 */
	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param user to be added to the DB
	 * @return the deleted user
	 */
	@Override
	public User save(User t) {	
		sessfact.openSession().save(t);
		return t;
	}

	/**
	 * @param id of the user to be deleted
	 * @return the deleted user 
	 */
	@Override
	public User delete(String i) {
		// TODO Auto-generated method stub
		return null;
	}
}