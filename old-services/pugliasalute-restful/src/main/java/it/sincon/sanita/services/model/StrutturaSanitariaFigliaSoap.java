package it.sincon.sanita.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.sincon.sanita.services.service.http.StrutturaSanitariaFigliaServiceSoap}.
 *
 * @author Sincon
 * @see it.sincon.sanita.services.service.http.StrutturaSanitariaFigliaServiceSoap
 * @generated
 */
public class StrutturaSanitariaFigliaSoap implements Serializable {
    private long _idStrutturaFiglia;
    private String _tipoStruttura;
    private String _denominazione;
    private String _indirizzo;
    private String _direttore;
    private String _responsabileSanitario;
    private String _telefono;
    private String _email;

    public StrutturaSanitariaFigliaSoap() {
    }

    public static StrutturaSanitariaFigliaSoap toSoapModel(
        StrutturaSanitariaFiglia model) {
        StrutturaSanitariaFigliaSoap soapModel = new StrutturaSanitariaFigliaSoap();

        soapModel.setIdStrutturaFiglia(model.getIdStrutturaFiglia());
        soapModel.setTipoStruttura(model.getTipoStruttura());
        soapModel.setDenominazione(model.getDenominazione());
        soapModel.setIndirizzo(model.getIndirizzo());
        soapModel.setDirettore(model.getDirettore());
        soapModel.setResponsabileSanitario(model.getResponsabileSanitario());
        soapModel.setTelefono(model.getTelefono());
        soapModel.setEmail(model.getEmail());

        return soapModel;
    }

    public static StrutturaSanitariaFigliaSoap[] toSoapModels(
        StrutturaSanitariaFiglia[] models) {
        StrutturaSanitariaFigliaSoap[] soapModels = new StrutturaSanitariaFigliaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static StrutturaSanitariaFigliaSoap[][] toSoapModels(
        StrutturaSanitariaFiglia[][] models) {
        StrutturaSanitariaFigliaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new StrutturaSanitariaFigliaSoap[models.length][models[0].length];
        } else {
            soapModels = new StrutturaSanitariaFigliaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static StrutturaSanitariaFigliaSoap[] toSoapModels(
        List<StrutturaSanitariaFiglia> models) {
        List<StrutturaSanitariaFigliaSoap> soapModels = new ArrayList<StrutturaSanitariaFigliaSoap>(models.size());

        for (StrutturaSanitariaFiglia model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new StrutturaSanitariaFigliaSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _idStrutturaFiglia;
    }

    public void setPrimaryKey(long pk) {
        setIdStrutturaFiglia(pk);
    }

    public long getIdStrutturaFiglia() {
        return _idStrutturaFiglia;
    }

    public void setIdStrutturaFiglia(long idStrutturaFiglia) {
        _idStrutturaFiglia = idStrutturaFiglia;
    }

    public String getTipoStruttura() {
        return _tipoStruttura;
    }

    public void setTipoStruttura(String tipoStruttura) {
        _tipoStruttura = tipoStruttura;
    }

    public String getDenominazione() {
        return _denominazione;
    }

    public void setDenominazione(String denominazione) {
        _denominazione = denominazione;
    }

    public String getIndirizzo() {
        return _indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        _indirizzo = indirizzo;
    }

    public String getDirettore() {
        return _direttore;
    }

    public void setDirettore(String direttore) {
        _direttore = direttore;
    }

    public String getResponsabileSanitario() {
        return _responsabileSanitario;
    }

    public void setResponsabileSanitario(String responsabileSanitario) {
        _responsabileSanitario = responsabileSanitario;
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
}
