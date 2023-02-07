/**
 * RispostaRicercaAOO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class RispostaRicercaAOO  implements java.io.Serializable {
    private int numeroAOOTrovate;

    private it.sincon.gepred.protocollo.scatel.bean.AnagraficaAOO[] anagraficaAOO;

    public RispostaRicercaAOO() {
    }

    public RispostaRicercaAOO(
           int numeroAOOTrovate,
           it.sincon.gepred.protocollo.scatel.bean.AnagraficaAOO[] anagraficaAOO) {
           this.numeroAOOTrovate = numeroAOOTrovate;
           this.anagraficaAOO = anagraficaAOO;
    }


    /**
     * Gets the numeroAOOTrovate value for this RispostaRicercaAOO.
     * 
     * @return numeroAOOTrovate
     */
    public int getNumeroAOOTrovate() {
        return numeroAOOTrovate;
    }


    /**
     * Sets the numeroAOOTrovate value for this RispostaRicercaAOO.
     * 
     * @param numeroAOOTrovate
     */
    public void setNumeroAOOTrovate(int numeroAOOTrovate) {
        this.numeroAOOTrovate = numeroAOOTrovate;
    }


    /**
     * Gets the anagraficaAOO value for this RispostaRicercaAOO.
     * 
     * @return anagraficaAOO
     */
    public it.sincon.gepred.protocollo.scatel.bean.AnagraficaAOO[] getAnagraficaAOO() {
        return anagraficaAOO;
    }


    /**
     * Sets the anagraficaAOO value for this RispostaRicercaAOO.
     * 
     * @param anagraficaAOO
     */
    public void setAnagraficaAOO(it.sincon.gepred.protocollo.scatel.bean.AnagraficaAOO[] anagraficaAOO) {
        this.anagraficaAOO = anagraficaAOO;
    }

    public it.sincon.gepred.protocollo.scatel.bean.AnagraficaAOO getAnagraficaAOO(int i) {
        return this.anagraficaAOO[i];
    }

    public void setAnagraficaAOO(int i, it.sincon.gepred.protocollo.scatel.bean.AnagraficaAOO _value) {
        this.anagraficaAOO[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaRicercaAOO)) return false;
        RispostaRicercaAOO other = (RispostaRicercaAOO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.numeroAOOTrovate == other.getNumeroAOOTrovate() &&
            ((this.anagraficaAOO==null && other.getAnagraficaAOO()==null) || 
             (this.anagraficaAOO!=null &&
              java.util.Arrays.equals(this.anagraficaAOO, other.getAnagraficaAOO())));
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
        _hashCode += getNumeroAOOTrovate();
        if (getAnagraficaAOO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAnagraficaAOO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAnagraficaAOO(), i);
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
        new org.apache.axis.description.TypeDesc(RispostaRicercaAOO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaAOO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroAOOTrovate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroAOOTrovate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anagraficaAOO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "AnagraficaAOO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "AnagraficaAOO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
