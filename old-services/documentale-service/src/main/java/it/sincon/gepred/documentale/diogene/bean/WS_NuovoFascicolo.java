/**
 * WS_NuovoFascicolo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_NuovoFascicolo  implements java.io.Serializable {
    private java.lang.String annotazioni;

    private java.lang.String codicePratica;

    private java.lang.String cup;

    private java.lang.String descrizione;

    private java.lang.Boolean flagDatiPersonali;

    private java.lang.Boolean flagDatiRiservati;

    private java.lang.Boolean flagDatiSensibili;

    private java.lang.String idBando;

    private java.lang.String idPadre;

    private java.lang.String idTitolario;

    private java.lang.String idVoceTitolario;

    private java.lang.String localizzazione;

    private java.lang.String mir;

    private java.lang.String nomeAggregato;

    private it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo numerazione;

    private java.lang.String oggetto;

    private it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi;

    private it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo;

    private it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo soggetto;

    public WS_NuovoFascicolo() {
    }

    public WS_NuovoFascicolo(
           java.lang.String annotazioni,
           java.lang.String codicePratica,
           java.lang.String cup,
           java.lang.String descrizione,
           java.lang.Boolean flagDatiPersonali,
           java.lang.Boolean flagDatiRiservati,
           java.lang.Boolean flagDatiSensibili,
           java.lang.String idBando,
           java.lang.String idPadre,
           java.lang.String idTitolario,
           java.lang.String idVoceTitolario,
           java.lang.String localizzazione,
           java.lang.String mir,
           java.lang.String nomeAggregato,
           it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo numerazione,
           java.lang.String oggetto,
           it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi,
           it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo,
           it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo soggetto) {
           this.annotazioni = annotazioni;
           this.codicePratica = codicePratica;
           this.cup = cup;
           this.descrizione = descrizione;
           this.flagDatiPersonali = flagDatiPersonali;
           this.flagDatiRiservati = flagDatiRiservati;
           this.flagDatiSensibili = flagDatiSensibili;
           this.idBando = idBando;
           this.idPadre = idPadre;
           this.idTitolario = idTitolario;
           this.idVoceTitolario = idVoceTitolario;
           this.localizzazione = localizzazione;
           this.mir = mir;
           this.nomeAggregato = nomeAggregato;
           this.numerazione = numerazione;
           this.oggetto = oggetto;
           this.permessi = permessi;
           this.protocollo = protocollo;
           this.soggetto = soggetto;
    }


    /**
     * Gets the annotazioni value for this WS_NuovoFascicolo.
     * 
     * @return annotazioni
     */
    public java.lang.String getAnnotazioni() {
        return annotazioni;
    }


    /**
     * Sets the annotazioni value for this WS_NuovoFascicolo.
     * 
     * @param annotazioni
     */
    public void setAnnotazioni(java.lang.String annotazioni) {
        this.annotazioni = annotazioni;
    }


    /**
     * Gets the codicePratica value for this WS_NuovoFascicolo.
     * 
     * @return codicePratica
     */
    public java.lang.String getCodicePratica() {
        return codicePratica;
    }


    /**
     * Sets the codicePratica value for this WS_NuovoFascicolo.
     * 
     * @param codicePratica
     */
    public void setCodicePratica(java.lang.String codicePratica) {
        this.codicePratica = codicePratica;
    }


    /**
     * Gets the cup value for this WS_NuovoFascicolo.
     * 
     * @return cup
     */
    public java.lang.String getCup() {
        return cup;
    }


    /**
     * Sets the cup value for this WS_NuovoFascicolo.
     * 
     * @param cup
     */
    public void setCup(java.lang.String cup) {
        this.cup = cup;
    }


    /**
     * Gets the descrizione value for this WS_NuovoFascicolo.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_NuovoFascicolo.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the flagDatiPersonali value for this WS_NuovoFascicolo.
     * 
     * @return flagDatiPersonali
     */
    public java.lang.Boolean getFlagDatiPersonali() {
        return flagDatiPersonali;
    }


    /**
     * Sets the flagDatiPersonali value for this WS_NuovoFascicolo.
     * 
     * @param flagDatiPersonali
     */
    public void setFlagDatiPersonali(java.lang.Boolean flagDatiPersonali) {
        this.flagDatiPersonali = flagDatiPersonali;
    }


    /**
     * Gets the flagDatiRiservati value for this WS_NuovoFascicolo.
     * 
     * @return flagDatiRiservati
     */
    public java.lang.Boolean getFlagDatiRiservati() {
        return flagDatiRiservati;
    }


    /**
     * Sets the flagDatiRiservati value for this WS_NuovoFascicolo.
     * 
     * @param flagDatiRiservati
     */
    public void setFlagDatiRiservati(java.lang.Boolean flagDatiRiservati) {
        this.flagDatiRiservati = flagDatiRiservati;
    }


    /**
     * Gets the flagDatiSensibili value for this WS_NuovoFascicolo.
     * 
     * @return flagDatiSensibili
     */
    public java.lang.Boolean getFlagDatiSensibili() {
        return flagDatiSensibili;
    }


    /**
     * Sets the flagDatiSensibili value for this WS_NuovoFascicolo.
     * 
     * @param flagDatiSensibili
     */
    public void setFlagDatiSensibili(java.lang.Boolean flagDatiSensibili) {
        this.flagDatiSensibili = flagDatiSensibili;
    }


    /**
     * Gets the idBando value for this WS_NuovoFascicolo.
     * 
     * @return idBando
     */
    public java.lang.String getIdBando() {
        return idBando;
    }


    /**
     * Sets the idBando value for this WS_NuovoFascicolo.
     * 
     * @param idBando
     */
    public void setIdBando(java.lang.String idBando) {
        this.idBando = idBando;
    }


    /**
     * Gets the idPadre value for this WS_NuovoFascicolo.
     * 
     * @return idPadre
     */
    public java.lang.String getIdPadre() {
        return idPadre;
    }


    /**
     * Sets the idPadre value for this WS_NuovoFascicolo.
     * 
     * @param idPadre
     */
    public void setIdPadre(java.lang.String idPadre) {
        this.idPadre = idPadre;
    }


    /**
     * Gets the idTitolario value for this WS_NuovoFascicolo.
     * 
     * @return idTitolario
     */
    public java.lang.String getIdTitolario() {
        return idTitolario;
    }


    /**
     * Sets the idTitolario value for this WS_NuovoFascicolo.
     * 
     * @param idTitolario
     */
    public void setIdTitolario(java.lang.String idTitolario) {
        this.idTitolario = idTitolario;
    }


    /**
     * Gets the idVoceTitolario value for this WS_NuovoFascicolo.
     * 
     * @return idVoceTitolario
     */
    public java.lang.String getIdVoceTitolario() {
        return idVoceTitolario;
    }


    /**
     * Sets the idVoceTitolario value for this WS_NuovoFascicolo.
     * 
     * @param idVoceTitolario
     */
    public void setIdVoceTitolario(java.lang.String idVoceTitolario) {
        this.idVoceTitolario = idVoceTitolario;
    }


    /**
     * Gets the localizzazione value for this WS_NuovoFascicolo.
     * 
     * @return localizzazione
     */
    public java.lang.String getLocalizzazione() {
        return localizzazione;
    }


    /**
     * Sets the localizzazione value for this WS_NuovoFascicolo.
     * 
     * @param localizzazione
     */
    public void setLocalizzazione(java.lang.String localizzazione) {
        this.localizzazione = localizzazione;
    }


    /**
     * Gets the mir value for this WS_NuovoFascicolo.
     * 
     * @return mir
     */
    public java.lang.String getMir() {
        return mir;
    }


    /**
     * Sets the mir value for this WS_NuovoFascicolo.
     * 
     * @param mir
     */
    public void setMir(java.lang.String mir) {
        this.mir = mir;
    }


    /**
     * Gets the nomeAggregato value for this WS_NuovoFascicolo.
     * 
     * @return nomeAggregato
     */
    public java.lang.String getNomeAggregato() {
        return nomeAggregato;
    }


    /**
     * Sets the nomeAggregato value for this WS_NuovoFascicolo.
     * 
     * @param nomeAggregato
     */
    public void setNomeAggregato(java.lang.String nomeAggregato) {
        this.nomeAggregato = nomeAggregato;
    }


    /**
     * Gets the numerazione value for this WS_NuovoFascicolo.
     * 
     * @return numerazione
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo getNumerazione() {
        return numerazione;
    }


    /**
     * Sets the numerazione value for this WS_NuovoFascicolo.
     * 
     * @param numerazione
     */
    public void setNumerazione(it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo numerazione) {
        this.numerazione = numerazione;
    }


    /**
     * Gets the oggetto value for this WS_NuovoFascicolo.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this WS_NuovoFascicolo.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the permessi value for this WS_NuovoFascicolo.
     * 
     * @return permessi
     */
    public it.sincon.gepred.documentale.diogene.bean.Permesso[] getPermessi() {
        return permessi;
    }


    /**
     * Sets the permessi value for this WS_NuovoFascicolo.
     * 
     * @param permessi
     */
    public void setPermessi(it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi) {
        this.permessi = permessi;
    }


    /**
     * Gets the protocollo value for this WS_NuovoFascicolo.
     * 
     * @return protocollo
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Protocollo getProtocollo() {
        return protocollo;
    }


    /**
     * Sets the protocollo value for this WS_NuovoFascicolo.
     * 
     * @param protocollo
     */
    public void setProtocollo(it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo) {
        this.protocollo = protocollo;
    }


    /**
     * Gets the soggetto value for this WS_NuovoFascicolo.
     * 
     * @return soggetto
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo getSoggetto() {
        return soggetto;
    }


    /**
     * Sets the soggetto value for this WS_NuovoFascicolo.
     * 
     * @param soggetto
     */
    public void setSoggetto(it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo soggetto) {
        this.soggetto = soggetto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_NuovoFascicolo)) return false;
        WS_NuovoFascicolo other = (WS_NuovoFascicolo) obj;
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
            ((this.codicePratica==null && other.getCodicePratica()==null) || 
             (this.codicePratica!=null &&
              this.codicePratica.equals(other.getCodicePratica()))) &&
            ((this.cup==null && other.getCup()==null) || 
             (this.cup!=null &&
              this.cup.equals(other.getCup()))) &&
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.flagDatiPersonali==null && other.getFlagDatiPersonali()==null) || 
             (this.flagDatiPersonali!=null &&
              this.flagDatiPersonali.equals(other.getFlagDatiPersonali()))) &&
            ((this.flagDatiRiservati==null && other.getFlagDatiRiservati()==null) || 
             (this.flagDatiRiservati!=null &&
              this.flagDatiRiservati.equals(other.getFlagDatiRiservati()))) &&
            ((this.flagDatiSensibili==null && other.getFlagDatiSensibili()==null) || 
             (this.flagDatiSensibili!=null &&
              this.flagDatiSensibili.equals(other.getFlagDatiSensibili()))) &&
            ((this.idBando==null && other.getIdBando()==null) || 
             (this.idBando!=null &&
              this.idBando.equals(other.getIdBando()))) &&
            ((this.idPadre==null && other.getIdPadre()==null) || 
             (this.idPadre!=null &&
              this.idPadre.equals(other.getIdPadre()))) &&
            ((this.idTitolario==null && other.getIdTitolario()==null) || 
             (this.idTitolario!=null &&
              this.idTitolario.equals(other.getIdTitolario()))) &&
            ((this.idVoceTitolario==null && other.getIdVoceTitolario()==null) || 
             (this.idVoceTitolario!=null &&
              this.idVoceTitolario.equals(other.getIdVoceTitolario()))) &&
            ((this.localizzazione==null && other.getLocalizzazione()==null) || 
             (this.localizzazione!=null &&
              this.localizzazione.equals(other.getLocalizzazione()))) &&
            ((this.mir==null && other.getMir()==null) || 
             (this.mir!=null &&
              this.mir.equals(other.getMir()))) &&
            ((this.nomeAggregato==null && other.getNomeAggregato()==null) || 
             (this.nomeAggregato!=null &&
              this.nomeAggregato.equals(other.getNomeAggregato()))) &&
            ((this.numerazione==null && other.getNumerazione()==null) || 
             (this.numerazione!=null &&
              this.numerazione.equals(other.getNumerazione()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
            ((this.permessi==null && other.getPermessi()==null) || 
             (this.permessi!=null &&
              java.util.Arrays.equals(this.permessi, other.getPermessi()))) &&
            ((this.protocollo==null && other.getProtocollo()==null) || 
             (this.protocollo!=null &&
              this.protocollo.equals(other.getProtocollo()))) &&
            ((this.soggetto==null && other.getSoggetto()==null) || 
             (this.soggetto!=null &&
              this.soggetto.equals(other.getSoggetto())));
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
        if (getCodicePratica() != null) {
            _hashCode += getCodicePratica().hashCode();
        }
        if (getCup() != null) {
            _hashCode += getCup().hashCode();
        }
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getFlagDatiPersonali() != null) {
            _hashCode += getFlagDatiPersonali().hashCode();
        }
        if (getFlagDatiRiservati() != null) {
            _hashCode += getFlagDatiRiservati().hashCode();
        }
        if (getFlagDatiSensibili() != null) {
            _hashCode += getFlagDatiSensibili().hashCode();
        }
        if (getIdBando() != null) {
            _hashCode += getIdBando().hashCode();
        }
        if (getIdPadre() != null) {
            _hashCode += getIdPadre().hashCode();
        }
        if (getIdTitolario() != null) {
            _hashCode += getIdTitolario().hashCode();
        }
        if (getIdVoceTitolario() != null) {
            _hashCode += getIdVoceTitolario().hashCode();
        }
        if (getLocalizzazione() != null) {
            _hashCode += getLocalizzazione().hashCode();
        }
        if (getMir() != null) {
            _hashCode += getMir().hashCode();
        }
        if (getNomeAggregato() != null) {
            _hashCode += getNomeAggregato().hashCode();
        }
        if (getNumerazione() != null) {
            _hashCode += getNumerazione().hashCode();
        }
        if (getOggetto() != null) {
            _hashCode += getOggetto().hashCode();
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
        if (getProtocollo() != null) {
            _hashCode += getProtocollo().hashCode();
        }
        if (getSoggetto() != null) {
            _hashCode += getSoggetto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_NuovoFascicolo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovoFascicolo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotazioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "annotazioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codicePratica");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "codicePratica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "cup"));
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
        elemField.setFieldName("flagDatiPersonali");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "flagDatiPersonali"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagDatiRiservati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "flagDatiRiservati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagDatiSensibili");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "flagDatiSensibili"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idBando");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idBando"));
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
        elemField.setFieldName("idTitolario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idTitolario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idVoceTitolario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idVoceTitolario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localizzazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "localizzazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mir");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "mir"));
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
        elemField.setFieldName("numerazione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "numerazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NumerazioneFascicolo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "oggetto"));
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
        elemField.setFieldName("protocollo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "protocollo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Protocollo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("soggetto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "soggetto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_SoggettoFascicolo"));
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
