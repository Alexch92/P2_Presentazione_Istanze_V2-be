package it.osapulie.infrastructure;

import java.util.Collection;
import java.util.Map;

public interface ReportService {
	/**
	 * 
	 * @param parametersMap
	 * @param dataSource
	 * @param mainReportJrxmlPath
	 * @param subreportJrxmlMap
	 * @return
	 */
	byte[] jrxmlToPdf( Map<String, Object> parametersMap, Collection<?> beans, String mainReportJrxmlPath, Map<String, String> subreportJrxmlMap );
	
	/**
	 * 
	 * @param parametersMap
	 * @param beans
	 * @param mainReportJasperPath
	 * @param subreportJasperMap
	 * @return
	 */
	byte[] jasperToPdf( Map<String, Object> parametersMap, Collection<?> beans, String mainReportJasperPath, Map<String, String> subreportJasperMap );
}