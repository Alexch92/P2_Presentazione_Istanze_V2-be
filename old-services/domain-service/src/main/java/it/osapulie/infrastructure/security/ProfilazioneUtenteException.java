package it.osapulie.infrastructure.security;

public class ProfilazioneUtenteException extends Exception {

	private static final long serialVersionUID = -250172582872244693L;

	public ProfilazioneUtenteException() {
		super();
	}

	public ProfilazioneUtenteException(String msg) {
		super(msg);
	}

	public ProfilazioneUtenteException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ProfilazioneUtenteException(Throwable cause) {
		super(cause);
	}
}
