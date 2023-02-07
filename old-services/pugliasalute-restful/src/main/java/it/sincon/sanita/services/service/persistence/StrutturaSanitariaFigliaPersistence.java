package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;

/**
 * The persistence interface for the struttura sanitaria figlia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitariaFigliaPersistenceImpl
 * @see StrutturaSanitariaFigliaUtil
 * @generated
 */
public interface StrutturaSanitariaFigliaPersistence extends BasePersistence<StrutturaSanitariaFiglia> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link StrutturaSanitariaFigliaUtil} to access the struttura sanitaria figlia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the struttura sanitaria figlia in the entity cache if it is enabled.
    *
    * @param strutturaSanitariaFiglia the struttura sanitaria figlia
    */
    public void cacheResult(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia);

    /**
    * Caches the struttura sanitaria figlias in the entity cache if it is enabled.
    *
    * @param strutturaSanitariaFiglias the struttura sanitaria figlias
    */
    public void cacheResult(
        java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> strutturaSanitariaFiglias);

    /**
    * Creates a new struttura sanitaria figlia with the primary key. Does not add the struttura sanitaria figlia to the database.
    *
    * @param idStrutturaFiglia the primary key for the new struttura sanitaria figlia
    * @return the new struttura sanitaria figlia
    */
    public it.sincon.sanita.services.model.StrutturaSanitariaFiglia create(
        long idStrutturaFiglia);

    /**
    * Removes the struttura sanitaria figlia with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia that was removed
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitariaFiglia remove(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException;

    public it.sincon.sanita.services.model.StrutturaSanitariaFiglia updateImpl(
        it.sincon.sanita.services.model.StrutturaSanitariaFiglia strutturaSanitariaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the struttura sanitaria figlia with the primary key or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException} if it could not be found.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitariaFiglia findByPrimaryKey(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaFigliaException;

    /**
    * Returns the struttura sanitaria figlia with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param idStrutturaFiglia the primary key of the struttura sanitaria figlia
    * @return the struttura sanitaria figlia, or <code>null</code> if a struttura sanitaria figlia with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitariaFiglia fetchByPrimaryKey(
        long idStrutturaFiglia)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the struttura sanitaria figlias.
    *
    * @return the struttura sanitaria figlias
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitariaFiglia> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the struttura sanitaria figlias from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of struttura sanitaria figlias.
    *
    * @return the number of struttura sanitaria figlias
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
