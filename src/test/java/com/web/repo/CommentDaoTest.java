package com.web.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import com.web.dao.CommentDao;
import com.web.model.Comment;

@Transactional
public class CommentDaoTest {
	private CommentDao cd;
	private Comment comment;
	private ApplicationContext ac;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("config-test.xml");
		cd = ac.getBean(CommentDao.class);
		comment = new Comment(1, 1, "some username", "Testing comment.");
		cd.save(comment);
	}
	
	@Test
	@Rollback(true)
	public void testAddComment() {
		Comment c = new Comment();
		assertNotNull(cd.save(c));
	}
	
	@Test
	public void testFindAll() {
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		assertEquals(comments.get(0).toString(), cd.findAll().get(0).toString());
	}
	
	@Test
	public void testFindById() {
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		assertEquals(comment.toString(), cd.findById(comment.getCommentId()).toString());
	}
	
	@Test
	@Rollback(true)
	public void testUpdateComment() {
		comment.setComment("changed");
		assertNotNull(cd.update(comment));
		assertEquals("changed", cd.findById(comment.getCommentId()).getComment());
	}
	
	@Test
	@Rollback(true)
	public void testDeleteCommentSuccessfully() {
		assertNotNull(cd.delete(comment.getCommentId()));
	}

	@Test
	public void testDeleteCommentUnsuccessfully() {
		Comment c = new Comment();
		c.setCommentId(2);
		assertNull(cd.delete(comment.getCommentId()));
	}
	
<<<<<<< Updated upstream
	@Test
	@Rollback(true)
	public void testDuplicateCommentThrowsException() {
		cd.save(comment);
		cd.save(comment);
	}
=======
//	@Test(expected = HibernateException.class)
//	@Rollback(true)
//	public void testDuplicateCommentThrowsException() {
//		cd.save(comment);
//		cd.save(comment);
//	}
>>>>>>> Stashed changes
	

}
