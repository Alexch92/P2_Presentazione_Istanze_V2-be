/**
 * RichiestaPrenota.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RichiestaPrenota  implements java.io.Serializable {
    private it.puglia.sanita.cup.Operatore operatore;

    private it.puglia.sanita.cup.Ente ente;

    private it.puglia.sanita.cup.Paziente paziente;

    private it.puglia.sanita.cup.Prescrizione[] listaPrescrizioni;

    private it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti;

    public RichiestaPrenota() {
    }

    public RichiestaPrenota(
           it.puglia.sanita.cup.Operatore operatore,
           it.puglia.sanita.cup.Ente ente,
           it.puglia.sanita.cup.Paziente paziente,
           it.puglia.sanita.cup.Prescrizione[] listaPrescrizioni,
           it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti) {
           this.operatore = operatore;
           this.ente = ente;
           this.paziente = paziente;
           this.listaPrescrizioni = listaPrescrizioni;
           this.listaAppuntamenti = listaAppuntamenti;
    }


    /**
     * Gets the operatore value for this RichiestaPrenota.
     * 
     * @return operatore
     */
    public it.puglia.sanita.cup.Operatore getOperatore() {
        return operatore;
    }


    /**
     * Sets the operatore value for this RichiestaPrenota.
     * 
     * @param operatore
     */
    public void setOperatore(it.puglia.sanita.cup.Operatore operatore) {
        this.operatore = operatore;
    }


    /**
     * Gets the ente value for this RichiestaPrenota.
     * 
     * @return ente
     */
    public it.puglia.sanita.cup.Ente getEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this RichiestaPrenota.
     * 
     * @param ente
     */
    public void setEnte(it.puglia.sanita.cup.Ente ente) {
        this.ente = ente;
    }


    /**
     * Gets the paziente value for this RichiestaPrenota.
     * 
     * @return paziente
     */
    public it.puglia.sanita.cup.Paziente getPaziente() {
        return paziente;
    }


    /**
     * Sets the paziente value for this RichiestaPrenota.
     * 
     * @param paziente
     */
    public void setPaziente(it.puglia.sanita.cup.Paziente paziente) {
        this.paziente = paziente;
    }


    /**
     * Gets the listaPrescrizioni value for this RichiestaPrenota.
     * 
     * @return listaPrescrizioni
     */
    public it.puglia.sanita.cup.Prescrizione[] getListaPrescrizioni() {
        return listaPrescrizioni;
    }


    /**
     * Sets the listaPrescrizioni value for this RichiestaPrenota.
     * 
     * @param listaPrescrizioni
     */
    public void setListaPrescrizioni(it.puglia.sanita.cup.Prescrizione[] listaPrescrizioni) {
        this.listaPrescrizioni = listaPrescrizioni;
    }


    /**
     * Gets the listaAppuntamenti value for this RichiestaPrenota.
     * 
     * @return listaAppuntamenti
     */
    public it.puglia.sanita.cup.Appuntamento[] getListaAppuntamenti() {
        return listaAppuntamenti;
    }


    /**
     * Sets the listaAppuntamenti value for this RichiestaPrenota.
     * 
     * @param listaAppuntamenti
     */
    public void setListaAppuntamenti(it.puglia.sanita.cup.Appuntamento[] listaAppuntamenti) {
        this.listaAppuntamenti = listaAppuntamenti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RichiestaPrenota)) return false;
        RichiestaPrenota other = (RichiestaPrenota) obj;
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
            ((this.paziente==null && other.getPaziente()==null) || 
             (this.paziente!=null &&
              this.paziente.equals(other.getPaziente()))) &&
            ((this.listaPrescrizioni==null && other.getListaPrescrizioni()==null) || 
             (this.listaPrescrizioni!=null &&
              java.util.Arrays.equals(this.listaPrescrizioni, other.getListaPrescrizioni()))) &&
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
        if (getOperatore() != null) {
            _hashCode += getOperatore().hashCode();
        }
        if (getEnte() != null) {
            _hashCode += getEnte().hashCode();
        }
        if (getPaziente() != null) {
            _hashCode += getPaziente().hashCode();
        }
        if (getListaPrescrizioni() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPrescrizioni());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPrescrizioni(), i);
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
        new org.apache.axis.description.TypeDesc(RichiestaPrenota.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPrenota"));
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
        elemField.setFieldName("paziente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "paziente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Paziente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPrescrizioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "listaPrescrizioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prescrizione"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "prescrizione"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaAppuntamenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "listaAppuntamenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento"));
        elemField.setNillable(false);
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
