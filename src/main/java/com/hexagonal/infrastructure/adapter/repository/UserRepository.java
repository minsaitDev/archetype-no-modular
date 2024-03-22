package com.hexagonal.infrastructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.infrastructure.adapter.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}