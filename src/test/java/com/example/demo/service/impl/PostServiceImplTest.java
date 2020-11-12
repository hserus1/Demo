package com.example.demo.service.impl;

import static org.mockito.Mockito.mockitoSession;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;

public class PostServiceImplTest {
	
	@InjectMocks
	private RestTemplate restTemplate;
	
	private PostService postService;
	
	
	@BeforeEach
	public void setUp() {
		postService = new PostServiceImpl();
		MockitoAnnotations.initMocks(PostServiceImplTest.class);
		
		//ReflectionUtils.setField(new Field, postService, restTemplate);
	}
	
	@Test
	public void test_getPostsById() {
		
		Post p = new Post();
		p.setId(1);
		p.setUserId(1);
		p.setTitle("Title1");
		p.setBody("Body1");
		
		Mockito.when(restTemplate.getForEntity(Mockito.any(), 
					Post.class))
		        .thenReturn(new ResponseEntity<Post>(p, HttpStatus.OK));
		
		ResponseEntity<Post> responseEntity = postService.getPosts(10);
		
		if (responseEntity.getBody().getId() == p.getId()) {
			System.out.println("Ids are equal");
		}
		
		
	}
	

}
