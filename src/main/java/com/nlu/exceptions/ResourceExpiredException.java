package com.nlu.exceptions;

import org.springframework.http.HttpStatus;

import com.nlu.common.exception.BaseRuntimeException;

public class ResourceExpiredException extends BaseRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceExpiredException(String data) {
		super(data + "Quá hạn !", HttpStatus.BAD_REQUEST);
	}

}
