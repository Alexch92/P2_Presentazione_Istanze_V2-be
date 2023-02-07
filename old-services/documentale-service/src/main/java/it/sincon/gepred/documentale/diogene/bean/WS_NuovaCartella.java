/**
 * WS_NuovaCartella.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_NuovaCartella  implements java.io.Serializable {
    private java.lang.String annotazioni;

    private java.lang.String descrizione;

    private java.lang.String idPadre;

    private java.lang.String nomeAggregato;

    private it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi;

    public WS_NuovaCartella() {
    }

    public WS_NuovaCartella(
           java.lang.String annotazioni,
           java.lang.String descrizione,
           java.lang.String idPadre,
           java.lang.String nomeAggregato,
           it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi) {
           this.annotazioni = annotazioni;
           this.descrizione = descrizione;
           this.idPadre = idPadre;
           this.nomeAggregato = nomeAggregato;
           this.permessi = permessi;
    }


    /**
     * Gets the annotazioni value for this WS_NuovaCartella.
     * 
     * @return annotazioni
     */
    public java.lang.String getAnnotazioni() {
        return annotazioni;
    }


    /**
     * Sets the annotazioni value for this WS_NuovaCartella.
     * 
     * @param annotazioni
     */
    public void setAnnotazioni(java.lang.String annotazioni) {
        this.annotazioni = annotazioni;
    }


    /**
     * Gets the descrizione value for this WS_NuovaCartella.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_NuovaCartella.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the idPadre value for this WS_NuovaCartella.
     * 
     * @return idPadre
     */
    public java.lang.String getIdPadre() {
        return idPadre;
    }


    /**
     * Sets the idPadre value for this WS_NuovaCartella.
     * 
     * @param idPadre
     */
    public void setIdPadre(java.lang.String idPadre) {
        this.idPadre = idPadre;
    }


    /**
     * Gets the nomeAggregato value for this WS_NuovaCartella.
     * 
     * @return nomeAggregato
     */
    public java.lang.String getNomeAggregato() {
        return nomeAggregato;
    }


    /**
     * Sets the nomeAggregato value for this WS_NuovaCartella.
     * 
     * @param nomeAggregato
     */
    public void setNomeAggregato(java.lang.String nomeAggregato) {
        this.nomeAggregato = nomeAggregato;
    }


    /**
     * Gets the permessi value for this WS_NuovaCartella.
     * 
     * @return permessi
     */
    public it.sincon.gepred.documentale.diogene.bean.Permesso[] getPermessi() {
        return permessi;
    }


    /**
     * Sets the permessi value for this WS_NuovaCartella.
     * 
     * @param permessi
     */
    public void setPermessi(it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi) {
        this.permessi = permessi;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_NuovaCartella)) return false;
        WS_NuovaCartella other = (WS_NuovaCartella) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.annotazioni==null && other.getAnnotazioni()==null) || 
             (this.annotazioni!=null &&
              this.annotazioni.equals(other.getAnnotazioni()))) &&
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.idPadre==null && other.getIdPadre()==null) || 
             (this.idPadre!=null &&
              this.idPadre.equals(other.getIdPadre()))) &&
            ((this.nomeAggregato==null && other.getNomeAggregato()==null) || 
             (this.nomeAggregato!=null &&
              this.nomeAggregato.equals(other.getNomeAggregato()))) &&
            ((this.permessi==null && other.getPermessi()==null) || 
             (this.permessi!=null &&
              java.util.Arrays.equals(this.permessi, other.getPermessi())));
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
        if (getAnnotazioni() != null) {
            _hashCode += getAnnotazioni().hashCode();
        }
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getIdPadre() != null) {
            _hashCode += getIdPadre().hashCode();
        }
        if (getNomeAggregato() != null) {
            _hashCode += getNomeAggregato().hashCode();
        }
        if (getPermessi() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPermessi());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPermessi(), i);
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
        new org.apache.axis.description.TypeDesc(WS_NuovaCartella.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovaCartella"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeAggregato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "nomeAggregato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("permessi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "permessi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "Permesso"));
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
