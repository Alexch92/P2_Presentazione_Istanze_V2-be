/**
 * WS_Cartella.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_Cartella  extends it.sincon.gepred.documentale.diogene.bean.WS_Aggregato  implements java.io.Serializable {
    private java.lang.String annotazioni;

    private java.lang.String descrizione;

    public WS_Cartella() {
    }

    public WS_Cartella(
           java.lang.String dataCreazione,
           java.lang.String idAggregato,
           java.lang.String idPadre,
           java.lang.String nomeAggregato,
           java.lang.String owner,
           java.lang.String path,
           it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi,
           java.lang.String stato,
           java.lang.String tipoAggregato,
           java.lang.String annotazioni,
           java.lang.String descrizione) {
        super(
            dataCreazione,
            idAggregato,
            idPadre,
            nomeAggregato,
            owner,
            path,
            permessi,
            stato,
            tipoAggregato);
        this.annotazioni = annotazioni;
        this.descrizione = descrizione;
    }


    /**
     * Gets the annotazioni value for this WS_Cartella.
     * 
     * @return annotazioni
     */
    public java.lang.String getAnnotazioni() {
        return annotazioni;
    }


    /**
     * Sets the annotazioni value for this WS_Cartella.
     * 
     * @param annotazioni
     */
    public void setAnnotazioni(java.lang.String annotazioni) {
        this.annotazioni = annotazioni;
    }


    /**
     * Gets the descrizione value for this WS_Cartella.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_Cartella.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_Cartella)) return false;
        WS_Cartella other = (WS_Cartella) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.annotazioni==null && other.getAnnotazioni()==null) || 
             (this.annotazioni!=null &&
              this.annotazioni.equals(other.getAnnotazioni()))) &&
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione())));
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
        if (getAnnotazioni() != null) {
            _hashCode += getAnnotazioni().hashCode();
        }
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_Cartella.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Cartella"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotazioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "annotazioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descrizione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "descrizione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
