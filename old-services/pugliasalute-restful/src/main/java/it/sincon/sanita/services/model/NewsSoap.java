package it.sincon.sanita.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.sincon.sanita.services.service.http.NewsServiceSoap}.
 *
 * @author Sincon
 * @see it.sincon.sanita.services.service.http.NewsServiceSoap
 * @generated
 */
public class NewsSoap implements Serializable {
    private long _pk;
    private long _idNews;
    private String _idAzienda;
    private String _titolo;
    private String _immagine;
    private String _descrizione;
    private long _dataPubblicazione;
    private String _autore;
    private String _locale;

    public NewsSoap() {
    }

    public static NewsSoap toSoapModel(News model) {
        NewsSoap soapModel = new NewsSoap();

        soapModel.setPk(model.getPk());
        soapModel.setIdNews(model.getIdNews());
        soapModel.setIdAzienda(model.getIdAzienda());
        soapModel.setTitolo(model.getTitolo());
        soapModel.setImmagine(model.getImmagine());
        soapModel.setDescrizione(model.getDescrizione());
        soapModel.setDataPubblicazione(model.getDataPubblicazione());
        soapModel.setAutore(model.getAutore());
        soapModel.setLocale(model.getLocale());

        return soapModel;
    }

    public static NewsSoap[] toSoapModels(News[] models) {
        NewsSoap[] soapModels = new NewsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static NewsSoap[][] toSoapModels(News[][] models) {
        NewsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new NewsSoap[models.length][models[0].length];
        } else {
            soapModels = new NewsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static NewsSoap[] toSoapModels(List<News> models) {
        List<NewsSoap> soapModels = new ArrayList<NewsSoap>(models.size());

        for (News model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NewsSoap[soapModels.size()]);
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

    public long getIdNews() {
        return _idNews;
    }

    public void setIdNews(long idNews) {
        _idNews = idNews;
    }

    public String getIdAzienda() {
        return _idAzienda;
    }

    public void setIdAzienda(String idAzienda) {
        _idAzienda = idAzienda;
    }

    public String getTitolo() {
        return _titolo;
    }

    public void setTitolo(String titolo) {
        _titolo = titolo;
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

    public long getDataPubblicazione() {
        return _dataPubblicazione;
    }

    public void setDataPubblicazione(long dataPubblicazione) {
        _dataPubblicazione = dataPubblicazione;
    }

    public String getAutore() {
        return _autore;
    }

    public void setAutore(String autore) {
        _autore = autore;
    }

    public String getLocale() {
        return _locale;
    }

    public void setLocale(String locale) {
        _locale = locale;
    }
}
