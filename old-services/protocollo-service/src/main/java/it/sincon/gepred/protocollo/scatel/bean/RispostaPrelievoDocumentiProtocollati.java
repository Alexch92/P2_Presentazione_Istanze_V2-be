/**
 * RispostaPrelievoDocumentiProtocollati.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.bean;

public class RispostaPrelievoDocumentiProtocollati  implements java.io.Serializable {
    private boolean trovato;

    private int numeroDocCartacei;

    private int numeroDocTelematici;

    private int numeroDocElettronici;

    private it.sincon.gepred.protocollo.scatel.bean.MatchingDocumenti[] matchingDocumenti;

    public RispostaPrelievoDocumentiProtocollati() {
    }

    public RispostaPrelievoDocumentiProtocollati(
           boolean trovato,
           int numeroDocCartacei,
           int numeroDocTelematici,
           int numeroDocElettronici,
           it.sincon.gepred.protocollo.scatel.bean.MatchingDocumenti[] matchingDocumenti) {
           this.trovato = trovato;
           this.numeroDocCartacei = numeroDocCartacei;
           this.numeroDocTelematici = numeroDocTelematici;
           this.numeroDocElettronici = numeroDocElettronici;
           this.matchingDocumenti = matchingDocumenti;
    }


    /**
     * Gets the trovato value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @return trovato
     */
    public boolean isTrovato() {
        return trovato;
    }


    /**
     * Sets the trovato value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @param trovato
     */
    public void setTrovato(boolean trovato) {
        this.trovato = trovato;
    }


    /**
     * Gets the numeroDocCartacei value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @return numeroDocCartacei
     */
    public int getNumeroDocCartacei() {
        return numeroDocCartacei;
    }


    /**
     * Sets the numeroDocCartacei value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @param numeroDocCartacei
     */
    public void setNumeroDocCartacei(int numeroDocCartacei) {
        this.numeroDocCartacei = numeroDocCartacei;
    }


    /**
     * Gets the numeroDocTelematici value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @return numeroDocTelematici
     */
    public int getNumeroDocTelematici() {
        return numeroDocTelematici;
    }


    /**
     * Sets the numeroDocTelematici value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @param numeroDocTelematici
     */
    public void setNumeroDocTelematici(int numeroDocTelematici) {
        this.numeroDocTelematici = numeroDocTelematici;
    }


    /**
     * Gets the numeroDocElettronici value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @return numeroDocElettronici
     */
    public int getNumeroDocElettronici() {
        return numeroDocElettronici;
    }


    /**
     * Sets the numeroDocElettronici value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @param numeroDocElettronici
     */
    public void setNumeroDocElettronici(int numeroDocElettronici) {
        this.numeroDocElettronici = numeroDocElettronici;
    }


    /**
     * Gets the matchingDocumenti value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @return matchingDocumenti
     */
    public it.sincon.gepred.protocollo.scatel.bean.MatchingDocumenti[] getMatchingDocumenti() {
        return matchingDocumenti;
    }


    /**
     * Sets the matchingDocumenti value for this RispostaPrelievoDocumentiProtocollati.
     * 
     * @param matchingDocumenti
     */
    public void setMatchingDocumenti(it.sincon.gepred.protocollo.scatel.bean.MatchingDocumenti[] matchingDocumenti) {
        this.matchingDocumenti = matchingDocumenti;
    }

    public it.sincon.gepred.protocollo.scatel.bean.MatchingDocumenti getMatchingDocumenti(int i) {
        return this.matchingDocumenti[i];
    }

    public void setMatchingDocumenti(int i, it.sincon.gepred.protocollo.scatel.bean.MatchingDocumenti _value) {
        this.matchingDocumenti[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RispostaPrelievoDocumentiProtocollati)) return false;
        RispostaPrelievoDocumentiProtocollati other = (RispostaPrelievoDocumentiProtocollati) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.trovato == other.isTrovato() &&
            this.numeroDocCartacei == other.getNumeroDocCartacei() &&
            this.numeroDocTelematici == other.getNumeroDocTelematici() &&
            this.numeroDocElettronici == other.getNumeroDocElettronici() &&
            ((this.matchingDocumenti==null && other.getMatchingDocumenti()==null) || 
             (this.matchingDocumenti!=null &&
              java.util.Arrays.equals(this.matchingDocumenti, other.getMatchingDocumenti())));
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
        _hashCode += (isTrovato() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getNumeroDocCartacei();
        _hashCode += getNumeroDocTelematici();
        _hashCode += getNumeroDocElettronici();
        if (getMatchingDocumenti() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMatchingDocumenti());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMatchingDocumenti(), i);
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
        new org.apache.axis.description.TypeDesc(RispostaPrelievoDocumentiProtocollati.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaPrelievoDocumentiProtocollati"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trovato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "Trovato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDocCartacei");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroDocCartacei"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDocTelematici");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroDocTelematici"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroDocElettronici");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "NumeroDocElettronici"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchingDocumenti");
        elemField.setXmlName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "MatchingDocumenti"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "MatchingDocumenti"));
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
