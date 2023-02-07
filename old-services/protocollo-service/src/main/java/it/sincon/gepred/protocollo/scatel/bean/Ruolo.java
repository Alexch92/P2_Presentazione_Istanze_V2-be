/**
 * Ruolo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Ruolo  implements java.io.Serializable {
    private java.lang.String denominazione;

    private java.lang.String identificativo;

    private it.sincon.gepred.protocollo.scatel.bean.Persona persona;

    public Ruolo() {
    }

    public Ruolo(
           java.lang.String denominazione,
           java.lang.String identificativo,
           it.sincon.gepred.protocollo.scatel.bean.Persona persona) {
           this.denominazione = denominazione;
           this.identificativo = identificativo;
           this.persona = persona;
    }


    /**
     * Gets the denominazione value for this Ruolo.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this Ruolo.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the identificativo value for this Ruolo.
     * 
     * @return identificativo
     */
    public java.lang.String getIdentificativo() {
        return identificativo;
    }


    /**
     * Sets the identificativo value for this Ruolo.
     * 
     * @param identificativo
     */
    public void setIdentificativo(java.lang.String identificativo) {
        this.identificativo = identificativo;
    }


    /**
     * Gets the persona value for this Ruolo.
     * 
     * @return persona
     */
    public it.sincon.gepred.protocollo.scatel.bean.Persona getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this Ruolo.
     * 
     * @param persona
     */
    public void setPersona(it.sincon.gepred.protocollo.scatel.bean.Persona persona) {
        this.persona = persona;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ruolo)) return false;
        Ruolo other = (Ruolo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.identificativo==null && other.getIdentificativo()==null) || 
             (this.identificativo!=null &&
              this.identificativo.equals(other.getIdentificativo()))) &&
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              this.persona.equals(other.getPersona())));
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
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getIdentificativo() != null) {
            _hashCode += getIdentificativo().hashCode();
        }
        if (getPersona() != null) {
            _hashCode += getPersona().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ruolo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Ruolo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificativo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Identificativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Persona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Persona"));
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
