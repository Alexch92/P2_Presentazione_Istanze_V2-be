package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.sincon.sanita.services.service.ClpSerializer;
import it.sincon.sanita.services.service.NewsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class NewsClp extends BaseModelImpl<News> implements News {
    private long _pk;
    private long _idNews;
    private String _idAzienda;
    private String _titolo;
    private String _immagine;
    private String _descrizione;
    private long _dataPubblicazione;
    private String _autore;
    private String _locale;
    private BaseModel<?> _newsRemoteModel;

    public NewsClp() {
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

    @Override
    public long getPk() {
        return _pk;
    }

    @Override
    public void setPk(long pk) {
        _pk = pk;

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setPk", long.class);

                method.invoke(_newsRemoteModel, pk);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getIdNews() {
        return _idNews;
    }

    @Override
    public void setIdNews(long idNews) {
        _idNews = idNews;

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setIdNews", long.class);

                method.invoke(_newsRemoteModel, idNews);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIdAzienda() {
        return _idAzienda;
    }

    @Override
    public void setIdAzienda(String idAzienda) {
        _idAzienda = idAzienda;

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setIdAzienda", String.class);

                method.invoke(_newsRemoteModel, idAzienda);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitolo() {
        return _titolo;
    }

    @Override
    public void setTitolo(String titolo) {
        _titolo = titolo;

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setTitolo", String.class);

                method.invoke(_newsRemoteModel, titolo);
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

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setImmagine", String.class);

                method.invoke(_newsRemoteModel, immagine);
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

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setDescrizione", String.class);

                method.invoke(_newsRemoteModel, descrizione);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDataPubblicazione() {
        return _dataPubblicazione;
    }

    @Override
    public void setDataPubblicazione(long dataPubblicazione) {
        _dataPubblicazione = dataPubblicazione;

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setDataPubblicazione",
                        long.class);

                method.invoke(_newsRemoteModel, dataPubblicazione);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAutore() {
        return _autore;
    }

    @Override
    public void setAutore(String autore) {
        _autore = autore;

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setAutore", String.class);

                method.invoke(_newsRemoteModel, autore);
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

        if (_newsRemoteModel != null) {
            try {
                Class<?> clazz = _newsRemoteModel.getClass();

                Method method = clazz.getMethod("setLocale", String.class);

                method.invoke(_newsRemoteModel, locale);
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

    public BaseModel<?> getNewsRemoteModel() {
        return _newsRemoteModel;
    }

    public void setNewsRemoteModel(BaseModel<?> newsRemoteModel) {
        _newsRemoteModel = newsRemoteModel;
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

        Class<?> remoteModelClass = _newsRemoteModel.getClass();

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

        Object returnValue = method.invoke(_newsRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            NewsLocalServiceUtil.addNews(this);
        } else {
            NewsLocalServiceUtil.updateNews(this);
        }
    }

    @Override
    public News toEscapedModel() {
        return (News) ProxyUtil.newProxyInstance(News.class.getClassLoader(),
            new Class[] { News.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        NewsClp clone = new NewsClp();

        clone.setPk(getPk());
        clone.setIdNews(getIdNews());
        clone.setIdAzienda(getIdAzienda());
        clone.setTitolo(getTitolo());
        clone.setImmagine(getImmagine());
        clone.setDescrizione(getDescrizione());
        clone.setDataPubblicazione(getDataPubblicazione());
        clone.setAutore(getAutore());
        clone.setLocale(getLocale());

        return clone;
    }

    @Override
    public int compareTo(News news) {
        long primaryKey = news.getPrimaryKey();

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

        if (!(obj instanceof NewsClp)) {
            return false;
        }

        NewsClp news = (NewsClp) obj;

        long primaryKey = news.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{pk=");
        sb.append(getPk());
        sb.append(", idNews=");
        sb.append(getIdNews());
        sb.append(", idAzienda=");
        sb.append(getIdAzienda());
        sb.append(", titolo=");
        sb.append(getTitolo());
        sb.append(", immagine=");
        sb.append(getImmagine());
        sb.append(", descrizione=");
        sb.append(getDescrizione());
        sb.append(", dataPubblicazione=");
        sb.append(getDataPubblicazione());
        sb.append(", autore=");
        sb.append(getAutore());
        sb.append(", locale=");
        sb.append(getLocale());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("it.sincon.sanita.services.model.News");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>pk</column-name><column-value><![CDATA[");
        sb.append(getPk());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>idNews</column-name><column-value><![CDATA[");
        sb.append(getIdNews());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>idAzienda</column-name><column-value><![CDATA[");
        sb.append(getIdAzienda());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>titolo</column-name><column-value><![CDATA[");
        sb.append(getTitolo());
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
            "<column><column-name>dataPubblicazione</column-name><column-value><![CDATA[");
        sb.append(getDataPubblicazione());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>autore</column-name><column-value><![CDATA[");
        sb.append(getAutore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>locale</column-name><column-value><![CDATA[");
        sb.append(getLocale());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
