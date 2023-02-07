package it.sincon.gepred.web.portlet.utils;

import it.osapulie.domain.ProfiloUtente;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BarChartUtils {
	private static Logger log = LoggerFactory.getLogger( BarChartUtils.class );
	
	
	public static String createBarChartDataJson (
			Map<String, Map<Integer, Double>> mapDataSets, 
			String[] labels) {
		try{
			BarChartData barChartData = new BarChartData();

			// Inizializzo le strutture richieste dal Bar Chart...
			// Inizializzo l'array delle labels con i mesi della ricerca...
			barChartData.setLabels(labels);

			// Inizializzo la lista dei DataSet....
			List<BarChartDataSet> dataSets = new ArrayList<BarChartDataSet>();

			Random rand = new Random();
			for (Entry<String, Map<Integer, Double>> entryMapDS : mapDataSets.entrySet() ){
				// Recupero ed ordino la lista valori di questa Stazione...
				TreeMap<Integer, Double> mapValori = new TreeMap<Integer, Double>(entryMapDS.getValue());
				List<Double> listValori = new ArrayList<Double>();
				for (Entry<Integer, Double> entryMapValori : mapValori.entrySet()){
					listValori.add(entryMapValori.getValue());
				}

				// recupero il colore assoziato alla postazione
				float r = rand.nextFloat();
				float g = rand.nextFloat();
				float b = rand.nextFloat();
				Color randomColor = new Color(r, g, b);

				BarChartDataSet dataSet = new BarChartDataSet(entryMapDS.getKey(), randomColor, listValori);
				dataSets.add(dataSet);
			}
			barChartData.setDatasets(dataSets);

			String retValue = barChartData.toJson();
			log.debug(String.format("Json per il Bar Chart : %s.", retValue));

			return retValue;
		} catch (Exception ex){
			log.error(ex.getMessage(), ex);
			return null;
		}
	}

}
