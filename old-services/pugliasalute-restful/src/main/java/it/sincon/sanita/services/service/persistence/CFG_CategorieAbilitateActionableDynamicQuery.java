package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import it.sincon.sanita.services.model.CFG_CategorieAbilitate;
import it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil;

/**
 * @author Sincon
 * @generated
 */
public abstract class CFG_CategorieAbilitateActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CFG_CategorieAbilitateActionableDynamicQuery()
        throws SystemException {
        setBaseLocalService(CFG_CategorieAbilitateLocalServiceUtil.getService());
        setClass(CFG_CategorieAbilitate.class);

        setClassLoader(it.sincon.sanita.services.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("structureKey");
    }
}
