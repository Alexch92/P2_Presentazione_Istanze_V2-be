package it.sincon.gepred.visura.rupar.impl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.sincon.gepred.visura.bean.RappresentanteLegale;
import it.sincon.gepred.visura.bean.SedeImpresa;
import it.sincon.gepred.visura.bean.VisuraImpresa;
import it.sincon.gepred.visura.rupar.bean.AttoConferimentoCariche;
import it.sincon.gepred.visura.rupar.bean.ClassificazioneAteco;
import it.sincon.gepred.visura.rupar.bean.Persona;
import it.sincon.gepred.visura.rupar.bean.Response;
import it.sincon.gepred.visura.service.VisuraService;


/**
 * Service class for managing GruppoRuolo.
 */
@Service
@Transactional
public class VisuraRegistroImprese implements VisuraService{
	
	private final Logger log = LoggerFactory.getLogger(VisuraRegistroImprese.class);
	
	/*
	@PostConstruct
    public void initializeConnection() {
    	try {
        	TrustManager[] trustAllCerts = new TrustManager[] {
        			new X509TrustManager() 
        			{
		                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		                    return null;
		                }
		                public void checkClientTrusted(X509Certificate[] certs, String authType) {
		                }
		                public void checkServerTrusted(X509Certificate[] certs, String authType) {
		                }
        			}
        	};

	        // Install the all-trusting trust manager
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	
	        // Create all-trusting host name verifier
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        };
	
	        // Install the all-trusting host verifier
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    	}
    	catch(Exception e) {
			log.error(e.getMessage(),e);
    	}
    }
*/
	
	private String authorization;
	
	private Date expirationDate;
	
	
	private String pathKeystoreServer;
	private String passwordKeystore;
	private String pathKeystoreClient;
	private String tokenGenerateURL;
	private String tokenAuthorization;
	private String visuraServiceURL;
	private String visuraServiceEncrKey;

	public String getPathKeystoreServer() {
		return pathKeystoreServer;
	}
	public void setPathKeystoreServer(String pathKeystoreServer) {
		this.pathKeystoreServer = pathKeystoreServer;
	}
	public String getPasswordKeystore() {
		return passwordKeystore;
	}
	public void setPasswordKeystore(String passwordKeystore) {
		this.passwordKeystore = passwordKeystore;
	}
	public String getPathKeystoreClient() {
		return pathKeystoreClient;
	}
	public void setPathKeystoreClient(String pathKeystoreClient) {
		this.pathKeystoreClient = pathKeystoreClient;
	}
	public String getTokenGenerateURL() {
		return tokenGenerateURL;
	}
	public void setTokenGenerateURL(String tokenGenerateURL) {
		this.tokenGenerateURL = tokenGenerateURL;
	}
	public String getTokenAuthorization() {
		return tokenAuthorization;
	}
	public void setTokenAuthorization(String tokenAuthorization) {
		this.tokenAuthorization = tokenAuthorization;
	}
	public String getVisuraServiceURL() {
		return visuraServiceURL;
	}
	public void setVisuraServiceURL(String visuraServiceURL) {
		this.visuraServiceURL = visuraServiceURL;
	}
	public String getVisuraServiceEncrKey() {
		return visuraServiceEncrKey;
	}
	public void setVisuraServiceEncrKey(String visuraServiceEncrKey) {
		this.visuraServiceEncrKey = visuraServiceEncrKey;
	}

	private void refreshToken() {
		try {
			System.setProperty("javax.net.ssl.trustStore",pathKeystoreServer);
	        System.setProperty("javax.net.ssl.trustStorePassword", passwordKeystore);     
	
	        //System.setProperty("javax.net.ssl.keyStore", pathKeystoreClient);
	        //System.setProperty("javax.net.ssl.keyStorePassword", passwordKeystore);
	
	        System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true"); 
	        
	        // Establish SSL handshake before the first web service method is called
	        final KeyStore keyStore = KeyStore.getInstance("JKS");
	        keyStore.load(new FileInputStream(pathKeystoreClient), passwordKeystore.toCharArray());
	        final KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	        keyManagerFactory.init(keyStore, passwordKeystore.toCharArray());
	
	        final KeyStore trustStore = KeyStore.getInstance("JKS");
	        trustStore.load(new FileInputStream(pathKeystoreServer), passwordKeystore.toCharArray());
	        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        trustManagerFactory.init(trustStore);
	
	        final SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
	        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
	
	        final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
	        final SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("api-gw.regione.puglia.it", 443);
	        //sslSocket.startHandshake();
	
	        
			URL urlForToken = new URL(tokenGenerateURL);
			HttpsURLConnection httpURLConnectionForToken = (HttpsURLConnection)urlForToken.openConnection();
			httpURLConnectionForToken.setRequestMethod("POST");
			httpURLConnectionForToken.setDoOutput(true);
			httpURLConnectionForToken.setUseCaches(false);
			httpURLConnectionForToken.setConnectTimeout(60000);
			httpURLConnectionForToken.setReadTimeout(60000);
																					 		
			httpURLConnectionForToken.addRequestProperty("Authorization", tokenAuthorization);
			httpURLConnectionForToken.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
	
			// Install the all-trusting host verifier
			httpURLConnectionForToken.setDefaultHostnameVerifier(allHostsValid);
			
			InputStream is=httpURLConnectionForToken.getInputStream();
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte[] buffer = new byte[256];
			int len;
			while((len=is.read(buffer))!=-1)
				baos.write(buffer, 0, len);
			String json = new String(baos.toByteArray());
			log.debug(String.format("Token Json:%s", json));
			
			Gson gson=new Gson();
			Map<String,Object> token=(Map<String,Object>)gson.fromJson(new String(baos.toByteArray()),Map.class);
			authorization=token.get("token_type")+" "+token.get("access_token");
			log.debug(String.format("authorization:%s", authorization));
			
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.SECOND, ((Double)token.get("expires_in")).intValue());
			expirationDate=cal.getTime();
		} catch (MalformedURLException e) {
			log.error(e.getMessage(), e);
		} catch (ProtocolException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		catch (Exception ee) {
			log.error(ee.getMessage(), ee);
		}
	}
	
