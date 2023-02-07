/**
 * WS_FascicoloReale.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_FascicoloReale  extends it.sincon.gepred.documentale.diogene.bean.WS_Aggregato  implements java.io.Serializable {
    private java.lang.String annotazioni;

    private java.lang.String codicePratica;

    private java.lang.String cup;

    private java.lang.String dataFine;

    private java.lang.String dataInizio;

    private java.lang.String descrizione;

    private java.lang.Boolean flagDatiPersonali;

    private java.lang.Boolean flagDatiRiservati;

    private java.lang.Boolean flagDatiSensibili;

    private java.lang.String idBando;

    private java.lang.String idPadreReale;

    private java.lang.String idTitolario;

    private java.lang.String idVoceTitolario;

    private java.lang.String localizzazione;

    private java.lang.String mir;

    private it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo numerazione;

    private java.lang.String oggetto;

    private it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo;

    private it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo soggetto;

    public WS_FascicoloReale() {
    }

    public WS_FascicoloReale(
           java.lang.String dataCreazione,
           java.lang.String idAggregato,
           java.lang.String idPadre,
           java.lang.String nomeAggregato,
           java.lang.String owner,
           java.lang.String path,
           it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi,
           java.lang.String stato,
           java.lang.String tipoAggregato,
           java.lang.String annotazioni,
           java.lang.String codicePratica,
           java.lang.String cup,
           java.lang.String dataFine,
           java.lang.String dataInizio,
           java.lang.String descrizione,
           java.lang.Boolean flagDatiPersonali,
           java.lang.Boolean flagDatiRiservati,
           java.lang.Boolean flagDatiSensibili,
           java.lang.String idBando,
           java.lang.String idPadreReale,
           java.lang.String idTitolario,
           java.lang.String idVoceTitolario,
           java.lang.String localizzazione,
           java.lang.String mir,
           it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo numerazione,
           java.lang.String oggetto,
           it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo,
           it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo soggetto) {
        super(
            dataCreazione,
            idAggregato,
            idPadre,
            nomeAggregato,
            owner,
            path,
            permessi,
            stato,
            tipoAggregato);
        this.annotazioni = annotazioni;
        this.codicePratica = codicePratica;
        this.cup = cup;
        this.dataFine = dataFine;
        this.dataInizio = dataInizio;
        this.descrizione = descrizione;
        this.flagDatiPersonali = flagDatiPersonali;
        this.flagDatiRiservati = flagDatiRiservati;
        this.flagDatiSensibili = flagDatiSensibili;
        this.idBando = idBando;
        this.idPadreReale = idPadreReale;
        this.idTitolario = idTitolario;
        this.idVoceTitolario = idVoceTitolario;
        this.localizzazione = localizzazione;
        this.mir = mir;
        this.numerazione = numerazione;
        this.oggetto = oggetto;
        this.protocollo = protocollo;
        this.soggetto = soggetto;
    }


    /**
     * Gets the annotazioni value for this WS_FascicoloReale.
     * 
     * @return annotazioni
     */
    public java.lang.String getAnnotazioni() {
        return annotazioni;
    }


    /**
     * Sets the annotazioni value for this WS_FascicoloReale.
     * 
     * @param annotazioni
     */
    public void setAnnotazioni(java.lang.String annotazioni) {
        this.annotazioni = annotazioni;
    }


    /**
     * Gets the codicePratica value for this WS_FascicoloReale.
     * 
     * @return codicePratica
     */
    public java.lang.String getCodicePratica() {
        return codicePratica;
    }


    /**
     * Sets the codicePratica value for this WS_FascicoloReale.
     * 
     * @param codicePratica
     */
    public void setCodicePratica(java.lang.String codicePratica) {
        this.codicePratica = codicePratica;
    }


    /**
     * Gets the cup value for this WS_FascicoloReale.
     * 
     * @return cup
     */
    public java.lang.String getCup() {
        return cup;
    }


    /**
     * Sets the cup value for this WS_FascicoloReale.
     * 
     * @param cup
     */
    public void setCup(java.lang.String cup) {
        this.cup = cup;
    }


    /**
     * Gets the dataFine value for this WS_FascicoloReale.
     * 
     * @return dataFine
     */
    public java.lang.String getDataFine() {
        return dataFine;
    }


    /**
     * Sets the dataFine value for this WS_FascicoloReale.
     * 
     * @param dataFine
     */
    public void setDataFine(java.lang.String dataFine) {
        this.dataFine = dataFine;
    }


    /**
     * Gets the dataInizio value for this WS_FascicoloReale.
     * 
     * @return dataInizio
     */
    public java.lang.String getDataInizio() {
        return dataInizio;
    }


    /**
     * Sets the dataInizio value for this WS_FascicoloReale.
     * 
     * @param dataInizio
     */
    public void setDataInizio(java.lang.String dataInizio) {
        this.dataInizio = dataInizio;
    }


    /**
     * Gets the descrizione value for this WS_FascicoloReale.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_FascicoloReale.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the flagDatiPersonali value for this WS_FascicoloReale.
     * 
     * @return flagDatiPersonali
     */
    public java.lang.Boolean getFlagDatiPersonali() {
        return flagDatiPersonali;
    }


    /**
     * Sets the flagDatiPersonali value for this WS_FascicoloReale.
     * 
     * @param flagDatiPersonali
     */
    public void setFlagDatiPersonali(java.lang.Boolean flagDatiPersonali) {
        this.flagDatiPersonali = flagDatiPersonali;
    }


    /**
     * Gets the flagDatiRiservati value for this WS_FascicoloReale.
     * 
     * @return flagDatiRiservati
     */
    public java.lang.Boolean getFlagDatiRiservati() {
        return flagDatiRiservati;
    }


    /**
     * Sets the flagDatiRiservati value for this WS_FascicoloReale.
     * 
     * @param flagDatiRiservati
     */
    public void setFlagDatiRiservati(java.lang.Boolean flagDatiRiservati) {
        this.flagDatiRiservati = flagDatiRiservati;
    }


    /**
     * Gets the flagDatiSensibili value for this WS_FascicoloReale.
     * 
     * @return flagDatiSensibili
     */
    public java.lang.Boolean getFlagDatiSensibili() {
        return flagDatiSensibili;
    }


    /**
     * Sets the flagDatiSensibili value for this WS_FascicoloReale.
     * 
     * @param flagDatiSensibili
     */
    public void setFlagDatiSensibili(java.lang.Boolean flagDatiSensibili) {
        this.flagDatiSensibili = flagDatiSensibili;
    }


    /**
     * Gets the idBando value for this WS_FascicoloReale.
     * 
     * @return idBando
     */
    public java.lang.String getIdBando() {
        return idBando;
    }


    /**
     * Sets the idBando value for this WS_FascicoloReale.
     * 
     * @param idBando
     */
    public void setIdBando(java.lang.String idBando) {
        this.idBando = idBando;
    }


    /**
     * Gets the idPadreReale value for this WS_FascicoloReale.
     * 
     * @return idPadreReale
     */
    public java.lang.String getIdPadreReale() {
        return idPadreReale;
    }


    /**
     * Sets the idPadreReale value for this WS_FascicoloReale.
     * 
     * @param idPadreReale
     */
    public void setIdPadreReale(java.lang.String idPadreReale) {
        this.idPadreReale = idPadreReale;
    }


    /**
     * Gets the idTitolario value for this WS_FascicoloReale.
     * 
     * @return idTitolario
     */
    public java.lang.String getIdTitolario() {
        return idTitolario;
    }


    /**
     * Sets the idTitolario value for this WS_FascicoloReale.
     * 
     * @param idTitolario
     */
    public void setIdTitolario(java.lang.String idTitolario) {
        this.idTitolario = idTitolario;
    }


    /**
     * Gets the idVoceTitolario value for this WS_FascicoloReale.
     * 
     * @return idVoceTitolario
     */
    public java.lang.String getIdVoceTitolario() {
        return idVoceTitolario;
    }


    /**
     * Sets the idVoceTitolario value for this WS_FascicoloReale.
     * 
     * @param idVoceTitolario
     */
    public void setIdVoceTitolario(java.lang.String idVoceTitolario) {
        this.idVoceTitolario = idVoceTitolario;
    }


    /**
     * Gets the localizzazione value for this WS_FascicoloReale.
     * 
     * @return localizzazione
     */
    public java.lang.String getLocalizzazione() {
        return localizzazione;
    }


    /**
     * Sets the localizzazione value for this WS_FascicoloReale.
     * 
     * @param localizzazione
     */
    public void setLocalizzazione(java.lang.String localizzazione) {
        this.localizzazione = localizzazione;
    }


    /**
     * Gets the mir value for this WS_FascicoloReale.
     * 
     * @return mir
     */
    public java.lang.String getMir() {
        return mir;
    }


    /**
     * Sets the mir value for this WS_FascicoloReale.
     * 
     * @param mir
     */
    public void setMir(java.lang.String mir) {
        this.mir = mir;
    }


    /**
     * Gets the numerazione value for this WS_FascicoloReale.
     * 
     * @return numerazione
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo getNumerazione() {
        return numerazione;
    }


    /**
     * Sets the numerazione value for this WS_FascicoloReale.
     * 
     * @param numerazione
     */
    public void setNumerazione(it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo numerazione) {
        this.numerazione = numerazione;
    }


    /**
     * Gets the oggetto value for this WS_FascicoloReale.
     * 
     * @return oggetto
     */
    public java.lang.String getOggetto() {
        return oggetto;
    }


    /**
     * Sets the oggetto value for this WS_FascicoloReale.
     * 
     * @param oggetto
     */
    public void setOggetto(java.lang.String oggetto) {
        this.oggetto = oggetto;
    }


    /**
     * Gets the protocollo value for this WS_FascicoloReale.
     * 
     * @return protocollo
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Protocollo getProtocollo() {
        return protocollo;
    }


    /**
     * Sets the protocollo value for this WS_FascicoloReale.
     * 
     * @param protocollo
     */
    public void setProtocollo(it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo) {
        this.protocollo = protocollo;
    }


    /**
     * Gets the soggetto value for this WS_FascicoloReale.
     * 
     * @return soggetto
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo getSoggetto() {
        return soggetto;
    }


    /**
     * Sets the soggetto value for this WS_FascicoloReale.
     * 
     * @param soggetto
     */
    public void setSoggetto(it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo soggetto) {
        this.soggetto = soggetto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_FascicoloReale)) return false;
        WS_FascicoloReale other = (WS_FascicoloReale) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.annotazioni==null && other.getAnnotazioni()==null) || 
             (this.annotazioni!=null &&
              this.annotazioni.equals(other.getAnnotazioni()))) &&
            ((this.codicePratica==null && other.getCodicePratica()==null) || 
             (this.codicePratica!=null &&
              this.codicePratica.equals(other.getCodicePratica()))) &&
            ((this.cup==null && other.getCup()==null) || 
             (this.cup!=null &&
              this.cup.equals(other.getCup()))) &&
            ((this.dataFine==null && other.getDataFine()==null) || 
             (this.dataFine!=null &&
              this.dataFine.equals(other.getDataFine()))) &&
            ((this.dataInizio==null && other.getDataInizio()==null) || 
             (this.dataInizio!=null &&
              this.dataInizio.equals(other.getDataInizio()))) &&
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
            ((this.idPadreReale==null && other.getIdPadreReale()==null) || 
             (this.idPadreReale!=null &&
              this.idPadreReale.equals(other.getIdPadreReale()))) &&
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
            ((this.numerazione==null && other.getNumerazione()==null) || 
             (this.numerazione!=null &&
              this.numerazione.equals(other.getNumerazione()))) &&
            ((this.oggetto==null && other.getOggetto()==null) || 
             (this.oggetto!=null &&
              this.oggetto.equals(other.getOggetto()))) &&
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
        int _hashCode = super.hashCode();
        if (getAnnotazioni() != null) {
            _hashCode += getAnnotazioni().hashCode();
        }
        if (getCodicePratica() != null) {
            _hashCode += getCodicePratica().hashCode();
        }
        if (getCup() != null) {
            _hashCode += getCup().hashCode();
        }
        if (getDataFine() != null) {
            _hashCode += getDataFine().hashCode();
        }
        if (getDataInizio() != null) {
            _hashCode += getDataInizio().hashCode();
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
        if (getIdPadreReale() != null) {
            _hashCode += getIdPadreReale().hashCode();
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
        if (getNumerazione() != null) {
            _hashCode += getNumerazione().hashCode();
        }
        if (getOggetto() != null) {
            _hashCode += getOggetto().hashCode();
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
        new org.apache.axis.description.TypeDesc(WS_FascicoloReale.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FascicoloReale"));
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
        elemField.setFieldName("dataFine");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataFine"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInizio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataInizio"));
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
        elemField.setFieldName("idPadreReale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idPadreReale"));
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
