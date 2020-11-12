package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;
import com.example.demo.exception.InvalidParameterException;
import com.example.demo.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/post/{postId}")
	public ResponseEntity<Post> getPosts(@PathVariable String postId) throws InvalidParameterException {
		
		int postIdNum;
		try {
			postIdNum = Integer.parseInt(postId);
		} catch(NumberFormatException exception) {
			throw new InvalidParameterException("Post Id cannot be String : " + postId);
		}
		
		if (postIdNum <=0) {
			throw new InvalidParameterException("Invalid Post Id : " + postId);
		}
		return postService.getPosts(postIdNum);
	}
	
	@GetMapping(value="/posts")
	public ResponseEntity<Post[]> getAllPosts() {
		return postService.getAllPosts();
	}
	

}
