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
 * Provides the local service interface for StrutturaSanitaria. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Sincon
 * @see StrutturaSanitariaLocalServiceUtil
 * @see it.sincon.sanita.services.service.base.StrutturaSanitariaLocalServiceBaseImpl
 * @see it.sincon.sanita.services.service.impl.StrutturaSanitariaLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface StrutturaSanitariaLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link StrutturaSanitariaLocalServiceUtil} to access the struttura sanitaria local service. Add custom service methods to {@link it.sincon.sanita.services.service.impl.StrutturaSanitariaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the struttura sanitaria to the database. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitaria the struttura sanitaria
    * @return the struttura sanitaria that was added
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria addStrutturaSanitaria(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new struttura sanitaria with the primary key. Does not add the struttura sanitaria to the database.
    *
    * @param pk the primary key for the new struttura sanitaria
    * @return the new struttura sanitaria
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria createStrutturaSanitaria(
        long pk);

    /**
    * Deletes the struttura sanitaria with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria that was removed
    * @throws PortalException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria deleteStrutturaSanitaria(
        long pk)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the struttura sanitaria from the database. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitaria the struttura sanitaria
    * @return the struttura sanitaria that was removed
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria deleteStrutturaSanitaria(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public it.sincon.sanita.services.model.StrutturaSanitaria fetchStrutturaSanitaria(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the struttura sanitaria with the primary key.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria
    * @throws PortalException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public it.sincon.sanita.services.model.StrutturaSanitaria getStrutturaSanitaria(
        long pk)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> getStrutturaSanitarias(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of struttura sanitarias.
    *
    * @return the number of struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getStrutturaSanitariasCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the struttura sanitaria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param strutturaSanitaria the struttura sanitaria
    * @return the struttura sanitaria that was updated
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria updateStrutturaSanitaria(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
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

    public long replaceAll(
        java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> newItemsList)
        throws com.liferay.portal.kernel.exception.SystemException;

    public it.sincon.sanita.services.model.StrutturaSanitaria findByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long searchCount(
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> search(
        int start, int numRes,
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.Double mobile_latitude,
        java.lang.Double mobile_longitude, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;
}
