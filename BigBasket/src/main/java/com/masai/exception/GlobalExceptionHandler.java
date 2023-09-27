package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(InvalidEmailException.class)
	  public ResponseEntity<ErrorDetails> missingData(InvalidEmailException excep, WebRequest wr){
		  ErrorDetails eF = new ErrorDetails(excep.getMessage(),wr.getDescription(false));
	  	return new ResponseEntity<ErrorDetails>(eF,HttpStatus.BAD_REQUEST);
	  }
	  
	  @ExceptionHandler(NotFoundException.class)
	  public ResponseEntity<ErrorDetails> missingData(NotFoundException excep, WebRequest wr){
		  ErrorDetails eF = new ErrorDetails(excep.getMessage(),wr.getDescription(false));
	  	return new ResponseEntity<ErrorDetails>(eF,HttpStatus.NOT_FOUND);
	  }
	  
}
