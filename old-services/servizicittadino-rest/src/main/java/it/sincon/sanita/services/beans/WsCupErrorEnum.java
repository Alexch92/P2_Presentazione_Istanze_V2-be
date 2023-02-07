package it.sincon.sanita.services.beans;

public enum WsCupErrorEnum {
	
	OK("OK"),
	GENERIC_ERROR("KO");
	
	private String value;

    private WsCupErrorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static WsCupErrorEnum fromString(String text) {
    	if (text != null && !text.equals("")) {
    		for (WsCupErrorEnum unit : WsCupErrorEnum.values()) {
    			if (text.equalsIgnoreCase(String.valueOf(unit.getValue()))) {
    				return unit;
    			}
    		}
    	}
    	return null;
    }

    public static String[] getAllValues(){
    	String[] retValue = new String[2];
    	
    	retValue[0] = WsCupErrorEnum.OK.getValue();
    	retValue[1] = WsCupErrorEnum.GENERIC_ERROR.getValue();
    	
    	return retValue;
    }

    @Override
    public String toString() {
        return value;
    }

}
