package it.sincon.sanita.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Sincon
 * @generated
 */
public class CFG_CategorieAbilitateSoap implements Serializable {
    private String _titoloStruttura;
    private String _denominazione;
    private int _ordine;
    private String _className;
    private boolean _defaultRicerca;

    public CFG_CategorieAbilitateSoap() {
    }

    public static CFG_CategorieAbilitateSoap toSoapModel(
        CFG_CategorieAbilitate model) {
        CFG_CategorieAbilitateSoap soapModel = new CFG_CategorieAbilitateSoap();

        soapModel.setTitoloStruttura(model.getTitoloStruttura());
        soapModel.setDenominazione(model.getDenominazione());
        soapModel.setOrdine(model.getOrdine());
        soapModel.setClassName(model.getClassName());
        soapModel.setDefaultRicerca(model.getDefaultRicerca());

        return soapModel;
    }

    public static CFG_CategorieAbilitateSoap[] toSoapModels(
        CFG_CategorieAbilitate[] models) {
        CFG_CategorieAbilitateSoap[] soapModels = new CFG_CategorieAbilitateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CFG_CategorieAbilitateSoap[][] toSoapModels(
        CFG_CategorieAbilitate[][] models) {
        CFG_CategorieAbilitateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CFG_CategorieAbilitateSoap[models.length][models[0].length];
        } else {
            soapModels = new CFG_CategorieAbilitateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CFG_CategorieAbilitateSoap[] toSoapModels(
        List<CFG_CategorieAbilitate> models) {
        List<CFG_CategorieAbilitateSoap> soapModels = new ArrayList<CFG_CategorieAbilitateSoap>(models.size());

        for (CFG_CategorieAbilitate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CFG_CategorieAbilitateSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _titoloStruttura;
    }

    public void setPrimaryKey(String pk) {
        setTitoloStruttura(pk);
    }

    public String getTitoloStruttura() {
        return _titoloStruttura;
    }

    public void setTitoloStruttura(String titoloStruttura) {
        _titoloStruttura = titoloStruttura;
    }

    public String getDenominazione() {
        return _denominazione;
    }

    public void setDenominazione(String denominazione) {
        _denominazione = denominazione;
    }

    public int getOrdine() {
        return _ordine;
    }

    public void setOrdine(int ordine) {
        _ordine = ordine;
    }

    public String getClassName() {
        return _className;
    }

    public void setClassName(String className) {
        _className = className;
    }

    public boolean getDefaultRicerca() {
        return _defaultRicerca;
    }

    public boolean isDefaultRicerca() {
        return _defaultRicerca;
    }

    public void setDefaultRicerca(boolean defaultRicerca) {
        _defaultRicerca = defaultRicerca;
    }
}
