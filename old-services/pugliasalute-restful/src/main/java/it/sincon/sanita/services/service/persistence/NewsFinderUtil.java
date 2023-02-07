package it.sincon.sanita.services.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class NewsFinderUtil {
    private static NewsFinder _finder;

    public static long getSearchCount(
        java.util.List<java.lang.String> listaAziende,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getSearchCount(listaAziende, fullText, locale);
    }

    public static java.util.List<it.sincon.sanita.services.model.News> search(
        int start, int numRes, java.util.List<java.lang.String> listaIdAziende,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .search(start, numRes, listaIdAziende, fullText, locale);
    }

    public static NewsFinder getFinder() {
        if (_finder == null) {
            _finder = (NewsFinder) PortletBeanLocatorUtil.locate(it.sincon.sanita.services.service.ClpSerializer.getServletContextName(),
                    NewsFinder.class.getName());

            ReferenceRegistry.registerReference(NewsFinderUtil.class, "_finder");
        }

        return _finder;
    }

    public void setFinder(NewsFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(NewsFinderUtil.class, "_finder");
    }
}
