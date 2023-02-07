/**
 * Destinatario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Destinatario  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Amministrazione amministrazione;

    private it.sincon.gepred.protocollo.scatel.bean.AOO AOO;

    private it.sincon.gepred.protocollo.scatel.bean.Persona[] persona;

    private java.lang.String denominazione;

    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico;

    private it.sincon.gepred.protocollo.scatel.bean.Telefono[] telefono;

    private it.sincon.gepred.protocollo.scatel.bean.Fax[] fax;

    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale;

    public Destinatario() {
    }

    public Destinatario(
           it.sincon.gepred.protocollo.scatel.bean.Amministrazione amministrazione,
           it.sincon.gepred.protocollo.scatel.bean.AOO AOO,
           it.sincon.gepred.protocollo.scatel.bean.Persona[] persona,
           java.lang.String denominazione,
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico,
           it.sincon.gepred.protocollo.scatel.bean.Telefono[] telefono,
           it.sincon.gepred.protocollo.scatel.bean.Fax[] fax,
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale) {
           this.amministrazione = amministrazione;
           this.AOO = AOO;
           this.persona = persona;
           this.denominazione = denominazione;
           this.indirizzoTelematico = indirizzoTelematico;
           this.telefono = telefono;
           this.fax = fax;
           this.indirizzoPostale = indirizzoPostale;
    }


    /**
     * Gets the amministrazione value for this Destinatario.
     * 
     * @return amministrazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.Amministrazione getAmministrazione() {
        return amministrazione;
    }


    /**
     * Sets the amministrazione value for this Destinatario.
     * 
     * @param amministrazione
     */
    public void setAmministrazione(it.sincon.gepred.protocollo.scatel.bean.Amministrazione amministrazione) {
        this.amministrazione = amministrazione;
    }


    /**
     * Gets the AOO value for this Destinatario.
     * 
     * @return AOO
     */
    public it.sincon.gepred.protocollo.scatel.bean.AOO getAOO() {
        return AOO;
    }


    /**
     * Sets the AOO value for this Destinatario.
     * 
     * @param AOO
     */
    public void setAOO(it.sincon.gepred.protocollo.scatel.bean.AOO AOO) {
        this.AOO = AOO;
    }


    /**
     * Gets the persona value for this Destinatario.
     * 
     * @return persona
     */
    public it.sincon.gepred.protocollo.scatel.bean.Persona[] getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this Destinatario.
     * 
     * @param persona
     */
    public void setPersona(it.sincon.gepred.protocollo.scatel.bean.Persona[] persona) {
        this.persona = persona;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Persona getPersona(int i) {
        return this.persona[i];
    }

    public void setPersona(int i, it.sincon.gepred.protocollo.scatel.bean.Persona _value) {
        this.persona[i] = _value;
    }


    /**
     * Gets the denominazione value for this Destinatario.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this Destinatario.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the indirizzoTelematico value for this Destinatario.
     * 
     * @return indirizzoTelematico
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico getIndirizzoTelematico() {
        return indirizzoTelematico;
    }


    /**
     * Sets the indirizzoTelematico value for this Destinatario.
     * 
     * @param indirizzoTelematico
     */
    public void setIndirizzoTelematico(it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico) {
        this.indirizzoTelematico = indirizzoTelematico;
    }


    /**
     * Gets the telefono value for this Destinatario.
     * 
     * @return telefono
     */
    public it.sincon.gepred.protocollo.scatel.bean.Telefono[] getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this Destinatario.
     * 
     * @param telefono
     */
    public void setTelefono(it.sincon.gepred.protocollo.scatel.bean.Telefono[] telefono) {
        this.telefono = telefono;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Telefono getTelefono(int i) {
        return this.telefono[i];
    }

    public void setTelefono(int i, it.sincon.gepred.protocollo.scatel.bean.Telefono _value) {
        this.telefono[i] = _value;
    }


    /**
     * Gets the fax value for this Destinatario.
     * 
     * @return fax
     */
    public it.sincon.gepred.protocollo.scatel.bean.Fax[] getFax() {
        return fax;
    }


    /**
     * Sets the fax value for this Destinatario.
     * 
     * @param fax
     */
    public void setFax(it.sincon.gepred.protocollo.scatel.bean.Fax[] fax) {
        this.fax = fax;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Fax getFax(int i) {
        return this.fax[i];
    }

    public void setFax(int i, it.sincon.gepred.protocollo.scatel.bean.Fax _value) {
        this.fax[i] = _value;
    }


    /**
     * Gets the indirizzoPostale value for this Destinatario.
     * 
     * @return indirizzoPostale
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale getIndirizzoPostale() {
        return indirizzoPostale;
    }


    /**
     * Sets the indirizzoPostale value for this Destinatario.
     * 
     * @param indirizzoPostale
     */
    public void setIndirizzoPostale(it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale) {
        this.indirizzoPostale = indirizzoPostale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Destinatario)) return false;
        Destinatario other = (Destinatario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amministrazione==null && other.getAmministrazione()==null) || 
             (this.amministrazione!=null &&
              this.amministrazione.equals(other.getAmministrazione()))) &&
            ((this.AOO==null && other.getAOO()==null) || 
             (this.AOO!=null &&
              this.AOO.equals(other.getAOO()))) &&
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              java.util.Arrays.equals(this.persona, other.getPersona()))) &&
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.indirizzoTelematico==null && other.getIndirizzoTelematico()==null) || 
             (this.indirizzoTelematico!=null &&
              this.indirizzoTelematico.equals(other.getIndirizzoTelematico()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              java.util.Arrays.equals(this.telefono, other.getTelefono()))) &&
            ((this.fax==null && other.getFax()==null) || 
             (this.fax!=null &&
              java.util.Arrays.equals(this.fax, other.getFax()))) &&
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
        if (getAmministrazione() != null) {
            _hashCode += getAmministrazione().hashCode();
        }
        if (getAOO() != null) {
            _hashCode += getAOO().hashCode();
        }
        if (getPersona() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPersona());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPersona(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getIndirizzoTelematico() != null) {
            _hashCode += getIndirizzoTelematico().hashCode();
        }
        if (getTelefono() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTelefono());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTelefono(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFax() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFax());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFax(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndirizzoPostale() != null) {
            _hashCode += getIndirizzoPostale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Destinatario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Destinatario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("persona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Persona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Persona"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Telefono"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Fax"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
