package com.spring.core.exception;

/**
 * Datastore Exception
 * @author gonchar
 * 
 */
public class DatastoreException extends Exception {

	private static final long serialVersionUID = 961027303407705568L;

	public DatastoreException() {
		super();
	}

	public DatastoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatastoreException(String message) {
		super(message);
	}

	public DatastoreException(Throwable cause) {
		super(cause);
	}

}
