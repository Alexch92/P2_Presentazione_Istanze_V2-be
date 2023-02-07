/**
 * RispostaRicercaAssegnazioniInoltriProtocollo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class RispostaRicercaAssegnazioniInoltriProtocollo  implements java.io.Serializable {
    private int numeroElementiTrovati;

    private it.sincon.gepred.protocollo.scatel.bean.MatchingAssegnazioniInoltri[] matchingAssegnazioniInoltri;

    public RispostaRicercaAssegnazioniInoltriProtocollo() {
    }

    public RispostaRicercaAssegnazioniInoltriProtocollo(
           int numeroElementiTrovati,
           it.sincon.gepred.protocollo.scatel.bean.MatchingAssegnazioniInoltri[] matchingAssegnazioniInoltri) {
           this.numeroElementiTrovati = numeroElementiTrovati;
           this.matchingAssegnazioniInoltri = matchingAssegnazioniInoltri;
    }


    /**
     * Gets the numeroElementiTrovati value for this RispostaRicercaAssegnazioniInoltriProtocollo.
     * 
     * @return numeroElementiTrovati
     */
    public int getNumeroElementiTrovati() {
        return numeroElementiTrovati;
    }


    /**
     * Sets the numeroElementiTrovati value for this RispostaRicercaAssegnazioniInoltriProtocollo.
     * 
     * @param numeroElementiTrovati
     */
    public void setNumeroElementiTrovati(int numeroElementiTrovati) {
        this.numeroElementiTrovati = numeroElementiTrovati;
    }


    /**
     * Gets the matchingAssegnazioniInoltri value for this RispostaRicercaAssegnazioniInoltriProtocollo.
     * 
     * @return matchingAssegnazioniInoltri
     */
    public it.sincon.gepred.protocollo.scatel.bean.MatchingAssegnazioniInoltri[] getMatchingAssegnazioniInoltri() {
        return matchingAssegnazioniInoltri;
    }


    /**
     * Sets the matchingAssegnazioniInoltri value for this RispostaRicercaAssegnazioniInoltriProtocollo.
     * 
     * @param matchingAssegnazioniInoltri
     */
    public void setMatchingAssegnazioniInoltri(it.sincon.gepred.protocollo.scatel.bean.MatchingAssegnazioniInoltri[] matchingAssegnazioniInoltri) {
        this.matchingAssegnazioniInoltri = matchingAssegnazioniInoltri;
    }

    public it.sincon.gepred.protocollo.scatel.bean.MatchingAssegnazioniInoltri getMatchingAssegnazioniInoltri(int i) {
        return this.matchingAssegnazioniInoltri[i];
    }

    public void setMatchingAssegnazioniInoltri(int i, it.sincon.gepred.protocollo.scatel.bean.MatchingAssegnazioniInoltri _value) {
        this.matchingAssegnazioniInoltri[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaRicercaAssegnazioniInoltriProtocollo)) return false;
        RispostaRicercaAssegnazioniInoltriProtocollo other = (RispostaRicercaAssegnazioniInoltriProtocollo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.numeroElementiTrovati == other.getNumeroElementiTrovati() &&
            ((this.matchingAssegnazioniInoltri==null && other.getMatchingAssegnazioniInoltri()==null) || 
             (this.matchingAssegnazioniInoltri!=null &&
              java.util.Arrays.equals(this.matchingAssegnazioniInoltri, other.getMatchingAssegnazioniInoltri())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getNumeroElementiTrovati();
        if (getMatchingAssegnazioniInoltri() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMatchingAssegnazioniInoltri());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMatchingAssegnazioniInoltri(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RispostaRicercaAssegnazioniInoltriProtocollo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaAssegnazioniInoltriProtocollo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroElementiTrovati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroElementiTrovati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchingAssegnazioniInoltri");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "MatchingAssegnazioniInoltri"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "MatchingAssegnazioniInoltri"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
