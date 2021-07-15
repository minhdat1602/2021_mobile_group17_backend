package com.nlu.exceptions;

import org.springframework.http.HttpStatus;

import com.nlu.common.exception.BaseRuntimeException;

public class ResoureNotFoundException extends BaseRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResoureNotFoundException(Long id) {
		super("Resoure with " + id + " not found", HttpStatus.BAD_REQUEST);
	}

	public ResoureNotFoundException(String data) {
		super(data + " not found", HttpStatus.BAD_REQUEST);
	}

}
