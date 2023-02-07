/**
 * WS_RicercaResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_RicercaResult  extends it.sincon.gepred.documentale.diogene.bean.WS_Result  implements java.io.Serializable {
    private it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] aggregati;

    private it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] documenti;

    public WS_RicercaResult() {
    }

    public WS_RicercaResult(
           int codice,
           java.lang.String messaggio,
           java.lang.String[] warning,
           it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] aggregati,
           it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] documenti) {
        super(
            codice,
            messaggio,
            warning);
        this.aggregati = aggregati;
        this.documenti = documenti;
    }


    /**
     * Gets the aggregati value for this WS_RicercaResult.
     * 
     * @return aggregati
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] getAggregati() {
        return aggregati;
    }


    /**
     * Sets the aggregati value for this WS_RicercaResult.
     * 
     * @param aggregati
     */
    public void setAggregati(it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] aggregati) {
        this.aggregati = aggregati;
    }


    /**
     * Gets the documenti value for this WS_RicercaResult.
     * 
     * @return documenti
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] getDocumenti() {
        return documenti;
    }


    /**
     * Sets the documenti value for this WS_RicercaResult.
     * 
     * @param documenti
     */
    public void setDocumenti(it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] documenti) {
        this.documenti = documenti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_RicercaResult)) return false;
        WS_RicercaResult other = (WS_RicercaResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.aggregati==null && other.getAggregati()==null) || 
             (this.aggregati!=null &&
              java.util.Arrays.equals(this.aggregati, other.getAggregati()))) &&
            ((this.documenti==null && other.getDocumenti()==null) || 
             (this.documenti!=null &&
              java.util.Arrays.equals(this.documenti, other.getDocumenti())));
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
        if (getAggregati() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAggregati());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAggregati(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocumenti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocumenti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocumenti(), i);
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
        new org.apache.axis.description.TypeDesc(WS_RicercaResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_RicercaResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggregati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "aggregati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Aggregato"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "documenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_InfoDocumento"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item"));
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
