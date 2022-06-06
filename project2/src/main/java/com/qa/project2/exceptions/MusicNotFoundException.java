package com.qa.project2.exceptions;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User does not exist with that ID")
public class MusicNotFoundException extends NoSuchElementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4546292972893400794L;
	
	
}
