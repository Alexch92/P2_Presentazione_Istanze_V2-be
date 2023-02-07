/**
 * RispostaRicercaProtocollo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class RispostaRicercaProtocollo  implements java.io.Serializable {
    private int numeroElementiTrovati;

    private it.sincon.gepred.protocollo.scatel.bean.MatchingProtocollo[] matchingProtocollo;

    public RispostaRicercaProtocollo() {
    }

    public RispostaRicercaProtocollo(
           int numeroElementiTrovati,
           it.sincon.gepred.protocollo.scatel.bean.MatchingProtocollo[] matchingProtocollo) {
           this.numeroElementiTrovati = numeroElementiTrovati;
           this.matchingProtocollo = matchingProtocollo;
    }


    /**
     * Gets the numeroElementiTrovati value for this RispostaRicercaProtocollo.
     * 
     * @return numeroElementiTrovati
     */
    public int getNumeroElementiTrovati() {
        return numeroElementiTrovati;
    }


    /**
     * Sets the numeroElementiTrovati value for this RispostaRicercaProtocollo.
     * 
     * @param numeroElementiTrovati
     */
    public void setNumeroElementiTrovati(int numeroElementiTrovati) {
        this.numeroElementiTrovati = numeroElementiTrovati;
    }


    /**
     * Gets the matchingProtocollo value for this RispostaRicercaProtocollo.
     * 
     * @return matchingProtocollo
     */
    public it.sincon.gepred.protocollo.scatel.bean.MatchingProtocollo[] getMatchingProtocollo() {
        return matchingProtocollo;
    }


    /**
     * Sets the matchingProtocollo value for this RispostaRicercaProtocollo.
     * 
     * @param matchingProtocollo
     */
    public void setMatchingProtocollo(it.sincon.gepred.protocollo.scatel.bean.MatchingProtocollo[] matchingProtocollo) {
        this.matchingProtocollo = matchingProtocollo;
    }

    public it.sincon.gepred.protocollo.scatel.bean.MatchingProtocollo getMatchingProtocollo(int i) {
        return this.matchingProtocollo[i];
    }

    public void setMatchingProtocollo(int i, it.sincon.gepred.protocollo.scatel.bean.MatchingProtocollo _value) {
        this.matchingProtocollo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaRicercaProtocollo)) return false;
        RispostaRicercaProtocollo other = (RispostaRicercaProtocollo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.numeroElementiTrovati == other.getNumeroElementiTrovati() &&
            ((this.matchingProtocollo==null && other.getMatchingProtocollo()==null) || 
             (this.matchingProtocollo!=null &&
              java.util.Arrays.equals(this.matchingProtocollo, other.getMatchingProtocollo())));
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
        if (getMatchingProtocollo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMatchingProtocollo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMatchingProtocollo(), i);
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
        new org.apache.axis.description.TypeDesc(RispostaRicercaProtocollo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaProtocollo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroElementiTrovati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroElementiTrovati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchingProtocollo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "MatchingProtocollo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "MatchingProtocollo"));
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
