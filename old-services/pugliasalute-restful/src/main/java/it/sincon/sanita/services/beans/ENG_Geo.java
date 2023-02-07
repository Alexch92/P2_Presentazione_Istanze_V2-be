package it.sincon.sanita.services.beans;

public class ENG_Geo {              
	
	private String coordinates;
	private String indirizzo;
	private String ol;
	
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getOl() {
		return ol;
	}
	public void setOl(String ol) {
		this.ol = ol;
	}
	
	public double getGeoLatitude() throws NumberFormatException { 
		String strLat = coordinates.replace("POINT (", "").replace(")", "").split(" ")[1];
		return Double.parseDouble(strLat);
	}
	
	public double getGeoLongitude() throws NumberFormatException { 
		String strLong = coordinates.replace("POINT (", "").replace(")", "").split(" ")[0];
		return Double.parseDouble(strLong);
	}

}
