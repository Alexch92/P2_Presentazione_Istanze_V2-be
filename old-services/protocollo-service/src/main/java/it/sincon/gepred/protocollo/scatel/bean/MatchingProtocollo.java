/**
 * MatchingProtocollo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class MatchingProtocollo  implements java.io.Serializable {
    private java.lang.String inOut;

    private it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore;

    private java.lang.String oggetto;

    private java.lang.String corrispondente;

    private java.lang.Boolean annullato;

    private java.lang.String dataArrivo;

    private java.lang.String rifProtocolloMittente;

    public MatchingProtocollo() {
    }

    public MatchingProtocollo(
           java.lang.String inOut,
           it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore,
           java.lang.String oggetto,
           java.lang.String corrispondente,
           java.lang.Boolean annullato,
           java.lang.String dataArrivo,
           java.lang.String rifProtocolloMittente) {
           this.inOut = inOut;
           this.identificatore = identificatore;
           this.oggetto = oggetto;
           this.corrispondente = corrispondente;
           this.annullato = annullato;
           this.dataArrivo = dataArrivo;
           this.rifProtocolloMittente = rifProtocolloMittente;
    }


    /**
     * Gets the inOut value for this MatchingProtocollo.
     * 
     * @return inOut
     */
    public java.lang.String getInOut() {
        return inOut;
    }


    /**
     * Sets the inOut value for this MatchingProtocollo.
     * 
     * @param inOut
     */
    public void setInOut(java.lang.String inOut) {
        this.inOut = inOut;
    }


    /**
     * Gets the identificatore value for this MatchingProtocollo.
     * 
     * @return identificatore
     */
    public it.sincon.gepred.protocollo.scatel.bean.Identificatore getIdentificatore() {
        return identificatore;
    }


    /**
     * Sets the identificatore value for this MatchingProtocollo.
     * 
     * @param identificatore
     */
    public void setIdentificatore(it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore) {
        this.identificatore = identificatore;
    }


    /**
     * Gets the oggetto value for this MatchingProtocollo.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this MatchingProtocollo.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the corrispondente value for this MatchingProtocollo.
     * 
     * @return corrispondente
     */
    public java.lang.String getCorrispondente() {
        return corrispondente;
    }


    /**
     * Sets the corrispondente value for this MatchingProtocollo.
     * 
     * @param corrispondente
     */
    public void setCorrispondente(java.lang.String corrispondente) {
        this.corrispondente = corrispondente;
    }


    /**
     * Gets the annullato value for this MatchingProtocollo.
     * 
     * @return annullato
     */
    public java.lang.Boolean getAnnullato() {
        return annullato;
    }


    /**
     * Sets the annullato value for this MatchingProtocollo.
     * 
     * @param annullato
     */
    public void setAnnullato(java.lang.Boolean annullato) {
        this.annullato = annullato;
    }


    /**
     * Gets the dataArrivo value for this MatchingProtocollo.
     * 
     * @return dataArrivo
     */
    public java.lang.String getDataArrivo() {
        return dataArrivo;
    }


    /**
     * Sets the dataArrivo value for this MatchingProtocollo.
     * 
     * @param dataArrivo
     */
    public void setDataArrivo(java.lang.String dataArrivo) {
        this.dataArrivo = dataArrivo;
    }


    /**
     * Gets the rifProtocolloMittente value for this MatchingProtocollo.
     * 
     * @return rifProtocolloMittente
     */
    public java.lang.String getRifProtocolloMittente() {
        return rifProtocolloMittente;
    }


    /**
     * Sets the rifProtocolloMittente value for this MatchingProtocollo.
     * 
     * @param rifProtocolloMittente
     */
    public void setRifProtocolloMittente(java.lang.String rifProtocolloMittente) {
        this.rifProtocolloMittente = rifProtocolloMittente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MatchingProtocollo)) return false;
        MatchingProtocollo other = (MatchingProtocollo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inOut==null && other.getInOut()==null) || 
             (this.inOut!=null &&
              this.inOut.equals(other.getInOut()))) &&
            ((this.identificatore==null && other.getIdentificatore()==null) || 
             (this.identificatore!=null &&
              this.identificatore.equals(other.getIdentificatore()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.corrispondente==null && other.getCorrispondente()==null) || 
             (this.corrispondente!=null &&
              this.corrispondente.equals(other.getCorrispondente()))) &&
            ((this.annullato==null && other.getAnnullato()==null) || 
             (this.annullato!=null &&
              this.annullato.equals(other.getAnnullato()))) &&
            ((this.dataArrivo==null && other.getDataArrivo()==null) || 
             (this.dataArrivo!=null &&
              this.dataArrivo.equals(other.getDataArrivo()))) &&
            ((this.rifProtocolloMittente==null && other.getRifProtocolloMittente()==null) || 
             (this.rifProtocolloMittente!=null &&
              this.rifProtocolloMittente.equals(other.getRifProtocolloMittente())));
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
        if (getInOut() != null) {
            _hashCode += getInOut().hashCode();
        }
        if (getIdentificatore() != null) {
            _hashCode += getIdentificatore().hashCode();
        }
        if (getOggetto() != null) {
            _hashCode += getOggetto().hashCode();
        }
        if (getCorrispondente() != null) {
            _hashCode += getCorrispondente().hashCode();
        }
        if (getAnnullato() != null) {
            _hashCode += getAnnullato().hashCode();
        }
        if (getDataArrivo() != null) {
            _hashCode += getDataArrivo().hashCode();
        }
        if (getRifProtocolloMittente() != null) {
            _hashCode += getRifProtocolloMittente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MatchingProtocollo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">MatchingProtocollo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "InOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificatore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Identificatore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Identificatore"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Oggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corrispondente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Corrispondente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annullato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Annullato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataArrivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DataArrivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rifProtocolloMittente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RifProtocolloMittente"));
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
