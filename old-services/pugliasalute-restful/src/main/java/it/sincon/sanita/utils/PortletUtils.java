package it.sincon.sanita.utils;


import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.SerializationUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;



public class PortletUtils {
	private static Logger log = LoggerFactory.getLogger( PortletUtils.class );

	/**
	 * Invia una request in post e restituisce la response come String
	 * @param input
	 * @param token
	 * @param urlTo
	 * @param useAuth
	 * @return
	 * @throws Exception
	 */
	public static String sendRequestHTTPPost(String input,String token,String urlTo,boolean useAuth,String auth) throws Exception {

		String res="";
		try{
			//String url2 = "https://idserver3.azurewebsites.net/idstravel/connect/token";
			URL url = new URL(urlTo);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true); 
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if(useAuth){
				if(token == null)
					conn.setRequestProperty("Authorization", auth);
				else
					conn.setRequestProperty("Authorization", "Bearer "+token);
			}
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				res = res + output;
			}

			conn.disconnect();
			//System.out.println("res="+res);

		} catch (MalformedURLException e) {
			log.error("ERROR: "+e.getLocalizedMessage());
			e.printStackTrace();
			throw new Exception(e);

		} catch (IOException e) {
			log.error("ERROR: "+e.getLocalizedMessage());
			e.printStackTrace();
			throw new Exception(e);

		}
		return res;
	}

	/**
	 * Invia una request in post e restituisce la response come byteArray
	 * @param input
	 * @param token
	 * @param urlTo
	 * @return
	 * @throws Exception
	 */
	public static byte[] sendRequestHTTPPost(String input,String token,String urlTo) throws Exception {

		OutputStream res=null;
		try{
			URL url = new URL(urlTo);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true); 
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes("UTF-8"));
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			// recupero la response come bytearray
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			res=new ByteArrayOutputStream();
			IOUtils.copy(conn.getInputStream(), res);

			conn.disconnect();

		} catch (MalformedURLException e) {
			log.error("ERROR: "+e.getLocalizedMessage());
			e.printStackTrace();
			throw new Exception(e);

		} catch (IOException e) {
			log.error("ERROR: "+e.getLocalizedMessage());
			e.printStackTrace();
			throw new Exception(e);
		}
		return ((ByteArrayOutputStream) res).toByteArray();
	}
	
	public static byte[] sendRequestHTTPGet_toByteArray(String token,String urlTo)throws Exception {
		
		OutputStream res=null;
		try{
			//String url2 = "https://mobiledriver.marozzivt.it/ricerca/partenza";
		    URL url = new URL(urlTo.replaceAll(" ", "%20"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(token != null)
				conn.setRequestProperty("Authorization" , "Bearer " + token);

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	 
			// recupero la response come bytearray
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			res=new ByteArrayOutputStream();
			IOUtils.copy(conn.getInputStream(), res);

			conn.disconnect();
		} catch (MalformedURLException e) {
			log.error("ERROR: "+e.getLocalizedMessage());
			e.printStackTrace();
			throw new Exception(e);

		} catch (IOException e) {
			log.error("ERROR: "+e.getLocalizedMessage());
			e.printStackTrace();
			throw new Exception(e);
		}
		return ((ByteArrayOutputStream) res).toByteArray();
	}

	public static String sendRequestHTTPGet(String token,String urlTo)throws Exception {
		
		String res="";
		try{
			//String url2 = "https://mobiledriver.marozzivt.it/ricerca/partenza";
		    URL url = new URL(urlTo.replaceAll(" ", "%20"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(token != null)
				conn.setRequestProperty("Authorization" , "Bearer " + token);

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				res = res + output;
			}
	 
			conn.disconnect();

			
	    } catch (MalformedURLException e) {
	    	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		 }
		return res;
	}

	public static <TR> String convertToJson(TR object, String[] propertiesToBeIncluded, String[] propertiesExcluded, String[][] replaceMap) throws IOException {
		log.debug("listToJson :: Entering Method");

		JSONSerializer serializer = new JSONSerializer();
		StringBuilder builder = new StringBuilder();
		String result;

		// Exclusions....
		if (propertiesExcluded!=null && propertiesExcluded.length!= 0){
			for (String toBeExcluded : propertiesExcluded){
				serializer.exclude(toBeExcluded);
			}
		}
		// Inclusions....
		if (propertiesToBeIncluded!=null && propertiesToBeIncluded.length!= 0){
			for (String toBeIncluded : propertiesToBeIncluded){
				serializer.include(toBeIncluded);
			}
		}
		serializer.deepSerialize(object, builder);

		// 
		result = builder.toString();
		if(replaceMap != null){
			for (String [] item : replaceMap){
				result = result.replaceAll(item[0], item[1]);
			}
		}

		log.debug("convertToJson :: Result JSON string: " + result);

		return result;
	}
	
	public static <TR> String convertToJson(TR object,Map<String, String> datePropertiesFormats, String[] propertiesToBeIncluded, String[] propertiesExcluded, String[][] replaceMap) throws IOException {
		log.debug("listToJson :: Entering Method");

		JSONSerializer serializer = new JSONSerializer();
		StringBuilder builder = new StringBuilder();
		String result;

		// Exclusions....
		if (propertiesExcluded!=null && propertiesExcluded.length!= 0){
			for (String toBeExcluded : propertiesExcluded){
				serializer.exclude(toBeExcluded);
			}
		}
		// Inclusions....
		if (propertiesToBeIncluded!=null && propertiesToBeIncluded.length!= 0){
			for (String toBeIncluded : propertiesToBeIncluded){
				serializer.include(toBeIncluded);
			}
		}
		
		// Gestiojne dei formati per le date...
		for(Entry<String, String> item : datePropertiesFormats.entrySet()){
			serializer.transform(new DateTransformer(item.getValue()), item.getKey());
		}
		
		serializer.deepSerialize(object, builder);

		// 
		result = builder.toString();
		if(replaceMap != null){
			for (String [] item : replaceMap){
				result = result.replaceAll(item[0], item[1]);
			}
		}

		log.debug("convertToJson :: Result JSON string: " + result);

		return result;
	}

	public static String generateCheckSum(byte[] buffer) {

		try {
			// Get an MD5 implementation of MessageDigest
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// pass data read from file to digest for processing
			digest.update( buffer );
			// Get the MD5 sum
			byte[] md5sum = digest.digest();
			// (Optionally) convert the MD5 byte array to a hex string
			BigInteger bigInt = new BigInteger(1, md5sum);
			String output = bigInt.toString(16);
			while(output.length() < 32 ){
				output = "0"+output;
			}
			System.out.println("MD5: " + output);
			return output;
		}
		catch(NoSuchAlgorithmException e) {
			throw new RuntimeException("Algoritmo MD5 non trovato", e);
		}		
	}

	

	@SuppressWarnings("unchecked")
	public static <T> T cloneObject(T objectToClone) {
		T result = (T)SerializationUtils.deserialize(SerializationUtils.serialize(objectToClone));
		return result;
	}

	/**
	 * Copy the property values of the given source bean into the given target bean.
	 * <p>Note: The source and target classes do not have to match or even be derived
	 * from each other, as long as the properties match. Any bean properties that the
	 * source bean exposes but the target bean does not will silently be ignored.
	 * @param source the source bean
	 * @param target the target bean
	 * @param editable the class (or interface) to restrict property setting to
	 * @param ignoreProperties array of property names to ignore
	 * @throws BeansException if the copying failed
	 * @see BeanWrapper
	 */
	public static void copyProperties(Object source, Object target, Class<?> editable, String[] ignoreProperties)
			throws BeansException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		//log.info("copy object of type "+source.getClass().getName()+" to type "+target.getClass().getName());

		Class<?> actualEditable = target.getClass();
		//		System.out.println("Copy properties START - actualEditable="+actualEditable.getName());
		if (editable != null) {
			//			System.out.println("editable="+editable.getName());
			if (!editable.isInstance(target)) {
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
						"] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
		//		System.out.println("targetPds.length="+targetPds.length);
		List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

		for (PropertyDescriptor targetPd : targetPds) {
			//			System.out.println("considero la proprietà "+targetPd.getName());
			if ((targetPd.getWriteMethod() != null || List.class.isAssignableFrom(targetPd.getPropertyType())) && 
					(ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
				PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					if(BeanUtils.isSimpleProperty(targetPd.getPropertyType())){
						try {
							//							System.out.println("copy simple property "+targetPd.getName());
							Method readMethod = sourcePd.getReadMethod();
							if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
						catch (Throwable ex) {
							throw new FatalBeanException("Could not copy simple properties from source to target: "+targetPd.getName(), ex);
						}
					}
					else{
						try {
							//							System.out.println("copy property: "+targetPd.getName()+" tipo: "+targetPd.getPropertyType());
							if(!List.class.isAssignableFrom(targetPd.getPropertyType())){
								//								System.out.println("!sono in List"+targetPd.getPropertyType().getName());
								if (targetPd.getPropertyType().equals(Calendar.class)){
									//									System.out.println("Gestione ad hoc per target di tipo java.util.Calendar....");

									Method readMethod = sourcePd.getReadMethod();
									if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
										readMethod.setAccessible(true);
									}
									Calendar sourceCal = (Calendar) readMethod.invoke(source);  

									Calendar targetCal = Calendar.getInstance();
									targetCal.setTime(sourceCal.getTime());

									Method writeMethod = targetPd.getWriteMethod();
									if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
										writeMethod.setAccessible(true);
									}
									writeMethod.invoke(target, targetCal);
								}
								else{
									Object obj = targetPd.getPropertyType().newInstance();
									Method readMethod = sourcePd.getReadMethod();
									if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
										readMethod.setAccessible(true);
									}
									Object value = readMethod.invoke(source);
									if (value!=null) {
										copyProperties(value,obj,null,ignoreProperties);
										Method writeMethod = targetPd.getWriteMethod();
										if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
											writeMethod.setAccessible(true);
										}
										writeMethod.invoke(target, obj);
									}
								}
							}else{
								Method readMethod = sourcePd.getReadMethod();
								if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
									readMethod.setAccessible(true);
								}
								Field stringListField = actualEditable.getDeclaredField(targetPd.getName());
								ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
								Class<?> listClass = (Class<?>) stringListType.getActualTypeArguments()[0];
								List<Object> list = new ArrayList<Object>();

								List value = (List)readMethod.invoke(source);
								if (value!=null) {
									for (Object ob : value) {
										Object o = listClass.newInstance();
										copyProperties(ob,o,null,ignoreProperties);
										list.add(o);
									}

									if(targetPd.getWriteMethod() != null){
										Method writeMethod = targetPd.getWriteMethod();
										if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
											writeMethod.setAccessible(true);
										}
										writeMethod.invoke(target, list);
									}else{
										Method read = targetPd.getReadMethod();
										if (!Modifier.isPublic(read.getDeclaringClass().getModifiers())) {
											read.setAccessible(true);
										}
										List listaTarget = (List)read.invoke(target);
										listaTarget.addAll(list);
									}
								}
							}
						}
						catch (Throwable ex) {
							throw new FatalBeanException("Could not copy properties from source to target: "+targetPd.getName(), ex);
						}
					}
				}
			}
			//			else{
			//				System.out.println(String.format("Proprietà %s SCARTATA !! targetPd.getWriteMethod()=%s",
			//						targetPd.getName(),
			//						targetPd.getWriteMethod()==null ? "NULL" : targetPd.getWriteMethod().getName()));
			//			}
		}
	}
	
	public static String filterString(String string){
		String result = string.replaceAll("-", "").substring(0, 8);;
		return result;
	}
	
	/** 
	 * Given a key / value mapping, create and return a URI formatted query string that is valid and can be appended to a URI.
	 * @param options The Mapping that will create the new Query string.
	 * @return a URI formatted query string.
	 * @throws URISyntaxException
	 */
	public static String createQueryString(Map<String,String> options) throws URISyntaxException {
		try {
			if (options.size() > 0) {
				StringBuffer rc=new StringBuffer();
				boolean first=true;
				for (String key : options.keySet()) {
					if (first) {
						first=false;
					}
					else {
						rc.append("&");
					}
					String value=(String)options.get(key);
					rc.append(URLEncoder.encode(key,"UTF-8"));
					rc.append("=");
					rc.append(URLEncoder.encode(value,"UTF-8"));
				}
				return rc.toString();
			}
			else {
				return "";
			}
		}
		catch (  UnsupportedEncodingException e) {
			throw (URISyntaxException)new URISyntaxException(e.toString(),"Invalid encoding").initCause(e);
		}
	}
	
	public static Date getLastSunday( int month, int year ) {
		Calendar cal = Calendar.getInstance();
		cal.set( year, month, 1 );
		cal.add(Calendar.DATE, -1); 
		cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) - 1 ) );
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
    }

	public static String getTimeZoneLabelFromDate(Date date){
		String result = null;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int nextYear = year+1;
		Date inizioOraLegaleAnnoCorrente = getLastSunday(3, year);
		Date fineOraLegaleAnnoCorrente = getLastSunday(10, year);
		Date inizioOraLegaleAnnoSuccessivo = getLastSunday(3, nextYear);
		Date fineOraLegaleAnnoSuccessivo=getLastSunday(10,nextYear);
		if (date.before(inizioOraLegaleAnnoCorrente))
			result="solare";
		else if (date.before(fineOraLegaleAnnoCorrente))
			result = "legale";
		else if (date.before(inizioOraLegaleAnnoSuccessivo))
			result = "solare";
		else if (date.before(fineOraLegaleAnnoSuccessivo))
			result = "legale";
		else
			result = "solare";
		return result;
	}

	public static String getTimeZoneLabelFromDateString(String dateString){
		String result = null;
		int year = Integer.parseInt(dateString.substring(0, 4));
		Date inizioOraLegaleAnnoCorrente = getLastSunday(3, year);
		Date fineOraLegaleAnnoCorrente = getLastSunday(10, year);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (dateString.compareTo(df.format(inizioOraLegaleAnnoCorrente))<0)
			result="solare";
		else if (dateString.compareTo(df.format(fineOraLegaleAnnoCorrente))<0)
			result = "legale";
		else
			result = "solare";
		return result;
	}
	
	public static PortletURL createPortletUrlToExternalPortlet(PortletRequest request,PortletResponse response,String portletName,Map<String,String> portletParams,String portletPhase)
	{
		LiferayPortletResponse liferayPortletResponse = (LiferayPortletResponse)response;

		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);//liferayPortletRequest.getHttpServletRequest();
		ThemeDisplay themeDisplay = (ThemeDisplay)httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL portletURL = null;
		long plid = 0;
		try {
			log.info(String.format("portletname: %s", portletName));
			if (themeDisplay!= null){
				log.info(String.format("themeDisplay.getScopeGroupId(): %s", themeDisplay.getScopeGroupId()));
			}
			else
				log.info("ThemeDisplay is null");
			log.info(String.format("portletname: %s", portletName));
			
//			plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName);
			plid = themeDisplay.getPlid();
			portletURL = liferayPortletResponse.createLiferayPortletURL(plid, portletName, portletPhase);
			portletURL.setPortletMode(PortletMode.VIEW);
		} 
//		catch (PortalException e) {
//			log.error(e.getMessage(), e);
//		} catch (SystemException e) {
//			log.error(e.getMessage(), e);
//		} 
		catch(PortletModeException e) {
			log.error(e.getMessage(), e);
		}
		if (portletParams!=null){
			for(Map.Entry<String,String> row:portletParams.entrySet())
				portletURL.setParameter(row.getKey(),row.getValue());
		}
		return portletURL;

	}
}
