/**
 * Appuntamento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class Appuntamento  implements java.io.Serializable {
    private java.lang.String idAppuntamento;

    private java.lang.String statoAppuntamento;

    private java.lang.String dataAppuntamento;

    private java.lang.String oraAppuntamento;

    private java.lang.String dataModificaStato;

    private java.lang.String codiceBranca;

    private it.puglia.sanita.cup.Unita unita;

    private it.puglia.sanita.cup.Sede sede;

    private it.puglia.sanita.cup.Prestazione[] listaPrestazioni;

    public Appuntamento() {
    }

    public Appuntamento(
           java.lang.String idAppuntamento,
           java.lang.String statoAppuntamento,
           java.lang.String dataAppuntamento,
           java.lang.String oraAppuntamento,
           java.lang.String dataModificaStato,
           java.lang.String codiceBranca,
           it.puglia.sanita.cup.Unita unita,
           it.puglia.sanita.cup.Sede sede,
           it.puglia.sanita.cup.Prestazione[] listaPrestazioni) {
           this.idAppuntamento = idAppuntamento;
           this.statoAppuntamento = statoAppuntamento;
           this.dataAppuntamento = dataAppuntamento;
           this.oraAppuntamento = oraAppuntamento;
           this.dataModificaStato = dataModificaStato;
           this.codiceBranca = codiceBranca;
           this.unita = unita;
           this.sede = sede;
           this.listaPrestazioni = listaPrestazioni;
    }


    /**
     * Gets the idAppuntamento value for this Appuntamento.
     * 
     * @return idAppuntamento
     */
    public java.lang.String getIdAppuntamento() {
        return idAppuntamento;
    }


    /**
     * Sets the idAppuntamento value for this Appuntamento.
     * 
     * @param idAppuntamento
     */
    public void setIdAppuntamento(java.lang.String idAppuntamento) {
        this.idAppuntamento = idAppuntamento;
    }


    /**
     * Gets the statoAppuntamento value for this Appuntamento.
     * 
     * @return statoAppuntamento
     */
    public java.lang.String getStatoAppuntamento() {
        return statoAppuntamento;
    }


    /**
     * Sets the statoAppuntamento value for this Appuntamento.
     * 
     * @param statoAppuntamento
     */
    public void setStatoAppuntamento(java.lang.String statoAppuntamento) {
        this.statoAppuntamento = statoAppuntamento;
    }


    /**
     * Gets the dataAppuntamento value for this Appuntamento.
     * 
     * @return dataAppuntamento
     */
    public java.lang.String getDataAppuntamento() {
        return dataAppuntamento;
    }


    /**
     * Sets the dataAppuntamento value for this Appuntamento.
     * 
     * @param dataAppuntamento
     */
    public void setDataAppuntamento(java.lang.String dataAppuntamento) {
        this.dataAppuntamento = dataAppuntamento;
    }


    /**
     * Gets the oraAppuntamento value for this Appuntamento.
     * 
     * @return oraAppuntamento
     */
    public java.lang.String getOraAppuntamento() {
        return oraAppuntamento;
    }


    /**
     * Sets the oraAppuntamento value for this Appuntamento.
     * 
     * @param oraAppuntamento
     */
    public void setOraAppuntamento(java.lang.String oraAppuntamento) {
        this.oraAppuntamento = oraAppuntamento;
    }


    /**
     * Gets the dataModificaStato value for this Appuntamento.
     * 
     * @return dataModificaStato
     */
    public java.lang.String getDataModificaStato() {
        return dataModificaStato;
    }


    /**
     * Sets the dataModificaStato value for this Appuntamento.
     * 
     * @param dataModificaStato
     */
    public void setDataModificaStato(java.lang.String dataModificaStato) {
        this.dataModificaStato = dataModificaStato;
    }


    /**
     * Gets the codiceBranca value for this Appuntamento.
     * 
     * @return codiceBranca
     */
    public java.lang.String getCodiceBranca() {
        return codiceBranca;
    }


    /**
     * Sets the codiceBranca value for this Appuntamento.
     * 
     * @param codiceBranca
     */
    public void setCodiceBranca(java.lang.String codiceBranca) {
        this.codiceBranca = codiceBranca;
    }


    /**
     * Gets the unita value for this Appuntamento.
     * 
     * @return unita
     */
    public it.puglia.sanita.cup.Unita getUnita() {
        return unita;
    }


    /**
     * Sets the unita value for this Appuntamento.
     * 
     * @param unita
     */
    public void setUnita(it.puglia.sanita.cup.Unita unita) {
        this.unita = unita;
    }


    /**
     * Gets the sede value for this Appuntamento.
     * 
     * @return sede
     */
    public it.puglia.sanita.cup.Sede getSede() {
        return sede;
    }


    /**
     * Sets the sede value for this Appuntamento.
     * 
     * @param sede
     */
    public void setSede(it.puglia.sanita.cup.Sede sede) {
        this.sede = sede;
    }


    /**
     * Gets the listaPrestazioni value for this Appuntamento.
     * 
     * @return listaPrestazioni
     */
    public it.puglia.sanita.cup.Prestazione[] getListaPrestazioni() {
        return listaPrestazioni;
    }


    /**
     * Sets the listaPrestazioni value for this Appuntamento.
     * 
     * @param listaPrestazioni
     */
    public void setListaPrestazioni(it.puglia.sanita.cup.Prestazione[] listaPrestazioni) {
        this.listaPrestazioni = listaPrestazioni;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Appuntamento)) return false;
        Appuntamento other = (Appuntamento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idAppuntamento==null && other.getIdAppuntamento()==null) || 
             (this.idAppuntamento!=null &&
              this.idAppuntamento.equals(other.getIdAppuntamento()))) &&
            ((this.statoAppuntamento==null && other.getStatoAppuntamento()==null) || 
             (this.statoAppuntamento!=null &&
              this.statoAppuntamento.equals(other.getStatoAppuntamento()))) &&
            ((this.dataAppuntamento==null && other.getDataAppuntamento()==null) || 
             (this.dataAppuntamento!=null &&
              this.dataAppuntamento.equals(other.getDataAppuntamento()))) &&
            ((this.oraAppuntamento==null && other.getOraAppuntamento()==null) || 
             (this.oraAppuntamento!=null &&
              this.oraAppuntamento.equals(other.getOraAppuntamento()))) &&
            ((this.dataModificaStato==null && other.getDataModificaStato()==null) || 
             (this.dataModificaStato!=null &&
              this.dataModificaStato.equals(other.getDataModificaStato()))) &&
            ((this.codiceBranca==null && other.getCodiceBranca()==null) || 
             (this.codiceBranca!=null &&
              this.codiceBranca.equals(other.getCodiceBranca()))) &&
            ((this.unita==null && other.getUnita()==null) || 
             (this.unita!=null &&
              this.unita.equals(other.getUnita()))) &&
            ((this.sede==null && other.getSede()==null) || 
             (this.sede!=null &&
              this.sede.equals(other.getSede()))) &&
            ((this.listaPrestazioni==null && other.getListaPrestazioni()==null) || 
             (this.listaPrestazioni!=null &&
              java.util.Arrays.equals(this.listaPrestazioni, other.getListaPrestazioni())));
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
        if (getIdAppuntamento() != null) {
            _hashCode += getIdAppuntamento().hashCode();
        }
        if (getStatoAppuntamento() != null) {
            _hashCode += getStatoAppuntamento().hashCode();
        }
        if (getDataAppuntamento() != null) {
            _hashCode += getDataAppuntamento().hashCode();
        }
        if (getOraAppuntamento() != null) {
            _hashCode += getOraAppuntamento().hashCode();
        }
        if (getDataModificaStato() != null) {
            _hashCode += getDataModificaStato().hashCode();
        }
        if (getCodiceBranca() != null) {
            _hashCode += getCodiceBranca().hashCode();
        }
        if (getUnita() != null) {
            _hashCode += getUnita().hashCode();
        }
        if (getSede() != null) {
            _hashCode += getSede().hashCode();
        }
        if (getListaPrestazioni() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPrestazioni());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPrestazioni(), i);
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
        new org.apache.axis.description.TypeDesc(Appuntamento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAppuntamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idAppuntamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statoAppuntamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "statoAppuntamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAppuntamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "dataAppuntamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oraAppuntamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "oraAppuntamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataModificaStato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "dataModificaStato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceBranca");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "codiceBranca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "unita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Unita"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sede");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "sede"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Sede"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPrestazioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "listaPrestazioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prestazione"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "prestazione"));
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
