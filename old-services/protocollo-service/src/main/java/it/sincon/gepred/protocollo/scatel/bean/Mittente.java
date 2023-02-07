/**
 * Mittente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Mittente  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Persona persona;

    private it.sincon.gepred.protocollo.scatel.bean.Amministrazione amministrazione;

    private it.sincon.gepred.protocollo.scatel.bean.AOO AOO;

    private java.lang.String denominazione;

    public Mittente() {
    }

    public Mittente(
           it.sincon.gepred.protocollo.scatel.bean.Persona persona,
           it.sincon.gepred.protocollo.scatel.bean.Amministrazione amministrazione,
           it.sincon.gepred.protocollo.scatel.bean.AOO AOO,
           java.lang.String denominazione) {
           this.persona = persona;
           this.amministrazione = amministrazione;
           this.AOO = AOO;
           this.denominazione = denominazione;
    }


    /**
     * Gets the persona value for this Mittente.
     * 
     * @return persona
     */
    public it.sincon.gepred.protocollo.scatel.bean.Persona getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this Mittente.
     * 
     * @param persona
     */
    public void setPersona(it.sincon.gepred.protocollo.scatel.bean.Persona persona) {
        this.persona = persona;
    }


    /**
     * Gets the amministrazione value for this Mittente.
     * 
     * @return amministrazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.Amministrazione getAmministrazione() {
        return amministrazione;
    }


    /**
     * Sets the amministrazione value for this Mittente.
     * 
     * @param amministrazione
     */
    public void setAmministrazione(it.sincon.gepred.protocollo.scatel.bean.Amministrazione amministrazione) {
        this.amministrazione = amministrazione;
    }


    /**
     * Gets the AOO value for this Mittente.
     * 
     * @return AOO
     */
    public it.sincon.gepred.protocollo.scatel.bean.AOO getAOO() {
        return AOO;
    }


    /**
     * Sets the AOO value for this Mittente.
     * 
     * @param AOO
     */
    public void setAOO(it.sincon.gepred.protocollo.scatel.bean.AOO AOO) {
        this.AOO = AOO;
    }


    /**
     * Gets the denominazione value for this Mittente.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this Mittente.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mittente)) return false;
        Mittente other = (Mittente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              this.persona.equals(other.getPersona()))) &&
            ((this.amministrazione==null && other.getAmministrazione()==null) || 
             (this.amministrazione!=null &&
              this.amministrazione.equals(other.getAmministrazione()))) &&
            ((this.AOO==null && other.getAOO()==null) || 
             (this.AOO!=null &&
              this.AOO.equals(other.getAOO()))) &&
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione())));
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
        if (getPersona() != null) {
            _hashCode += getPersona().hashCode();
        }
        if (getAmministrazione() != null) {
            _hashCode += getAmministrazione().hashCode();
        }
        if (getAOO() != null) {
            _hashCode += getAOO().hashCode();
        }
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Mittente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Mittente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Persona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Persona"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amministrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Amministrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Amministrazione"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AOO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "AOO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">AOO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
