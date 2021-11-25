package com.example.demo.exception;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice 
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 ExceptionResponse exceptionResponse  = 
				 new ExceptionResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage(), request.getDescription(false),new Date().getTime());
	return new ResponseEntity<>(exceptionResponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex1,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse ex11 = new ExceptionResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), ex1.getMessage(), request.getDescription(false),new Date().getTime());
		return new ResponseEntity<>(ex11, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

	}


	@ExceptionHandler({ HttpMessageConversionException.class, MethodArgumentTypeMismatchException.class })
	public final ResponseEntity<Object> handleInvalidRequestDataException(Exception ex, WebRequest request) {
		ExceptionResponse e= new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),request.getDescription(false),new Date().getTime());
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);

	}

@ExceptionHandler({ RecordNotFoundException.class, BaseException.class })
public final ResponseEntity<Object> handleExceptionsBaseException(BaseException ex,WebRequest request) {
	
	ExceptionResponse e= new ExceptionResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false),new Date().getTime());
	return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
}

@ExceptionHandler(Exception.class)
protected ResponseEntity<?> globalExceptionHandling(Exception ex, WebRequest request){
	 ExceptionResponse exceptionResponse  = 
			 new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false),new Date().getTime());
return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	

}


}