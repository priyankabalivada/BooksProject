package com.example.demo.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;

public class BaseException extends RuntimeException{

	 

    private static final long serialVersionUID = 1;

 

    protected final ExceptionResponse errorResponse;

 

    public BaseException(ExceptionResponse errorResponse) {
        super();
        this.errorResponse = errorResponse;
    }

 

    public BaseException(ExceptionResponse errorResponse, Throwable cause) {
        super();
        this.errorResponse = errorResponse;
    }

 

    public ExceptionResponse geterrorResponse() {
        return this.errorResponse;
    }



    
    
}
