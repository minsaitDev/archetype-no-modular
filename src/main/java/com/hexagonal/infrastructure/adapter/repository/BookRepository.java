package com.hexagonal.infrastructure.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.infrastructure.adapter.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {

}
