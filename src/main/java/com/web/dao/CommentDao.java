package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.Comment;

@Repository
@Transactional
public class CommentDao implements DaoContract<Comment, Integer> {

private SessionFactory sessfact;
	
	@Autowired
	public CommentDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public CommentDao() {
	}

	/**
	 * @returns a list of all comments in the DB
	 */
	@Override
	public List<Comment> findAll() {
		return sessfact.openSession().createQuery("from Comment", Comment.class).list();
	}

	/**
	 * @param an integer correlating to the comment id
	 * @return comment associated with the id
	 */
	@Override
	public Comment findById(Integer i) {
		return sessfact.openSession().get(Comment.class, i);
	}
	
	/**
	 * @param Comment for which to delete
	 * @return the comment that was deleted
	 */
	@Override
	public Comment update(Comment t) {
		// TODO Auto-generated method stub
		return t;
	}

	/**
	 * @param Comment to be added to the DB
	 * @return the deleted comment
	 */
	@Override
	public Comment save(Comment t) {
		sessfact.openSession().save(t);
		return t;
	}

	/**
	 * @param id of the comment to be deleted
	 * @return the deleted comment 
	 */
	@Override
	public Comment delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
}
