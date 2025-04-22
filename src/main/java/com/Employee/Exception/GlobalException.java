package com.Employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> NameNot (NameNotFoundException ne){
		return new ResponseEntity<Object>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> Idnot (IdNotFoundException ie){
		return new ResponseEntity<Object>(ie.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<Object> indexnot(IndexOutOfBoundsException ine){
		return new ResponseEntity<Object>(ine.getMessage(),HttpStatus.NOT_FOUND);
	}

}
