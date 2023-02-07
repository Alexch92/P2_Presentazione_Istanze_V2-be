package it.sincon.sanita.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StrutturaSanitariaFigliaService}.
 *
 * @author Sincon
 * @see StrutturaSanitariaFigliaService
 * @generated
 */
public class StrutturaSanitariaFigliaServiceWrapper
    implements StrutturaSanitariaFigliaService,
        ServiceWrapper<StrutturaSanitariaFigliaService> {
    private StrutturaSanitariaFigliaService _strutturaSanitariaFigliaService;

    public StrutturaSanitariaFigliaServiceWrapper(
        StrutturaSanitariaFigliaService strutturaSanitariaFigliaService) {
        _strutturaSanitariaFigliaService = strutturaSanitariaFigliaService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _strutturaSanitariaFigliaService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _strutturaSanitariaFigliaService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _strutturaSanitariaFigliaService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public StrutturaSanitariaFigliaService getWrappedStrutturaSanitariaFigliaService() {
        return _strutturaSanitariaFigliaService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedStrutturaSanitariaFigliaService(
        StrutturaSanitariaFigliaService strutturaSanitariaFigliaService) {
        _strutturaSanitariaFigliaService = strutturaSanitariaFigliaService;
    }

    @Override
    public StrutturaSanitariaFigliaService getWrappedService() {
        return _strutturaSanitariaFigliaService;
    }

    @Override
    public void setWrappedService(
        StrutturaSanitariaFigliaService strutturaSanitariaFigliaService) {
        _strutturaSanitariaFigliaService = strutturaSanitariaFigliaService;
    }
}
