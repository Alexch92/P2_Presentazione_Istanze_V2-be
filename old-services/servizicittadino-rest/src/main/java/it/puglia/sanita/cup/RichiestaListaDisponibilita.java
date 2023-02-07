/**
 * RichiestaListaDisponibilita.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class RichiestaListaDisponibilita  implements java.io.Serializable {
    private java.lang.String tipo;

    private it.puglia.sanita.cup.Operatore operatore;

    private it.puglia.sanita.cup.Ente ente;

    private it.puglia.sanita.cup.Paziente paziente;

    private it.puglia.sanita.cup.Prescrizione[] listaPrescrizioni;

    private it.puglia.sanita.cup.Vincolo[] vincolo;

    public RichiestaListaDisponibilita() {
    }

    public RichiestaListaDisponibilita(
           java.lang.String tipo,
           it.puglia.sanita.cup.Operatore operatore,
           it.puglia.sanita.cup.Ente ente,
           it.puglia.sanita.cup.Paziente paziente,
           it.puglia.sanita.cup.Prescrizione[] listaPrescrizioni,
           it.puglia.sanita.cup.Vincolo[] vincolo) {
           this.tipo = tipo;
           this.operatore = operatore;
           this.ente = ente;
           this.paziente = paziente;
           this.listaPrescrizioni = listaPrescrizioni;
           this.vincolo = vincolo;
    }


    /**
     * Gets the tipo value for this RichiestaListaDisponibilita.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this RichiestaListaDisponibilita.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the operatore value for this RichiestaListaDisponibilita.
     * 
     * @return operatore
     */
    public it.puglia.sanita.cup.Operatore getOperatore() {
        return operatore;
    }


    /**
     * Sets the operatore value for this RichiestaListaDisponibilita.
     * 
     * @param operatore
     */
    public void setOperatore(it.puglia.sanita.cup.Operatore operatore) {
        this.operatore = operatore;
    }


    /**
     * Gets the ente value for this RichiestaListaDisponibilita.
     * 
     * @return ente
     */
    public it.puglia.sanita.cup.Ente getEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this RichiestaListaDisponibilita.
     * 
     * @param ente
     */
    public void setEnte(it.puglia.sanita.cup.Ente ente) {
        this.ente = ente;
    }


    /**
     * Gets the paziente value for this RichiestaListaDisponibilita.
     * 
     * @return paziente
     */
    public it.puglia.sanita.cup.Paziente getPaziente() {
        return paziente;
    }


    /**
     * Sets the paziente value for this RichiestaListaDisponibilita.
     * 
     * @param paziente
     */
    public void setPaziente(it.puglia.sanita.cup.Paziente paziente) {
        this.paziente = paziente;
    }


    /**
     * Gets the listaPrescrizioni value for this RichiestaListaDisponibilita.
     * 
     * @return listaPrescrizioni
     */
    public it.puglia.sanita.cup.Prescrizione[] getListaPrescrizioni() {
        return listaPrescrizioni;
    }


    /**
     * Sets the listaPrescrizioni value for this RichiestaListaDisponibilita.
     * 
     * @param listaPrescrizioni
     */
    public void setListaPrescrizioni(it.puglia.sanita.cup.Prescrizione[] listaPrescrizioni) {
        this.listaPrescrizioni = listaPrescrizioni;
    }


    /**
     * Gets the vincolo value for this RichiestaListaDisponibilita.
     * 
     * @return vincolo
     */
    public it.puglia.sanita.cup.Vincolo[] getVincolo() {
        return vincolo;
    }


    /**
     * Sets the vincolo value for this RichiestaListaDisponibilita.
     * 
     * @param vincolo
     */
    public void setVincolo(it.puglia.sanita.cup.Vincolo[] vincolo) {
        this.vincolo = vincolo;
    }

    public it.puglia.sanita.cup.Vincolo getVincolo(int i) {
        return this.vincolo[i];
    }

    public void setVincolo(int i, it.puglia.sanita.cup.Vincolo _value) {
        this.vincolo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RichiestaListaDisponibilita)) return false;
        RichiestaListaDisponibilita other = (RichiestaListaDisponibilita) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.operatore==null && other.getOperatore()==null) || 
             (this.operatore!=null &&
              this.operatore.equals(other.getOperatore()))) &&
            ((this.ente==null && other.getEnte()==null) || 
             (this.ente!=null &&
              this.ente.equals(other.getEnte()))) &&
            ((this.paziente==null && other.getPaziente()==null) || 
             (this.paziente!=null &&
              this.paziente.equals(other.getPaziente()))) &&
            ((this.listaPrescrizioni==null && other.getListaPrescrizioni()==null) || 
             (this.listaPrescrizioni!=null &&
              java.util.Arrays.equals(this.listaPrescrizioni, other.getListaPrescrizioni()))) &&
            ((this.vincolo==null && other.getVincolo()==null) || 
             (this.vincolo!=null &&
              java.util.Arrays.equals(this.vincolo, other.getVincolo())));
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
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getOperatore() != null) {
            _hashCode += getOperatore().hashCode();
        }
        if (getEnte() != null) {
            _hashCode += getEnte().hashCode();
        }
        if (getPaziente() != null) {
            _hashCode += getPaziente().hashCode();
        }
        if (getListaPrescrizioni() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaPrescrizioni());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaPrescrizioni(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVincolo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVincolo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVincolo(), i);
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
        new org.apache.axis.description.TypeDesc(RichiestaListaDisponibilita.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaListaDisponibilita"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operatore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "operatore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Operatore"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "ente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Ente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paziente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "paziente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Paziente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaPrescrizioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "listaPrescrizioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prescrizione"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "prescrizione"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vincolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "vincolo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Vincolo"));
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
