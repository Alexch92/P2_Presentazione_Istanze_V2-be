package it.osapulie.web.portlet.util;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component( "fileUploadValidator" )
public class FileUploadValidator implements Validator {
	
	@Override
	public boolean supports( Class<?> clazz ) {
		return UploadItem.class.isAssignableFrom( clazz );
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate( Object target, Errors errors) {
		UploadItem upload = (UploadItem) target;
		
		if (upload.isRitiro()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motivoRitiro", "NotEmpty.field.required");
		}
		
		MultipartFile generatedfile = upload.getFile();
		
		if(generatedfile == null || generatedfile.isEmpty()){
			errors.rejectValue("file", "NotEmpty.field.required");
		}
		try {
			if(generatedfile != null && !generatedfile.isEmpty()){
				//String verifica = SignatureManager.checkPkcs7Signature(generatedfile.getBytes(), null, null, upload.getCodiceFiscale(), true);
				String verifica = SignatureManager.checkPadesSignature(generatedfile.getBytes(), upload.getCodiceFiscale());
				
				if (verifica != "OK")
					errors.rejectValue("file", "error.checkPkcs7Signature", verifica);
					//errors.rejectValue("file", verifica);
			}
		}
		catch (IOException ioe) {
			errors.rejectValue("file", "error.fileUpload");
		}
			
		
	}
}
