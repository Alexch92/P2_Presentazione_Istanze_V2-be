package it.osapulie.web.portlet.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.directory.InitialDirContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.exceptions.SignatureException;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfPKCS7;
import com.lowagie.text.pdf.PdfReader;

/**
 * Verifies pkcs #7 signature for binary-DER or base64 DER files.
 */
public class SignatureManager {
	
	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	protected static Log log = LogFactory.getLog(SignatureManager.class.getName());

	/**
	 * Verify a .p7m input file signature.
	 * 
	 * @param inputFile the .p7m signature file
	 * @param outputFile the name of output file (extract file to outputFile), <code>null</code> if
	 *        no output required
	 * @param certificateFile file of certificate, <code>null</code> if certificate is into
	 *        inputFile
	 * @return <code>true</code> if input file signature is valid, <code>false</code> otherwise
	 */
	
		
		/**
		 * Verify a .p7m input file signature.
		 * 
		 * @param inputFile the .p7m signature file
		 * @param outputFile the name of output file (extract file to outputFile), <code>null</code> if
		 *        no output required
		 * @param certificateFile file of certificate, <code>null</code> if certificate is into
		 *        inputFile
		 * @return <code>true</code> if input file signature is valid, <code>false</code> otherwise
		 */
		public static boolean checkPkcs7Signature(byte[] sigbytes, String outputFile, String certificateFile) {

			X509Certificate signercert = null;

			// recovered signed-content
			if (certificateFile != null) {
				try {
					InputStream inStream = new FileInputStream(certificateFile);
					CertificateFactory cf = CertificateFactory.getInstance("X.509");
					signercert = (X509Certificate) cf.generateCertificate(inStream);
					
					/*
					//TODO: verificare qui....
					String certCF = signercert.getSubjectDN().getName();//questo è il codice fiscale nel certificato....
					if (certCF.toUpperCase() != codiceFiscale.toUpperCase()) {
						throw new Exception("Firma non valida. Il file non risulta firmato digitalmente da " + codiceFiscale);
					}
					// TODO:
					 *  
					 */
					
					inStream.close();
				}
				catch (Exception cerexc) {
					log.error("checkPkcs7Signature :: Failed to create certificate from file : " + certificateFile + " :: " + cerexc.getMessage(), cerexc);
					return false;
				}
			}

		/*
		 * FileInputStream freader = null; File f = null;
		 * 
		 * // ------ Get the included data signature from file ------------- f = new
		 * File(inputFile); int sizecontent = ((int) f.length()); byte[] sigbytes = new
		 * byte[sizecontent];
		 * 
		 * try { freader = new FileInputStream(f); freader.read(sigbytes, 0, sizecontent);
		 * freader.close(); } catch (IOException ioe) { log.error("checkPkcs7Signature :: " +
		 * ioe.getMessage(), ioe); return false; }
		 */

		if (isBase64Encoded(sigbytes)) {
			try {
				sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
				sigbytes = dec.decodeBuffer(new String(sigbytes));
				log.info("checkPkcs7Signature :: Signature file is BASE64 encoded");
			}
			catch (IOException ioe) {
				log.warn("checkPkcs7Signature :: Problem decoding from b64 : " + ioe.getMessage());
			}
		}

		// --- Use Bouncy Castle provider to verify included-content CSM/PKCS#7 signature ---
		try {
			CMSSignedData s = new CMSSignedData(sigbytes);
			CertStore certs = s.getCertificatesAndCRLs("Collection", "BC");
			SignerInformationStore signers = s.getSignerInfos();
			Collection c = signers.getSigners();
			Iterator it = c.iterator();
			int verified = 0;

			while (it.hasNext()) {
				X509Certificate cert = null;
				SignerInformation signer = (SignerInformation) it.next();
				Collection certCollection = certs.getCertificates(signer.getSID());
				if (certCollection.isEmpty() && signercert == null)
					continue;
				else if (signercert != null) // use a signer cert file for verification, if it was
					cert = signercert;
				else { // use the certificates included in the signature for verification
					Iterator certIt = certCollection.iterator();
					cert = (X509Certificate) certIt.next();
				}

				log.debug("checkPkcs7Signature :: certificate : " + cert);

				if (signer.verify(cert.getPublicKey(), "BC")) {

					// Verify certificate validation date
					Date now = new Date();
					if (now.before(cert.getNotAfter()) && now.after(cert.getNotBefore()))
						verified++;
				}
			}

			if (verified == 0) {
				log.info("checkPkcs7Signature :: WARNING: No signers' signatures could be verified!");
				return false;
			}
			else if (signercert != null)
				log.info("checkPkcs7Signature :: Verified a signature using signer certificate file  '" + certificateFile + "'");
			else
				log.info("checkPkcs7Signature :: Verified a signature using a certificate in the signature file '");

			if (outputFile != null) {
				log.info("checkPkcs7Signature :: writing original file : " + outputFile);
				CMSProcessableByteArray cpb = (CMSProcessableByteArray) s.getSignedContent();
				byte[] rawcontent = (byte[]) cpb.getContent();
				log.debug("checkPkcs7Signature :: Writing content (" + rawcontent.length + " bytes) to file " + outputFile + " ... ");
				FileOutputStream fcontent = new FileOutputStream(outputFile);
				fcontent.write(rawcontent);
				fcontent.close();
			}

		}
		catch (Exception ex) {
			log.error("checkPkcs7Signature :: Couldn't verify included-content CMS signature : " + ex.toString());
			return false;
		}

		return true;
	}
		
