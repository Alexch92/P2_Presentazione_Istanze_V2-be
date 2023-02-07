/**
 * WS_FascicoloTemporaneo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_FascicoloTemporaneo  extends it.sincon.gepred.documentale.diogene.bean.WS_Aggregato  implements java.io.Serializable {
    private java.lang.String annotazioni;

    private java.lang.String codice;

    private java.lang.String dataFine;

    private java.lang.String dataInizio;

    private java.lang.String descrizione;

    private java.lang.String idTitolario;

    private java.lang.String idVoceTitolario;

    public WS_FascicoloTemporaneo() {
    }

    public WS_FascicoloTemporaneo(
           java.lang.String dataCreazione,
           java.lang.String idAggregato,
           java.lang.String idPadre,
           java.lang.String nomeAggregato,
           java.lang.String owner,
           java.lang.String path,
           it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi,
           java.lang.String stato,
           java.lang.String tipoAggregato,
           java.lang.String annotazioni,
           java.lang.String codice,
           java.lang.String dataFine,
           java.lang.String dataInizio,
           java.lang.String descrizione,
           java.lang.String idTitolario,
           java.lang.String idVoceTitolario) {
        super(
            dataCreazione,
            idAggregato,
            idPadre,
            nomeAggregato,
            owner,
            path,
            permessi,
            stato,
            tipoAggregato);
        this.annotazioni = annotazioni;
        this.codice = codice;
        this.dataFine = dataFine;
        this.dataInizio = dataInizio;
        this.descrizione = descrizione;
        this.idTitolario = idTitolario;
        this.idVoceTitolario = idVoceTitolario;
    }


    /**
     * Gets the annotazioni value for this WS_FascicoloTemporaneo.
     * 
     * @return annotazioni
     */
    public java.lang.String getAnnotazioni() {
        return annotazioni;
    }


    /**
     * Sets the annotazioni value for this WS_FascicoloTemporaneo.
     * 
     * @param annotazioni
     */
    public void setAnnotazioni(java.lang.String annotazioni) {
        this.annotazioni = annotazioni;
    }


    /**
     * Gets the codice value for this WS_FascicoloTemporaneo.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this WS_FascicoloTemporaneo.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }


    /**
     * Gets the dataFine value for this WS_FascicoloTemporaneo.
     * 
     * @return dataFine
     */
    public java.lang.String getDataFine() {
        return dataFine;
    }


    /**
     * Sets the dataFine value for this WS_FascicoloTemporaneo.
     * 
     * @param dataFine
     */
    public void setDataFine(java.lang.String dataFine) {
        this.dataFine = dataFine;
    }


    /**
     * Gets the dataInizio value for this WS_FascicoloTemporaneo.
     * 
     * @return dataInizio
     */
    public java.lang.String getDataInizio() {
        return dataInizio;
    }


    /**
     * Sets the dataInizio value for this WS_FascicoloTemporaneo.
     * 
     * @param dataInizio
     */
    public void setDataInizio(java.lang.String dataInizio) {
        this.dataInizio = dataInizio;
    }


    /**
     * Gets the descrizione value for this WS_FascicoloTemporaneo.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_FascicoloTemporaneo.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the idTitolario value for this WS_FascicoloTemporaneo.
     * 
     * @return idTitolario
     */
    public java.lang.String getIdTitolario() {
        return idTitolario;
    }


    /**
     * Sets the idTitolario value for this WS_FascicoloTemporaneo.
     * 
     * @param idTitolario
     */
    public void setIdTitolario(java.lang.String idTitolario) {
        this.idTitolario = idTitolario;
    }


    /**
     * Gets the idVoceTitolario value for this WS_FascicoloTemporaneo.
     * 
     * @return idVoceTitolario
     */
    public java.lang.String getIdVoceTitolario() {
        return idVoceTitolario;
    }


    /**
     * Sets the idVoceTitolario value for this WS_FascicoloTemporaneo.
     * 
     * @param idVoceTitolario
     */
    public void setIdVoceTitolario(java.lang.String idVoceTitolario) {
        this.idVoceTitolario = idVoceTitolario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_FascicoloTemporaneo)) return false;
        WS_FascicoloTemporaneo other = (WS_FascicoloTemporaneo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.annotazioni==null && other.getAnnotazioni()==null) || 
             (this.annotazioni!=null &&
              this.annotazioni.equals(other.getAnnotazioni()))) &&
            ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice()))) &&
            ((this.dataFine==null && other.getDataFine()==null) || 
             (this.dataFine!=null &&
              this.dataFine.equals(other.getDataFine()))) &&
            ((this.dataInizio==null && other.getDataInizio()==null) || 
             (this.dataInizio!=null &&
              this.dataInizio.equals(other.getDataInizio()))) &&
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.idTitolario==null && other.getIdTitolario()==null) || 
             (this.idTitolario!=null &&
              this.idTitolario.equals(other.getIdTitolario()))) &&
            ((this.idVoceTitolario==null && other.getIdVoceTitolario()==null) || 
             (this.idVoceTitolario!=null &&
              this.idVoceTitolario.equals(other.getIdVoceTitolario())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAnnotazioni() != null) {
            _hashCode += getAnnotazioni().hashCode();
        }
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        if (getDataFine() != null) {
            _hashCode += getDataFine().hashCode();
        }
        if (getDataInizio() != null) {
            _hashCode += getDataInizio().hashCode();
        }
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getIdTitolario() != null) {
            _hashCode += getIdTitolario().hashCode();
        }
        if (getIdVoceTitolario() != null) {
            _hashCode += getIdVoceTitolario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_FascicoloTemporaneo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FascicoloTemporaneo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotazioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "annotazioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "codice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataFine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInizio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataInizio"));
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
        elemField.setFieldName("idTitolario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idTitolario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idVoceTitolario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idVoceTitolario"));
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
