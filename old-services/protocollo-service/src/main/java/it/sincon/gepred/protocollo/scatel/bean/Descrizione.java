/**
 * Descrizione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Descrizione  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Documento documento;

    private it.sincon.gepred.protocollo.scatel.bean.Allegati[] allegati;

    private java.lang.String note;

    public Descrizione() {
    }

    public Descrizione(
           it.sincon.gepred.protocollo.scatel.bean.Documento documento,
           it.sincon.gepred.protocollo.scatel.bean.Allegati[] allegati,
           java.lang.String note) {
           this.documento = documento;
           this.allegati = allegati;
           this.note = note;
    }


    /**
     * Gets the documento value for this Descrizione.
     * 
     * @return documento
     */
    public it.sincon.gepred.protocollo.scatel.bean.Documento getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this Descrizione.
     * 
     * @param documento
     */
    public void setDocumento(it.sincon.gepred.protocollo.scatel.bean.Documento documento) {
        this.documento = documento;
    }


    /**
     * Gets the allegati value for this Descrizione.
     * 
     * @return allegati
     */
    public it.sincon.gepred.protocollo.scatel.bean.Allegati[] getAllegati() {
        return allegati;
    }


    /**
     * Sets the allegati value for this Descrizione.
     * 
     * @param allegati
     */
    public void setAllegati(it.sincon.gepred.protocollo.scatel.bean.Allegati[] allegati) {
        this.allegati = allegati;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Allegati getAllegati(int i) {
        return this.allegati[i];
    }

    public void setAllegati(int i, it.sincon.gepred.protocollo.scatel.bean.Allegati _value) {
        this.allegati[i] = _value;
    }


    /**
     * Gets the note value for this Descrizione.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this Descrizione.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Descrizione)) return false;
        Descrizione other = (Descrizione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              this.documento.equals(other.getDocumento()))) &&
            ((this.allegati==null && other.getAllegati()==null) || 
             (this.allegati!=null &&
              java.util.Arrays.equals(this.allegati, other.getAllegati()))) &&
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
        if (getDocumento() != null) {
            _hashCode += getDocumento().hashCode();
        }
        if (getAllegati() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAllegati());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAllegati(), i);
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
        new org.apache.axis.description.TypeDesc(Descrizione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Descrizione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Documento"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allegati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Allegati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Allegati"));
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
