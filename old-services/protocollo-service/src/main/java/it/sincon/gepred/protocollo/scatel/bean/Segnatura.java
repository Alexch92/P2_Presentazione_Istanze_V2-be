/**
 * Segnatura.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Segnatura  implements java.io.Serializable {
    private java.lang.String inOut;

    private it.sincon.gepred.protocollo.scatel.bean.Intestazione intestazione;

    private it.sincon.gepred.protocollo.scatel.bean.Riferimenti riferimenti;

    private it.sincon.gepred.protocollo.scatel.bean.Descrizione descrizione;

    private java.lang.String tipoOperazione;

    private java.lang.String utenteOperazione;

    private java.lang.String dataModifica;

    private java.lang.String provvedimentoModifica;

    private it.sincon.gepred.protocollo.scatel.bean.ProtocolloMittente protocolloMittente;

    private it.sincon.gepred.protocollo.scatel.bean.ProtocolloEmergenza protocolloEmergenza;

    private java.lang.String dataArrivo;

    private java.lang.String riferimentoArrivo;

    private org.apache.axis.types.NMToken versione;  // attribute

    private java.lang.Object lang;  // attribute

    public Segnatura() {
    }

    public Segnatura(
           java.lang.String inOut,
           it.sincon.gepred.protocollo.scatel.bean.Intestazione intestazione,
           it.sincon.gepred.protocollo.scatel.bean.Riferimenti riferimenti,
           it.sincon.gepred.protocollo.scatel.bean.Descrizione descrizione,
           java.lang.String tipoOperazione,
           java.lang.String utenteOperazione,
           java.lang.String dataModifica,
           java.lang.String provvedimentoModifica,
           it.sincon.gepred.protocollo.scatel.bean.ProtocolloMittente protocolloMittente,
           it.sincon.gepred.protocollo.scatel.bean.ProtocolloEmergenza protocolloEmergenza,
           java.lang.String dataArrivo,
           java.lang.String riferimentoArrivo,
           org.apache.axis.types.NMToken versione,
           java.lang.Object lang) {
           this.inOut = inOut;
           this.intestazione = intestazione;
           this.riferimenti = riferimenti;
           this.descrizione = descrizione;
           this.tipoOperazione = tipoOperazione;
           this.utenteOperazione = utenteOperazione;
           this.dataModifica = dataModifica;
           this.provvedimentoModifica = provvedimentoModifica;
           this.protocolloMittente = protocolloMittente;
           this.protocolloEmergenza = protocolloEmergenza;
           this.dataArrivo = dataArrivo;
           this.riferimentoArrivo = riferimentoArrivo;
           this.versione = versione;
           this.lang = lang;
    }


    /**
     * Gets the inOut value for this Segnatura.
     * 
     * @return inOut
     */
    public java.lang.String getInOut() {
        return inOut;
    }


    /**
     * Sets the inOut value for this Segnatura.
     * 
     * @param inOut
     */
    public void setInOut(java.lang.String inOut) {
        this.inOut = inOut;
    }


    /**
     * Gets the intestazione value for this Segnatura.
     * 
     * @return intestazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.Intestazione getIntestazione() {
        return intestazione;
    }


    /**
     * Sets the intestazione value for this Segnatura.
     * 
     * @param intestazione
     */
    public void setIntestazione(it.sincon.gepred.protocollo.scatel.bean.Intestazione intestazione) {
        this.intestazione = intestazione;
    }


    /**
     * Gets the riferimenti value for this Segnatura.
     * 
     * @return riferimenti
     */
    public it.sincon.gepred.protocollo.scatel.bean.Riferimenti getRiferimenti() {
        return riferimenti;
    }


    /**
     * Sets the riferimenti value for this Segnatura.
     * 
     * @param riferimenti
     */
    public void setRiferimenti(it.sincon.gepred.protocollo.scatel.bean.Riferimenti riferimenti) {
        this.riferimenti = riferimenti;
    }


    /**
     * Gets the descrizione value for this Segnatura.
     * 
     * @return descrizione
     */
    public it.sincon.gepred.protocollo.scatel.bean.Descrizione getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this Segnatura.
     * 
     * @param descrizione
     */
    public void setDescrizione(it.sincon.gepred.protocollo.scatel.bean.Descrizione descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the tipoOperazione value for this Segnatura.
     * 
     * @return tipoOperazione
     */
    public java.lang.String getTipoOperazione() {
        return tipoOperazione;
    }


    /**
     * Sets the tipoOperazione value for this Segnatura.
     * 
     * @param tipoOperazione
     */
    public void setTipoOperazione(java.lang.String tipoOperazione) {
        this.tipoOperazione = tipoOperazione;
    }


    /**
     * Gets the utenteOperazione value for this Segnatura.
     * 
     * @return utenteOperazione
     */
    public java.lang.String getUtenteOperazione() {
        return utenteOperazione;
    }


    /**
     * Sets the utenteOperazione value for this Segnatura.
     * 
     * @param utenteOperazione
     */
    public void setUtenteOperazione(java.lang.String utenteOperazione) {
        this.utenteOperazione = utenteOperazione;
    }


    /**
     * Gets the dataModifica value for this Segnatura.
     * 
     * @return dataModifica
     */
    public java.lang.String getDataModifica() {
        return dataModifica;
    }


    /**
     * Sets the dataModifica value for this Segnatura.
     * 
     * @param dataModifica
     */
    public void setDataModifica(java.lang.String dataModifica) {
        this.dataModifica = dataModifica;
    }


    /**
     * Gets the provvedimentoModifica value for this Segnatura.
     * 
     * @return provvedimentoModifica
     */
    public java.lang.String getProvvedimentoModifica() {
        return provvedimentoModifica;
    }


    /**
     * Sets the provvedimentoModifica value for this Segnatura.
     * 
     * @param provvedimentoModifica
     */
    public void setProvvedimentoModifica(java.lang.String provvedimentoModifica) {
        this.provvedimentoModifica = provvedimentoModifica;
    }


    /**
     * Gets the protocolloMittente value for this Segnatura.
     * 
     * @return protocolloMittente
     */
    public it.sincon.gepred.protocollo.scatel.bean.ProtocolloMittente getProtocolloMittente() {
        return protocolloMittente;
    }


    /**
     * Sets the protocolloMittente value for this Segnatura.
     * 
     * @param protocolloMittente
     */
    public void setProtocolloMittente(it.sincon.gepred.protocollo.scatel.bean.ProtocolloMittente protocolloMittente) {
        this.protocolloMittente = protocolloMittente;
    }


    /**
     * Gets the protocolloEmergenza value for this Segnatura.
     * 
     * @return protocolloEmergenza
     */
    public it.sincon.gepred.protocollo.scatel.bean.ProtocolloEmergenza getProtocolloEmergenza() {
        return protocolloEmergenza;
    }


    /**
     * Sets the protocolloEmergenza value for this Segnatura.
     * 
     * @param protocolloEmergenza
     */
    public void setProtocolloEmergenza(it.sincon.gepred.protocollo.scatel.bean.ProtocolloEmergenza protocolloEmergenza) {
        this.protocolloEmergenza = protocolloEmergenza;
    }


    /**
     * Gets the dataArrivo value for this Segnatura.
     * 
     * @return dataArrivo
     */
    public java.lang.String getDataArrivo() {
        return dataArrivo;
    }


    /**
     * Sets the dataArrivo value for this Segnatura.
     * 
     * @param dataArrivo
     */
    public void setDataArrivo(java.lang.String dataArrivo) {
        this.dataArrivo = dataArrivo;
    }


    /**
     * Gets the riferimentoArrivo value for this Segnatura.
     * 
     * @return riferimentoArrivo
     */
    public java.lang.String getRiferimentoArrivo() {
        return riferimentoArrivo;
    }


    /**
     * Sets the riferimentoArrivo value for this Segnatura.
     * 
     * @param riferimentoArrivo
     */
    public void setRiferimentoArrivo(java.lang.String riferimentoArrivo) {
        this.riferimentoArrivo = riferimentoArrivo;
    }


    /**
     * Gets the versione value for this Segnatura.
     * 
     * @return versione
     */
    public org.apache.axis.types.NMToken getVersione() {
        return versione;
    }


    /**
     * Sets the versione value for this Segnatura.
     * 
     * @param versione
     */
    public void setVersione(org.apache.axis.types.NMToken versione) {
        this.versione = versione;
    }


    /**
     * Gets the lang value for this Segnatura.
     * 
     * @return lang
     */
    public java.lang.Object getLang() {
        return lang;
    }


    /**
     * Sets the lang value for this Segnatura.
     * 
     * @param lang
     */
    public void setLang(java.lang.Object lang) {
        this.lang = lang;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Segnatura)) return false;
        Segnatura other = (Segnatura) obj;
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
            ((this.intestazione==null && other.getIntestazione()==null) || 
             (this.intestazione!=null &&
              this.intestazione.equals(other.getIntestazione()))) &&
            ((this.riferimenti==null && other.getRiferimenti()==null) || 
             (this.riferimenti!=null &&
              this.riferimenti.equals(other.getRiferimenti()))) &&
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.tipoOperazione==null && other.getTipoOperazione()==null) || 
             (this.tipoOperazione!=null &&
              this.tipoOperazione.equals(other.getTipoOperazione()))) &&
            ((this.utenteOperazione==null && other.getUtenteOperazione()==null) || 
             (this.utenteOperazione!=null &&
              this.utenteOperazione.equals(other.getUtenteOperazione()))) &&
            ((this.dataModifica==null && other.getDataModifica()==null) || 
             (this.dataModifica!=null &&
              this.dataModifica.equals(other.getDataModifica()))) &&
            ((this.provvedimentoModifica==null && other.getProvvedimentoModifica()==null) || 
             (this.provvedimentoModifica!=null &&
              this.provvedimentoModifica.equals(other.getProvvedimentoModifica()))) &&
            ((this.protocolloMittente==null && other.getProtocolloMittente()==null) || 
             (this.protocolloMittente!=null &&
              this.protocolloMittente.equals(other.getProtocolloMittente()))) &&
            ((this.protocolloEmergenza==null && other.getProtocolloEmergenza()==null) || 
             (this.protocolloEmergenza!=null &&
              this.protocolloEmergenza.equals(other.getProtocolloEmergenza()))) &&
            ((this.dataArrivo==null && other.getDataArrivo()==null) || 
             (this.dataArrivo!=null &&
              this.dataArrivo.equals(other.getDataArrivo()))) &&
            ((this.riferimentoArrivo==null && other.getRiferimentoArrivo()==null) || 
             (this.riferimentoArrivo!=null &&
              this.riferimentoArrivo.equals(other.getRiferimentoArrivo()))) &&
            ((this.versione==null && other.getVersione()==null) || 
             (this.versione!=null &&
              this.versione.equals(other.getVersione()))) &&
            ((this.lang==null && other.getLang()==null) || 
             (this.lang!=null &&
              this.lang.equals(other.getLang())));
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
        if (getIntestazione() != null) {
            _hashCode += getIntestazione().hashCode();
        }
        if (getRiferimenti() != null) {
            _hashCode += getRiferimenti().hashCode();
        }
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getTipoOperazione() != null) {
            _hashCode += getTipoOperazione().hashCode();
        }
        if (getUtenteOperazione() != null) {
            _hashCode += getUtenteOperazione().hashCode();
        }
        if (getDataModifica() != null) {
            _hashCode += getDataModifica().hashCode();
        }
        if (getProvvedimentoModifica() != null) {
            _hashCode += getProvvedimentoModifica().hashCode();
        }
        if (getProtocolloMittente() != null) {
            _hashCode += getProtocolloMittente().hashCode();
        }
        if (getProtocolloEmergenza() != null) {
            _hashCode += getProtocolloEmergenza().hashCode();
        }
        if (getDataArrivo() != null) {
            _hashCode += getDataArrivo().hashCode();
        }
        if (getRiferimentoArrivo() != null) {
            _hashCode += getRiferimentoArrivo().hashCode();
        }
        if (getVersione() != null) {
            _hashCode += getVersione().hashCode();
        }
        if (getLang() != null) {
            _hashCode += getLang().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Segnatura.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Segnatura"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("versione");
        attrField.setXmlName(new javax.xml.namespace.QName("", "versione"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "NMTOKEN"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("lang");
        attrField.setXmlName(new javax.xml.namespace.QName("", "lang"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "InOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intestazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Intestazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Intestazione"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riferimenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Riferimenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Riferimenti"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Descrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Descrizione"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoOperazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "TipoOperazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("utenteOperazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "UtenteOperazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataModifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DataModifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provvedimentoModifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ProvvedimentoModifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocolloMittente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ProtocolloMittente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ProtocolloMittente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocolloEmergenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ProtocolloEmergenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ProtocolloEmergenza"));
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
        elemField.setFieldName("riferimentoArrivo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RiferimentoArrivo"));
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
