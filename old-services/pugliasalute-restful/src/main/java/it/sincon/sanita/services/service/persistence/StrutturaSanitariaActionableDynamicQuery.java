package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.sincon.sanita.services.model.StrutturaSanitaria;
import it.sincon.sanita.services.service.StrutturaSanitariaLocalServiceUtil;

/**
 * @author Sincon
 * @generated
 */
public abstract class StrutturaSanitariaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public StrutturaSanitariaActionableDynamicQuery() throws SystemException {
        setBaseLocalService(StrutturaSanitariaLocalServiceUtil.getService());
        setClass(StrutturaSanitaria.class);

        setClassLoader(it.sincon.sanita.services.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("pk");
    }
}
