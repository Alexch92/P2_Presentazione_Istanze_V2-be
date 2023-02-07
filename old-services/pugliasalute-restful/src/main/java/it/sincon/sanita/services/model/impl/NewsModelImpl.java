package it.sincon.sanita.services.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.NewsModel;
import it.sincon.sanita.services.model.NewsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the News service. Represents a row in the &quot;SANITAREST_News&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link it.sincon.sanita.services.model.NewsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsImpl}.
 * </p>
 *
 * @author Sincon
 * @see NewsImpl
 * @see it.sincon.sanita.services.model.News
 * @see it.sincon.sanita.services.model.NewsModel
 * @generated
 */
@JSON(strict = true)
public class NewsModelImpl extends BaseModelImpl<News> implements NewsModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a news model instance should use the {@link it.sincon.sanita.services.model.News} interface instead.
     */
    public static final String TABLE_NAME = "SANITAREST_News";
    public static final Object[][] TABLE_COLUMNS = {
            { "pk", Types.BIGINT },
            { "idNews", Types.BIGINT },
            { "idAzienda", Types.VARCHAR },
            { "titolo", Types.VARCHAR },
            { "immagine", Types.VARCHAR },
            { "descrizione", Types.VARCHAR },
            { "dataPubblicazione", Types.BIGINT },
            { "autore", Types.VARCHAR },
            { "locale", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table SANITAREST_News (pk LONG not null primary key,idNews LONG,idAzienda VARCHAR(75) null,titolo VARCHAR(2000) null,immagine VARCHAR(255) null,descrizione TEXT null,dataPubblicazione LONG,autore VARCHAR(255) null,locale VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table SANITAREST_News";
    public static final String ORDER_BY_JPQL = " ORDER BY news.pk ASC";
    public static final String ORDER_BY_SQL = " ORDER BY SANITAREST_News.pk ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.it.sincon.sanita.services.model.News"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.it.sincon.sanita.services.model.News"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.it.sincon.sanita.services.model.News"));
    private static ClassLoader _classLoader = News.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { News.class };
    private long _pk;
    private long _idNews;
    private String _idAzienda;
    private String _titolo;
    private String _immagine;
    private String _descrizione;
    private long _dataPubblicazione;
    private String _autore;
    private String _locale;
    private News _escapedModel;

    public NewsModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static News toModel(NewsSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        News model = new NewsImpl();

        model.setPk(soapModel.getPk());
        model.setIdNews(soapModel.getIdNews());
        model.setIdAzienda(soapModel.getIdAzienda());
        model.setTitolo(soapModel.getTitolo());
        model.setImmagine(soapModel.getImmagine());
        model.setDescrizione(soapModel.getDescrizione());
        model.setDataPubblicazione(soapModel.getDataPubblicazione());
        model.setAutore(soapModel.getAutore());
        model.setLocale(soapModel.getLocale());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<News> toModels(NewsSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<News> models = new ArrayList<News>(soapModels.length);

        for (NewsSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
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

    @JSON(include = false)
    @Override
    public long getPk() {
        return _pk;
    }

    @Override
    public void setPk(long pk) {
        _pk = pk;
    }

    @JSON
    @Override
    public long getIdNews() {
        return _idNews;
    }

    @Override
    public void setIdNews(long idNews) {
        _idNews = idNews;
    }

    @JSON(include = false)
    @Override
    public String getIdAzienda() {
        if (_idAzienda == null) {
            return StringPool.BLANK;
        } else {
            return _idAzienda;
        }
    }

    @Override
    public void setIdAzienda(String idAzienda) {
        _idAzienda = idAzienda;
    }

    @JSON
    @Override
    public String getTitolo() {
        if (_titolo == null) {
            return StringPool.BLANK;
        } else {
            return _titolo;
        }
    }

    @Override
    public void setTitolo(String titolo) {
        _titolo = titolo;
    }

    @JSON
    @Override
    public String getImmagine() {
        if (_immagine == null) {
            return StringPool.BLANK;
        } else {
            return _immagine;
        }
    }

    @Override
    public void setImmagine(String immagine) {
        _immagine = immagine;
    }

    @JSON
    @Override
    public String getDescrizione() {
        if (_descrizione == null) {
            return StringPool.BLANK;
        } else {
            return _descrizione;
        }
    }

    @Override
    public void setDescrizione(String descrizione) {
        _descrizione = descrizione;
    }

    @JSON
    @Override
    public long getDataPubblicazione() {
        return _dataPubblicazione;
    }

    @Override
    public void setDataPubblicazione(long dataPubblicazione) {
        _dataPubblicazione = dataPubblicazione;
    }

    @JSON
    @Override
    public String getAutore() {
        if (_autore == null) {
            return StringPool.BLANK;
        } else {
            return _autore;
        }
    }

    @Override
    public void setAutore(String autore) {
        _autore = autore;
    }

    @JSON(include = false)
    @Override
    public String getLocale() {
        if (_locale == null) {
            return StringPool.BLANK;
        } else {
            return _locale;
        }
    }

    @Override
    public void setLocale(String locale) {
        _locale = locale;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            News.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public News toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (News) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        NewsImpl newsImpl = new NewsImpl();

        newsImpl.setPk(getPk());
        newsImpl.setIdNews(getIdNews());
        newsImpl.setIdAzienda(getIdAzienda());
        newsImpl.setTitolo(getTitolo());
        newsImpl.setImmagine(getImmagine());
        newsImpl.setDescrizione(getDescrizione());
        newsImpl.setDataPubblicazione(getDataPubblicazione());
        newsImpl.setAutore(getAutore());
        newsImpl.setLocale(getLocale());

        newsImpl.resetOriginalValues();

        return newsImpl;
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

        if (!(obj instanceof News)) {
            return false;
        }

        News news = (News) obj;

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
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<News> toCacheModel() {
        NewsCacheModel newsCacheModel = new NewsCacheModel();

        newsCacheModel.pk = getPk();

        newsCacheModel.idNews = getIdNews();

        newsCacheModel.idAzienda = getIdAzienda();

        String idAzienda = newsCacheModel.idAzienda;

        if ((idAzienda != null) && (idAzienda.length() == 0)) {
            newsCacheModel.idAzienda = null;
        }

        newsCacheModel.titolo = getTitolo();

        String titolo = newsCacheModel.titolo;

        if ((titolo != null) && (titolo.length() == 0)) {
            newsCacheModel.titolo = null;
        }

        newsCacheModel.immagine = getImmagine();

        String immagine = newsCacheModel.immagine;

        if ((immagine != null) && (immagine.length() == 0)) {
            newsCacheModel.immagine = null;
        }

        newsCacheModel.descrizione = getDescrizione();

        String descrizione = newsCacheModel.descrizione;

        if ((descrizione != null) && (descrizione.length() == 0)) {
            newsCacheModel.descrizione = null;
        }

        newsCacheModel.dataPubblicazione = getDataPubblicazione();

        newsCacheModel.autore = getAutore();

        String autore = newsCacheModel.autore;

        if ((autore != null) && (autore.length() == 0)) {
            newsCacheModel.autore = null;
        }

        newsCacheModel.locale = getLocale();

        String locale = newsCacheModel.locale;

        if ((locale != null) && (locale.length() == 0)) {
            newsCacheModel.locale = null;
        }

        return newsCacheModel;
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