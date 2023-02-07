package it.sincon.sanita.services.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for StrutturaSanitariaFiglia. This utility wraps
 * {@link it.sincon.sanita.services.service.impl.StrutturaSanitariaFigliaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sincon
 * @see StrutturaSanitariaFigliaLocalService
 * @see it.sincon.sanita.services.service.base.StrutturaSanitariaFigliaLocalServiceBaseImpl
 * @see it.sincon.sanita.services.service.impl.StrutturaSanitariaFigliaLocalServiceImpl
 * @generated
 */
public class StrutturaSanitariaFigliaLocalServiceUtil {
    private static StrutturaSanitariaFigliaLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link it.sincon.sanita.services.service.impl.StrutturaSanitariaFigliaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the struttura sanitaria figlia to the database. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitariaFiglia the struttura sanitaria figlia
    * @return the struttura sanitaria figlia that was added
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia addStrutturaSanitariaFiglia(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addStrutturaSanitariaFiglia(strutturaSanitariaFiglia);
    }

    /**
    * Creates a new struttura sanitaria figlia with the primary key. Does not add the struttura sanitaria figlia to the database.
    *
    * @param idStrutturaFiglia the primary key for the new struttura sanitaria figlia
    * @return the new struttura sanitaria figlia
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia createStrutturaSanitariaFiglia(
        long idStrutturaFiglia) {
        return getService().createStrutturaSanitariaFiglia(idStrutturaFiglia);
    }

    /**
    * Deletes the struttura sanitaria figlia with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia that was removed
    * @throws PortalException if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia deleteStrutturaSanitariaFiglia(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteStrutturaSanitariaFiglia(idStrutturaFiglia);
    }

    /**
    * Deletes the struttura sanitaria figlia from the database. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitariaFiglia the struttura sanitaria figlia
    * @return the struttura sanitaria figlia that was removed
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia deleteStrutturaSanitariaFiglia(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteStrutturaSanitariaFiglia(strutturaSanitariaFiglia);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaFigliaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia fetchStrutturaSanitariaFiglia(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchStrutturaSanitariaFiglia(idStrutturaFiglia);
    }

    /**
    * Returns the struttura sanitaria figlia with the primary key.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia
    * @throws PortalException if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia getStrutturaSanitariaFiglia(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getStrutturaSanitariaFiglia(idStrutturaFiglia);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> getStrutturaSanitariaFiglias(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getStrutturaSanitariaFiglias(start, end);
    }

    /**
    * Returns the number of struttura sanitaria figlias.
    *
    * @return the number of struttura sanitaria figlias
    * @throws SystemException if a system exception occurred
    */
    public static int getStrutturaSanitariaFigliasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getStrutturaSanitariaFigliasCount();
    }

    /**
    * Updates the struttura sanitaria figlia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitariaFiglia the struttura sanitaria figlia
    * @return the struttura sanitaria figlia that was updated
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.StrutturaSanitariaFiglia updateStrutturaSanitariaFiglia(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateStrutturaSanitariaFiglia(strutturaSanitariaFiglia);
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

    public static StrutturaSanitariaFigliaLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    StrutturaSanitariaFigliaLocalService.class.getName());

            if (invokableLocalService instanceof StrutturaSanitariaFigliaLocalService) {
                _service = (StrutturaSanitariaFigliaLocalService) invokableLocalService;
            } else {
                _service = new StrutturaSanitariaFigliaLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(StrutturaSanitariaFigliaLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(StrutturaSanitariaFigliaLocalService service) {
    }
}
