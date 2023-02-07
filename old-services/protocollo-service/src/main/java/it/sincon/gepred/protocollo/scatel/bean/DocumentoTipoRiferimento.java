/**
 * DocumentoTipoRiferimento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class DocumentoTipoRiferimento implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected DocumentoTipoRiferimento(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _DM = "DM";
    public static final java.lang.String _MIME = "MIME";
    public static final java.lang.String _telematico = "telematico";
    public static final java.lang.String _cartaceo = "cartaceo";
    public static final DocumentoTipoRiferimento DM = new DocumentoTipoRiferimento(_DM);
    public static final DocumentoTipoRiferimento MIME = new DocumentoTipoRiferimento(_MIME);
    public static final DocumentoTipoRiferimento telematico = new DocumentoTipoRiferimento(_telematico);
    public static final DocumentoTipoRiferimento cartaceo = new DocumentoTipoRiferimento(_cartaceo);
    public java.lang.String getValue() { return _value_;}
    public static DocumentoTipoRiferimento fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        DocumentoTipoRiferimento enumeration = (DocumentoTipoRiferimento)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static DocumentoTipoRiferimento fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoTipoRiferimento.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">>Documento>tipoRiferimento"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
