package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.sincon.sanita.services.model.CategoriaStruttura;

/**
 * The persistence interface for the categoria struttura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see CategoriaStrutturaPersistenceImpl
 * @see CategoriaStrutturaUtil
 * @generated
 */
public interface CategoriaStrutturaPersistence extends BasePersistence<CategoriaStruttura> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CategoriaStrutturaUtil} to access the categoria struttura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the categoria struttura in the entity cache if it is enabled.
    *
    * @param categoriaStruttura the categoria struttura
    */
    public void cacheResult(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura);

    /**
    * Caches the categoria strutturas in the entity cache if it is enabled.
    *
    * @param categoriaStrutturas the categoria strutturas
    */
    public void cacheResult(
        java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> categoriaStrutturas);

    /**
    * Creates a new categoria struttura with the primary key. Does not add the categoria struttura to the database.
    *
    * @param idTipoStruttura the primary key for the new categoria struttura
    * @return the new categoria struttura
    */
    public it.sincon.sanita.services.model.CategoriaStruttura create(
        java.lang.String idTipoStruttura);

    /**
    * Removes the categoria struttura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura that was removed
    * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CategoriaStruttura remove(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCategoriaStrutturaException;

    public it.sincon.sanita.services.model.CategoriaStruttura updateImpl(
        it.sincon.sanita.services.model.CategoriaStruttura categoriaStruttura)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the categoria struttura with the primary key or throws a {@link it.sincon.sanita.services.NoSuchCategoriaStrutturaException} if it could not be found.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura
    * @throws it.sincon.sanita.services.NoSuchCategoriaStrutturaException if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CategoriaStruttura findByPrimaryKey(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCategoriaStrutturaException;

    /**
    * Returns the categoria struttura with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param idTipoStruttura the primary key of the categoria struttura
    * @return the categoria struttura, or <code>null</code> if a categoria struttura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CategoriaStruttura fetchByPrimaryKey(
        java.lang.String idTipoStruttura)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the categoria strutturas.
    *
    * @return the categoria strutturas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the categoria strutturas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of categoria strutturas
    * @param end the upper bound of the range of categoria strutturas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of categoria strutturas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CategoriaStruttura> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the categoria strutturas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categoria strutturas.
    *
    * @return the number of categoria strutturas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
