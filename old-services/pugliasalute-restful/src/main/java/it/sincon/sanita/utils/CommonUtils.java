package it.sincon.sanita.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import flexjson.JSONDeserializer;

public class CommonUtils {
	private static Logger log = LoggerFactory.getLogger( CommonUtils.class );
	
	/**
	 * Utility per analizzare un json contenente un array di stringe e restituirlo come Lista  
	 * @param json
	 * @return
	 */
	public static List<String> parseJson(String json) {
		List<String> response = null;
		// Se mi viene valorizzato jsonCategorie estraggo le DDMStructure corrispondenti,
		// altrimenti prelevo quelle da configurazione.
		if (json!=null && !json.isEmpty()){
			try{
				JSONDeserializer<List<String>> deserializer = new JSONDeserializer<List<String>>();
				response = deserializer.deserialize(json, List.class);
			}
			catch (Exception exp){
				log.error(exp.getMessage(), exp);
				response = null;
			}
		}
		return response;
	}

}
