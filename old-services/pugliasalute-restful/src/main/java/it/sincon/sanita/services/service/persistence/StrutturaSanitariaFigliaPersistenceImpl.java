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

import it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException;
import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;
import it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaImpl;
import it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaModelImpl;
import it.sincon.sanita.services.service.persistence.StrutturaSanitariaFigliaPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the struttura sanitaria figlia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitariaFigliaPersistence
 * @see StrutturaSanitariaFigliaUtil
 * @generated
 */
public class StrutturaSanitariaFigliaPersistenceImpl extends BasePersistenceImpl<StrutturaSanitariaFiglia>
    implements StrutturaSanitariaFigliaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link StrutturaSanitariaFigliaUtil} to access the struttura sanitaria figlia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = StrutturaSanitariaFigliaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaFigliaModelImpl.FINDER_CACHE_ENABLED,
            StrutturaSanitariaFigliaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaFigliaModelImpl.FINDER_CACHE_ENABLED,
            StrutturaSanitariaFigliaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaFigliaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_STRUTTURASANITARIAFIGLIA = "SELECT strutturaSanitariaFiglia FROM StrutturaSanitariaFiglia strutturaSanitariaFiglia";
    private static final String _SQL_COUNT_STRUTTURASANITARIAFIGLIA = "SELECT COUNT(strutturaSanitariaFiglia) FROM StrutturaSanitariaFiglia strutturaSanitariaFiglia";
    private static final String _ORDER_BY_ENTITY_ALIAS = "strutturaSanitariaFiglia.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StrutturaSanitariaFiglia exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(StrutturaSanitariaFigliaPersistenceImpl.class);
    private static StrutturaSanitariaFiglia _nullStrutturaSanitariaFiglia = new StrutturaSanitariaFigliaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<StrutturaSanitariaFiglia> toCacheModel() {
                return _nullStrutturaSanitariaFigliaCacheModel;
            }
        };

    private static CacheModel<StrutturaSanitariaFiglia> _nullStrutturaSanitariaFigliaCacheModel =
        new CacheModel<StrutturaSanitariaFiglia>() {
            @Override
            public StrutturaSanitariaFiglia toEntityModel() {
                return _nullStrutturaSanitariaFiglia;
            }
        };

    public StrutturaSanitariaFigliaPersistenceImpl() {
        setModelClass(StrutturaSanitariaFiglia.class);
    }

    /**
     * Caches the struttura sanitaria figlia in the entity cache if it is enabled.
     *
     * @param strutturaSanitariaFiglia the struttura sanitaria figlia
     */
    @Override
    public void cacheResult(StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        EntityCacheUtil.putResult(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaFigliaImpl.class,
            strutturaSanitariaFiglia.getPrimaryKey(), strutturaSanitariaFiglia);

        strutturaSanitariaFiglia.resetOriginalValues();
    }

    /**
     * Caches the struttura sanitaria figlias in the entity cache if it is enabled.
     *
     * @param strutturaSanitariaFiglias the struttura sanitaria figlias
     */
    @Override
    public void cacheResult(
        List<StrutturaSanitariaFiglia> strutturaSanitariaFiglias) {
        for (StrutturaSanitariaFiglia strutturaSanitariaFiglia : strutturaSanitariaFiglias) {
            if (EntityCacheUtil.getResult(
                        StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
                        StrutturaSanitariaFigliaImpl.class,
                        strutturaSanitariaFiglia.getPrimaryKey()) == null) {
                cacheResult(strutturaSanitariaFiglia);
            } else {
                strutturaSanitariaFiglia.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all struttura sanitaria figlias.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(StrutturaSanitariaFigliaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(StrutturaSanitariaFigliaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the struttura sanitaria figlia.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        EntityCacheUtil.removeResult(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaFigliaImpl.class,
            strutturaSanitariaFiglia.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<StrutturaSanitariaFiglia> strutturaSanitariaFiglias) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (StrutturaSanitariaFiglia strutturaSanitariaFiglia : strutturaSanitariaFiglias) {
            EntityCacheUtil.removeResult(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
                StrutturaSanitariaFigliaImpl.class,
                strutturaSanitariaFiglia.getPrimaryKey());
        }
    }

    /**
     * Creates a new struttura sanitaria figlia with the primary key. Does not add the struttura sanitaria figlia to the database.
     *
     * @param idStrutturaFiglia the primary key for the new struttura sanitaria figlia
     * @return the new struttura sanitaria figlia
     */
    @Override
    public StrutturaSanitariaFiglia create(long idStrutturaFiglia) {
        StrutturaSanitariaFiglia strutturaSanitariaFiglia = new StrutturaSanitariaFigliaImpl();

        strutturaSanitariaFiglia.setNew(true);
        strutturaSanitariaFiglia.setPrimaryKey(idStrutturaFiglia);

        return strutturaSanitariaFiglia;
    }

    /**
     * Removes the struttura sanitaria figlia with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
     * @return the struttura sanitaria figlia that was removed
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitariaFiglia remove(long idStrutturaFiglia)
        throws NoSuchStrutturaSanitariaFigliaException, SystemException {
        return remove((Serializable) idStrutturaFiglia);
    }

    /**
     * Removes the struttura sanitaria figlia with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the struttura sanitaria figlia
     * @return the struttura sanitaria figlia that was removed
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitariaFiglia remove(Serializable primaryKey)
        throws NoSuchStrutturaSanitariaFigliaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            StrutturaSanitariaFiglia strutturaSanitariaFiglia = (StrutturaSanitariaFiglia) session.get(StrutturaSanitariaFigliaImpl.class,
                    primaryKey);

            if (strutturaSanitariaFiglia == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchStrutturaSanitariaFigliaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(strutturaSanitariaFiglia);
        } catch (NoSuchStrutturaSanitariaFigliaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected StrutturaSanitariaFiglia removeImpl(
        StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws SystemException {
        strutturaSanitariaFiglia = toUnwrappedModel(strutturaSanitariaFiglia);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(strutturaSanitariaFiglia)) {
                strutturaSanitariaFiglia = (StrutturaSanitariaFiglia) session.get(StrutturaSanitariaFigliaImpl.class,
                        strutturaSanitariaFiglia.getPrimaryKeyObj());
            }

            if (strutturaSanitariaFiglia != null) {
                session.delete(strutturaSanitariaFiglia);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (strutturaSanitariaFiglia != null) {
            clearCache(strutturaSanitariaFiglia);
        }

        return strutturaSanitariaFiglia;
    }

    @Override
    public StrutturaSanitariaFiglia updateImpl(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws SystemException {
        strutturaSanitariaFiglia = toUnwrappedModel(strutturaSanitariaFiglia);

        boolean isNew = strutturaSanitariaFiglia.isNew();

        Session session = null;

        try {
            session = openSession();

            if (strutturaSanitariaFiglia.isNew()) {
                session.save(strutturaSanitariaFiglia);

                strutturaSanitariaFiglia.setNew(false);
            } else {
                session.merge(strutturaSanitariaFiglia);
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

        EntityCacheUtil.putResult(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaFigliaImpl.class,
            strutturaSanitariaFiglia.getPrimaryKey(), strutturaSanitariaFiglia);

        return strutturaSanitariaFiglia;
    }

    protected StrutturaSanitariaFiglia toUnwrappedModel(
        StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        if (strutturaSanitariaFiglia instanceof StrutturaSanitariaFigliaImpl) {
            return strutturaSanitariaFiglia;
        }

        StrutturaSanitariaFigliaImpl strutturaSanitariaFigliaImpl = new StrutturaSanitariaFigliaImpl();

        strutturaSanitariaFigliaImpl.setNew(strutturaSanitariaFiglia.isNew());
        strutturaSanitariaFigliaImpl.setPrimaryKey(strutturaSanitariaFiglia.getPrimaryKey());

        strutturaSanitariaFigliaImpl.setIdStrutturaFiglia(strutturaSanitariaFiglia.getIdStrutturaFiglia());
        strutturaSanitariaFigliaImpl.setTipoStruttura(strutturaSanitariaFiglia.getTipoStruttura());
        strutturaSanitariaFigliaImpl.setDenominazione(strutturaSanitariaFiglia.getDenominazione());
        strutturaSanitariaFigliaImpl.setIndirizzo(strutturaSanitariaFiglia.getIndirizzo());
        strutturaSanitariaFigliaImpl.setDirettore(strutturaSanitariaFiglia.getDirettore());
        strutturaSanitariaFigliaImpl.setResponsabileSanitario(strutturaSanitariaFiglia.getResponsabileSanitario());
        strutturaSanitariaFigliaImpl.setTelefono(strutturaSanitariaFiglia.getTelefono());
        strutturaSanitariaFigliaImpl.setEmail(strutturaSanitariaFiglia.getEmail());

        return strutturaSanitariaFigliaImpl;
    }

    /**
     * Returns the struttura sanitaria figlia with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the struttura sanitaria figlia
     * @return the struttura sanitaria figlia
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitariaFiglia findByPrimaryKey(Serializable primaryKey)
        throws NoSuchStrutturaSanitariaFigliaException, SystemException {
        StrutturaSanitariaFiglia strutturaSanitariaFiglia = fetchByPrimaryKey(primaryKey);

        if (strutturaSanitariaFiglia == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchStrutturaSanitariaFigliaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return strutturaSanitariaFiglia;
    }

    /**
     * Returns the struttura sanitaria figlia with the primary key or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException} if it could not be found.
     *
     * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
     * @return the struttura sanitaria figlia
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitariaFiglia findByPrimaryKey(long idStrutturaFiglia)
        throws NoSuchStrutturaSanitariaFigliaException, SystemException {
        return findByPrimaryKey((Serializable) idStrutturaFiglia);
    }

    /**
     * Returns the struttura sanitaria figlia with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the struttura sanitaria figlia
     * @return the struttura sanitaria figlia, or <code>null</code> if a struttura sanitaria figlia with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitariaFiglia fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        StrutturaSanitariaFiglia strutturaSanitariaFiglia = (StrutturaSanitariaFiglia) EntityCacheUtil.getResult(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
                StrutturaSanitariaFigliaImpl.class, primaryKey);

        if (strutturaSanitariaFiglia == _nullStrutturaSanitariaFiglia) {
            return null;
        }

        if (strutturaSanitariaFiglia == null) {
            Session session = null;

            try {
                session = openSession();

                strutturaSanitariaFiglia = (StrutturaSanitariaFiglia) session.get(StrutturaSanitariaFigliaImpl.class,
                        primaryKey);

                if (strutturaSanitariaFiglia != null) {
                    cacheResult(strutturaSanitariaFiglia);
                } else {
                    EntityCacheUtil.putResult(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
                        StrutturaSanitariaFigliaImpl.class, primaryKey,
                        _nullStrutturaSanitariaFiglia);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(StrutturaSanitariaFigliaModelImpl.ENTITY_CACHE_ENABLED,
                    StrutturaSanitariaFigliaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return strutturaSanitariaFiglia;
    }

    /**
     * Returns the struttura sanitaria figlia with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
     * @return the struttura sanitaria figlia, or <code>null</code> if a struttura sanitaria figlia with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitariaFiglia fetchByPrimaryKey(long idStrutturaFiglia)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) idStrutturaFiglia);
    }

    /**
     * Returns all the struttura sanitaria figlias.
     *
     * @return the struttura sanitaria figlias
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<StrutturaSanitariaFiglia> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the struttura sanitaria figlias.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of struttura sanitaria figlias
     * @param end the upper bound of the range of struttura sanitaria figlias (not inclusive)
     * @return the range of struttura sanitaria figlias
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<StrutturaSanitariaFiglia> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the struttura sanitaria figlias.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of struttura sanitaria figlias
     * @param end the upper bound of the range of struttura sanitaria figlias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of struttura sanitaria figlias
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<StrutturaSanitariaFiglia> findAll(int start, int end,
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

        List<StrutturaSanitariaFiglia> list = (List<StrutturaSanitariaFiglia>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_STRUTTURASANITARIAFIGLIA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_STRUTTURASANITARIAFIGLIA;

                if (pagination) {
                    sql = sql.concat(StrutturaSanitariaFigliaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<StrutturaSanitariaFiglia>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<StrutturaSanitariaFiglia>(list);
                } else {
                    list = (List<StrutturaSanitariaFiglia>) QueryUtil.list(q,
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
     * Removes all the struttura sanitaria figlias from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (StrutturaSanitariaFiglia strutturaSanitariaFiglia : findAll()) {
            remove(strutturaSanitariaFiglia);
        }
    }

    /**
     * Returns the number of struttura sanitaria figlias.
     *
     * @return the number of struttura sanitaria figlias
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

                Query q = session.createQuery(_SQL_COUNT_STRUTTURASANITARIAFIGLIA);

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
     * Initializes the struttura sanitaria figlia persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.sincon.sanita.services.model.StrutturaSanitariaFiglia")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<StrutturaSanitariaFiglia>> listenersList = new ArrayList<ModelListener<StrutturaSanitariaFiglia>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<StrutturaSanitariaFiglia>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(StrutturaSanitariaFigliaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
