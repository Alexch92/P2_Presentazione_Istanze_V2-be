/**
 * Procedimento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Procedimento  implements java.io.Serializable {
    private java.lang.String codiceAmministrazione;

    private java.lang.String codiceAOO;

    private java.lang.String identificativo;

    private java.lang.String tipoProcedimento;

    private java.lang.String oggetto;

    private it.sincon.gepred.protocollo.scatel.bean.Classifica[] classifica;

    private it.sincon.gepred.protocollo.scatel.bean.Responsabile responsabile;

    private java.lang.String dataAvvio;

    private java.lang.String dataTermine;

    private java.lang.String note;

    private org.apache.axis.types.Id id;  // attribute

    private org.apache.axis.types.IDRef rife;  // attribute

    public Procedimento() {
    }

    public Procedimento(
           java.lang.String codiceAmministrazione,
           java.lang.String codiceAOO,
           java.lang.String identificativo,
           java.lang.String tipoProcedimento,
           java.lang.String oggetto,
           it.sincon.gepred.protocollo.scatel.bean.Classifica[] classifica,
           it.sincon.gepred.protocollo.scatel.bean.Responsabile responsabile,
           java.lang.String dataAvvio,
           java.lang.String dataTermine,
           java.lang.String note,
           org.apache.axis.types.Id id,
           org.apache.axis.types.IDRef rife) {
           this.codiceAmministrazione = codiceAmministrazione;
           this.codiceAOO = codiceAOO;
           this.identificativo = identificativo;
           this.tipoProcedimento = tipoProcedimento;
           this.oggetto = oggetto;
           this.classifica = classifica;
           this.responsabile = responsabile;
           this.dataAvvio = dataAvvio;
           this.dataTermine = dataTermine;
           this.note = note;
           this.id = id;
           this.rife = rife;
    }


    /**
     * Gets the codiceAmministrazione value for this Procedimento.
     * 
     * @return codiceAmministrazione
     */
    public java.lang.String getCodiceAmministrazione() {
        return codiceAmministrazione;
    }


    /**
     * Sets the codiceAmministrazione value for this Procedimento.
     * 
     * @param codiceAmministrazione
     */
    public void setCodiceAmministrazione(java.lang.String codiceAmministrazione) {
        this.codiceAmministrazione = codiceAmministrazione;
    }


    /**
     * Gets the codiceAOO value for this Procedimento.
     * 
     * @return codiceAOO
     */
    public java.lang.String getCodiceAOO() {
        return codiceAOO;
    }


    /**
     * Sets the codiceAOO value for this Procedimento.
     * 
     * @param codiceAOO
     */
    public void setCodiceAOO(java.lang.String codiceAOO) {
        this.codiceAOO = codiceAOO;
    }


    /**
     * Gets the identificativo value for this Procedimento.
     * 
     * @return identificativo
     */
    public java.lang.String getIdentificativo() {
        return identificativo;
    }


    /**
     * Sets the identificativo value for this Procedimento.
     * 
     * @param identificativo
     */
    public void setIdentificativo(java.lang.String identificativo) {
        this.identificativo = identificativo;
    }


    /**
     * Gets the tipoProcedimento value for this Procedimento.
     * 
     * @return tipoProcedimento
     */
    public java.lang.String getTipoProcedimento() {
        return tipoProcedimento;
    }


    /**
     * Sets the tipoProcedimento value for this Procedimento.
     * 
     * @param tipoProcedimento
     */
    public void setTipoProcedimento(java.lang.String tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }


    /**
     * Gets the oggetto value for this Procedimento.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this Procedimento.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the classifica value for this Procedimento.
     * 
     * @return classifica
     */
    public it.sincon.gepred.protocollo.scatel.bean.Classifica[] getClassifica() {
        return classifica;
    }


    /**
     * Sets the classifica value for this Procedimento.
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
     * Gets the responsabile value for this Procedimento.
     * 
     * @return responsabile
     */
    public it.sincon.gepred.protocollo.scatel.bean.Responsabile getResponsabile() {
        return responsabile;
    }


    /**
     * Sets the responsabile value for this Procedimento.
     * 
     * @param responsabile
     */
    public void setResponsabile(it.sincon.gepred.protocollo.scatel.bean.Responsabile responsabile) {
        this.responsabile = responsabile;
    }


    /**
     * Gets the dataAvvio value for this Procedimento.
     * 
     * @return dataAvvio
     */
    public java.lang.String getDataAvvio() {
        return dataAvvio;
    }


    /**
     * Sets the dataAvvio value for this Procedimento.
     * 
     * @param dataAvvio
     */
    public void setDataAvvio(java.lang.String dataAvvio) {
        this.dataAvvio = dataAvvio;
    }


    /**
     * Gets the dataTermine value for this Procedimento.
     * 
     * @return dataTermine
     */
    public java.lang.String getDataTermine() {
        return dataTermine;
    }


    /**
     * Sets the dataTermine value for this Procedimento.
     * 
     * @param dataTermine
     */
    public void setDataTermine(java.lang.String dataTermine) {
        this.dataTermine = dataTermine;
    }


    /**
     * Gets the note value for this Procedimento.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this Procedimento.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the id value for this Procedimento.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this Procedimento.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the rife value for this Procedimento.
     * 
     * @return rife
     */
    public org.apache.axis.types.IDRef getRife() {
        return rife;
    }


    /**
     * Sets the rife value for this Procedimento.
     * 
     * @param rife
     */
    public void setRife(org.apache.axis.types.IDRef rife) {
        this.rife = rife;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Procedimento)) return false;
        Procedimento other = (Procedimento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codiceAmministrazione==null && other.getCodiceAmministrazione()==null) || 
             (this.codiceAmministrazione!=null &&
              this.codiceAmministrazione.equals(other.getCodiceAmministrazione()))) &&
            ((this.codiceAOO==null && other.getCodiceAOO()==null) || 
             (this.codiceAOO!=null &&
              this.codiceAOO.equals(other.getCodiceAOO()))) &&
            ((this.identificativo==null && other.getIdentificativo()==null) || 
             (this.identificativo!=null &&
              this.identificativo.equals(other.getIdentificativo()))) &&
            ((this.tipoProcedimento==null && other.getTipoProcedimento()==null) || 
             (this.tipoProcedimento!=null &&
              this.tipoProcedimento.equals(other.getTipoProcedimento()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.classifica==null && other.getClassifica()==null) || 
             (this.classifica!=null &&
              java.util.Arrays.equals(this.classifica, other.getClassifica()))) &&
            ((this.responsabile==null && other.getResponsabile()==null) || 
             (this.responsabile!=null &&
              this.responsabile.equals(other.getResponsabile()))) &&
            ((this.dataAvvio==null && other.getDataAvvio()==null) || 
             (this.dataAvvio!=null &&
              this.dataAvvio.equals(other.getDataAvvio()))) &&
            ((this.dataTermine==null && other.getDataTermine()==null) || 
             (this.dataTermine!=null &&
              this.dataTermine.equals(other.getDataTermine()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.rife==null && other.getRife()==null) || 
             (this.rife!=null &&
              this.rife.equals(other.getRife())));
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
        if (getCodiceAmministrazione() != null) {
            _hashCode += getCodiceAmministrazione().hashCode();
        }
        if (getCodiceAOO() != null) {
            _hashCode += getCodiceAOO().hashCode();
        }
        if (getIdentificativo() != null) {
            _hashCode += getIdentificativo().hashCode();
        }
        if (getTipoProcedimento() != null) {
            _hashCode += getTipoProcedimento().hashCode();
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
        if (getResponsabile() != null) {
            _hashCode += getResponsabile().hashCode();
        }
        if (getDataAvvio() != null) {
            _hashCode += getDataAvvio().hashCode();
        }
        if (getDataTermine() != null) {
            _hashCode += getDataTermine().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getRife() != null) {
            _hashCode += getRife().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Procedimento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Procedimento"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "ID"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rife");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rife"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "IDREF"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAmministrazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAmministrazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceAOO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CodiceAOO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identificativo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Identificativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "TipoProcedimento"));
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
        elemField.setFieldName("responsabile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Responsabile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Responsabile"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAvvio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DataAvvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataTermine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DataTermine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
