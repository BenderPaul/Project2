package com.web.model;

/**
 * 
 * @author Andrew Pearse Post model
 */
public class Post {

	private int postId;
	private String author;
	private String title;
	private String body;

	/**
	 * Creates a new post
	 * @param postId unique ID of the post
	 * @param author username of the author of the post
	 * @param title main header of the post
	 * @param body body of the post
	 */
	public Post(int postId, String owner, String title, String body) {
		super();
		this.postId = postId;
		this.author = owner;
		this.title = title;
		this.body = body;
	}

	public Post() {
		super();
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String owner) {
		this.author = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", owner=" + author + ", title=" + title + ", body=" + body + "]";
	}

}
