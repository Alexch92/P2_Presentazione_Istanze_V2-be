package it.sincon.gepred.web.portlet.utils;

import it.osapulie.infrastructure.impl.StringUtils;
import it.osapulie.service.ServiceLayerException;
import it.osapulie.web.portlet.util.SignatureManager;
import it.sincon.gepred.documentale.bean.DocFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.activation.MimetypesFileTypeMap;

import org.alfresco.webservice.util.ContentUtils;
import org.apache.tika.Tika;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.bouncycastle.cms.CMSException;

public class ServiceHelper {

	/* MASCHERE PER LA CONFIGURAZIONE DELLA PORTLET */
	//public static final byte SHOW_TAB_MASK = 1; // 00000001

	/* MASCHERE DI BIT PER LA CONFIGURAZIONE DEI CAMPI AGGIUNTIVI DEL TIPO PRATICA */
	public static final byte BACK_END_MAIN_PAG_MASK = 1; 		// 00000001
	public static final byte FRONT_END_MAIN_PAG_MASK = 2;		// 00000010
	
	public static final byte BACK_FRONT_END_MAIN_PAG_MASK = BACK_END_MAIN_PAG_MASK | FRONT_END_MAIN_PAG_MASK;	// 00000011
	
	public static final String NOME_FILE = "NOME-FILE";
	public static final String CONTENT_FILE = "CONTENT-FILE";
	public static final String CONTENT_TYPE = "CONTENT-TYPE";
	public static final Detector DETECTOR = new DefaultDetector(MimeTypes.getDefaultMimeTypes());
	
	/* 
	1 - BackEnd + MainPag
	2 - FrontEnd + MainPag
	3 - BackFrontEnd + MainPag
	5 - BackEnd + Tab
	7 - BackFrontEnd + Tab
	*/
	
	/* MASCHERE DI BIT USATE PER LA CONFIGURAZIONE DELLA TIPOLOGIA DI PRATICA */
	public static final byte SHOW_MITT_DEST = 1; 					// 0000 0001
	public static final byte SHOW_STATO = 2;						// 0000 0010
	public static final byte SHOW_TIP_INT = 4;						// 0000 0100
	public static final byte SHOW_LOCALITA = 8;						// 0000 1000
	public static final byte AUTOMATIC_ASSIGN = 16;					// 0001 0000
	public static final byte SHOW_INVIA_MAIL_DA_ALLEGATO = 32;		// 0010 0000
	public static final byte SHOW_VISIBILE_ON_LINE = 64;			// 0100 0000
	public static final byte AUTOMATIC_PROTOCOL = -128;				// 1000 0000

	
	/**
	 * Verifico la configurazione caricata dal DB
	 * 
	 * @param mask
	 * @param maskToCheck
	 * @return true se la maschera &egrave; verificata
	 */
	public static boolean checkBitMask(byte mask, byte maskToCheck) {
		return ((mask & maskToCheck) == maskToCheck);
	}
	
	/**
	 * Setta la maschera di bit per la configurazione del tipo pratica / campo aggiuntivo
	 * 
	 * @param bitToSet
	 * @return la maschera di bit per la configurazione
	 */
	public static byte setBitMask(byte[] bitToSet) {
		byte result = 0;
		for (int i = 0; i < bitToSet.length; i++) {
			result |= bitToSet[i];
		}
		return result;
	}
	
	public static DocFile convertFiletoDocFile(File inputfile) throws Exception{
		
		if (inputfile == null) throw new Exception("Il file e' null"); //FIXME
		if (inputfile.getName().contains("@"))
			throw new Exception("Il nome del file contiene caratteri non validi");
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(inputfile);
		} catch (FileNotFoundException e1) {
			throw new Exception("Accesso al file non riuscito", e1);
		}
		byte[] content;
		try {
			content = ContentUtils.convertToByteArray(inputStream);
			inputStream.close();
		} catch (Exception e1) {
			throw new Exception("Lettura file non riuscita", e1);
		}

		DocFile res_docFile = new DocFile();
		res_docFile.setNome(inputfile.getName());

		// TODO: Sostituire MimetypesFileTypeMap().getContentType( con Apache tika...
		res_docFile.setMimeType(new MimetypesFileTypeMap().getContentType(inputfile));
		// TODO.....
		
		res_docFile.setEncoding(getEncoding(inputfile));
		res_docFile.setContent(content);

