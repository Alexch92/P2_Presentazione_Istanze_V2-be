package it.sincon.sanita.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NewsService}.
 *
 * @author Sincon
 * @see NewsService
 * @generated
 */
public class NewsServiceWrapper implements NewsService,
    ServiceWrapper<NewsService> {
    private NewsService _newsService;

    public NewsServiceWrapper(NewsService newsService) {
        _newsService = newsService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _newsService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _newsService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _newsService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public NewsService getWrappedNewsService() {
        return _newsService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedNewsService(NewsService newsService) {
        _newsService = newsService;
    }

    @Override
    public NewsService getWrappedService() {
        return _newsService;
    }

    @Override
    public void setWrappedService(NewsService newsService) {
        _newsService = newsService;
    }
}
