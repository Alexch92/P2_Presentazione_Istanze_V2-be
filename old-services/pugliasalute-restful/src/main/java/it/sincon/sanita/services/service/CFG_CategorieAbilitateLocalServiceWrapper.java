package it.sincon.sanita.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CFG_CategorieAbilitateLocalService}.
 *
 * @author Sincon
 * @see CFG_CategorieAbilitateLocalService
 * @generated
 */
public class CFG_CategorieAbilitateLocalServiceWrapper
    implements CFG_CategorieAbilitateLocalService,
        ServiceWrapper<CFG_CategorieAbilitateLocalService> {
    private CFG_CategorieAbilitateLocalService _cfg_CategorieAbilitateLocalService;

    public CFG_CategorieAbilitateLocalServiceWrapper(
        CFG_CategorieAbilitateLocalService cfg_CategorieAbilitateLocalService) {
        _cfg_CategorieAbilitateLocalService = cfg_CategorieAbilitateLocalService;
    }

    /**
    * Adds the c f g_ categorie abilitate to the database. Also notifies the appropriate model listeners.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate addCFG_CategorieAbilitate(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.addCFG_CategorieAbilitate(cfg_CategorieAbilitate);
    }

    /**
    * Creates a new c f g_ categorie abilitate with the primary key. Does not add the c f g_ categorie abilitate to the database.
    *
    * @param titoloStruttura the primary key for the new c f g_ categorie abilitate
    * @return the new c f g_ categorie abilitate
    */
    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate createCFG_CategorieAbilitate(
        java.lang.String titoloStruttura) {
        return _cfg_CategorieAbilitateLocalService.createCFG_CategorieAbilitate(titoloStruttura);
    }

    /**
    * Deletes the c f g_ categorie abilitate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was removed
    * @throws PortalException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate deleteCFG_CategorieAbilitate(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.deleteCFG_CategorieAbilitate(titoloStruttura);
    }

    /**
    * Deletes the c f g_ categorie abilitate from the database. Also notifies the appropriate model listeners.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate deleteCFG_CategorieAbilitate(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.deleteCFG_CategorieAbilitate(cfg_CategorieAbilitate);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _cfg_CategorieAbilitateLocalService.dynamicQuery();
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
        return _cfg_CategorieAbilitateLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _cfg_CategorieAbilitateLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _cfg_CategorieAbilitateLocalService.dynamicQuery(dynamicQuery,
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
        return _cfg_CategorieAbilitateLocalService.dynamicQueryCount(dynamicQuery);
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
        return _cfg_CategorieAbilitateLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchCFG_CategorieAbilitate(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.fetchCFG_CategorieAbilitate(titoloStruttura);
    }

    /**
    * Returns the c f g_ categorie abilitate with the primary key.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate
    * @throws PortalException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate getCFG_CategorieAbilitate(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getCFG_CategorieAbilitate(titoloStruttura);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getCFG_CategorieAbilitates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getCFG_CategorieAbilitates(start,
            end);
    }

    /**
    * Returns the number of c f g_ categorie abilitates.
    *
    * @return the number of c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getCFG_CategorieAbilitatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getCFG_CategorieAbilitatesCount();
    }

    /**
    * Updates the c f g_ categorie abilitate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate updateCFG_CategorieAbilitate(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.updateCFG_CategorieAbilitate(cfg_CategorieAbilitate);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _cfg_CategorieAbilitateLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _cfg_CategorieAbilitateLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _cfg_CategorieAbilitateLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getAllCFG_CategorieAbilitate()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getAllCFG_CategorieAbilitate();
    }

    @Override
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getCFG_CategorieAbilitateByClassName(
        java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getCFG_CategorieAbilitateByClassName(className);
    }

    @Override
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getCFG_CategorieAbilitateByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getCFG_CategorieAbilitateByClassNameAndDefaultRicerca(className,
            defaultRicerca);
    }

    /**
    * Analizza il jsonAziende (parametro di request inviato dall'app mobile) e se non ÃƒÂ¨ null restituisce
    * la lista di CFG_CategorieAbilitate corrispondenti, in caso contrario restituisce quelle impostate di default.
    *
    * @param className
    * @param jsonCategorie
    * @return
    * @throws SystemException
    */
    @Override
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getSelectedByClassName(
        java.lang.String className, java.lang.String jsonCategorie)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _cfg_CategorieAbilitateLocalService.getSelectedByClassName(className,
            jsonCategorie);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CFG_CategorieAbilitateLocalService getWrappedCFG_CategorieAbilitateLocalService() {
        return _cfg_CategorieAbilitateLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCFG_CategorieAbilitateLocalService(
        CFG_CategorieAbilitateLocalService cfg_CategorieAbilitateLocalService) {
        _cfg_CategorieAbilitateLocalService = cfg_CategorieAbilitateLocalService;
    }

    @Override
    public CFG_CategorieAbilitateLocalService getWrappedService() {
        return _cfg_CategorieAbilitateLocalService;
    }

    @Override
    public void setWrappedService(
        CFG_CategorieAbilitateLocalService cfg_CategorieAbilitateLocalService) {
        _cfg_CategorieAbilitateLocalService = cfg_CategorieAbilitateLocalService;
    }
}
