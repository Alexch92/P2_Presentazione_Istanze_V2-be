package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StrutturaSanitariaFiglia}.
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitariaFiglia
 * @generated
 */
public class StrutturaSanitariaFigliaWrapper implements StrutturaSanitariaFiglia,
    ModelWrapper<StrutturaSanitariaFiglia> {
    private StrutturaSanitariaFiglia _strutturaSanitariaFiglia;

    public StrutturaSanitariaFigliaWrapper(
        StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        _strutturaSanitariaFiglia = strutturaSanitariaFiglia;
    }

    @Override
    public Class<?> getModelClass() {
        return StrutturaSanitariaFiglia.class;
    }

    @Override
    public String getModelClassName() {
        return StrutturaSanitariaFiglia.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("idStrutturaFiglia", getIdStrutturaFiglia());
        attributes.put("tipoStruttura", getTipoStruttura());
        attributes.put("denominazione", getDenominazione());
        attributes.put("indirizzo", getIndirizzo());
        attributes.put("direttore", getDirettore());
        attributes.put("responsabileSanitario", getResponsabileSanitario());
        attributes.put("telefono", getTelefono());
        attributes.put("email", getEmail());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long idStrutturaFiglia = (Long) attributes.get("idStrutturaFiglia");

        if (idStrutturaFiglia != null) {
            setIdStrutturaFiglia(idStrutturaFiglia);
        }

        String tipoStruttura = (String) attributes.get("tipoStruttura");

        if (tipoStruttura != null) {
            setTipoStruttura(tipoStruttura);
        }

        String denominazione = (String) attributes.get("denominazione");

        if (denominazione != null) {
            setDenominazione(denominazione);
        }

        String indirizzo = (String) attributes.get("indirizzo");

        if (indirizzo != null) {
            setIndirizzo(indirizzo);
        }

        String direttore = (String) attributes.get("direttore");

        if (direttore != null) {
            setDirettore(direttore);
        }

        String responsabileSanitario = (String) attributes.get(
                "responsabileSanitario");

        if (responsabileSanitario != null) {
            setResponsabileSanitario(responsabileSanitario);
        }

        String telefono = (String) attributes.get("telefono");

        if (telefono != null) {
            setTelefono(telefono);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }
    }

    /**
    * Returns the primary key of this struttura sanitaria figlia.
    *
    * @return the primary key of this struttura sanitaria figlia
    */
    @Override
    public long getPrimaryKey() {
        return _strutturaSanitariaFiglia.getPrimaryKey();
    }

    /**
    * Sets the primary key of this struttura sanitaria figlia.
    *
    * @param primaryKey the primary key of this struttura sanitaria figlia
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _strutturaSanitariaFiglia.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the id struttura figlia of this struttura sanitaria figlia.
    *
    * @return the id struttura figlia of this struttura sanitaria figlia
    */
    @Override
    public long getIdStrutturaFiglia() {
        return _strutturaSanitariaFiglia.getIdStrutturaFiglia();
    }

    /**
    * Sets the id struttura figlia of this struttura sanitaria figlia.
    *
    * @param idStrutturaFiglia the id struttura figlia of this struttura sanitaria figlia
    */
    @Override
    public void setIdStrutturaFiglia(long idStrutturaFiglia) {
        _strutturaSanitariaFiglia.setIdStrutturaFiglia(idStrutturaFiglia);
    }

    /**
    * Returns the tipo struttura of this struttura sanitaria figlia.
    *
    * @return the tipo struttura of this struttura sanitaria figlia
    */
    @Override
    public java.lang.String getTipoStruttura() {
        return _strutturaSanitariaFiglia.getTipoStruttura();
    }

    /**
    * Sets the tipo struttura of this struttura sanitaria figlia.
    *
    * @param tipoStruttura the tipo struttura of this struttura sanitaria figlia
    */
    @Override
    public void setTipoStruttura(java.lang.String tipoStruttura) {
        _strutturaSanitariaFiglia.setTipoStruttura(tipoStruttura);
    }

    /**
    * Returns the denominazione of this struttura sanitaria figlia.
    *
    * @return the denominazione of this struttura sanitaria figlia
    */
    @Override
    public java.lang.String getDenominazione() {
        return _strutturaSanitariaFiglia.getDenominazione();
    }

    /**
    * Sets the denominazione of this struttura sanitaria figlia.
    *
    * @param denominazione the denominazione of this struttura sanitaria figlia
    */
    @Override
    public void setDenominazione(java.lang.String denominazione) {
        _strutturaSanitariaFiglia.setDenominazione(denominazione);
    }

    /**
    * Returns the indirizzo of this struttura sanitaria figlia.
    *
    * @return the indirizzo of this struttura sanitaria figlia
    */
    @Override
    public java.lang.String getIndirizzo() {
        return _strutturaSanitariaFiglia.getIndirizzo();
    }

    /**
    * Sets the indirizzo of this struttura sanitaria figlia.
    *
    * @param indirizzo the indirizzo of this struttura sanitaria figlia
    */
    @Override
    public void setIndirizzo(java.lang.String indirizzo) {
        _strutturaSanitariaFiglia.setIndirizzo(indirizzo);
    }

    /**
    * Returns the direttore of this struttura sanitaria figlia.
    *
    * @return the direttore of this struttura sanitaria figlia
    */
    @Override
    public java.lang.String getDirettore() {
        return _strutturaSanitariaFiglia.getDirettore();
    }

    /**
    * Sets the direttore of this struttura sanitaria figlia.
    *
    * @param direttore the direttore of this struttura sanitaria figlia
    */
    @Override
    public void setDirettore(java.lang.String direttore) {
        _strutturaSanitariaFiglia.setDirettore(direttore);
    }

    /**
    * Returns the responsabile sanitario of this struttura sanitaria figlia.
    *
    * @return the responsabile sanitario of this struttura sanitaria figlia
    */
    @Override
    public java.lang.String getResponsabileSanitario() {
        return _strutturaSanitariaFiglia.getResponsabileSanitario();
    }

    /**
    * Sets the responsabile sanitario of this struttura sanitaria figlia.
    *
    * @param responsabileSanitario the responsabile sanitario of this struttura sanitaria figlia
    */
    @Override
    public void setResponsabileSanitario(java.lang.String responsabileSanitario) {
        _strutturaSanitariaFiglia.setResponsabileSanitario(responsabileSanitario);
    }

    /**
    * Returns the telefono of this struttura sanitaria figlia.
    *
    * @return the telefono of this struttura sanitaria figlia
    */
    @Override
    public java.lang.String getTelefono() {
        return _strutturaSanitariaFiglia.getTelefono();
    }

    /**
    * Sets the telefono of this struttura sanitaria figlia.
    *
    * @param telefono the telefono of this struttura sanitaria figlia
    */
    @Override
    public void setTelefono(java.lang.String telefono) {
        _strutturaSanitariaFiglia.setTelefono(telefono);
    }

    /**
    * Returns the email of this struttura sanitaria figlia.
    *
    * @return the email of this struttura sanitaria figlia
    */
    @Override
    public java.lang.String getEmail() {
        return _strutturaSanitariaFiglia.getEmail();
    }

    /**
    * Sets the email of this struttura sanitaria figlia.
    *
    * @param email the email of this struttura sanitaria figlia
    */
    @Override
    public void setEmail(java.lang.String email) {
        _strutturaSanitariaFiglia.setEmail(email);
    }

    @Override
    public boolean isNew() {
        return _strutturaSanitariaFiglia.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _strutturaSanitariaFiglia.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _strutturaSanitariaFiglia.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _strutturaSanitariaFiglia.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _strutturaSanitariaFiglia.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _strutturaSanitariaFiglia.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _strutturaSanitariaFiglia.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _strutturaSanitariaFiglia.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _strutturaSanitariaFiglia.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _strutturaSanitariaFiglia.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _strutturaSanitariaFiglia.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new StrutturaSanitariaFigliaWrapper((StrutturaSanitariaFiglia) _strutturaSanitariaFiglia.clone());
    }

    @Override
    public int compareTo(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        return _strutturaSanitariaFiglia.compareTo(strutturaSanitariaFiglia);
    }

    @Override
    public int hashCode() {
        return _strutturaSanitariaFiglia.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> toCacheModel() {
        return _strutturaSanitariaFiglia.toCacheModel();
    }

    @Override
    public it.sincon.sanita.services.model.StrutturaSanitariaFiglia toEscapedModel() {
        return new StrutturaSanitariaFigliaWrapper(_strutturaSanitariaFiglia.toEscapedModel());
    }

    @Override
    public it.sincon.sanita.services.model.StrutturaSanitariaFiglia toUnescapedModel() {
        return new StrutturaSanitariaFigliaWrapper(_strutturaSanitariaFiglia.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _strutturaSanitariaFiglia.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _strutturaSanitariaFiglia.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _strutturaSanitariaFiglia.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StrutturaSanitariaFigliaWrapper)) {
            return false;
        }

        StrutturaSanitariaFigliaWrapper strutturaSanitariaFigliaWrapper = (StrutturaSanitariaFigliaWrapper) obj;

        if (Validator.equals(_strutturaSanitariaFiglia,
                    strutturaSanitariaFigliaWrapper._strutturaSanitariaFiglia)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public StrutturaSanitariaFiglia getWrappedStrutturaSanitariaFiglia() {
        return _strutturaSanitariaFiglia;
    }

    @Override
    public StrutturaSanitariaFiglia getWrappedModel() {
        return _strutturaSanitariaFiglia;
    }

    @Override
    public void resetOriginalValues() {
        _strutturaSanitariaFiglia.resetOriginalValues();
    }
}
