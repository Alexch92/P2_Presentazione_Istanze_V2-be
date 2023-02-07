package it.osapulie.web.portlet.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CheckSumGenerator {

	
	public static String generateCheckSum(byte[] buffer) {
		
		//File f = new File("c:\\myfile.txt");
		//InputStream is = new FileInputStream(f);				
		//byte[] buffer = new byte[8192];
		//int read = 0;
		
		// Get an MD5 implementation of MessageDigest
		//String algoritmo = "MD5";
		// Get an SHA-256 implementation of MessageDigest
		String algoritmo = "SHA-256";
		try {
			MessageDigest digest = MessageDigest.getInstance(algoritmo);
			// pass data read from file to digest for processing
			digest.update( buffer );
			// Get the sum...
			byte[] sum = digest.digest();
			// (Optionally) convert the byte array to a hex string
			BigInteger bigInt = new BigInteger(1, sum);
			String output = bigInt.toString(16);
			System.out.println(algoritmo + ": " + output);
			return output;
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(String.format("Algoritmo %s non trovato", algoritmo), e);
		}		
	}
}
