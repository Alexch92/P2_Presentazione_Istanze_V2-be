package it.sincon.sanita.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CategoriaStrutturaLocalService}.
 *
 * @author Sincon
 * @see CategoriaStrutturaLocalService
 * @generated
 */
public class CategoriaStrutturaLocalServiceWrapper
    implements CategoriaStrutturaLocalService,
        ServiceWrapper<CategoriaStrutturaLocalService> {
    private CategoriaStrutturaLocalService _categoriaStrutturaLocalService;

    public CategoriaStrutturaLocalServiceWrapper(
        CategoriaStrutturaLocalService categoriaStrutturaLocalService) {
        _categoriaStrutturaLocalService = categoriaStrutturaLocalService;
    }

    /**
    * Adds the categoria struttura to the database. Also notifies the appropriate model listeners.
    *
    * @param categoriaStruttura the categoria struttura
    * @return the categoria struttura that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura addCategoriaStruttura(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.addCategoriaStruttura(categoriaStruttura);
    }

    /**
    * Creates a new categoria struttura with the primary key. Does not add the categoria struttura to the database.
    *
    * @param idTipoStruttura the primary key for the new categoria struttura
    * @return the new categoria struttura
    */
    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura createCategoriaStruttura(
        java.lang.String idTipoStruttura) {
        return _categoriaStrutturaLocalService.createCategoriaStruttura(idTipoStruttura);
    }

    /**
    * Deletes the categoria struttura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura that was removed
    * @throws PortalException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura deleteCategoriaStruttura(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.deleteCategoriaStruttura(idTipoStruttura);
    }

    /**
    * Deletes the categoria struttura from the database. Also notifies the appropriate model listeners.
    *
    * @param categoriaStruttura the categoria struttura
    * @return the categoria struttura that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura deleteCategoriaStruttura(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.deleteCategoriaStruttura(categoriaStruttura);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _categoriaStrutturaLocalService.dynamicQuery();
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
        return _categoriaStrutturaLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.dynamicQuery(dynamicQuery,
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
        return _categoriaStrutturaLocalService.dynamicQueryCount(dynamicQuery);
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
        return _categoriaStrutturaLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura fetchCategoriaStruttura(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.fetchCategoriaStruttura(idTipoStruttura);
    }

    /**
    * Returns the categoria struttura with the primary key.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura
    * @throws PortalException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura getCategoriaStruttura(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.getCategoriaStruttura(idTipoStruttura);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> getCategoriaStrutturas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.getCategoriaStrutturas(start, end);
    }

    /**
    * Returns the number of categoria strutturas.
    *
    * @return the number of categoria strutturas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getCategoriaStrutturasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.getCategoriaStrutturasCount();
    }

    /**
    * Updates the categoria struttura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param categoriaStruttura the categoria struttura
    * @return the categoria struttura that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CategoriaStruttura updateCategoriaStruttura(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoriaStrutturaLocalService.updateCategoriaStruttura(categoriaStruttura);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _categoriaStrutturaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _categoriaStrutturaLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _categoriaStrutturaLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CategoriaStrutturaLocalService getWrappedCategoriaStrutturaLocalService() {
        return _categoriaStrutturaLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCategoriaStrutturaLocalService(
        CategoriaStrutturaLocalService categoriaStrutturaLocalService) {
        _categoriaStrutturaLocalService = categoriaStrutturaLocalService;
    }

    @Override
    public CategoriaStrutturaLocalService getWrappedService() {
        return _categoriaStrutturaLocalService;
    }

    @Override
    public void setWrappedService(
        CategoriaStrutturaLocalService categoriaStrutturaLocalService) {
        _categoriaStrutturaLocalService = categoriaStrutturaLocalService;
    }
}
