package it.sincon.gepred.web.portlet.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MultipartFileToMapConverter implements
Converter<CommonsMultipartFile, Map<String, Object>>{

	@Override
	public Map<String, Object> convert(CommonsMultipartFile source) {
		Map<String,Object> result = null;
		if (!source.isEmpty()){
			try{
				result = new HashMap<String, Object>();
				result.put(ServiceHelper.NOME_FILE, source.getOriginalFilename());
				result.put(ServiceHelper.CONTENT_FILE, source.getBytes());
				result.put(ServiceHelper.CONTENT_TYPE, source.getContentType());
				return result;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
