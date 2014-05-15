package com.spring.core.exception;

/**
 * Create Exception
 * @author gonchar
 * 
 */
public class CreateException extends Exception {

	private static final long serialVersionUID = 244172858421106329L;

	public CreateException() {
		super();
	}

	public CreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateException(String message) {
		super(message);
	}

	public CreateException(Throwable cause) {
		super(cause);
	}

}
