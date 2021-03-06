package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.Post;


@Repository
@Transactional
public class PostDao implements DaoContract<Post, Integer>{

	
private SessionFactory sessfact;
	
	@Autowired
	private UserDao ud;

	@Autowired
	public PostDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public PostDao() {
	}
	
	/**
	 * @returns a list of all posts in the DB
	 */
	@Override
	public List<Post> findAll() {
		return sessfact.openSession().createQuery("from Post", Post.class).list();
	}

	/**
	 * @param an integer correlating to the post id
	 * @return post associated with the id
	 */
	@Override
	public Post findById(Integer i) {
		return sessfact.openSession().get(Post.class, i);
	}

	/**
	 * @param post for which to delete
	 * @return the post that was deleted
	 */
	@Override
	public Post update(Post t) {
		sessfact.getCurrentSession().update(t);
		return t;
	}

	/**
	 * @param post to be added to the DB
	 * @return the deleted post
	 */
	@Override
	public Post save(Post t) {
		t.setAuthor(ud.findById(t.getAuthor().getUsername()));
		sessfact.openSession().save(t);
		return t;
	}

	/**
	 * @param id of the post to be deleted
	 * @return the deleted post 
	 */
	@Override
	public Post delete(Post t) {
		sessfact.openSession().delete(t);
		return t;
	}
	
	public List<Post> findAllByUser(String username){
		return sessfact.openSession().createQuery("from Post where fk_user = " + ud.findById(username).getUserId(), Post.class).list();
	}

}
