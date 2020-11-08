package com.web.service;

import java.util.List;
import java.util.stream.Collectors;

import com.web.dao.PostDao;
import com.web.model.Post;

public class PostService {

	private PostDao pd;

	public void setPd(PostDao pd) {
		this.pd = pd;
	}
	
	/**
	 * finds all posts
	 * @return a list of all posts
	 */
	public List<Post> findAll(){
		return pd.findAll();
	}
	
	/**
	 * finds a post by it's id
	 * @param id unique ID of the post
	 * @return post with matching ID, null if no matching ID found
	 */
	public Post findById(int id) {
		return pd.findById(id);
	}
	
	/**
	 * edits the information of a post
	 * @param post new Post object with updated information
	 * @return updated Post if successful, null if not
	 */
	public Post editPost(Post post) {
		return pd.update(post);
	}
	
	/**
	 * creates a new Post
	 * @param post new Post Object to be stored in the DB
	 * @return created post if successful, null if not
	 */
	public Post createPost(Post post) {
		return pd.save(post);
	}
	
	/**
	 * deletes post with specified ID
	 * @param id unique identifier for the post
	 * @return deleted post if successful, null if not
	 */
	public Post deletePost(int id) {
		return pd.delete(id);
	}
	
	/**
	 * finds all posts by specified user
	 * @param username unique identifier for user
	 * @return list of posts by user
	 */
	public List<Post> findAllByUser(String username) {
		return pd.findAll().stream()
				.filter(p -> p.getAuthor().equals(username))
				.collect(Collectors.toList());
	}
}
