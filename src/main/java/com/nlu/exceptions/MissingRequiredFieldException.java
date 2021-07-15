package com.nlu.exceptions;

import org.springframework.http.HttpStatus;

import com.nlu.common.exception.BaseRuntimeException;

public class MissingRequiredFieldException extends BaseRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissingRequiredFieldException(String message) {
		super("Field '" + message + "' is required", HttpStatus.BAD_REQUEST);
	}

}
