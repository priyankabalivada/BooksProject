package com.example.demo.schema;


import java.util.Objects;

import javax.persistence.*;

import com.example.demo.exception.RecordNotFoundException;

@Entity
@Table(name = "User")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;

	

	public Book(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String string, String string2, boolean b, long l) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.description = description;
		this.published = published;
		this.id=id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	}

	
	


	

	    
}
