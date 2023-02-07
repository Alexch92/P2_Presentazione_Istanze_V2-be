package it.sincon.gepred.web.portlet.utils;

import java.awt.Color;
import java.util.List;

public class BarChartDataSet {
	
	private final String FILL_COLOR_FORMAT = "rgba(%s,%s,%s,0.5)";
	private final String STROKE_COLOR_FORMAT = "rgba(%s,%s,%s,0.8)";
	private final String HIGHLIGHT_FILL_FORMAT = "rgba(%s,%s,%s,0.75)";
	private final String HIGHLIGHT_STROKE_FORMAT = "rgba(%s,%s,%s,0.1)";
	
	private String label;
	private String fillColor;
	private String strokeColor;
	private String highlightFill;
	private String highlightStroke;
	private List<Double> data;
	
	public BarChartDataSet(String _label, Color _color, List<Double> _data){
		// Imposto la label
		this.label = _label;
		// Imposto i colori
		this.fillColor = String.format(FILL_COLOR_FORMAT, _color.getRed(), _color.getGreen(), _color.getBlue());
		this.strokeColor = String.format(STROKE_COLOR_FORMAT, _color.getRed(), _color.getGreen(), _color.getBlue());
		this.highlightFill = String.format(HIGHLIGHT_FILL_FORMAT, _color.getRed(), _color.getGreen(), _color.getBlue());
		this.highlightStroke = String.format(HIGHLIGHT_STROKE_FORMAT, _color.getRed(), _color.getGreen(), _color.getBlue());
		//Imposto i dati
		this.data = _data;
	}

	public String getLabel() {
		return label;
	}
	public String getFillColor() {
		return fillColor;
	}
	public String getStrokeColor() {
		return strokeColor;
	}
	public String getHighlightFill() {
		return highlightFill;
	}
	public String getHighlightStroke() {
		return highlightStroke;
	}

	public List<Double> getData() {
		return data;
	}
	
}