		/**
		 * Verify a .p7m input file signature.
		 * 
		 * @param inputFile the .p7m signature file
		 * @param outputFile the name of output file (extract file to outputFile), <code>null</code> if
		 *        no output required
		 * @param certificateFile file of certificate, <code>null</code> if certificate is into
		 *        inputFile
		 * @return <code>true</code> if input file signature is valid, <code>false</code> otherwise
		 */
		public static String checkPkcs7Signature(byte[] sigbytes, String outputFile, String certificateFile, String loggedUserCF,boolean verifyExpired) {

			X509Certificate signercert = null;

			// recovered signed-content
			if (certificateFile != null) {
				try {
					InputStream inStream = new FileInputStream(certificateFile);
					CertificateFactory cf = CertificateFactory.getInstance("X.509");
					signercert = (X509Certificate) cf.generateCertificate(inStream);
					
					inStream.close();
				}
				catch (Exception cerexc) {
					log.error("checkPkcs7Signature :: Failed to create certificate from file : " + certificateFile + " :: " + cerexc.getMessage(), cerexc);
					return "checkPkcs7Signature :: Failed to create certificate from file : " + certificateFile + " :: " + cerexc.getMessage();
				}
			}

		/*
		 * FileInputStream freader = null; File f = null;
		 * 
		 * // ------ Get the included data signature from file ------------- f = new
		 * File(inputFile); int sizecontent = ((int) f.length()); byte[] sigbytes = new
		 * byte[sizecontent];
		 * 
		 * try { freader = new FileInputStream(f); freader.read(sigbytes, 0, sizecontent);
		 * freader.close(); } catch (IOException ioe) { log.error("checkPkcs7Signature :: " +
		 * ioe.getMessage(), ioe); return false; }
		 */

		if (isBase64Encoded(sigbytes)) {
			try {
				sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
				sigbytes = dec.decodeBuffer(new String(sigbytes));
				log.info("checkPkcs7Signature :: Signature file is BASE64 encoded");
			}
			catch (IOException ioe) {
				log.warn("checkPkcs7Signature :: Problem decoding from b64 : " + ioe.getMessage());
			}
		}

		// --- Use Bouncy Castle provider to verify included-content CSM/PKCS#7 signature ---
		try {
			CMSSignedData s = new CMSSignedData(sigbytes);
			CertStore certs = s.getCertificatesAndCRLs("Collection", "BC");
			SignerInformationStore signers = s.getSignerInfos();
			Collection c = signers.getSigners();
			Iterator it = c.iterator();
			int verified = 0;
			int verifiedDate = 0;
			int verifiedCF = 0;

			while (it.hasNext()) {
				boolean validDate = false;
				boolean validCF = false;
				X509Certificate cert = null;
				SignerInformation signer = (SignerInformation) it.next();
				Collection certCollection = certs.getCertificates(signer.getSID());
				if (certCollection.isEmpty() && signercert == null)
					continue;
				else if (signercert != null) // use a signer cert file for verification, if it was
					cert = signercert;
				else { // use the certificates included in the signature for verification
					Iterator certIt = certCollection.iterator();
					cert = (X509Certificate) certIt.next();
				}

				log.debug("checkPkcs7Signature :: certificate : " + cert);

				if (signer.verify(cert.getPublicKey(), "BC")) {

					// Verify certificate validation date
					Date now = new Date();
					if (now.before(cert.getNotAfter()) && now.after(cert.getNotBefore())) {
						verifiedDate++;
						validDate = true;
					}
				}
				
				String certCF = cert.getSubjectDN().getName();//questo è il codice fiscale nel certificato....
				if (loggedUserCF!=null) {
					log.debug("certCF= " + certCF.toUpperCase() + "; loggedUserCF= " + loggedUserCF.toUpperCase());
				}
				if (loggedUserCF!=null && certCF.toUpperCase().contains(loggedUserCF.toUpperCase())) {
					//return ("Firma non valida. Il file non risulta firmato digitalmente da " + loggedUserCF.toUpperCase());
					verifiedCF++;
					validCF = true;
				}else {
					validCF=loggedUserCF==null;
				}
				if (validDate && validCF){
					verified++;
					break;
				}
			}

			if (verifyExpired) {
				if (verified == 0) {
					log.info("checkPkcs7Signature :: WARNING: No signers' signatures could be verified!");
					return "Firma digitale non valida :: Certificato scaduto o non appartenente a " + loggedUserCF.toUpperCase();
				}
			}
			else if (signercert != null) 
				log.info("checkPkcs7Signature :: Verified a signature using signer certificate file  '" + certificateFile + "'");
			else 
				log.info("checkPkcs7Signature :: Verified a signature using a certificate in the signature file '");

			if (outputFile != null) {
				log.info("checkPkcs7Signature :: writing original file : " + outputFile);
				CMSProcessableByteArray cpb = (CMSProcessableByteArray) s.getSignedContent();
				byte[] rawcontent = (byte[]) cpb.getContent();
				log.debug("checkPkcs7Signature :: Writing content (" + rawcontent.length + " bytes) to file " + outputFile + " ... ");
				FileOutputStream fcontent = new FileOutputStream(outputFile);
				fcontent.write(rawcontent);
				fcontent.close();
			}

		}
		catch (Exception ex) {
			log.error("checkPkcs7Signature :: Couldn't verify included-content CMS signature : " + ex.toString(), ex);
			return "checkPkcs7Signature :: Couldn't verify included-content CMS signature : " + ex.toString();
		}

		return "OK";
	}
	
