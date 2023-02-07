package it.sincon.gepred.protocollo.scatel;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* PWCallback for the Client
*/
public class PWCallback implements CallbackHandler {
	
	private static Logger log = LoggerFactory.getLogger(CallbackHandler.class);
	public static String pwd;

	/**
	 ** @see javax.security.auth.callback.CallbackHandler#handle
	(javax.security.auth.callback.Callback[])
	 */
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];
				pc.setPassword("XXXXXXXXXX");
				callbacks[i] = new WSPasswordCallback("YYYYYYYYYY",pc.getPassword(),pc.getPasswordType(),pc.getUsage());

				log.debug(pc.getIdentifer());
				pc.setPassword(pwd);
	
			} else {
				throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
			}
		}
	}
}