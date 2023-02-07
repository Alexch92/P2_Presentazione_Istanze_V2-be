package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.sincon.sanita.services.service.ClpSerializer;
import it.sincon.sanita.services.service.StrutturaSanitariaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class StrutturaSanitariaClp extends BaseModelImpl<StrutturaSanitaria>
    implements StrutturaSanitaria {
    private long _pk;
    private long _idStruttura;
    private long _groupId;
    private String _idTipoStruttura;
    private String _tipoStruttura;
    private String _tipologia;
    private String _denominazione;
    private String _immagine;
    private String _descrizione;
    private String _indirizzo;
    private double _lat;
    private double _lng;
    private double _distanza;
    private String _telefono;
    private String _email;
    private String _fax;
    private String _orari;
    private String _locale;
    private int _stato;
    private String _childrenEdottoOspedaleCollegato;
    private String _childrenEdottoAmbulatorio;
    private String _childrenEdottoUnitaOperativa;
    private String _childrenEdottoUnitaps;
    private String _relazioneAmbulatorio;
    private BaseModel<?> _strutturaSanitariaRemoteModel;

    public StrutturaSanitariaClp() {
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
    public long getPrimaryKey() {
        return _pk;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPk(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _pk;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getPk() {
        return _pk;
    }

    @Override
    public void setPk(long pk) {
        _pk = pk;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setPk", long.class);

                method.invoke(_strutturaSanitariaRemoteModel, pk);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getIdStruttura() {
        return _idStruttura;
    }

    @Override
    public void setIdStruttura(long idStruttura) {
        _idStruttura = idStruttura;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setIdStruttura", long.class);

                method.invoke(_strutturaSanitariaRemoteModel, idStruttura);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_strutturaSanitariaRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIdTipoStruttura() {
        return _idTipoStruttura;
    }

    @Override
    public void setIdTipoStruttura(String idTipoStruttura) {
        _idTipoStruttura = idTipoStruttura;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setIdTipoStruttura",
                        String.class);

                method.invoke(_strutturaSanitariaRemoteModel, idTipoStruttura);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTipoStruttura() {
        return _tipoStruttura;
    }

    @Override
    public void setTipoStruttura(String tipoStruttura) {
        _tipoStruttura = tipoStruttura;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setTipoStruttura", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, tipoStruttura);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTipologia() {
        return _tipologia;
    }

    @Override
    public void setTipologia(String tipologia) {
        _tipologia = tipologia;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setTipologia", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, tipologia);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDenominazione() {
        return _denominazione;
    }

    @Override
    public void setDenominazione(String denominazione) {
        _denominazione = denominazione;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setDenominazione", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, denominazione);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getImmagine() {
        return _immagine;
    }

    @Override
    public void setImmagine(String immagine) {
        _immagine = immagine;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setImmagine", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, immagine);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescrizione() {
        return _descrizione;
    }

    @Override
    public void setDescrizione(String descrizione) {
        _descrizione = descrizione;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setDescrizione", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, descrizione);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIndirizzo() {
        return _indirizzo;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        _indirizzo = indirizzo;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setIndirizzo", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, indirizzo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLat() {
        return _lat;
    }

    @Override
    public void setLat(double lat) {
        _lat = lat;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setLat", double.class);

                method.invoke(_strutturaSanitariaRemoteModel, lat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLng() {
        return _lng;
    }

    @Override
    public void setLng(double lng) {
        _lng = lng;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setLng", double.class);

                method.invoke(_strutturaSanitariaRemoteModel, lng);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getDistanza() {
        return _distanza;
    }

    @Override
    public void setDistanza(double distanza) {
        _distanza = distanza;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setDistanza", double.class);

                method.invoke(_strutturaSanitariaRemoteModel, distanza);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTelefono() {
        return _telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        _telefono = telefono;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setTelefono", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, telefono);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFax() {
        return _fax;
    }

    @Override
    public void setFax(String fax) {
        _fax = fax;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setFax", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, fax);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrari() {
        return _orari;
    }

    @Override
    public void setOrari(String orari) {
        _orari = orari;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setOrari", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, orari);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLocale() {
        return _locale;
    }

    @Override
    public void setLocale(String locale) {
        _locale = locale;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setLocale", String.class);

                method.invoke(_strutturaSanitariaRemoteModel, locale);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStato() {
        return _stato;
    }

    @Override
    public void setStato(int stato) {
        _stato = stato;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setStato", int.class);

                method.invoke(_strutturaSanitariaRemoteModel, stato);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChildrenEdottoOspedaleCollegato() {
        return _childrenEdottoOspedaleCollegato;
    }

    @Override
    public void setChildrenEdottoOspedaleCollegato(
        String childrenEdottoOspedaleCollegato) {
        _childrenEdottoOspedaleCollegato = childrenEdottoOspedaleCollegato;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setChildrenEdottoOspedaleCollegato",
                        String.class);

                method.invoke(_strutturaSanitariaRemoteModel,
                    childrenEdottoOspedaleCollegato);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChildrenEdottoAmbulatorio() {
        return _childrenEdottoAmbulatorio;
    }

    @Override
    public void setChildrenEdottoAmbulatorio(String childrenEdottoAmbulatorio) {
        _childrenEdottoAmbulatorio = childrenEdottoAmbulatorio;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setChildrenEdottoAmbulatorio",
                        String.class);

                method.invoke(_strutturaSanitariaRemoteModel,
                    childrenEdottoAmbulatorio);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChildrenEdottoUnitaOperativa() {
        return _childrenEdottoUnitaOperativa;
    }

    @Override
    public void setChildrenEdottoUnitaOperativa(
        String childrenEdottoUnitaOperativa) {
        _childrenEdottoUnitaOperativa = childrenEdottoUnitaOperativa;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setChildrenEdottoUnitaOperativa",
                        String.class);

                method.invoke(_strutturaSanitariaRemoteModel,
                    childrenEdottoUnitaOperativa);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChildrenEdottoUnitaps() {
        return _childrenEdottoUnitaps;
    }

    @Override
    public void setChildrenEdottoUnitaps(String childrenEdottoUnitaps) {
        _childrenEdottoUnitaps = childrenEdottoUnitaps;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setChildrenEdottoUnitaps",
                        String.class);

                method.invoke(_strutturaSanitariaRemoteModel,
                    childrenEdottoUnitaps);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRelazioneAmbulatorio() {
        return _relazioneAmbulatorio;
    }

    @Override
    public void setRelazioneAmbulatorio(String relazioneAmbulatorio) {
        _relazioneAmbulatorio = relazioneAmbulatorio;

        if (_strutturaSanitariaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaRemoteModel.getClass();

                Method method = clazz.getMethod("setRelazioneAmbulatorio",
                        String.class);

                method.invoke(_strutturaSanitariaRemoteModel,
                    relazioneAmbulatorio);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        try {
            String methodName = "setExpandoBridgeAttributes";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portlet.expando.model.ExpandoBridge.class
                };

            Object[] parameterValues = new Object[] { expandoBridge };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        try {
            String methodName = "setExpandoBridgeAttributes";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portal.model.BaseModel.class
                };

            Object[] parameterValues = new Object[] { baseModel };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getStrutturaSanitariaRemoteModel() {
        return _strutturaSanitariaRemoteModel;
    }

    public void setStrutturaSanitariaRemoteModel(
        BaseModel<?> strutturaSanitariaRemoteModel) {
        _strutturaSanitariaRemoteModel = strutturaSanitariaRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _strutturaSanitariaRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_strutturaSanitariaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            StrutturaSanitariaLocalServiceUtil.addStrutturaSanitaria(this);
        } else {
            StrutturaSanitariaLocalServiceUtil.updateStrutturaSanitaria(this);
        }
    }

    @Override
    public StrutturaSanitaria toEscapedModel() {
        return (StrutturaSanitaria) ProxyUtil.newProxyInstance(StrutturaSanitaria.class.getClassLoader(),
            new Class[] { StrutturaSanitaria.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        StrutturaSanitariaClp clone = new StrutturaSanitariaClp();

        clone.setPk(getPk());
        clone.setIdStruttura(getIdStruttura());
        clone.setGroupId(getGroupId());
        clone.setIdTipoStruttura(getIdTipoStruttura());
        clone.setTipoStruttura(getTipoStruttura());
        clone.setTipologia(getTipologia());
        clone.setDenominazione(getDenominazione());
        clone.setImmagine(getImmagine());
        clone.setDescrizione(getDescrizione());
        clone.setIndirizzo(getIndirizzo());
        clone.setLat(getLat());
        clone.setLng(getLng());
        clone.setDistanza(getDistanza());
        clone.setTelefono(getTelefono());
        clone.setEmail(getEmail());
        clone.setFax(getFax());
        clone.setOrari(getOrari());
        clone.setLocale(getLocale());
        clone.setStato(getStato());
        clone.setChildrenEdottoOspedaleCollegato(getChildrenEdottoOspedaleCollegato());
        clone.setChildrenEdottoAmbulatorio(getChildrenEdottoAmbulatorio());
        clone.setChildrenEdottoUnitaOperativa(getChildrenEdottoUnitaOperativa());
        clone.setChildrenEdottoUnitaps(getChildrenEdottoUnitaps());
        clone.setRelazioneAmbulatorio(getRelazioneAmbulatorio());

        return clone;
    }

    @Override
    public int compareTo(StrutturaSanitaria strutturaSanitaria) {
        long primaryKey = strutturaSanitaria.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StrutturaSanitariaClp)) {
            return false;
        }

        StrutturaSanitariaClp strutturaSanitaria = (StrutturaSanitariaClp) obj;

        long primaryKey = strutturaSanitaria.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(49);

        sb.append("{pk=");
        sb.append(getPk());
        sb.append(", idStruttura=");
        sb.append(getIdStruttura());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", idTipoStruttura=");
        sb.append(getIdTipoStruttura());
        sb.append(", tipoStruttura=");
        sb.append(getTipoStruttura());
        sb.append(", tipologia=");
        sb.append(getTipologia());
        sb.append(", denominazione=");
        sb.append(getDenominazione());
        sb.append(", immagine=");
        sb.append(getImmagine());
        sb.append(", descrizione=");
        sb.append(getDescrizione());
        sb.append(", indirizzo=");
        sb.append(getIndirizzo());
        sb.append(", lat=");
        sb.append(getLat());
        sb.append(", lng=");
        sb.append(getLng());
        sb.append(", distanza=");
        sb.append(getDistanza());
        sb.append(", telefono=");
        sb.append(getTelefono());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", fax=");
        sb.append(getFax());
        sb.append(", orari=");
        sb.append(getOrari());
        sb.append(", locale=");
        sb.append(getLocale());
        sb.append(", stato=");
        sb.append(getStato());
        sb.append(", childrenEdottoOspedaleCollegato=");
        sb.append(getChildrenEdottoOspedaleCollegato());
        sb.append(", childrenEdottoAmbulatorio=");
        sb.append(getChildrenEdottoAmbulatorio());
        sb.append(", childrenEdottoUnitaOperativa=");
        sb.append(getChildrenEdottoUnitaOperativa());
        sb.append(", childrenEdottoUnitaps=");
        sb.append(getChildrenEdottoUnitaps());
        sb.append(", relazioneAmbulatorio=");
        sb.append(getRelazioneAmbulatorio());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(76);

        sb.append("<model><model-name>");
        sb.append("it.sincon.sanita.services.model.StrutturaSanitaria");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>pk</column-name><column-value><![CDATA[");
        sb.append(getPk());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>idStruttura</column-name><column-value><![CDATA[");
        sb.append(getIdStruttura());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>idTipoStruttura</column-name><column-value><![CDATA[");
        sb.append(getIdTipoStruttura());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tipoStruttura</column-name><column-value><![CDATA[");
        sb.append(getTipoStruttura());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tipologia</column-name><column-value><![CDATA[");
        sb.append(getTipologia());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>denominazione</column-name><column-value><![CDATA[");
        sb.append(getDenominazione());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>immagine</column-name><column-value><![CDATA[");
        sb.append(getImmagine());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>descrizione</column-name><column-value><![CDATA[");
        sb.append(getDescrizione());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>indirizzo</column-name><column-value><![CDATA[");
        sb.append(getIndirizzo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lat</column-name><column-value><![CDATA[");
        sb.append(getLat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lng</column-name><column-value><![CDATA[");
        sb.append(getLng());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>distanza</column-name><column-value><![CDATA[");
        sb.append(getDistanza());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>telefono</column-name><column-value><![CDATA[");
        sb.append(getTelefono());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fax</column-name><column-value><![CDATA[");
        sb.append(getFax());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>orari</column-name><column-value><![CDATA[");
        sb.append(getOrari());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>locale</column-name><column-value><![CDATA[");
        sb.append(getLocale());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stato</column-name><column-value><![CDATA[");
        sb.append(getStato());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>childrenEdottoOspedaleCollegato</column-name><column-value><![CDATA[");
        sb.append(getChildrenEdottoOspedaleCollegato());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>childrenEdottoAmbulatorio</column-name><column-value><![CDATA[");
        sb.append(getChildrenEdottoAmbulatorio());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>childrenEdottoUnitaOperativa</column-name><column-value><![CDATA[");
        sb.append(getChildrenEdottoUnitaOperativa());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>childrenEdottoUnitaps</column-name><column-value><![CDATA[");
        sb.append(getChildrenEdottoUnitaps());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>relazioneAmbulatorio</column-name><column-value><![CDATA[");
        sb.append(getRelazioneAmbulatorio());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
