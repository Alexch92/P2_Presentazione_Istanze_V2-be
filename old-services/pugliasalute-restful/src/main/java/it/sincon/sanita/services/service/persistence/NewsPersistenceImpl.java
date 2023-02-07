package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.sincon.sanita.services.NoSuchNewsException;
import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.model.impl.NewsImpl;
import it.sincon.sanita.services.model.impl.NewsModelImpl;
import it.sincon.sanita.services.service.persistence.NewsPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the news service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see NewsPersistence
 * @see NewsUtil
 * @generated
 */
public class NewsPersistenceImpl extends BasePersistenceImpl<News>
    implements NewsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link NewsUtil} to access the news persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = NewsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, NewsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_NEWS = "SELECT news FROM News news";
    private static final String _SQL_COUNT_NEWS = "SELECT COUNT(news) FROM News news";
    private static final String _ORDER_BY_ENTITY_ALIAS = "news.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No News exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(NewsPersistenceImpl.class);
    private static News _nullNews = new NewsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<News> toCacheModel() {
                return _nullNewsCacheModel;
            }
        };

    private static CacheModel<News> _nullNewsCacheModel = new CacheModel<News>() {
            @Override
            public News toEntityModel() {
                return _nullNews;
            }
        };

    public NewsPersistenceImpl() {
        setModelClass(News.class);
    }

    /**
     * Caches the news in the entity cache if it is enabled.
     *
     * @param news the news
     */
    @Override
    public void cacheResult(News news) {
        EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsImpl.class, news.getPrimaryKey(), news);

        news.resetOriginalValues();
    }

    /**
     * Caches the newses in the entity cache if it is enabled.
     *
     * @param newses the newses
     */
    @Override
    public void cacheResult(List<News> newses) {
        for (News news : newses) {
            if (EntityCacheUtil.getResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                        NewsImpl.class, news.getPrimaryKey()) == null) {
                cacheResult(news);
            } else {
                news.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all newses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(NewsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(NewsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the news.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(News news) {
        EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsImpl.class, news.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<News> newses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (News news : newses) {
            EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                NewsImpl.class, news.getPrimaryKey());
        }
    }

    /**
     * Creates a new news with the primary key. Does not add the news to the database.
     *
     * @param pk the primary key for the new news
     * @return the new news
     */
    @Override
    public News create(long pk) {
        News news = new NewsImpl();

        news.setNew(true);
        news.setPrimaryKey(pk);

        return news;
    }

    /**
     * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param pk the primary key of the news
     * @return the news that was removed
     * @throws it.sincon.sanita.services.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News remove(long pk) throws NoSuchNewsException, SystemException {
        return remove((Serializable) pk);
    }

    /**
     * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the news
     * @return the news that was removed
     * @throws it.sincon.sanita.services.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News remove(Serializable primaryKey)
        throws NoSuchNewsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            News news = (News) session.get(NewsImpl.class, primaryKey);

            if (news == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(news);
        } catch (NoSuchNewsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected News removeImpl(News news) throws SystemException {
        news = toUnwrappedModel(news);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(news)) {
                news = (News) session.get(NewsImpl.class,
                        news.getPrimaryKeyObj());
            }

            if (news != null) {
                session.delete(news);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (news != null) {
            clearCache(news);
        }

        return news;
    }

    @Override
    public News updateImpl(it.sincon.sanita.services.model.News news)
        throws SystemException {
        news = toUnwrappedModel(news);

        boolean isNew = news.isNew();

        Session session = null;

        try {
            session = openSession();

            if (news.isNew()) {
                session.save(news);

                news.setNew(false);
            } else {
                session.merge(news);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
            NewsImpl.class, news.getPrimaryKey(), news);

        return news;
    }

    protected News toUnwrappedModel(News news) {
        if (news instanceof NewsImpl) {
            return news;
        }

        NewsImpl newsImpl = new NewsImpl();

        newsImpl.setNew(news.isNew());
        newsImpl.setPrimaryKey(news.getPrimaryKey());

        newsImpl.setPk(news.getPk());
        newsImpl.setIdNews(news.getIdNews());
        newsImpl.setIdAzienda(news.getIdAzienda());
        newsImpl.setTitolo(news.getTitolo());
        newsImpl.setImmagine(news.getImmagine());
        newsImpl.setDescrizione(news.getDescrizione());
        newsImpl.setDataPubblicazione(news.getDataPubblicazione());
        newsImpl.setAutore(news.getAutore());
        newsImpl.setLocale(news.getLocale());

        return newsImpl;
    }

    /**
     * Returns the news with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the news
     * @return the news
     * @throws it.sincon.sanita.services.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News findByPrimaryKey(Serializable primaryKey)
        throws NoSuchNewsException, SystemException {
        News news = fetchByPrimaryKey(primaryKey);

        if (news == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return news;
    }

    /**
     * Returns the news with the primary key or throws a {@link it.sincon.sanita.services.NoSuchNewsException} if it could not be found.
     *
     * @param pk the primary key of the news
     * @return the news
     * @throws it.sincon.sanita.services.NoSuchNewsException if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News findByPrimaryKey(long pk)
        throws NoSuchNewsException, SystemException {
        return findByPrimaryKey((Serializable) pk);
    }

    /**
     * Returns the news with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the news
     * @return the news, or <code>null</code> if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        News news = (News) EntityCacheUtil.getResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                NewsImpl.class, primaryKey);

        if (news == _nullNews) {
            return null;
        }

        if (news == null) {
            Session session = null;

            try {
                session = openSession();

                news = (News) session.get(NewsImpl.class, primaryKey);

                if (news != null) {
                    cacheResult(news);
                } else {
                    EntityCacheUtil.putResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                        NewsImpl.class, primaryKey, _nullNews);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(NewsModelImpl.ENTITY_CACHE_ENABLED,
                    NewsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return news;
    }

    /**
     * Returns the news with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param pk the primary key of the news
     * @return the news, or <code>null</code> if a news with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public News fetchByPrimaryKey(long pk) throws SystemException {
        return fetchByPrimaryKey((Serializable) pk);
    }

    /**
     * Returns all the newses.
     *
     * @return the newses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<News> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the newses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @return the range of newses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<News> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the newses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of newses
     * @param end the upper bound of the range of newses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of newses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<News> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<News> list = (List<News>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_NEWS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_NEWS;

                if (pagination) {
                    sql = sql.concat(NewsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<News>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<News>(list);
                } else {
                    list = (List<News>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the newses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (News news : findAll()) {
            remove(news);
        }
    }

    /**
     * Returns the number of newses.
     *
     * @return the number of newses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_NEWS);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the news persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.sincon.sanita.services.model.News")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<News>> listenersList = new ArrayList<ModelListener<News>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<News>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(NewsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
