/**
 * ParametriEseguiProtocollo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class ParametriEseguiProtocollo  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.CredenzialiUtente credenzialiUtente;

    private it.sincon.gepred.protocollo.scatel.bean.Segnatura segnatura;

    public ParametriEseguiProtocollo() {
    }

    public ParametriEseguiProtocollo(
           it.sincon.gepred.protocollo.scatel.bean.CredenzialiUtente credenzialiUtente,
           it.sincon.gepred.protocollo.scatel.bean.Segnatura segnatura) {
           this.credenzialiUtente = credenzialiUtente;
           this.segnatura = segnatura;
    }


    /**
     * Gets the credenzialiUtente value for this ParametriEseguiProtocollo.
     * 
     * @return credenzialiUtente
     */
    public it.sincon.gepred.protocollo.scatel.bean.CredenzialiUtente getCredenzialiUtente() {
        return credenzialiUtente;
    }


    /**
     * Sets the credenzialiUtente value for this ParametriEseguiProtocollo.
     * 
     * @param credenzialiUtente
     */
    public void setCredenzialiUtente(it.sincon.gepred.protocollo.scatel.bean.CredenzialiUtente credenzialiUtente) {
        this.credenzialiUtente = credenzialiUtente;
    }


    /**
     * Gets the segnatura value for this ParametriEseguiProtocollo.
     * 
     * @return segnatura
     */
    public it.sincon.gepred.protocollo.scatel.bean.Segnatura getSegnatura() {
        return segnatura;
    }


    /**
     * Sets the segnatura value for this ParametriEseguiProtocollo.
     * 
     * @param segnatura
     */
    public void setSegnatura(it.sincon.gepred.protocollo.scatel.bean.Segnatura segnatura) {
        this.segnatura = segnatura;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParametriEseguiProtocollo)) return false;
        ParametriEseguiProtocollo other = (ParametriEseguiProtocollo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.credenzialiUtente==null && other.getCredenzialiUtente()==null) || 
             (this.credenzialiUtente!=null &&
              this.credenzialiUtente.equals(other.getCredenzialiUtente()))) &&
            ((this.segnatura==null && other.getSegnatura()==null) || 
             (this.segnatura!=null &&
              this.segnatura.equals(other.getSegnatura())));
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
        if (getCredenzialiUtente() != null) {
            _hashCode += getCredenzialiUtente().hashCode();
        }
        if (getSegnatura() != null) {
            _hashCode += getSegnatura().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParametriEseguiProtocollo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriEseguiProtocollo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credenzialiUtente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CredenzialiUtente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">CredenzialiUtente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segnatura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Segnatura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Segnatura"));
        elemField.setNillable(false);
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
