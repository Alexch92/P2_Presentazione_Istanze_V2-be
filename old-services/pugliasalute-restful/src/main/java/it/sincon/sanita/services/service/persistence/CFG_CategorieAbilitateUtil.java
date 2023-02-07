package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.sincon.sanita.services.model.CFG_CategorieAbilitate;

import java.util.List;

/**
 * The persistence utility for the c f g_ categorie abilitate service. This utility wraps {@link CFG_CategorieAbilitatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see CFG_CategorieAbilitatePersistence
 * @see CFG_CategorieAbilitatePersistenceImpl
 * @generated
 */
public class CFG_CategorieAbilitateUtil {
    private static CFG_CategorieAbilitatePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        getPersistence().clearCache(cfg_CategorieAbilitate);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<CFG_CategorieAbilitate> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<CFG_CategorieAbilitate> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<CFG_CategorieAbilitate> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static CFG_CategorieAbilitate update(
        CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws SystemException {
        return getPersistence().update(cfg_CategorieAbilitate);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static CFG_CategorieAbilitate update(
        CFG_CategorieAbilitate cfg_CategorieAbilitate,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(cfg_CategorieAbilitate, serviceContext);
    }

    /**
    * Returns all the c f g_ categorie abilitates where className = &#63;.
    *
    * @param className the class name
    * @return the matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassName(
        java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByClassName(className);
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
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassName(
        java.lang.String className, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByClassName(className, start, end);
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
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassName(
        java.lang.String className, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByClassName(className, start, end, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassName_First(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence()
                   .findByClassName_First(className, orderByComparator);
    }

    /**
    * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63;.
    *
    * @param className the class name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassName_First(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByClassName_First(className, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassName_Last(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence()
                   .findByClassName_Last(className, orderByComparator);
    }

    /**
    * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63;.
    *
    * @param className the class name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassName_Last(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByClassName_Last(className, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate[] findByClassName_PrevAndNext(
        java.lang.String titoloStruttura, java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence()
                   .findByClassName_PrevAndNext(titoloStruttura, className,
            orderByComparator);
    }

    /**
    * Removes all the c f g_ categorie abilitates where className = &#63; from the database.
    *
    * @param className the class name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByClassName(java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByClassName(className);
    }

    /**
    * Returns the number of c f g_ categorie abilitates where className = &#63;.
    *
    * @param className the class name
    * @return the number of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public static int countByClassName(java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByClassName(className);
    }

    /**
    * Returns all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @return the matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByClassNameAndDefaultRicerca(className, defaultRicerca);
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
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByClassNameAndDefaultRicerca(className, defaultRicerca,
            start, end);
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
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByClassNameAndDefaultRicerca(className, defaultRicerca,
            start, end, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassNameAndDefaultRicerca_First(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence()
                   .findByClassNameAndDefaultRicerca_First(className,
            defaultRicerca, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassNameAndDefaultRicerca_First(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByClassNameAndDefaultRicerca_First(className,
            defaultRicerca, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassNameAndDefaultRicerca_Last(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence()
                   .findByClassNameAndDefaultRicerca_Last(className,
            defaultRicerca, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassNameAndDefaultRicerca_Last(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByClassNameAndDefaultRicerca_Last(className,
            defaultRicerca, orderByComparator);
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
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate[] findByClassNameAndDefaultRicerca_PrevAndNext(
        java.lang.String titoloStruttura, java.lang.String className,
        boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence()
                   .findByClassNameAndDefaultRicerca_PrevAndNext(titoloStruttura,
            className, defaultRicerca, orderByComparator);
    }

    /**
    * Removes all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63; from the database.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @throws SystemException if a system exception occurred
    */
    public static void removeByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByClassNameAndDefaultRicerca(className, defaultRicerca);
    }

    /**
    * Returns the number of c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @return the number of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public static int countByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByClassNameAndDefaultRicerca(className, defaultRicerca);
    }

    /**
    * Caches the c f g_ categorie abilitate in the entity cache if it is enabled.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    */
    public static void cacheResult(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        getPersistence().cacheResult(cfg_CategorieAbilitate);
    }

    /**
    * Caches the c f g_ categorie abilitates in the entity cache if it is enabled.
    *
    * @param cfg_CategorieAbilitates the c f g_ categorie abilitates
    */
    public static void cacheResult(
        java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> cfg_CategorieAbilitates) {
        getPersistence().cacheResult(cfg_CategorieAbilitates);
    }

    /**
    * Creates a new c f g_ categorie abilitate with the primary key. Does not add the c f g_ categorie abilitate to the database.
    *
    * @param titoloStruttura the primary key for the new c f g_ categorie abilitate
    * @return the new c f g_ categorie abilitate
    */
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate create(
        java.lang.String titoloStruttura) {
        return getPersistence().create(titoloStruttura);
    }

    /**
    * Removes the c f g_ categorie abilitate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was removed
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate remove(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence().remove(titoloStruttura);
    }

    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate updateImpl(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(cfg_CategorieAbilitate);
    }

    /**
    * Returns the c f g_ categorie abilitate with the primary key or throws a {@link it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException} if it could not be found.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate findByPrimaryKey(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException {
        return getPersistence().findByPrimaryKey(titoloStruttura);
    }

    /**
    * Returns the c f g_ categorie abilitate with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate, or <code>null</code> if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByPrimaryKey(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(titoloStruttura);
    }

    /**
    * Returns all the c f g_ categorie abilitates.
    *
    * @return the c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the c f g_ categorie abilitates from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of c f g_ categorie abilitates.
    *
    * @return the number of c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CFG_CategorieAbilitatePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CFG_CategorieAbilitatePersistence) PortletBeanLocatorUtil.locate(it.sincon.sanita.services.service.ClpSerializer.getServletContextName(),
                    CFG_CategorieAbilitatePersistence.class.getName());

            ReferenceRegistry.registerReference(CFG_CategorieAbilitateUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CFG_CategorieAbilitatePersistence persistence) {
    }
}
