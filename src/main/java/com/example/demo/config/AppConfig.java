package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate(getClientHttpRequestFactory());
	}
	
	
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
		
		SimpleClientHttpRequestFactory factory = 
				new SimpleClientHttpRequestFactory();
		
		factory.setConnectTimeout(10);
		factory.setReadTimeout(10);
		return factory;
		
	}
}
