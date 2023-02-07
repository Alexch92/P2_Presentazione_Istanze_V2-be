/**
 * ProtocolloEmergenza.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class ProtocolloEmergenza  implements java.io.Serializable {
    private java.lang.String numeroProtEmergenza;

    private java.lang.String dataProtEmergenza;

    public ProtocolloEmergenza() {
    }

    public ProtocolloEmergenza(
           java.lang.String numeroProtEmergenza,
           java.lang.String dataProtEmergenza) {
           this.numeroProtEmergenza = numeroProtEmergenza;
           this.dataProtEmergenza = dataProtEmergenza;
    }


    /**
     * Gets the numeroProtEmergenza value for this ProtocolloEmergenza.
     * 
     * @return numeroProtEmergenza
     */
    public java.lang.String getNumeroProtEmergenza() {
        return numeroProtEmergenza;
    }


    /**
     * Sets the numeroProtEmergenza value for this ProtocolloEmergenza.
     * 
     * @param numeroProtEmergenza
     */
    public void setNumeroProtEmergenza(java.lang.String numeroProtEmergenza) {
        this.numeroProtEmergenza = numeroProtEmergenza;
    }


    /**
     * Gets the dataProtEmergenza value for this ProtocolloEmergenza.
     * 
     * @return dataProtEmergenza
     */
    public java.lang.String getDataProtEmergenza() {
        return dataProtEmergenza;
    }


    /**
     * Sets the dataProtEmergenza value for this ProtocolloEmergenza.
     * 
     * @param dataProtEmergenza
     */
    public void setDataProtEmergenza(java.lang.String dataProtEmergenza) {
        this.dataProtEmergenza = dataProtEmergenza;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProtocolloEmergenza)) return false;
        ProtocolloEmergenza other = (ProtocolloEmergenza) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroProtEmergenza==null && other.getNumeroProtEmergenza()==null) || 
             (this.numeroProtEmergenza!=null &&
              this.numeroProtEmergenza.equals(other.getNumeroProtEmergenza()))) &&
            ((this.dataProtEmergenza==null && other.getDataProtEmergenza()==null) || 
             (this.dataProtEmergenza!=null &&
              this.dataProtEmergenza.equals(other.getDataProtEmergenza())));
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
        if (getNumeroProtEmergenza() != null) {
            _hashCode += getNumeroProtEmergenza().hashCode();
        }
        if (getDataProtEmergenza() != null) {
            _hashCode += getDataProtEmergenza().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProtocolloEmergenza.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ProtocolloEmergenza"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroProtEmergenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroProtEmergenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataProtEmergenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DataProtEmergenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
