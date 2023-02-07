package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StrutturaSanitaria}.
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitaria
 * @generated
 */
public class StrutturaSanitariaWrapper implements StrutturaSanitaria,
    ModelWrapper<StrutturaSanitaria> {
    private StrutturaSanitaria _strutturaSanitaria;

    public StrutturaSanitariaWrapper(StrutturaSanitaria strutturaSanitaria) {
        _strutturaSanitaria = strutturaSanitaria;
    }

    @Override
    public Class<?> getModelClass() {
        return StrutturaSanitaria.class;
    }

    @Override
    public String getModelClassName() {
        return StrutturaSanitaria.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("pk", getPk());
        attributes.put("idStruttura", getIdStruttura());
        attributes.put("groupId", getGroupId());
        attributes.put("idTipoStruttura", getIdTipoStruttura());
        attributes.put("tipoStruttura", getTipoStruttura());
        attributes.put("tipologia", getTipologia());
        attributes.put("denominazione", getDenominazione());
        attributes.put("immagine", getImmagine());
        attributes.put("descrizione", getDescrizione());
        attributes.put("indirizzo", getIndirizzo());
        attributes.put("lat", getLat());
        attributes.put("lng", getLng());
        attributes.put("distanza", getDistanza());
        attributes.put("telefono", getTelefono());
        attributes.put("email", getEmail());
        attributes.put("fax", getFax());
        attributes.put("orari", getOrari());
        attributes.put("locale", getLocale());
        attributes.put("stato", getStato());
        attributes.put("childrenEdottoOspedaleCollegato",
            getChildrenEdottoOspedaleCollegato());
        attributes.put("childrenEdottoAmbulatorio",
            getChildrenEdottoAmbulatorio());
        attributes.put("childrenEdottoUnitaOperativa",
            getChildrenEdottoUnitaOperativa());
        attributes.put("childrenEdottoUnitaps", getChildrenEdottoUnitaps());
        attributes.put("relazioneAmbulatorio", getRelazioneAmbulatorio());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long pk = (Long) attributes.get("pk");

        if (pk != null) {
            setPk(pk);
        }

        Long idStruttura = (Long) attributes.get("idStruttura");

        if (idStruttura != null) {
            setIdStruttura(idStruttura);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        String idTipoStruttura = (String) attributes.get("idTipoStruttura");

        if (idTipoStruttura != null) {
            setIdTipoStruttura(idTipoStruttura);
        }

        String tipoStruttura = (String) attributes.get("tipoStruttura");

        if (tipoStruttura != null) {
            setTipoStruttura(tipoStruttura);
        }

        String tipologia = (String) attributes.get("tipologia");

        if (tipologia != null) {
            setTipologia(tipologia);
        }

        String denominazione = (String) attributes.get("denominazione");

        if (denominazione != null) {
            setDenominazione(denominazione);
        }

        String immagine = (String) attributes.get("immagine");

        if (immagine != null) {
            setImmagine(immagine);
        }

        String descrizione = (String) attributes.get("descrizione");

        if (descrizione != null) {
            setDescrizione(descrizione);
        }

        String indirizzo = (String) attributes.get("indirizzo");

        if (indirizzo != null) {
            setIndirizzo(indirizzo);
        }

        Double lat = (Double) attributes.get("lat");

        if (lat != null) {
            setLat(lat);
        }

        Double lng = (Double) attributes.get("lng");

        if (lng != null) {
            setLng(lng);
        }

        Double distanza = (Double) attributes.get("distanza");

        if (distanza != null) {
            setDistanza(distanza);
        }

        String telefono = (String) attributes.get("telefono");

        if (telefono != null) {
            setTelefono(telefono);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String fax = (String) attributes.get("fax");

        if (fax != null) {
            setFax(fax);
        }

        String orari = (String) attributes.get("orari");

        if (orari != null) {
            setOrari(orari);
        }

        String locale = (String) attributes.get("locale");

        if (locale != null) {
            setLocale(locale);
        }

        Integer stato = (Integer) attributes.get("stato");

        if (stato != null) {
            setStato(stato);
        }

        String childrenEdottoOspedaleCollegato = (String) attributes.get(
                "childrenEdottoOspedaleCollegato");

        if (childrenEdottoOspedaleCollegato != null) {
            setChildrenEdottoOspedaleCollegato(childrenEdottoOspedaleCollegato);
        }

        String childrenEdottoAmbulatorio = (String) attributes.get(
                "childrenEdottoAmbulatorio");

        if (childrenEdottoAmbulatorio != null) {
            setChildrenEdottoAmbulatorio(childrenEdottoAmbulatorio);
        }

        String childrenEdottoUnitaOperativa = (String) attributes.get(
                "childrenEdottoUnitaOperativa");

        if (childrenEdottoUnitaOperativa != null) {
            setChildrenEdottoUnitaOperativa(childrenEdottoUnitaOperativa);
        }

        String childrenEdottoUnitaps = (String) attributes.get(
                "childrenEdottoUnitaps");

        if (childrenEdottoUnitaps != null) {
            setChildrenEdottoUnitaps(childrenEdottoUnitaps);
        }

        String relazioneAmbulatorio = (String) attributes.get(
                "relazioneAmbulatorio");

        if (relazioneAmbulatorio != null) {
            setRelazioneAmbulatorio(relazioneAmbulatorio);
        }
    }

    /**
    * Returns the primary key of this struttura sanitaria.
    *
    * @return the primary key of this struttura sanitaria
    */
    @Override
    public long getPrimaryKey() {
        return _strutturaSanitaria.getPrimaryKey();
    }

    /**
    * Sets the primary key of this struttura sanitaria.
    *
    * @param primaryKey the primary key of this struttura sanitaria
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _strutturaSanitaria.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the pk of this struttura sanitaria.
    *
    * @return the pk of this struttura sanitaria
    */
    @Override
    public long getPk() {
        return _strutturaSanitaria.getPk();
    }

    /**
    * Sets the pk of this struttura sanitaria.
    *
    * @param pk the pk of this struttura sanitaria
    */
    @Override
    public void setPk(long pk) {
        _strutturaSanitaria.setPk(pk);
    }

    /**
    * Returns the id struttura of this struttura sanitaria.
    *
    * @return the id struttura of this struttura sanitaria
    */
    @Override
    public long getIdStruttura() {
        return _strutturaSanitaria.getIdStruttura();
    }

    /**
    * Sets the id struttura of this struttura sanitaria.
    *
    * @param idStruttura the id struttura of this struttura sanitaria
    */
    @Override
    public void setIdStruttura(long idStruttura) {
        _strutturaSanitaria.setIdStruttura(idStruttura);
    }

    /**
    * Returns the group ID of this struttura sanitaria.
    *
    * @return the group ID of this struttura sanitaria
    */
    @Override
    public long getGroupId() {
        return _strutturaSanitaria.getGroupId();
    }

    /**
    * Sets the group ID of this struttura sanitaria.
    *
    * @param groupId the group ID of this struttura sanitaria
    */
    @Override
    public void setGroupId(long groupId) {
        _strutturaSanitaria.setGroupId(groupId);
    }

    /**
    * Returns the id tipo struttura of this struttura sanitaria.
    *
    * @return the id tipo struttura of this struttura sanitaria
    */
    @Override
    public java.lang.String getIdTipoStruttura() {
        return _strutturaSanitaria.getIdTipoStruttura();
    }

    /**
    * Sets the id tipo struttura of this struttura sanitaria.
    *
    * @param idTipoStruttura the id tipo struttura of this struttura sanitaria
    */
    @Override
    public void setIdTipoStruttura(java.lang.String idTipoStruttura) {
        _strutturaSanitaria.setIdTipoStruttura(idTipoStruttura);
    }

    /**
    * Returns the tipo struttura of this struttura sanitaria.
    *
    * @return the tipo struttura of this struttura sanitaria
    */
    @Override
    public java.lang.String getTipoStruttura() {
        return _strutturaSanitaria.getTipoStruttura();
    }

    /**
    * Sets the tipo struttura of this struttura sanitaria.
    *
    * @param tipoStruttura the tipo struttura of this struttura sanitaria
    */
    @Override
    public void setTipoStruttura(java.lang.String tipoStruttura) {
        _strutturaSanitaria.setTipoStruttura(tipoStruttura);
    }

    /**
    * Returns the tipologia of this struttura sanitaria.
    *
    * @return the tipologia of this struttura sanitaria
    */
    @Override
    public java.lang.String getTipologia() {
        return _strutturaSanitaria.getTipologia();
    }

    /**
    * Sets the tipologia of this struttura sanitaria.
    *
    * @param tipologia the tipologia of this struttura sanitaria
    */
    @Override
    public void setTipologia(java.lang.String tipologia) {
        _strutturaSanitaria.setTipologia(tipologia);
    }

    /**
    * Returns the denominazione of this struttura sanitaria.
    *
    * @return the denominazione of this struttura sanitaria
    */
    @Override
    public java.lang.String getDenominazione() {
        return _strutturaSanitaria.getDenominazione();
    }

    /**
    * Sets the denominazione of this struttura sanitaria.
    *
    * @param denominazione the denominazione of this struttura sanitaria
    */
    @Override
    public void setDenominazione(java.lang.String denominazione) {
        _strutturaSanitaria.setDenominazione(denominazione);
    }

    /**
    * Returns the immagine of this struttura sanitaria.
    *
    * @return the immagine of this struttura sanitaria
    */
    @Override
    public java.lang.String getImmagine() {
        return _strutturaSanitaria.getImmagine();
    }

    /**
    * Sets the immagine of this struttura sanitaria.
    *
    * @param immagine the immagine of this struttura sanitaria
    */
    @Override
    public void setImmagine(java.lang.String immagine) {
        _strutturaSanitaria.setImmagine(immagine);
    }

    /**
    * Returns the descrizione of this struttura sanitaria.
    *
    * @return the descrizione of this struttura sanitaria
    */
    @Override
    public java.lang.String getDescrizione() {
        return _strutturaSanitaria.getDescrizione();
    }

    /**
    * Sets the descrizione of this struttura sanitaria.
    *
    * @param descrizione the descrizione of this struttura sanitaria
    */
    @Override
    public void setDescrizione(java.lang.String descrizione) {
        _strutturaSanitaria.setDescrizione(descrizione);
    }

    /**
    * Returns the indirizzo of this struttura sanitaria.
    *
    * @return the indirizzo of this struttura sanitaria
    */
    @Override
    public java.lang.String getIndirizzo() {
        return _strutturaSanitaria.getIndirizzo();
    }

    /**
    * Sets the indirizzo of this struttura sanitaria.
    *
    * @param indirizzo the indirizzo of this struttura sanitaria
    */
    @Override
    public void setIndirizzo(java.lang.String indirizzo) {
        _strutturaSanitaria.setIndirizzo(indirizzo);
    }

    /**
    * Returns the lat of this struttura sanitaria.
    *
    * @return the lat of this struttura sanitaria
    */
    @Override
    public double getLat() {
        return _strutturaSanitaria.getLat();
    }

    /**
    * Sets the lat of this struttura sanitaria.
    *
    * @param lat the lat of this struttura sanitaria
    */
    @Override
    public void setLat(double lat) {
        _strutturaSanitaria.setLat(lat);
    }

    /**
    * Returns the lng of this struttura sanitaria.
    *
    * @return the lng of this struttura sanitaria
    */
    @Override
    public double getLng() {
        return _strutturaSanitaria.getLng();
    }

    /**
    * Sets the lng of this struttura sanitaria.
    *
    * @param lng the lng of this struttura sanitaria
    */
    @Override
    public void setLng(double lng) {
        _strutturaSanitaria.setLng(lng);
    }

    /**
    * Returns the distanza of this struttura sanitaria.
    *
    * @return the distanza of this struttura sanitaria
    */
    @Override
    public double getDistanza() {
        return _strutturaSanitaria.getDistanza();
    }

    /**
    * Sets the distanza of this struttura sanitaria.
    *
    * @param distanza the distanza of this struttura sanitaria
    */
    @Override
    public void setDistanza(double distanza) {
        _strutturaSanitaria.setDistanza(distanza);
    }

    /**
    * Returns the telefono of this struttura sanitaria.
    *
    * @return the telefono of this struttura sanitaria
    */
    @Override
    public java.lang.String getTelefono() {
        return _strutturaSanitaria.getTelefono();
    }

    /**
    * Sets the telefono of this struttura sanitaria.
    *
    * @param telefono the telefono of this struttura sanitaria
    */
    @Override
    public void setTelefono(java.lang.String telefono) {
        _strutturaSanitaria.setTelefono(telefono);
    }

    /**
    * Returns the email of this struttura sanitaria.
    *
    * @return the email of this struttura sanitaria
    */
    @Override
    public java.lang.String getEmail() {
        return _strutturaSanitaria.getEmail();
    }

    /**
    * Sets the email of this struttura sanitaria.
    *
    * @param email the email of this struttura sanitaria
    */
    @Override
    public void setEmail(java.lang.String email) {
        _strutturaSanitaria.setEmail(email);
    }

    /**
    * Returns the fax of this struttura sanitaria.
    *
    * @return the fax of this struttura sanitaria
    */
    @Override
    public java.lang.String getFax() {
        return _strutturaSanitaria.getFax();
    }

    /**
    * Sets the fax of this struttura sanitaria.
    *
    * @param fax the fax of this struttura sanitaria
    */
    @Override
    public void setFax(java.lang.String fax) {
        _strutturaSanitaria.setFax(fax);
    }

    /**
    * Returns the orari of this struttura sanitaria.
    *
    * @return the orari of this struttura sanitaria
    */
    @Override
    public java.lang.String getOrari() {
        return _strutturaSanitaria.getOrari();
    }

    /**
    * Sets the orari of this struttura sanitaria.
    *
    * @param orari the orari of this struttura sanitaria
    */
    @Override
    public void setOrari(java.lang.String orari) {
        _strutturaSanitaria.setOrari(orari);
    }

    /**
    * Returns the locale of this struttura sanitaria.
    *
    * @return the locale of this struttura sanitaria
    */
    @Override
    public java.lang.String getLocale() {
        return _strutturaSanitaria.getLocale();
    }

    /**
    * Sets the locale of this struttura sanitaria.
    *
    * @param locale the locale of this struttura sanitaria
    */
    @Override
    public void setLocale(java.lang.String locale) {
        _strutturaSanitaria.setLocale(locale);
    }

    /**
    * Returns the stato of this struttura sanitaria.
    *
    * @return the stato of this struttura sanitaria
    */
    @Override
    public int getStato() {
        return _strutturaSanitaria.getStato();
    }

    /**
    * Sets the stato of this struttura sanitaria.
    *
    * @param stato the stato of this struttura sanitaria
    */
    @Override
    public void setStato(int stato) {
        _strutturaSanitaria.setStato(stato);
    }

    /**
    * Returns the children edotto ospedale collegato of this struttura sanitaria.
    *
    * @return the children edotto ospedale collegato of this struttura sanitaria
    */
    @Override
    public java.lang.String getChildrenEdottoOspedaleCollegato() {
        return _strutturaSanitaria.getChildrenEdottoOspedaleCollegato();
    }

    /**
    * Sets the children edotto ospedale collegato of this struttura sanitaria.
    *
    * @param childrenEdottoOspedaleCollegato the children edotto ospedale collegato of this struttura sanitaria
    */
    @Override
    public void setChildrenEdottoOspedaleCollegato(
        java.lang.String childrenEdottoOspedaleCollegato) {
        _strutturaSanitaria.setChildrenEdottoOspedaleCollegato(childrenEdottoOspedaleCollegato);
    }

    /**
    * Returns the children edotto ambulatorio of this struttura sanitaria.
    *
    * @return the children edotto ambulatorio of this struttura sanitaria
    */
    @Override
    public java.lang.String getChildrenEdottoAmbulatorio() {
        return _strutturaSanitaria.getChildrenEdottoAmbulatorio();
    }

    /**
    * Sets the children edotto ambulatorio of this struttura sanitaria.
    *
    * @param childrenEdottoAmbulatorio the children edotto ambulatorio of this struttura sanitaria
    */
    @Override
    public void setChildrenEdottoAmbulatorio(
        java.lang.String childrenEdottoAmbulatorio) {
        _strutturaSanitaria.setChildrenEdottoAmbulatorio(childrenEdottoAmbulatorio);
    }

    /**
    * Returns the children edotto unita operativa of this struttura sanitaria.
    *
    * @return the children edotto unita operativa of this struttura sanitaria
    */
    @Override
    public java.lang.String getChildrenEdottoUnitaOperativa() {
        return _strutturaSanitaria.getChildrenEdottoUnitaOperativa();
    }

    /**
    * Sets the children edotto unita operativa of this struttura sanitaria.
    *
    * @param childrenEdottoUnitaOperativa the children edotto unita operativa of this struttura sanitaria
    */
    @Override
    public void setChildrenEdottoUnitaOperativa(
        java.lang.String childrenEdottoUnitaOperativa) {
        _strutturaSanitaria.setChildrenEdottoUnitaOperativa(childrenEdottoUnitaOperativa);
    }

    /**
    * Returns the children edotto unitaps of this struttura sanitaria.
    *
    * @return the children edotto unitaps of this struttura sanitaria
    */
    @Override
    public java.lang.String getChildrenEdottoUnitaps() {
        return _strutturaSanitaria.getChildrenEdottoUnitaps();
    }

    /**
    * Sets the children edotto unitaps of this struttura sanitaria.
    *
    * @param childrenEdottoUnitaps the children edotto unitaps of this struttura sanitaria
    */
    @Override
    public void setChildrenEdottoUnitaps(java.lang.String childrenEdottoUnitaps) {
        _strutturaSanitaria.setChildrenEdottoUnitaps(childrenEdottoUnitaps);
    }

    /**
    * Returns the relazione ambulatorio of this struttura sanitaria.
    *
    * @return the relazione ambulatorio of this struttura sanitaria
    */
    @Override
    public java.lang.String getRelazioneAmbulatorio() {
        return _strutturaSanitaria.getRelazioneAmbulatorio();
    }

    /**
    * Sets the relazione ambulatorio of this struttura sanitaria.
    *
    * @param relazioneAmbulatorio the relazione ambulatorio of this struttura sanitaria
    */
    @Override
    public void setRelazioneAmbulatorio(java.lang.String relazioneAmbulatorio) {
        _strutturaSanitaria.setRelazioneAmbulatorio(relazioneAmbulatorio);
    }

    @Override
    public boolean isNew() {
        return _strutturaSanitaria.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _strutturaSanitaria.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _strutturaSanitaria.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _strutturaSanitaria.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _strutturaSanitaria.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _strutturaSanitaria.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _strutturaSanitaria.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _strutturaSanitaria.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _strutturaSanitaria.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _strutturaSanitaria.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _strutturaSanitaria.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new StrutturaSanitariaWrapper((StrutturaSanitaria) _strutturaSanitaria.clone());
    }

    @Override
    public int compareTo(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria) {
        return _strutturaSanitaria.compareTo(strutturaSanitaria);
    }

    @Override
    public int hashCode() {
        return _strutturaSanitaria.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.sincon.sanita.services.model.StrutturaSanitaria> toCacheModel() {
        return _strutturaSanitaria.toCacheModel();
    }

    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria toEscapedModel() {
        return new StrutturaSanitariaWrapper(_strutturaSanitaria.toEscapedModel());
    }

    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria toUnescapedModel() {
        return new StrutturaSanitariaWrapper(_strutturaSanitaria.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _strutturaSanitaria.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _strutturaSanitaria.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _strutturaSanitaria.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StrutturaSanitariaWrapper)) {
            return false;
        }

        StrutturaSanitariaWrapper strutturaSanitariaWrapper = (StrutturaSanitariaWrapper) obj;

        if (Validator.equals(_strutturaSanitaria,
                    strutturaSanitariaWrapper._strutturaSanitaria)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public StrutturaSanitaria getWrappedStrutturaSanitaria() {
        return _strutturaSanitaria;
    }

    @Override
    public StrutturaSanitaria getWrappedModel() {
        return _strutturaSanitaria;
    }

    @Override
    public void resetOriginalValues() {
        _strutturaSanitaria.resetOriginalValues();
    }
}
