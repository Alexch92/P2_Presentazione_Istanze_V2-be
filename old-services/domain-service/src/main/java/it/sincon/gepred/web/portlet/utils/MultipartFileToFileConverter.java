package it.sincon.gepred.web.portlet.utils;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MultipartFileToFileConverter implements
		Converter<CommonsMultipartFile, File> {

	private static Logger log = LoggerFactory.getLogger( MultipartFileToFileConverter.class );
	
//	@Override
//	public File convert(CommonsMultipartFile source) {
//		
//		if(!source.isEmpty()){
//			String fileName = source.getOriginalFilename();
//			String split[] = fileName.split("\\.");
//			String extension = split[split.length-1];
//			File dir = new File(source.getOriginalFilename());
//			dir.mkdirs();
//			try {
//				File file = File.createTempFile("Temp", "."+extension, dir);
//				FileCopyUtils.copy(source.getBytes(), file);
//				log.debug(String.format("file creato. File name=%s; parent=%s", 
//						file.getName(), file.getParent()));
//				return file;
//			} catch (IOException e) {
//				//e.printStackTrace();
//				log.error(e.getMessage(), e);
//			}
//		}
//		return null;
//	}
	
	@Override
	public File convert(CommonsMultipartFile source) {
		if (!source.isEmpty()){
			File file = new File(ServiceHelper.createDir()+source.getOriginalFilename());
			try {
				FileCopyUtils.copy(source.getBytes(), file);
				log.debug(String.format("file creato. File name=%s; path=%s",	file.getName(), file.getAbsolutePath()));
				return file;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
