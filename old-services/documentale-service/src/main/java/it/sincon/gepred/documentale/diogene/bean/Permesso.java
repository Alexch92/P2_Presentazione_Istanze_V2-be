/**
 * Permesso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class Permesso  implements java.io.Serializable {
    private boolean admin;

    private boolean delete;

    private java.lang.String nomeGruppo;

    private java.lang.String nomeUtente;

    private boolean read;

    private boolean write;

    public Permesso() {
    }

    public Permesso(
           boolean admin,
           boolean delete,
           java.lang.String nomeGruppo,
           java.lang.String nomeUtente,
           boolean read,
           boolean write) {
           this.admin = admin;
           this.delete = delete;
           this.nomeGruppo = nomeGruppo;
           this.nomeUtente = nomeUtente;
           this.read = read;
           this.write = write;
    }


    /**
     * Gets the admin value for this Permesso.
     * 
     * @return admin
     */
    public boolean isAdmin() {
        return admin;
    }


    /**
     * Sets the admin value for this Permesso.
     * 
     * @param admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    /**
     * Gets the delete value for this Permesso.
     * 
     * @return delete
     */
    public boolean isDelete() {
        return delete;
    }


    /**
     * Sets the delete value for this Permesso.
     * 
     * @param delete
     */
    public void setDelete(boolean delete) {
        this.delete = delete;
    }


    /**
     * Gets the nomeGruppo value for this Permesso.
     * 
     * @return nomeGruppo
     */
    public java.lang.String getNomeGruppo() {
        return nomeGruppo;
    }


    /**
     * Sets the nomeGruppo value for this Permesso.
     * 
     * @param nomeGruppo
     */
    public void setNomeGruppo(java.lang.String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }


    /**
     * Gets the nomeUtente value for this Permesso.
     * 
     * @return nomeUtente
     */
    public java.lang.String getNomeUtente() {
        return nomeUtente;
    }


    /**
     * Sets the nomeUtente value for this Permesso.
     * 
     * @param nomeUtente
     */
    public void setNomeUtente(java.lang.String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }


    /**
     * Gets the read value for this Permesso.
     * 
     * @return read
     */
    public boolean isRead() {
        return read;
    }


    /**
     * Sets the read value for this Permesso.
     * 
     * @param read
     */
    public void setRead(boolean read) {
        this.read = read;
    }


    /**
     * Gets the write value for this Permesso.
     * 
     * @return write
     */
    public boolean isWrite() {
        return write;
    }


    /**
     * Sets the write value for this Permesso.
     * 
     * @param write
     */
    public void setWrite(boolean write) {
        this.write = write;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Permesso)) return false;
        Permesso other = (Permesso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.admin == other.isAdmin() &&
            this.delete == other.isDelete() &&
            ((this.nomeGruppo==null && other.getNomeGruppo()==null) || 
             (this.nomeGruppo!=null &&
              this.nomeGruppo.equals(other.getNomeGruppo()))) &&
            ((this.nomeUtente==null && other.getNomeUtente()==null) || 
             (this.nomeUtente!=null &&
              this.nomeUtente.equals(other.getNomeUtente()))) &&
            this.read == other.isRead() &&
            this.write == other.isWrite();
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
        _hashCode += (isAdmin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getNomeGruppo() != null) {
            _hashCode += getNomeGruppo().hashCode();
        }
        if (getNomeUtente() != null) {
            _hashCode += getNomeUtente().hashCode();
        }
        _hashCode += (isRead() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isWrite() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Permesso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "Permesso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("admin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "admin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delete");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "delete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeGruppo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "nomeGruppo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomeUtente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "nomeUtente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("read");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "read"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("write");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "write"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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
