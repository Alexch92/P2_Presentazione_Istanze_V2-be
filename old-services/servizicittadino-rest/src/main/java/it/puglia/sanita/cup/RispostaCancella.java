/**
 * RispostaCancella.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RispostaCancella  implements java.io.Serializable {
    private it.puglia.sanita.cup.Appuntamento appuntamento;

    private it.puglia.sanita.cup.Errore errore;

    public RispostaCancella() {
    }

    public RispostaCancella(
           it.puglia.sanita.cup.Appuntamento appuntamento,
           it.puglia.sanita.cup.Errore errore) {
           this.appuntamento = appuntamento;
           this.errore = errore;
    }


    /**
     * Gets the appuntamento value for this RispostaCancella.
     * 
     * @return appuntamento
     */
    public it.puglia.sanita.cup.Appuntamento getAppuntamento() {
        return appuntamento;
    }


    /**
     * Sets the appuntamento value for this RispostaCancella.
     * 
     * @param appuntamento
     */
    public void setAppuntamento(it.puglia.sanita.cup.Appuntamento appuntamento) {
        this.appuntamento = appuntamento;
    }


    /**
     * Gets the errore value for this RispostaCancella.
     * 
     * @return errore
     */
    public it.puglia.sanita.cup.Errore getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this RispostaCancella.
     * 
     * @param errore
     */
    public void setErrore(it.puglia.sanita.cup.Errore errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaCancella)) return false;
        RispostaCancella other = (RispostaCancella) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.appuntamento==null && other.getAppuntamento()==null) || 
             (this.appuntamento!=null &&
              this.appuntamento.equals(other.getAppuntamento()))) &&
            ((this.errore==null && other.getErrore()==null) || 
             (this.errore!=null &&
              this.errore.equals(other.getErrore())));
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
        if (getAppuntamento() != null) {
            _hashCode += getAppuntamento().hashCode();
        }
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RispostaCancella.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaCancella"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appuntamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "appuntamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "errore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Errore"));
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
