package it.sincon.sanita.services.service.persistence;

public interface StrutturaSanitariaFinder {
    public long getSearchCount(
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<it.sincon.sanita.services.model.StrutturaSanitaria> search(
        int start, int numRes,
        java.util.List<java.lang.String> listaIdTipoStrutture,
        java.util.List<java.lang.String> listaIdStrutture,
        java.lang.String fullText, java.lang.Double mobile_latitude,
        java.lang.Double mobile_longitude, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;
}
