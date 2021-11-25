package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.hamcrest.Matcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.schema.Book;




public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

	Book findById(long id);

//	Object save(Matcher<Book> any);

	

	

	//public Book getById(Long Id);

	//public Book post(Book book);
		
	
 
}
