/**
 * Intestazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Intestazione  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore;

    private it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione;

    private it.sincon.gepred.protocollo.scatel.bean.OraRegistrazione oraRegistrazione;

    private it.sincon.gepred.protocollo.scatel.bean.Origine origine;

    private it.sincon.gepred.protocollo.scatel.bean.Destinazione[] destinazione;

    private it.sincon.gepred.protocollo.scatel.bean.PerConoscenza[] perConoscenza;

    private java.lang.String riservato;

    private java.lang.String oggetto;

    private it.sincon.gepred.protocollo.scatel.bean.Classifica[] classifica;

    private java.lang.String note;

    public Intestazione() {
    }

    public Intestazione(
           it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore,
           it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione,
           it.sincon.gepred.protocollo.scatel.bean.OraRegistrazione oraRegistrazione,
           it.sincon.gepred.protocollo.scatel.bean.Origine origine,
           it.sincon.gepred.protocollo.scatel.bean.Destinazione[] destinazione,
           it.sincon.gepred.protocollo.scatel.bean.PerConoscenza[] perConoscenza,
           java.lang.String riservato,
           java.lang.String oggetto,
           it.sincon.gepred.protocollo.scatel.bean.Classifica[] classifica,
           java.lang.String note) {
           this.identificatore = identificatore;
           this.primaRegistrazione = primaRegistrazione;
           this.oraRegistrazione = oraRegistrazione;
           this.origine = origine;
           this.destinazione = destinazione;
           this.perConoscenza = perConoscenza;
           this.riservato = riservato;
           this.oggetto = oggetto;
           this.classifica = classifica;
           this.note = note;
    }


    /**
     * Gets the identificatore value for this Intestazione.
     * 
     * @return identificatore
     */
    public it.sincon.gepred.protocollo.scatel.bean.Identificatore getIdentificatore() {
        return identificatore;
    }


    /**
     * Sets the identificatore value for this Intestazione.
     * 
     * @param identificatore
     */
    public void setIdentificatore(it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore) {
        this.identificatore = identificatore;
    }


    /**
     * Gets the primaRegistrazione value for this Intestazione.
     * 
     * @return primaRegistrazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione getPrimaRegistrazione() {
        return primaRegistrazione;
    }


    /**
     * Sets the primaRegistrazione value for this Intestazione.
     * 
     * @param primaRegistrazione
     */
    public void setPrimaRegistrazione(it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione) {
        this.primaRegistrazione = primaRegistrazione;
    }


    /**
     * Gets the oraRegistrazione value for this Intestazione.
     * 
     * @return oraRegistrazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.OraRegistrazione getOraRegistrazione() {
        return oraRegistrazione;
    }


    /**
     * Sets the oraRegistrazione value for this Intestazione.
     * 
     * @param oraRegistrazione
     */
    public void setOraRegistrazione(it.sincon.gepred.protocollo.scatel.bean.OraRegistrazione oraRegistrazione) {
        this.oraRegistrazione = oraRegistrazione;
    }


    /**
     * Gets the origine value for this Intestazione.
     * 
     * @return origine
     */
    public it.sincon.gepred.protocollo.scatel.bean.Origine getOrigine() {
        return origine;
    }


    /**
     * Sets the origine value for this Intestazione.
     * 
     * @param origine
     */
    public void setOrigine(it.sincon.gepred.protocollo.scatel.bean.Origine origine) {
        this.origine = origine;
    }


    /**
     * Gets the destinazione value for this Intestazione.
     * 
     * @return destinazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.Destinazione[] getDestinazione() {
        return destinazione;
    }


    /**
     * Sets the destinazione value for this Intestazione.
     * 
     * @param destinazione
     */
    public void setDestinazione(it.sincon.gepred.protocollo.scatel.bean.Destinazione[] destinazione) {
        this.destinazione = destinazione;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Destinazione getDestinazione(int i) {
        return this.destinazione[i];
    }

    public void setDestinazione(int i, it.sincon.gepred.protocollo.scatel.bean.Destinazione _value) {
        this.destinazione[i] = _value;
    }


    /**
     * Gets the perConoscenza value for this Intestazione.
     * 
     * @return perConoscenza
     */
    public it.sincon.gepred.protocollo.scatel.bean.PerConoscenza[] getPerConoscenza() {
        return perConoscenza;
    }


    /**
     * Sets the perConoscenza value for this Intestazione.
     * 
     * @param perConoscenza
     */
    public void setPerConoscenza(it.sincon.gepred.protocollo.scatel.bean.PerConoscenza[] perConoscenza) {
        this.perConoscenza = perConoscenza;
    }

    public it.sincon.gepred.protocollo.scatel.bean.PerConoscenza getPerConoscenza(int i) {
        return this.perConoscenza[i];
    }

    public void setPerConoscenza(int i, it.sincon.gepred.protocollo.scatel.bean.PerConoscenza _value) {
        this.perConoscenza[i] = _value;
    }


    /**
     * Gets the riservato value for this Intestazione.
     * 
     * @return riservato
     */
    public java.lang.String getRiservato() {
        return riservato;
    }


    /**
     * Sets the riservato value for this Intestazione.
     * 
     * @param riservato
     */
    public void setRiservato(java.lang.String riservato) {
        this.riservato = riservato;
    }


    /**
     * Gets the oggetto value for this Intestazione.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this Intestazione.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the classifica value for this Intestazione.
     * 
     * @return classifica
     */
    public it.sincon.gepred.protocollo.scatel.bean.Classifica[] getClassifica() {
        return classifica;
    }


    /**
     * Sets the classifica value for this Intestazione.
     * 
     * @param classifica
     */
    public void setClassifica(it.sincon.gepred.protocollo.scatel.bean.Classifica[] classifica) {
        this.classifica = classifica;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Classifica getClassifica(int i) {
        return this.classifica[i];
    }

    public void setClassifica(int i, it.sincon.gepred.protocollo.scatel.bean.Classifica _value) {
        this.classifica[i] = _value;
    }


    /**
     * Gets the note value for this Intestazione.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this Intestazione.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Intestazione)) return false;
        Intestazione other = (Intestazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.identificatore==null && other.getIdentificatore()==null) || 
             (this.identificatore!=null &&
              this.identificatore.equals(other.getIdentificatore()))) &&
            ((this.primaRegistrazione==null && other.getPrimaRegistrazione()==null) || 
             (this.primaRegistrazione!=null &&
              this.primaRegistrazione.equals(other.getPrimaRegistrazione()))) &&
            ((this.oraRegistrazione==null && other.getOraRegistrazione()==null) || 
             (this.oraRegistrazione!=null &&
              this.oraRegistrazione.equals(other.getOraRegistrazione()))) &&
            ((this.origine==null && other.getOrigine()==null) || 
             (this.origine!=null &&
              this.origine.equals(other.getOrigine()))) &&
            ((this.destinazione==null && other.getDestinazione()==null) || 
             (this.destinazione!=null &&
              java.util.Arrays.equals(this.destinazione, other.getDestinazione()))) &&
            ((this.perConoscenza==null && other.getPerConoscenza()==null) || 
             (this.perConoscenza!=null &&
              java.util.Arrays.equals(this.perConoscenza, other.getPerConoscenza()))) &&
            ((this.riservato==null && other.getRiservato()==null) || 
             (this.riservato!=null &&
              this.riservato.equals(other.getRiservato()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.classifica==null && other.getClassifica()==null) || 
             (this.classifica!=null &&
              java.util.Arrays.equals(this.classifica, other.getClassifica()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote())));
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
        if (getIdentificatore() != null) {
            _hashCode += getIdentificatore().hashCode();
        }
        if (getPrimaRegistrazione() != null) {
            _hashCode += getPrimaRegistrazione().hashCode();
        }
        if (getOraRegistrazione() != null) {
            _hashCode += getOraRegistrazione().hashCode();
        }
        if (getOrigine() != null) {
            _hashCode += getOrigine().hashCode();
        }
        if (getDestinazione() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDestinazione());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDestinazione(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPerConoscenza() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPerConoscenza());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPerConoscenza(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRiservato() != null) {
            _hashCode += getRiservato().hashCode();
        }
        if (getOggetto() != null) {
            _hashCode += getOggetto().hashCode();
        }
        if (getClassifica() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClassifica());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClassifica(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Intestazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Intestazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificatore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Identificatore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Identificatore"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaRegistrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "PrimaRegistrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">PrimaRegistrazione"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oraRegistrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "OraRegistrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">OraRegistrazione"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Origine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Origine"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Destinazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Destinazione"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perConoscenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "PerConoscenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "PerConoscenza"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riservato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Riservato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Oggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classifica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Classifica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Classifica"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Note"));
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
