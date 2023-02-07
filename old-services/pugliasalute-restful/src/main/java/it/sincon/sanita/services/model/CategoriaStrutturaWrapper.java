package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CategoriaStruttura}.
 * </p>
 *
 * @author Sincon
 * @see CategoriaStruttura
 * @generated
 */
public class CategoriaStrutturaWrapper implements CategoriaStruttura,
    ModelWrapper<CategoriaStruttura> {
    private CategoriaStruttura _categoriaStruttura;

    public CategoriaStrutturaWrapper(CategoriaStruttura categoriaStruttura) {
        _categoriaStruttura = categoriaStruttura;
    }

    @Override
    public Class<?> getModelClass() {
        return CategoriaStruttura.class;
    }

    @Override
    public String getModelClassName() {
        return CategoriaStruttura.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("idTipoStruttura", getIdTipoStruttura());
        attributes.put("denominazione", getDenominazione());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String idTipoStruttura = (String) attributes.get("idTipoStruttura");

        if (idTipoStruttura != null) {
            setIdTipoStruttura(idTipoStruttura);
        }

        String denominazione = (String) attributes.get("denominazione");

        if (denominazione != null) {
            setDenominazione(denominazione);
        }
    }

    /**
    * Returns the primary key of this categoria struttura.
    *
    * @return the primary key of this categoria struttura
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _categoriaStruttura.getPrimaryKey();
    }

    /**
    * Sets the primary key of this categoria struttura.
    *
    * @param primaryKey the primary key of this categoria struttura
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _categoriaStruttura.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the id tipo struttura of this categoria struttura.
    *
    * @return the id tipo struttura of this categoria struttura
    */
    @Override
    public java.lang.String getIdTipoStruttura() {
        return _categoriaStruttura.getIdTipoStruttura();
    }

    /**
    * Sets the id tipo struttura of this categoria struttura.
    *
    * @param idTipoStruttura the id tipo struttura of this categoria struttura
    */
    @Override
    public void setIdTipoStruttura(java.lang.String idTipoStruttura) {
        _categoriaStruttura.setIdTipoStruttura(idTipoStruttura);
    }

    /**
    * Returns the denominazione of this categoria struttura.
    *
    * @return the denominazione of this categoria struttura
    */
    @Override
    public java.lang.String getDenominazione() {
        return _categoriaStruttura.getDenominazione();
    }

    /**
    * Sets the denominazione of this categoria struttura.
    *
    * @param denominazione the denominazione of this categoria struttura
    */
    @Override
    public void setDenominazione(java.lang.String denominazione) {
        _categoriaStruttura.setDenominazione(denominazione);
    }

    @Override
    public boolean isNew() {
        return _categoriaStruttura.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _categoriaStruttura.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _categoriaStruttura.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _categoriaStruttura.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _categoriaStruttura.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _categoriaStruttura.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _categoriaStruttura.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _categoriaStruttura.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _categoriaStruttura.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _categoriaStruttura.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _categoriaStruttura.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CategoriaStrutturaWrapper((CategoriaStruttura) _categoriaStruttura.clone());
    }

    @Override
    public int compareTo(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura) {
        return _categoriaStruttura.compareTo(categoriaStruttura);
    }

    @Override
    public int hashCode() {
        return _categoriaStruttura.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.sincon.sanita.services.model.CategoriaStruttura> toCacheModel() {
        return _categoriaStruttura.toCacheModel();
    }

    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura toEscapedModel() {
        return new CategoriaStrutturaWrapper(_categoriaStruttura.toEscapedModel());
    }

    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura toUnescapedModel() {
        return new CategoriaStrutturaWrapper(_categoriaStruttura.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _categoriaStruttura.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _categoriaStruttura.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _categoriaStruttura.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CategoriaStrutturaWrapper)) {
            return false;
        }

        CategoriaStrutturaWrapper categoriaStrutturaWrapper = (CategoriaStrutturaWrapper) obj;

        if (Validator.equals(_categoriaStruttura,
                    categoriaStrutturaWrapper._categoriaStruttura)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public CategoriaStruttura getWrappedCategoriaStruttura() {
        return _categoriaStruttura;
    }

    @Override
    public CategoriaStruttura getWrappedModel() {
        return _categoriaStruttura;
    }

    @Override
    public void resetOriginalValues() {
        _categoriaStruttura.resetOriginalValues();
    }
}
