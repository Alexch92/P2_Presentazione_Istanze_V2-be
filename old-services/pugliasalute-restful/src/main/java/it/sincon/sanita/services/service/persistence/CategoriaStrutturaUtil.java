package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.sincon.sanita.services.model.CategoriaStruttura;

import java.util.List;

/**
 * The persistence utility for the categoria struttura service. This utility wraps {@link CategoriaStrutturaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see CategoriaStrutturaPersistence
 * @see CategoriaStrutturaPersistenceImpl
 * @generated
 */
public class CategoriaStrutturaUtil {
    private static CategoriaStrutturaPersistence _persistence;

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
    public static void clearCache(CategoriaStruttura categoriaStruttura) {
        getPersistence().clearCache(categoriaStruttura);
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
    public static List<CategoriaStruttura> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<CategoriaStruttura> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<CategoriaStruttura> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static CategoriaStruttura update(
        CategoriaStruttura categoriaStruttura) throws SystemException {
        return getPersistence().update(categoriaStruttura);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static CategoriaStruttura update(
        CategoriaStruttura categoriaStruttura, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(categoriaStruttura, serviceContext);
    }

    /**
    * Caches the categoria struttura in the entity cache if it is enabled.
    *
    * @param categoriaStruttura the categoria struttura
    */
    public static void cacheResult(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura) {
        getPersistence().cacheResult(categoriaStruttura);
    }

    /**
    * Caches the categoria strutturas in the entity cache if it is enabled.
    *
    * @param categoriaStrutturas the categoria strutturas
    */
    public static void cacheResult(
        java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> categoriaStrutturas) {
        getPersistence().cacheResult(categoriaStrutturas);
    }

    /**
    * Creates a new categoria struttura with the primary key. Does not add the categoria struttura to the database.
    *
    * @param idTipoStruttura the primary key for the new categoria struttura
    * @return the new categoria struttura
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura create(
        java.lang.String idTipoStruttura) {
        return getPersistence().create(idTipoStruttura);
    }

    /**
    * Removes the categoria struttura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura that was removed
    * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura remove(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCategoriaStrutturaException {
        return getPersistence().remove(idTipoStruttura);
    }

    public static it.sincon.sanita.services.model.CategoriaStruttura updateImpl(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(categoriaStruttura);
    }

    /**
    * Returns the categoria struttura with the primary key or throws a {@link it.sincon.sanita.services.NoSuchCategoriaStrutturaException} if it could not be found.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura
    * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura findByPrimaryKey(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCategoriaStrutturaException {
        return getPersistence().findByPrimaryKey(idTipoStruttura);
    }

    /**
    * Returns the categoria struttura with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura, or <code>null</code> if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura fetchByPrimaryKey(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(idTipoStruttura);
    }

    /**
    * Returns all the categoria strutturas.
    *
    * @return the categoria strutturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the categoria strutturas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of categoria strutturas.
    *
    * @return the number of categoria strutturas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CategoriaStrutturaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CategoriaStrutturaPersistence) PortletBeanLocatorUtil.locate(it.sincon.sanita.services.service.ClpSerializer.getServletContextName(),
                    CategoriaStrutturaPersistence.class.getName());

            ReferenceRegistry.registerReference(CategoriaStrutturaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CategoriaStrutturaPersistence persistence) {
    }
}
