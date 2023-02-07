package it.sincon.sanita.services.model.impl;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

/**
 * The extended model implementation for the StrutturaSanitariaFiglia service. Represents a row in the &quot;SANITAREST_StrutturaSanitariaFiglia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.sincon.sanita.services.model.StrutturaSanitariaFiglia} interface.
 * </p>
 *
 * @author Sincon
 */
@JsonIgnoreProperties({ "expandoBridge", "expandoBridgeAttributes","cachedModel","escapedModel","modelAttributes","modelClass","modelClassName","new","primaryKey","primaryKeyObj" })
public class StrutturaSanitariaFigliaImpl
    extends StrutturaSanitariaFigliaBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a struttura sanitaria figlia model instance should use the {@link it.sincon.sanita.services.model.StrutturaSanitariaFiglia} interface instead.
     */
    public StrutturaSanitariaFigliaImpl() {
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
}
