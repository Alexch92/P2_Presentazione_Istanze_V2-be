package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.sincon.sanita.services.model.News;
import it.sincon.sanita.services.service.NewsLocalServiceUtil;

/**
 * @author Sincon
 * @generated
 */
public abstract class NewsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public NewsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(NewsLocalServiceUtil.getService());
        setClass(News.class);

        setClassLoader(it.sincon.sanita.services.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("pk");
    }
}
