package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<Post> getPosts(int postId) {
		
		String url = "https://jsonplaceholder.typicode.com/posts/" +postId;	
		ResponseEntity<Post> responseEntity = restTemplate.getForEntity(url, Post.class);
		return responseEntity;
	
	}

	@Override
	public ResponseEntity<Post[]> getAllPosts() {
		
		 String url = "https://jsonplaceholder.typicode.com/posts";	
		 ResponseEntity<Post[]> posts = restTemplate.getForEntity(url, Post[].class);
		 return posts;
	}

}
