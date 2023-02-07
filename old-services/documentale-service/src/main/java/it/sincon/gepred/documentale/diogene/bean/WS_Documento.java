/**
 * WS_Documento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.bean;

public class WS_Documento  extends it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento  implements java.io.Serializable {
    private it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] allegati;

    private java.lang.String annotazioni;

    private java.lang.String canaleInvio;

    private java.lang.String canaleRicezione;

    private boolean checkedOut;

    private java.lang.String checkoutUser;

    private java.lang.String cifra;

    private java.lang.String cup;

    private java.lang.String dataChekin;

    private java.lang.String dataDocumento;

    private java.lang.String dataRicevimento;

    private java.lang.String dataTrasmissione;

    private java.lang.String descrizione;

    private java.lang.String destinatario;

    private java.lang.String elaboraAllegati;

    private java.lang.String fileSize;

    private java.lang.Boolean flagDaProtocollare;

    private java.lang.Boolean flagDatiPersonali;

    private java.lang.Boolean flagDatiRiservati;

    private java.lang.Boolean flagDatiSensibili;

    private java.lang.Boolean flagFirma;

    private java.lang.Boolean flagTimestamp;

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

    private it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento tipologia;

    public WS_Documento() {
    }

    public WS_Documento(
           java.lang.String autore,
           java.lang.String dataCreazione,
           java.lang.String fileName,
           java.lang.String idAggregatoContenitore,
           java.lang.String idDocumento,
           java.lang.String idDocumentoPadre,
           java.lang.String idVersione,
           java.lang.String numVersione,
           java.lang.String tipoDocumento,
           java.lang.String titolo,
           it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] allegati,
           java.lang.String annotazioni,
           java.lang.String canaleInvio,
           java.lang.String canaleRicezione,
           boolean checkedOut,
           java.lang.String checkoutUser,
           java.lang.String cifra,
           java.lang.String cup,
           java.lang.String dataChekin,
           java.lang.String dataDocumento,
           java.lang.String dataRicevimento,
           java.lang.String dataTrasmissione,
           java.lang.String descrizione,
           java.lang.String destinatario,
           java.lang.String elaboraAllegati,
           java.lang.String fileSize,
           java.lang.Boolean flagDaProtocollare,
           java.lang.Boolean flagDatiPersonali,
           java.lang.Boolean flagDatiRiservati,
           java.lang.Boolean flagDatiSensibili,
           java.lang.Boolean flagFirma,
           java.lang.Boolean flagTimestamp,
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
           it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento tipologia) {
        super(
            autore,
            dataCreazione,
            fileName,
            idAggregatoContenitore,
            idDocumento,
            idDocumentoPadre,
            idVersione,
            numVersione,
            tipoDocumento,
            titolo);
        this.allegati = allegati;
        this.annotazioni = annotazioni;
        this.canaleInvio = canaleInvio;
        this.canaleRicezione = canaleRicezione;
        this.checkedOut = checkedOut;
        this.checkoutUser = checkoutUser;
        this.cifra = cifra;
        this.cup = cup;
        this.dataChekin = dataChekin;
        this.dataDocumento = dataDocumento;
        this.dataRicevimento = dataRicevimento;
        this.dataTrasmissione = dataTrasmissione;
        this.descrizione = descrizione;
        this.destinatario = destinatario;
        this.elaboraAllegati = elaboraAllegati;
        this.fileSize = fileSize;
        this.flagDaProtocollare = flagDaProtocollare;
        this.flagDatiPersonali = flagDatiPersonali;
        this.flagDatiRiservati = flagDatiRiservati;
        this.flagDatiSensibili = flagDatiSensibili;
        this.flagFirma = flagFirma;
        this.flagTimestamp = flagTimestamp;
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
        this.tipologia = tipologia;
    }


    /**
     * Gets the allegati value for this WS_Documento.
     * 
     * @return allegati
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] getAllegati() {
        return allegati;
    }


    /**
     * Sets the allegati value for this WS_Documento.
     * 
     * @param allegati
     */
    public void setAllegati(it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[] allegati) {
        this.allegati = allegati;
    }


    /**
     * Gets the annotazioni value for this WS_Documento.
     * 
     * @return annotazioni
     */
    public java.lang.String getAnnotazioni() {
        return annotazioni;
    }


    /**
     * Sets the annotazioni value for this WS_Documento.
     * 
     * @param annotazioni
     */
    public void setAnnotazioni(java.lang.String annotazioni) {
        this.annotazioni = annotazioni;
    }


    /**
     * Gets the canaleInvio value for this WS_Documento.
     * 
     * @return canaleInvio
     */
    public java.lang.String getCanaleInvio() {
        return canaleInvio;
    }


    /**
     * Sets the canaleInvio value for this WS_Documento.
     * 
     * @param canaleInvio
     */
    public void setCanaleInvio(java.lang.String canaleInvio) {
        this.canaleInvio = canaleInvio;
    }


    /**
     * Gets the canaleRicezione value for this WS_Documento.
     * 
     * @return canaleRicezione
     */
    public java.lang.String getCanaleRicezione() {
        return canaleRicezione;
    }


    /**
     * Sets the canaleRicezione value for this WS_Documento.
     * 
     * @param canaleRicezione
     */
    public void setCanaleRicezione(java.lang.String canaleRicezione) {
        this.canaleRicezione = canaleRicezione;
    }


    /**
     * Gets the checkedOut value for this WS_Documento.
     * 
     * @return checkedOut
     */
    public boolean isCheckedOut() {
        return checkedOut;
    }


    /**
     * Sets the checkedOut value for this WS_Documento.
     * 
     * @param checkedOut
     */
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }


    /**
     * Gets the checkoutUser value for this WS_Documento.
     * 
     * @return checkoutUser
     */
    public java.lang.String getCheckoutUser() {
        return checkoutUser;
    }


    /**
     * Sets the checkoutUser value for this WS_Documento.
     * 
     * @param checkoutUser
     */
    public void setCheckoutUser(java.lang.String checkoutUser) {
        this.checkoutUser = checkoutUser;
    }


    /**
     * Gets the cifra value for this WS_Documento.
     * 
     * @return cifra
     */
    public java.lang.String getCifra() {
        return cifra;
    }


    /**
     * Sets the cifra value for this WS_Documento.
     * 
     * @param cifra
     */
    public void setCifra(java.lang.String cifra) {
        this.cifra = cifra;
    }


    /**
     * Gets the cup value for this WS_Documento.
     * 
     * @return cup
     */
    public java.lang.String getCup() {
        return cup;
    }


    /**
     * Sets the cup value for this WS_Documento.
     * 
     * @param cup
     */
    public void setCup(java.lang.String cup) {
        this.cup = cup;
    }


    /**
     * Gets the dataChekin value for this WS_Documento.
     * 
     * @return dataChekin
     */
    public java.lang.String getDataChekin() {
        return dataChekin;
    }


    /**
     * Sets the dataChekin value for this WS_Documento.
     * 
     * @param dataChekin
     */
    public void setDataChekin(java.lang.String dataChekin) {
        this.dataChekin = dataChekin;
    }


    /**
     * Gets the dataDocumento value for this WS_Documento.
     * 
     * @return dataDocumento
     */
    public java.lang.String getDataDocumento() {
        return dataDocumento;
    }


    /**
     * Sets the dataDocumento value for this WS_Documento.
     * 
     * @param dataDocumento
     */
    public void setDataDocumento(java.lang.String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }


    /**
     * Gets the dataRicevimento value for this WS_Documento.
     * 
     * @return dataRicevimento
     */
    public java.lang.String getDataRicevimento() {
        return dataRicevimento;
    }


    /**
     * Sets the dataRicevimento value for this WS_Documento.
     * 
     * @param dataRicevimento
     */
    public void setDataRicevimento(java.lang.String dataRicevimento) {
        this.dataRicevimento = dataRicevimento;
    }


    /**
     * Gets the dataTrasmissione value for this WS_Documento.
     * 
     * @return dataTrasmissione
     */
    public java.lang.String getDataTrasmissione() {
        return dataTrasmissione;
    }


    /**
     * Sets the dataTrasmissione value for this WS_Documento.
     * 
     * @param dataTrasmissione
     */
    public void setDataTrasmissione(java.lang.String dataTrasmissione) {
        this.dataTrasmissione = dataTrasmissione;
    }


    /**
     * Gets the descrizione value for this WS_Documento.
     * 
     * @return descrizione
     */
    public java.lang.String getDescrizione() {
        return descrizione;
    }


    /**
     * Sets the descrizione value for this WS_Documento.
     * 
     * @param descrizione
     */
    public void setDescrizione(java.lang.String descrizione) {
        this.descrizione = descrizione;
    }


    /**
     * Gets the destinatario value for this WS_Documento.
     * 
     * @return destinatario
     */
    public java.lang.String getDestinatario() {
        return destinatario;
    }


    /**
     * Sets the destinatario value for this WS_Documento.
     * 
     * @param destinatario
     */
    public void setDestinatario(java.lang.String destinatario) {
        this.destinatario = destinatario;
    }


    /**
     * Gets the elaboraAllegati value for this WS_Documento.
     * 
     * @return elaboraAllegati
     */
    public java.lang.String getElaboraAllegati() {
        return elaboraAllegati;
    }


    /**
     * Sets the elaboraAllegati value for this WS_Documento.
     * 
     * @param elaboraAllegati
     */
    public void setElaboraAllegati(java.lang.String elaboraAllegati) {
        this.elaboraAllegati = elaboraAllegati;
    }


    /**
     * Gets the fileSize value for this WS_Documento.
     * 
     * @return fileSize
     */
    public java.lang.String getFileSize() {
        return fileSize;
    }


    /**
     * Sets the fileSize value for this WS_Documento.
     * 
     * @param fileSize
     */
    public void setFileSize(java.lang.String fileSize) {
        this.fileSize = fileSize;
    }


    /**
     * Gets the flagDaProtocollare value for this WS_Documento.
     * 
     * @return flagDaProtocollare
     */
    public java.lang.Boolean getFlagDaProtocollare() {
        return flagDaProtocollare;
    }


    /**
     * Sets the flagDaProtocollare value for this WS_Documento.
     * 
     * @param flagDaProtocollare
     */
    public void setFlagDaProtocollare(java.lang.Boolean flagDaProtocollare) {
        this.flagDaProtocollare = flagDaProtocollare;
    }


    /**
     * Gets the flagDatiPersonali value for this WS_Documento.
     * 
     * @return flagDatiPersonali
     */
    public java.lang.Boolean getFlagDatiPersonali() {
        return flagDatiPersonali;
    }


    /**
     * Sets the flagDatiPersonali value for this WS_Documento.
     * 
     * @param flagDatiPersonali
     */
    public void setFlagDatiPersonali(java.lang.Boolean flagDatiPersonali) {
        this.flagDatiPersonali = flagDatiPersonali;
    }


    /**
     * Gets the flagDatiRiservati value for this WS_Documento.
     * 
     * @return flagDatiRiservati
     */
    public java.lang.Boolean getFlagDatiRiservati() {
        return flagDatiRiservati;
    }


    /**
     * Sets the flagDatiRiservati value for this WS_Documento.
     * 
     * @param flagDatiRiservati
     */
    public void setFlagDatiRiservati(java.lang.Boolean flagDatiRiservati) {
        this.flagDatiRiservati = flagDatiRiservati;
    }


    /**
     * Gets the flagDatiSensibili value for this WS_Documento.
     * 
     * @return flagDatiSensibili
     */
    public java.lang.Boolean getFlagDatiSensibili() {
        return flagDatiSensibili;
    }


    /**
     * Sets the flagDatiSensibili value for this WS_Documento.
     * 
     * @param flagDatiSensibili
     */
    public void setFlagDatiSensibili(java.lang.Boolean flagDatiSensibili) {
        this.flagDatiSensibili = flagDatiSensibili;
    }


    /**
     * Gets the flagFirma value for this WS_Documento.
     * 
     * @return flagFirma
     */
    public java.lang.Boolean getFlagFirma() {
        return flagFirma;
    }


    /**
     * Sets the flagFirma value for this WS_Documento.
     * 
     * @param flagFirma
     */
    public void setFlagFirma(java.lang.Boolean flagFirma) {
        this.flagFirma = flagFirma;
    }


    /**
     * Gets the flagTimestamp value for this WS_Documento.
     * 
     * @return flagTimestamp
     */
    public java.lang.Boolean getFlagTimestamp() {
        return flagTimestamp;
    }


    /**
     * Sets the flagTimestamp value for this WS_Documento.
     * 
     * @param flagTimestamp
     */
    public void setFlagTimestamp(java.lang.Boolean flagTimestamp) {
        this.flagTimestamp = flagTimestamp;
    }


    /**
     * Gets the luogoDocumento value for this WS_Documento.
     * 
     * @return luogoDocumento
     */
    public java.lang.String getLuogoDocumento() {
        return luogoDocumento;
    }


    /**
     * Sets the luogoDocumento value for this WS_Documento.
     * 
     * @param luogoDocumento
     */
    public void setLuogoDocumento(java.lang.String luogoDocumento) {
        this.luogoDocumento = luogoDocumento;
    }


    /**
     * Gets the mimeType value for this WS_Documento.
     * 
     * @return mimeType
     */
    public java.lang.String getMimeType() {
        return mimeType;
    }


    /**
     * Sets the mimeType value for this WS_Documento.
     * 
     * @param mimeType
     */
    public void setMimeType(java.lang.String mimeType) {
        this.mimeType = mimeType;
    }


    /**
     * Gets the mittente value for this WS_Documento.
     * 
     * @return mittente
     */
    public java.lang.String getMittente() {
        return mittente;
    }


    /**
     * Sets the mittente value for this WS_Documento.
     * 
     * @param mittente
     */
    public void setMittente(java.lang.String mittente) {
        this.mittente = mittente;
    }


    /**
     * Gets the natura value for this WS_Documento.
     * 
     * @return natura
     */
    public java.lang.String getNatura() {
        return natura;
    }


    /**
     * Sets the natura value for this WS_Documento.
     * 
     * @param natura
     */
    public void setNatura(java.lang.String natura) {
        this.natura = natura;
    }


    /**
     * Gets the permessi value for this WS_Documento.
     * 
     * @return permessi
     */
    public it.sincon.gepred.documentale.diogene.bean.Permesso[] getPermessi() {
        return permessi;
    }


    /**
     * Sets the permessi value for this WS_Documento.
     * 
     * @param permessi
     */
    public void setPermessi(it.sincon.gepred.documentale.diogene.bean.Permesso[] permessi) {
        this.permessi = permessi;
    }


    /**
     * Gets the protocollo value for this WS_Documento.
     * 
     * @return protocollo
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Protocollo getProtocollo() {
        return protocollo;
    }


    /**
     * Sets the protocollo value for this WS_Documento.
     * 
     * @param protocollo
     */
    public void setProtocollo(it.sincon.gepred.documentale.diogene.bean.WS_Protocollo protocollo) {
        this.protocollo = protocollo;
    }


    /**
     * Gets the repertorio value for this WS_Documento.
     * 
     * @return repertorio
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_Repertorio getRepertorio() {
        return repertorio;
    }


    /**
     * Sets the repertorio value for this WS_Documento.
     * 
     * @param repertorio
     */
    public void setRepertorio(it.sincon.gepred.documentale.diogene.bean.WS_Repertorio repertorio) {
        this.repertorio = repertorio;
    }


    /**
     * Gets the stato value for this WS_Documento.
     * 
     * @return stato
     */
    public java.lang.String getStato() {
        return stato;
    }


    /**
     * Sets the stato value for this WS_Documento.
     * 
     * @param stato
     */
    public void setStato(java.lang.String stato) {
        this.stato = stato;
    }


    /**
     * Gets the tipoCanaleInvio value for this WS_Documento.
     * 
     * @return tipoCanaleInvio
     */
    public java.lang.String getTipoCanaleInvio() {
        return tipoCanaleInvio;
    }


    /**
     * Sets the tipoCanaleInvio value for this WS_Documento.
     * 
     * @param tipoCanaleInvio
     */
    public void setTipoCanaleInvio(java.lang.String tipoCanaleInvio) {
        this.tipoCanaleInvio = tipoCanaleInvio;
    }


    /**
     * Gets the tipoCanaleRicezione value for this WS_Documento.
     * 
     * @return tipoCanaleRicezione
     */
    public java.lang.String getTipoCanaleRicezione() {
        return tipoCanaleRicezione;
    }


    /**
     * Sets the tipoCanaleRicezione value for this WS_Documento.
     * 
     * @param tipoCanaleRicezione
     */
    public void setTipoCanaleRicezione(java.lang.String tipoCanaleRicezione) {
        this.tipoCanaleRicezione = tipoCanaleRicezione;
    }


    /**
     * Gets the tipologia value for this WS_Documento.
     * 
     * @return tipologia
     */
    public it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento getTipologia() {
        return tipologia;
    }


    /**
     * Sets the tipologia value for this WS_Documento.
     * 
     * @param tipologia
     */
    public void setTipologia(it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento tipologia) {
        this.tipologia = tipologia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WS_Documento)) return false;
        WS_Documento other = (WS_Documento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.allegati==null && other.getAllegati()==null) || 
             (this.allegati!=null &&
              java.util.Arrays.equals(this.allegati, other.getAllegati()))) &&
            ((this.annotazioni==null && other.getAnnotazioni()==null) || 
             (this.annotazioni!=null &&
              this.annotazioni.equals(other.getAnnotazioni()))) &&
            ((this.canaleInvio==null && other.getCanaleInvio()==null) || 
             (this.canaleInvio!=null &&
              this.canaleInvio.equals(other.getCanaleInvio()))) &&
            ((this.canaleRicezione==null && other.getCanaleRicezione()==null) || 
             (this.canaleRicezione!=null &&
              this.canaleRicezione.equals(other.getCanaleRicezione()))) &&
            this.checkedOut == other.isCheckedOut() &&
            ((this.checkoutUser==null && other.getCheckoutUser()==null) || 
             (this.checkoutUser!=null &&
              this.checkoutUser.equals(other.getCheckoutUser()))) &&
            ((this.cifra==null && other.getCifra()==null) || 
             (this.cifra!=null &&
              this.cifra.equals(other.getCifra()))) &&
            ((this.cup==null && other.getCup()==null) || 
             (this.cup!=null &&
              this.cup.equals(other.getCup()))) &&
            ((this.dataChekin==null && other.getDataChekin()==null) || 
             (this.dataChekin!=null &&
              this.dataChekin.equals(other.getDataChekin()))) &&
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
            ((this.elaboraAllegati==null && other.getElaboraAllegati()==null) || 
             (this.elaboraAllegati!=null &&
              this.elaboraAllegati.equals(other.getElaboraAllegati()))) &&
            ((this.fileSize==null && other.getFileSize()==null) || 
             (this.fileSize!=null &&
              this.fileSize.equals(other.getFileSize()))) &&
            ((this.flagDaProtocollare==null && other.getFlagDaProtocollare()==null) || 
             (this.flagDaProtocollare!=null &&
              this.flagDaProtocollare.equals(other.getFlagDaProtocollare()))) &&
            ((this.flagDatiPersonali==null && other.getFlagDatiPersonali()==null) || 
             (this.flagDatiPersonali!=null &&
              this.flagDatiPersonali.equals(other.getFlagDatiPersonali()))) &&
            ((this.flagDatiRiservati==null && other.getFlagDatiRiservati()==null) || 
             (this.flagDatiRiservati!=null &&
              this.flagDatiRiservati.equals(other.getFlagDatiRiservati()))) &&
            ((this.flagDatiSensibili==null && other.getFlagDatiSensibili()==null) || 
             (this.flagDatiSensibili!=null &&
              this.flagDatiSensibili.equals(other.getFlagDatiSensibili()))) &&
            ((this.flagFirma==null && other.getFlagFirma()==null) || 
             (this.flagFirma!=null &&
              this.flagFirma.equals(other.getFlagFirma()))) &&
            ((this.flagTimestamp==null && other.getFlagTimestamp()==null) || 
             (this.flagTimestamp!=null &&
              this.flagTimestamp.equals(other.getFlagTimestamp()))) &&
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
            ((this.tipologia==null && other.getTipologia()==null) || 
             (this.tipologia!=null &&
              this.tipologia.equals(other.getTipologia())));
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
        if (getAllegati() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAllegati());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAllegati(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAnnotazioni() != null) {
            _hashCode += getAnnotazioni().hashCode();
        }
        if (getCanaleInvio() != null) {
            _hashCode += getCanaleInvio().hashCode();
        }
        if (getCanaleRicezione() != null) {
            _hashCode += getCanaleRicezione().hashCode();
        }
        _hashCode += (isCheckedOut() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCheckoutUser() != null) {
            _hashCode += getCheckoutUser().hashCode();
        }
        if (getCifra() != null) {
            _hashCode += getCifra().hashCode();
        }
        if (getCup() != null) {
            _hashCode += getCup().hashCode();
        }
        if (getDataChekin() != null) {
            _hashCode += getDataChekin().hashCode();
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
        if (getElaboraAllegati() != null) {
            _hashCode += getElaboraAllegati().hashCode();
        }
        if (getFileSize() != null) {
            _hashCode += getFileSize().hashCode();
        }
        if (getFlagDaProtocollare() != null) {
            _hashCode += getFlagDaProtocollare().hashCode();
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
        if (getFlagFirma() != null) {
            _hashCode += getFlagFirma().hashCode();
        }
        if (getFlagTimestamp() != null) {
            _hashCode += getFlagTimestamp().hashCode();
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
        if (getTipologia() != null) {
            _hashCode += getTipologia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WS_Documento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Documento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allegati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "allegati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_InfoDocumento"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("checkedOut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "checkedOut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkoutUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "checkoutUser"));
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
        elemField.setFieldName("cup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "cup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataChekin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "dataChekin"));
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
        elemField.setFieldName("elaboraAllegati");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "elaboraAllegati"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileSize");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "fileSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagDaProtocollare");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "flagDaProtocollare"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("flagFirma");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "flagFirma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagTimestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "flagTimestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("tipologia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "tipologia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_TipologiaDocumento"));
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
