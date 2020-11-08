package com.web.controller;

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

import com.web.model.Post;
import com.web.service.PostService;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {
	@Mock
	private PostService psMock;
	@InjectMocks
	private PostController pc;
	private Post post;
	
	@Before
	public void init() {
		pc = new PostController();
		pc.setPs(psMock);
		post = new Post(1, "some username", "Testing Post", "This post is all about testing.");
	}
	
	@Test
	public void testAddPost() {
		when(psMock.createPost(post)).thenReturn(post);
		assertEquals(post.toString(), pc.createPost(post).toString());
	}
	
	@Test
	public void testFindAll() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		when(psMock.findAll()).thenReturn(posts);
		assertEquals(posts.get(0).toString(), pc.findAll().get(0).toString());
	}
	
	@Test
	public void testFindAllByAuthor() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		when(psMock.findAll()).thenReturn(posts);
		assertEquals(posts.get(0).toString(), pc.findAll().get(0).toString());
	}
	
	@Test
	public void testFindById() {
		when(psMock.findById(post.getPostId())).thenReturn(post);
		assertEquals(post.toString(), pc.findById(post.getPostId()).toString());
	}
	
	@Test
	public void testUpdatePost() {
		when(psMock.editPost(post)).thenReturn(post);
		assertEquals(post.toString(), pc.editPost(post).toString());
	}
	
	@Test
	public void testDeletePost() {
		when(psMock.deletePost(post.getPostId())).thenReturn(post);
		assertNotNull(pc.deletePost(post.getPostId()));
	}
}
