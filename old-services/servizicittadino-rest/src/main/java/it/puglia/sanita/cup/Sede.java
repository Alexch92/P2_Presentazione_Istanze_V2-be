/**
 * Sede.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class Sede  implements java.io.Serializable {
    private java.lang.String idSede;

    private java.lang.String descSede;

    private java.lang.String indirizzoSede;

    public Sede() {
    }

    public Sede(
           java.lang.String idSede,
           java.lang.String descSede,
           java.lang.String indirizzoSede) {
           this.idSede = idSede;
           this.descSede = descSede;
           this.indirizzoSede = indirizzoSede;
    }


    /**
     * Gets the idSede value for this Sede.
     * 
     * @return idSede
     */
    public java.lang.String getIdSede() {
        return idSede;
    }


    /**
     * Sets the idSede value for this Sede.
     * 
     * @param idSede
     */
    public void setIdSede(java.lang.String idSede) {
        this.idSede = idSede;
    }


    /**
     * Gets the descSede value for this Sede.
     * 
     * @return descSede
     */
    public java.lang.String getDescSede() {
        return descSede;
    }


    /**
     * Sets the descSede value for this Sede.
     * 
     * @param descSede
     */
    public void setDescSede(java.lang.String descSede) {
        this.descSede = descSede;
    }


    /**
     * Gets the indirizzoSede value for this Sede.
     * 
     * @return indirizzoSede
     */
    public java.lang.String getIndirizzoSede() {
        return indirizzoSede;
    }


    /**
     * Sets the indirizzoSede value for this Sede.
     * 
     * @param indirizzoSede
     */
    public void setIndirizzoSede(java.lang.String indirizzoSede) {
        this.indirizzoSede = indirizzoSede;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sede)) return false;
        Sede other = (Sede) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idSede==null && other.getIdSede()==null) || 
             (this.idSede!=null &&
              this.idSede.equals(other.getIdSede()))) &&
            ((this.descSede==null && other.getDescSede()==null) || 
             (this.descSede!=null &&
              this.descSede.equals(other.getDescSede()))) &&
            ((this.indirizzoSede==null && other.getIndirizzoSede()==null) || 
             (this.indirizzoSede!=null &&
              this.indirizzoSede.equals(other.getIndirizzoSede())));
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
        if (getIdSede() != null) {
            _hashCode += getIdSede().hashCode();
        }
        if (getDescSede() != null) {
            _hashCode += getDescSede().hashCode();
        }
        if (getIndirizzoSede() != null) {
            _hashCode += getIndirizzoSede().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sede.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Sede"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idSede");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idSede"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descSede");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "descSede"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoSede");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "indirizzoSede"));
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
