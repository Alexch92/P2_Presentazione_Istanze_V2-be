/**
 * WS_Dettaglio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_Dettaglio  extends it.sincon.gepred.documentale.diogene.bean.WS_Result  implements java.io.Serializable {
    private it.sincon.gepred.documentale.diogene.bean.WS_Cartella cartella;

    private it.sincon.gepred.documentale.diogene.bean.WS_Documento documento;

    private it.sincon.gepred.documentale.diogene.bean.WS_FascicoloReale fascicolo;

    private it.sincon.gepred.documentale.diogene.bean.WS_FascicoloTemporaneo temporaneo;

    public WS_Dettaglio() {
    }

    public WS_Dettaglio(
           int codice,
           java.lang.String messaggio,
           java.lang.String[] warning,
           it.sincon.gepred.documentale.diogene.bean.WS_Cartella cartella,
           it.sincon.gepred.documentale.diogene.bean.WS_Documento documento,
           it.sincon.gepred.documentale.diogene.bean.WS_FascicoloReale fascicolo,
           it.sincon.gepred.documentale.diogene.bean.WS_FascicoloTemporaneo temporaneo) {
        super(
            codice,
            messaggio,
            warning);
        this.cartella = cartella;
        this.documento = documento;
        this.fascicolo = fascicolo;
        this.temporaneo = temporaneo;
    }


    /**
     * Gets the cartella value for this WS_Dettaglio.
     * 
     * @return cartella
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Cartella getCartella() {
        return cartella;
    }


    /**
     * Sets the cartella value for this WS_Dettaglio.
     * 
     * @param cartella
     */
    public void setCartella(it.sincon.gepred.documentale.diogene.bean.WS_Cartella cartella) {
        this.cartella = cartella;
    }


    /**
     * Gets the documento value for this WS_Dettaglio.
     * 
     * @return documento
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Documento getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this WS_Dettaglio.
     * 
     * @param documento
     */
    public void setDocumento(it.sincon.gepred.documentale.diogene.bean.WS_Documento documento) {
        this.documento = documento;
    }


    /**
     * Gets the fascicolo value for this WS_Dettaglio.
     * 
     * @return fascicolo
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_FascicoloReale getFascicolo() {
        return fascicolo;
    }


    /**
     * Sets the fascicolo value for this WS_Dettaglio.
     * 
     * @param fascicolo
     */
    public void setFascicolo(it.sincon.gepred.documentale.diogene.bean.WS_FascicoloReale fascicolo) {
        this.fascicolo = fascicolo;
    }


    /**
     * Gets the temporaneo value for this WS_Dettaglio.
     * 
     * @return temporaneo
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_FascicoloTemporaneo getTemporaneo() {
        return temporaneo;
    }


    /**
     * Sets the temporaneo value for this WS_Dettaglio.
     * 
     * @param temporaneo
     */
    public void setTemporaneo(it.sincon.gepred.documentale.diogene.bean.WS_FascicoloTemporaneo temporaneo) {
        this.temporaneo = temporaneo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_Dettaglio)) return false;
        WS_Dettaglio other = (WS_Dettaglio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cartella==null && other.getCartella()==null) || 
             (this.cartella!=null &&
              this.cartella.equals(other.getCartella()))) &&
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              this.documento.equals(other.getDocumento()))) &&
            ((this.fascicolo==null && other.getFascicolo()==null) || 
             (this.fascicolo!=null &&
              this.fascicolo.equals(other.getFascicolo()))) &&
            ((this.temporaneo==null && other.getTemporaneo()==null) || 
             (this.temporaneo!=null &&
              this.temporaneo.equals(other.getTemporaneo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCartella() != null) {
            _hashCode += getCartella().hashCode();
        }
        if (getDocumento() != null) {
            _hashCode += getDocumento().hashCode();
        }
        if (getFascicolo() != null) {
            _hashCode += getFascicolo().hashCode();
        }
        if (getTemporaneo() != null) {
            _hashCode += getTemporaneo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_Dettaglio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cartella");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "cartella"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Cartella"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Documento"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fascicolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "fascicolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FascicoloReale"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temporaneo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "temporaneo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FascicoloTemporaneo"));
        elemField.setNillable(true);
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
