/**
 * MessaggioRicevuto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class MessaggioRicevuto  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore;

    private it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione;

    private java.lang.String descrizioneMessaggio;

    public MessaggioRicevuto() {
    }

    public MessaggioRicevuto(
           it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore,
           it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione,
           java.lang.String descrizioneMessaggio) {
           this.identificatore = identificatore;
           this.primaRegistrazione = primaRegistrazione;
           this.descrizioneMessaggio = descrizioneMessaggio;
    }


    /**
     * Gets the identificatore value for this MessaggioRicevuto.
     * 
     * @return identificatore
     */
    public it.sincon.gepred.protocollo.scatel.bean.Identificatore getIdentificatore() {
        return identificatore;
    }


    /**
     * Sets the identificatore value for this MessaggioRicevuto.
     * 
     * @param identificatore
     */
    public void setIdentificatore(it.sincon.gepred.protocollo.scatel.bean.Identificatore identificatore) {
        this.identificatore = identificatore;
    }


    /**
     * Gets the primaRegistrazione value for this MessaggioRicevuto.
     * 
     * @return primaRegistrazione
     */
    public it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione getPrimaRegistrazione() {
        return primaRegistrazione;
    }


    /**
     * Sets the primaRegistrazione value for this MessaggioRicevuto.
     * 
     * @param primaRegistrazione
     */
    public void setPrimaRegistrazione(it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione primaRegistrazione) {
        this.primaRegistrazione = primaRegistrazione;
    }


    /**
     * Gets the descrizioneMessaggio value for this MessaggioRicevuto.
     * 
     * @return descrizioneMessaggio
     */
    public java.lang.String getDescrizioneMessaggio() {
        return descrizioneMessaggio;
    }


    /**
     * Sets the descrizioneMessaggio value for this MessaggioRicevuto.
     * 
     * @param descrizioneMessaggio
     */
    public void setDescrizioneMessaggio(java.lang.String descrizioneMessaggio) {
        this.descrizioneMessaggio = descrizioneMessaggio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessaggioRicevuto)) return false;
        MessaggioRicevuto other = (MessaggioRicevuto) obj;
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
            ((this.descrizioneMessaggio==null && other.getDescrizioneMessaggio()==null) || 
             (this.descrizioneMessaggio!=null &&
              this.descrizioneMessaggio.equals(other.getDescrizioneMessaggio())));
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
        if (getDescrizioneMessaggio() != null) {
            _hashCode += getDescrizioneMessaggio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MessaggioRicevuto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">MessaggioRicevuto"));
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
        elemField.setFieldName("descrizioneMessaggio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "DescrizioneMessaggio"));
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
