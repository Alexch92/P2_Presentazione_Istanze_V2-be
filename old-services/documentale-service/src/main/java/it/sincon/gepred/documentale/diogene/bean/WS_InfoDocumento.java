/**
 * WS_InfoDocumento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_InfoDocumento  implements java.io.Serializable {
    private java.lang.String autore;

    private java.lang.String dataCreazione;

    private java.lang.String fileName;

    private java.lang.String idAggregatoContenitore;

    private java.lang.String idDocumento;

    private java.lang.String idDocumentoPadre;

    private java.lang.String idVersione;

    private java.lang.String numVersione;

    private java.lang.String tipoDocumento;

    private java.lang.String titolo;

    public WS_InfoDocumento() {
    }

    public WS_InfoDocumento(
           java.lang.String autore,
           java.lang.String dataCreazione,
           java.lang.String fileName,
           java.lang.String idAggregatoContenitore,
           java.lang.String idDocumento,
           java.lang.String idDocumentoPadre,
           java.lang.String idVersione,
           java.lang.String numVersione,
           java.lang.String tipoDocumento,
           java.lang.String titolo) {
           this.autore = autore;
           this.dataCreazione = dataCreazione;
           this.fileName = fileName;
           this.idAggregatoContenitore = idAggregatoContenitore;
           this.idDocumento = idDocumento;
           this.idDocumentoPadre = idDocumentoPadre;
           this.idVersione = idVersione;
           this.numVersione = numVersione;
           this.tipoDocumento = tipoDocumento;
           this.titolo = titolo;
    }


    /**
     * Gets the autore value for this WS_InfoDocumento.
     * 
     * @return autore
     */
    public java.lang.String getAutore() {
        return autore;
    }


    /**
     * Sets the autore value for this WS_InfoDocumento.
     * 
     * @param autore
     */
    public void setAutore(java.lang.String autore) {
        this.autore = autore;
    }


    /**
     * Gets the dataCreazione value for this WS_InfoDocumento.
     * 
     * @return dataCreazione
     */
    public java.lang.String getDataCreazione() {
        return dataCreazione;
    }


    /**
     * Sets the dataCreazione value for this WS_InfoDocumento.
     * 
     * @param dataCreazione
     */
    public void setDataCreazione(java.lang.String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }


    /**
     * Gets the fileName value for this WS_InfoDocumento.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this WS_InfoDocumento.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the idAggregatoContenitore value for this WS_InfoDocumento.
     * 
     * @return idAggregatoContenitore
     */
    public java.lang.String getIdAggregatoContenitore() {
        return idAggregatoContenitore;
    }


    /**
     * Sets the idAggregatoContenitore value for this WS_InfoDocumento.
     * 
     * @param idAggregatoContenitore
     */
    public void setIdAggregatoContenitore(java.lang.String idAggregatoContenitore) {
        this.idAggregatoContenitore = idAggregatoContenitore;
    }


    /**
     * Gets the idDocumento value for this WS_InfoDocumento.
     * 
     * @return idDocumento
     */
    public java.lang.String getIdDocumento() {
        return idDocumento;
    }


    /**
     * Sets the idDocumento value for this WS_InfoDocumento.
     * 
     * @param idDocumento
     */
    public void setIdDocumento(java.lang.String idDocumento) {
        this.idDocumento = idDocumento;
    }


    /**
     * Gets the idDocumentoPadre value for this WS_InfoDocumento.
     * 
     * @return idDocumentoPadre
     */
    public java.lang.String getIdDocumentoPadre() {
        return idDocumentoPadre;
    }


    /**
     * Sets the idDocumentoPadre value for this WS_InfoDocumento.
     * 
     * @param idDocumentoPadre
     */
    public void setIdDocumentoPadre(java.lang.String idDocumentoPadre) {
        this.idDocumentoPadre = idDocumentoPadre;
    }


    /**
     * Gets the idVersione value for this WS_InfoDocumento.
     * 
     * @return idVersione
     */
    public java.lang.String getIdVersione() {
        return idVersione;
    }


    /**
     * Sets the idVersione value for this WS_InfoDocumento.
     * 
     * @param idVersione
     */
    public void setIdVersione(java.lang.String idVersione) {
        this.idVersione = idVersione;
    }


    /**
     * Gets the numVersione value for this WS_InfoDocumento.
     * 
     * @return numVersione
     */
    public java.lang.String getNumVersione() {
        return numVersione;
    }


    /**
     * Sets the numVersione value for this WS_InfoDocumento.
     * 
     * @param numVersione
     */
    public void setNumVersione(java.lang.String numVersione) {
        this.numVersione = numVersione;
    }


    /**
     * Gets the tipoDocumento value for this WS_InfoDocumento.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this WS_InfoDocumento.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the titolo value for this WS_InfoDocumento.
     * 
     * @return titolo
     */
    public java.lang.String getTitolo() {
        return titolo;
    }


    /**
     * Sets the titolo value for this WS_InfoDocumento.
     * 
     * @param titolo
     */
    public void setTitolo(java.lang.String titolo) {
        this.titolo = titolo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_InfoDocumento)) return false;
        WS_InfoDocumento other = (WS_InfoDocumento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autore==null && other.getAutore()==null) || 
             (this.autore!=null &&
              this.autore.equals(other.getAutore()))) &&
            ((this.dataCreazione==null && other.getDataCreazione()==null) || 
             (this.dataCreazione!=null &&
              this.dataCreazione.equals(other.getDataCreazione()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.idAggregatoContenitore==null && other.getIdAggregatoContenitore()==null) || 
             (this.idAggregatoContenitore!=null &&
              this.idAggregatoContenitore.equals(other.getIdAggregatoContenitore()))) &&
            ((this.idDocumento==null && other.getIdDocumento()==null) || 
             (this.idDocumento!=null &&
              this.idDocumento.equals(other.getIdDocumento()))) &&
            ((this.idDocumentoPadre==null && other.getIdDocumentoPadre()==null) || 
             (this.idDocumentoPadre!=null &&
              this.idDocumentoPadre.equals(other.getIdDocumentoPadre()))) &&
            ((this.idVersione==null && other.getIdVersione()==null) || 
             (this.idVersione!=null &&
              this.idVersione.equals(other.getIdVersione()))) &&
            ((this.numVersione==null && other.getNumVersione()==null) || 
             (this.numVersione!=null &&
              this.numVersione.equals(other.getNumVersione()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            ((this.titolo==null && other.getTitolo()==null) || 
             (this.titolo!=null &&
              this.titolo.equals(other.getTitolo())));
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
        if (getAutore() != null) {
            _hashCode += getAutore().hashCode();
        }
        if (getDataCreazione() != null) {
            _hashCode += getDataCreazione().hashCode();
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getIdAggregatoContenitore() != null) {
            _hashCode += getIdAggregatoContenitore().hashCode();
        }
        if (getIdDocumento() != null) {
            _hashCode += getIdDocumento().hashCode();
        }
        if (getIdDocumentoPadre() != null) {
            _hashCode += getIdDocumentoPadre().hashCode();
        }
        if (getIdVersione() != null) {
            _hashCode += getIdVersione().hashCode();
        }
        if (getNumVersione() != null) {
            _hashCode += getNumVersione().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        if (getTitolo() != null) {
            _hashCode += getTitolo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_InfoDocumento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_InfoDocumento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "autore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataCreazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataCreazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "fileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAggregatoContenitore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idAggregatoContenitore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumentoPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idDocumentoPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idVersione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idVersione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numVersione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "numVersione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "titolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
