package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;
import it.sincon.sanita.services.service.StrutturaSanitariaFigliaLocalServiceUtil;

/**
 * @author Sincon
 * @generated
 */
public abstract class StrutturaSanitariaFigliaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public StrutturaSanitariaFigliaActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(StrutturaSanitariaFigliaLocalServiceUtil.getService());
        setClass(StrutturaSanitariaFiglia.class);

        setClassLoader(it.sincon.sanita.services.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("idStrutturaFiglia");
    }
}
