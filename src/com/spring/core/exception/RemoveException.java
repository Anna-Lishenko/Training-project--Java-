package com.spring.core.exception;

/**
 * Remove Exception
 * @author gonchar
 * 
 */
public class RemoveException extends Exception {

	private static final long serialVersionUID = -8503922892125499217L;

	public RemoveException() {
		super();
	}

	public RemoveException(String message, Throwable cause) {
		super(message, cause);
	}

	public RemoveException(String message) {
		super(message);
	}

	public RemoveException(Throwable cause) {
		super(cause);
	}

}
