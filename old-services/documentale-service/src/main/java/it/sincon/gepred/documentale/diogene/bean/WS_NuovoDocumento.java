/**
 * WS_NuovoDocumento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_NuovoDocumento  implements java.io.Serializable {
    private java.lang.String annotazioni;

    private java.lang.String canaleInvio;

    private java.lang.String canaleRicezione;

    private java.lang.String cifra;

    private java.lang.String dataDocumento;

    private java.lang.String dataRicevimento;

    private java.lang.String dataTrasmissione;

    private java.lang.String descrizione;

    private java.lang.String destinatario;

    private it.sincon.gepred.documentale.diogene.bean.WS_FileType file;

    private java.lang.Boolean flagDatiPersonali;

    private java.lang.Boolean flagDatiRiservati;

    private java.lang.Boolean flagDatiSensibili;

    private java.lang.String idAggregatoContenitore;

    private java.lang.String idDocumentoPadre;

    private java.lang.String localizzazione;

    private java.lang.String luogoDocumento;

    private java.lang.String mimeType;

    private java.lang.String mittente;

    private java.lang.String natura;

    private it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi;

    private it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo;

    private it.sincon.gepred.documentale.diogene.bean.WS_Repertorio repertorio;

    private java.lang.String stato;

    private java.lang.String tipoCanaleInvio;

    private java.lang.String tipoCanaleRicezione;

    private java.lang.String tipoDocumento;

    private it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento tipologia;

    private java.lang.String titolo;

    public WS_NuovoDocumento() {
    }

    public WS_NuovoDocumento(
           java.lang.String annotazioni,
           java.lang.String canaleInvio,
           java.lang.String canaleRicezione,
           java.lang.String cifra,
           java.lang.String dataDocumento,
           java.lang.String dataRicevimento,
           java.lang.String dataTrasmissione,
           java.lang.String descrizione,
           java.lang.String destinatario,
           it.sincon.gepred.documentale.diogene.bean.WS_FileType file,
           java.lang.Boolean flagDatiPersonali,
           java.lang.Boolean flagDatiRiservati,
           java.lang.Boolean flagDatiSensibili,
           java.lang.String idAggregatoContenitore,
           java.lang.String idDocumentoPadre,
           java.lang.String localizzazione,
           java.lang.String luogoDocumento,
           java.lang.String mimeType,
           java.lang.String mittente,
           java.lang.String natura,
           it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi,
           it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo,
           it.sincon.gepred.documentale.diogene.bean.WS_Repertorio repertorio,
           java.lang.String stato,
           java.lang.String tipoCanaleInvio,
           java.lang.String tipoCanaleRicezione,
           java.lang.String tipoDocumento,
           it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento tipologia,
           java.lang.String titolo) {
           this.annotazioni = annotazioni;
           this.canaleInvio = canaleInvio;
           this.canaleRicezione = canaleRicezione;
           this.cifra = cifra;
           this.dataDocumento = dataDocumento;
           this.dataRicevimento = dataRicevimento;
           this.dataTrasmissione = dataTrasmissione;
           this.descrizione = descrizione;
           this.destinatario = destinatario;
           this.file = file;
           this.flagDatiPersonali = flagDatiPersonali;
           this.flagDatiRiservati = flagDatiRiservati;
           this.flagDatiSensibili = flagDatiSensibili;
           this.idAggregatoContenitore = idAggregatoContenitore;
           this.idDocumentoPadre = idDocumentoPadre;
           this.localizzazione = localizzazione;
           this.luogoDocumento = luogoDocumento;
           this.mimeType = mimeType;
           this.mittente = mittente;
           this.natura = natura;
           this.permessi = permessi;
           this.protocollo = protocollo;
           this.repertorio = repertorio;
           this.stato = stato;
           this.tipoCanaleInvio = tipoCanaleInvio;
           this.tipoCanaleRicezione = tipoCanaleRicezione;
           this.tipoDocumento = tipoDocumento;
           this.tipologia = tipologia;
           this.titolo = titolo;
    }


    /**
     * Gets the annotazioni value for this WS_NuovoDocumento.
     * 
     * @return annotazioni
     */
    public java.lang.String getAnnotazioni() {
        return annotazioni;
    }


    /**
     * Sets the annotazioni value for this WS_NuovoDocumento.
     * 
     * @param annotazioni
     */
    public void setAnnotazioni(java.lang.String annotazioni) {
        this.annotazioni = annotazioni;
    }


    /**
     * Gets the canaleInvio value for this WS_NuovoDocumento.
     * 
     * @return canaleInvio
     */
    public java.lang.String getCanaleInvio() {
        return canaleInvio;
    }


    /**
     * Sets the canaleInvio value for this WS_NuovoDocumento.
     * 
     * @param canaleInvio
     */
    public void setCanaleInvio(java.lang.String canaleInvio) {
        this.canaleInvio = canaleInvio;
    }


    /**
     * Gets the canaleRicezione value for this WS_NuovoDocumento.
     * 
     * @return canaleRicezione
     */
    public java.lang.String getCanaleRicezione() {
        return canaleRicezione;
    }


    /**
     * Sets the canaleRicezione value for this WS_NuovoDocumento.
     * 
     * @param canaleRicezione
     */
    public void setCanaleRicezione(java.lang.String canaleRicezione) {
        this.canaleRicezione = canaleRicezione;
    }


    /**
     * Gets the cifra value for this WS_NuovoDocumento.
     * 
     * @return cifra
     */
    public java.lang.String getCifra() {
        return cifra;
    }


    /**
     * Sets the cifra value for this WS_NuovoDocumento.
     * 
     * @param cifra
     */
    public void setCifra(java.lang.String cifra) {
        this.cifra = cifra;
    }


    /**
     * Gets the dataDocumento value for this WS_NuovoDocumento.
     * 
     * @return dataDocumento
     */
    public java.lang.String getDataDocumento() {
        return dataDocumento;
    }


    /**
     * Sets the dataDocumento value for this WS_NuovoDocumento.
     * 
     * @param dataDocumento
     */
    public void setDataDocumento(java.lang.String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }


    /**
     * Gets the dataRicevimento value for this WS_NuovoDocumento.
     * 
     * @return dataRicevimento
     */
    public java.lang.String getDataRicevimento() {
        return dataRicevimento;
    }


    /**
     * Sets the dataRicevimento value for this WS_NuovoDocumento.
     * 
     * @param dataRicevimento
     */
    public void setDataRicevimento(java.lang.String dataRicevimento) {
        this.dataRicevimento = dataRicevimento;
    }


    /**
     * Gets the dataTrasmissione value for this WS_NuovoDocumento.
     * 
     * @return dataTrasmissione
     */
    public java.lang.String getDataTrasmissione() {
        return dataTrasmissione;
    }


    /**
     * Sets the dataTrasmissione value for this WS_NuovoDocumento.
     * 
     * @param dataTrasmissione
     */
    public void setDataTrasmissione(java.lang.String dataTrasmissione) {
        this.dataTrasmissione = dataTrasmissione;
    }


    /**
     * Gets the descrizione value for this WS_NuovoDocumento.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_NuovoDocumento.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the destinatario value for this WS_NuovoDocumento.
     * 
     * @return destinatario
     */
    public java.lang.String getDestinatario() {
        return destinatario;
    }


    /**
     * Sets the destinatario value for this WS_NuovoDocumento.
     * 
     * @param destinatario
     */
    public void setDestinatario(java.lang.String destinatario) {
        this.destinatario = destinatario;
    }


    /**
     * Gets the file value for this WS_NuovoDocumento.
     * 
     * @return file
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_FileType getFile() {
        return file;
    }


    /**
     * Sets the file value for this WS_NuovoDocumento.
     * 
     * @param file
     */
    public void setFile(it.sincon.gepred.documentale.diogene.bean.WS_FileType file) {
        this.file = file;
    }


    /**
     * Gets the flagDatiPersonali value for this WS_NuovoDocumento.
     * 
     * @return flagDatiPersonali
     */
    public java.lang.Boolean getFlagDatiPersonali() {
        return flagDatiPersonali;
    }


    /**
     * Sets the flagDatiPersonali value for this WS_NuovoDocumento.
     * 
     * @param flagDatiPersonali
     */
    public void setFlagDatiPersonali(java.lang.Boolean flagDatiPersonali) {
        this.flagDatiPersonali = flagDatiPersonali;
    }


    /**
     * Gets the flagDatiRiservati value for this WS_NuovoDocumento.
     * 
     * @return flagDatiRiservati
     */
    public java.lang.Boolean getFlagDatiRiservati() {
        return flagDatiRiservati;
    }


    /**
     * Sets the flagDatiRiservati value for this WS_NuovoDocumento.
     * 
     * @param flagDatiRiservati
     */
    public void setFlagDatiRiservati(java.lang.Boolean flagDatiRiservati) {
        this.flagDatiRiservati = flagDatiRiservati;
    }


    /**
     * Gets the flagDatiSensibili value for this WS_NuovoDocumento.
     * 
     * @return flagDatiSensibili
     */
    public java.lang.Boolean getFlagDatiSensibili() {
        return flagDatiSensibili;
    }


    /**
     * Sets the flagDatiSensibili value for this WS_NuovoDocumento.
     * 
     * @param flagDatiSensibili
     */
    public void setFlagDatiSensibili(java.lang.Boolean flagDatiSensibili) {
        this.flagDatiSensibili = flagDatiSensibili;
    }


    /**
     * Gets the idAggregatoContenitore value for this WS_NuovoDocumento.
     * 
     * @return idAggregatoContenitore
     */
    public java.lang.String getIdAggregatoContenitore() {
        return idAggregatoContenitore;
    }


    /**
     * Sets the idAggregatoContenitore value for this WS_NuovoDocumento.
     * 
     * @param idAggregatoContenitore
     */
    public void setIdAggregatoContenitore(java.lang.String idAggregatoContenitore) {
        this.idAggregatoContenitore = idAggregatoContenitore;
    }


    /**
     * Gets the idDocumentoPadre value for this WS_NuovoDocumento.
     * 
     * @return idDocumentoPadre
     */
    public java.lang.String getIdDocumentoPadre() {
        return idDocumentoPadre;
    }


    /**
     * Sets the idDocumentoPadre value for this WS_NuovoDocumento.
     * 
     * @param idDocumentoPadre
     */
    public void setIdDocumentoPadre(java.lang.String idDocumentoPadre) {
        this.idDocumentoPadre = idDocumentoPadre;
    }


    /**
     * Gets the localizzazione value for this WS_NuovoDocumento.
     * 
     * @return localizzazione
     */
    public java.lang.String getLocalizzazione() {
        return localizzazione;
    }


    /**
     * Sets the localizzazione value for this WS_NuovoDocumento.
     * 
     * @param localizzazione
     */
    public void setLocalizzazione(java.lang.String localizzazione) {
        this.localizzazione = localizzazione;
    }


    /**
     * Gets the luogoDocumento value for this WS_NuovoDocumento.
     * 
     * @return luogoDocumento
     */
    public java.lang.String getLuogoDocumento() {
        return luogoDocumento;
    }


    /**
     * Sets the luogoDocumento value for this WS_NuovoDocumento.
     * 
     * @param luogoDocumento
     */
    public void setLuogoDocumento(java.lang.String luogoDocumento) {
        this.luogoDocumento = luogoDocumento;
    }


    /**
     * Gets the mimeType value for this WS_NuovoDocumento.
     * 
     * @return mimeType
     */
    public java.lang.String getMimeType() {
        return mimeType;
    }


    /**
     * Sets the mimeType value for this WS_NuovoDocumento.
     * 
     * @param mimeType
     */
    public void setMimeType(java.lang.String mimeType) {
        this.mimeType = mimeType;
    }


    /**
     * Gets the mittente value for this WS_NuovoDocumento.
     * 
     * @return mittente
     */
    public java.lang.String getMittente() {
        return mittente;
    }


    /**
     * Sets the mittente value for this WS_NuovoDocumento.
     * 
     * @param mittente
     */
    public void setMittente(java.lang.String mittente) {
        this.mittente = mittente;
    }


    /**
     * Gets the natura value for this WS_NuovoDocumento.
     * 
     * @return natura
     */
    public java.lang.String getNatura() {
        return natura;
    }


    /**
     * Sets the natura value for this WS_NuovoDocumento.
     * 
     * @param natura
     */
    public void setNatura(java.lang.String natura) {
        this.natura = natura;
    }


    /**
     * Gets the permessi value for this WS_NuovoDocumento.
     * 
     * @return permessi
     */
    public it.sincon.gepred.documentale.diogene.bean.Permesso[] getPermessi() {
        return permessi;
    }


    /**
     * Sets the permessi value for this WS_NuovoDocumento.
     * 
     * @param permessi
     */
    public void setPermessi(it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi) {
        this.permessi = permessi;
    }


    /**
     * Gets the protocollo value for this WS_NuovoDocumento.
     * 
     * @return protocollo
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Protocollo getProtocollo() {
        return protocollo;
    }


    /**
     * Sets the protocollo value for this WS_NuovoDocumento.
     * 
     * @param protocollo
     */
    public void setProtocollo(it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo) {
        this.protocollo = protocollo;
    }


    /**
     * Gets the repertorio value for this WS_NuovoDocumento.
     * 
     * @return repertorio
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Repertorio getRepertorio() {
        return repertorio;
    }


    /**
     * Sets the repertorio value for this WS_NuovoDocumento.
     * 
     * @param repertorio
     */
    public void setRepertorio(it.sincon.gepred.documentale.diogene.bean.WS_Repertorio repertorio) {
        this.repertorio = repertorio;
    }


    /**
     * Gets the stato value for this WS_NuovoDocumento.
     * 
     * @return stato
     */
    public java.lang.String getStato() {
        return stato;
    }


    /**
     * Sets the stato value for this WS_NuovoDocumento.
     * 
     * @param stato
     */
    public void setStato(java.lang.String stato) {
        this.stato = stato;
    }


    /**
     * Gets the tipoCanaleInvio value for this WS_NuovoDocumento.
     * 
     * @return tipoCanaleInvio
     */
    public java.lang.String getTipoCanaleInvio() {
        return tipoCanaleInvio;
    }


    /**
     * Sets the tipoCanaleInvio value for this WS_NuovoDocumento.
     * 
     * @param tipoCanaleInvio
     */
    public void setTipoCanaleInvio(java.lang.String tipoCanaleInvio) {
        this.tipoCanaleInvio = tipoCanaleInvio;
    }


    /**
     * Gets the tipoCanaleRicezione value for this WS_NuovoDocumento.
     * 
     * @return tipoCanaleRicezione
     */
    public java.lang.String getTipoCanaleRicezione() {
        return tipoCanaleRicezione;
    }


    /**
     * Sets the tipoCanaleRicezione value for this WS_NuovoDocumento.
     * 
     * @param tipoCanaleRicezione
     */
    public void setTipoCanaleRicezione(java.lang.String tipoCanaleRicezione) {
        this.tipoCanaleRicezione = tipoCanaleRicezione;
    }


    /**
     * Gets the tipoDocumento value for this WS_NuovoDocumento.
     * 
     * @return tipoDocumento
     */
    public java.lang.String getTipoDocumento() {
        return tipoDocumento;
    }


    /**
     * Sets the tipoDocumento value for this WS_NuovoDocumento.
     * 
     * @param tipoDocumento
     */
    public void setTipoDocumento(java.lang.String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    /**
     * Gets the tipologia value for this WS_NuovoDocumento.
     * 
     * @return tipologia
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento getTipologia() {
        return tipologia;
    }


    /**
     * Sets the tipologia value for this WS_NuovoDocumento.
     * 
     * @param tipologia
     */
    public void setTipologia(it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento tipologia) {
        this.tipologia = tipologia;
    }


    /**
     * Gets the titolo value for this WS_NuovoDocumento.
     * 
     * @return titolo
     */
    public java.lang.String getTitolo() {
        return titolo;
    }


    /**
     * Sets the titolo value for this WS_NuovoDocumento.
     * 
     * @param titolo
     */
    public void setTitolo(java.lang.String titolo) {
        this.titolo = titolo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_NuovoDocumento)) return false;
        WS_NuovoDocumento other = (WS_NuovoDocumento) obj;
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
            ((this.canaleInvio==null && other.getCanaleInvio()==null) || 
             (this.canaleInvio!=null &&
              this.canaleInvio.equals(other.getCanaleInvio()))) &&
            ((this.canaleRicezione==null && other.getCanaleRicezione()==null) || 
             (this.canaleRicezione!=null &&
              this.canaleRicezione.equals(other.getCanaleRicezione()))) &&
            ((this.cifra==null && other.getCifra()==null) || 
             (this.cifra!=null &&
              this.cifra.equals(other.getCifra()))) &&
            ((this.dataDocumento==null && other.getDataDocumento()==null) || 
             (this.dataDocumento!=null &&
              this.dataDocumento.equals(other.getDataDocumento()))) &&
            ((this.dataRicevimento==null && other.getDataRicevimento()==null) || 
             (this.dataRicevimento!=null &&
              this.dataRicevimento.equals(other.getDataRicevimento()))) &&
            ((this.dataTrasmissione==null && other.getDataTrasmissione()==null) || 
             (this.dataTrasmissione!=null &&
              this.dataTrasmissione.equals(other.getDataTrasmissione()))) &&
            ((this.descrizione==null && other.getDescrizione()==null) || 
             (this.descrizione!=null &&
              this.descrizione.equals(other.getDescrizione()))) &&
            ((this.destinatario==null && other.getDestinatario()==null) || 
             (this.destinatario!=null &&
              this.destinatario.equals(other.getDestinatario()))) &&
            ((this.file==null && other.getFile()==null) || 
             (this.file!=null &&
              this.file.equals(other.getFile()))) &&
            ((this.flagDatiPersonali==null && other.getFlagDatiPersonali()==null) || 
             (this.flagDatiPersonali!=null &&
              this.flagDatiPersonali.equals(other.getFlagDatiPersonali()))) &&
            ((this.flagDatiRiservati==null && other.getFlagDatiRiservati()==null) || 
             (this.flagDatiRiservati!=null &&
              this.flagDatiRiservati.equals(other.getFlagDatiRiservati()))) &&
            ((this.flagDatiSensibili==null && other.getFlagDatiSensibili()==null) || 
             (this.flagDatiSensibili!=null &&
              this.flagDatiSensibili.equals(other.getFlagDatiSensibili()))) &&
            ((this.idAggregatoContenitore==null && other.getIdAggregatoContenitore()==null) || 
             (this.idAggregatoContenitore!=null &&
              this.idAggregatoContenitore.equals(other.getIdAggregatoContenitore()))) &&
            ((this.idDocumentoPadre==null && other.getIdDocumentoPadre()==null) || 
             (this.idDocumentoPadre!=null &&
              this.idDocumentoPadre.equals(other.getIdDocumentoPadre()))) &&
            ((this.localizzazione==null && other.getLocalizzazione()==null) || 
             (this.localizzazione!=null &&
              this.localizzazione.equals(other.getLocalizzazione()))) &&
            ((this.luogoDocumento==null && other.getLuogoDocumento()==null) || 
             (this.luogoDocumento!=null &&
              this.luogoDocumento.equals(other.getLuogoDocumento()))) &&
            ((this.mimeType==null && other.getMimeType()==null) || 
             (this.mimeType!=null &&
              this.mimeType.equals(other.getMimeType()))) &&
            ((this.mittente==null && other.getMittente()==null) || 
             (this.mittente!=null &&
              this.mittente.equals(other.getMittente()))) &&
            ((this.natura==null && other.getNatura()==null) || 
             (this.natura!=null &&
              this.natura.equals(other.getNatura()))) &&
            ((this.permessi==null && other.getPermessi()==null) || 
             (this.permessi!=null &&
              java.util.Arrays.equals(this.permessi, other.getPermessi()))) &&
            ((this.protocollo==null && other.getProtocollo()==null) || 
             (this.protocollo!=null &&
              this.protocollo.equals(other.getProtocollo()))) &&
            ((this.repertorio==null && other.getRepertorio()==null) || 
             (this.repertorio!=null &&
              this.repertorio.equals(other.getRepertorio()))) &&
            ((this.stato==null && other.getStato()==null) || 
             (this.stato!=null &&
              this.stato.equals(other.getStato()))) &&
            ((this.tipoCanaleInvio==null && other.getTipoCanaleInvio()==null) || 
             (this.tipoCanaleInvio!=null &&
              this.tipoCanaleInvio.equals(other.getTipoCanaleInvio()))) &&
            ((this.tipoCanaleRicezione==null && other.getTipoCanaleRicezione()==null) || 
             (this.tipoCanaleRicezione!=null &&
              this.tipoCanaleRicezione.equals(other.getTipoCanaleRicezione()))) &&
            ((this.tipoDocumento==null && other.getTipoDocumento()==null) || 
             (this.tipoDocumento!=null &&
              this.tipoDocumento.equals(other.getTipoDocumento()))) &&
            ((this.tipologia==null && other.getTipologia()==null) || 
             (this.tipologia!=null &&
              this.tipologia.equals(other.getTipologia()))) &&
            ((this.titolo==null && other.getTitolo()==null) || 
             (this.titolo!=null &&
              this.titolo.equals(other.getTitolo())));
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
        if (getCanaleInvio() != null) {
            _hashCode += getCanaleInvio().hashCode();
        }
        if (getCanaleRicezione() != null) {
            _hashCode += getCanaleRicezione().hashCode();
        }
        if (getCifra() != null) {
            _hashCode += getCifra().hashCode();
        }
        if (getDataDocumento() != null) {
            _hashCode += getDataDocumento().hashCode();
        }
        if (getDataRicevimento() != null) {
            _hashCode += getDataRicevimento().hashCode();
        }
        if (getDataTrasmissione() != null) {
            _hashCode += getDataTrasmissione().hashCode();
        }
        if (getDescrizione() != null) {
            _hashCode += getDescrizione().hashCode();
        }
        if (getDestinatario() != null) {
            _hashCode += getDestinatario().hashCode();
        }
        if (getFile() != null) {
            _hashCode += getFile().hashCode();
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
        if (getIdAggregatoContenitore() != null) {
            _hashCode += getIdAggregatoContenitore().hashCode();
        }
        if (getIdDocumentoPadre() != null) {
            _hashCode += getIdDocumentoPadre().hashCode();
        }
        if (getLocalizzazione() != null) {
            _hashCode += getLocalizzazione().hashCode();
        }
        if (getLuogoDocumento() != null) {
            _hashCode += getLuogoDocumento().hashCode();
        }
        if (getMimeType() != null) {
            _hashCode += getMimeType().hashCode();
        }
        if (getMittente() != null) {
            _hashCode += getMittente().hashCode();
        }
        if (getNatura() != null) {
            _hashCode += getNatura().hashCode();
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
        if (getRepertorio() != null) {
            _hashCode += getRepertorio().hashCode();
        }
        if (getStato() != null) {
            _hashCode += getStato().hashCode();
        }
        if (getTipoCanaleInvio() != null) {
            _hashCode += getTipoCanaleInvio().hashCode();
        }
        if (getTipoCanaleRicezione() != null) {
            _hashCode += getTipoCanaleRicezione().hashCode();
        }
        if (getTipoDocumento() != null) {
            _hashCode += getTipoDocumento().hashCode();
        }
        if (getTipologia() != null) {
            _hashCode += getTipologia().hashCode();
        }
        if (getTitolo() != null) {
            _hashCode += getTitolo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_NuovoDocumento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovoDocumento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annotazioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "annotazioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canaleInvio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "canaleInvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("canaleRicezione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "canaleRicezione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cifra");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "cifra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataRicevimento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataRicevimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataTrasmissione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataTrasmissione"));
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
        elemField.setFieldName("destinatario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "destinatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("file");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "file"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FileType"));
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
        elemField.setFieldName("idAggregatoContenitore");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idAggregatoContenitore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idDocumentoPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "idDocumentoPadre"));
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
        elemField.setFieldName("luogoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "luogoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mimeType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "mimeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mittente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "mittente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("natura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "natura"));
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
        elemField.setFieldName("repertorio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "repertorio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Repertorio"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stato");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "stato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCanaleInvio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipoCanaleInvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCanaleRicezione");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipoCanaleRicezione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoDocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipoDocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipologia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipologia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_TipologiaDocumento"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titolo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "titolo"));
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
