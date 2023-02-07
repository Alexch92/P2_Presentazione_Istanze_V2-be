/**
 * UnitaOrganizzativa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class UnitaOrganizzativa  implements java.io.Serializable {
    private java.lang.String denominazione;

    private java.lang.String identificativo;

    private it.sincon.gepred.protocollo.scatel.bean.Ruolo[] ruolo;

    private it.sincon.gepred.protocollo.scatel.bean.Persona[] persona;

    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale;

    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico[] indirizzoTelematico;

    private it.sincon.gepred.protocollo.scatel.bean.Telefono[] telefono;

    private it.sincon.gepred.protocollo.scatel.bean.Fax[] fax;

    private it.sincon.gepred.protocollo.scatel.bean.UnitaOrganizzativaTipo tipo;  // attribute

    public UnitaOrganizzativa() {
    }

    public UnitaOrganizzativa(
           java.lang.String denominazione,
           java.lang.String identificativo,
           it.sincon.gepred.protocollo.scatel.bean.Ruolo[] ruolo,
           it.sincon.gepred.protocollo.scatel.bean.Persona[] persona,
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale,
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico[] indirizzoTelematico,
           it.sincon.gepred.protocollo.scatel.bean.Telefono[] telefono,
           it.sincon.gepred.protocollo.scatel.bean.Fax[] fax,
           it.sincon.gepred.protocollo.scatel.bean.UnitaOrganizzativaTipo tipo) {
           this.denominazione = denominazione;
           this.identificativo = identificativo;
           this.ruolo = ruolo;
           this.persona = persona;
           this.indirizzoPostale = indirizzoPostale;
           this.indirizzoTelematico = indirizzoTelematico;
           this.telefono = telefono;
           this.fax = fax;
           this.tipo = tipo;
    }


    /**
     * Gets the denominazione value for this UnitaOrganizzativa.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this UnitaOrganizzativa.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the identificativo value for this UnitaOrganizzativa.
     * 
     * @return identificativo
     */
    public java.lang.String getIdentificativo() {
        return identificativo;
    }


    /**
     * Sets the identificativo value for this UnitaOrganizzativa.
     * 
     * @param identificativo
     */
    public void setIdentificativo(java.lang.String identificativo) {
        this.identificativo = identificativo;
    }


    /**
     * Gets the ruolo value for this UnitaOrganizzativa.
     * 
     * @return ruolo
     */
    public it.sincon.gepred.protocollo.scatel.bean.Ruolo[] getRuolo() {
        return ruolo;
    }


    /**
     * Sets the ruolo value for this UnitaOrganizzativa.
     * 
     * @param ruolo
     */
    public void setRuolo(it.sincon.gepred.protocollo.scatel.bean.Ruolo[] ruolo) {
        this.ruolo = ruolo;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Ruolo getRuolo(int i) {
        return this.ruolo[i];
    }

    public void setRuolo(int i, it.sincon.gepred.protocollo.scatel.bean.Ruolo _value) {
        this.ruolo[i] = _value;
    }


    /**
     * Gets the persona value for this UnitaOrganizzativa.
     * 
     * @return persona
     */
    public it.sincon.gepred.protocollo.scatel.bean.Persona[] getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this UnitaOrganizzativa.
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
     * Gets the indirizzoPostale value for this UnitaOrganizzativa.
     * 
     * @return indirizzoPostale
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale getIndirizzoPostale() {
        return indirizzoPostale;
    }


    /**
     * Sets the indirizzoPostale value for this UnitaOrganizzativa.
     * 
     * @param indirizzoPostale
     */
    public void setIndirizzoPostale(it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale indirizzoPostale) {
        this.indirizzoPostale = indirizzoPostale;
    }


    /**
     * Gets the indirizzoTelematico value for this UnitaOrganizzativa.
     * 
     * @return indirizzoTelematico
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico[] getIndirizzoTelematico() {
        return indirizzoTelematico;
    }


    /**
     * Sets the indirizzoTelematico value for this UnitaOrganizzativa.
     * 
     * @param indirizzoTelematico
     */
    public void setIndirizzoTelematico(it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico[] indirizzoTelematico) {
        this.indirizzoTelematico = indirizzoTelematico;
    }

    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico getIndirizzoTelematico(int i) {
        return this.indirizzoTelematico[i];
    }

    public void setIndirizzoTelematico(int i, it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico _value) {
        this.indirizzoTelematico[i] = _value;
    }


    /**
     * Gets the telefono value for this UnitaOrganizzativa.
     * 
     * @return telefono
     */
    public it.sincon.gepred.protocollo.scatel.bean.Telefono[] getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this UnitaOrganizzativa.
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
     * Gets the fax value for this UnitaOrganizzativa.
     * 
     * @return fax
     */
    public it.sincon.gepred.protocollo.scatel.bean.Fax[] getFax() {
        return fax;
    }


    /**
     * Sets the fax value for this UnitaOrganizzativa.
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
     * Gets the tipo value for this UnitaOrganizzativa.
     * 
     * @return tipo
     */
    public it.sincon.gepred.protocollo.scatel.bean.UnitaOrganizzativaTipo getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this UnitaOrganizzativa.
     * 
     * @param tipo
     */
    public void setTipo(it.sincon.gepred.protocollo.scatel.bean.UnitaOrganizzativaTipo tipo) {
        this.tipo = tipo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnitaOrganizzativa)) return false;
        UnitaOrganizzativa other = (UnitaOrganizzativa) obj;
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
            ((this.ruolo==null && other.getRuolo()==null) || 
             (this.ruolo!=null &&
              java.util.Arrays.equals(this.ruolo, other.getRuolo()))) &&
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              java.util.Arrays.equals(this.persona, other.getPersona()))) &&
            ((this.indirizzoPostale==null && other.getIndirizzoPostale()==null) || 
             (this.indirizzoPostale!=null &&
              this.indirizzoPostale.equals(other.getIndirizzoPostale()))) &&
            ((this.indirizzoTelematico==null && other.getIndirizzoTelematico()==null) || 
             (this.indirizzoTelematico!=null &&
              java.util.Arrays.equals(this.indirizzoTelematico, other.getIndirizzoTelematico()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              java.util.Arrays.equals(this.telefono, other.getTelefono()))) &&
            ((this.fax==null && other.getFax()==null) || 
             (this.fax!=null &&
              java.util.Arrays.equals(this.fax, other.getFax()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo())));
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
        if (getRuolo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRuolo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRuolo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getIndirizzoPostale() != null) {
            _hashCode += getIndirizzoPostale().hashCode();
        }
        if (getIndirizzoTelematico() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIndirizzoTelematico());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIndirizzoTelematico(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnitaOrganizzativa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">UnitaOrganizzativa"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tipo");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">>UnitaOrganizzativa>tipo"));
        typeDesc.addFieldDesc(attrField);
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
        elemField.setFieldName("ruolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Ruolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Ruolo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("indirizzoPostale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IndirizzoPostale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoPostale"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoTelematico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IndirizzoTelematico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IndirizzoTelematico"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