	public static boolean signContent(byte[] contentbytes,InputStream certificateContent,OutputStream os) {
		boolean result = true;
		X509Certificate cert = null;
		try{
			  CertificateFactory cf = CertificateFactory.getInstance("X.509");
			  cert = (X509Certificate)cf.generateCertificate(certificateContent);
			  certificateContent.close();
			 }
			 catch(Exception exc){
			  log.error("Error in signContent :: "+exc.getMessage(),exc);
			  result= false;
			 }

			// --- Use Bouncy Castle provider to create enveloped message ---
			 String algorithm = CMSEnvelopedDataGenerator.RC2_CBC;
			 int keysize = 128;  // bits
			 CMSEnvelopedDataGenerator  fact = new CMSEnvelopedDataGenerator();
			 fact.addKeyTransRecipient(cert);
			 CMSProcessableByteArray content = new CMSProcessableByteArray(contentbytes);
			 try{
			  CMSEnvelopedData  envdata = fact.generate(content, algorithm, keysize, "BC");
			  byte[] enveloped = envdata.getEncoded() ;
			  System.out.println("Got encoded pkcs7 bytes " + enveloped.length + " bytes") ;
			   os.write(enveloped);
			   os.close();
			 }
			 catch(Exception ex){
				  log.error("Error in signContent :: "+ex.getMessage(),ex);
				  result= false;
			 }		
		return result;
		
	}

