package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.sincon.sanita.services.model.News;

import java.util.List;

/**
 * The persistence utility for the news service. This utility wraps {@link NewsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sincon
 * @see NewsPersistence
 * @see NewsPersistenceImpl
 * @generated
 */
public class NewsUtil {
    private static NewsPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(News news) {
        getPersistence().clearCache(news);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<News> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<News> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<News> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static News update(News news) throws SystemException {
        return getPersistence().update(news);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static News update(News news, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(news, serviceContext);
    }

    /**
    * Caches the news in the entity cache if it is enabled.
    *
    * @param news the news
    */
    public static void cacheResult(it.sincon.sanita.services.model.News news) {
        getPersistence().cacheResult(news);
    }

    /**
    * Caches the newses in the entity cache if it is enabled.
    *
    * @param newses the newses
    */
    public static void cacheResult(
        java.util.List<it.sincon.sanita.services.model.News> newses) {
        getPersistence().cacheResult(newses);
    }

    /**
    * Creates a new news with the primary key. Does not add the news to the database.
    *
    * @param pk the primary key for the new news
    * @return the new news
    */
    public static it.sincon.sanita.services.model.News create(long pk) {
        return getPersistence().create(pk);
    }

    /**
    * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param pk the primary key of the news
    * @return the news that was removed
    * @throws it.sincon.sanita.services.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.News remove(long pk)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchNewsException {
        return getPersistence().remove(pk);
    }

    public static it.sincon.sanita.services.model.News updateImpl(
        it.sincon.sanita.services.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(news);
    }

    /**
    * Returns the news with the primary key or throws a {@link it.sincon.sanita.services.NoSuchNewsException} if it could not be found.
    *
    * @param pk the primary key of the news
    * @return the news
    * @throws it.sincon.sanita.services.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.News findByPrimaryKey(long pk)
        throws com.liferay.portal.kernel.exception.SystemException,
            it.sincon.sanita.services.NoSuchNewsException {
        return getPersistence().findByPrimaryKey(pk);
    }

    /**
    * Returns the news with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param pk the primary key of the news
    * @return the news, or <code>null</code> if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static it.sincon.sanita.services.model.News fetchByPrimaryKey(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(pk);
    }

    /**
    * Returns all the newses.
    *
    * @return the newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.News> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the newses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @return the range of newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.News> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the newses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.sincon.sanita.services.model.impl.NewsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<it.sincon.sanita.services.model.News> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the newses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of newses.
    *
    * @return the number of newses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static NewsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (NewsPersistence) PortletBeanLocatorUtil.locate(it.sincon.sanita.services.service.ClpSerializer.getServletContextName(),
                    NewsPersistence.class.getName());

            ReferenceRegistry.registerReference(NewsUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(NewsPersistence persistence) {
    }
}
