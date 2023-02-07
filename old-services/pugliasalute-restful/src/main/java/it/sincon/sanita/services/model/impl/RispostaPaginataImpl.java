package it.sincon.sanita.services.model.impl;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import it.sincon.sanita.services.model.RispostaPaginata;
import it.sincon.sanita.services.model.StrutturaSanitaria;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

/**
 * The extended model implementation for the StrutturaSanitaria service. Represents a row in the &quot;StrutturaSanitaria&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.sincon.sanita.services.model.StrutturaSanitaria} interface.
 * </p>
 *
 * @author Sincon
 * @param <T>
 */
@JsonIgnoreProperties({ "expandoBridge", "expandoBridgeAttributes","cachedModel","escapedModel","modelAttributes","modelClass","modelClassName","new","primaryKey","primaryKeyObj" })
public class RispostaPaginataImpl<T> extends RispostaPaginataModelImpl<T> implements RispostaPaginata<T> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a struttura sanitaria model instance should use the {@link it.sincon.sanita.services.model.StrutturaSanitaria} interface instead.
     */
    public RispostaPaginataImpl() {
    }
    
    public RispostaPaginataImpl(int _start, int _numRes, List<T> _items, boolean eseguiPaginazione) {
    	
    	if (eseguiPaginazione){
    		// Restituisco i risultati voluti come da parametri di request....
    		if (_start > _items.size())
    			_start = _items.size();
    		int stop = _start + _numRes;
    		if (stop > _items.size())
    			stop = _items.size();

    		LinkedList<T> myItems = new LinkedList<T>();
    		for (int idx=_start; idx < stop; idx++){
    			myItems.addLast(_items.get(idx));
    		}

    		setStart(_start);
    		setNumFound(_items.size());
    		setData(myItems);
    		
    		// A questo punto l'array _items non mi serve più, lo imposto a null...
    		_items = null;
    	}
    	else{
    		setStart(_start);
    		setNumFound(_numRes);
    		setData(_items);
    	}
    }
    
    @JsonIgnore
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
    	super.setExpandoBridgeAttributes(serviceContext);
    }

	@JsonIgnore
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		super.setExpandoBridgeAttributes(baseModel);
	}

	@JsonIgnore
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		super.setExpandoBridgeAttributes(expandoBridge);
	}
	@Override
	public void persist() throws SystemException {
		// TODO Auto-generated method stub
		
	}
}
