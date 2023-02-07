package it.sincon.sanita.services.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for StrutturaSanitariaFiglia. This utility wraps
 * {@link it.sincon.sanita.services.service.impl.StrutturaSanitariaFigliaServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Sincon
 * @see StrutturaSanitariaFigliaService
 * @see it.sincon.sanita.services.service.base.StrutturaSanitariaFigliaServiceBaseImpl
 * @see it.sincon.sanita.services.service.impl.StrutturaSanitariaFigliaServiceImpl
 * @generated
 */
public class StrutturaSanitariaFigliaServiceUtil {
    private static StrutturaSanitariaFigliaService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link it.sincon.sanita.services.service.impl.StrutturaSanitariaFigliaServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static StrutturaSanitariaFigliaService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    StrutturaSanitariaFigliaService.class.getName());

            if (invokableService instanceof StrutturaSanitariaFigliaService) {
                _service = (StrutturaSanitariaFigliaService) invokableService;
            } else {
                _service = new StrutturaSanitariaFigliaServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(StrutturaSanitariaFigliaServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(StrutturaSanitariaFigliaService service) {
    }
}
