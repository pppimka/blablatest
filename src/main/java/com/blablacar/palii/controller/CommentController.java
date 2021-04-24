package com.blablacar.palii.controller;

import com.blablacar.palii.controller.request.CreateCommentRequest;
import com.blablacar.palii.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/comment")
@RestController
@AllArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping
	@Transactional
	public ResponseEntity<?> createComment(@RequestParam CreateCommentRequest createCommentRequest) {
		String id = commentService.createComment(createCommentRequest);

		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@DeleteMapping("/{commentId}")
	@Transactional
	public ResponseEntity<?> deleteComment(@PathVariable("commentId") String commentId) {
		commentService.deleteComment(commentId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
