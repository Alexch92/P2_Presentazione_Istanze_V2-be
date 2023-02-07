package it.sincon.sanita.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.sincon.sanita.services.service.http.StrutturaSanitariaServiceSoap}.
 *
 * @author Sincon
 * @see it.sincon.sanita.services.service.http.StrutturaSanitariaServiceSoap
 * @generated
 */
public class StrutturaSanitariaSoap implements Serializable {
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

    public StrutturaSanitariaSoap() {
    }

    public static StrutturaSanitariaSoap toSoapModel(StrutturaSanitaria model) {
        StrutturaSanitariaSoap soapModel = new StrutturaSanitariaSoap();

        soapModel.setPk(model.getPk());
        soapModel.setIdStruttura(model.getIdStruttura());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setIdTipoStruttura(model.getIdTipoStruttura());
        soapModel.setTipoStruttura(model.getTipoStruttura());
        soapModel.setTipologia(model.getTipologia());
        soapModel.setDenominazione(model.getDenominazione());
        soapModel.setImmagine(model.getImmagine());
        soapModel.setDescrizione(model.getDescrizione());
        soapModel.setIndirizzo(model.getIndirizzo());
        soapModel.setLat(model.getLat());
        soapModel.setLng(model.getLng());
        soapModel.setDistanza(model.getDistanza());
        soapModel.setTelefono(model.getTelefono());
        soapModel.setEmail(model.getEmail());
        soapModel.setFax(model.getFax());
        soapModel.setOrari(model.getOrari());
        soapModel.setLocale(model.getLocale());
        soapModel.setStato(model.getStato());
        soapModel.setChildrenEdottoOspedaleCollegato(model.getChildrenEdottoOspedaleCollegato());
        soapModel.setChildrenEdottoAmbulatorio(model.getChildrenEdottoAmbulatorio());
        soapModel.setChildrenEdottoUnitaOperativa(model.getChildrenEdottoUnitaOperativa());
        soapModel.setChildrenEdottoUnitaps(model.getChildrenEdottoUnitaps());
        soapModel.setRelazioneAmbulatorio(model.getRelazioneAmbulatorio());

        return soapModel;
    }

    public static StrutturaSanitariaSoap[] toSoapModels(
        StrutturaSanitaria[] models) {
        StrutturaSanitariaSoap[] soapModels = new StrutturaSanitariaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static StrutturaSanitariaSoap[][] toSoapModels(
        StrutturaSanitaria[][] models) {
        StrutturaSanitariaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new StrutturaSanitariaSoap[models.length][models[0].length];
        } else {
            soapModels = new StrutturaSanitariaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static StrutturaSanitariaSoap[] toSoapModels(
        List<StrutturaSanitaria> models) {
        List<StrutturaSanitariaSoap> soapModels = new ArrayList<StrutturaSanitariaSoap>(models.size());

        for (StrutturaSanitaria model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new StrutturaSanitariaSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _pk;
    }

    public void setPrimaryKey(long pk) {
        setPk(pk);
    }

    public long getPk() {
        return _pk;
    }

    public void setPk(long pk) {
        _pk = pk;
    }

    public long getIdStruttura() {
        return _idStruttura;
    }

    public void setIdStruttura(long idStruttura) {
        _idStruttura = idStruttura;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public String getIdTipoStruttura() {
        return _idTipoStruttura;
    }

    public void setIdTipoStruttura(String idTipoStruttura) {
        _idTipoStruttura = idTipoStruttura;
    }

    public String getTipoStruttura() {
        return _tipoStruttura;
    }

    public void setTipoStruttura(String tipoStruttura) {
        _tipoStruttura = tipoStruttura;
    }

    public String getTipologia() {
        return _tipologia;
    }

    public void setTipologia(String tipologia) {
        _tipologia = tipologia;
    }

    public String getDenominazione() {
        return _denominazione;
    }

    public void setDenominazione(String denominazione) {
        _denominazione = denominazione;
    }

    public String getImmagine() {
        return _immagine;
    }

    public void setImmagine(String immagine) {
        _immagine = immagine;
    }

    public String getDescrizione() {
        return _descrizione;
    }

    public void setDescrizione(String descrizione) {
        _descrizione = descrizione;
    }

    public String getIndirizzo() {
        return _indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        _indirizzo = indirizzo;
    }

    public double getLat() {
        return _lat;
    }

    public void setLat(double lat) {
        _lat = lat;
    }

    public double getLng() {
        return _lng;
    }

    public void setLng(double lng) {
        _lng = lng;
    }

    public double getDistanza() {
        return _distanza;
    }

    public void setDistanza(double distanza) {
        _distanza = distanza;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String telefono) {
        _telefono = telefono;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getFax() {
        return _fax;
    }

    public void setFax(String fax) {
        _fax = fax;
    }

    public String getOrari() {
        return _orari;
    }

    public void setOrari(String orari) {
        _orari = orari;
    }

    public String getLocale() {
        return _locale;
    }

    public void setLocale(String locale) {
        _locale = locale;
    }

    public int getStato() {
        return _stato;
    }

    public void setStato(int stato) {
        _stato = stato;
    }

    public String getChildrenEdottoOspedaleCollegato() {
        return _childrenEdottoOspedaleCollegato;
    }

    public void setChildrenEdottoOspedaleCollegato(
        String childrenEdottoOspedaleCollegato) {
        _childrenEdottoOspedaleCollegato = childrenEdottoOspedaleCollegato;
    }

    public String getChildrenEdottoAmbulatorio() {
        return _childrenEdottoAmbulatorio;
    }

    public void setChildrenEdottoAmbulatorio(String childrenEdottoAmbulatorio) {
        _childrenEdottoAmbulatorio = childrenEdottoAmbulatorio;
    }

    public String getChildrenEdottoUnitaOperativa() {
        return _childrenEdottoUnitaOperativa;
    }

    public void setChildrenEdottoUnitaOperativa(
        String childrenEdottoUnitaOperativa) {
        _childrenEdottoUnitaOperativa = childrenEdottoUnitaOperativa;
    }

    public String getChildrenEdottoUnitaps() {
        return _childrenEdottoUnitaps;
    }

    public void setChildrenEdottoUnitaps(String childrenEdottoUnitaps) {
        _childrenEdottoUnitaps = childrenEdottoUnitaps;
    }

    public String getRelazioneAmbulatorio() {
        return _relazioneAmbulatorio;
    }

    public void setRelazioneAmbulatorio(String relazioneAmbulatorio) {
        _relazioneAmbulatorio = relazioneAmbulatorio;
    }
}
