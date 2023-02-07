package it.sincon.sanita.utils;

import it.sincon.sanita.services.beans.atp.DatiAttoJAXB;

import java.lang.reflect.Field;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DatiAttoOrderByComparator extends OrderByComparator {
	private static Logger log = LoggerFactory.getLogger( DatiAttoOrderByComparator.class );
	
	private boolean _ascending;
	private String _propertyName;

	public DatiAttoOrderByComparator(String orderByCol, String orderByType){
		log.info(String.format("DatiAttoOrderByComparator new instance - OrderBy Column :%s - OrderBy Type:%s",
				orderByCol, orderByType));
		
		this._propertyName = orderByCol;
		
		if (orderByType.equals("desc")) 
			this._ascending = false;
		else
			this._ascending = true;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		Object val1 = getValue(obj1, this._propertyName);
		Object val2 = getValue(obj2, this._propertyName);

		int retValue = 0;
		

		if (val1 == null){
			retValue = -1;
		}else if (val2 == null){
			retValue = 1;
		}else{
			if (val1 instanceof Integer){
				retValue = ((Integer) val1).compareTo((Integer)val2);
			}else if (val1 instanceof String){
				retValue = ((String) val1).compareTo((String)val2);
			}else if (val1 instanceof Date){
				retValue = ((Date) val1).compareTo((Date)val2);
			}
		}
		
		if (retValue != 0 && !_ascending){
			retValue = -retValue;
		}
			
		return retValue;
	}
	
	private Object getValue(Object obj, String fieldName){
		Object value = null;
		
		try {
			Field field = DatiAttoJAXB.class.getDeclaredField(fieldName);
			value = field.get(obj);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return value;
	}

}
