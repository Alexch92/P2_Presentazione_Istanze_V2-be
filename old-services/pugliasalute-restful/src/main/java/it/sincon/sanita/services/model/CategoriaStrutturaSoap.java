package it.sincon.sanita.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.sincon.sanita.services.service.http.CategoriaStrutturaServiceSoap}.
 *
 * @author Sincon
 * @see it.sincon.sanita.services.service.http.CategoriaStrutturaServiceSoap
 * @generated
 */
public class CategoriaStrutturaSoap implements Serializable {
    private String _idTipoStruttura;
    private String _denominazione;

    public CategoriaStrutturaSoap() {
    }

    public static CategoriaStrutturaSoap toSoapModel(CategoriaStruttura model) {
        CategoriaStrutturaSoap soapModel = new CategoriaStrutturaSoap();

        soapModel.setIdTipoStruttura(model.getIdTipoStruttura());
        soapModel.setDenominazione(model.getDenominazione());

        return soapModel;
    }

    public static CategoriaStrutturaSoap[] toSoapModels(
        CategoriaStruttura[] models) {
        CategoriaStrutturaSoap[] soapModels = new CategoriaStrutturaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CategoriaStrutturaSoap[][] toSoapModels(
        CategoriaStruttura[][] models) {
        CategoriaStrutturaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CategoriaStrutturaSoap[models.length][models[0].length];
        } else {
            soapModels = new CategoriaStrutturaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CategoriaStrutturaSoap[] toSoapModels(
        List<CategoriaStruttura> models) {
        List<CategoriaStrutturaSoap> soapModels = new ArrayList<CategoriaStrutturaSoap>(models.size());

        for (CategoriaStruttura model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CategoriaStrutturaSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _idTipoStruttura;
    }

    public void setPrimaryKey(String pk) {
        setIdTipoStruttura(pk);
    }

    public String getIdTipoStruttura() {
        return _idTipoStruttura;
    }

    public void setIdTipoStruttura(String idTipoStruttura) {
        _idTipoStruttura = idTipoStruttura;
    }

    public String getDenominazione() {
        return _denominazione;
    }

    public void setDenominazione(String denominazione) {
        _denominazione = denominazione;
    }
}
