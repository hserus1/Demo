package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Post;

public interface PostService {

	public ResponseEntity<Post> getPosts(int postId);
	public ResponseEntity<Post[]> getAllPosts();
}
