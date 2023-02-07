package it.osapulie.infrastructure.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class StreamUtils {
	/**
	 * @param contentBytes
	 * @param fileName
	 * @throws Throwable 
	 */
	public static File dumpToFile( byte[] contentBytes, String fileName ) throws Exception {
		if (contentBytes == null || contentBytes.length == 0) {
			return null;
		}
		
		ByteArrayInputStream in = new ByteArrayInputStream( contentBytes );
		File result = new File(fileName);
		FileOutputStream out = new FileOutputStream(result);
		try {
			byte[] buf = new byte[1 * 1024];
			int len = 0;
			while ((len = in.read( buf )) >= 0) {
				out.write( buf, 0, len );
			}
		} finally {
			closeStream( in );
			closeStream( out );
		}
		return result;
	}

	public static void closeStream( Closeable is ) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) { /* Close */ }
		}
	}
	
	/**
     * Legge il contenuto di un file
     * @param pathFile
     * @return	string
     */
	public static String leggiDaFile( String pathFile ) {
		ByteArrayOutputStream outStreamArray = new ByteArrayOutputStream();
		FileInputStream inStream = null;
		try {
			for (inStream = new FileInputStream( pathFile ); inStream.available() > 0; outStreamArray.write( inStream.read() ))
				;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeStream( inStream );
		}
		return outStreamArray.toString();
	}
	
	/**
     * Legge il contenuto di un file
     * @param pathFile
     * @return	string
     */
	public static byte[] getFileContent( File file ) {
		ByteArrayOutputStream outStreamArray = new ByteArrayOutputStream();
		FileInputStream inStream = null;
		try {
			for (inStream = new FileInputStream( file ); inStream.available() > 0; outStreamArray.write( inStream.read() ))
				;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeStream( inStream );
		}
		
		return outStreamArray.toByteArray();
	}
	
	public static byte[] toByteArray (Object obj)
	{
	  byte[] bytes = null;
	  ByteArrayOutputStream bos = new ByteArrayOutputStream();
	  try {
	    ObjectOutputStream oos = new ObjectOutputStream(bos); 
	    oos.writeObject(obj);
	    oos.flush(); 
	    oos.close(); 
	    bos.close();
	    bytes = bos.toByteArray ();
	  }
	  catch (IOException ex) {
	    //TODO: Handle the exception
	  }
	  return bytes;
	}
	
	public static File[] listDirectory(String path){
		File name = new File(path);	
		File directory[]=null;
		if (name.exists())
		{
			if (name.isDirectory())
			{
				directory = name.listFiles();
				System.out.printf("\n\nDirectory contents:\n\n");							
			}
		}
		return directory;
	}
	
	public static String humanReadableByteCount(long bytes, boolean si) {
		int unit = si ? 1000 : 1024;
		if (bytes < unit) return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	
}
