package com.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.web.dao.CommentDao;
import com.web.model.Comment;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {
	@Mock
	private CommentDao cdMock;
	@InjectMocks
	private CommentService cs;
	private Comment comment;
	
	@Before
	public void init() {
		cs = new CommentService();
		cs.setCd(cdMock);
		comment = new Comment(1, 1, "some username", "Testing comment.");
	}
	
	@Test
	public void testAddComment() {
		when(cdMock.save(comment)).thenReturn(comment);
		assertEquals(comment.toString(), cs.createComment(comment).toString());
	}
	
//	@Test
//	public void testFindAll() {
//		List<Comment> comments = new ArrayList<>();
//		comments.add(comment);
//		when(cdMock.findAll()).thenReturn(comments);
//		assertEquals(comments.get(0).toString(), cs.findAll().get(0).toString());
//	}
	
	@Test
	public void testFindById() {
		when(cdMock.findById(comment.getCommentId())).thenReturn(comment);
		assertEquals(comment.toString(), cs.findById(comment.getCommentId()).toString());
	}
	
	@Test
	public void testUpdateComment() {
		when(cdMock.update(comment)).thenReturn(comment);
		assertEquals(comment.toString(), cs.updateComment(comment).toString());
	}
	
	@Test
	public void testDeleteComment() {
		when(cdMock.delete(comment.getCommentId())).thenReturn(comment);
		assertNotNull(cs.deleteComment(comment.getCommentId()));
	}
}
