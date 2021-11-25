package com.example.demo.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends BaseException 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    public RecordNotFoundException(String message) {
    	
        super(new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),message,"/books/",new Date().getTime()));
    }



   

}