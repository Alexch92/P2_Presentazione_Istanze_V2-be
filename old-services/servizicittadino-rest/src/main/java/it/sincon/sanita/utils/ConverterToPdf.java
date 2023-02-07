/**
 * 
 */
package it.sincon.sanita.utils;

import it.sincon.sanita.utils.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.ByteArrayOutputStream;

import org.apache.commons.io.IOUtils;

import com.artofsolving.jodconverter.BasicDocumentFormatRegistry;
import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFamily;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * @author Birtolo Maria Michela
 *
 */
public class ConverterToPdf {
	
	private static 	        final int PDFXNONE = 0;
	private static 	        final int PDFX1A2001 = 1;
	private static 	        final int PDFX32002 = 2;
	private static 	        final int PDFA1A = 3;
	private static 	        final int PDFA1B = 4;
 

	/**
	 * Metodo che trasforma un documento in pdf usando l'openoffice
	 * @param documento
	 * @param outputFilePath
	 * @param inputFileName
	 * @param host TODO
	 * @param port TODO
	 * @return File documento pdf
	 * @throws Exception
	 */
	public static File converterToPdf(byte[] documento, String outputFilePath, String inputFileName, String host, int port) throws Exception{
		File inputFile = StreamUtils.dumpToFile(documento, inputFileName);
		String outputFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf(".")) +".pdf";
        File outputFile = new File(outputFilePath , outputFileName);
        try{
	        // connect to an OpenOffice.org instance running on port 8100
	        OpenOfficeConnection connection = new SocketOpenOfficeConnection(host,port);
	        connection.connect();
	
	        // convert
	        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);

	        DocumentFormat customPdfFormat = new DocumentFormat("Portable Document Format", "application/pdf", "pdf");

	        customPdfFormat.setExportFilter(DocumentFamily.TEXT, "writer_pdf_Export");
	        final Map<String, Integer> pdfOptions = new HashMap<String, Integer>();
	        pdfOptions.put("SelectPdfVersion", PDFX1A2001);
	        customPdfFormat.setExportOption(DocumentFamily.TEXT, "FilterData", pdfOptions);
	        converter.convert(inputFile, outputFile,customPdfFormat);
	
	        // close the connection
	        connection.disconnect();
	        
	        inputFile.delete();
        }
        catch (Exception e) {
        	e.printStackTrace();
			System.out.println("errore"+e.getMessage());
		}
        return outputFile;
	}
	
	/**
	 * Metodo che trasforma un documento in pdf usando l'openoffice
	 * @param inputDocStream
	 * @param outputFilePath
	 * @param inputFileName
	 * @param host TODO
	 * @param port TODO
	 * @return File documento pdf
	 * @throws Exception
	 */
	public static ByteArrayOutputStream converterToPdf(InputStream inputDocStream, String imputDocMimeType, String host, int port) throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
	        // connect to an OpenOffice.org instance running on port 8100
	        OpenOfficeConnection connection = new SocketOpenOfficeConnection(host,port);
	        connection.connect();
	        // convert
	        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
	        DefaultDocumentFormatRegistry ddfr = new DefaultDocumentFormatRegistry();
	        
	        // DocumentFormat per il file di input...
	        DocumentFormat inputDocFormat = ddfr.getFormatByMimeType(imputDocMimeType);
	        
	        // DocumentFormat per il file di output...
	        DocumentFormat customPdfFormat = ddfr.getFormatByMimeType("application/pdf"); 
	        final Map<String, Integer> pdfOptions = new HashMap<String, Integer>();
	        pdfOptions.put("SelectPdfVersion", PDFX1A2001);
	        customPdfFormat.setExportOption(DocumentFamily.TEXT, "FilterData", pdfOptions);
	        converter.convert(inputDocStream, inputDocFormat, baos, customPdfFormat);

	        baos.flush();
	
	        // close the connection
	        connection.disconnect();
        }
        catch (Exception e) {
        	e.printStackTrace();
			System.out.println("errore"+e.getMessage());
        } finally {
        	try {
        		if (baos != null) {
        			baos.close();
        		}
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
        return baos;
	}

}
