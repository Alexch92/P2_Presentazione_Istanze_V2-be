/**
 * Destinazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class Destinazione  implements java.io.Serializable {
    private it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico;

    private it.sincon.gepred.protocollo.scatel.bean.Destinatario[] destinatario;

    public Destinazione() {
    }

    public Destinazione(
           it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico,
           it.sincon.gepred.protocollo.scatel.bean.Destinatario[] destinatario) {
           this.indirizzoTelematico = indirizzoTelematico;
           this.destinatario = destinatario;
    }


    /**
     * Gets the indirizzoTelematico value for this Destinazione.
     * 
     * @return indirizzoTelematico
     */
    public it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico getIndirizzoTelematico() {
        return indirizzoTelematico;
    }


    /**
     * Sets the indirizzoTelematico value for this Destinazione.
     * 
     * @param indirizzoTelematico
     */
    public void setIndirizzoTelematico(it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico indirizzoTelematico) {
        this.indirizzoTelematico = indirizzoTelematico;
    }


    /**
     * Gets the destinatario value for this Destinazione.
     * 
     * @return destinatario
     */
    public it.sincon.gepred.protocollo.scatel.bean.Destinatario[] getDestinatario() {
        return destinatario;
    }


    /**
     * Sets the destinatario value for this Destinazione.
     * 
     * @param destinatario
     */
    public void setDestinatario(it.sincon.gepred.protocollo.scatel.bean.Destinatario[] destinatario) {
        this.destinatario = destinatario;
    }

    public it.sincon.gepred.protocollo.scatel.bean.Destinatario getDestinatario(int i) {
        return this.destinatario[i];
    }

    public void setDestinatario(int i, it.sincon.gepred.protocollo.scatel.bean.Destinatario _value) {
        this.destinatario[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Destinazione)) return false;
        Destinazione other = (Destinazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indirizzoTelematico==null && other.getIndirizzoTelematico()==null) || 
             (this.indirizzoTelematico!=null &&
              this.indirizzoTelematico.equals(other.getIndirizzoTelematico()))) &&
            ((this.destinatario==null && other.getDestinatario()==null) || 
             (this.destinatario!=null &&
              java.util.Arrays.equals(this.destinatario, other.getDestinatario())));
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
        if (getIndirizzoTelematico() != null) {
            _hashCode += getIndirizzoTelematico().hashCode();
        }
        if (getDestinatario() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDestinatario());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDestinatario(), i);
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
        new org.apache.axis.description.TypeDesc(Destinazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Destinazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoTelematico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "IndirizzoTelematico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoTelematico"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinatario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Destinatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Destinatario"));
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
