package it.sincon.sanita.services.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CategoriaStruttura. This utility wraps
 * {@link it.sincon.sanita.services.service.impl.CategoriaStrutturaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sincon
 * @see CategoriaStrutturaLocalService
 * @see it.sincon.sanita.services.service.base.CategoriaStrutturaLocalServiceBaseImpl
 * @see it.sincon.sanita.services.service.impl.CategoriaStrutturaLocalServiceImpl
 * @generated
 */
public class CategoriaStrutturaLocalServiceUtil {
    private static CategoriaStrutturaLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link it.sincon.sanita.services.service.impl.CategoriaStrutturaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the categoria struttura to the database. Also notifies the appropriate model listeners.
    *
    * @param categoriaStruttura the categoria struttura
    * @return the categoria struttura that was added
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura addCategoriaStruttura(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addCategoriaStruttura(categoriaStruttura);
    }

    /**
    * Creates a new categoria struttura with the primary key. Does not add the categoria struttura to the database.
    *
    * @param idTipoStruttura the primary key for the new categoria struttura
    * @return the new categoria struttura
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura createCategoriaStruttura(
        java.lang.String idTipoStruttura) {
        return getService().createCategoriaStruttura(idTipoStruttura);
    }

    /**
    * Deletes the categoria struttura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura that was removed
    * @throws PortalException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura deleteCategoriaStruttura(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCategoriaStruttura(idTipoStruttura);
    }

    /**
    * Deletes the categoria struttura from the database. Also notifies the appropriate model listeners.
    *
    * @param categoriaStruttura the categoria struttura
    * @return the categoria struttura that was removed
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura deleteCategoriaStruttura(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteCategoriaStruttura(categoriaStruttura);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static it.sincon.sanita.services.model.CategoriaStruttura fetchCategoriaStruttura(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchCategoriaStruttura(idTipoStruttura);
    }

    /**
    * Returns the categoria struttura with the primary key.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura
    * @throws PortalException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura getCategoriaStruttura(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategoriaStruttura(idTipoStruttura);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> getCategoriaStrutturas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategoriaStrutturas(start, end);
    }

    /**
    * Returns the number of categoria strutturas.
    *
    * @return the number of categoria strutturas
    * @throws SystemException if a system exception occurred
    */
    public static int getCategoriaStrutturasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getCategoriaStrutturasCount();
    }

    /**
    * Updates the categoria struttura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param categoriaStruttura the categoria struttura
    * @return the categoria struttura that was updated
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.CategoriaStruttura updateCategoriaStruttura(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateCategoriaStruttura(categoriaStruttura);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static CategoriaStrutturaLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    CategoriaStrutturaLocalService.class.getName());

            if (invokableLocalService instanceof CategoriaStrutturaLocalService) {
                _service = (CategoriaStrutturaLocalService) invokableLocalService;
            } else {
                _service = new CategoriaStrutturaLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(CategoriaStrutturaLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(CategoriaStrutturaLocalService service) {
    }
}
