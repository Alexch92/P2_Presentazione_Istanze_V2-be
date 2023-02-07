/**
 * RichiestaCancella.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RichiestaCancella  implements java.io.Serializable {
    private it.puglia.sanita.cup.Operatore operatore;

    private it.puglia.sanita.cup.Ente ente;

    private it.puglia.sanita.cup.Appuntamento appuntamento;

    public RichiestaCancella() {
    }

    public RichiestaCancella(
           it.puglia.sanita.cup.Operatore operatore,
           it.puglia.sanita.cup.Ente ente,
           it.puglia.sanita.cup.Appuntamento appuntamento) {
           this.operatore = operatore;
           this.ente = ente;
           this.appuntamento = appuntamento;
    }


    /**
     * Gets the operatore value for this RichiestaCancella.
     * 
     * @return operatore
     */
    public it.puglia.sanita.cup.Operatore getOperatore() {
        return operatore;
    }


    /**
     * Sets the operatore value for this RichiestaCancella.
     * 
     * @param operatore
     */
    public void setOperatore(it.puglia.sanita.cup.Operatore operatore) {
        this.operatore = operatore;
    }


    /**
     * Gets the ente value for this RichiestaCancella.
     * 
     * @return ente
     */
    public it.puglia.sanita.cup.Ente getEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this RichiestaCancella.
     * 
     * @param ente
     */
    public void setEnte(it.puglia.sanita.cup.Ente ente) {
        this.ente = ente;
    }


    /**
     * Gets the appuntamento value for this RichiestaCancella.
     * 
     * @return appuntamento
     */
    public it.puglia.sanita.cup.Appuntamento getAppuntamento() {
        return appuntamento;
    }


    /**
     * Sets the appuntamento value for this RichiestaCancella.
     * 
     * @param appuntamento
     */
    public void setAppuntamento(it.puglia.sanita.cup.Appuntamento appuntamento) {
        this.appuntamento = appuntamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RichiestaCancella)) return false;
        RichiestaCancella other = (RichiestaCancella) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operatore==null && other.getOperatore()==null) || 
             (this.operatore!=null &&
              this.operatore.equals(other.getOperatore()))) &&
            ((this.ente==null && other.getEnte()==null) || 
             (this.ente!=null &&
              this.ente.equals(other.getEnte()))) &&
            ((this.appuntamento==null && other.getAppuntamento()==null) || 
             (this.appuntamento!=null &&
              this.appuntamento.equals(other.getAppuntamento())));
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
        if (getOperatore() != null) {
            _hashCode += getOperatore().hashCode();
        }
        if (getEnte() != null) {
            _hashCode += getEnte().hashCode();
        }
        if (getAppuntamento() != null) {
            _hashCode += getAppuntamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RichiestaCancella.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaCancella"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "operatore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Operatore"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "ente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Ente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appuntamento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "appuntamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento"));
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
