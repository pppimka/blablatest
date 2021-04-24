package com.blablacar.palii.service;

import com.blablacar.palii.controller.request.CreateCommentRequest;
import com.blablacar.palii.repo.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;

	public String createComment(CreateCommentRequest createCommentRequest) {
		//map create request to new comment
		return "newCommentId";
	}

	public void deleteComment(String commentId) {
		commentRepository.deleteById(commentId);
	}
}
