/**
 * Unita.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class Unita  implements java.io.Serializable {
    private java.lang.String idUnita;

    private java.lang.String descUnita;

    private java.lang.String nomeUnita;

    private java.lang.String indirizzoUnita;

    public Unita() {
    }

    public Unita(
           java.lang.String idUnita,
           java.lang.String descUnita,
           java.lang.String nomeUnita,
           java.lang.String indirizzoUnita) {
           this.idUnita = idUnita;
           this.descUnita = descUnita;
           this.nomeUnita = nomeUnita;
           this.indirizzoUnita = indirizzoUnita;
    }


    /**
     * Gets the idUnita value for this Unita.
     * 
     * @return idUnita
     */
    public java.lang.String getIdUnita() {
        return idUnita;
    }


    /**
     * Sets the idUnita value for this Unita.
     * 
     * @param idUnita
     */
    public void setIdUnita(java.lang.String idUnita) {
        this.idUnita = idUnita;
    }


    /**
     * Gets the descUnita value for this Unita.
     * 
     * @return descUnita
     */
    public java.lang.String getDescUnita() {
        return descUnita;
    }


    /**
     * Sets the descUnita value for this Unita.
     * 
     * @param descUnita
     */
    public void setDescUnita(java.lang.String descUnita) {
        this.descUnita = descUnita;
    }


    /**
     * Gets the nomeUnita value for this Unita.
     * 
     * @return nomeUnita
     */
    public java.lang.String getNomeUnita() {
        return nomeUnita;
    }


    /**
     * Sets the nomeUnita value for this Unita.
     * 
     * @param nomeUnita
     */
    public void setNomeUnita(java.lang.String nomeUnita) {
        this.nomeUnita = nomeUnita;
    }


    /**
     * Gets the indirizzoUnita value for this Unita.
     * 
     * @return indirizzoUnita
     */
    public java.lang.String getIndirizzoUnita() {
        return indirizzoUnita;
    }


    /**
     * Sets the indirizzoUnita value for this Unita.
     * 
     * @param indirizzoUnita
     */
    public void setIndirizzoUnita(java.lang.String indirizzoUnita) {
        this.indirizzoUnita = indirizzoUnita;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Unita)) return false;
        Unita other = (Unita) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idUnita==null && other.getIdUnita()==null) || 
             (this.idUnita!=null &&
              this.idUnita.equals(other.getIdUnita()))) &&
            ((this.descUnita==null && other.getDescUnita()==null) || 
             (this.descUnita!=null &&
              this.descUnita.equals(other.getDescUnita()))) &&
            ((this.nomeUnita==null && other.getNomeUnita()==null) || 
             (this.nomeUnita!=null &&
              this.nomeUnita.equals(other.getNomeUnita()))) &&
            ((this.indirizzoUnita==null && other.getIndirizzoUnita()==null) || 
             (this.indirizzoUnita!=null &&
              this.indirizzoUnita.equals(other.getIndirizzoUnita())));
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
        if (getIdUnita() != null) {
            _hashCode += getIdUnita().hashCode();
        }
        if (getDescUnita() != null) {
            _hashCode += getDescUnita().hashCode();
        }
        if (getNomeUnita() != null) {
            _hashCode += getNomeUnita().hashCode();
        }
        if (getIndirizzoUnita() != null) {
            _hashCode += getIndirizzoUnita().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Unita.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Unita"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUnita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idUnita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descUnita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "descUnita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeUnita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "nomeUnita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoUnita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "indirizzoUnita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
