package it.sincon.sanita.utils;

public enum DistanceUnitEnum {
	
	MILES("M"),
	NAUTICAL_MILES("N"),
	KILOMETERS("K");
	
	private String value;

    private DistanceUnitEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static DistanceUnitEnum fromString(String text) {
    	if (text != null && !text.equals("")) {
    		for (DistanceUnitEnum unit : DistanceUnitEnum.values()) {
    			if (text.equalsIgnoreCase(String.valueOf(unit.getValue()))) {
    				return unit;
    			}
    		}
    	}
    	return null;
    }

    public static String[] getAllValues(){
    	String[] retValue = new String[2];
    	
    	retValue[0] = DistanceUnitEnum.MILES.getValue();
    	retValue[1] = DistanceUnitEnum.NAUTICAL_MILES.getValue();
    	retValue[2] = DistanceUnitEnum.KILOMETERS.getValue();
    	
    	return retValue;
    }

    @Override
    public String toString() {
        return value;
    }

}
