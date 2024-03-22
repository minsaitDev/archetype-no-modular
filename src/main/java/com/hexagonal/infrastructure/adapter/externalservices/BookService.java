package com.hexagonal.infrastructure.adapter.externalservices;

import org.springframework.stereotype.Service;

import com.hexagonal.domain.port.BookPort;
import com.hexagonal.infrastructure.adapter.entity.BookEntity;
import com.hexagonal.infrastructure.adapter.repository.BookRepository;

@Service
public class BookService implements BookPort {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	@Override
	public String saveBook() {
		bookRepository.save(new BookEntity("123456","Libro 1"));
		return "123456";
	}

}
