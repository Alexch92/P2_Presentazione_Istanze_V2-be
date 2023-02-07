/**
 * WS_Protocollo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_Protocollo  implements java.io.Serializable {
    private java.lang.String anno;

    private java.lang.String aoo;

    private java.lang.String data;

    private java.lang.String destinatario;

    private java.lang.String idVoceTitolario;

    private java.lang.String mittente;

    private java.lang.String note;

    private java.lang.String numero;

    private java.lang.String oggetto;

    private java.lang.String tipoProtocollo;

    public WS_Protocollo() {
    }

    public WS_Protocollo(
           java.lang.String anno,
           java.lang.String aoo,
           java.lang.String data,
           java.lang.String destinatario,
           java.lang.String idVoceTitolario,
           java.lang.String mittente,
           java.lang.String note,
           java.lang.String numero,
           java.lang.String oggetto,
           java.lang.String tipoProtocollo) {
           this.anno = anno;
           this.aoo = aoo;
           this.data = data;
           this.destinatario = destinatario;
           this.idVoceTitolario = idVoceTitolario;
           this.mittente = mittente;
           this.note = note;
           this.numero = numero;
           this.oggetto = oggetto;
           this.tipoProtocollo = tipoProtocollo;
    }


    /**
     * Gets the anno value for this WS_Protocollo.
     * 
     * @return anno
     */
    public java.lang.String getAnno() {
        return anno;
    }


    /**
     * Sets the anno value for this WS_Protocollo.
     * 
     * @param anno
     */
    public void setAnno(java.lang.String anno) {
        this.anno = anno;
    }


    /**
     * Gets the aoo value for this WS_Protocollo.
     * 
     * @return aoo
     */
    public java.lang.String getAoo() {
        return aoo;
    }


    /**
     * Sets the aoo value for this WS_Protocollo.
     * 
     * @param aoo
     */
    public void setAoo(java.lang.String aoo) {
        this.aoo = aoo;
    }


    /**
     * Gets the data value for this WS_Protocollo.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this WS_Protocollo.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }


    /**
     * Gets the destinatario value for this WS_Protocollo.
     * 
     * @return destinatario
     */
    public java.lang.String getDestinatario() {
        return destinatario;
    }


    /**
     * Sets the destinatario value for this WS_Protocollo.
     * 
     * @param destinatario
     */
    public void setDestinatario(java.lang.String destinatario) {
        this.destinatario = destinatario;
    }


    /**
     * Gets the idVoceTitolario value for this WS_Protocollo.
     * 
     * @return idVoceTitolario
     */
    public java.lang.String getIdVoceTitolario() {
        return idVoceTitolario;
    }


    /**
     * Sets the idVoceTitolario value for this WS_Protocollo.
     * 
     * @param idVoceTitolario
     */
    public void setIdVoceTitolario(java.lang.String idVoceTitolario) {
        this.idVoceTitolario = idVoceTitolario;
    }


    /**
     * Gets the mittente value for this WS_Protocollo.
     * 
     * @return mittente
     */
    public java.lang.String getMittente() {
        return mittente;
    }


    /**
     * Sets the mittente value for this WS_Protocollo.
     * 
     * @param mittente
     */
    public void setMittente(java.lang.String mittente) {
        this.mittente = mittente;
    }


    /**
     * Gets the note value for this WS_Protocollo.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this WS_Protocollo.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the numero value for this WS_Protocollo.
     * 
     * @return numero
     */
    public java.lang.String getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this WS_Protocollo.
     * 
     * @param numero
     */
    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }


    /**
     * Gets the oggetto value for this WS_Protocollo.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this WS_Protocollo.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the tipoProtocollo value for this WS_Protocollo.
     * 
     * @return tipoProtocollo
     */
    public java.lang.String getTipoProtocollo() {
        return tipoProtocollo;
    }


    /**
     * Sets the tipoProtocollo value for this WS_Protocollo.
     * 
     * @param tipoProtocollo
     */
    public void setTipoProtocollo(java.lang.String tipoProtocollo) {
        this.tipoProtocollo = tipoProtocollo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_Protocollo)) return false;
        WS_Protocollo other = (WS_Protocollo) obj;
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
            ((this.aoo==null && other.getAoo()==null) || 
             (this.aoo!=null &&
              this.aoo.equals(other.getAoo()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.destinatario==null && other.getDestinatario()==null) || 
             (this.destinatario!=null &&
              this.destinatario.equals(other.getDestinatario()))) &&
            ((this.idVoceTitolario==null && other.getIdVoceTitolario()==null) || 
             (this.idVoceTitolario!=null &&
              this.idVoceTitolario.equals(other.getIdVoceTitolario()))) &&
            ((this.mittente==null && other.getMittente()==null) || 
             (this.mittente!=null &&
              this.mittente.equals(other.getMittente()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.numero==null && other.getNumero()==null) || 
             (this.numero!=null &&
              this.numero.equals(other.getNumero()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.tipoProtocollo==null && other.getTipoProtocollo()==null) || 
             (this.tipoProtocollo!=null &&
              this.tipoProtocollo.equals(other.getTipoProtocollo())));
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
        if (getAoo() != null) {
            _hashCode += getAoo().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getDestinatario() != null) {
            _hashCode += getDestinatario().hashCode();
        }
        if (getIdVoceTitolario() != null) {
            _hashCode += getIdVoceTitolario().hashCode();
        }
        if (getMittente() != null) {
            _hashCode += getMittente().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getNumero() != null) {
            _hashCode += getNumero().hashCode();
        }
        if (getOggetto() != null) {
            _hashCode += getOggetto().hashCode();
        }
        if (getTipoProtocollo() != null) {
            _hashCode += getTipoProtocollo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_Protocollo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Protocollo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "anno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aoo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "aoo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinatario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "destinatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idVoceTitolario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idVoceTitolario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mittente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "mittente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "oggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoProtocollo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipoProtocollo"));
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