		return res_docFile;
	}
	
	public static String createDir(){
		File cartella = new File("Tmp"+System.currentTimeMillis());
		cartella.mkdir();
		return cartella.getAbsolutePath()+File.separator;
	}
	public static String createDir(String parentFolder){
		File cartella = new File(parentFolder + "Tmp" + System.currentTimeMillis());
		cartella.mkdir();
		return cartella.getAbsolutePath()+File.separator;
	}
	public static boolean deleteFile(File file) {
		boolean result=	file.delete();
		if (result && file.getParentFile().list().length==0)
			result = file.getParentFile().delete();
		return result;
	}

	public static String getEncoding(File file) {
		String encoding = System.getProperty("file.encoding");  
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			char buffer[] = new char[3];
			int length = bufferedReader.read(buffer);
			if ((length >= 2) && ((buffer[0] == (char) 0xff && buffer[1] == (char) 0xfe) || 
					(buffer[0] == (char) 0xfe && buffer[1] == (char) 0xff)))
				encoding = "UTF16";
			if ((length >= 3) && (buffer[0] == (char) 0xef && buffer[1] == (char) 0xbb &&
					buffer[2] == (char) 0xbf))
				encoding = "UTF8";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		}
		return encoding;
	}
	
	public static String getNomeAllegatoPraticaWeb(Long idPraticaWeb, Long idAllegato, String originalFileName, String originalNomeDocumento, String pattern){
		String retValue = "";
		
		String strIdPratica = (idPraticaWeb!=null ? String.valueOf(idPraticaWeb) : "");
		String strIdAllegato = (idAllegato!=null ? String.valueOf(idAllegato) : "");
		
		String nomeFile = "";
		String ext = "";
		if (originalFileName!=null){
			ext=originalFileName.substring(originalFileName.lastIndexOf("."));
			originalFileName = originalFileName.replace(ext, "");
			nomeFile=StringUtils.cleanString(originalFileName);
			if (nomeFile.length()>240)
				nomeFile = nomeFile.substring( 0, 240 );
		}
		
		String nomeDocumento="";
		if (originalNomeDocumento!=null){
			nomeDocumento=StringUtils.cleanString(originalNomeDocumento);
			 if (nomeDocumento.length()>240)
				 nomeDocumento = nomeDocumento.substring( 0, 240 );
		}
		
		retValue = pattern.replace("%idPratica", strIdPratica).
				replace("%idAllegato", strIdAllegato).
				replace("%originalFileName", nomeFile).
				replace("%nomeDocumento", nomeDocumento).
				replace("%ext", ext);
		
		return retValue;
	}
	
	public static String detectExtension(final byte[] content) throws IOException {
		if (SignatureManager.checkPkcs7Signature(content, null, null,null,false).equals("OK")){
			try {
				String result =detectExtension(SignatureManager.getData(content))+".p7m"; 
				return result;
			} catch (CMSException e) {
				e.printStackTrace();
				return ".p7m";
			}
		}else {
			try {
				String mimeType = detectMimeType(content);
				MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
				  MimeType mime = allTypes.forName(mimeType);
				  return mime.getExtension();
			} catch (MimeTypeException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String detectMimeType(final byte[] content) throws IOException {
		if (SignatureManager.checkPkcs7Signature(content, null, null,null,false).equals("OK")){
			return "application/pkcs7-mime";
		}
	    TikaInputStream tikaIS = null;
	    try {
	        tikaIS = TikaInputStream.get(content);

	        /*
	         * You might not want to provide the file's name. If you provide an Excel
	         * document with a .xls extension, it will get it correct right away; but
	         * if you provide an Excel document with .doc extension, it will guess it
	         * to be a Word document
	         */
	        final Metadata metadata = new Metadata();
	        // metadata.set(Metadata.RESOURCE_NAME_KEY, file.getName());

	        return DETECTOR.detect(tikaIS, metadata).toString();
	    } finally {
	        if (tikaIS != null) {
	            tikaIS.close();
	        }
	    }
	}

	public static String contentToString(byte[] content) throws ServiceLayerException{
		try {
			Tika tika = new Tika();
			return tika.parseToString(new ByteArrayInputStream(content));
		} catch (IOException e) {
			throw new ServiceLayerException(e.getMessage(), e);
		} catch (TikaException e) {
			throw new ServiceLayerException(e.getMessage(), e);
		}
	}
	
	public static String getNomeDocumentoAllegatoBRapprLegale(String nominativoRL, String codiceFiscaleRL){
		String retValue = "";
		
		retValue = String.format("%S_AllegatoB", codiceFiscaleRL);
		
		return retValue;
	}
	public static String getNomeFileAllegatoBRapprLegale(Long idPraticaWeb, Long idRappresentante, String originalFileName, String originalNomeDocumento, String pattern){
		String retValue = "";
		
		String strIdPratica = (idPraticaWeb!=null ? String.valueOf(idPraticaWeb) : "");
		String strIdRappresentante = (idRappresentante!=null ? String.valueOf(idRappresentante) : "");
		
		String nomeFile = "";
		String ext = "";
		if (originalFileName!=null){
			ext=originalFileName.substring(originalFileName.lastIndexOf("."));
			originalFileName = originalFileName.replace(ext, "");
			nomeFile=StringUtils.cleanString(originalFileName);
			if (nomeFile.length()>240)
				nomeFile = nomeFile.substring( 0, 240 );
		}
		
		String nomeDocumento="";
		if (originalNomeDocumento!=null){
			nomeDocumento=StringUtils.cleanString(originalNomeDocumento);
			 if (nomeDocumento.length()>240)
				 nomeDocumento = nomeDocumento.substring( 0, 240 );
		}
		
		retValue = pattern.replace("%idPratica", strIdPratica).
				replace("%idRapprLegale", strIdRappresentante).
				replace("%originalFileName", nomeFile).
				replace("%nomeDocumento", nomeDocumento).
				replace("%ext", ext);
		
		return retValue;
	}

	// Returns the contents of the file in a byte array.
    public static byte[] getBytesFromFile(File file) throws IOException {        
        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
            throw new IOException("File is too large!");
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;

        InputStream is = new FileInputStream(file);
        try {
            while (offset < bytes.length
                   && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
                offset += numRead;
            }
        } finally {
            is.close();
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }
        return bytes;
    }
}
