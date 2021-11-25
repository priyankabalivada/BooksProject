package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Repository.BookRepository;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.schema.Book;



@Component
public class ServiceImp implements Service {
@Autowired
BookRepository r;
@Autowired
BookRepository b;;

  @Override
  public Book post(Book b)
  {
	  
	  return b=r.save(b);
  }
  @Override
  public Book getById(Long id) 
  {
	 return r.findById(id).get();
  }
  @Override
  public void delete(Long id)
  {
	  r.deleteById(id);
  }
  @Override
  public void deleteAll()
  {
	  r.deleteAll();
  }
  @Override
  public Optional<Book> update(Long id)
  {
		return  r.findById(id);

  }
  
@Override
  public List<Book> getAllBooks(){
      List<Book> b = new ArrayList<Book>();
      r.findAll().forEach(e -> b.add(e));
      return b;
   }
	
}
