package com.web.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.web.dao.PostDao;
import com.web.model.Post;

@Transactional
public class PostDaoTest {
	private PostDao pd;
	private Post post;
	private ApplicationContext ac;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("config-test.xml");
		pd = ac.getBean(PostDao.class);
		post = new Post(1, "some username", "Testing Post", "This post is all about testing.");
		pd.save(post);
	}
	
	@Test
	@Rollback(true)
	public void testAddPost() {
		Post p = new Post();
		assertNotNull(pd.save(p));
	}
	
	@Test
	public void testFindAll() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		assertEquals(posts.get(0).toString(), pd.findAll().get(0).toString());
	}
	
	@Test
	public void testFindAllByAuthor() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		assertEquals(posts.get(0).toString(), pd.findAll().get(0).toString());
	}

	@Test
	public void testFindById() {
		assertEquals(post.toString(), pd.findById(post.getPostId()).toString());
	}
	
	@Test
	@Rollback(true)
	public void	testUpdatePost() {
		post.setBody("changed");
		assertNotNull(pd.update(post));
		assertEquals("changed", pd.findById(post.getPostId()).getBody());
	}
	
	@Test
	@Rollback(true)
	public void testDeletePostSuccessfully() {
		assertNotNull(pd.delete(post.getPostId()));
	}

	@Test
	public void testDeletePostUnsuccessfully() {
		Post p = new Post();
		assertNull(pd.delete(p.getPostId()));
	}

//	@Test(expected = HibernateException.class)
//	@Rollback(true)
//	public void testDuplicatePostThrowsException() {
//		pd.save(post);
//		pd.save(post);
//	}
	
}
