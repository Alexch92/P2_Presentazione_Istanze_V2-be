package it.osapulie.infrastructure.impl;

import static it.osapulie.infrastructure.impl.StreamUtils.closeStream;
import it.osapulie.infrastructure.ReportService;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("exportPDFManager")
public class ReportServiceImpl implements ReportService {

	private static Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.linksmt.osapulie.infrastructure.ReportService#jrxmlToPdf(java.util.Map,
	 * java.util.Collection, java.lang.String, java.util.Map)
	 */
	@Override
	public byte[] jrxmlToPdf(Map<String, Object> parametersMap, Collection<?> beans, String mainReportJrxmlPath, Map<String, String> subreportJrxmlMap) {
		JRDataSource dataSource = wrapCollection(beans);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			String mainReportPath = ReportServiceImpl.class.getResource(mainReportJrxmlPath).getPath().replaceAll("%20", " ");
			JasperReport jasperReport = JasperCompileManager.compileReport(mainReportPath);

			if (subreportJrxmlMap != null && !subreportJrxmlMap.isEmpty()) {
				for (Map.Entry<String, String> entry : subreportJrxmlMap.entrySet()) {
					JasperReport report = JasperCompileManager.compileReport(ReportServiceImpl.class.getResource(entry.getValue()).getPath());
					parametersMap.put(entry.getKey(), report);
				}
			}

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametersMap, dataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			return out.toByteArray();
		}
		catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		finally {
			closeStream(out);
		}
		return null;
	}

	private static JRBeanCollectionDataSource wrapCollection(Collection<?> beans) {
		return new JRBeanCollectionDataSource(beans);
	}

	@Override
	public byte[] jasperToPdf(Map<String, Object> parametersMap, Collection<?> beans, String mainReportJasperPath,
			Map<String, String> subreportJasperMap) {
		JRDataSource dataSource = wrapCollection(beans);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			String mainReportPath = ReportServiceImpl.class.getResource(mainReportJasperPath).getPath().replaceAll("%20", " ");
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(new FileInputStream(mainReportPath));

			if (subreportJasperMap != null && !subreportJasperMap.isEmpty()) {
				for (Map.Entry<String, String> entry : subreportJasperMap.entrySet()) {
					JasperReport report = (JasperReport)JRLoader.loadObject(new FileInputStream(ReportServiceImpl.class.getResource(entry.getValue()).getPath()));
					parametersMap.put(entry.getKey(), report);
				}
			}

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametersMap, dataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			return out.toByteArray();
		}
		catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		finally {
			closeStream(out);
		}
		return null;
	}
}
