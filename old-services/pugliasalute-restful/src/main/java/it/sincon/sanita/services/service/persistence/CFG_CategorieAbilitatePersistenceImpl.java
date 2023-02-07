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

import it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;
import it.sincon.sanita.services.model.CFG_CategorieAbilitate;
import it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateImpl;
import it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl;
import it.sincon.sanita.services.service.persistence.CFG_CategorieAbilitatePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the c f g_ categorie abilitate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see CFG_CategorieAbilitatePersistence
 * @see CFG_CategorieAbilitateUtil
 * @generated
 */
public class CFG_CategorieAbilitatePersistenceImpl extends BasePersistenceImpl<CFG_CategorieAbilitate>
    implements CFG_CategorieAbilitatePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CFG_CategorieAbilitateUtil} to access the c f g_ categorie abilitate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CFG_CategorieAbilitateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME =
        new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME =
        new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassName",
            new String[] { String.class.getName() },
            CFG_CategorieAbilitateModelImpl.CLASSNAME_COLUMN_BITMASK |
            CFG_CategorieAbilitateModelImpl.ORDINE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAME = new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_1 = "cfg_CategorieAbilitate.className IS NULL";
    private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_2 = "cfg_CategorieAbilitate.className = ?";
    private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_3 = "(cfg_CategorieAbilitate.className IS NULL OR cfg_CategorieAbilitate.className = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDDEFAULTRICERCA =
        new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByClassNameAndDefaultRicerca",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDDEFAULTRICERCA =
        new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByClassNameAndDefaultRicerca",
            new String[] { String.class.getName(), Boolean.class.getName() },
            CFG_CategorieAbilitateModelImpl.CLASSNAME_COLUMN_BITMASK |
            CFG_CategorieAbilitateModelImpl.DEFAULTRICERCA_COLUMN_BITMASK |
            CFG_CategorieAbilitateModelImpl.ORDINE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEANDDEFAULTRICERCA =
        new FinderPath(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByClassNameAndDefaultRicerca",
            new String[] { String.class.getName(), Boolean.class.getName() });
    private static final String _FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_1 =
        "cfg_CategorieAbilitate.className IS NULL AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_2 =
        "cfg_CategorieAbilitate.className = ? AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_3 =
        "(cfg_CategorieAbilitate.className IS NULL OR cfg_CategorieAbilitate.className = '') AND ";
    private static final String _FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_DEFAULTRICERCA_2 =
        "cfg_CategorieAbilitate.defaultRicerca = ?";
    private static final String _SQL_SELECT_CFG_CATEGORIEABILITATE = "SELECT cfg_CategorieAbilitate FROM CFG_CategorieAbilitate cfg_CategorieAbilitate";
    private static final String _SQL_SELECT_CFG_CATEGORIEABILITATE_WHERE = "SELECT cfg_CategorieAbilitate FROM CFG_CategorieAbilitate cfg_CategorieAbilitate WHERE ";
    private static final String _SQL_COUNT_CFG_CATEGORIEABILITATE = "SELECT COUNT(cfg_CategorieAbilitate) FROM CFG_CategorieAbilitate cfg_CategorieAbilitate";
    private static final String _SQL_COUNT_CFG_CATEGORIEABILITATE_WHERE = "SELECT COUNT(cfg_CategorieAbilitate) FROM CFG_CategorieAbilitate cfg_CategorieAbilitate WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "cfg_CategorieAbilitate.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CFG_CategorieAbilitate exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CFG_CategorieAbilitate exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CFG_CategorieAbilitatePersistenceImpl.class);
    private static CFG_CategorieAbilitate _nullCFG_CategorieAbilitate = new CFG_CategorieAbilitateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<CFG_CategorieAbilitate> toCacheModel() {
                return _nullCFG_CategorieAbilitateCacheModel;
            }
        };

    private static CacheModel<CFG_CategorieAbilitate> _nullCFG_CategorieAbilitateCacheModel =
        new CacheModel<CFG_CategorieAbilitate>() {
            @Override
            public CFG_CategorieAbilitate toEntityModel() {
                return _nullCFG_CategorieAbilitate;
            }
        };

    public CFG_CategorieAbilitatePersistenceImpl() {
        setModelClass(CFG_CategorieAbilitate.class);
    }

    /**
     * Returns all the c f g_ categorie abilitates where className = &#63;.
     *
     * @param className the class name
     * @return the matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findByClassName(String className)
        throws SystemException {
        return findByClassName(className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the c f g_ categorie abilitates where className = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param className the class name
     * @param start the lower bound of the range of c f g_ categorie abilitates
     * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
     * @return the range of matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findByClassName(String className,
        int start, int end) throws SystemException {
        return findByClassName(className, start, end, null);
    }

    /**
     * Returns an ordered range of all the c f g_ categorie abilitates where className = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param className the class name
     * @param start the lower bound of the range of c f g_ categorie abilitates
     * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findByClassName(String className,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME;
            finderArgs = new Object[] { className };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME;
            finderArgs = new Object[] { className, start, end, orderByComparator };
        }

        List<CFG_CategorieAbilitate> list = (List<CFG_CategorieAbilitate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (CFG_CategorieAbilitate cfg_CategorieAbilitate : list) {
                if (!Validator.equals(className,
                            cfg_CategorieAbilitate.getClassName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CFG_CATEGORIEABILITATE_WHERE);

            boolean bindClassName = false;

            if (className == null) {
                query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
            } else if (className.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
            } else {
                bindClassName = true;

                query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CFG_CategorieAbilitateModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindClassName) {
                    qPos.add(className);
                }

                if (!pagination) {
                    list = (List<CFG_CategorieAbilitate>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<CFG_CategorieAbilitate>(list);
                } else {
                    list = (List<CFG_CategorieAbilitate>) QueryUtil.list(q,
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
     * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63;.
     *
     * @param className the class name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate findByClassName_First(String className,
        OrderByComparator orderByComparator)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = fetchByClassName_First(className,
                orderByComparator);

        if (cfg_CategorieAbilitate != null) {
            return cfg_CategorieAbilitate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("className=");
        msg.append(className);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCFG_CategorieAbilitateException(msg.toString());
    }

    /**
     * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63;.
     *
     * @param className the class name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate fetchByClassName_First(String className,
        OrderByComparator orderByComparator) throws SystemException {
        List<CFG_CategorieAbilitate> list = findByClassName(className, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63;.
     *
     * @param className the class name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate findByClassName_Last(String className,
        OrderByComparator orderByComparator)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = fetchByClassName_Last(className,
                orderByComparator);

        if (cfg_CategorieAbilitate != null) {
            return cfg_CategorieAbilitate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("className=");
        msg.append(className);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCFG_CategorieAbilitateException(msg.toString());
    }

    /**
     * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63;.
     *
     * @param className the class name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate fetchByClassName_Last(String className,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByClassName(className);

        if (count == 0) {
            return null;
        }

        List<CFG_CategorieAbilitate> list = findByClassName(className,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the c f g_ categorie abilitates before and after the current c f g_ categorie abilitate in the ordered set where className = &#63;.
     *
     * @param titoloStruttura the primary key of the current c f g_ categorie abilitate
     * @param className the class name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate[] findByClassName_PrevAndNext(
        String titoloStruttura, String className,
        OrderByComparator orderByComparator)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = findByPrimaryKey(titoloStruttura);

        Session session = null;

        try {
            session = openSession();

            CFG_CategorieAbilitate[] array = new CFG_CategorieAbilitateImpl[3];

            array[0] = getByClassName_PrevAndNext(session,
                    cfg_CategorieAbilitate, className, orderByComparator, true);

            array[1] = cfg_CategorieAbilitate;

            array[2] = getByClassName_PrevAndNext(session,
                    cfg_CategorieAbilitate, className, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected CFG_CategorieAbilitate getByClassName_PrevAndNext(
        Session session, CFG_CategorieAbilitate cfg_CategorieAbilitate,
        String className, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CFG_CATEGORIEABILITATE_WHERE);

        boolean bindClassName = false;

        if (className == null) {
            query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
        } else if (className.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
        } else {
            bindClassName = true;

            query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CFG_CategorieAbilitateModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindClassName) {
            qPos.add(className);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(cfg_CategorieAbilitate);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<CFG_CategorieAbilitate> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the c f g_ categorie abilitates where className = &#63; from the database.
     *
     * @param className the class name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByClassName(String className) throws SystemException {
        for (CFG_CategorieAbilitate cfg_CategorieAbilitate : findByClassName(
                className, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(cfg_CategorieAbilitate);
        }
    }

    /**
     * Returns the number of c f g_ categorie abilitates where className = &#63;.
     *
     * @param className the class name
     * @return the number of matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByClassName(String className) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAME;

        Object[] finderArgs = new Object[] { className };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CFG_CATEGORIEABILITATE_WHERE);

            boolean bindClassName = false;

            if (className == null) {
                query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
            } else if (className.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
            } else {
                bindClassName = true;

                query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindClassName) {
                    qPos.add(className);
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
     * Returns all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @return the matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        String className, boolean defaultRicerca) throws SystemException {
        return findByClassNameAndDefaultRicerca(className, defaultRicerca,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @param start the lower bound of the range of c f g_ categorie abilitates
     * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
     * @return the range of matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        String className, boolean defaultRicerca, int start, int end)
        throws SystemException {
        return findByClassNameAndDefaultRicerca(className, defaultRicerca,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @param start the lower bound of the range of c f g_ categorie abilitates
     * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        String className, boolean defaultRicerca, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDDEFAULTRICERCA;
            finderArgs = new Object[] { className, defaultRicerca };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDDEFAULTRICERCA;
            finderArgs = new Object[] {
                    className, defaultRicerca,
                    
                    start, end, orderByComparator
                };
        }

        List<CFG_CategorieAbilitate> list = (List<CFG_CategorieAbilitate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (CFG_CategorieAbilitate cfg_CategorieAbilitate : list) {
                if (!Validator.equals(className,
                            cfg_CategorieAbilitate.getClassName()) ||
                        (defaultRicerca != cfg_CategorieAbilitate.getDefaultRicerca())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_CFG_CATEGORIEABILITATE_WHERE);

            boolean bindClassName = false;

            if (className == null) {
                query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_1);
            } else if (className.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_3);
            } else {
                bindClassName = true;

                query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_2);
            }

            query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_DEFAULTRICERCA_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CFG_CategorieAbilitateModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindClassName) {
                    qPos.add(className);
                }

                qPos.add(defaultRicerca);

                if (!pagination) {
                    list = (List<CFG_CategorieAbilitate>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<CFG_CategorieAbilitate>(list);
                } else {
                    list = (List<CFG_CategorieAbilitate>) QueryUtil.list(q,
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
     * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate findByClassNameAndDefaultRicerca_First(
        String className, boolean defaultRicerca,
        OrderByComparator orderByComparator)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = fetchByClassNameAndDefaultRicerca_First(className,
                defaultRicerca, orderByComparator);

        if (cfg_CategorieAbilitate != null) {
            return cfg_CategorieAbilitate;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("className=");
        msg.append(className);

        msg.append(", defaultRicerca=");
        msg.append(defaultRicerca);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCFG_CategorieAbilitateException(msg.toString());
    }

    /**
     * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate fetchByClassNameAndDefaultRicerca_First(
        String className, boolean defaultRicerca,
        OrderByComparator orderByComparator) throws SystemException {
        List<CFG_CategorieAbilitate> list = findByClassNameAndDefaultRicerca(className,
                defaultRicerca, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate findByClassNameAndDefaultRicerca_Last(
        String className, boolean defaultRicerca,
        OrderByComparator orderByComparator)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = fetchByClassNameAndDefaultRicerca_Last(className,
                defaultRicerca, orderByComparator);

        if (cfg_CategorieAbilitate != null) {
            return cfg_CategorieAbilitate;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("className=");
        msg.append(className);

        msg.append(", defaultRicerca=");
        msg.append(defaultRicerca);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCFG_CategorieAbilitateException(msg.toString());
    }

    /**
     * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate fetchByClassNameAndDefaultRicerca_Last(
        String className, boolean defaultRicerca,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByClassNameAndDefaultRicerca(className, defaultRicerca);

        if (count == 0) {
            return null;
        }

        List<CFG_CategorieAbilitate> list = findByClassNameAndDefaultRicerca(className,
                defaultRicerca, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the c f g_ categorie abilitates before and after the current c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
     *
     * @param titoloStruttura the primary key of the current c f g_ categorie abilitate
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate[] findByClassNameAndDefaultRicerca_PrevAndNext(
        String titoloStruttura, String className, boolean defaultRicerca,
        OrderByComparator orderByComparator)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = findByPrimaryKey(titoloStruttura);

        Session session = null;

        try {
            session = openSession();

            CFG_CategorieAbilitate[] array = new CFG_CategorieAbilitateImpl[3];

            array[0] = getByClassNameAndDefaultRicerca_PrevAndNext(session,
                    cfg_CategorieAbilitate, className, defaultRicerca,
                    orderByComparator, true);

            array[1] = cfg_CategorieAbilitate;

            array[2] = getByClassNameAndDefaultRicerca_PrevAndNext(session,
                    cfg_CategorieAbilitate, className, defaultRicerca,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected CFG_CategorieAbilitate getByClassNameAndDefaultRicerca_PrevAndNext(
        Session session, CFG_CategorieAbilitate cfg_CategorieAbilitate,
        String className, boolean defaultRicerca,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CFG_CATEGORIEABILITATE_WHERE);

        boolean bindClassName = false;

        if (className == null) {
            query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_1);
        } else if (className.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_3);
        } else {
            bindClassName = true;

            query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_2);
        }

        query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_DEFAULTRICERCA_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CFG_CategorieAbilitateModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindClassName) {
            qPos.add(className);
        }

        qPos.add(defaultRicerca);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(cfg_CategorieAbilitate);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<CFG_CategorieAbilitate> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63; from the database.
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByClassNameAndDefaultRicerca(String className,
        boolean defaultRicerca) throws SystemException {
        for (CFG_CategorieAbilitate cfg_CategorieAbilitate : findByClassNameAndDefaultRicerca(
                className, defaultRicerca, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(cfg_CategorieAbilitate);
        }
    }

    /**
     * Returns the number of c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
     *
     * @param className the class name
     * @param defaultRicerca the default ricerca
     * @return the number of matching c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByClassNameAndDefaultRicerca(String className,
        boolean defaultRicerca) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEANDDEFAULTRICERCA;

        Object[] finderArgs = new Object[] { className, defaultRicerca };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CFG_CATEGORIEABILITATE_WHERE);

            boolean bindClassName = false;

            if (className == null) {
                query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_1);
            } else if (className.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_3);
            } else {
                bindClassName = true;

                query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_CLASSNAME_2);
            }

            query.append(_FINDER_COLUMN_CLASSNAMEANDDEFAULTRICERCA_DEFAULTRICERCA_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindClassName) {
                    qPos.add(className);
                }

                qPos.add(defaultRicerca);

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
     * Caches the c f g_ categorie abilitate in the entity cache if it is enabled.
     *
     * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
     */
    @Override
    public void cacheResult(CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        EntityCacheUtil.putResult(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            cfg_CategorieAbilitate.getPrimaryKey(), cfg_CategorieAbilitate);

        cfg_CategorieAbilitate.resetOriginalValues();
    }

    /**
     * Caches the c f g_ categorie abilitates in the entity cache if it is enabled.
     *
     * @param cfg_CategorieAbilitates the c f g_ categorie abilitates
     */
    @Override
    public void cacheResult(
        List<CFG_CategorieAbilitate> cfg_CategorieAbilitates) {
        for (CFG_CategorieAbilitate cfg_CategorieAbilitate : cfg_CategorieAbilitates) {
            if (EntityCacheUtil.getResult(
                        CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
                        CFG_CategorieAbilitateImpl.class,
                        cfg_CategorieAbilitate.getPrimaryKey()) == null) {
                cacheResult(cfg_CategorieAbilitate);
            } else {
                cfg_CategorieAbilitate.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all c f g_ categorie abilitates.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CFG_CategorieAbilitateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CFG_CategorieAbilitateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the c f g_ categorie abilitate.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        EntityCacheUtil.removeResult(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            cfg_CategorieAbilitate.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<CFG_CategorieAbilitate> cfg_CategorieAbilitates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (CFG_CategorieAbilitate cfg_CategorieAbilitate : cfg_CategorieAbilitates) {
            EntityCacheUtil.removeResult(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
                CFG_CategorieAbilitateImpl.class,
                cfg_CategorieAbilitate.getPrimaryKey());
        }
    }

    /**
     * Creates a new c f g_ categorie abilitate with the primary key. Does not add the c f g_ categorie abilitate to the database.
     *
     * @param titoloStruttura the primary key for the new c f g_ categorie abilitate
     * @return the new c f g_ categorie abilitate
     */
    @Override
    public CFG_CategorieAbilitate create(String titoloStruttura) {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = new CFG_CategorieAbilitateImpl();

        cfg_CategorieAbilitate.setNew(true);
        cfg_CategorieAbilitate.setPrimaryKey(titoloStruttura);

        return cfg_CategorieAbilitate;
    }

    /**
     * Removes the c f g_ categorie abilitate with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param titoloStruttura the primary key of the c f g_ categorie abilitate
     * @return the c f g_ categorie abilitate that was removed
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate remove(String titoloStruttura)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        return remove((Serializable) titoloStruttura);
    }

    /**
     * Removes the c f g_ categorie abilitate with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the c f g_ categorie abilitate
     * @return the c f g_ categorie abilitate that was removed
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate remove(Serializable primaryKey)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CFG_CategorieAbilitate cfg_CategorieAbilitate = (CFG_CategorieAbilitate) session.get(CFG_CategorieAbilitateImpl.class,
                    primaryKey);

            if (cfg_CategorieAbilitate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCFG_CategorieAbilitateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(cfg_CategorieAbilitate);
        } catch (NoSuchCFG_CategorieAbilitateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected CFG_CategorieAbilitate removeImpl(
        CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws SystemException {
        cfg_CategorieAbilitate = toUnwrappedModel(cfg_CategorieAbilitate);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(cfg_CategorieAbilitate)) {
                cfg_CategorieAbilitate = (CFG_CategorieAbilitate) session.get(CFG_CategorieAbilitateImpl.class,
                        cfg_CategorieAbilitate.getPrimaryKeyObj());
            }

            if (cfg_CategorieAbilitate != null) {
                session.delete(cfg_CategorieAbilitate);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (cfg_CategorieAbilitate != null) {
            clearCache(cfg_CategorieAbilitate);
        }

        return cfg_CategorieAbilitate;
    }

    @Override
    public CFG_CategorieAbilitate updateImpl(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws SystemException {
        cfg_CategorieAbilitate = toUnwrappedModel(cfg_CategorieAbilitate);

        boolean isNew = cfg_CategorieAbilitate.isNew();

        CFG_CategorieAbilitateModelImpl cfg_CategorieAbilitateModelImpl = (CFG_CategorieAbilitateModelImpl) cfg_CategorieAbilitate;

        Session session = null;

        try {
            session = openSession();

            if (cfg_CategorieAbilitate.isNew()) {
                session.save(cfg_CategorieAbilitate);

                cfg_CategorieAbilitate.setNew(false);
            } else {
                session.merge(cfg_CategorieAbilitate);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CFG_CategorieAbilitateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((cfg_CategorieAbilitateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        cfg_CategorieAbilitateModelImpl.getOriginalClassName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
                    args);

                args = new Object[] {
                        cfg_CategorieAbilitateModelImpl.getClassName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
                    args);
            }

            if ((cfg_CategorieAbilitateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDDEFAULTRICERCA.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        cfg_CategorieAbilitateModelImpl.getOriginalClassName(),
                        cfg_CategorieAbilitateModelImpl.getOriginalDefaultRicerca()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDDEFAULTRICERCA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDDEFAULTRICERCA,
                    args);

                args = new Object[] {
                        cfg_CategorieAbilitateModelImpl.getClassName(),
                        cfg_CategorieAbilitateModelImpl.getDefaultRicerca()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDDEFAULTRICERCA,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDDEFAULTRICERCA,
                    args);
            }
        }

        EntityCacheUtil.putResult(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
            CFG_CategorieAbilitateImpl.class,
            cfg_CategorieAbilitate.getPrimaryKey(), cfg_CategorieAbilitate);

        return cfg_CategorieAbilitate;
    }

    protected CFG_CategorieAbilitate toUnwrappedModel(
        CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        if (cfg_CategorieAbilitate instanceof CFG_CategorieAbilitateImpl) {
            return cfg_CategorieAbilitate;
        }

        CFG_CategorieAbilitateImpl cfg_CategorieAbilitateImpl = new CFG_CategorieAbilitateImpl();

        cfg_CategorieAbilitateImpl.setNew(cfg_CategorieAbilitate.isNew());
        cfg_CategorieAbilitateImpl.setPrimaryKey(cfg_CategorieAbilitate.getPrimaryKey());

        cfg_CategorieAbilitateImpl.setTitoloStruttura(cfg_CategorieAbilitate.getTitoloStruttura());
        cfg_CategorieAbilitateImpl.setDenominazione(cfg_CategorieAbilitate.getDenominazione());
        cfg_CategorieAbilitateImpl.setOrdine(cfg_CategorieAbilitate.getOrdine());
        cfg_CategorieAbilitateImpl.setClassName(cfg_CategorieAbilitate.getClassName());
        cfg_CategorieAbilitateImpl.setDefaultRicerca(cfg_CategorieAbilitate.isDefaultRicerca());

        return cfg_CategorieAbilitateImpl;
    }

    /**
     * Returns the c f g_ categorie abilitate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the c f g_ categorie abilitate
     * @return the c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = fetchByPrimaryKey(primaryKey);

        if (cfg_CategorieAbilitate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCFG_CategorieAbilitateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return cfg_CategorieAbilitate;
    }

    /**
     * Returns the c f g_ categorie abilitate with the primary key or throws a {@link it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException} if it could not be found.
     *
     * @param titoloStruttura the primary key of the c f g_ categorie abilitate
     * @return the c f g_ categorie abilitate
     * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate findByPrimaryKey(String titoloStruttura)
        throws NoSuchCFG_CategorieAbilitateException, SystemException {
        return findByPrimaryKey((Serializable) titoloStruttura);
    }

    /**
     * Returns the c f g_ categorie abilitate with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the c f g_ categorie abilitate
     * @return the c f g_ categorie abilitate, or <code>null</code> if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        CFG_CategorieAbilitate cfg_CategorieAbilitate = (CFG_CategorieAbilitate) EntityCacheUtil.getResult(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
                CFG_CategorieAbilitateImpl.class, primaryKey);

        if (cfg_CategorieAbilitate == _nullCFG_CategorieAbilitate) {
            return null;
        }

        if (cfg_CategorieAbilitate == null) {
            Session session = null;

            try {
                session = openSession();

                cfg_CategorieAbilitate = (CFG_CategorieAbilitate) session.get(CFG_CategorieAbilitateImpl.class,
                        primaryKey);

                if (cfg_CategorieAbilitate != null) {
                    cacheResult(cfg_CategorieAbilitate);
                } else {
                    EntityCacheUtil.putResult(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
                        CFG_CategorieAbilitateImpl.class, primaryKey,
                        _nullCFG_CategorieAbilitate);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CFG_CategorieAbilitateModelImpl.ENTITY_CACHE_ENABLED,
                    CFG_CategorieAbilitateImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return cfg_CategorieAbilitate;
    }

    /**
     * Returns the c f g_ categorie abilitate with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param titoloStruttura the primary key of the c f g_ categorie abilitate
     * @return the c f g_ categorie abilitate, or <code>null</code> if a c f g_ categorie abilitate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public CFG_CategorieAbilitate fetchByPrimaryKey(String titoloStruttura)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) titoloStruttura);
    }

    /**
     * Returns all the c f g_ categorie abilitates.
     *
     * @return the c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the c f g_ categorie abilitates.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of c f g_ categorie abilitates
     * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
     * @return the range of c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the c f g_ categorie abilitates.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of c f g_ categorie abilitates
     * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of c f g_ categorie abilitates
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<CFG_CategorieAbilitate> findAll(int start, int end,
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

        List<CFG_CategorieAbilitate> list = (List<CFG_CategorieAbilitate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CFG_CATEGORIEABILITATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CFG_CATEGORIEABILITATE;

                if (pagination) {
                    sql = sql.concat(CFG_CategorieAbilitateModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<CFG_CategorieAbilitate>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<CFG_CategorieAbilitate>(list);
                } else {
                    list = (List<CFG_CategorieAbilitate>) QueryUtil.list(q,
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
     * Removes all the c f g_ categorie abilitates from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (CFG_CategorieAbilitate cfg_CategorieAbilitate : findAll()) {
            remove(cfg_CategorieAbilitate);
        }
    }

    /**
     * Returns the number of c f g_ categorie abilitates.
     *
     * @return the number of c f g_ categorie abilitates
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

                Query q = session.createQuery(_SQL_COUNT_CFG_CATEGORIEABILITATE);

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
     * Initializes the c f g_ categorie abilitate persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.it.sincon.sanita.services.model.CFG_CategorieAbilitate")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<CFG_CategorieAbilitate>> listenersList = new ArrayList<ModelListener<CFG_CategorieAbilitate>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<CFG_CategorieAbilitate>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CFG_CategorieAbilitateImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
