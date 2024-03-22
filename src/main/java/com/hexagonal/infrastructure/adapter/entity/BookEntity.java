package com.hexagonal.infrastructure.adapter.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@RedisHash("BookEntity")
public class BookEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;


}
