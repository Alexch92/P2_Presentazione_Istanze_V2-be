package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.sincon.sanita.services.model.StrutturaSanitaria;

import java.util.List;

/**
 * The persistence utility for the struttura sanitaria service. This utility wraps {@link StrutturaSanitariaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitariaPersistence
 * @see StrutturaSanitariaPersistenceImpl
 * @generated
 */
public class StrutturaSanitariaUtil {
    private static StrutturaSanitariaPersistence _persistence;

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
    public static void clearCache(StrutturaSanitaria strutturaSanitaria) {
        getPersistence().clearCache(strutturaSanitaria);
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
    public static List<StrutturaSanitaria> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<StrutturaSanitaria> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<StrutturaSanitaria> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static StrutturaSanitaria update(
        StrutturaSanitaria strutturaSanitaria) throws SystemException {
        return getPersistence().update(strutturaSanitaria);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static StrutturaSanitaria update(
        StrutturaSanitaria strutturaSanitaria, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(strutturaSanitaria, serviceContext);
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
    public static it.sincon.sanita.services.model.StrutturaSanitaria findByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException {
        return getPersistence().findByIdStrutturaAndLocale(idStruttura, locale);
    }

    /**
    * Returns the struttura sanitaria where idStruttura = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @return the matching struttura sanitaria, or <code>null</code> if a matching struttura sanitaria could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitaria fetchByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByIdStrutturaAndLocale(idStruttura, locale);
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
    public static it.sincon.sanita.services.model.StrutturaSanitaria fetchByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByIdStrutturaAndLocale(idStruttura, locale,
            retrieveFromCache);
    }

    /**
    * Removes the struttura sanitaria where idStruttura = &#63; and locale = &#63; from the database.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @return the struttura sanitaria that was removed
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitaria removeByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException {
        return getPersistence().removeByIdStrutturaAndLocale(idStruttura, locale);
    }

    /**
    * Returns the number of struttura sanitarias where idStruttura = &#63; and locale = &#63;.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @return the number of matching struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    public static int countByIdStrutturaAndLocale(long idStruttura,
        java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByIdStrutturaAndLocale(idStruttura, locale);
    }

    /**
    * Caches the struttura sanitaria in the entity cache if it is enabled.
    *
    * @param strutturaSanitaria the struttura sanitaria
    */
    public static void cacheResult(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria) {
        getPersistence().cacheResult(strutturaSanitaria);
    }

    /**
    * Caches the struttura sanitarias in the entity cache if it is enabled.
    *
    * @param strutturaSanitarias the struttura sanitarias
    */
    public static void cacheResult(
        java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> strutturaSanitarias) {
        getPersistence().cacheResult(strutturaSanitarias);
    }

    /**
    * Creates a new struttura sanitaria with the primary key. Does not add the struttura sanitaria to the database.
    *
    * @param pk the primary key for the new struttura sanitaria
    * @return the new struttura sanitaria
    */
    public static it.sincon.sanita.services.model.StrutturaSanitaria create(
        long pk) {
        return getPersistence().create(pk);
    }

    /**
    * Removes the struttura sanitaria with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria that was removed
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitaria remove(
        long pk)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException {
        return getPersistence().remove(pk);
    }

    public static it.sincon.sanita.services.model.StrutturaSanitaria updateImpl(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(strutturaSanitaria);
    }

    /**
    * Returns the struttura sanitaria with the primary key or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaException} if it could not be found.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitaria findByPrimaryKey(
        long pk)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException {
        return getPersistence().findByPrimaryKey(pk);
    }

    /**
    * Returns the struttura sanitaria with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria, or <code>null</code> if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitaria fetchByPrimaryKey(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(pk);
    }

    /**
    * Returns all the struttura sanitarias.
    *
    * @return the struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the struttura sanitarias from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of struttura sanitarias.
    *
    * @return the number of struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static StrutturaSanitariaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (StrutturaSanitariaPersistence) PortletBeanLocatorUtil.locate(it.sincon.sanita.services.service.ClpSerializer.getServletContextName(),
                    StrutturaSanitariaPersistence.class.getName());

            ReferenceRegistry.registerReference(StrutturaSanitariaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(StrutturaSanitariaPersistence persistence) {
    }
}
