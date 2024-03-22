package com.hexagonal.infrastructure.configuration;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.hexagonal.infrastructure.adapter.entity.BookEntity;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {
	
	@Bean
	public RedisTemplate<Long, BookEntity> redisTemplate(RedisConnectionFactory connectionFactory) {
	    RedisTemplate<Long, BookEntity> template = new RedisTemplate<>();
	    template.setConnectionFactory(connectionFactory);
	    return template;
	}

}
