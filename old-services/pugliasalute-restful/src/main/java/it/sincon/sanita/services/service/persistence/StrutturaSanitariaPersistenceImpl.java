package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.sincon.sanita.services.NoSuchStrutturaSanitariaException;
import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.model.impl.StrutturaSanitariaImpl;
import it.sincon.sanita.services.model.impl.StrutturaSanitariaModelImpl;
import it.sincon.sanita.services.service.persistence.StrutturaSanitariaPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the struttura sanitaria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitariaPersistence
 * @see StrutturaSanitariaUtil
 * @generated
 */
public class StrutturaSanitariaPersistenceImpl extends BasePersistenceImpl<StrutturaSanitaria>
    implements StrutturaSanitariaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link StrutturaSanitariaUtil} to access the struttura sanitaria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = StrutturaSanitariaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaModelImpl.FINDER_CACHE_ENABLED,
            StrutturaSanitariaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaModelImpl.FINDER_CACHE_ENABLED,
            StrutturaSanitariaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE = new FinderPath(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaModelImpl.FINDER_CACHE_ENABLED,
            StrutturaSanitariaImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByIdStrutturaAndLocale",
            new String[] { Long.class.getName(), String.class.getName() },
            StrutturaSanitariaModelImpl.IDSTRUTTURA_COLUMN_BITMASK |
            StrutturaSanitariaModelImpl.LOCALE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_IDSTRUTTURAANDLOCALE = new FinderPath(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByIdStrutturaAndLocale",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_IDSTRUTTURAANDLOCALE_IDSTRUTTURA_2 =
        "strutturaSanitaria.idStruttura = ? AND ";
    private static final String _FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_1 = "strutturaSanitaria.locale IS NULL";
    private static final String _FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_2 = "strutturaSanitaria.locale = ?";
    private static final String _FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_3 = "(strutturaSanitaria.locale IS NULL OR strutturaSanitaria.locale = '')";
    private static final String _SQL_SELECT_STRUTTURASANITARIA = "SELECT strutturaSanitaria FROM StrutturaSanitaria strutturaSanitaria";
    private static final String _SQL_SELECT_STRUTTURASANITARIA_WHERE = "SELECT strutturaSanitaria FROM StrutturaSanitaria strutturaSanitaria WHERE ";
    private static final String _SQL_COUNT_STRUTTURASANITARIA = "SELECT COUNT(strutturaSanitaria) FROM StrutturaSanitaria strutturaSanitaria";
    private static final String _SQL_COUNT_STRUTTURASANITARIA_WHERE = "SELECT COUNT(strutturaSanitaria) FROM StrutturaSanitaria strutturaSanitaria WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "strutturaSanitaria.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StrutturaSanitaria exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StrutturaSanitaria exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(StrutturaSanitariaPersistenceImpl.class);
    private static StrutturaSanitaria _nullStrutturaSanitaria = new StrutturaSanitariaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<StrutturaSanitaria> toCacheModel() {
                return _nullStrutturaSanitariaCacheModel;
            }
        };

    private static CacheModel<StrutturaSanitaria> _nullStrutturaSanitariaCacheModel =
        new CacheModel<StrutturaSanitaria>() {
            @Override
            public StrutturaSanitaria toEntityModel() {
                return _nullStrutturaSanitaria;
            }
        };

    public StrutturaSanitariaPersistenceImpl() {
        setModelClass(StrutturaSanitaria.class);
    }

    /**
     * Returns the struttura sanitaria where idStruttura = &#63; and locale = &#63; or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaException} if it could not be found.
     *
     * @param idStruttura the id struttura
     * @param locale the locale
     * @return the matching struttura sanitaria
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a matching struttura sanitaria could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria findByIdStrutturaAndLocale(long idStruttura,
        String locale)
        throws NoSuchStrutturaSanitariaException, SystemException {
        StrutturaSanitaria strutturaSanitaria = fetchByIdStrutturaAndLocale(idStruttura,
                locale);

        if (strutturaSanitaria == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("idStruttura=");
            msg.append(idStruttura);

            msg.append(", locale=");
            msg.append(locale);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchStrutturaSanitariaException(msg.toString());
        }

        return strutturaSanitaria;
    }

    /**
     * Returns the struttura sanitaria where idStruttura = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param idStruttura the id struttura
     * @param locale the locale
     * @return the matching struttura sanitaria, or <code>null</code> if a matching struttura sanitaria could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria fetchByIdStrutturaAndLocale(long idStruttura,
        String locale) throws SystemException {
        return fetchByIdStrutturaAndLocale(idStruttura, locale, true);
    }

    /**
     * Returns the struttura sanitaria where idStruttura = &#63; and locale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param idStruttura the id struttura
     * @param locale the locale
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching struttura sanitaria, or <code>null</code> if a matching struttura sanitaria could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria fetchByIdStrutturaAndLocale(long idStruttura,
        String locale, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { idStruttura, locale };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
                    finderArgs, this);
        }

        if (result instanceof StrutturaSanitaria) {
            StrutturaSanitaria strutturaSanitaria = (StrutturaSanitaria) result;

            if ((idStruttura != strutturaSanitaria.getIdStruttura()) ||
                    !Validator.equals(locale, strutturaSanitaria.getLocale())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_STRUTTURASANITARIA_WHERE);

            query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_IDSTRUTTURA_2);

            boolean bindLocale = false;

            if (locale == null) {
                query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_1);
            } else if (locale.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_3);
            } else {
                bindLocale = true;

                query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idStruttura);

                if (bindLocale) {
                    qPos.add(locale);
                }

                List<StrutturaSanitaria> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "StrutturaSanitariaPersistenceImpl.fetchByIdStrutturaAndLocale(long, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    StrutturaSanitaria strutturaSanitaria = list.get(0);

                    result = strutturaSanitaria;

                    cacheResult(strutturaSanitaria);

                    if ((strutturaSanitaria.getIdStruttura() != idStruttura) ||
                            (strutturaSanitaria.getLocale() == null) ||
                            !strutturaSanitaria.getLocale().equals(locale)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
                            finderArgs, strutturaSanitaria);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (StrutturaSanitaria) result;
        }
    }

    /**
     * Removes the struttura sanitaria where idStruttura = &#63; and locale = &#63; from the database.
     *
     * @param idStruttura the id struttura
     * @param locale the locale
     * @return the struttura sanitaria that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria removeByIdStrutturaAndLocale(long idStruttura,
        String locale)
        throws NoSuchStrutturaSanitariaException, SystemException {
        StrutturaSanitaria strutturaSanitaria = findByIdStrutturaAndLocale(idStruttura,
                locale);

        return remove(strutturaSanitaria);
    }

    /**
     * Returns the number of struttura sanitarias where idStruttura = &#63; and locale = &#63;.
     *
     * @param idStruttura the id struttura
     * @param locale the locale
     * @return the number of matching struttura sanitarias
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByIdStrutturaAndLocale(long idStruttura, String locale)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_IDSTRUTTURAANDLOCALE;

        Object[] finderArgs = new Object[] { idStruttura, locale };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_STRUTTURASANITARIA_WHERE);

            query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_IDSTRUTTURA_2);

            boolean bindLocale = false;

            if (locale == null) {
                query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_1);
            } else if (locale.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_3);
            } else {
                bindLocale = true;

                query.append(_FINDER_COLUMN_IDSTRUTTURAANDLOCALE_LOCALE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idStruttura);

                if (bindLocale) {
                    qPos.add(locale);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the struttura sanitaria in the entity cache if it is enabled.
     *
     * @param strutturaSanitaria the struttura sanitaria
     */
    @Override
    public void cacheResult(StrutturaSanitaria strutturaSanitaria) {
        EntityCacheUtil.putResult(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaImpl.class, strutturaSanitaria.getPrimaryKey(),
            strutturaSanitaria);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
            new Object[] {
                strutturaSanitaria.getIdStruttura(),
                strutturaSanitaria.getLocale()
            }, strutturaSanitaria);

        strutturaSanitaria.resetOriginalValues();
    }

    /**
     * Caches the struttura sanitarias in the entity cache if it is enabled.
     *
     * @param strutturaSanitarias the struttura sanitarias
     */
    @Override
    public void cacheResult(List<StrutturaSanitaria> strutturaSanitarias) {
        for (StrutturaSanitaria strutturaSanitaria : strutturaSanitarias) {
            if (EntityCacheUtil.getResult(
                        StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
                        StrutturaSanitariaImpl.class,
                        strutturaSanitaria.getPrimaryKey()) == null) {
                cacheResult(strutturaSanitaria);
            } else {
                strutturaSanitaria.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all struttura sanitarias.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(StrutturaSanitariaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(StrutturaSanitariaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the struttura sanitaria.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(StrutturaSanitaria strutturaSanitaria) {
        EntityCacheUtil.removeResult(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaImpl.class, strutturaSanitaria.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(strutturaSanitaria);
    }

    @Override
    public void clearCache(List<StrutturaSanitaria> strutturaSanitarias) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (StrutturaSanitaria strutturaSanitaria : strutturaSanitarias) {
            EntityCacheUtil.removeResult(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
                StrutturaSanitariaImpl.class, strutturaSanitaria.getPrimaryKey());

            clearUniqueFindersCache(strutturaSanitaria);
        }
    }

    protected void cacheUniqueFindersCache(
        StrutturaSanitaria strutturaSanitaria) {
        if (strutturaSanitaria.isNew()) {
            Object[] args = new Object[] {
                    strutturaSanitaria.getIdStruttura(),
                    strutturaSanitaria.getLocale()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDSTRUTTURAANDLOCALE,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
                args, strutturaSanitaria);
        } else {
            StrutturaSanitariaModelImpl strutturaSanitariaModelImpl = (StrutturaSanitariaModelImpl) strutturaSanitaria;

            if ((strutturaSanitariaModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        strutturaSanitaria.getIdStruttura(),
                        strutturaSanitaria.getLocale()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDSTRUTTURAANDLOCALE,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
                    args, strutturaSanitaria);
            }
        }
    }

    protected void clearUniqueFindersCache(
        StrutturaSanitaria strutturaSanitaria) {
        StrutturaSanitariaModelImpl strutturaSanitariaModelImpl = (StrutturaSanitariaModelImpl) strutturaSanitaria;

        Object[] args = new Object[] {
                strutturaSanitaria.getIdStruttura(),
                strutturaSanitaria.getLocale()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDSTRUTTURAANDLOCALE,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
            args);

        if ((strutturaSanitariaModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE.getColumnBitmask()) != 0) {
            args = new Object[] {
                    strutturaSanitariaModelImpl.getOriginalIdStruttura(),
                    strutturaSanitariaModelImpl.getOriginalLocale()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDSTRUTTURAANDLOCALE,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDSTRUTTURAANDLOCALE,
                args);
        }
    }

    /**
     * Creates a new struttura sanitaria with the primary key. Does not add the struttura sanitaria to the database.
     *
     * @param pk the primary key for the new struttura sanitaria
     * @return the new struttura sanitaria
     */
    @Override
    public StrutturaSanitaria create(long pk) {
        StrutturaSanitaria strutturaSanitaria = new StrutturaSanitariaImpl();

        strutturaSanitaria.setNew(true);
        strutturaSanitaria.setPrimaryKey(pk);

        return strutturaSanitaria;
    }

    /**
     * Removes the struttura sanitaria with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param pk the primary key of the struttura sanitaria
     * @return the struttura sanitaria that was removed
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria remove(long pk)
        throws NoSuchStrutturaSanitariaException, SystemException {
        return remove((Serializable) pk);
    }

    /**
     * Removes the struttura sanitaria with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the struttura sanitaria
     * @return the struttura sanitaria that was removed
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria remove(Serializable primaryKey)
        throws NoSuchStrutturaSanitariaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            StrutturaSanitaria strutturaSanitaria = (StrutturaSanitaria) session.get(StrutturaSanitariaImpl.class,
                    primaryKey);

            if (strutturaSanitaria == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchStrutturaSanitariaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(strutturaSanitaria);
        } catch (NoSuchStrutturaSanitariaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected StrutturaSanitaria removeImpl(
        StrutturaSanitaria strutturaSanitaria) throws SystemException {
        strutturaSanitaria = toUnwrappedModel(strutturaSanitaria);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(strutturaSanitaria)) {
                strutturaSanitaria = (StrutturaSanitaria) session.get(StrutturaSanitariaImpl.class,
                        strutturaSanitaria.getPrimaryKeyObj());
            }

            if (strutturaSanitaria != null) {
                session.delete(strutturaSanitaria);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (strutturaSanitaria != null) {
            clearCache(strutturaSanitaria);
        }

        return strutturaSanitaria;
    }

    @Override
    public StrutturaSanitaria updateImpl(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
        throws SystemException {
        strutturaSanitaria = toUnwrappedModel(strutturaSanitaria);

        boolean isNew = strutturaSanitaria.isNew();

        Session session = null;

        try {
            session = openSession();

            if (strutturaSanitaria.isNew()) {
                session.save(strutturaSanitaria);

                strutturaSanitaria.setNew(false);
            } else {
                session.merge(strutturaSanitaria);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !StrutturaSanitariaModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
            StrutturaSanitariaImpl.class, strutturaSanitaria.getPrimaryKey(),
            strutturaSanitaria);

        clearUniqueFindersCache(strutturaSanitaria);
        cacheUniqueFindersCache(strutturaSanitaria);

        return strutturaSanitaria;
    }

    protected StrutturaSanitaria toUnwrappedModel(
        StrutturaSanitaria strutturaSanitaria) {
        if (strutturaSanitaria instanceof StrutturaSanitariaImpl) {
            return strutturaSanitaria;
        }

        StrutturaSanitariaImpl strutturaSanitariaImpl = new StrutturaSanitariaImpl();

        strutturaSanitariaImpl.setNew(strutturaSanitaria.isNew());
        strutturaSanitariaImpl.setPrimaryKey(strutturaSanitaria.getPrimaryKey());

        strutturaSanitariaImpl.setPk(strutturaSanitaria.getPk());
        strutturaSanitariaImpl.setIdStruttura(strutturaSanitaria.getIdStruttura());
        strutturaSanitariaImpl.setGroupId(strutturaSanitaria.getGroupId());
        strutturaSanitariaImpl.setIdTipoStruttura(strutturaSanitaria.getIdTipoStruttura());
        strutturaSanitariaImpl.setTipoStruttura(strutturaSanitaria.getTipoStruttura());
        strutturaSanitariaImpl.setTipologia(strutturaSanitaria.getTipologia());
        strutturaSanitariaImpl.setDenominazione(strutturaSanitaria.getDenominazione());
        strutturaSanitariaImpl.setImmagine(strutturaSanitaria.getImmagine());
        strutturaSanitariaImpl.setDescrizione(strutturaSanitaria.getDescrizione());
        strutturaSanitariaImpl.setIndirizzo(strutturaSanitaria.getIndirizzo());
        strutturaSanitariaImpl.setLat(strutturaSanitaria.getLat());
        strutturaSanitariaImpl.setLng(strutturaSanitaria.getLng());
        strutturaSanitariaImpl.setDistanza(strutturaSanitaria.getDistanza());
        strutturaSanitariaImpl.setTelefono(strutturaSanitaria.getTelefono());
        strutturaSanitariaImpl.setEmail(strutturaSanitaria.getEmail());
        strutturaSanitariaImpl.setFax(strutturaSanitaria.getFax());
        strutturaSanitariaImpl.setOrari(strutturaSanitaria.getOrari());
        strutturaSanitariaImpl.setLocale(strutturaSanitaria.getLocale());
        strutturaSanitariaImpl.setStato(strutturaSanitaria.getStato());
        strutturaSanitariaImpl.setChildrenEdottoOspedaleCollegato(strutturaSanitaria.getChildrenEdottoOspedaleCollegato());
        strutturaSanitariaImpl.setChildrenEdottoAmbulatorio(strutturaSanitaria.getChildrenEdottoAmbulatorio());
        strutturaSanitariaImpl.setChildrenEdottoUnitaOperativa(strutturaSanitaria.getChildrenEdottoUnitaOperativa());
        strutturaSanitariaImpl.setChildrenEdottoUnitaps(strutturaSanitaria.getChildrenEdottoUnitaps());
        strutturaSanitariaImpl.setRelazioneAmbulatorio(strutturaSanitaria.getRelazioneAmbulatorio());

        return strutturaSanitariaImpl;
    }

    /**
     * Returns the struttura sanitaria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the struttura sanitaria
     * @return the struttura sanitaria
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria findByPrimaryKey(Serializable primaryKey)
        throws NoSuchStrutturaSanitariaException, SystemException {
        StrutturaSanitaria strutturaSanitaria = fetchByPrimaryKey(primaryKey);

        if (strutturaSanitaria == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchStrutturaSanitariaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return strutturaSanitaria;
    }

    /**
     * Returns the struttura sanitaria with the primary key or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaException} if it could not be found.
     *
     * @param pk the primary key of the struttura sanitaria
     * @return the struttura sanitaria
     * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria findByPrimaryKey(long pk)
        throws NoSuchStrutturaSanitariaException, SystemException {
        return findByPrimaryKey((Serializable) pk);
    }

    /**
     * Returns the struttura sanitaria with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the struttura sanitaria
     * @return the struttura sanitaria, or <code>null</code> if a struttura sanitaria with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        StrutturaSanitaria strutturaSanitaria = (StrutturaSanitaria) EntityCacheUtil.getResult(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
                StrutturaSanitariaImpl.class, primaryKey);

        if (strutturaSanitaria == _nullStrutturaSanitaria) {
            return null;
        }

        if (strutturaSanitaria == null) {
            Session session = null;

            try {
                session = openSession();

                strutturaSanitaria = (StrutturaSanitaria) session.get(StrutturaSanitariaImpl.class,
                        primaryKey);

                if (strutturaSanitaria != null) {
                    cacheResult(strutturaSanitaria);
                } else {
                    EntityCacheUtil.putResult(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
                        StrutturaSanitariaImpl.class, primaryKey,
                        _nullStrutturaSanitaria);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(StrutturaSanitariaModelImpl.ENTITY_CACHE_ENABLED,
                    StrutturaSanitariaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return strutturaSanitaria;
    }

    /**
     * Returns the struttura sanitaria with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param pk the primary key of the struttura sanitaria
     * @return the struttura sanitaria, or <code>null</code> if a struttura sanitaria with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public StrutturaSanitaria fetchByPrimaryKey(long pk)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) pk);
    }

    /**
     * Returns all the struttura sanitarias.
     *
     * @return the struttura sanitarias
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<StrutturaSanitaria> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the struttura sanitarias.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of struttura sanitarias
     * @param end the upper bound of the range of struttura sanitarias (not inclusive)
     * @return the range of struttura sanitarias
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<StrutturaSanitaria> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the struttura sanitarias.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of struttura sanitarias
     * @param end the upper bound of the range of struttura sanitarias (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of struttura sanitarias
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<StrutturaSanitaria> findAll(int start, int end,
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

        List<StrutturaSanitaria> list = (List<StrutturaSanitaria>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_STRUTTURASANITARIA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_STRUTTURASANITARIA;

                if (pagination) {
                    sql = sql.concat(StrutturaSanitariaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<StrutturaSanitaria>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<StrutturaSanitaria>(list);
                } else {
                    list = (List<StrutturaSanitaria>) QueryUtil.list(q,
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
     * Removes all the struttura sanitarias from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (StrutturaSanitaria strutturaSanitaria : findAll()) {
            remove(strutturaSanitaria);
        }
    }

    /**
     * Returns the number of struttura sanitarias.
     *
     * @return the number of struttura sanitarias
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

                Query q = session.createQuery(_SQL_COUNT_STRUTTURASANITARIA);

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
     * Initializes the struttura sanitaria persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.sincon.sanita.services.model.StrutturaSanitaria")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<StrutturaSanitaria>> listenersList = new ArrayList<ModelListener<StrutturaSanitaria>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<StrutturaSanitaria>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(StrutturaSanitariaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
