package com.telstra.codechallenge.assignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="Exception Occured")
public class RepositoryException extends RuntimeException {
	public RepositoryException(String s) {
		super(s);
	}
}
