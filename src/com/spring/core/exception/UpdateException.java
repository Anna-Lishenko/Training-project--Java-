package com.spring.core.exception;

/**
 * Update Exception
 * @author gonchar
 * 
 */
public class UpdateException extends Exception {

	private static final long serialVersionUID = -1705762536542164024L;

	public UpdateException() {
		super();
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateException(String message) {
		super(message);
	}

	public UpdateException(Throwable cause) {
		super(cause);
	}

}
