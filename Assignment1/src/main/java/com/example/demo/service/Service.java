package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.schema.Book;

public interface Service {

	 public Book post(Book b);
	 public Book getById(Long id);
	 public void delete(Long id);
	 public void deleteAll();
     public Optional<Book> update(Long id);
	List<Book> getAllBooks();
}
