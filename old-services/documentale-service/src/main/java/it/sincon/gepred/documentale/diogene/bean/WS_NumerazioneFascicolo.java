/**
 * WS_NumerazioneFascicolo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_NumerazioneFascicolo  implements java.io.Serializable {
    private java.lang.Integer anno;

    private java.lang.Integer numero;

    private java.lang.String numeroInterno;

    private java.lang.String numeroLegislatura;

    private java.lang.Integer tipologiaNumerazione;

    public WS_NumerazioneFascicolo() {
    }

    public WS_NumerazioneFascicolo(
           java.lang.Integer anno,
           java.lang.Integer numero,
           java.lang.String numeroInterno,
           java.lang.String numeroLegislatura,
           java.lang.Integer tipologiaNumerazione) {
           this.anno = anno;
           this.numero = numero;
           this.numeroInterno = numeroInterno;
           this.numeroLegislatura = numeroLegislatura;
           this.tipologiaNumerazione = tipologiaNumerazione;
    }


    /**
     * Gets the anno value for this WS_NumerazioneFascicolo.
     * 
     * @return anno
     */
    public java.lang.Integer getAnno() {
        return anno;
    }


    /**
     * Sets the anno value for this WS_NumerazioneFascicolo.
     * 
     * @param anno
     */
    public void setAnno(java.lang.Integer anno) {
        this.anno = anno;
    }


    /**
     * Gets the numero value for this WS_NumerazioneFascicolo.
     * 
     * @return numero
     */
    public java.lang.Integer getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this WS_NumerazioneFascicolo.
     * 
     * @param numero
     */
    public void setNumero(java.lang.Integer numero) {
        this.numero = numero;
    }


    /**
     * Gets the numeroInterno value for this WS_NumerazioneFascicolo.
     * 
     * @return numeroInterno
     */
    public java.lang.String getNumeroInterno() {
        return numeroInterno;
    }


    /**
     * Sets the numeroInterno value for this WS_NumerazioneFascicolo.
     * 
     * @param numeroInterno
     */
    public void setNumeroInterno(java.lang.String numeroInterno) {
        this.numeroInterno = numeroInterno;
    }


    /**
     * Gets the numeroLegislatura value for this WS_NumerazioneFascicolo.
     * 
     * @return numeroLegislatura
     */
    public java.lang.String getNumeroLegislatura() {
        return numeroLegislatura;
    }


    /**
     * Sets the numeroLegislatura value for this WS_NumerazioneFascicolo.
     * 
     * @param numeroLegislatura
     */
    public void setNumeroLegislatura(java.lang.String numeroLegislatura) {
        this.numeroLegislatura = numeroLegislatura;
    }


    /**
     * Gets the tipologiaNumerazione value for this WS_NumerazioneFascicolo.
     * 
     * @return tipologiaNumerazione
     */
    public java.lang.Integer getTipologiaNumerazione() {
        return tipologiaNumerazione;
    }


    /**
     * Sets the tipologiaNumerazione value for this WS_NumerazioneFascicolo.
     * 
     * @param tipologiaNumerazione
     */
    public void setTipologiaNumerazione(java.lang.Integer tipologiaNumerazione) {
        this.tipologiaNumerazione = tipologiaNumerazione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_NumerazioneFascicolo)) return false;
        WS_NumerazioneFascicolo other = (WS_NumerazioneFascicolo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anno==null && other.getAnno()==null) || 
             (this.anno!=null &&
              this.anno.equals(other.getAnno()))) &&
            ((this.numero==null && other.getNumero()==null) || 
             (this.numero!=null &&
              this.numero.equals(other.getNumero()))) &&
            ((this.numeroInterno==null && other.getNumeroInterno()==null) || 
             (this.numeroInterno!=null &&
              this.numeroInterno.equals(other.getNumeroInterno()))) &&
            ((this.numeroLegislatura==null && other.getNumeroLegislatura()==null) || 
             (this.numeroLegislatura!=null &&
              this.numeroLegislatura.equals(other.getNumeroLegislatura()))) &&
            ((this.tipologiaNumerazione==null && other.getTipologiaNumerazione()==null) || 
             (this.tipologiaNumerazione!=null &&
              this.tipologiaNumerazione.equals(other.getTipologiaNumerazione())));
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
        if (getAnno() != null) {
            _hashCode += getAnno().hashCode();
        }
        if (getNumero() != null) {
            _hashCode += getNumero().hashCode();
        }
        if (getNumeroInterno() != null) {
            _hashCode += getNumeroInterno().hashCode();
        }
        if (getNumeroLegislatura() != null) {
            _hashCode += getNumeroLegislatura().hashCode();
        }
        if (getTipologiaNumerazione() != null) {
            _hashCode += getTipologiaNumerazione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_NumerazioneFascicolo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NumerazioneFascicolo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "anno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroInterno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "numeroInterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroLegislatura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "numeroLegislatura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipologiaNumerazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipologiaNumerazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
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
