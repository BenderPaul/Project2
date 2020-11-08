package com.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//TODO: Optional model, may not use

/**
 * @author Andrew Pearse Comment Model
 */

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private int postId;
	private String author;
	private String comment;

	/**
	 * Creates a new comment
	 * @param commentId unique identifier for each comment
	 * @param postId post that the comment is being made on
	 * @param author writer of the comment
	 * @param comment body of the comment
	 */
	public Comment(int commentId, int postId, String author, String comment) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.author = author;
		this.comment = comment;
	}

	public Comment() {
		super();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", postId=" + postId + ", author=" + author + ", comment=" + comment
				+ "]";
	}

}
