/**
 * AnagraficaAOO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class AnagraficaAOO  implements java.io.Serializable {
    private java.lang.String codiceAOO;

    private java.lang.String codiceAmministrazione;

    private java.lang.String descrizioneAoo;

    private java.lang.String descrizioneAmministrazione;

    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico;

    private it.sincon.gepred.protocollo.scatel.bean.Telefono telefono;

    private it.sincon.gepred.protocollo.scatel.bean.Fax fax;

    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale;

    public AnagraficaAOO() {
    }

    public AnagraficaAOO(
           java.lang.String codiceAOO,
           java.lang.String codiceAmministrazione,
           java.lang.String descrizioneAoo,
           java.lang.String descrizioneAmministrazione,
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico,
           it.sincon.gepred.protocollo.scatel.bean.Telefono telefono,
           it.sincon.gepred.protocollo.scatel.bean.Fax fax,
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale) {
           this.codiceAOO = codiceAOO;
           this.codiceAmministrazione = codiceAmministrazione;
           this.descrizioneAoo = descrizioneAoo;
           this.descrizioneAmministrazione = descrizioneAmministrazione;
           this.indirizzoTelematico = indirizzoTelematico;
           this.telefono = telefono;
           this.fax = fax;
           this.indirizzoPostale = indirizzoPostale;
    }


    /**
     * Gets the codiceAOO value for this AnagraficaAOO.
     * 
     * @return codiceAOO
     */
    public java.lang.String getCodiceAOO() {
        return codiceAOO;
    }


    /**
     * Sets the codiceAOO value for this AnagraficaAOO.
     * 
     * @param codiceAOO
     */
    public void setCodiceAOO(java.lang.String codiceAOO) {
        this.codiceAOO = codiceAOO;
    }


    /**
     * Gets the codiceAmministrazione value for this AnagraficaAOO.
     * 
     * @return codiceAmministrazione
     */
    public java.lang.String getCodiceAmministrazione() {
        return codiceAmministrazione;
    }


    /**
     * Sets the codiceAmministrazione value for this AnagraficaAOO.
     * 
     * @param codiceAmministrazione
     */
    public void setCodiceAmministrazione(java.lang.String codiceAmministrazione) {
        this.codiceAmministrazione = codiceAmministrazione;
    }


    /**
     * Gets the descrizioneAoo value for this AnagraficaAOO.
     * 
     * @return descrizioneAoo
     */
    public java.lang.String getDescrizioneAoo() {
        return descrizioneAoo;
    }


    /**
     * Sets the descrizioneAoo value for this AnagraficaAOO.
     * 
     * @param descrizioneAoo
     */
    public void setDescrizioneAoo(java.lang.String descrizioneAoo) {
        this.descrizioneAoo = descrizioneAoo;
    }


    /**
     * Gets the descrizioneAmministrazione value for this AnagraficaAOO.
     * 
     * @return descrizioneAmministrazione
     */
    public java.lang.String getDescrizioneAmministrazione() {
        return descrizioneAmministrazione;
    }


    /**
     * Sets the descrizioneAmministrazione value for this AnagraficaAOO.
     * 
     * @param descrizioneAmministrazione
     */
    public void setDescrizioneAmministrazione(java.lang.String descrizioneAmministrazione) {
        this.descrizioneAmministrazione = descrizioneAmministrazione;
    }


    /**
     * Gets the indirizzoTelematico value for this AnagraficaAOO.
     * 
     * @return indirizzoTelematico
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico getIndirizzoTelematico() {
        return indirizzoTelematico;
    }


    /**
     * Sets the indirizzoTelematico value for this AnagraficaAOO.
     * 
     * @param indirizzoTelematico
     */
    public void setIndirizzoTelematico(it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico) {
        this.indirizzoTelematico = indirizzoTelematico;
    }


    /**
     * Gets the telefono value for this AnagraficaAOO.
     * 
     * @return telefono
     */
    public it.sincon.gepred.protocollo.scatel.bean.Telefono getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this AnagraficaAOO.
     * 
     * @param telefono
     */
    public void setTelefono(it.sincon.gepred.protocollo.scatel.bean.Telefono telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the fax value for this AnagraficaAOO.
     * 
     * @return fax
     */
    public it.sincon.gepred.protocollo.scatel.bean.Fax getFax() {
        return fax;
    }


    /**
     * Sets the fax value for this AnagraficaAOO.
     * 
     * @param fax
     */
    public void setFax(it.sincon.gepred.protocollo.scatel.bean.Fax fax) {
        this.fax = fax;
    }


    /**
     * Gets the indirizzoPostale value for this AnagraficaAOO.
     * 
     * @return indirizzoPostale
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale getIndirizzoPostale() {
        return indirizzoPostale;
    }


    /**
     * Sets the indirizzoPostale value for this AnagraficaAOO.
     * 
     * @param indirizzoPostale
     */
    public void setIndirizzoPostale(it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale) {
        this.indirizzoPostale = indirizzoPostale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnagraficaAOO)) return false;
        AnagraficaAOO other = (AnagraficaAOO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceAOO==null && other.getCodiceAOO()==null) || 
             (this.codiceAOO!=null &&
              this.codiceAOO.equals(other.getCodiceAOO()))) &&
            ((this.codiceAmministrazione==null && other.getCodiceAmministrazione()==null) || 
             (this.codiceAmministrazione!=null &&
              this.codiceAmministrazione.equals(other.getCodiceAmministrazione()))) &&
            ((this.descrizioneAoo==null && other.getDescrizioneAoo()==null) || 
             (this.descrizioneAoo!=null &&
              this.descrizioneAoo.equals(other.getDescrizioneAoo()))) &&
            ((this.descrizioneAmministrazione==null && other.getDescrizioneAmministrazione()==null) || 
             (this.descrizioneAmministrazione!=null &&
              this.descrizioneAmministrazione.equals(other.getDescrizioneAmministrazione()))) &&
            ((this.indirizzoTelematico==null && other.getIndirizzoTelematico()==null) || 
             (this.indirizzoTelematico!=null &&
              this.indirizzoTelematico.equals(other.getIndirizzoTelematico()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.fax==null && other.getFax()==null) || 
             (this.fax!=null &&
              this.fax.equals(other.getFax()))) &&
            ((this.indirizzoPostale==null && other.getIndirizzoPostale()==null) || 
             (this.indirizzoPostale!=null &&
              this.indirizzoPostale.equals(other.getIndirizzoPostale())));
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
        if (getCodiceAOO() != null) {
            _hashCode += getCodiceAOO().hashCode();
        }
        if (getCodiceAmministrazione() != null) {
            _hashCode += getCodiceAmministrazione().hashCode();
        }
        if (getDescrizioneAoo() != null) {
            _hashCode += getDescrizioneAoo().hashCode();
        }
        if (getDescrizioneAmministrazione() != null) {
            _hashCode += getDescrizioneAmministrazione().hashCode();
        }
        if (getIndirizzoTelematico() != null) {
            _hashCode += getIndirizzoTelematico().hashCode();
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getFax() != null) {
            _hashCode += getFax().hashCode();
        }
        if (getIndirizzoPostale() != null) {
            _hashCode += getIndirizzoPostale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnagraficaAOO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">AnagraficaAOO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAOO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAOO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAmministrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAmministrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneAoo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DescrizioneAoo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizioneAmministrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DescrizioneAmministrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoTelematico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IndirizzoTelematico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoTelematico"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Telefono"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Fax"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoPostale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IndirizzoPostale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoPostale"));
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
