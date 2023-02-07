package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import it.sincon.sanita.services.model.CFG_CategorieAbilitate;

/**
 * The persistence interface for the c f g_ categorie abilitate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see CFG_CategorieAbilitatePersistenceImpl
 * @see CFG_CategorieAbilitateUtil
 * @generated
 */
public interface CFG_CategorieAbilitatePersistence extends BasePersistence<CFG_CategorieAbilitate> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CFG_CategorieAbilitateUtil} to access the c f g_ categorie abilitate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the c f g_ categorie abilitates where className = &#63;.
    *
    * @param className the class name
    * @return the matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassName(
        java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the c f g_ categorie abilitates where className = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param className the class name
    * @param start the lower bound of the range of c f g_ categorie abilitates
    * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
    * @return the range of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassName(
        java.lang.String className, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the c f g_ categorie abilitates where className = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param className the class name
    * @param start the lower bound of the range of c f g_ categorie abilitates
    * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassName(
        java.lang.String className, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63;.
    *
    * @param className the class name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassName_First(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    /**
    * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63;.
    *
    * @param className the class name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassName_First(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63;.
    *
    * @param className the class name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassName_Last(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    /**
    * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63;.
    *
    * @param className the class name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassName_Last(
        java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the c f g_ categorie abilitates before and after the current c f g_ categorie abilitate in the ordered set where className = &#63;.
    *
    * @param titoloStruttura the primary key of the current c f g_ categorie abilitate
    * @param className the class name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate[] findByClassName_PrevAndNext(
        java.lang.String titoloStruttura, java.lang.String className,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    /**
    * Removes all the c f g_ categorie abilitates where className = &#63; from the database.
    *
    * @param className the class name
    * @throws SystemException if a system exception occurred
    */
    public void removeByClassName(java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of c f g_ categorie abilitates where className = &#63;.
    *
    * @param className the class name
    * @return the number of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public int countByClassName(java.lang.String className)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @return the matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @param start the lower bound of the range of c f g_ categorie abilitates
    * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
    * @return the range of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @param start the lower bound of the range of c f g_ categorie abilitates
    * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findByClassNameAndDefaultRicerca(
        java.lang.String className, boolean defaultRicerca, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassNameAndDefaultRicerca_First(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    /**
    * Returns the first c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassNameAndDefaultRicerca_First(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate findByClassNameAndDefaultRicerca_Last(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    /**
    * Returns the last c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching c f g_ categorie abilitate, or <code>null</code> if a matching c f g_ categorie abilitate could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByClassNameAndDefaultRicerca_Last(
        java.lang.String className, boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the c f g_ categorie abilitates before and after the current c f g_ categorie abilitate in the ordered set where className = &#63; and defaultRicerca = &#63;.
    *
    * @param titoloStruttura the primary key of the current c f g_ categorie abilitate
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate[] findByClassNameAndDefaultRicerca_PrevAndNext(
        java.lang.String titoloStruttura, java.lang.String className,
        boolean defaultRicerca,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    /**
    * Removes all the c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63; from the database.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @throws SystemException if a system exception occurred
    */
    public void removeByClassNameAndDefaultRicerca(java.lang.String className,
        boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of c f g_ categorie abilitates where className = &#63; and defaultRicerca = &#63;.
    *
    * @param className the class name
    * @param defaultRicerca the default ricerca
    * @return the number of matching c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public int countByClassNameAndDefaultRicerca(java.lang.String className,
        boolean defaultRicerca)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the c f g_ categorie abilitate in the entity cache if it is enabled.
    *
    * @param cfg_CategorieAbilitate the c f g_ categorie abilitate
    */
    public void cacheResult(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate);

    /**
    * Caches the c f g_ categorie abilitates in the entity cache if it is enabled.
    *
    * @param cfg_CategorieAbilitates the c f g_ categorie abilitates
    */
    public void cacheResult(
        java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> cfg_CategorieAbilitates);

    /**
    * Creates a new c f g_ categorie abilitate with the primary key. Does not add the c f g_ categorie abilitate to the database.
    *
    * @param titoloStruttura the primary key for the new c f g_ categorie abilitate
    * @return the new c f g_ categorie abilitate
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate create(
        java.lang.String titoloStruttura);

    /**
    * Removes the c f g_ categorie abilitate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate that was removed
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate remove(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    public it.sincon.sanita.services.model.CFG_CategorieAbilitate updateImpl(
        it.sincon.sanita.services.model.CFG_CategorieAbilitate cfg_CategorieAbilitate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the c f g_ categorie abilitate with the primary key or throws a {@link it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException} if it could not be found.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate
    * @throws it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate findByPrimaryKey(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchCFG_CategorieAbilitateException;

    /**
    * Returns the c f g_ categorie abilitate with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param titoloStruttura the primary key of the c f g_ categorie abilitate
    * @return the c f g_ categorie abilitate, or <code>null</code> if a c f g_ categorie abilitate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public it.sincon.sanita.services.model.CFG_CategorieAbilitate fetchByPrimaryKey(
        java.lang.String titoloStruttura)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the c f g_ categorie abilitates.
    *
    * @return the c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the c f g_ categorie abilitates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.CFG_CategorieAbilitateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of c f g_ categorie abilitates
    * @param end the upper bound of the range of c f g_ categorie abilitates (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<it.sincon.sanita.services.model.CFG_CategorieAbilitate> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the c f g_ categorie abilitates from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of c f g_ categorie abilitates.
    *
    * @return the number of c f g_ categorie abilitates
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
