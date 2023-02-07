package it.sincon.gepred.documentale.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;
public class DateUtils {

	private DateUtils() {
	}
	
	/**
	 * Verifica se la data è corretta
	 * @param data
	 * @return boolean
	 */
	public static boolean isData(String date){
		
		if(date.trim().length() != 10)
            return false;
        if(date.charAt(2) != '/' && date.charAt(2) != '-')
            return false;
        if(date.charAt(5) != '/' && date.charAt(2) != '-')
            return false;
        
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(date);
        }
        catch(ParseException pe)
        {
        	try{
	        	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	            sdf.setLenient(false);
	            sdf.parse(date);
        	}
            catch(ParseException pe1)
            {   
            	return false;
            }
        }
        return true;
	}
	
	/**
	 * Restituisce la data corrente
	 * 
	 * @return Date
	 */
	public static Date getOggi() {
		Calendar oggi = Calendar.getInstance();
		// oggi.set(11, 0);
		// oggi.set(12, 0);
		// oggi.set(13, 0);
		// oggi.set(14, 0);
		return oggi.getTime();
	}

	/**
	 * Converte una data dal formato YYYY-MM-GG in GG-MM-YYYY
	 * 
	 * @param dataYYYMMGG
	 * @return string
	 */
	public static String getStringDataDaYYYYMMGG( String dataYYYMMGG ) {
		String ddmmyyyy = null;
		if (dataYYYMMGG != null) {
			String yyyy = dataYYYMMGG.substring( 0, 4 );
			String mm = dataYYYMMGG.substring( 5, 7 );
			String dd = dataYYYMMGG.substring( 8 );
			ddmmyyyy = (new StringBuilder()).append( dd ).append( "-" ).append( mm ).append( "-" ).append( yyyy ).toString();
		}
		return ddmmyyyy;
	}
	/**
	 * Converte una data dal formato YYYY-MM-GG in GG-MM-YYYY
	 * 
	 * @param dataYYYMMGG
	 * @return string
	 */
	public static String getStringDataDaGGMMYYYY( String dataGGMMYYYY ) {
		String yyyymmdd = null;
		if (dataGGMMYYYY != null) {
			String yyyy = dataGGMMYYYY.substring( 6 );
			String mm = dataGGMMYYYY.substring( 3, 5 );
			String dd = dataGGMMYYYY.substring( 0,2 );
			yyyymmdd = (new StringBuilder()).append( yyyy ).append( "-" ).append( mm ).append( "-" ).append( dd ).toString();
		}
		return yyyymmdd;
	}

	/**
	 * restituisce la data corrente
	 * 
	 * @return string
	 */
	public static String getDataCorrente() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy" );
		String data = sdf.format( date );
		return data;
	}
	
	/**
	 * Restituisce l'anno corrente
	 * 
	 * @return string
	 */
	public static String getAnnoCorrente() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy" );
		String anno = sdf.format( date );
		return anno;
	}

	/**
	 * Converte la data da stringa (dd-MM-yyyy) a date
	 * 
	 * @param data
	 * @param format
	 *            - formato del campo data
	 * @return Date
	 */
	public static Date getData( String data ) {
		if (data == null)
			return null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
			sdf.setLenient( false );
			Date dataDate = sdf.parse( data );
			return dataDate;
		} catch (ParseException pe) {
			return null;
		}
	}

	/**
	 * Restituisce la data senza gli slash
	 * 
	 * @param data
	 * @return String
	 */
	public static String getDataSenzaSlash( Date data ) {
		if (data == null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat( "ddMMyyyy" );
			String dataString = sdf.format( data );
			return dataString;
		}
	}

	/**
	 * Restituisce la data nel formato GG-MM-AAAA
	 * 
	 * @param data
	 * @return String
	 */
	public static String getDataGGMMAAAA( Date data ) {
		if (data == null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy" );
			String dataString = sdf.format( data );
			return dataString;
		}
	}
	
	public static Date fromXMLGregorianCalendar( XMLGregorianCalendar xcal ) {
		return xcal.toGregorianCalendar().getTime();
	}
}