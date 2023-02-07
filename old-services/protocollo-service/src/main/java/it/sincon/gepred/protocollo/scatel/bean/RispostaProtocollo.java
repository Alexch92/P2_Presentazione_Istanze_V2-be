/**
 * RispostaProtocollo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class RispostaProtocollo  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Esito esito;

    private it.sincon.gepred.protocollo.scatel.bean.SegnaturaProtocollo segnaturaProtocollo;

    public RispostaProtocollo() {
    }

    public RispostaProtocollo(
           it.sincon.gepred.protocollo.scatel.bean.Esito esito,
           it.sincon.gepred.protocollo.scatel.bean.SegnaturaProtocollo segnaturaProtocollo) {
           this.esito = esito;
           this.segnaturaProtocollo = segnaturaProtocollo;
    }


    /**
     * Gets the esito value for this RispostaProtocollo.
     * 
     * @return esito
     */
    public it.sincon.gepred.protocollo.scatel.bean.Esito getEsito() {
        return esito;
    }


    /**
     * Sets the esito value for this RispostaProtocollo.
     * 
     * @param esito
     */
    public void setEsito(it.sincon.gepred.protocollo.scatel.bean.Esito esito) {
        this.esito = esito;
    }


    /**
     * Gets the segnaturaProtocollo value for this RispostaProtocollo.
     * 
     * @return segnaturaProtocollo
     */
    public it.sincon.gepred.protocollo.scatel.bean.SegnaturaProtocollo getSegnaturaProtocollo() {
        return segnaturaProtocollo;
    }


    /**
     * Sets the segnaturaProtocollo value for this RispostaProtocollo.
     * 
     * @param segnaturaProtocollo
     */
    public void setSegnaturaProtocollo(it.sincon.gepred.protocollo.scatel.bean.SegnaturaProtocollo segnaturaProtocollo) {
        this.segnaturaProtocollo = segnaturaProtocollo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaProtocollo)) return false;
        RispostaProtocollo other = (RispostaProtocollo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.esito==null && other.getEsito()==null) || 
             (this.esito!=null &&
              this.esito.equals(other.getEsito()))) &&
            ((this.segnaturaProtocollo==null && other.getSegnaturaProtocollo()==null) || 
             (this.segnaturaProtocollo!=null &&
              this.segnaturaProtocollo.equals(other.getSegnaturaProtocollo())));
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
        if (getEsito() != null) {
            _hashCode += getEsito().hashCode();
        }
        if (getSegnaturaProtocollo() != null) {
            _hashCode += getSegnaturaProtocollo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RispostaProtocollo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaProtocollo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("esito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Esito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Esito"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segnaturaProtocollo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "SegnaturaProtocollo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">SegnaturaProtocollo"));
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
