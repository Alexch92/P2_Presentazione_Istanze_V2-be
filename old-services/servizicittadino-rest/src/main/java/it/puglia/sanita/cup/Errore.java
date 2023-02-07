/**
 * Errore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class Errore  implements java.io.Serializable {
    private java.lang.String codiceErrore;

    private java.lang.String messaggioErrore;

    public Errore() {
    }

    public Errore(
           java.lang.String codiceErrore,
           java.lang.String messaggioErrore) {
           this.codiceErrore = codiceErrore;
           this.messaggioErrore = messaggioErrore;
    }


    /**
     * Gets the codiceErrore value for this Errore.
     * 
     * @return codiceErrore
     */
    public java.lang.String getCodiceErrore() {
        return codiceErrore;
    }


    /**
     * Sets the codiceErrore value for this Errore.
     * 
     * @param codiceErrore
     */
    public void setCodiceErrore(java.lang.String codiceErrore) {
        this.codiceErrore = codiceErrore;
    }


    /**
     * Gets the messaggioErrore value for this Errore.
     * 
     * @return messaggioErrore
     */
    public java.lang.String getMessaggioErrore() {
        return messaggioErrore;
    }


    /**
     * Sets the messaggioErrore value for this Errore.
     * 
     * @param messaggioErrore
     */
    public void setMessaggioErrore(java.lang.String messaggioErrore) {
        this.messaggioErrore = messaggioErrore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Errore)) return false;
        Errore other = (Errore) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceErrore==null && other.getCodiceErrore()==null) || 
             (this.codiceErrore!=null &&
              this.codiceErrore.equals(other.getCodiceErrore()))) &&
            ((this.messaggioErrore==null && other.getMessaggioErrore()==null) || 
             (this.messaggioErrore!=null &&
              this.messaggioErrore.equals(other.getMessaggioErrore())));
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
        if (getCodiceErrore() != null) {
            _hashCode += getCodiceErrore().hashCode();
        }
        if (getMessaggioErrore() != null) {
            _hashCode += getMessaggioErrore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Errore.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Errore"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceErrore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "codiceErrore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messaggioErrore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "messaggioErrore"));
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
