package it.sincon.sanita.services.beans;

public enum WsCupStatoAppuntamentoEnum {
	
	PRENOTATO("PRENOTATO"),
	CANCELLATO("CANCELLATO");
	
	private String value;

    private WsCupStatoAppuntamentoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static WsCupStatoAppuntamentoEnum fromString(String text) {
    	if (text != null && !text.equals("")) {
    		for (WsCupStatoAppuntamentoEnum unit : WsCupStatoAppuntamentoEnum.values()) {
    			if (text.equalsIgnoreCase(String.valueOf(unit.getValue()))) {
    				return unit;
    			}
    		}
    	}
    	return null;
    }

    public static String[] getAllValues(){
    	String[] retValue = new String[2];
    	
    	retValue[0] = WsCupStatoAppuntamentoEnum.PRENOTATO.getValue();
    	retValue[1] = WsCupStatoAppuntamentoEnum.CANCELLATO.getValue();
    	
    	return retValue;
    }

    @Override
    public String toString() {
        return value;
    }

}
