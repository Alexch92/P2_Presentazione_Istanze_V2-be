package it.sincon.gepred.web.portlet.utils;

import java.util.List;

import flexjson.JSONSerializer;

/**
 * Classe che raccoglie i dati per la renderizzazione del grafico a barre
 * @author Santomauro
 *
 */
public class BarChartData {

	private String[] labels;
	private BarChartDataSet[] datasets;
	
	public String[] getLabels() {
		return labels;
	}
	
	public BarChartDataSet[] getDatasets() {
		return datasets;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	public void setDatasets(BarChartDataSet[] datasets) {
		this.datasets = datasets;
	}
	public void setDatasets(List<BarChartDataSet> datasets) {
		this.datasets = datasets.toArray(new BarChartDataSet[0]);
	}

	public String toJson(){
		JSONSerializer serializer = new JSONSerializer();
		StringBuilder builder = new StringBuilder();
		String result;

		serializer.exclude("*.class")
		          .exclude("*.parent")
		          .exclude("*.new")
				  .deepSerialize(this, builder);
		
		result = builder.toString();
		return result;
	}
}

