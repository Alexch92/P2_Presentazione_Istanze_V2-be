package it.sincon.gepred.web.portlet.varie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

	private Pattern pattern;
	private Matcher matcher;
 
	private static final String PATTERN = "^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$";
 
	public EmailValidation() {
		pattern = Pattern.compile(PATTERN);
	}
 
	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {
 
		matcher = pattern.matcher(hex);
		return matcher.matches();
 
	}
}
