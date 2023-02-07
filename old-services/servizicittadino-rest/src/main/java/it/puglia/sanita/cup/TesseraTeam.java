/**
 * TesseraTeam.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class TesseraTeam  implements java.io.Serializable {
    private java.lang.String numeroTessera;

    private java.lang.String numeroPersonale;

    private java.lang.String numeroIstituzione;

    private java.lang.String dataScadenza;

    private java.lang.String siglaNazione;

    public TesseraTeam() {
    }

    public TesseraTeam(
           java.lang.String numeroTessera,
           java.lang.String numeroPersonale,
           java.lang.String numeroIstituzione,
           java.lang.String dataScadenza,
           java.lang.String siglaNazione) {
           this.numeroTessera = numeroTessera;
           this.numeroPersonale = numeroPersonale;
           this.numeroIstituzione = numeroIstituzione;
           this.dataScadenza = dataScadenza;
           this.siglaNazione = siglaNazione;
    }


    /**
     * Gets the numeroTessera value for this TesseraTeam.
     * 
     * @return numeroTessera
     */
    public java.lang.String getNumeroTessera() {
        return numeroTessera;
    }


    /**
     * Sets the numeroTessera value for this TesseraTeam.
     * 
     * @param numeroTessera
     */
    public void setNumeroTessera(java.lang.String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }


    /**
     * Gets the numeroPersonale value for this TesseraTeam.
     * 
     * @return numeroPersonale
     */
    public java.lang.String getNumeroPersonale() {
        return numeroPersonale;
    }


    /**
     * Sets the numeroPersonale value for this TesseraTeam.
     * 
     * @param numeroPersonale
     */
    public void setNumeroPersonale(java.lang.String numeroPersonale) {
        this.numeroPersonale = numeroPersonale;
    }


    /**
     * Gets the numeroIstituzione value for this TesseraTeam.
     * 
     * @return numeroIstituzione
     */
    public java.lang.String getNumeroIstituzione() {
        return numeroIstituzione;
    }


    /**
     * Sets the numeroIstituzione value for this TesseraTeam.
     * 
     * @param numeroIstituzione
     */
    public void setNumeroIstituzione(java.lang.String numeroIstituzione) {
        this.numeroIstituzione = numeroIstituzione;
    }


    /**
     * Gets the dataScadenza value for this TesseraTeam.
     * 
     * @return dataScadenza
     */
    public java.lang.String getDataScadenza() {
        return dataScadenza;
    }


    /**
     * Sets the dataScadenza value for this TesseraTeam.
     * 
     * @param dataScadenza
     */
    public void setDataScadenza(java.lang.String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }


    /**
     * Gets the siglaNazione value for this TesseraTeam.
     * 
     * @return siglaNazione
     */
    public java.lang.String getSiglaNazione() {
        return siglaNazione;
    }


    /**
     * Sets the siglaNazione value for this TesseraTeam.
     * 
     * @param siglaNazione
     */
    public void setSiglaNazione(java.lang.String siglaNazione) {
        this.siglaNazione = siglaNazione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TesseraTeam)) return false;
        TesseraTeam other = (TesseraTeam) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroTessera==null && other.getNumeroTessera()==null) || 
             (this.numeroTessera!=null &&
              this.numeroTessera.equals(other.getNumeroTessera()))) &&
            ((this.numeroPersonale==null && other.getNumeroPersonale()==null) || 
             (this.numeroPersonale!=null &&
              this.numeroPersonale.equals(other.getNumeroPersonale()))) &&
            ((this.numeroIstituzione==null && other.getNumeroIstituzione()==null) || 
             (this.numeroIstituzione!=null &&
              this.numeroIstituzione.equals(other.getNumeroIstituzione()))) &&
            ((this.dataScadenza==null && other.getDataScadenza()==null) || 
             (this.dataScadenza!=null &&
              this.dataScadenza.equals(other.getDataScadenza()))) &&
            ((this.siglaNazione==null && other.getSiglaNazione()==null) || 
             (this.siglaNazione!=null &&
              this.siglaNazione.equals(other.getSiglaNazione())));
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
        if (getNumeroTessera() != null) {
            _hashCode += getNumeroTessera().hashCode();
        }
        if (getNumeroPersonale() != null) {
            _hashCode += getNumeroPersonale().hashCode();
        }
        if (getNumeroIstituzione() != null) {
            _hashCode += getNumeroIstituzione().hashCode();
        }
        if (getDataScadenza() != null) {
            _hashCode += getDataScadenza().hashCode();
        }
        if (getSiglaNazione() != null) {
            _hashCode += getSiglaNazione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TesseraTeam.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "TesseraTeam"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroTessera");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "numeroTessera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPersonale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "numeroPersonale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroIstituzione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "numeroIstituzione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataScadenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "dataScadenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaNazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "siglaNazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
