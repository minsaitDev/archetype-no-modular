package com.hexagonal.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hexagonal.infrastructure.adapter.entity.TaskMongoEntity;

public interface TaskMongoRepository extends MongoRepository<TaskMongoEntity, String> {
	
	 List<TaskMongoEntity> findByIdIn(List<String> tasksIds);

}
