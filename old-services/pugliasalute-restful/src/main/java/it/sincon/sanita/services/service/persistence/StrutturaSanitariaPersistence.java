package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.sincon.sanita.services.model.StrutturaSanitaria;

/**
 * The persistence interface for the struttura sanitaria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see StrutturaSanitariaPersistenceImpl
 * @see StrutturaSanitariaUtil
 * @generated
 */
public interface StrutturaSanitariaPersistence extends BasePersistence<StrutturaSanitaria> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link StrutturaSanitariaUtil} to access the struttura sanitaria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the struttura sanitaria where idStruttura = &#63; and locale = &#63; or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaException} if it could not be found.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @return the matching struttura sanitaria
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a matching struttura sanitaria could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria findByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException;

    /**
    * Returns the struttura sanitaria where idStruttura = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @return the matching struttura sanitaria, or <code>null</code> if a matching struttura sanitaria could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria fetchByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the struttura sanitaria where idStruttura = &#63; and locale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching struttura sanitaria, or <code>null</code> if a matching struttura sanitaria could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria fetchByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the struttura sanitaria where idStruttura = &#63; and locale = &#63; from the database.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @return the struttura sanitaria that was removed
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria removeByIdStrutturaAndLocale(
        long idStruttura, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException;

    /**
    * Returns the number of struttura sanitarias where idStruttura = &#63; and locale = &#63;.
    *
    * @param idStruttura the id struttura
    * @param locale the locale
    * @return the number of matching struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    public int countByIdStrutturaAndLocale(long idStruttura,
        java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the struttura sanitaria in the entity cache if it is enabled.
    *
    * @param strutturaSanitaria the struttura sanitaria
    */
    public void cacheResult(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria);

    /**
    * Caches the struttura sanitarias in the entity cache if it is enabled.
    *
    * @param strutturaSanitarias the struttura sanitarias
    */
    public void cacheResult(
        java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> strutturaSanitarias);

    /**
    * Creates a new struttura sanitaria with the primary key. Does not add the struttura sanitaria to the database.
    *
    * @param pk the primary key for the new struttura sanitaria
    * @return the new struttura sanitaria
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria create(long pk);

    /**
    * Removes the struttura sanitaria with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria that was removed
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria remove(long pk)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException;

    public it.sincon.sanita.services.model.StrutturaSanitaria updateImpl(
        it.sincon.sanita.services.model.StrutturaSanitaria strutturaSanitaria)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the struttura sanitaria with the primary key or throws a {@link it.sincon.sanita.services.NoSuchStrutturaSanitariaException} if it could not be found.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria
    * @throws it.sincon.sanita.services.NoSuchStrutturaSanitariaException if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria findByPrimaryKey(
        long pk)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchStrutturaSanitariaException;

    /**
    * Returns the struttura sanitaria with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param pk the primary key of the struttura sanitaria
    * @return the struttura sanitaria, or <code>null</code> if a struttura sanitaria with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.StrutturaSanitaria fetchByPrimaryKey(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the struttura sanitarias.
    *
    * @return the struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the struttura sanitarias.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.StrutturaSanitariaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of struttura sanitarias
    * @param end the upper bound of the range of struttura sanitarias (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the struttura sanitarias from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of struttura sanitarias.
    *
    * @return the number of struttura sanitarias
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
