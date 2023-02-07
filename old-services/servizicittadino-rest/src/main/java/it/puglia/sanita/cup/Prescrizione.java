/**
 * Prescrizione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class Prescrizione  implements java.io.Serializable {
    private java.lang.String numPrescrizione;

    private java.lang.String idPrescrizione;

    private java.lang.String idPrescrizioneRmt;

    private java.lang.String convenzione;

    private java.lang.String tipoPrescrizione;

    private java.lang.String tipoErogazione;

    private java.lang.String numeroImpegnativa;

    private java.lang.String dataImpegnativa;

    private java.lang.String codiceEsenzione;

    private java.lang.String classePriorita;

    private java.lang.String costoPrescrizione;

    private it.puglia.sanita.cup.Prestazione[] listaPrestazioni;

    private it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti;

    public Prescrizione() {
    }

    public Prescrizione(
           java.lang.String numPrescrizione,
           java.lang.String idPrescrizione,
           java.lang.String idPrescrizioneRmt,
           java.lang.String convenzione,
           java.lang.String tipoPrescrizione,
           java.lang.String tipoErogazione,
           java.lang.String numeroImpegnativa,
           java.lang.String dataImpegnativa,
           java.lang.String codiceEsenzione,
           java.lang.String classePriorita,
           java.lang.String costoPrescrizione,
           it.puglia.sanita.cup.Prestazione[] listaPrestazioni,
           it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti) {
           this.numPrescrizione = numPrescrizione;
           this.idPrescrizione = idPrescrizione;
           this.idPrescrizioneRmt = idPrescrizioneRmt;
           this.convenzione = convenzione;
           this.tipoPrescrizione = tipoPrescrizione;
           this.tipoErogazione = tipoErogazione;
           this.numeroImpegnativa = numeroImpegnativa;
           this.dataImpegnativa = dataImpegnativa;
           this.codiceEsenzione = codiceEsenzione;
           this.classePriorita = classePriorita;
           this.costoPrescrizione = costoPrescrizione;
           this.listaPrestazioni = listaPrestazioni;
           this.listaAppuntamenti = listaAppuntamenti;
    }


    /**
     * Gets the numPrescrizione value for this Prescrizione.
     * 
     * @return numPrescrizione
     */
    public java.lang.String getNumPrescrizione() {
        return numPrescrizione;
    }


    /**
     * Sets the numPrescrizione value for this Prescrizione.
     * 
     * @param numPrescrizione
     */
    public void setNumPrescrizione(java.lang.String numPrescrizione) {
        this.numPrescrizione = numPrescrizione;
    }


    /**
     * Gets the idPrescrizione value for this Prescrizione.
     * 
     * @return idPrescrizione
     */
    public java.lang.String getIdPrescrizione() {
        return idPrescrizione;
    }


    /**
     * Sets the idPrescrizione value for this Prescrizione.
     * 
     * @param idPrescrizione
     */
    public void setIdPrescrizione(java.lang.String idPrescrizione) {
        this.idPrescrizione = idPrescrizione;
    }


    /**
     * Gets the idPrescrizioneRmt value for this Prescrizione.
     * 
     * @return idPrescrizioneRmt
     */
    public java.lang.String getIdPrescrizioneRmt() {
        return idPrescrizioneRmt;
    }


    /**
     * Sets the idPrescrizioneRmt value for this Prescrizione.
     * 
     * @param idPrescrizioneRmt
     */
    public void setIdPrescrizioneRmt(java.lang.String idPrescrizioneRmt) {
        this.idPrescrizioneRmt = idPrescrizioneRmt;
    }


    /**
     * Gets the convenzione value for this Prescrizione.
     * 
     * @return convenzione
     */
    public java.lang.String getConvenzione() {
        return convenzione;
    }


    /**
     * Sets the convenzione value for this Prescrizione.
     * 
     * @param convenzione
     */
    public void setConvenzione(java.lang.String convenzione) {
        this.convenzione = convenzione;
    }


    /**
     * Gets the tipoPrescrizione value for this Prescrizione.
     * 
     * @return tipoPrescrizione
     */
    public java.lang.String getTipoPrescrizione() {
        return tipoPrescrizione;
    }


    /**
     * Sets the tipoPrescrizione value for this Prescrizione.
     * 
     * @param tipoPrescrizione
     */
    public void setTipoPrescrizione(java.lang.String tipoPrescrizione) {
        this.tipoPrescrizione = tipoPrescrizione;
    }


    /**
     * Gets the tipoErogazione value for this Prescrizione.
     * 
     * @return tipoErogazione
     */
    public java.lang.String getTipoErogazione() {
        return tipoErogazione;
    }


    /**
     * Sets the tipoErogazione value for this Prescrizione.
     * 
     * @param tipoErogazione
     */
    public void setTipoErogazione(java.lang.String tipoErogazione) {
        this.tipoErogazione = tipoErogazione;
    }


    /**
     * Gets the numeroImpegnativa value for this Prescrizione.
     * 
     * @return numeroImpegnativa
     */
    public java.lang.String getNumeroImpegnativa() {
        return numeroImpegnativa;
    }


    /**
     * Sets the numeroImpegnativa value for this Prescrizione.
     * 
     * @param numeroImpegnativa
     */
    public void setNumeroImpegnativa(java.lang.String numeroImpegnativa) {
        this.numeroImpegnativa = numeroImpegnativa;
    }


    /**
     * Gets the dataImpegnativa value for this Prescrizione.
     * 
     * @return dataImpegnativa
     */
    public java.lang.String getDataImpegnativa() {
        return dataImpegnativa;
    }


    /**
     * Sets the dataImpegnativa value for this Prescrizione.
     * 
     * @param dataImpegnativa
     */
    public void setDataImpegnativa(java.lang.String dataImpegnativa) {
        this.dataImpegnativa = dataImpegnativa;
    }


    /**
     * Gets the codiceEsenzione value for this Prescrizione.
     * 
     * @return codiceEsenzione
     */
    public java.lang.String getCodiceEsenzione() {
        return codiceEsenzione;
    }


    /**
     * Sets the codiceEsenzione value for this Prescrizione.
     * 
     * @param codiceEsenzione
     */
    public void setCodiceEsenzione(java.lang.String codiceEsenzione) {
        this.codiceEsenzione = codiceEsenzione;
    }


    /**
     * Gets the classePriorita value for this Prescrizione.
     * 
     * @return classePriorita
     */
    public java.lang.String getClassePriorita() {
        return classePriorita;
    }


    /**
     * Sets the classePriorita value for this Prescrizione.
     * 
     * @param classePriorita
     */
    public void setClassePriorita(java.lang.String classePriorita) {
        this.classePriorita = classePriorita;
    }


    /**
     * Gets the costoPrescrizione value for this Prescrizione.
     * 
     * @return costoPrescrizione
     */
    public java.lang.String getCostoPrescrizione() {
        return costoPrescrizione;
    }


    /**
     * Sets the costoPrescrizione value for this Prescrizione.
     * 
     * @param costoPrescrizione
     */
    public void setCostoPrescrizione(java.lang.String costoPrescrizione) {
        this.costoPrescrizione = costoPrescrizione;
    }


    /**
     * Gets the listaPrestazioni value for this Prescrizione.
     * 
     * @return listaPrestazioni
     */
    public it.puglia.sanita.cup.Prestazione[] getListaPrestazioni() {
        return listaPrestazioni;
    }


    /**
     * Sets the listaPrestazioni value for this Prescrizione.
     * 
     * @param listaPrestazioni
     */
    public void setListaPrestazioni(it.puglia.sanita.cup.Prestazione[] listaPrestazioni) {
        this.listaPrestazioni = listaPrestazioni;
    }


    /**
     * Gets the listaAppuntamenti value for this Prescrizione.
     * 
     * @return listaAppuntamenti
     */
    public it.puglia.sanita.cup.Appuntamento[] getListaAppuntamenti() {
        return listaAppuntamenti;
    }


    /**
     * Sets the listaAppuntamenti value for this Prescrizione.
     * 
     * @param listaAppuntamenti
     */
    public void setListaAppuntamenti(it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti) {
        this.listaAppuntamenti = listaAppuntamenti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Prescrizione)) return false;
        Prescrizione other = (Prescrizione) obj;
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
            ((this.idPrescrizione==null && other.getIdPrescrizione()==null) || 
             (this.idPrescrizione!=null &&
              this.idPrescrizione.equals(other.getIdPrescrizione()))) &&
            ((this.idPrescrizioneRmt==null && other.getIdPrescrizioneRmt()==null) || 
             (this.idPrescrizioneRmt!=null &&
              this.idPrescrizioneRmt.equals(other.getIdPrescrizioneRmt()))) &&
            ((this.convenzione==null && other.getConvenzione()==null) || 
             (this.convenzione!=null &&
              this.convenzione.equals(other.getConvenzione()))) &&
            ((this.tipoPrescrizione==null && other.getTipoPrescrizione()==null) || 
             (this.tipoPrescrizione!=null &&
              this.tipoPrescrizione.equals(other.getTipoPrescrizione()))) &&
            ((this.tipoErogazione==null && other.getTipoErogazione()==null) || 
             (this.tipoErogazione!=null &&
              this.tipoErogazione.equals(other.getTipoErogazione()))) &&
            ((this.numeroImpegnativa==null && other.getNumeroImpegnativa()==null) || 
             (this.numeroImpegnativa!=null &&
              this.numeroImpegnativa.equals(other.getNumeroImpegnativa()))) &&
            ((this.dataImpegnativa==null && other.getDataImpegnativa()==null) || 
             (this.dataImpegnativa!=null &&
              this.dataImpegnativa.equals(other.getDataImpegnativa()))) &&
            ((this.codiceEsenzione==null && other.getCodiceEsenzione()==null) || 
             (this.codiceEsenzione!=null &&
              this.codiceEsenzione.equals(other.getCodiceEsenzione()))) &&
            ((this.classePriorita==null && other.getClassePriorita()==null) || 
             (this.classePriorita!=null &&
              this.classePriorita.equals(other.getClassePriorita()))) &&
            ((this.costoPrescrizione==null && other.getCostoPrescrizione()==null) || 
             (this.costoPrescrizione!=null &&
              this.costoPrescrizione.equals(other.getCostoPrescrizione()))) &&
            ((this.listaPrestazioni==null && other.getListaPrestazioni()==null) || 
             (this.listaPrestazioni!=null &&
              java.util.Arrays.equals(this.listaPrestazioni, other.getListaPrestazioni()))) &&
            ((this.listaAppuntamenti==null && other.getListaAppuntamenti()==null) || 
             (this.listaAppuntamenti!=null &&
              java.util.Arrays.equals(this.listaAppuntamenti, other.getListaAppuntamenti())));
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
        if (getIdPrescrizione() != null) {
            _hashCode += getIdPrescrizione().hashCode();
        }
        if (getIdPrescrizioneRmt() != null) {
            _hashCode += getIdPrescrizioneRmt().hashCode();
        }
        if (getConvenzione() != null) {
            _hashCode += getConvenzione().hashCode();
        }
        if (getTipoPrescrizione() != null) {
            _hashCode += getTipoPrescrizione().hashCode();
        }
        if (getTipoErogazione() != null) {
            _hashCode += getTipoErogazione().hashCode();
        }
        if (getNumeroImpegnativa() != null) {
            _hashCode += getNumeroImpegnativa().hashCode();
        }
        if (getDataImpegnativa() != null) {
            _hashCode += getDataImpegnativa().hashCode();
        }
        if (getCodiceEsenzione() != null) {
            _hashCode += getCodiceEsenzione().hashCode();
        }
        if (getClassePriorita() != null) {
            _hashCode += getClassePriorita().hashCode();
        }
        if (getCostoPrescrizione() != null) {
            _hashCode += getCostoPrescrizione().hashCode();
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
        if (getListaAppuntamenti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaAppuntamenti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaAppuntamenti(), i);
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
        new org.apache.axis.description.TypeDesc(Prescrizione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prescrizione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPrescrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "numPrescrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPrescrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idPrescrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPrescrizioneRmt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idPrescrizioneRmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("convenzione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "convenzione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoPrescrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "tipoPrescrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoErogazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "tipoErogazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroImpegnativa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "numeroImpegnativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataImpegnativa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "dataImpegnativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceEsenzione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "codiceEsenzione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classePriorita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "classePriorita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costoPrescrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "costoPrescrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaAppuntamenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "listaAppuntamenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "appuntamento"));
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
