/**
 * Allegati.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Allegati  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Documento documento;

    private it.sincon.gepred.protocollo.scatel.bean.Fascicolo fascicolo;

    public Allegati() {
    }

    public Allegati(
           it.sincon.gepred.protocollo.scatel.bean.Documento documento,
           it.sincon.gepred.protocollo.scatel.bean.Fascicolo fascicolo) {
           this.documento = documento;
           this.fascicolo = fascicolo;
    }


    /**
     * Gets the documento value for this Allegati.
     * 
     * @return documento
     */
    public it.sincon.gepred.protocollo.scatel.bean.Documento getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this Allegati.
     * 
     * @param documento
     */
    public void setDocumento(it.sincon.gepred.protocollo.scatel.bean.Documento documento) {
        this.documento = documento;
    }


    /**
     * Gets the fascicolo value for this Allegati.
     * 
     * @return fascicolo
     */
    public it.sincon.gepred.protocollo.scatel.bean.Fascicolo getFascicolo() {
        return fascicolo;
    }


    /**
     * Sets the fascicolo value for this Allegati.
     * 
     * @param fascicolo
     */
    public void setFascicolo(it.sincon.gepred.protocollo.scatel.bean.Fascicolo fascicolo) {
        this.fascicolo = fascicolo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Allegati)) return false;
        Allegati other = (Allegati) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              this.documento.equals(other.getDocumento()))) &&
            ((this.fascicolo==null && other.getFascicolo()==null) || 
             (this.fascicolo!=null &&
              this.fascicolo.equals(other.getFascicolo())));
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
        if (getDocumento() != null) {
            _hashCode += getDocumento().hashCode();
        }
        if (getFascicolo() != null) {
            _hashCode += getFascicolo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Allegati.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Allegati"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Documento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fascicolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Fascicolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Fascicolo"));
        elemField.setMinOccurs(0);
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
