/**
 * CredenzialiUtente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class CredenzialiUtente  implements java.io.Serializable {
    private java.lang.String codiceAmministrazione;

    private java.lang.String codiceAOO;

    private java.lang.String IDUtente;

    public CredenzialiUtente() {
    }

    public CredenzialiUtente(
           java.lang.String codiceAmministrazione,
           java.lang.String codiceAOO,
           java.lang.String IDUtente) {
           this.codiceAmministrazione = codiceAmministrazione;
           this.codiceAOO = codiceAOO;
           this.IDUtente = IDUtente;
    }


    /**
     * Gets the codiceAmministrazione value for this CredenzialiUtente.
     * 
     * @return codiceAmministrazione
     */
    public java.lang.String getCodiceAmministrazione() {
        return codiceAmministrazione;
    }


    /**
     * Sets the codiceAmministrazione value for this CredenzialiUtente.
     * 
     * @param codiceAmministrazione
     */
    public void setCodiceAmministrazione(java.lang.String codiceAmministrazione) {
        this.codiceAmministrazione = codiceAmministrazione;
    }


    /**
     * Gets the codiceAOO value for this CredenzialiUtente.
     * 
     * @return codiceAOO
     */
    public java.lang.String getCodiceAOO() {
        return codiceAOO;
    }


    /**
     * Sets the codiceAOO value for this CredenzialiUtente.
     * 
     * @param codiceAOO
     */
    public void setCodiceAOO(java.lang.String codiceAOO) {
        this.codiceAOO = codiceAOO;
    }


    /**
     * Gets the IDUtente value for this CredenzialiUtente.
     * 
     * @return IDUtente
     */
    public java.lang.String getIDUtente() {
        return IDUtente;
    }


    /**
     * Sets the IDUtente value for this CredenzialiUtente.
     * 
     * @param IDUtente
     */
    public void setIDUtente(java.lang.String IDUtente) {
        this.IDUtente = IDUtente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CredenzialiUtente)) return false;
        CredenzialiUtente other = (CredenzialiUtente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceAmministrazione==null && other.getCodiceAmministrazione()==null) || 
             (this.codiceAmministrazione!=null &&
              this.codiceAmministrazione.equals(other.getCodiceAmministrazione()))) &&
            ((this.codiceAOO==null && other.getCodiceAOO()==null) || 
             (this.codiceAOO!=null &&
              this.codiceAOO.equals(other.getCodiceAOO()))) &&
            ((this.IDUtente==null && other.getIDUtente()==null) || 
             (this.IDUtente!=null &&
              this.IDUtente.equals(other.getIDUtente())));
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
        if (getCodiceAmministrazione() != null) {
            _hashCode += getCodiceAmministrazione().hashCode();
        }
        if (getCodiceAOO() != null) {
            _hashCode += getCodiceAOO().hashCode();
        }
        if (getIDUtente() != null) {
            _hashCode += getIDUtente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CredenzialiUtente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">CredenzialiUtente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAmministrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAmministrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAOO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAOO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDUtente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IDUtente"));
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
