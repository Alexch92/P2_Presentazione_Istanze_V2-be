/**
 * Classifica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Classifica  implements java.io.Serializable {
    private java.lang.String codiceAmministrazione;

    private java.lang.String codiceAOO;

    private java.lang.String denominazione;

    private it.sincon.gepred.protocollo.scatel.bean.Livello[] livello;

    public Classifica() {
    }

    public Classifica(
           java.lang.String codiceAmministrazione,
           java.lang.String codiceAOO,
           java.lang.String denominazione,
           it.sincon.gepred.protocollo.scatel.bean.Livello[] livello) {
           this.codiceAmministrazione = codiceAmministrazione;
           this.codiceAOO = codiceAOO;
           this.denominazione = denominazione;
           this.livello = livello;
    }


    /**
     * Gets the codiceAmministrazione value for this Classifica.
     * 
     * @return codiceAmministrazione
     */
    public java.lang.String getCodiceAmministrazione() {
        return codiceAmministrazione;
    }


    /**
     * Sets the codiceAmministrazione value for this Classifica.
     * 
     * @param codiceAmministrazione
     */
    public void setCodiceAmministrazione(java.lang.String codiceAmministrazione) {
        this.codiceAmministrazione = codiceAmministrazione;
    }


    /**
     * Gets the codiceAOO value for this Classifica.
     * 
     * @return codiceAOO
     */
    public java.lang.String getCodiceAOO() {
        return codiceAOO;
    }


    /**
     * Sets the codiceAOO value for this Classifica.
     * 
     * @param codiceAOO
     */
    public void setCodiceAOO(java.lang.String codiceAOO) {
        this.codiceAOO = codiceAOO;
    }


    /**
     * Gets the denominazione value for this Classifica.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this Classifica.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the livello value for this Classifica.
     * 
     * @return livello
     */
    public it.sincon.gepred.protocollo.scatel.bean.Livello[] getLivello() {
        return livello;
    }


    /**
     * Sets the livello value for this Classifica.
     * 
     * @param livello
     */
    public void setLivello(it.sincon.gepred.protocollo.scatel.bean.Livello[] livello) {
        this.livello = livello;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Livello getLivello(int i) {
        return this.livello[i];
    }

    public void setLivello(int i, it.sincon.gepred.protocollo.scatel.bean.Livello _value) {
        this.livello[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Classifica)) return false;
        Classifica other = (Classifica) obj;
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
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.livello==null && other.getLivello()==null) || 
             (this.livello!=null &&
              java.util.Arrays.equals(this.livello, other.getLivello())));
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
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getLivello() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLivello());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLivello(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Classifica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Classifica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAmministrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAmministrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAOO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAOO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("livello");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Livello"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Livello"));
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
