package it.sincon.sanita.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CategoriaStrutturaService}.
 *
 * @author Sincon
 * @see CategoriaStrutturaService
 * @generated
 */
public class CategoriaStrutturaServiceWrapper
    implements CategoriaStrutturaService,
        ServiceWrapper<CategoriaStrutturaService> {
    private CategoriaStrutturaService _categoriaStrutturaService;

    public CategoriaStrutturaServiceWrapper(
        CategoriaStrutturaService categoriaStrutturaService) {
        _categoriaStrutturaService = categoriaStrutturaService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _categoriaStrutturaService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _categoriaStrutturaService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _categoriaStrutturaService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CategoriaStrutturaService getWrappedCategoriaStrutturaService() {
        return _categoriaStrutturaService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCategoriaStrutturaService(
        CategoriaStrutturaService categoriaStrutturaService) {
        _categoriaStrutturaService = categoriaStrutturaService;
    }

    @Override
    public CategoriaStrutturaService getWrappedService() {
        return _categoriaStrutturaService;
    }

    @Override
    public void setWrappedService(
        CategoriaStrutturaService categoriaStrutturaService) {
        _categoriaStrutturaService = categoriaStrutturaService;
    }
}
