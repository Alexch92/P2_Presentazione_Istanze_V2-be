/**
 * SegnaturaProtocollo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class SegnaturaProtocollo  implements java.io.Serializable {
    private java.lang.String codiceAmministrazione;

    private java.lang.String codiceAOO;

    private java.lang.String codiceRegistro;

    private java.lang.String dataRegistrazione;

    private java.lang.String numeroProtocollo;

    public SegnaturaProtocollo() {
    }

    public SegnaturaProtocollo(
           java.lang.String codiceAmministrazione,
           java.lang.String codiceAOO,
           java.lang.String codiceRegistro,
           java.lang.String dataRegistrazione,
           java.lang.String numeroProtocollo) {
           this.codiceAmministrazione = codiceAmministrazione;
           this.codiceAOO = codiceAOO;
           this.codiceRegistro = codiceRegistro;
           this.dataRegistrazione = dataRegistrazione;
           this.numeroProtocollo = numeroProtocollo;
    }


    /**
     * Gets the codiceAmministrazione value for this SegnaturaProtocollo.
     * 
     * @return codiceAmministrazione
     */
    public java.lang.String getCodiceAmministrazione() {
        return codiceAmministrazione;
    }


    /**
     * Sets the codiceAmministrazione value for this SegnaturaProtocollo.
     * 
     * @param codiceAmministrazione
     */
    public void setCodiceAmministrazione(java.lang.String codiceAmministrazione) {
        this.codiceAmministrazione = codiceAmministrazione;
    }


    /**
     * Gets the codiceAOO value for this SegnaturaProtocollo.
     * 
     * @return codiceAOO
     */
    public java.lang.String getCodiceAOO() {
        return codiceAOO;
    }


    /**
     * Sets the codiceAOO value for this SegnaturaProtocollo.
     * 
     * @param codiceAOO
     */
    public void setCodiceAOO(java.lang.String codiceAOO) {
        this.codiceAOO = codiceAOO;
    }


    /**
     * Gets the codiceRegistro value for this SegnaturaProtocollo.
     * 
     * @return codiceRegistro
     */
    public java.lang.String getCodiceRegistro() {
        return codiceRegistro;
    }


    /**
     * Sets the codiceRegistro value for this SegnaturaProtocollo.
     * 
     * @param codiceRegistro
     */
    public void setCodiceRegistro(java.lang.String codiceRegistro) {
        this.codiceRegistro = codiceRegistro;
    }


    /**
     * Gets the dataRegistrazione value for this SegnaturaProtocollo.
     * 
     * @return dataRegistrazione
     */
    public java.lang.String getDataRegistrazione() {
        return dataRegistrazione;
    }


    /**
     * Sets the dataRegistrazione value for this SegnaturaProtocollo.
     * 
     * @param dataRegistrazione
     */
    public void setDataRegistrazione(java.lang.String dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }


    /**
     * Gets the numeroProtocollo value for this SegnaturaProtocollo.
     * 
     * @return numeroProtocollo
     */
    public java.lang.String getNumeroProtocollo() {
        return numeroProtocollo;
    }


    /**
     * Sets the numeroProtocollo value for this SegnaturaProtocollo.
     * 
     * @param numeroProtocollo
     */
    public void setNumeroProtocollo(java.lang.String numeroProtocollo) {
        this.numeroProtocollo = numeroProtocollo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SegnaturaProtocollo)) return false;
        SegnaturaProtocollo other = (SegnaturaProtocollo) obj;
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
            ((this.codiceRegistro==null && other.getCodiceRegistro()==null) || 
             (this.codiceRegistro!=null &&
              this.codiceRegistro.equals(other.getCodiceRegistro()))) &&
            ((this.dataRegistrazione==null && other.getDataRegistrazione()==null) || 
             (this.dataRegistrazione!=null &&
              this.dataRegistrazione.equals(other.getDataRegistrazione()))) &&
            ((this.numeroProtocollo==null && other.getNumeroProtocollo()==null) || 
             (this.numeroProtocollo!=null &&
              this.numeroProtocollo.equals(other.getNumeroProtocollo())));
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
        if (getCodiceRegistro() != null) {
            _hashCode += getCodiceRegistro().hashCode();
        }
        if (getDataRegistrazione() != null) {
            _hashCode += getDataRegistrazione().hashCode();
        }
        if (getNumeroProtocollo() != null) {
            _hashCode += getNumeroProtocollo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SegnaturaProtocollo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">SegnaturaProtocollo"));
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
        elemField.setFieldName("codiceRegistro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceRegistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataRegistrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DataRegistrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroProtocollo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroProtocollo"));
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
