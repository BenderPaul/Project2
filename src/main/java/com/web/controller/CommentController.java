package com.web.controller;

import java.util.List;

import com.web.model.Comment;
import com.web.service.CommentService;

public class CommentController {

	private CommentService cs;

	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
	/**
	 * finds all comments by post ID
	 * @return list of comments related to specified post ID
	 */
	public List<Comment> findAllByPost(int pid) {
		return cs.findAllByPost(pid);
	}
	
	/**
	 * finds comment by its ID
	 * @param id unique identifier for comment
	 * @return
	 */
	public Comment findById(int id) {
		return cs.findById(id);
	}
	
	/**
	 * updates comment information
	 * @param comment Comment object with updated information
	 * @return updated comment if successful, null if not
	 */
	public Comment updateComment(Comment comment) {
		return cs.updateComment(comment);
	}
	
	/**
	 * creates a comment
	 * @param comment Comment object with created information
	 * @return created comment if successful, null if not
	 */
	public Comment createComment(Comment comment) {
		return cs.createComment(comment);
	}
	
	/**
	 * deletes a comment from the DB
	 * @param id unique identifier for the comment
	 * @return deleted comment if exists, null if it does not
	 */
	public Comment deleteComment(int id) {
		return cs.deleteComment(id);
	}
	
}