	/**
	 * Ritorna il file originale contenuto in un <code>.p7m</code>.
	 * 
	 * @param p7bytes
	 * @return
	 * @throws CMSException
	 * @throws IOException
	 */
	public static byte[] getData(final byte[] p7bytes) throws CMSException, IOException {
		CMSSignedData cms = new CMSSignedData(p7bytes);
		if (cms.getSignedContent() == null) {
			// Error!!!
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		cms.getSignedContent().write(out);
		return out.toByteArray();
	}

	private static final boolean isBase64Encoded(byte[] data) {
		Arrays.sort(Base64Map);
		for (int i = 0; i < data.length; i++) {
			// System.out.println("data[" + i + "] " + (char)data[i]) ;
			if (Arrays.binarySearch(Base64Map, (char) data[i]) < 0 && !Character.isWhitespace((char) data[i]))
				return false;
		}
		return true;
	}

	private static char[] Base64Map = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '=' };
	
	public static final String checkPadesSignature(byte[] sigbytes, String[] loggedUserCFs){
        String retValue = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        try{
	        PdfReader pdfReader = new PdfReader(sigbytes);
	        AcroFields acroFields = pdfReader.getAcroFields();
	        List<String> signatureNames = acroFields.getSignatureNames();
	        if (!signatureNames.isEmpty()) {
	        	log.debug(String.format("signatureNames size =%s", signatureNames.size()));
	        	int verified = 0;
				int verifiedDate = 0;
				int verifiedCF = 0;
				int verifiedRevocation = 0;
	        	for (String name : signatureNames) {
	        		boolean checkRevocation = true;
	            	boolean validDate = false;
					boolean validCF = false;
					
					// #SA# 28.01.2022
					// Controllo che il file sia firmato TOTALMENTE....
	                if (acroFields.signatureCoversWholeDocument(name)) {
	                	log.debug(String.format("signature name =%s", name));
	                    PdfPKCS7 pkcs7 = acroFields.verifySignature(name);
	                    //valid = pkcs7.verify();
	                    String reason = pkcs7.getReason();
	                    Calendar signedAt = pkcs7.getSignDate();
	                    
	                    X509Certificate signingCertificate = pkcs7.getSigningCertificate();
	                    Date now = new Date();
	                    // Verifica della Data...
	                    log.debug(String.format("Verifica date... %s - %s - %s", 
	                    		sdf.format(signingCertificate.getNotAfter()),
	                    		sdf.format(now),
	                    		sdf.format(signingCertificate.getNotBefore())));
	                    
	                    
						if (now.before(signingCertificate.getNotAfter()) && now.after(signingCertificate.getNotBefore())){
							validDate = true;
							verifiedDate++;
						}
						
	                    // Verifica del Codice Fiscale...
	                    String strSubjectDN = signingCertificate.getSubjectDN().getName();
	                    log.debug(String.format("strSubjectDN =%s", strSubjectDN.toUpperCase()));
	                    for (String loggedUserCF : loggedUserCFs) {
	                    	log.debug(String.format("loggedUserCF =%s", loggedUserCF.toUpperCase()));
		                    if (strSubjectDN.toUpperCase().contains(loggedUserCF.toUpperCase())) {
								validCF = true;
								verifiedCF++;
								break;
							}
						}
	                    
	                    // Verifica revoca certificato...
	                    checkRevocation= checkIsRevoked(signingCertificate);
	                    if (!checkRevocation)
	                    	verifiedRevocation++;
	                    
	                    if (validDate && validCF && !checkRevocation){
	                    	log.debug("firma VALIDA!!");
							verified++;
							break;
	                    }
	                }
	        	}
	        	
	        	if (verified > 0) {
					log.info("checkPadesSignature :: INFO: Firma digitale valida !");
					retValue = "OK";
				}
				else {
					if (verifiedCF == 0){
						retValue = "error.checkSignature.invalidCF";
						log.error(retValue);
					}
					if (verifiedDate == 0){
						retValue = "error.checkSignature.certScaduto";
						log.error(retValue);
					}
					if (verifiedRevocation==0){
						retValue = "error.checkSignature.certRevocato";
						log.error(retValue);
					}
				}
	        }
		}
        /*
        catch (Exception ex) {
			retValue = "checkPadesSignature :: Couldn't verify included-content CMS signature : " + ex.toString();
			log.error(retValue, ex);
		}
		*/
        catch (Throwable throwable) {
        	retValue = "checkPadesSignature :: Couldn't verify included-content CMS signature : " + throwable.toString();
			log.error(retValue, throwable);
        }
        
        return retValue;
    }
	
	
	
