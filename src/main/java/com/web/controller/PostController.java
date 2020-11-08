package com.web.controller;

import java.util.List;

import com.web.model.Post;
import com.web.service.PostService;

public class PostController {

	private PostService ps;

	public void setPs(PostService ps) {
		this.ps = ps;
	}
	
	/**
	 * finds all posts
	 * @return a list of all posts
	 */
	public List<Post> findAll(){
		return ps.findAll();
	}
	
	/**
	 * finds a post by it's id
	 * @param id unique ID of the post
	 * @return post with matching ID, null if no matching ID found
	 */
	public Post findById(int id) {
		return ps.findById(id);
	}
	
	/**
	 * edits the information of a post
	 * @param post new Post object with updated information
	 * @return updated Post if successful, null if not
	 */
	public Post editPost(Post post) {
		return ps.editPost(post);
	}
	
	/**
	 * creates a new Post
	 * @param post new Post Object to be stored in the DB
	 * @return created post if successful, null if not
	 */
	public Post createPost(Post post) {
		return ps.createPost(post);
	}
	
	/**
	 * deletes post with specified ID
	 * @param id unique identifier for the post
	 * @return deleted post if successful, null if not
	 */
	public Post deletePost(int id) {
		return ps.deletePost(id);
	}
	
	/**
	 * finds all posts by specified user
	 * @param username unique identifier for user
	 * @return list of posts by user
	 */
	public List<Post> findAllByUser(String username) {
		return ps.findAllByUser(username);
	}
}
