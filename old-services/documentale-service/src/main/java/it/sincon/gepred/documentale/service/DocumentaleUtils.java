package it.sincon.gepred.documentale.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentaleUtils {
	private static Logger log = LoggerFactory.getLogger(DocumentaleUtils.class);
	
	private static String DIOG_TITOLO_DOC_ILLEGALS_PATTERN = "[^\\x20-\\x7Eàòèéìù€]";
	
	public static boolean containsIllegals(String toExamine, String illegalsPattern) {
		illegalsPattern = DIOG_TITOLO_DOC_ILLEGALS_PATTERN;
		log.info(String.format("containsIllegals(toExamine:%s, illegalsPattern:%s)", toExamine, illegalsPattern));
		Pattern pattern = Pattern.compile(illegalsPattern);
		Matcher matcher = pattern.matcher(toExamine);
		return matcher.find();
	}
	
	public static String getValidTitolo(String toExamine, String illegalsPattern){
		illegalsPattern = DIOG_TITOLO_DOC_ILLEGALS_PATTERN;
		log.info(String.format("getValidTitolo(toExamine:%s, illegalsPattern:%s)", toExamine, illegalsPattern));
		String retValue = toExamine;
		if (illegalsPattern!= null && !illegalsPattern.isEmpty()){
			Pattern pattern = Pattern.compile(illegalsPattern);
			Matcher matcher = pattern.matcher(toExamine);
			retValue = matcher.replaceAll("_");
		}
		
		return retValue;
	}
}
