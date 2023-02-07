/**
 * Prestazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class Prestazione  implements java.io.Serializable {
    private java.lang.String numPrescrizione;

    private java.lang.String idPrestazione;

    private java.lang.String idPrestazioneRmt;

    private java.lang.String statoPrestazione;

    private java.lang.String codicePrestazione;

    private java.lang.String costoPrestazione;

    private java.lang.String compEsePatologia;

    private java.lang.String descrizionePrestazione;

    private java.lang.String dataModificaStatoPre;

    private java.lang.String idDisdettaPre;

    public Prestazione() {
    }

    public Prestazione(
           java.lang.String numPrescrizione,
           java.lang.String idPrestazione,
           java.lang.String idPrestazioneRmt,
           java.lang.String statoPrestazione,
           java.lang.String codicePrestazione,
           java.lang.String costoPrestazione,
           java.lang.String compEsePatologia,
           java.lang.String descrizionePrestazione,
           java.lang.String dataModificaStatoPre,
           java.lang.String idDisdettaPre) {
           this.numPrescrizione = numPrescrizione;
           this.idPrestazione = idPrestazione;
           this.idPrestazioneRmt = idPrestazioneRmt;
           this.statoPrestazione = statoPrestazione;
           this.codicePrestazione = codicePrestazione;
           this.costoPrestazione = costoPrestazione;
           this.compEsePatologia = compEsePatologia;
           this.descrizionePrestazione = descrizionePrestazione;
           this.dataModificaStatoPre = dataModificaStatoPre;
           this.idDisdettaPre = idDisdettaPre;
    }


    /**
     * Gets the numPrescrizione value for this Prestazione.
     * 
     * @return numPrescrizione
     */
    public java.lang.String getNumPrescrizione() {
        return numPrescrizione;
    }


    /**
     * Sets the numPrescrizione value for this Prestazione.
     * 
     * @param numPrescrizione
     */
    public void setNumPrescrizione(java.lang.String numPrescrizione) {
        this.numPrescrizione = numPrescrizione;
    }


    /**
     * Gets the idPrestazione value for this Prestazione.
     * 
     * @return idPrestazione
     */
    public java.lang.String getIdPrestazione() {
        return idPrestazione;
    }


    /**
     * Sets the idPrestazione value for this Prestazione.
     * 
     * @param idPrestazione
     */
    public void setIdPrestazione(java.lang.String idPrestazione) {
        this.idPrestazione = idPrestazione;
    }


    /**
     * Gets the idPrestazioneRmt value for this Prestazione.
     * 
     * @return idPrestazioneRmt
     */
    public java.lang.String getIdPrestazioneRmt() {
        return idPrestazioneRmt;
    }


    /**
     * Sets the idPrestazioneRmt value for this Prestazione.
     * 
     * @param idPrestazioneRmt
     */
    public void setIdPrestazioneRmt(java.lang.String idPrestazioneRmt) {
        this.idPrestazioneRmt = idPrestazioneRmt;
    }


    /**
     * Gets the statoPrestazione value for this Prestazione.
     * 
     * @return statoPrestazione
     */
    public java.lang.String getStatoPrestazione() {
        return statoPrestazione;
    }


    /**
     * Sets the statoPrestazione value for this Prestazione.
     * 
     * @param statoPrestazione
     */
    public void setStatoPrestazione(java.lang.String statoPrestazione) {
        this.statoPrestazione = statoPrestazione;
    }


    /**
     * Gets the codicePrestazione value for this Prestazione.
     * 
     * @return codicePrestazione
     */
    public java.lang.String getCodicePrestazione() {
        return codicePrestazione;
    }


    /**
     * Sets the codicePrestazione value for this Prestazione.
     * 
     * @param codicePrestazione
     */
    public void setCodicePrestazione(java.lang.String codicePrestazione) {
        this.codicePrestazione = codicePrestazione;
    }


    /**
     * Gets the costoPrestazione value for this Prestazione.
     * 
     * @return costoPrestazione
     */
    public java.lang.String getCostoPrestazione() {
        return costoPrestazione;
    }


    /**
     * Sets the costoPrestazione value for this Prestazione.
     * 
     * @param costoPrestazione
     */
    public void setCostoPrestazione(java.lang.String costoPrestazione) {
        this.costoPrestazione = costoPrestazione;
    }


    /**
     * Gets the compEsePatologia value for this Prestazione.
     * 
     * @return compEsePatologia
     */
    public java.lang.String getCompEsePatologia() {
        return compEsePatologia;
    }


    /**
     * Sets the compEsePatologia value for this Prestazione.
     * 
     * @param compEsePatologia
     */
    public void setCompEsePatologia(java.lang.String compEsePatologia) {
        this.compEsePatologia = compEsePatologia;
    }


    /**
     * Gets the descrizionePrestazione value for this Prestazione.
     * 
     * @return descrizionePrestazione
     */
    public java.lang.String getDescrizionePrestazione() {
        return descrizionePrestazione;
    }


    /**
     * Sets the descrizionePrestazione value for this Prestazione.
     * 
     * @param descrizionePrestazione
     */
    public void setDescrizionePrestazione(java.lang.String descrizionePrestazione) {
        this.descrizionePrestazione = descrizionePrestazione;
    }


    /**
     * Gets the dataModificaStatoPre value for this Prestazione.
     * 
     * @return dataModificaStatoPre
     */
    public java.lang.String getDataModificaStatoPre() {
        return dataModificaStatoPre;
    }


    /**
     * Sets the dataModificaStatoPre value for this Prestazione.
     * 
     * @param dataModificaStatoPre
     */
    public void setDataModificaStatoPre(java.lang.String dataModificaStatoPre) {
        this.dataModificaStatoPre = dataModificaStatoPre;
    }


    /**
     * Gets the idDisdettaPre value for this Prestazione.
     * 
     * @return idDisdettaPre
     */
    public java.lang.String getIdDisdettaPre() {
        return idDisdettaPre;
    }


    /**
     * Sets the idDisdettaPre value for this Prestazione.
     * 
     * @param idDisdettaPre
     */
    public void setIdDisdettaPre(java.lang.String idDisdettaPre) {
        this.idDisdettaPre = idDisdettaPre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prestazione)) return false;
        Prestazione other = (Prestazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numPrescrizione==null && other.getNumPrescrizione()==null) || 
             (this.numPrescrizione!=null &&
              this.numPrescrizione.equals(other.getNumPrescrizione()))) &&
            ((this.idPrestazione==null && other.getIdPrestazione()==null) || 
             (this.idPrestazione!=null &&
              this.idPrestazione.equals(other.getIdPrestazione()))) &&
            ((this.idPrestazioneRmt==null && other.getIdPrestazioneRmt()==null) || 
             (this.idPrestazioneRmt!=null &&
              this.idPrestazioneRmt.equals(other.getIdPrestazioneRmt()))) &&
            ((this.statoPrestazione==null && other.getStatoPrestazione()==null) || 
             (this.statoPrestazione!=null &&
              this.statoPrestazione.equals(other.getStatoPrestazione()))) &&
            ((this.codicePrestazione==null && other.getCodicePrestazione()==null) || 
             (this.codicePrestazione!=null &&
              this.codicePrestazione.equals(other.getCodicePrestazione()))) &&
            ((this.costoPrestazione==null && other.getCostoPrestazione()==null) || 
             (this.costoPrestazione!=null &&
              this.costoPrestazione.equals(other.getCostoPrestazione()))) &&
            ((this.compEsePatologia==null && other.getCompEsePatologia()==null) || 
             (this.compEsePatologia!=null &&
              this.compEsePatologia.equals(other.getCompEsePatologia()))) &&
            ((this.descrizionePrestazione==null && other.getDescrizionePrestazione()==null) || 
             (this.descrizionePrestazione!=null &&
              this.descrizionePrestazione.equals(other.getDescrizionePrestazione()))) &&
            ((this.dataModificaStatoPre==null && other.getDataModificaStatoPre()==null) || 
             (this.dataModificaStatoPre!=null &&
              this.dataModificaStatoPre.equals(other.getDataModificaStatoPre()))) &&
            ((this.idDisdettaPre==null && other.getIdDisdettaPre()==null) || 
             (this.idDisdettaPre!=null &&
              this.idDisdettaPre.equals(other.getIdDisdettaPre())));
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
        if (getNumPrescrizione() != null) {
            _hashCode += getNumPrescrizione().hashCode();
        }
        if (getIdPrestazione() != null) {
            _hashCode += getIdPrestazione().hashCode();
        }
        if (getIdPrestazioneRmt() != null) {
            _hashCode += getIdPrestazioneRmt().hashCode();
        }
        if (getStatoPrestazione() != null) {
            _hashCode += getStatoPrestazione().hashCode();
        }
        if (getCodicePrestazione() != null) {
            _hashCode += getCodicePrestazione().hashCode();
        }
        if (getCostoPrestazione() != null) {
            _hashCode += getCostoPrestazione().hashCode();
        }
        if (getCompEsePatologia() != null) {
            _hashCode += getCompEsePatologia().hashCode();
        }
        if (getDescrizionePrestazione() != null) {
            _hashCode += getDescrizionePrestazione().hashCode();
        }
        if (getDataModificaStatoPre() != null) {
            _hashCode += getDataModificaStatoPre().hashCode();
        }
        if (getIdDisdettaPre() != null) {
            _hashCode += getIdDisdettaPre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Prestazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prestazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPrescrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "numPrescrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPrestazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idPrestazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPrestazioneRmt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idPrestazioneRmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoPrestazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "statoPrestazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codicePrestazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "codicePrestazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costoPrestazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "costoPrestazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compEsePatologia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "compEsePatologia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizionePrestazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "descrizionePrestazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataModificaStatoPre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "dataModificaStatoPre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDisdettaPre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idDisdettaPre"));
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
