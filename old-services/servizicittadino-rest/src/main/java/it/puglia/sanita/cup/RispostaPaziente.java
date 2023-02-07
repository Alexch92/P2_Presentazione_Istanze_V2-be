/**
 * RispostaPaziente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RispostaPaziente  implements java.io.Serializable {
    private it.puglia.sanita.cup.Paziente paziente;

    private it.puglia.sanita.cup.Errore errore;

    public RispostaPaziente() {
    }

    public RispostaPaziente(
           it.puglia.sanita.cup.Paziente paziente,
           it.puglia.sanita.cup.Errore errore) {
           this.paziente = paziente;
           this.errore = errore;
    }


    /**
     * Gets the paziente value for this RispostaPaziente.
     * 
     * @return paziente
     */
    public it.puglia.sanita.cup.Paziente getPaziente() {
        return paziente;
    }


    /**
     * Sets the paziente value for this RispostaPaziente.
     * 
     * @param paziente
     */
    public void setPaziente(it.puglia.sanita.cup.Paziente paziente) {
        this.paziente = paziente;
    }


    /**
     * Gets the errore value for this RispostaPaziente.
     * 
     * @return errore
     */
    public it.puglia.sanita.cup.Errore getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this RispostaPaziente.
     * 
     * @param errore
     */
    public void setErrore(it.puglia.sanita.cup.Errore errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaPaziente)) return false;
        RispostaPaziente other = (RispostaPaziente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.paziente==null && other.getPaziente()==null) || 
             (this.paziente!=null &&
              this.paziente.equals(other.getPaziente()))) &&
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
        if (getPaziente() != null) {
            _hashCode += getPaziente().hashCode();
        }
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RispostaPaziente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPaziente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paziente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "paziente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Paziente"));
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
