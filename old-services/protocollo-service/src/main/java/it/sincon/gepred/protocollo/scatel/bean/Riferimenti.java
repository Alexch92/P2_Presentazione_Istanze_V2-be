/**
 * Riferimenti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Riferimenti  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.Messaggio[] messaggio;

    private it.sincon.gepred.protocollo.scatel.bean.Procedimento[] procedimento;

    public Riferimenti() {
    }

    public Riferimenti(
           it.sincon.gepred.protocollo.scatel.bean.Messaggio[] messaggio,
           it.sincon.gepred.protocollo.scatel.bean.Procedimento[] procedimento) {
           this.messaggio = messaggio;
           this.procedimento = procedimento;
    }


    /**
     * Gets the messaggio value for this Riferimenti.
     * 
     * @return messaggio
     */
    public it.sincon.gepred.protocollo.scatel.bean.Messaggio[] getMessaggio() {
        return messaggio;
    }


    /**
     * Sets the messaggio value for this Riferimenti.
     * 
     * @param messaggio
     */
    public void setMessaggio(it.sincon.gepred.protocollo.scatel.bean.Messaggio[] messaggio) {
        this.messaggio = messaggio;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Messaggio getMessaggio(int i) {
        return this.messaggio[i];
    }

    public void setMessaggio(int i, it.sincon.gepred.protocollo.scatel.bean.Messaggio _value) {
        this.messaggio[i] = _value;
    }


    /**
     * Gets the procedimento value for this Riferimenti.
     * 
     * @return procedimento
     */
    public it.sincon.gepred.protocollo.scatel.bean.Procedimento[] getProcedimento() {
        return procedimento;
    }


    /**
     * Sets the procedimento value for this Riferimenti.
     * 
     * @param procedimento
     */
    public void setProcedimento(it.sincon.gepred.protocollo.scatel.bean.Procedimento[] procedimento) {
        this.procedimento = procedimento;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Procedimento getProcedimento(int i) {
        return this.procedimento[i];
    }

    public void setProcedimento(int i, it.sincon.gepred.protocollo.scatel.bean.Procedimento _value) {
        this.procedimento[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Riferimenti)) return false;
        Riferimenti other = (Riferimenti) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.messaggio==null && other.getMessaggio()==null) || 
             (this.messaggio!=null &&
              java.util.Arrays.equals(this.messaggio, other.getMessaggio()))) &&
            ((this.procedimento==null && other.getProcedimento()==null) || 
             (this.procedimento!=null &&
              java.util.Arrays.equals(this.procedimento, other.getProcedimento())));
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
        if (getMessaggio() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessaggio());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessaggio(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProcedimento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProcedimento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProcedimento(), i);
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
        new org.apache.axis.description.TypeDesc(Riferimenti.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Riferimenti"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messaggio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Messaggio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Messaggio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Procedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Procedimento"));
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
