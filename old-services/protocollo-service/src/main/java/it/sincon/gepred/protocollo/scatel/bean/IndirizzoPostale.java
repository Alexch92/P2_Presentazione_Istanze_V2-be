/**
 * IndirizzoPostale.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class IndirizzoPostale  implements java.io.Serializable {
    private java.lang.String denominazione;

    private it.sincon.gepred.protocollo.scatel.bean.Toponimo toponimo;

    private java.lang.String civico;

    private java.lang.String CAP;

    private it.sincon.gepred.protocollo.scatel.bean.Comune comune;

    private java.lang.String provincia;

    private java.lang.String nazione;

    public IndirizzoPostale() {
    }

    public IndirizzoPostale(
           java.lang.String denominazione,
           it.sincon.gepred.protocollo.scatel.bean.Toponimo toponimo,
           java.lang.String civico,
           java.lang.String CAP,
           it.sincon.gepred.protocollo.scatel.bean.Comune comune,
           java.lang.String provincia,
           java.lang.String nazione) {
           this.denominazione = denominazione;
           this.toponimo = toponimo;
           this.civico = civico;
           this.CAP = CAP;
           this.comune = comune;
           this.provincia = provincia;
           this.nazione = nazione;
    }


    /**
     * Gets the denominazione value for this IndirizzoPostale.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this IndirizzoPostale.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the toponimo value for this IndirizzoPostale.
     * 
     * @return toponimo
     */
    public it.sincon.gepred.protocollo.scatel.bean.Toponimo getToponimo() {
        return toponimo;
    }


    /**
     * Sets the toponimo value for this IndirizzoPostale.
     * 
     * @param toponimo
     */
    public void setToponimo(it.sincon.gepred.protocollo.scatel.bean.Toponimo toponimo) {
        this.toponimo = toponimo;
    }


    /**
     * Gets the civico value for this IndirizzoPostale.
     * 
     * @return civico
     */
    public java.lang.String getCivico() {
        return civico;
    }


    /**
     * Sets the civico value for this IndirizzoPostale.
     * 
     * @param civico
     */
    public void setCivico(java.lang.String civico) {
        this.civico = civico;
    }


    /**
     * Gets the CAP value for this IndirizzoPostale.
     * 
     * @return CAP
     */
    public java.lang.String getCAP() {
        return CAP;
    }


    /**
     * Sets the CAP value for this IndirizzoPostale.
     * 
     * @param CAP
     */
    public void setCAP(java.lang.String CAP) {
        this.CAP = CAP;
    }


    /**
     * Gets the comune value for this IndirizzoPostale.
     * 
     * @return comune
     */
    public it.sincon.gepred.protocollo.scatel.bean.Comune getComune() {
        return comune;
    }


    /**
     * Sets the comune value for this IndirizzoPostale.
     * 
     * @param comune
     */
    public void setComune(it.sincon.gepred.protocollo.scatel.bean.Comune comune) {
        this.comune = comune;
    }


    /**
     * Gets the provincia value for this IndirizzoPostale.
     * 
     * @return provincia
     */
    public java.lang.String getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this IndirizzoPostale.
     * 
     * @param provincia
     */
    public void setProvincia(java.lang.String provincia) {
        this.provincia = provincia;
    }


    /**
     * Gets the nazione value for this IndirizzoPostale.
     * 
     * @return nazione
     */
    public java.lang.String getNazione() {
        return nazione;
    }


    /**
     * Sets the nazione value for this IndirizzoPostale.
     * 
     * @param nazione
     */
    public void setNazione(java.lang.String nazione) {
        this.nazione = nazione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndirizzoPostale)) return false;
        IndirizzoPostale other = (IndirizzoPostale) obj;
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
            ((this.toponimo==null && other.getToponimo()==null) || 
             (this.toponimo!=null &&
              this.toponimo.equals(other.getToponimo()))) &&
            ((this.civico==null && other.getCivico()==null) || 
             (this.civico!=null &&
              this.civico.equals(other.getCivico()))) &&
            ((this.CAP==null && other.getCAP()==null) || 
             (this.CAP!=null &&
              this.CAP.equals(other.getCAP()))) &&
            ((this.comune==null && other.getComune()==null) || 
             (this.comune!=null &&
              this.comune.equals(other.getComune()))) &&
            ((this.provincia==null && other.getProvincia()==null) || 
             (this.provincia!=null &&
              this.provincia.equals(other.getProvincia()))) &&
            ((this.nazione==null && other.getNazione()==null) || 
             (this.nazione!=null &&
              this.nazione.equals(other.getNazione())));
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
        if (getToponimo() != null) {
            _hashCode += getToponimo().hashCode();
        }
        if (getCivico() != null) {
            _hashCode += getCivico().hashCode();
        }
        if (getCAP() != null) {
            _hashCode += getCAP().hashCode();
        }
        if (getComune() != null) {
            _hashCode += getComune().hashCode();
        }
        if (getProvincia() != null) {
            _hashCode += getProvincia().hashCode();
        }
        if (getNazione() != null) {
            _hashCode += getNazione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndirizzoPostale.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoPostale"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toponimo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Toponimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Toponimo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("civico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Civico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CAP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comune");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Comune"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Comune"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provincia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Provincia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Nazione"));
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
