package it.sincon.sanita.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StrutturaSanitariaLocalService}.
 *
 * @author Sincon
 * @see StrutturaSanitariaLocalService
 * @generated
 */
public class StrutturaSanitariaLocalServiceWrapper
    implements StrutturaSanitariaLocalService,
        ServiceWrapper<StrutturaSanitariaLocalService> {
    private StrutturaSanitariaLocalService _strutturaSanitariaLocalService;

    public StrutturaSanitariaLocalServiceWrapper(
        StrutturaSanitariaLocalService strutturaSanitariaLocalService) {
        _strutturaSanitariaLocalService = strutturaSanitariaLocalService;
    }

    /**
    * Adds the struttura sanitaria to the database. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitaria the struttura sanitaria
    * @return the struttura sanitaria that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria addStrutturaSanitaria(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.addStrutturaSanitaria(strutturaSanitaria);
    }

    /**
    * Creates a new struttura sanitaria with the primary key. Does not add the struttura sanitaria to the database.
    *
    * @param pk the primary key for the new struttura sanitaria
    * @return the new struttura sanitaria
    */
    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria createStrutturaSanitaria(
        long pk) {
        return _strutturaSanitariaLocalService.createStrutturaSanitaria(pk);
    }

    /**
    * Deletes the struttura sanitaria with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria that was removed
    * @throws PortalException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria deleteStrutturaSanitaria(
        long pk)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.deleteStrutturaSanitaria(pk);
    }

    /**
    * Deletes the struttura sanitaria from the database. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitaria the struttura sanitaria
    * @return the struttura sanitaria that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria deleteStrutturaSanitaria(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.deleteStrutturaSanitaria(strutturaSanitaria);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _strutturaSanitariaLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria fetchStrutturaSanitaria(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.fetchStrutturaSanitaria(pk);
    }

    /**
    * Returns the struttura sanitaria with the primary key.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria
    * @throws PortalException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria getStrutturaSanitaria(
        long pk)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.getStrutturaSanitaria(pk);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> getStrutturaSanitarias(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.getStrutturaSanitarias(start, end);
    }

    /**
    * Returns the number of struttura sanitarias.
    *
    * @return the number of struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getStrutturaSanitariasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.getStrutturaSanitariasCount();
    }

    /**
    * Updates the struttura sanitaria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitaria the struttura sanitaria
    * @return the struttura sanitaria that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria updateStrutturaSanitaria(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.updateStrutturaSanitaria(strutturaSanitaria);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _strutturaSanitariaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _strutturaSanitariaLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _strutturaSanitariaLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public long replaceAll(
        java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> newItemsList)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.replaceAll(newItemsList);
    }

    @Override
    public it.sincon.sanita.services.model.StrutturaSanitaria findByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.findByIdStrutturaAndLocale(idStruttura,
            locale);
    }

    @Override
    public long searchCount(
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.searchCount(listaIdTipoStrutture,
            listaIdStrutture, fullText, locale);
    }

    @Override
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> search(
        int start, int numRes,
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.Double mobile_latitude,
        java.lang.Double mobile_longitude, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _strutturaSanitariaLocalService.search(start, numRes,
            listaIdTipoStrutture, listaIdStrutture, fullText, mobile_latitude,
            mobile_longitude, locale);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public StrutturaSanitariaLocalService getWrappedStrutturaSanitariaLocalService() {
        return _strutturaSanitariaLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedStrutturaSanitariaLocalService(
        StrutturaSanitariaLocalService strutturaSanitariaLocalService) {
        _strutturaSanitariaLocalService = strutturaSanitariaLocalService;
    }

    @Override
    public StrutturaSanitariaLocalService getWrappedService() {
        return _strutturaSanitariaLocalService;
    }

    @Override
    public void setWrappedService(
        StrutturaSanitariaLocalService strutturaSanitariaLocalService) {
        _strutturaSanitariaLocalService = strutturaSanitariaLocalService;
    }
}
