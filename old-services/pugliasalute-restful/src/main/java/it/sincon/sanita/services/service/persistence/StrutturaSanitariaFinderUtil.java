package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class StrutturaSanitariaFinderUtil {
    private static StrutturaSanitariaFinder _finder;

    public static long getSearchCount(
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getSearchCount(listaIdTipoStrutture, listaIdStrutture,
            fullText, locale);
    }

    public static java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> search(
        int start, int numRes,
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.Double mobile_latitude,
        java.lang.Double mobile_longitude, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .search(start, numRes, listaIdTipoStrutture,
            listaIdStrutture, fullText, mobile_latitude, mobile_longitude,
            locale);
    }

    public static StrutturaSanitariaFinder getFinder() {
        if (_finder == null) {
            _finder = (StrutturaSanitariaFinder) PortletBeanLocatorUtil.locate(it.sincon.sanita.services.service.ClpSerializer.getServletContextName(),
                    StrutturaSanitariaFinder.class.getName());

            ReferenceRegistry.registerReference(StrutturaSanitariaFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(StrutturaSanitariaFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(StrutturaSanitariaFinderUtil.class,
            "_finder");
    }
}
