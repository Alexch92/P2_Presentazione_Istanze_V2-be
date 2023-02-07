/**
 * RichiestaPromemoria.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RichiestaPromemoria  implements java.io.Serializable {
    private it.puglia.sanita.cup.Operatore operatore;

    private it.puglia.sanita.cup.Ente ente;

    private it.puglia.sanita.cup.Prescrizione prescrizione;

    public RichiestaPromemoria() {
    }

    public RichiestaPromemoria(
           it.puglia.sanita.cup.Operatore operatore,
           it.puglia.sanita.cup.Ente ente,
           it.puglia.sanita.cup.Prescrizione prescrizione) {
           this.operatore = operatore;
           this.ente = ente;
           this.prescrizione = prescrizione;
    }


    /**
     * Gets the operatore value for this RichiestaPromemoria.
     * 
     * @return operatore
     */
    public it.puglia.sanita.cup.Operatore getOperatore() {
        return operatore;
    }


    /**
     * Sets the operatore value for this RichiestaPromemoria.
     * 
     * @param operatore
     */
    public void setOperatore(it.puglia.sanita.cup.Operatore operatore) {
        this.operatore = operatore;
    }


    /**
     * Gets the ente value for this RichiestaPromemoria.
     * 
     * @return ente
     */
    public it.puglia.sanita.cup.Ente getEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this RichiestaPromemoria.
     * 
     * @param ente
     */
    public void setEnte(it.puglia.sanita.cup.Ente ente) {
        this.ente = ente;
    }


    /**
     * Gets the prescrizione value for this RichiestaPromemoria.
     * 
     * @return prescrizione
     */
    public it.puglia.sanita.cup.Prescrizione getPrescrizione() {
        return prescrizione;
    }


    /**
     * Sets the prescrizione value for this RichiestaPromemoria.
     * 
     * @param prescrizione
     */
    public void setPrescrizione(it.puglia.sanita.cup.Prescrizione prescrizione) {
        this.prescrizione = prescrizione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RichiestaPromemoria)) return false;
        RichiestaPromemoria other = (RichiestaPromemoria) obj;
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
            ((this.prescrizione==null && other.getPrescrizione()==null) || 
             (this.prescrizione!=null &&
              this.prescrizione.equals(other.getPrescrizione())));
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
        if (getPrescrizione() != null) {
            _hashCode += getPrescrizione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RichiestaPromemoria.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPromemoria"));
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
        elemField.setFieldName("prescrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "prescrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prescrizione"));
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
