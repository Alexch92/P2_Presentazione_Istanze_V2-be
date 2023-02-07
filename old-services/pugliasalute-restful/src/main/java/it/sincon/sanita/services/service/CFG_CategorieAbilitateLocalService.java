package it.sincon.sanita.services.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for CFG_CategorieAbilitate. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Sincon
 * @see CFG_CategorieAbilitateLocalServiceUtil
 * @see it.sincon.sanita.services.service.base.CFG_CategorieAbilitateLocalServiceBaseImpl
 * @see it.sincon.sanita.services.service.impl.CFG_CategorieAbilitateLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface CFG_CategorieAbilitateLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CFG_CategorieAbilitateLocalServiceUtil} to access the c f g_ categorie abilitate local service. Add custom service methods to {@link it.sincon.sanita.services.service.impl.CFG_CategorieAbilitateLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the c f g_ categorie abilitate to the database. Also notifies the appropriate model listeners.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was added
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate addCFG_CategorieAbilitate(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new c f g_ categorie abilitate with the primary key. Does not add the c f g_ categorie abilitate to the database.
    *
    * @param titoloStruttura the primary key for the new c f g_ categorie abilitate
    * @return the new c f g_ categorie abilitate
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate createCFG_CategorieAbilitate(
        java.lang.String titoloStruttura);

    /**
    * Deletes the c f g_ categorie abilitate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was removed
    * @throws PortalException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate deleteCFG_CategorieAbilitate(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the c f g_ categorie abilitate from the database. Also notifies the appropriate model listeners.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was removed
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate deleteCFG_CategorieAbilitate(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchCFG_CategorieAbilitate(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the c f g_ categorie abilitate with the primary key.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate
    * @throws PortalException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate getCFG_CategorieAbilitate(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getCFG_CategorieAbilitates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of c f g_ categorie abilitates.
    *
    * @return the number of c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCFG_CategorieAbilitatesCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the c f g_ categorie abilitate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was updated
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate updateCFG_CategorieAbilitate(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getAllCFG_CategorieAbilitate()
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getCFG_CategorieAbilitateByClassName(
        java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getCFG_CategorieAbilitateByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Analizza il jsonAziende (parametro di request inviato dall'app mobile) e se non Ã¨ null restituisce
    * la lista di CFG_CategorieAbilitate corrispondenti, in caso contrario restituisce quelle impostate di default.
    *
    * @param className
    * @param jsonCategorie
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> getSelectedByClassName(
        java.lang.String className, java.lang.String jsonCategorie)
        throws com.liferay.portal.kernel.exception.SystemException;
}
