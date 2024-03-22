package com.hexagonal.infrastructure.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hexagonal.infrastructure.adapter.entity.UserMongoEntity;

public interface UserMongoRepository extends MongoRepository<UserMongoEntity, String> {

}
