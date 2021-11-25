package com.example.demo.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.BookRepository;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.ExceptionResponse;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.schema.Book;
import com.example.demo.service.ServiceImp;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepository r;
    @Autowired
    ServiceImp s;
	
	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Book> booksPageable(Pageable pageable) {
		return r.findAll(pageable);

	}

	@PostMapping("/books")
	public ResponseEntity<Book>createBook(@RequestBody Book Book)
	  {

		
			return new ResponseEntity<Book>(s.post(Book), HttpStatus.CREATED);
		
	} 

	@GetMapping("/books/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long id) throws BaseException {
	  //Optional<Book> d = Optional.ofNullable(s.getById(id));    
		try {
		//if (!d.isPresent()){
			//return s.getById(id);
			return new ResponseEntity<>(s.getById(id), HttpStatus.OK);
			
			} catch(Exception exception) { 
				 
				throw new RecordNotFoundException("hoo"); }

		 
		// }else 
			// throw new RecordNotFoundException("hoo");
		
	}
	//if (!d.isPresent()){
	      //   throw new RecordNotFoundException("Invalid  id : " + id);
	    //}
			//return new ResponseEntity<>(d.get(), HttpStatus.OK);
			
		//}
		//else {
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			//return new ResponseEntity<>(d.get(), HttpStatus.OK);


	@DeleteMapping("/books/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id) {
		try {
			s.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 @GetMapping("/books")
	   public List<Book> getAllBooks(){
	      return s.getAllBooks();
	   }
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBooks(@PathVariable("id") long id, @RequestBody Book Books) {
	//	Optional<Book> BooksData = s.update(id);
     
	//	if (BooksData.isPresent()) {
		try {
			Book _Books = s.update(id).get();
			_Books.setTitle(Books.getTitle());
			_Books.setDescription(Books.getDescription());
			_Books.setPublished(Books.isPublished());
			return new ResponseEntity<>(r.save(_Books), HttpStatus.OK);}
		//} else {
		catch(Exception ex) {
			ExceptionResponse e= new ExceptionResponse(404,"Not found the id ","/book/"+id, id);
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/books")
	public ResponseEntity<HttpStatus> deleteAllBooks() {
		try {
			s.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	

}