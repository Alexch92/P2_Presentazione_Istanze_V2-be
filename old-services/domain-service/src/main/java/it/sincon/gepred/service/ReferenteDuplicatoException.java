package it.sincon.gepred.service;

public class ReferenteDuplicatoException extends RuntimeException {

	private static final long serialVersionUID = 8373847486417252636L;

	public ReferenteDuplicatoException() {
		super();
	}

	public ReferenteDuplicatoException(String message, Throwable e) {
		super(message, e);
	}

	public ReferenteDuplicatoException(String message) {
		super(message);
	}

}
