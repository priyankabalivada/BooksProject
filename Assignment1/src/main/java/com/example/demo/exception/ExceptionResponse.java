package com.example.demo.exception;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;
 
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "error")
public class ExceptionResponse {
	  private int status;
	  private String message;
	  private String path;
	  private long timestamp;
	public ExceptionResponse(int status, String message, String path, long timestamp) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
		this.timestamp=timestamp;
		
	}
	 public ExceptionResponse() {
	    }

	    

	    public ExceptionResponse(String message, String code) {
	        this();
	    }
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	

	
	
	}
	
	 
	