package it.sincon.gepred.web.portlet.varie;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.sincon.gepred.web.portlet.varie.DatiRicercaUserLog;

/**
 * @author Eligio Cavallo - Sincon srl 
 * */
@Component("userLogValidator")
public class UserLogValidator implements Validator{

	public boolean supports(Class<?> classe) {
		return DatiRicercaUserLog.class.equals(classe);
	}

	public void validate(Object target, Errors error) {
    
	DatiRicercaUserLog datiRicercaUserLog = (DatiRicercaUserLog) target;

	ValidationUtils.rejectIfEmptyOrWhitespace(error, "filtroData_da", "NotEmpty.field.required");
	ValidationUtils.rejectIfEmptyOrWhitespace(error, "filtroData_a","NotEmpty.field.required");
	}
}
