/**
 * WS_MostraContenuto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_MostraContenuto  extends it.sincon.gepred.documentale.diogene.bean.WS_Result  implements java.io.Serializable {
    private it.sincon.gepred.documentale.diogene.bean.WS_Aggregato aggregato;

    private it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] elencoAggregati;

    private it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] elencoDocumenti;

    public WS_MostraContenuto() {
    }

    public WS_MostraContenuto(
           int codice,
           java.lang.String messaggio,
           java.lang.String[] warning,
           it.sincon.gepred.documentale.diogene.bean.WS_Aggregato aggregato,
           it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] elencoAggregati,
           it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] elencoDocumenti) {
        super(
            codice,
            messaggio,
            warning);
        this.aggregato = aggregato;
        this.elencoAggregati = elencoAggregati;
        this.elencoDocumenti = elencoDocumenti;
    }


    /**
     * Gets the aggregato value for this WS_MostraContenuto.
     * 
     * @return aggregato
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Aggregato getAggregato() {
        return aggregato;
    }


    /**
     * Sets the aggregato value for this WS_MostraContenuto.
     * 
     * @param aggregato
     */
    public void setAggregato(it.sincon.gepred.documentale.diogene.bean.WS_Aggregato aggregato) {
        this.aggregato = aggregato;
    }


    /**
     * Gets the elencoAggregati value for this WS_MostraContenuto.
     * 
     * @return elencoAggregati
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] getElencoAggregati() {
        return elencoAggregati;
    }


    /**
     * Sets the elencoAggregati value for this WS_MostraContenuto.
     * 
     * @param elencoAggregati
     */
    public void setElencoAggregati(it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[] elencoAggregati) {
        this.elencoAggregati = elencoAggregati;
    }


    /**
     * Gets the elencoDocumenti value for this WS_MostraContenuto.
     * 
     * @return elencoDocumenti
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] getElencoDocumenti() {
        return elencoDocumenti;
    }


    /**
     * Sets the elencoDocumenti value for this WS_MostraContenuto.
     * 
     * @param elencoDocumenti
     */
    public void setElencoDocumenti(it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] elencoDocumenti) {
        this.elencoDocumenti = elencoDocumenti;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_MostraContenuto)) return false;
        WS_MostraContenuto other = (WS_MostraContenuto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.aggregato==null && other.getAggregato()==null) || 
             (this.aggregato!=null &&
              this.aggregato.equals(other.getAggregato()))) &&
            ((this.elencoAggregati==null && other.getElencoAggregati()==null) || 
             (this.elencoAggregati!=null &&
              java.util.Arrays.equals(this.elencoAggregati, other.getElencoAggregati()))) &&
            ((this.elencoDocumenti==null && other.getElencoDocumenti()==null) || 
             (this.elencoDocumenti!=null &&
              java.util.Arrays.equals(this.elencoDocumenti, other.getElencoDocumenti())));
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
        if (getAggregato() != null) {
            _hashCode += getAggregato().hashCode();
        }
        if (getElencoAggregati() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getElencoAggregati());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getElencoAggregati(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getElencoDocumenti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getElencoDocumenti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getElencoDocumenti(), i);
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
        new org.apache.axis.description.TypeDesc(WS_MostraContenuto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_MostraContenuto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggregato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "aggregato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Aggregato"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elencoAggregati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "elencoAggregati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Aggregato"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("elencoDocumenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "elencoDocumenti"));
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
