package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CFG_CategorieAbilitate}.
 * </p>
 *
 * @author Sincon
 * @see CFG_CategorieAbilitate
 * @generated
 */
public class CFG_CategorieAbilitateWrapper implements CFG_CategorieAbilitate,
    ModelWrapper<CFG_CategorieAbilitate> {
    private CFG_CategorieAbilitate _cfg_CategorieAbilitate;

    public CFG_CategorieAbilitateWrapper(
        CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        _cfg_CategorieAbilitate = cfg_CategorieAbilitate;
    }

    @Override
    public Class<?> getModelClass() {
        return CFG_CategorieAbilitate.class;
    }

    @Override
    public String getModelClassName() {
        return CFG_CategorieAbilitate.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("titoloStruttura", getTitoloStruttura());
        attributes.put("denominazione", getDenominazione());
        attributes.put("ordine", getOrdine());
        attributes.put("className", getClassName());
        attributes.put("defaultRicerca", getDefaultRicerca());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String titoloStruttura = (String) attributes.get("titoloStruttura");

        if (titoloStruttura != null) {
            setTitoloStruttura(titoloStruttura);
        }

        String denominazione = (String) attributes.get("denominazione");

        if (denominazione != null) {
            setDenominazione(denominazione);
        }

        Integer ordine = (Integer) attributes.get("ordine");

        if (ordine != null) {
            setOrdine(ordine);
        }

        String className = (String) attributes.get("className");

        if (className != null) {
            setClassName(className);
        }

        Boolean defaultRicerca = (Boolean) attributes.get("defaultRicerca");

        if (defaultRicerca != null) {
            setDefaultRicerca(defaultRicerca);
        }
    }

    /**
    * Returns the primary key of this c f g_ categorie abilitate.
    *
    * @return the primary key of this c f g_ categorie abilitate
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _cfg_CategorieAbilitate.getPrimaryKey();
    }

    /**
    * Sets the primary key of this c f g_ categorie abilitate.
    *
    * @param primaryKey the primary key of this c f g_ categorie abilitate
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _cfg_CategorieAbilitate.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the titolo struttura of this c f g_ categorie abilitate.
    *
    * @return the titolo struttura of this c f g_ categorie abilitate
    */
    @Override
    public java.lang.String getTitoloStruttura() {
        return _cfg_CategorieAbilitate.getTitoloStruttura();
    }

    /**
    * Sets the titolo struttura of this c f g_ categorie abilitate.
    *
    * @param titoloStruttura the titolo struttura of this c f g_ categorie abilitate
    */
    @Override
    public void setTitoloStruttura(java.lang.String titoloStruttura) {
        _cfg_CategorieAbilitate.setTitoloStruttura(titoloStruttura);
    }

    /**
    * Returns the denominazione of this c f g_ categorie abilitate.
    *
    * @return the denominazione of this c f g_ categorie abilitate
    */
    @Override
    public java.lang.String getDenominazione() {
        return _cfg_CategorieAbilitate.getDenominazione();
    }

    /**
    * Sets the denominazione of this c f g_ categorie abilitate.
    *
    * @param denominazione the denominazione of this c f g_ categorie abilitate
    */
    @Override
    public void setDenominazione(java.lang.String denominazione) {
        _cfg_CategorieAbilitate.setDenominazione(denominazione);
    }

    /**
    * Returns the ordine of this c f g_ categorie abilitate.
    *
    * @return the ordine of this c f g_ categorie abilitate
    */
    @Override
    public int getOrdine() {
        return _cfg_CategorieAbilitate.getOrdine();
    }

    /**
    * Sets the ordine of this c f g_ categorie abilitate.
    *
    * @param ordine the ordine of this c f g_ categorie abilitate
    */
    @Override
    public void setOrdine(int ordine) {
        _cfg_CategorieAbilitate.setOrdine(ordine);
    }

    /**
    * Returns the class name of this c f g_ categorie abilitate.
    *
    * @return the class name of this c f g_ categorie abilitate
    */
    @Override
    public java.lang.String getClassName() {
        return _cfg_CategorieAbilitate.getClassName();
    }

    /**
    * Sets the class name of this c f g_ categorie abilitate.
    *
    * @param className the class name of this c f g_ categorie abilitate
    */
    @Override
    public void setClassName(java.lang.String className) {
        _cfg_CategorieAbilitate.setClassName(className);
    }

    /**
    * Returns the default ricerca of this c f g_ categorie abilitate.
    *
    * @return the default ricerca of this c f g_ categorie abilitate
    */
    @Override
    public boolean getDefaultRicerca() {
        return _cfg_CategorieAbilitate.getDefaultRicerca();
    }

    /**
    * Returns <code>true</code> if this c f g_ categorie abilitate is default ricerca.
    *
    * @return <code>true</code> if this c f g_ categorie abilitate is default ricerca; <code>false</code> otherwise
    */
    @Override
    public boolean isDefaultRicerca() {
        return _cfg_CategorieAbilitate.isDefaultRicerca();
    }

    /**
    * Sets whether this c f g_ categorie abilitate is default ricerca.
    *
    * @param defaultRicerca the default ricerca of this c f g_ categorie abilitate
    */
    @Override
    public void setDefaultRicerca(boolean defaultRicerca) {
        _cfg_CategorieAbilitate.setDefaultRicerca(defaultRicerca);
    }

    @Override
    public boolean isNew() {
        return _cfg_CategorieAbilitate.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _cfg_CategorieAbilitate.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _cfg_CategorieAbilitate.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _cfg_CategorieAbilitate.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _cfg_CategorieAbilitate.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _cfg_CategorieAbilitate.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _cfg_CategorieAbilitate.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _cfg_CategorieAbilitate.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _cfg_CategorieAbilitate.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _cfg_CategorieAbilitate.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _cfg_CategorieAbilitate.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CFG_CategorieAbilitateWrapper((CFG_CategorieAbilitate) _cfg_CategorieAbilitate.clone());
    }

    @Override
    public int compareTo(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        return _cfg_CategorieAbilitate.compareTo(cfg_CategorieAbilitate);
    }

    @Override
    public int hashCode() {
        return _cfg_CategorieAbilitate.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.sincon.sanita.services.model.CFG_CategorieAbilitate> toCacheModel() {
        return _cfg_CategorieAbilitate.toCacheModel();
    }

    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate toEscapedModel() {
        return new CFG_CategorieAbilitateWrapper(_cfg_CategorieAbilitate.toEscapedModel());
    }

    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate toUnescapedModel() {
        return new CFG_CategorieAbilitateWrapper(_cfg_CategorieAbilitate.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _cfg_CategorieAbilitate.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _cfg_CategorieAbilitate.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _cfg_CategorieAbilitate.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CFG_CategorieAbilitateWrapper)) {
            return false;
        }

        CFG_CategorieAbilitateWrapper cfg_CategorieAbilitateWrapper = (CFG_CategorieAbilitateWrapper) obj;

        if (Validator.equals(_cfg_CategorieAbilitate,
                    cfg_CategorieAbilitateWrapper._cfg_CategorieAbilitate)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public CFG_CategorieAbilitate getWrappedCFG_CategorieAbilitate() {
        return _cfg_CategorieAbilitate;
    }

    @Override
    public CFG_CategorieAbilitate getWrappedModel() {
        return _cfg_CategorieAbilitate;
    }

    @Override
    public void resetOriginalValues() {
        _cfg_CategorieAbilitate.resetOriginalValues();
    }
}
