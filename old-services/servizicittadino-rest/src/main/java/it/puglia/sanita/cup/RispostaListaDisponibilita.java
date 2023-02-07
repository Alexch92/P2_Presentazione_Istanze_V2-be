/**
 * RispostaListaDisponibilita.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RispostaListaDisponibilita  implements java.io.Serializable {
    private it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti;

    private it.puglia.sanita.cup.Errore errore;

    public RispostaListaDisponibilita() {
    }

    public RispostaListaDisponibilita(
           it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti,
           it.puglia.sanita.cup.Errore errore) {
           this.listaAppuntamenti = listaAppuntamenti;
           this.errore = errore;
    }


    /**
     * Gets the listaAppuntamenti value for this RispostaListaDisponibilita.
     * 
     * @return listaAppuntamenti
     */
    public it.puglia.sanita.cup.Appuntamento[] getListaAppuntamenti() {
        return listaAppuntamenti;
    }


    /**
     * Sets the listaAppuntamenti value for this RispostaListaDisponibilita.
     * 
     * @param listaAppuntamenti
     */
    public void setListaAppuntamenti(it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti) {
        this.listaAppuntamenti = listaAppuntamenti;
    }


    /**
     * Gets the errore value for this RispostaListaDisponibilita.
     * 
     * @return errore
     */
    public it.puglia.sanita.cup.Errore getErrore() {
        return errore;
    }


    /**
     * Sets the errore value for this RispostaListaDisponibilita.
     * 
     * @param errore
     */
    public void setErrore(it.puglia.sanita.cup.Errore errore) {
        this.errore = errore;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaListaDisponibilita)) return false;
        RispostaListaDisponibilita other = (RispostaListaDisponibilita) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.listaAppuntamenti==null && other.getListaAppuntamenti()==null) || 
             (this.listaAppuntamenti!=null &&
              java.util.Arrays.equals(this.listaAppuntamenti, other.getListaAppuntamenti()))) &&
            ((this.errore==null && other.getErrore()==null) || 
             (this.errore!=null &&
              this.errore.equals(other.getErrore())));
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
        if (getErrore() != null) {
            _hashCode += getErrore().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RispostaListaDisponibilita.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaListaDisponibilita"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaAppuntamenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "listaAppuntamenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "appuntamento"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "errore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Errore"));
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
