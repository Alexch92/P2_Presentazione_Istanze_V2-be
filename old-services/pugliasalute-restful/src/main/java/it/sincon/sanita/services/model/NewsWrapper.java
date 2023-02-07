package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link News}.
 * </p>
 *
 * @author Sincon
 * @see News
 * @generated
 */
public class NewsWrapper implements News, ModelWrapper<News> {
    private News _news;

    public NewsWrapper(News news) {
        _news = news;
    }

    @Override
    public Class<?> getModelClass() {
        return News.class;
    }

    @Override
    public String getModelClassName() {
        return News.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("pk", getPk());
        attributes.put("idNews", getIdNews());
        attributes.put("idAzienda", getIdAzienda());
        attributes.put("titolo", getTitolo());
        attributes.put("immagine", getImmagine());
        attributes.put("descrizione", getDescrizione());
        attributes.put("dataPubblicazione", getDataPubblicazione());
        attributes.put("autore", getAutore());
        attributes.put("locale", getLocale());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long pk = (Long) attributes.get("pk");

        if (pk != null) {
            setPk(pk);
        }

        Long idNews = (Long) attributes.get("idNews");

        if (idNews != null) {
            setIdNews(idNews);
        }

        String idAzienda = (String) attributes.get("idAzienda");

        if (idAzienda != null) {
            setIdAzienda(idAzienda);
        }

        String titolo = (String) attributes.get("titolo");

        if (titolo != null) {
            setTitolo(titolo);
        }

        String immagine = (String) attributes.get("immagine");

        if (immagine != null) {
            setImmagine(immagine);
        }

        String descrizione = (String) attributes.get("descrizione");

        if (descrizione != null) {
            setDescrizione(descrizione);
        }

        Long dataPubblicazione = (Long) attributes.get("dataPubblicazione");

        if (dataPubblicazione != null) {
            setDataPubblicazione(dataPubblicazione);
        }

        String autore = (String) attributes.get("autore");

        if (autore != null) {
            setAutore(autore);
        }

        String locale = (String) attributes.get("locale");

        if (locale != null) {
            setLocale(locale);
        }
    }

    /**
    * Returns the primary key of this news.
    *
    * @return the primary key of this news
    */
    @Override
    public long getPrimaryKey() {
        return _news.getPrimaryKey();
    }

    /**
    * Sets the primary key of this news.
    *
    * @param primaryKey the primary key of this news
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _news.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the pk of this news.
    *
    * @return the pk of this news
    */
    @Override
    public long getPk() {
        return _news.getPk();
    }

    /**
    * Sets the pk of this news.
    *
    * @param pk the pk of this news
    */
    @Override
    public void setPk(long pk) {
        _news.setPk(pk);
    }

    /**
    * Returns the id news of this news.
    *
    * @return the id news of this news
    */
    @Override
    public long getIdNews() {
        return _news.getIdNews();
    }

    /**
    * Sets the id news of this news.
    *
    * @param idNews the id news of this news
    */
    @Override
    public void setIdNews(long idNews) {
        _news.setIdNews(idNews);
    }

    /**
    * Returns the id azienda of this news.
    *
    * @return the id azienda of this news
    */
    @Override
    public java.lang.String getIdAzienda() {
        return _news.getIdAzienda();
    }

    /**
    * Sets the id azienda of this news.
    *
    * @param idAzienda the id azienda of this news
    */
    @Override
    public void setIdAzienda(java.lang.String idAzienda) {
        _news.setIdAzienda(idAzienda);
    }

    /**
    * Returns the titolo of this news.
    *
    * @return the titolo of this news
    */
    @Override
    public java.lang.String getTitolo() {
        return _news.getTitolo();
    }

    /**
    * Sets the titolo of this news.
    *
    * @param titolo the titolo of this news
    */
    @Override
    public void setTitolo(java.lang.String titolo) {
        _news.setTitolo(titolo);
    }

    /**
    * Returns the immagine of this news.
    *
    * @return the immagine of this news
    */
    @Override
    public java.lang.String getImmagine() {
        return _news.getImmagine();
    }

    /**
    * Sets the immagine of this news.
    *
    * @param immagine the immagine of this news
    */
    @Override
    public void setImmagine(java.lang.String immagine) {
        _news.setImmagine(immagine);
    }

    /**
    * Returns the descrizione of this news.
    *
    * @return the descrizione of this news
    */
    @Override
    public java.lang.String getDescrizione() {
        return _news.getDescrizione();
    }

    /**
    * Sets the descrizione of this news.
    *
    * @param descrizione the descrizione of this news
    */
    @Override
    public void setDescrizione(java.lang.String descrizione) {
        _news.setDescrizione(descrizione);
    }

    /**
    * Returns the data pubblicazione of this news.
    *
    * @return the data pubblicazione of this news
    */
    @Override
    public long getDataPubblicazione() {
        return _news.getDataPubblicazione();
    }

    /**
    * Sets the data pubblicazione of this news.
    *
    * @param dataPubblicazione the data pubblicazione of this news
    */
    @Override
    public void setDataPubblicazione(long dataPubblicazione) {
        _news.setDataPubblicazione(dataPubblicazione);
    }

    /**
    * Returns the autore of this news.
    *
    * @return the autore of this news
    */
    @Override
    public java.lang.String getAutore() {
        return _news.getAutore();
    }

    /**
    * Sets the autore of this news.
    *
    * @param autore the autore of this news
    */
    @Override
    public void setAutore(java.lang.String autore) {
        _news.setAutore(autore);
    }

    /**
    * Returns the locale of this news.
    *
    * @return the locale of this news
    */
    @Override
    public java.lang.String getLocale() {
        return _news.getLocale();
    }

    /**
    * Sets the locale of this news.
    *
    * @param locale the locale of this news
    */
    @Override
    public void setLocale(java.lang.String locale) {
        _news.setLocale(locale);
    }

    @Override
    public boolean isNew() {
        return _news.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _news.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _news.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _news.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _news.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _news.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _news.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _news.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _news.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _news.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _news.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new NewsWrapper((News) _news.clone());
    }

    @Override
    public int compareTo(it.sincon.sanita.services.model.News news) {
        return _news.compareTo(news);
    }

    @Override
    public int hashCode() {
        return _news.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<it.sincon.sanita.services.model.News> toCacheModel() {
        return _news.toCacheModel();
    }

    @Override
    public it.sincon.sanita.services.model.News toEscapedModel() {
        return new NewsWrapper(_news.toEscapedModel());
    }

    @Override
    public it.sincon.sanita.services.model.News toUnescapedModel() {
        return new NewsWrapper(_news.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _news.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _news.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _news.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NewsWrapper)) {
            return false;
        }

        NewsWrapper newsWrapper = (NewsWrapper) obj;

        if (Validator.equals(_news, newsWrapper._news)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public News getWrappedNews() {
        return _news;
    }

    @Override
    public News getWrappedModel() {
        return _news;
    }

    @Override
    public void resetOriginalValues() {
        _news.resetOriginalValues();
    }
}
