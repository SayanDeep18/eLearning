package com.capg.eLearning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NoStudentFound.class)
	public ResponseEntity<String> handleStudentNotFoundException(NoStudentFound e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(NoAdminFound.class)
	public ResponseEntity<String> handleAdminNotFoundException(NoAdminFound e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(NoFacultyFound.class)
	public ResponseEntity<String> handleFacultyNotFoundException(NoFacultyFound e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	@ExceptionHandler(NoCourseFound.class)
	public ResponseEntity<String> handleCourseNotFoundException(NoCourseFound e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
