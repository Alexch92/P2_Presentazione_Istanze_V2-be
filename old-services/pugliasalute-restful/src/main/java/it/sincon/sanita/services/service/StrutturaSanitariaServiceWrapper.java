package it.sincon.sanita.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StrutturaSanitariaService}.
 *
 * @author Sincon
 * @see StrutturaSanitariaService
 * @generated
 */
public class StrutturaSanitariaServiceWrapper
    implements StrutturaSanitariaService,
        ServiceWrapper<StrutturaSanitariaService> {
    private StrutturaSanitariaService _strutturaSanitariaService;

    public StrutturaSanitariaServiceWrapper(
        StrutturaSanitariaService strutturaSanitariaService) {
        _strutturaSanitariaService = strutturaSanitariaService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _strutturaSanitariaService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _strutturaSanitariaService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _strutturaSanitariaService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public StrutturaSanitariaService getWrappedStrutturaSanitariaService() {
        return _strutturaSanitariaService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedStrutturaSanitariaService(
        StrutturaSanitariaService strutturaSanitariaService) {
        _strutturaSanitariaService = strutturaSanitariaService;
    }

    @Override
    public StrutturaSanitariaService getWrappedService() {
        return _strutturaSanitariaService;
    }

    @Override
    public void setWrappedService(
        StrutturaSanitariaService strutturaSanitariaService) {
        _strutturaSanitariaService = strutturaSanitariaService;
    }
}
