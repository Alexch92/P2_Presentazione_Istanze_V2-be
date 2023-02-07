package it.sincon.sanita.services.service.persistence;

public interface NewsFinder {
    public long getSearchCount(java.util.List<java.lang.String> listaAziende,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<it.sincon.sanita.services.model.News> search(
        int start, int numRes, java.util.List<java.lang.String> listaIdAziende,
        java.lang.String fullText, java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;
}
