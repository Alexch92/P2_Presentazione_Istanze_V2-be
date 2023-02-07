package it.osapulie.web.portlet.util;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;


public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.PropertyEditorRegistrar#registerCustomEditors(org.springframework.beans.PropertyEditorRegistry)
	 */
	@Override
	public void registerCustomEditors( PropertyEditorRegistry registry ) {
//		registry.registerCustomEditor( SecoloTradotto.class, new SecoloPropertyEditor() );
	}
}
