package com.hexagonal.infrastructure.adapter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hexagonal.infrastructure.adapter.entity.AudioEntity;

public interface AudioRepository extends MongoRepository<AudioEntity, String> {

}
