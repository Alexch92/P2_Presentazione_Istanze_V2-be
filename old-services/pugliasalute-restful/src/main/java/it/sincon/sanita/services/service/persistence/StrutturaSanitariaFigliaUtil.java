package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;

import java.util.List;

/**
 * The persistence utility for the struttura sanitaria figlia service. This utility wraps {@link StrutturaSanitariaFigliaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitariaFigliaPersistence
 * @see StrutturaSanitariaFigliaPersistenceImpl
 * @generated
 */
public class StrutturaSanitariaFigliaUtil {
    private static StrutturaSanitariaFigliaPersistence _persistence;

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
    public static void clearCache(
        StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        getPersistence().clearCache(strutturaSanitariaFiglia);
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
    public static List<StrutturaSanitariaFiglia> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<StrutturaSanitariaFiglia> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<StrutturaSanitariaFiglia> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static StrutturaSanitariaFiglia update(
        StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws SystemException {
        return getPersistence().update(strutturaSanitariaFiglia);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static StrutturaSanitariaFiglia update(
        StrutturaSanitariaFiglia strutturaSanitariaFiglia,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(strutturaSanitariaFiglia, serviceContext);
    }

    /**
    * Caches the struttura sanitaria figlia in the entity cache if it is enabled.
    *
    * @param strutturaSanitariaFiglia the struttura sanitaria figlia
    */
    public static void cacheResult(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        getPersistence().cacheResult(strutturaSanitariaFiglia);
    }

    /**
    * Caches the struttura sanitaria figlias in the entity cache if it is enabled.
    *
    * @param strutturaSanitariaFiglias the struttura sanitaria figlias
    */
    public static void cacheResult(
        java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> strutturaSanitariaFiglias) {
        getPersistence().cacheResult(strutturaSanitariaFiglias);
    }

    /**
    * Creates a new struttura sanitaria figlia with the primary key. Does not add the struttura sanitaria figlia to the database.
    *
    * @param idStrutturaFiglia the primary key for the new struttura sanitaria figlia
    * @return the new struttura sanitaria figlia
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia create(
        long idStrutturaFiglia) {
        return getPersistence().create(idStrutturaFiglia);
    }

    /**
    * Removes the struttura sanitaria figlia with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia that was removed
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia remove(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException {
        return getPersistence().remove(idStrutturaFiglia);
    }

    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia updateImpl(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(strutturaSanitariaFiglia);
    }

    /**
    * Returns the struttura sanitaria figlia with the primary key or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException} if it could not be found.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia findByPrimaryKey(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException {
        return getPersistence().findByPrimaryKey(idStrutturaFiglia);
    }

    /**
    * Returns the struttura sanitaria figlia with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia, or <code>null</code> if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia fetchByPrimaryKey(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(idStrutturaFiglia);
    }

    /**
    * Returns all the struttura sanitaria figlias.
    *
    * @return the struttura sanitaria figlias
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the struttura sanitaria figlias from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of struttura sanitaria figlias.
    *
    * @return the number of struttura sanitaria figlias
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static StrutturaSanitariaFigliaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (StrutturaSanitariaFigliaPersistence) PortletBeanLocatorUtil.locate(it.sincon.sanita.services.service.ClpSerializer.getServletContextName(),
                    StrutturaSanitariaFigliaPersistence.class.getName());

            ReferenceRegistry.registerReference(StrutturaSanitariaFigliaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(StrutturaSanitariaFigliaPersistence persistence) {
    }
}