    private static X509CRL getX509CRLFromURL(String url){
        try{
            InputStream inStream = null;
            try{
                if(url.toLowerCase().startsWith("ldap")){
                    Map<String, String> env = new Hashtable<String, String>();
                    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
                    env.put(Context.PROVIDER_URL, url);
                    byte[] val = (byte[]) new InitialDirContext((Hashtable<String, String>)env).getAttributes("").get("certificateRevocationList;binary").get();
                    if ((val == null) || (val.length == 0))
                        throw new Exception("Can not download CRL from: " + url);
                    inStream = new ByteArrayInputStream(val);
                } else{
                    inStream = new URL(url).openStream();
                }
                System.out.println("CRL download correctly from : " + url);
            }catch(Exception e){throw new Exception("Can not download CRL from: " + url + "\n" + e.getMessage());}
            
            X509CRL crl = (X509CRL) CertificateFactory.getInstance("X.509").generateCRL(inStream);
            inStream.close();
            
            return crl;
        }catch(Exception ex){ex.printStackTrace();}
        return null;
    }
    
    private static List<String> getDistributionPointUrls(X509Certificate cert){
        
        List<String> ret = new ArrayList<String>();
        
        try{
            String data = cert.toString();
            
            if(data.indexOf("CRLDistributionPoints") == -1)
                return ret;
            
            data = data.substring(data.indexOf("CRLDistributionPoints"));
            data = data.substring(0, data.indexOf("]]") + 2);
            
            while(data.indexOf("URIName") != -1){
                data = data.substring(data.indexOf("URIName") + 9);
                
                String url = data.substring(0, data.indexOf("]"));
                
                if(url.contains(", URIName: ")){
                    String[] urlTmpList = url.split(", URIName: ");
                    for(String urlTmp:urlTmpList)
                        ret.add(urlTmp);
                }else
                    ret.add(url);
                
                data = data.substring(data.indexOf("]") + 1);
            }
        }catch(Exception ex){ex.printStackTrace();}
        
        return ret;
    }
    
    private static boolean checkIsRevoked(X509Certificate cert){
        List<String> crlDPUrlList = getDistributionPointUrls(cert);
        X509CRL x509CRL = null;
        for(String crlDPUrl: crlDPUrlList){
            if(crlDPUrl.toLowerCase().startsWith("ldap"))
                continue;
            x509CRL = getX509CRLFromURL(crlDPUrl);
            if(x509CRL != null)
                break;
        }
        if(x509CRL == null)
            for(String crlDPUrl: crlDPUrlList){
                if(!crlDPUrl.toLowerCase().startsWith("ldap"))
                    continue;
                x509CRL = getX509CRLFromURL(crlDPUrl);
                if(x509CRL != null)
                    break;
            }
        try{
            if(x509CRL == null)
                throw new Exception("Impossible to get the Certificate Revocation List from the URLs provided.");
        }catch(Exception ex){ex.printStackTrace();return false;}
        
        return x509CRL.isRevoked(cert);
    }




	

}