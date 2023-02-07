/**
 * Origine.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Origine  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico;

    private it.sincon.gepred.protocollo.scatel.bean.Mittente mittente;

    public Origine() {
    }

    public Origine(
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico,
           it.sincon.gepred.protocollo.scatel.bean.Mittente mittente) {
           this.indirizzoTelematico = indirizzoTelematico;
           this.mittente = mittente;
    }


    /**
     * Gets the indirizzoTelematico value for this Origine.
     * 
     * @return indirizzoTelematico
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico getIndirizzoTelematico() {
        return indirizzoTelematico;
    }


    /**
     * Sets the indirizzoTelematico value for this Origine.
     * 
     * @param indirizzoTelematico
     */
    public void setIndirizzoTelematico(it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico) {
        this.indirizzoTelematico = indirizzoTelematico;
    }


    /**
     * Gets the mittente value for this Origine.
     * 
     * @return mittente
     */
    public it.sincon.gepred.protocollo.scatel.bean.Mittente getMittente() {
        return mittente;
    }


    /**
     * Sets the mittente value for this Origine.
     * 
     * @param mittente
     */
    public void setMittente(it.sincon.gepred.protocollo.scatel.bean.Mittente mittente) {
        this.mittente = mittente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Origine)) return false;
        Origine other = (Origine) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indirizzoTelematico==null && other.getIndirizzoTelematico()==null) || 
             (this.indirizzoTelematico!=null &&
              this.indirizzoTelematico.equals(other.getIndirizzoTelematico()))) &&
            ((this.mittente==null && other.getMittente()==null) || 
             (this.mittente!=null &&
              this.mittente.equals(other.getMittente())));
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
        if (getIndirizzoTelematico() != null) {
            _hashCode += getIndirizzoTelematico().hashCode();
        }
        if (getMittente() != null) {
            _hashCode += getMittente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Origine.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Origine"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoTelematico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IndirizzoTelematico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoTelematico"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mittente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Mittente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Mittente"));
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
