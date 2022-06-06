package com.qa.project2.exceptions;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MusicNotFoundExceptionWithID extends EntityNotFoundException {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 5657808822232471735L;

		public MusicNotFoundExceptionWithID(long id) {
			super("User does not exist with ID: " + id);
		}
	}

