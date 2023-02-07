/**
 * RichiestaPaziente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RichiestaPaziente  implements java.io.Serializable {
    private it.puglia.sanita.cup.Operatore operatore;

    private it.puglia.sanita.cup.Paziente paziente;

    public RichiestaPaziente() {
    }

    public RichiestaPaziente(
           it.puglia.sanita.cup.Operatore operatore,
           it.puglia.sanita.cup.Paziente paziente) {
           this.operatore = operatore;
           this.paziente = paziente;
    }


    /**
     * Gets the operatore value for this RichiestaPaziente.
     * 
     * @return operatore
     */
    public it.puglia.sanita.cup.Operatore getOperatore() {
        return operatore;
    }


    /**
     * Sets the operatore value for this RichiestaPaziente.
     * 
     * @param operatore
     */
    public void setOperatore(it.puglia.sanita.cup.Operatore operatore) {
        this.operatore = operatore;
    }


    /**
     * Gets the paziente value for this RichiestaPaziente.
     * 
     * @return paziente
     */
    public it.puglia.sanita.cup.Paziente getPaziente() {
        return paziente;
    }


    /**
     * Sets the paziente value for this RichiestaPaziente.
     * 
     * @param paziente
     */
    public void setPaziente(it.puglia.sanita.cup.Paziente paziente) {
        this.paziente = paziente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RichiestaPaziente)) return false;
        RichiestaPaziente other = (RichiestaPaziente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operatore==null && other.getOperatore()==null) || 
             (this.operatore!=null &&
              this.operatore.equals(other.getOperatore()))) &&
            ((this.paziente==null && other.getPaziente()==null) || 
             (this.paziente!=null &&
              this.paziente.equals(other.getPaziente())));
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
        if (getOperatore() != null) {
            _hashCode += getOperatore().hashCode();
        }
        if (getPaziente() != null) {
            _hashCode += getPaziente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RichiestaPaziente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPaziente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "operatore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Operatore"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paziente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "paziente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Paziente"));
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
