package com.example.demo.testservice;



	

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.Assignment1Application;
import com.example.demo.Controller.BookController;
import com.example.demo.Repository.BookRepository;
import com.example.demo.schema.Book;
import com.google.common.net.HttpHeaders;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

	


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ControllerTests {

	@Autowired
	BookRepository r;
	//@Autowired
	//BookController c;
   
   
  

	     @Test
	    @Order(1)
        public void testCreate () {
        	//Book p = new Book("Hp", "Hello", false);
	    	 Book p = new Book();
        	p.setId(1L);
        	p.setPublished(false);
        	p.setTitle("Harrypotter");
        	p.setDescription("Hello");
        	r.save(p);
    		assertNotNull(r.findById(1L));
    		
	     }
	     @Test
	     public void testRead () {
	     	Book bk = r.findById(1L);
	     	assertEquals("Harrypotter", bk.getTitle());
	     }
    		
//	     @Test
//	     public void testUpdate () {
//	    	Book b=new Book("HarryPotter","good",false,1L);
//	     	Book bk = r.findById(1L).get();
//	     	
//	     	bk.setTitle("Harry");
//	     	r.save(bk);
//	     	assertNotEquals("Harry", r.findById(1L).get().getTitle());
//	     }
    		
	     @Test
	 	
	 	public void testDelete () {
	 		r.deleteById(1L);
	 		assertThat(r.existsById(1L)).isFalse();
	 	}
	     @Test
	     @Rollback(false)
	     public void testUpdate() {
	         Book b = r.findById(1L);
	         b.setTitle("Hp");;
	          
	        r.save(b);
	          
	         Book updated = r.findById(1L);
	          
	         assertThat(updated.getTitle()).isEqualTo("Hp");
	     }
    		
    		
    		
    		
    		
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//	@Autowired
//	Book Book;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//	

//	@Test
//	public void testEmployee() throws Exception {
//		Book b=new Book("Hp","good",false);
//		
//		  when(r.save(any(Book.class))).thenReturn(b);
//		 ResponseEntity<Book> response = c.createBook(b);
//
//	        Assert.assertEquals("Hp",.getTitle());
//
//
//			mockMvc.perform(post("/api/books")
//				.content("{json}")
//				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated());

	}


	
  //      }

       
//}



 

   