	private String getJsonFromStream(InputStream is) throws IOException {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		byte[] buffer = new byte[256];
		int len;
		while((len=is.read(buffer))!=-1)
			baos.write(buffer, 0, len);
		String json = new String(baos.toByteArray());
		log.debug(String.format("Visura Json:%s", json));
		
		return json;
	}
	
	//@SuppressWarnings("unchecked")
	public Response getVisuraByPartitaIvaCodiceFiscale(String codiceFiscalePartitaIva) {
		Response result = null;
		try {
			if (authorization==null || expirationDate.getTime()<System.currentTimeMillis()) {
				refreshToken();
			}
			                          
			URL urlForVisura=new URL(String.format("%s/true/%s/%s", visuraServiceURL, codiceFiscalePartitaIva, visuraServiceEncrKey));
			HttpURLConnection httpURLConnectionForVisura = (HttpURLConnection)urlForVisura.openConnection();
			httpURLConnectionForVisura.setRequestMethod("GET");
			httpURLConnectionForVisura.setDoOutput(true);
			httpURLConnectionForVisura.setUseCaches(false);
			httpURLConnectionForVisura.setConnectTimeout(60000);
			httpURLConnectionForVisura.setReadTimeout(60000);
			httpURLConnectionForVisura.addRequestProperty("Authorization", authorization);
			httpURLConnectionForVisura.addRequestProperty("accept", "*/*");
			httpURLConnectionForVisura.setRequestProperty("Content-Type", "application/json");
			int responseCode = ((HttpURLConnection) httpURLConnectionForVisura).getResponseCode();
			log.debug(String.format("Response Code: %s", responseCode));
			if (responseCode != 200) {
				String jsonError = getJsonFromStream(httpURLConnectionForVisura.getErrorStream());
			} else {
				String json = getJsonFromStream(httpURLConnectionForVisura.getInputStream());
				GsonBuilder gsonBuilder=new GsonBuilder();
				gsonBuilder.setDateFormat("dd/MM/yyyy");
				Gson gson=gsonBuilder.create();
				result=gson.fromJson(json,Response.class);
				//result=readAllObjectProperties(result);
			}
		} catch (MalformedURLException e) {
			log.error(e.getMessage(), e);
		} catch (ProtocolException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		catch (Exception ee) {
			log.error(ee.getMessage(), ee);
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public <T> T readAllObjectProperties(T t) {
		if (t!=null) {
			try {
				BeanInfo beanInfo=Introspector.getBeanInfo(t.getClass());
				PropertyDescriptor[] properties=beanInfo.getPropertyDescriptors();
				for(PropertyDescriptor property:properties) {
					Class c=property.getReadMethod().getReturnType();
					if (property.getWriteMethod()!=null) {
						if (c!=Date.class && c!=String.class) {
							Object o = property.getReadMethod().invoke(t, new Object[] {});
							if (o!=null) {
								if (c==List.class) {
									List l = (List)o;
									for(Object obj:l) {
										readAllObjectProperties(obj);
									}
								}else {
									o=readAllObjectProperties(o);
								}
								property.getWriteMethod().invoke(t, new Object[] {o});
							}
						}
					}
				}
			} catch (IntrospectionException e) {
				log.error(e.getMessage(), e);
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(), e);
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage(), e);
			} catch (InvocationTargetException e) {
				log.error(e.getMessage(), e);
			}
		}
		return t;
	}

	@Override
	public VisuraImpresa getVisura(String partitaIva) {
		VisuraImpresa visuraDto = null;
		
		Response visuraRuparResponse = getVisuraByPartitaIvaCodiceFiscale(partitaIva);
		if (visuraRuparResponse != null)
		{
			visuraDto = new VisuraImpresa();
			visuraDto.setCodice(visuraRuparResponse.getCodice());
			visuraDto.setMessaggio(visuraRuparResponse.getMessaggio());
			
			if (visuraRuparResponse.getCodice().equals("OK")) {
				if (visuraRuparResponse.getResult() != null){
					if (visuraRuparResponse.getResult().getDatiIdentificativi() != null){
						visuraDto.setDenominazione(visuraRuparResponse.getResult().getDatiIdentificativi().getDenominazione());
						visuraDto.setCodiceFiscale(visuraRuparResponse.getResult().getDatiIdentificativi().getCodiceFiscale());
						visuraDto.setPartitaIva(visuraRuparResponse.getResult().getDatiIdentificativi().getPartitaIva());
						visuraDto.setFormaGiuridica(String.format("%S (%S)", 
								visuraRuparResponse.getResult().getDatiIdentificativi().getFormaGiuridica().getValue(),
								visuraRuparResponse.getResult().getDatiIdentificativi().getFormaGiuridica().getCodice()));
						visuraDto.setDenominazione(visuraRuparResponse.getResult().getDatiIdentificativi().getDenominazione());
						visuraDto.setPec(visuraRuparResponse.getResult().getDatiIdentificativi().getIndirizzoPostaCertificata());
						visuraDto.setSede(new SedeImpresa());
						visuraDto.getSede().setCap(visuraRuparResponse.getResult().getDatiIdentificativi().getIndirizzoLocalizzazione().getCap());
						visuraDto.getSede().setComune(visuraRuparResponse.getResult().getDatiIdentificativi().getIndirizzoLocalizzazione().getComune());
						visuraDto.getSede().setProvincia(visuraRuparResponse.getResult().getDatiIdentificativi().getIndirizzoLocalizzazione().getProvincia());
						visuraDto.getSede().setIndirizzo(String.format("%S %S %s", 
								visuraRuparResponse.getResult().getDatiIdentificativi().getIndirizzoLocalizzazione().getToponimo(),
								visuraRuparResponse.getResult().getDatiIdentificativi().getIndirizzoLocalizzazione().getVia(),
								visuraRuparResponse.getResult().getDatiIdentificativi().getIndirizzoLocalizzazione().getNumeroCivico()));
					}
					
					if (visuraRuparResponse.getResult().getInfoAttivita() != null){
						if (visuraRuparResponse.getResult().getInfoAttivita().getClassificazioniAteco() != null){
							if (visuraRuparResponse.getResult().getInfoAttivita().getClassificazioniAteco().getClassificazioneAteco() != null){
								visuraDto.setCodiciAteco(new ArrayList<String>());
								for (ClassificazioneAteco ateco : visuraRuparResponse.getResult().getInfoAttivita().getClassificazioniAteco().getClassificazioneAteco()) {
									log.debug(String.format("%s-%S", ateco.getCodiceAttivita(), ateco.getAttivita()));
									visuraDto.getCodiciAteco().add(String.format("%s-%S", ateco.getCodiceAttivita(), ateco.getAttivita()));
								}
							}
						}
					}
					
					if (visuraRuparResponse.getResult().getPersoneSede() != null){
						log.debug("------------------------------------------------------------------------------------------------");
						log.debug(String.format("PersoneSede :: %s", visuraRuparResponse.getResult().getPersoneSede().toString()));
						log.debug("------------------------------------------------------------------------------------------------");
						if (visuraRuparResponse.getResult().getPersoneSede().getPersona() != null){
							visuraDto.setRappresentanti(new ArrayList<RappresentanteLegale>());
							for (Persona persona : visuraRuparResponse.getResult().getPersoneSede().getPersona()) {
								log.debug(String.format("%S %S", persona.getPersonaFisica().getCognome(), persona.getPersonaFisica().getNome()));
								if (persona.getAttiConferimentoCariche()!= null) {
									for (AttoConferimentoCariche atto : persona.getAttiConferimentoCariche().getAttoConferimentoCariche()) {
										if (atto.getPoteriPersona()!= null) {
											RappresentanteLegale rappresentante = new RappresentanteLegale();
											log.debug(String.format("%S %S", 
													persona.getPersonaFisica().getCognome(), 
													persona.getPersonaFisica().getNome()));
											rappresentante.setNominativo(String.format("%S %S", 
													persona.getPersonaFisica().getCognome(), 
													persona.getPersonaFisica().getNome()));
											rappresentante.setCodiceFiscale(persona.getPersonaFisica().getCodiceFiscale());
											log.debug(persona.getPersonaFisica().getCodiceFiscale());
											if (atto.getCariche()!= null) {
												if (atto.getCariche().getCarica() != null) {
													/*rappresentante.setCaricaRicoperta(String.format("%S (%S)", 
															atto.getCariche().getCarica().getValue(), 
															atto.getCariche().getCarica().getCodiceCarica()));*/
													rappresentante.setCaricaRicoperta(String.format("%S", atto.getCariche().getCarica().getValue()));
													log.debug(String.format("%S (%S)", 
															atto.getCariche().getCarica().getValue(), 
															atto.getCariche().getCarica().getCodiceCarica()));
												}
											}
											visuraDto.getRappresentanti().add(rappresentante);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return visuraDto;
	}
	
	

}
