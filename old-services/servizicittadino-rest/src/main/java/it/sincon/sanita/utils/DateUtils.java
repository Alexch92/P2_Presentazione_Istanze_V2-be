package it.sincon.sanita.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String changeFormat(String actualDateString, String actualFormatPattern, String newFormatPattern){
		String response = "";

		if (actualFormatPattern.equals(newFormatPattern)){
			response = actualDateString;
		}else{
			SimpleDateFormat actualSDF = new SimpleDateFormat(actualFormatPattern); 
			SimpleDateFormat newSDF = new SimpleDateFormat(newFormatPattern);

			try {
				Date data = actualSDF.parse(actualDateString);
				response = newSDF.format(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return response;
	}

}
