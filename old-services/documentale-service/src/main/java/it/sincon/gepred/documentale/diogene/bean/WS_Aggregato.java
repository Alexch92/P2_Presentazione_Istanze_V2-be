/**
 * WS_Aggregato.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_Aggregato  implements java.io.Serializable {
    private java.lang.String dataCreazione;

    private java.lang.String idAggregato;

    private java.lang.String idPadre;

    private java.lang.String nomeAggregato;

    private java.lang.String owner;

    private java.lang.String path;

    private it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi;

    private java.lang.String stato;

    private java.lang.String tipoAggregato;

    public WS_Aggregato() {
    }

    public WS_Aggregato(
           java.lang.String dataCreazione,
           java.lang.String idAggregato,
           java.lang.String idPadre,
           java.lang.String nomeAggregato,
           java.lang.String owner,
           java.lang.String path,
           it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi,
           java.lang.String stato,
           java.lang.String tipoAggregato) {
           this.dataCreazione = dataCreazione;
           this.idAggregato = idAggregato;
           this.idPadre = idPadre;
           this.nomeAggregato = nomeAggregato;
           this.owner = owner;
           this.path = path;
           this.permessi = permessi;
           this.stato = stato;
           this.tipoAggregato = tipoAggregato;
    }


    /**
     * Gets the dataCreazione value for this WS_Aggregato.
     * 
     * @return dataCreazione
     */
    public java.lang.String getDataCreazione() {
        return dataCreazione;
    }


    /**
     * Sets the dataCreazione value for this WS_Aggregato.
     * 
     * @param dataCreazione
     */
    public void setDataCreazione(java.lang.String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }


    /**
     * Gets the idAggregato value for this WS_Aggregato.
     * 
     * @return idAggregato
     */
    public java.lang.String getIdAggregato() {
        return idAggregato;
    }


    /**
     * Sets the idAggregato value for this WS_Aggregato.
     * 
     * @param idAggregato
     */
    public void setIdAggregato(java.lang.String idAggregato) {
        this.idAggregato = idAggregato;
    }


    /**
     * Gets the idPadre value for this WS_Aggregato.
     * 
     * @return idPadre
     */
    public java.lang.String getIdPadre() {
        return idPadre;
    }


    /**
     * Sets the idPadre value for this WS_Aggregato.
     * 
     * @param idPadre
     */
    public void setIdPadre(java.lang.String idPadre) {
        this.idPadre = idPadre;
    }


    /**
     * Gets the nomeAggregato value for this WS_Aggregato.
     * 
     * @return nomeAggregato
     */
    public java.lang.String getNomeAggregato() {
        return nomeAggregato;
    }


    /**
     * Sets the nomeAggregato value for this WS_Aggregato.
     * 
     * @param nomeAggregato
     */
    public void setNomeAggregato(java.lang.String nomeAggregato) {
        this.nomeAggregato = nomeAggregato;
    }


    /**
     * Gets the owner value for this WS_Aggregato.
     * 
     * @return owner
     */
    public java.lang.String getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this WS_Aggregato.
     * 
     * @param owner
     */
    public void setOwner(java.lang.String owner) {
        this.owner = owner;
    }


    /**
     * Gets the path value for this WS_Aggregato.
     * 
     * @return path
     */
    public java.lang.String getPath() {
        return path;
    }


    /**
     * Sets the path value for this WS_Aggregato.
     * 
     * @param path
     */
    public void setPath(java.lang.String path) {
        this.path = path;
    }


    /**
     * Gets the permessi value for this WS_Aggregato.
     * 
     * @return permessi
     */
    public it.sincon.gepred.documentale.diogene.bean.Permesso[] getPermessi() {
        return permessi;
    }


    /**
     * Sets the permessi value for this WS_Aggregato.
     * 
     * @param permessi
     */
    public void setPermessi(it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi) {
        this.permessi = permessi;
    }


    /**
     * Gets the stato value for this WS_Aggregato.
     * 
     * @return stato
     */
    public java.lang.String getStato() {
        return stato;
    }


    /**
     * Sets the stato value for this WS_Aggregato.
     * 
     * @param stato
     */
    public void setStato(java.lang.String stato) {
        this.stato = stato;
    }


    /**
     * Gets the tipoAggregato value for this WS_Aggregato.
     * 
     * @return tipoAggregato
     */
    public java.lang.String getTipoAggregato() {
        return tipoAggregato;
    }


    /**
     * Sets the tipoAggregato value for this WS_Aggregato.
     * 
     * @param tipoAggregato
     */
    public void setTipoAggregato(java.lang.String tipoAggregato) {
        this.tipoAggregato = tipoAggregato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_Aggregato)) return false;
        WS_Aggregato other = (WS_Aggregato) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataCreazione==null && other.getDataCreazione()==null) || 
             (this.dataCreazione!=null &&
              this.dataCreazione.equals(other.getDataCreazione()))) &&
            ((this.idAggregato==null && other.getIdAggregato()==null) || 
             (this.idAggregato!=null &&
              this.idAggregato.equals(other.getIdAggregato()))) &&
            ((this.idPadre==null && other.getIdPadre()==null) || 
             (this.idPadre!=null &&
              this.idPadre.equals(other.getIdPadre()))) &&
            ((this.nomeAggregato==null && other.getNomeAggregato()==null) || 
             (this.nomeAggregato!=null &&
              this.nomeAggregato.equals(other.getNomeAggregato()))) &&
            ((this.owner==null && other.getOwner()==null) || 
             (this.owner!=null &&
              this.owner.equals(other.getOwner()))) &&
            ((this.path==null && other.getPath()==null) || 
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            ((this.permessi==null && other.getPermessi()==null) || 
             (this.permessi!=null &&
              java.util.Arrays.equals(this.permessi, other.getPermessi()))) &&
            ((this.stato==null && other.getStato()==null) || 
             (this.stato!=null &&
              this.stato.equals(other.getStato()))) &&
            ((this.tipoAggregato==null && other.getTipoAggregato()==null) || 
             (this.tipoAggregato!=null &&
              this.tipoAggregato.equals(other.getTipoAggregato())));
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
        if (getDataCreazione() != null) {
            _hashCode += getDataCreazione().hashCode();
        }
        if (getIdAggregato() != null) {
            _hashCode += getIdAggregato().hashCode();
        }
        if (getIdPadre() != null) {
            _hashCode += getIdPadre().hashCode();
        }
        if (getNomeAggregato() != null) {
            _hashCode += getNomeAggregato().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
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
        if (getStato() != null) {
            _hashCode += getStato().hashCode();
        }
        if (getTipoAggregato() != null) {
            _hashCode += getTipoAggregato().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_Aggregato.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Aggregato"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataCreazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataCreazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAggregato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idAggregato"));
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
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "path"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "stato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAggregato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipoAggregato"));
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
