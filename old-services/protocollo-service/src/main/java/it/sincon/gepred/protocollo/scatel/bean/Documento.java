/**
 * Documento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Documento  implements java.io.Serializable {
    private java.lang.String collocazioneTelematica;

    private it.sincon.gepred.protocollo.scatel.bean.Impronta impronta;

    private it.sincon.gepred.protocollo.scatel.bean.ImprontaMIME improntaMIME;

    private java.lang.String titoloDocumento;

    private it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione;

    private java.lang.String tipoDocumento;

    private java.lang.String oggetto;

    private it.sincon.gepred.protocollo.scatel.bean.Classifica[] classifica;

    private java.lang.String numeroPagine;

    private java.lang.String note;

    private org.apache.axis.types.Id id;  // attribute

    private org.apache.axis.types.IDRef rife;  // attribute

    private java.lang.String nome;  // attribute

    private java.lang.String tipoMIME;  // attribute

    private it.sincon.gepred.protocollo.scatel.bean.DocumentoTipoRiferimento tipoRiferimento;  // attribute

    public Documento() {
    }

    public Documento(
           java.lang.String collocazioneTelematica,
           it.sincon.gepred.protocollo.scatel.bean.Impronta impronta,
           it.sincon.gepred.protocollo.scatel.bean.ImprontaMIME improntaMIME,
           java.lang.String titoloDocumento,
           it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione,
           java.lang.String tipoDocumento,
           java.lang.String oggetto,
           it.sincon.gepred.protocollo.scatel.bean.Classifica[] classifica,
           java.lang.String numeroPagine,
           java.lang.String note,
           org.apache.axis.types.Id id,
           org.apache.axis.types.IDRef rife,
           java.lang.String nome,
           java.lang.String tipoMIME,
           it.sincon.gepred.protocollo.scatel.bean.DocumentoTipoRiferimento tipoRiferimento) {
           this.collocazioneTelematica = collocazioneTelematica;
           this.impronta = impronta;
           this.improntaMIME = improntaMIME;
           this.titoloDocumento = titoloDocumento;
           this.primaRegistrazione = primaRegistrazione;
           this.tipoDocumento = tipoDocumento;
           this.oggetto = oggetto;
           this.classifica = classifica;
           this.numeroPagine = numeroPagine;
           this.note = note;
           this.id = id;
           this.rife = rife;
           this.nome = nome;
           this.tipoMIME = tipoMIME;
           this.tipoRiferimento = tipoRiferimento;
    }


    /**
     * Gets the collocazioneTelematica value for this Documento.
     * 
     * @return collocazioneTelematica
     */
    public java.lang.String getCollocazioneTelematica() {
        return collocazioneTelematica;
    }


    /**
     * Sets the collocazioneTelematica value for this Documento.
     * 
     * @param collocazioneTelematica
     */
    public void setCollocazioneTelematica(java.lang.String collocazioneTelematica) {
        this.collocazioneTelematica = collocazioneTelematica;
    }


    /**
     * Gets the impronta value for this Documento.
     * 
     * @return impronta
     */
    public it.sincon.gepred.protocollo.scatel.bean.Impronta getImpronta() {
        return impronta;
    }


    /**
     * Sets the impronta value for this Documento.
     * 
     * @param impronta
     */
    public void setImpronta(it.sincon.gepred.protocollo.scatel.bean.Impronta impronta) {
        this.impronta = impronta;
    }


    /**
     * Gets the improntaMIME value for this Documento.
     * 
     * @return improntaMIME
     */
    public it.sincon.gepred.protocollo.scatel.bean.ImprontaMIME getImprontaMIME() {
        return improntaMIME;
    }


    /**
     * Sets the improntaMIME value for this Documento.
     * 
     * @param improntaMIME
     */
    public void setImprontaMIME(it.sincon.gepred.protocollo.scatel.bean.ImprontaMIME improntaMIME) {
        this.improntaMIME = improntaMIME;
    }


    /**
     * Gets the titoloDocumento value for this Documento.
     * 
     * @return titoloDocumento
     */
    public java.lang.String getTitoloDocumento() {
        return titoloDocumento;
    }


    /**
     * Sets the titoloDocumento value for this Documento.
     * 
     * @param titoloDocumento
     */
    public void setTitoloDocumento(java.lang.String titoloDocumento) {
        this.titoloDocumento = titoloDocumento;
    }


    /**
     * Gets the primaRegistrazione value for this Documento.
     * 
     * @return primaRegistrazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione getPrimaRegistrazione() {
        return primaRegistrazione;
    }


    /**
     * Sets the primaRegistrazione value for this Documento.
     * 
     * @param primaRegistrazione
     */
    public void setPrimaRegistrazione(it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione) {
        this.primaRegistrazione = primaRegistrazione;
    }


    /**
     * Gets the tipoDocumento value for this Documento.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this Documento.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the oggetto value for this Documento.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this Documento.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the classifica value for this Documento.
     * 
     * @return classifica
     */
    public it.sincon.gepred.protocollo.scatel.bean.Classifica[] getClassifica() {
        return classifica;
    }


    /**
     * Sets the classifica value for this Documento.
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
     * Gets the numeroPagine value for this Documento.
     * 
     * @return numeroPagine
     */
    public java.lang.String getNumeroPagine() {
        return numeroPagine;
    }


    /**
     * Sets the numeroPagine value for this Documento.
     * 
     * @param numeroPagine
     */
    public void setNumeroPagine(java.lang.String numeroPagine) {
        this.numeroPagine = numeroPagine;
    }


    /**
     * Gets the note value for this Documento.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this Documento.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the id value for this Documento.
     * 
     * @return id
     */
    public org.apache.axis.types.Id getId() {
        return id;
    }


    /**
     * Sets the id value for this Documento.
     * 
     * @param id
     */
    public void setId(org.apache.axis.types.Id id) {
        this.id = id;
    }


    /**
     * Gets the rife value for this Documento.
     * 
     * @return rife
     */
    public org.apache.axis.types.IDRef getRife() {
        return rife;
    }


    /**
     * Sets the rife value for this Documento.
     * 
     * @param rife
     */
    public void setRife(org.apache.axis.types.IDRef rife) {
        this.rife = rife;
    }


    /**
     * Gets the nome value for this Documento.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Documento.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the tipoMIME value for this Documento.
     * 
     * @return tipoMIME
     */
    public java.lang.String getTipoMIME() {
        return tipoMIME;
    }


    /**
     * Sets the tipoMIME value for this Documento.
     * 
     * @param tipoMIME
     */
    public void setTipoMIME(java.lang.String tipoMIME) {
        this.tipoMIME = tipoMIME;
    }


    /**
     * Gets the tipoRiferimento value for this Documento.
     * 
     * @return tipoRiferimento
     */
    public it.sincon.gepred.protocollo.scatel.bean.DocumentoTipoRiferimento getTipoRiferimento() {
        return tipoRiferimento;
    }


    /**
     * Sets the tipoRiferimento value for this Documento.
     * 
     * @param tipoRiferimento
     */
    public void setTipoRiferimento(it.sincon.gepred.protocollo.scatel.bean.DocumentoTipoRiferimento tipoRiferimento) {
        this.tipoRiferimento = tipoRiferimento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Documento)) return false;
        Documento other = (Documento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.collocazioneTelematica==null && other.getCollocazioneTelematica()==null) || 
             (this.collocazioneTelematica!=null &&
              this.collocazioneTelematica.equals(other.getCollocazioneTelematica()))) &&
            ((this.impronta==null && other.getImpronta()==null) || 
             (this.impronta!=null &&
              this.impronta.equals(other.getImpronta()))) &&
            ((this.improntaMIME==null && other.getImprontaMIME()==null) || 
             (this.improntaMIME!=null &&
              this.improntaMIME.equals(other.getImprontaMIME()))) &&
            ((this.titoloDocumento==null && other.getTitoloDocumento()==null) || 
             (this.titoloDocumento!=null &&
              this.titoloDocumento.equals(other.getTitoloDocumento()))) &&
            ((this.primaRegistrazione==null && other.getPrimaRegistrazione()==null) || 
             (this.primaRegistrazione!=null &&
              this.primaRegistrazione.equals(other.getPrimaRegistrazione()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.classifica==null && other.getClassifica()==null) || 
             (this.classifica!=null &&
              java.util.Arrays.equals(this.classifica, other.getClassifica()))) &&
            ((this.numeroPagine==null && other.getNumeroPagine()==null) || 
             (this.numeroPagine!=null &&
              this.numeroPagine.equals(other.getNumeroPagine()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.rife==null && other.getRife()==null) || 
             (this.rife!=null &&
              this.rife.equals(other.getRife()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.tipoMIME==null && other.getTipoMIME()==null) || 
             (this.tipoMIME!=null &&
              this.tipoMIME.equals(other.getTipoMIME()))) &&
            ((this.tipoRiferimento==null && other.getTipoRiferimento()==null) || 
             (this.tipoRiferimento!=null &&
              this.tipoRiferimento.equals(other.getTipoRiferimento())));
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
        if (getCollocazioneTelematica() != null) {
            _hashCode += getCollocazioneTelematica().hashCode();
        }
        if (getImpronta() != null) {
            _hashCode += getImpronta().hashCode();
        }
        if (getImprontaMIME() != null) {
            _hashCode += getImprontaMIME().hashCode();
        }
        if (getTitoloDocumento() != null) {
            _hashCode += getTitoloDocumento().hashCode();
        }
        if (getPrimaRegistrazione() != null) {
            _hashCode += getPrimaRegistrazione().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
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
        if (getNumeroPagine() != null) {
            _hashCode += getNumeroPagine().hashCode();
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
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getTipoMIME() != null) {
            _hashCode += getTipoMIME().hashCode();
        }
        if (getTipoRiferimento() != null) {
            _hashCode += getTipoRiferimento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Documento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Documento"));
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
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("nome");
        attrField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tipoMIME");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tipoMIME"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tipoRiferimento");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tipoRiferimento"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">>Documento>tipoRiferimento"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("collocazioneTelematica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "CollocazioneTelematica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("impronta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Impronta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Impronta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("improntaMIME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ImprontaMIME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ImprontaMIME"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titoloDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "TitoloDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "TipoDocumento"));
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
        elemField.setFieldName("numeroPagine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroPagine"));
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
