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

import it.sincon.sanita.services.NoSuchCategoriaStrutturaException;
import it.sincon.sanita.services.model.CategoriaStruttura;
import it.sincon.sanita.services.model.impl.CategoriaStrutturaImpl;
import it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl;
import it.sincon.sanita.services.service.persistence.CategoriaStrutturaPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the categoria struttura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see CategoriaStrutturaPersistence
 * @see CategoriaStrutturaUtil
 * @generated
 */
public class CategoriaStrutturaPersistenceImpl extends BasePersistenceImpl<CategoriaStruttura>
    implements CategoriaStrutturaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CategoriaStrutturaUtil} to access the categoria struttura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CategoriaStrutturaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
            CategoriaStrutturaModelImpl.FINDER_CACHE_ENABLED,
            CategoriaStrutturaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
            CategoriaStrutturaModelImpl.FINDER_CACHE_ENABLED,
            CategoriaStrutturaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
            CategoriaStrutturaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CATEGORIASTRUTTURA = "SELECT categoriaStruttura FROM CategoriaStruttura categoriaStruttura";
    private static final String _SQL_COUNT_CATEGORIASTRUTTURA = "SELECT COUNT(categoriaStruttura) FROM CategoriaStruttura categoriaStruttura";
    private static final String _ORDER_BY_ENTITY_ALIAS = "categoriaStruttura.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CategoriaStruttura exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CategoriaStrutturaPersistenceImpl.class);
    private static CategoriaStruttura _nullCategoriaStruttura = new CategoriaStrutturaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<CategoriaStruttura> toCacheModel() {
                return _nullCategoriaStrutturaCacheModel;
            }
        };

    private static CacheModel<CategoriaStruttura> _nullCategoriaStrutturaCacheModel =
        new CacheModel<CategoriaStruttura>() {
            @Override
            public CategoriaStruttura toEntityModel() {
                return _nullCategoriaStruttura;
            }
        };

    public CategoriaStrutturaPersistenceImpl() {
        setModelClass(CategoriaStruttura.class);
    }

    /**
     * Caches the categoria struttura in the entity cache if it is enabled.
     *
     * @param categoriaStruttura the categoria struttura
     */
    @Override
    public void cacheResult(CategoriaStruttura categoriaStruttura) {
        EntityCacheUtil.putResult(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
            CategoriaStrutturaImpl.class, categoriaStruttura.getPrimaryKey(),
            categoriaStruttura);

        categoriaStruttura.resetOriginalValues();
    }

    /**
     * Caches the categoria strutturas in the entity cache if it is enabled.
     *
     * @param categoriaStrutturas the categoria strutturas
     */
    @Override
    public void cacheResult(List<CategoriaStruttura> categoriaStrutturas) {
        for (CategoriaStruttura categoriaStruttura : categoriaStrutturas) {
            if (EntityCacheUtil.getResult(
                        CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
                        CategoriaStrutturaImpl.class,
                        categoriaStruttura.getPrimaryKey()) == null) {
                cacheResult(categoriaStruttura);
            } else {
                categoriaStruttura.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all categoria strutturas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CategoriaStrutturaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CategoriaStrutturaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the categoria struttura.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(CategoriaStruttura categoriaStruttura) {
        EntityCacheUtil.removeResult(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
            CategoriaStrutturaImpl.class, categoriaStruttura.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<CategoriaStruttura> categoriaStrutturas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (CategoriaStruttura categoriaStruttura : categoriaStrutturas) {
            EntityCacheUtil.removeResult(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
                CategoriaStrutturaImpl.class, categoriaStruttura.getPrimaryKey());
        }
    }

    /**
     * Creates a new categoria struttura with the primary key. Does not add the categoria struttura to the database.
     *
     * @param idTipoStruttura the primary key for the new categoria struttura
     * @return the new categoria struttura
     */
    @Override
    public CategoriaStruttura create(String idTipoStruttura) {
        CategoriaStruttura categoriaStruttura = new CategoriaStrutturaImpl();

        categoriaStruttura.setNew(true);
        categoriaStruttura.setPrimaryKey(idTipoStruttura);

        return categoriaStruttura;
    }

    /**
     * Removes the categoria struttura with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param idTipoStruttura the primary key of the categoria struttura
     * @return the categoria struttura that was removed
     * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CategoriaStruttura remove(String idTipoStruttura)
        throws NoSuchCategoriaStrutturaException, SystemException {
        return remove((Serializable) idTipoStruttura);
    }

    /**
     * Removes the categoria struttura with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the categoria struttura
     * @return the categoria struttura that was removed
     * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CategoriaStruttura remove(Serializable primaryKey)
        throws NoSuchCategoriaStrutturaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CategoriaStruttura categoriaStruttura = (CategoriaStruttura) session.get(CategoriaStrutturaImpl.class,
                    primaryKey);

            if (categoriaStruttura == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCategoriaStrutturaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(categoriaStruttura);
        } catch (NoSuchCategoriaStrutturaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected CategoriaStruttura removeImpl(
        CategoriaStruttura categoriaStruttura) throws SystemException {
        categoriaStruttura = toUnwrappedModel(categoriaStruttura);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(categoriaStruttura)) {
                categoriaStruttura = (CategoriaStruttura) session.get(CategoriaStrutturaImpl.class,
                        categoriaStruttura.getPrimaryKeyObj());
            }

            if (categoriaStruttura != null) {
                session.delete(categoriaStruttura);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (categoriaStruttura != null) {
            clearCache(categoriaStruttura);
        }

        return categoriaStruttura;
    }

    @Override
    public CategoriaStruttura updateImpl(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws SystemException {
        categoriaStruttura = toUnwrappedModel(categoriaStruttura);

        boolean isNew = categoriaStruttura.isNew();

        Session session = null;

        try {
            session = openSession();

            if (categoriaStruttura.isNew()) {
                session.save(categoriaStruttura);

                categoriaStruttura.setNew(false);
            } else {
                session.merge(categoriaStruttura);
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

        EntityCacheUtil.putResult(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
            CategoriaStrutturaImpl.class, categoriaStruttura.getPrimaryKey(),
            categoriaStruttura);

        return categoriaStruttura;
    }

    protected CategoriaStruttura toUnwrappedModel(
        CategoriaStruttura categoriaStruttura) {
        if (categoriaStruttura instanceof CategoriaStrutturaImpl) {
            return categoriaStruttura;
        }

        CategoriaStrutturaImpl categoriaStrutturaImpl = new CategoriaStrutturaImpl();

        categoriaStrutturaImpl.setNew(categoriaStruttura.isNew());
        categoriaStrutturaImpl.setPrimaryKey(categoriaStruttura.getPrimaryKey());

        categoriaStrutturaImpl.setIdTipoStruttura(categoriaStruttura.getIdTipoStruttura());
        categoriaStrutturaImpl.setDenominazione(categoriaStruttura.getDenominazione());

        return categoriaStrutturaImpl;
    }

    /**
     * Returns the categoria struttura with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the categoria struttura
     * @return the categoria struttura
     * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CategoriaStruttura findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCategoriaStrutturaException, SystemException {
        CategoriaStruttura categoriaStruttura = fetchByPrimaryKey(primaryKey);

        if (categoriaStruttura == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCategoriaStrutturaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return categoriaStruttura;
    }

    /**
     * Returns the categoria struttura with the primary key or throws a {@link it.sincon.sanita.services.NoSuchCategoriaStrutturaException} if it could not be found.
     *
     * @param idTipoStruttura the primary key of the categoria struttura
     * @return the categoria struttura
     * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CategoriaStruttura findByPrimaryKey(String idTipoStruttura)
        throws NoSuchCategoriaStrutturaException, SystemException {
        return findByPrimaryKey((Serializable) idTipoStruttura);
    }

    /**
     * Returns the categoria struttura with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the categoria struttura
     * @return the categoria struttura, or <code>null</code> if a categoria struttura with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CategoriaStruttura fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        CategoriaStruttura categoriaStruttura = (CategoriaStruttura) EntityCacheUtil.getResult(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
                CategoriaStrutturaImpl.class, primaryKey);

        if (categoriaStruttura == _nullCategoriaStruttura) {
            return null;
        }

        if (categoriaStruttura == null) {
            Session session = null;

            try {
                session = openSession();

                categoriaStruttura = (CategoriaStruttura) session.get(CategoriaStrutturaImpl.class,
                        primaryKey);

                if (categoriaStruttura != null) {
                    cacheResult(categoriaStruttura);
                } else {
                    EntityCacheUtil.putResult(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
                        CategoriaStrutturaImpl.class, primaryKey,
                        _nullCategoriaStruttura);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CategoriaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
                    CategoriaStrutturaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return categoriaStruttura;
    }

    /**
     * Returns the categoria struttura with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param idTipoStruttura the primary key of the categoria struttura
     * @return the categoria struttura, or <code>null</code> if a categoria struttura with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CategoriaStruttura fetchByPrimaryKey(String idTipoStruttura)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) idTipoStruttura);
    }

    /**
     * Returns all the categoria strutturas.
     *
     * @return the categoria strutturas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CategoriaStruttura> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the categoria strutturas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of categoria strutturas
     * @param end the upper bound of the range of categoria strutturas (not inclusive)
     * @return the range of categoria strutturas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CategoriaStruttura> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the categoria strutturas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of categoria strutturas
     * @param end the upper bound of the range of categoria strutturas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of categoria strutturas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CategoriaStruttura> findAll(int start, int end,
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

        List<CategoriaStruttura> list = (List<CategoriaStruttura>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CATEGORIASTRUTTURA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CATEGORIASTRUTTURA;

                if (pagination) {
                    sql = sql.concat(CategoriaStrutturaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<CategoriaStruttura>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<CategoriaStruttura>(list);
                } else {
                    list = (List<CategoriaStruttura>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the categoria strutturas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (CategoriaStruttura categoriaStruttura : findAll()) {
            remove(categoriaStruttura);
        }
    }

    /**
     * Returns the number of categoria strutturas.
     *
     * @return the number of categoria strutturas
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

                Query q = session.createQuery(_SQL_COUNT_CATEGORIASTRUTTURA);

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
     * Initializes the categoria struttura persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.sincon.sanita.services.model.CategoriaStruttura")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<CategoriaStruttura>> listenersList = new ArrayList<ModelListener<CategoriaStruttura>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<CategoriaStruttura>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CategoriaStrutturaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
