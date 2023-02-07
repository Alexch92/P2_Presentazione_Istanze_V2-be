/**
 * WS_RicercaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_RicercaType  implements java.io.Serializable {
    private java.lang.String autore;

    private java.lang.String descrizione;

    private java.lang.String fileName;

    private java.lang.String nome;

    private java.lang.String stato;

    private java.lang.String[] tipoOggetti;

    public WS_RicercaType() {
    }

    public WS_RicercaType(
           java.lang.String autore,
           java.lang.String descrizione,
           java.lang.String fileName,
           java.lang.String nome,
           java.lang.String stato,
           java.lang.String[] tipoOggetti) {
           this.autore = autore;
           this.descrizione = descrizione;
           this.fileName = fileName;
           this.nome = nome;
           this.stato = stato;
           this.tipoOggetti = tipoOggetti;
    }


    /**
     * Gets the autore value for this WS_RicercaType.
     * 
     * @return autore
     */
    public java.lang.String getAutore() {
        return autore;
    }


    /**
     * Sets the autore value for this WS_RicercaType.
     * 
     * @param autore
     */
    public void setAutore(java.lang.String autore) {
        this.autore = autore;
    }


    /**
     * Gets the descrizione value for this WS_RicercaType.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_RicercaType.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the fileName value for this WS_RicercaType.
     * 
     * @return fileName
     */
    public java.lang.String getFileName() {
        return fileName;
    }


    /**
     * Sets the fileName value for this WS_RicercaType.
     * 
     * @param fileName
     */
    public void setFileName(java.lang.String fileName) {
        this.fileName = fileName;
    }


    /**
     * Gets the nome value for this WS_RicercaType.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this WS_RicercaType.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the stato value for this WS_RicercaType.
     * 
     * @return stato
     */
    public java.lang.String getStato() {
        return stato;
    }


    /**
     * Sets the stato value for this WS_RicercaType.
     * 
     * @param stato
     */
    public void setStato(java.lang.String stato) {
        this.stato = stato;
    }


    /**
     * Gets the tipoOggetti value for this WS_RicercaType.
     * 
     * @return tipoOggetti
     */
    public java.lang.String[] getTipoOggetti() {
        return tipoOggetti;
    }


    /**
     * Sets the tipoOggetti value for this WS_RicercaType.
     * 
     * @param tipoOggetti
     */
    public void setTipoOggetti(java.lang.String[] tipoOggetti) {
        this.tipoOggetti = tipoOggetti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_RicercaType)) return false;
        WS_RicercaType other = (WS_RicercaType) obj;
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
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.fileName==null && other.getFileName()==null) || 
             (this.fileName!=null &&
              this.fileName.equals(other.getFileName()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.stato==null && other.getStato()==null) || 
             (this.stato!=null &&
              this.stato.equals(other.getStato()))) &&
            ((this.tipoOggetti==null && other.getTipoOggetti()==null) || 
             (this.tipoOggetti!=null &&
              java.util.Arrays.equals(this.tipoOggetti, other.getTipoOggetti())));
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
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getFileName() != null) {
            _hashCode += getFileName().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getStato() != null) {
            _hashCode += getStato().hashCode();
        }
        if (getTipoOggetti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTipoOggetti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTipoOggetti(), i);
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
        new org.apache.axis.description.TypeDesc(WS_RicercaType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_RicercaType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "autore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "descrizione"));
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
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "stato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOggetti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipoOggetti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item"));
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
