/**
 * Paziente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class Paziente  implements java.io.Serializable {
    private java.lang.String siglaRegole;

    private java.lang.String idPaziente;

    private java.lang.String idPazienteSGP;

    private java.lang.String nome;

    private java.lang.String cognome;

    private java.lang.String dataNascita;

    private java.lang.String sesso;

    private java.lang.String codiceFiscale;

    private java.lang.String indirizzoDomicilio;

    private java.lang.String nCivicoDomicilio;

    private java.lang.String comuneDomicilio;

    private java.lang.String comuneDomicilioDesc;

    private java.lang.String capDomicilio;

    private java.lang.String indirizzoResidenza;

    private java.lang.String nCivicoResidenza;

    private java.lang.String comuneResidenza;

    private java.lang.String comuneResidenzaDesc;

    private java.lang.String capResidenza;

    private java.lang.String comuneNascita;

    private java.lang.String comuneNascitaDesc;

    private java.lang.String aslAppartenenza;

    private java.lang.String aslAppartenenzaDesc;

    private java.lang.String aslAssistenza;

    private java.lang.String aslAssistenzaDesc;

    private java.lang.String cittadinanza;

    private java.lang.String cittadinanzaDesc;

    private java.lang.String tel1;

    private java.lang.String tel2;

    private java.lang.String tel3;

    private it.puglia.sanita.cup.TesseraTeam tesseraTeam;

    public Paziente() {
    }

    public Paziente(
           java.lang.String siglaRegole,
           java.lang.String idPaziente,
           java.lang.String idPazienteSGP,
           java.lang.String nome,
           java.lang.String cognome,
           java.lang.String dataNascita,
           java.lang.String sesso,
           java.lang.String codiceFiscale,
           java.lang.String indirizzoDomicilio,
           java.lang.String nCivicoDomicilio,
           java.lang.String comuneDomicilio,
           java.lang.String comuneDomicilioDesc,
           java.lang.String capDomicilio,
           java.lang.String indirizzoResidenza,
           java.lang.String nCivicoResidenza,
           java.lang.String comuneResidenza,
           java.lang.String comuneResidenzaDesc,
           java.lang.String capResidenza,
           java.lang.String comuneNascita,
           java.lang.String comuneNascitaDesc,
           java.lang.String aslAppartenenza,
           java.lang.String aslAppartenenzaDesc,
           java.lang.String aslAssistenza,
           java.lang.String aslAssistenzaDesc,
           java.lang.String cittadinanza,
           java.lang.String cittadinanzaDesc,
           java.lang.String tel1,
           java.lang.String tel2,
           java.lang.String tel3,
           it.puglia.sanita.cup.TesseraTeam tesseraTeam) {
           this.siglaRegole = siglaRegole;
           this.idPaziente = idPaziente;
           this.idPazienteSGP = idPazienteSGP;
           this.nome = nome;
           this.cognome = cognome;
           this.dataNascita = dataNascita;
           this.sesso = sesso;
           this.codiceFiscale = codiceFiscale;
           this.indirizzoDomicilio = indirizzoDomicilio;
           this.nCivicoDomicilio = nCivicoDomicilio;
           this.comuneDomicilio = comuneDomicilio;
           this.comuneDomicilioDesc = comuneDomicilioDesc;
           this.capDomicilio = capDomicilio;
           this.indirizzoResidenza = indirizzoResidenza;
           this.nCivicoResidenza = nCivicoResidenza;
           this.comuneResidenza = comuneResidenza;
           this.comuneResidenzaDesc = comuneResidenzaDesc;
           this.capResidenza = capResidenza;
           this.comuneNascita = comuneNascita;
           this.comuneNascitaDesc = comuneNascitaDesc;
           this.aslAppartenenza = aslAppartenenza;
           this.aslAppartenenzaDesc = aslAppartenenzaDesc;
           this.aslAssistenza = aslAssistenza;
           this.aslAssistenzaDesc = aslAssistenzaDesc;
           this.cittadinanza = cittadinanza;
           this.cittadinanzaDesc = cittadinanzaDesc;
           this.tel1 = tel1;
           this.tel2 = tel2;
           this.tel3 = tel3;
           this.tesseraTeam = tesseraTeam;
    }


    /**
     * Gets the siglaRegole value for this Paziente.
     * 
     * @return siglaRegole
     */
    public java.lang.String getSiglaRegole() {
        return siglaRegole;
    }


    /**
     * Sets the siglaRegole value for this Paziente.
     * 
     * @param siglaRegole
     */
    public void setSiglaRegole(java.lang.String siglaRegole) {
        this.siglaRegole = siglaRegole;
    }


    /**
     * Gets the idPaziente value for this Paziente.
     * 
     * @return idPaziente
     */
    public java.lang.String getIdPaziente() {
        return idPaziente;
    }


    /**
     * Sets the idPaziente value for this Paziente.
     * 
     * @param idPaziente
     */
    public void setIdPaziente(java.lang.String idPaziente) {
        this.idPaziente = idPaziente;
    }


    /**
     * Gets the idPazienteSGP value for this Paziente.
     * 
     * @return idPazienteSGP
     */
    public java.lang.String getIdPazienteSGP() {
        return idPazienteSGP;
    }


    /**
     * Sets the idPazienteSGP value for this Paziente.
     * 
     * @param idPazienteSGP
     */
    public void setIdPazienteSGP(java.lang.String idPazienteSGP) {
        this.idPazienteSGP = idPazienteSGP;
    }


    /**
     * Gets the nome value for this Paziente.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Paziente.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the cognome value for this Paziente.
     * 
     * @return cognome
     */
    public java.lang.String getCognome() {
        return cognome;
    }


    /**
     * Sets the cognome value for this Paziente.
     * 
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }


    /**
     * Gets the dataNascita value for this Paziente.
     * 
     * @return dataNascita
     */
    public java.lang.String getDataNascita() {
        return dataNascita;
    }


    /**
     * Sets the dataNascita value for this Paziente.
     * 
     * @param dataNascita
     */
    public void setDataNascita(java.lang.String dataNascita) {
        this.dataNascita = dataNascita;
    }


    /**
     * Gets the sesso value for this Paziente.
     * 
     * @return sesso
     */
    public java.lang.String getSesso() {
        return sesso;
    }


    /**
     * Sets the sesso value for this Paziente.
     * 
     * @param sesso
     */
    public void setSesso(java.lang.String sesso) {
        this.sesso = sesso;
    }


    /**
     * Gets the codiceFiscale value for this Paziente.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this Paziente.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the indirizzoDomicilio value for this Paziente.
     * 
     * @return indirizzoDomicilio
     */
    public java.lang.String getIndirizzoDomicilio() {
        return indirizzoDomicilio;
    }


    /**
     * Sets the indirizzoDomicilio value for this Paziente.
     * 
     * @param indirizzoDomicilio
     */
    public void setIndirizzoDomicilio(java.lang.String indirizzoDomicilio) {
        this.indirizzoDomicilio = indirizzoDomicilio;
    }


    /**
     * Gets the nCivicoDomicilio value for this Paziente.
     * 
     * @return nCivicoDomicilio
     */
    public java.lang.String getNCivicoDomicilio() {
        return nCivicoDomicilio;
    }


    /**
     * Sets the nCivicoDomicilio value for this Paziente.
     * 
     * @param nCivicoDomicilio
     */
    public void setNCivicoDomicilio(java.lang.String nCivicoDomicilio) {
        this.nCivicoDomicilio = nCivicoDomicilio;
    }


    /**
     * Gets the comuneDomicilio value for this Paziente.
     * 
     * @return comuneDomicilio
     */
    public java.lang.String getComuneDomicilio() {
        return comuneDomicilio;
    }


    /**
     * Sets the comuneDomicilio value for this Paziente.
     * 
     * @param comuneDomicilio
     */
    public void setComuneDomicilio(java.lang.String comuneDomicilio) {
        this.comuneDomicilio = comuneDomicilio;
    }


    /**
     * Gets the comuneDomicilioDesc value for this Paziente.
     * 
     * @return comuneDomicilioDesc
     */
    public java.lang.String getComuneDomicilioDesc() {
        return comuneDomicilioDesc;
    }


    /**
     * Sets the comuneDomicilioDesc value for this Paziente.
     * 
     * @param comuneDomicilioDesc
     */
    public void setComuneDomicilioDesc(java.lang.String comuneDomicilioDesc) {
        this.comuneDomicilioDesc = comuneDomicilioDesc;
    }


    /**
     * Gets the capDomicilio value for this Paziente.
     * 
     * @return capDomicilio
     */
    public java.lang.String getCapDomicilio() {
        return capDomicilio;
    }


    /**
     * Sets the capDomicilio value for this Paziente.
     * 
     * @param capDomicilio
     */
    public void setCapDomicilio(java.lang.String capDomicilio) {
        this.capDomicilio = capDomicilio;
    }


    /**
     * Gets the indirizzoResidenza value for this Paziente.
     * 
     * @return indirizzoResidenza
     */
    public java.lang.String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }


    /**
     * Sets the indirizzoResidenza value for this Paziente.
     * 
     * @param indirizzoResidenza
     */
    public void setIndirizzoResidenza(java.lang.String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }


    /**
     * Gets the nCivicoResidenza value for this Paziente.
     * 
     * @return nCivicoResidenza
     */
    public java.lang.String getNCivicoResidenza() {
        return nCivicoResidenza;
    }


    /**
     * Sets the nCivicoResidenza value for this Paziente.
     * 
     * @param nCivicoResidenza
     */
    public void setNCivicoResidenza(java.lang.String nCivicoResidenza) {
        this.nCivicoResidenza = nCivicoResidenza;
    }


    /**
     * Gets the comuneResidenza value for this Paziente.
     * 
     * @return comuneResidenza
     */
    public java.lang.String getComuneResidenza() {
        return comuneResidenza;
    }


    /**
     * Sets the comuneResidenza value for this Paziente.
     * 
     * @param comuneResidenza
     */
    public void setComuneResidenza(java.lang.String comuneResidenza) {
        this.comuneResidenza = comuneResidenza;
    }


    /**
     * Gets the comuneResidenzaDesc value for this Paziente.
     * 
     * @return comuneResidenzaDesc
     */
    public java.lang.String getComuneResidenzaDesc() {
        return comuneResidenzaDesc;
    }


    /**
     * Sets the comuneResidenzaDesc value for this Paziente.
     * 
     * @param comuneResidenzaDesc
     */
    public void setComuneResidenzaDesc(java.lang.String comuneResidenzaDesc) {
        this.comuneResidenzaDesc = comuneResidenzaDesc;
    }


    /**
     * Gets the capResidenza value for this Paziente.
     * 
     * @return capResidenza
     */
    public java.lang.String getCapResidenza() {
        return capResidenza;
    }


    /**
     * Sets the capResidenza value for this Paziente.
     * 
     * @param capResidenza
     */
    public void setCapResidenza(java.lang.String capResidenza) {
        this.capResidenza = capResidenza;
    }


    /**
     * Gets the comuneNascita value for this Paziente.
     * 
     * @return comuneNascita
     */
    public java.lang.String getComuneNascita() {
        return comuneNascita;
    }


    /**
     * Sets the comuneNascita value for this Paziente.
     * 
     * @param comuneNascita
     */
    public void setComuneNascita(java.lang.String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }


    /**
     * Gets the comuneNascitaDesc value for this Paziente.
     * 
     * @return comuneNascitaDesc
     */
    public java.lang.String getComuneNascitaDesc() {
        return comuneNascitaDesc;
    }


    /**
     * Sets the comuneNascitaDesc value for this Paziente.
     * 
     * @param comuneNascitaDesc
     */
    public void setComuneNascitaDesc(java.lang.String comuneNascitaDesc) {
        this.comuneNascitaDesc = comuneNascitaDesc;
    }


    /**
     * Gets the aslAppartenenza value for this Paziente.
     * 
     * @return aslAppartenenza
     */
    public java.lang.String getAslAppartenenza() {
        return aslAppartenenza;
    }


    /**
     * Sets the aslAppartenenza value for this Paziente.
     * 
     * @param aslAppartenenza
     */
    public void setAslAppartenenza(java.lang.String aslAppartenenza) {
        this.aslAppartenenza = aslAppartenenza;
    }


    /**
     * Gets the aslAppartenenzaDesc value for this Paziente.
     * 
     * @return aslAppartenenzaDesc
     */
    public java.lang.String getAslAppartenenzaDesc() {
        return aslAppartenenzaDesc;
    }


    /**
     * Sets the aslAppartenenzaDesc value for this Paziente.
     * 
     * @param aslAppartenenzaDesc
     */
    public void setAslAppartenenzaDesc(java.lang.String aslAppartenenzaDesc) {
        this.aslAppartenenzaDesc = aslAppartenenzaDesc;
    }


    /**
     * Gets the aslAssistenza value for this Paziente.
     * 
     * @return aslAssistenza
     */
    public java.lang.String getAslAssistenza() {
        return aslAssistenza;
    }


    /**
     * Sets the aslAssistenza value for this Paziente.
     * 
     * @param aslAssistenza
     */
    public void setAslAssistenza(java.lang.String aslAssistenza) {
        this.aslAssistenza = aslAssistenza;
    }


    /**
     * Gets the aslAssistenzaDesc value for this Paziente.
     * 
     * @return aslAssistenzaDesc
     */
    public java.lang.String getAslAssistenzaDesc() {
        return aslAssistenzaDesc;
    }


    /**
     * Sets the aslAssistenzaDesc value for this Paziente.
     * 
     * @param aslAssistenzaDesc
     */
    public void setAslAssistenzaDesc(java.lang.String aslAssistenzaDesc) {
        this.aslAssistenzaDesc = aslAssistenzaDesc;
    }


    /**
     * Gets the cittadinanza value for this Paziente.
     * 
     * @return cittadinanza
     */
    public java.lang.String getCittadinanza() {
        return cittadinanza;
    }


    /**
     * Sets the cittadinanza value for this Paziente.
     * 
     * @param cittadinanza
     */
    public void setCittadinanza(java.lang.String cittadinanza) {
        this.cittadinanza = cittadinanza;
    }


    /**
     * Gets the cittadinanzaDesc value for this Paziente.
     * 
     * @return cittadinanzaDesc
     */
    public java.lang.String getCittadinanzaDesc() {
        return cittadinanzaDesc;
    }


    /**
     * Sets the cittadinanzaDesc value for this Paziente.
     * 
     * @param cittadinanzaDesc
     */
    public void setCittadinanzaDesc(java.lang.String cittadinanzaDesc) {
        this.cittadinanzaDesc = cittadinanzaDesc;
    }


    /**
     * Gets the tel1 value for this Paziente.
     * 
     * @return tel1
     */
    public java.lang.String getTel1() {
        return tel1;
    }


    /**
     * Sets the tel1 value for this Paziente.
     * 
     * @param tel1
     */
    public void setTel1(java.lang.String tel1) {
        this.tel1 = tel1;
    }


    /**
     * Gets the tel2 value for this Paziente.
     * 
     * @return tel2
     */
    public java.lang.String getTel2() {
        return tel2;
    }


    /**
     * Sets the tel2 value for this Paziente.
     * 
     * @param tel2
     */
    public void setTel2(java.lang.String tel2) {
        this.tel2 = tel2;
    }


    /**
     * Gets the tel3 value for this Paziente.
     * 
     * @return tel3
     */
    public java.lang.String getTel3() {
        return tel3;
    }


    /**
     * Sets the tel3 value for this Paziente.
     * 
     * @param tel3
     */
    public void setTel3(java.lang.String tel3) {
        this.tel3 = tel3;
    }


    /**
     * Gets the tesseraTeam value for this Paziente.
     * 
     * @return tesseraTeam
     */
    public it.puglia.sanita.cup.TesseraTeam getTesseraTeam() {
        return tesseraTeam;
    }


    /**
     * Sets the tesseraTeam value for this Paziente.
     * 
     * @param tesseraTeam
     */
    public void setTesseraTeam(it.puglia.sanita.cup.TesseraTeam tesseraTeam) {
        this.tesseraTeam = tesseraTeam;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Paziente)) return false;
        Paziente other = (Paziente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.siglaRegole==null && other.getSiglaRegole()==null) || 
             (this.siglaRegole!=null &&
              this.siglaRegole.equals(other.getSiglaRegole()))) &&
            ((this.idPaziente==null && other.getIdPaziente()==null) || 
             (this.idPaziente!=null &&
              this.idPaziente.equals(other.getIdPaziente()))) &&
            ((this.idPazienteSGP==null && other.getIdPazienteSGP()==null) || 
             (this.idPazienteSGP!=null &&
              this.idPazienteSGP.equals(other.getIdPazienteSGP()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.cognome==null && other.getCognome()==null) || 
             (this.cognome!=null &&
              this.cognome.equals(other.getCognome()))) &&
            ((this.dataNascita==null && other.getDataNascita()==null) || 
             (this.dataNascita!=null &&
              this.dataNascita.equals(other.getDataNascita()))) &&
            ((this.sesso==null && other.getSesso()==null) || 
             (this.sesso!=null &&
              this.sesso.equals(other.getSesso()))) &&
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.indirizzoDomicilio==null && other.getIndirizzoDomicilio()==null) || 
             (this.indirizzoDomicilio!=null &&
              this.indirizzoDomicilio.equals(other.getIndirizzoDomicilio()))) &&
            ((this.nCivicoDomicilio==null && other.getNCivicoDomicilio()==null) || 
             (this.nCivicoDomicilio!=null &&
              this.nCivicoDomicilio.equals(other.getNCivicoDomicilio()))) &&
            ((this.comuneDomicilio==null && other.getComuneDomicilio()==null) || 
             (this.comuneDomicilio!=null &&
              this.comuneDomicilio.equals(other.getComuneDomicilio()))) &&
            ((this.comuneDomicilioDesc==null && other.getComuneDomicilioDesc()==null) || 
             (this.comuneDomicilioDesc!=null &&
              this.comuneDomicilioDesc.equals(other.getComuneDomicilioDesc()))) &&
            ((this.capDomicilio==null && other.getCapDomicilio()==null) || 
             (this.capDomicilio!=null &&
              this.capDomicilio.equals(other.getCapDomicilio()))) &&
            ((this.indirizzoResidenza==null && other.getIndirizzoResidenza()==null) || 
             (this.indirizzoResidenza!=null &&
              this.indirizzoResidenza.equals(other.getIndirizzoResidenza()))) &&
            ((this.nCivicoResidenza==null && other.getNCivicoResidenza()==null) || 
             (this.nCivicoResidenza!=null &&
              this.nCivicoResidenza.equals(other.getNCivicoResidenza()))) &&
            ((this.comuneResidenza==null && other.getComuneResidenza()==null) || 
             (this.comuneResidenza!=null &&
              this.comuneResidenza.equals(other.getComuneResidenza()))) &&
            ((this.comuneResidenzaDesc==null && other.getComuneResidenzaDesc()==null) || 
             (this.comuneResidenzaDesc!=null &&
              this.comuneResidenzaDesc.equals(other.getComuneResidenzaDesc()))) &&
            ((this.capResidenza==null && other.getCapResidenza()==null) || 
             (this.capResidenza!=null &&
              this.capResidenza.equals(other.getCapResidenza()))) &&
            ((this.comuneNascita==null && other.getComuneNascita()==null) || 
             (this.comuneNascita!=null &&
              this.comuneNascita.equals(other.getComuneNascita()))) &&
            ((this.comuneNascitaDesc==null && other.getComuneNascitaDesc()==null) || 
             (this.comuneNascitaDesc!=null &&
              this.comuneNascitaDesc.equals(other.getComuneNascitaDesc()))) &&
            ((this.aslAppartenenza==null && other.getAslAppartenenza()==null) || 
             (this.aslAppartenenza!=null &&
              this.aslAppartenenza.equals(other.getAslAppartenenza()))) &&
            ((this.aslAppartenenzaDesc==null && other.getAslAppartenenzaDesc()==null) || 
             (this.aslAppartenenzaDesc!=null &&
              this.aslAppartenenzaDesc.equals(other.getAslAppartenenzaDesc()))) &&
            ((this.aslAssistenza==null && other.getAslAssistenza()==null) || 
             (this.aslAssistenza!=null &&
              this.aslAssistenza.equals(other.getAslAssistenza()))) &&
            ((this.aslAssistenzaDesc==null && other.getAslAssistenzaDesc()==null) || 
             (this.aslAssistenzaDesc!=null &&
              this.aslAssistenzaDesc.equals(other.getAslAssistenzaDesc()))) &&
            ((this.cittadinanza==null && other.getCittadinanza()==null) || 
             (this.cittadinanza!=null &&
              this.cittadinanza.equals(other.getCittadinanza()))) &&
            ((this.cittadinanzaDesc==null && other.getCittadinanzaDesc()==null) || 
             (this.cittadinanzaDesc!=null &&
              this.cittadinanzaDesc.equals(other.getCittadinanzaDesc()))) &&
            ((this.tel1==null && other.getTel1()==null) || 
             (this.tel1!=null &&
              this.tel1.equals(other.getTel1()))) &&
            ((this.tel2==null && other.getTel2()==null) || 
             (this.tel2!=null &&
              this.tel2.equals(other.getTel2()))) &&
            ((this.tel3==null && other.getTel3()==null) || 
             (this.tel3!=null &&
              this.tel3.equals(other.getTel3()))) &&
            ((this.tesseraTeam==null && other.getTesseraTeam()==null) || 
             (this.tesseraTeam!=null &&
              this.tesseraTeam.equals(other.getTesseraTeam())));
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
        if (getSiglaRegole() != null) {
            _hashCode += getSiglaRegole().hashCode();
        }
        if (getIdPaziente() != null) {
            _hashCode += getIdPaziente().hashCode();
        }
        if (getIdPazienteSGP() != null) {
            _hashCode += getIdPazienteSGP().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getCognome() != null) {
            _hashCode += getCognome().hashCode();
        }
        if (getDataNascita() != null) {
            _hashCode += getDataNascita().hashCode();
        }
        if (getSesso() != null) {
            _hashCode += getSesso().hashCode();
        }
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getIndirizzoDomicilio() != null) {
            _hashCode += getIndirizzoDomicilio().hashCode();
        }
        if (getNCivicoDomicilio() != null) {
            _hashCode += getNCivicoDomicilio().hashCode();
        }
        if (getComuneDomicilio() != null) {
            _hashCode += getComuneDomicilio().hashCode();
        }
        if (getComuneDomicilioDesc() != null) {
            _hashCode += getComuneDomicilioDesc().hashCode();
        }
        if (getCapDomicilio() != null) {
            _hashCode += getCapDomicilio().hashCode();
        }
        if (getIndirizzoResidenza() != null) {
            _hashCode += getIndirizzoResidenza().hashCode();
        }
        if (getNCivicoResidenza() != null) {
            _hashCode += getNCivicoResidenza().hashCode();
        }
        if (getComuneResidenza() != null) {
            _hashCode += getComuneResidenza().hashCode();
        }
        if (getComuneResidenzaDesc() != null) {
            _hashCode += getComuneResidenzaDesc().hashCode();
        }
        if (getCapResidenza() != null) {
            _hashCode += getCapResidenza().hashCode();
        }
        if (getComuneNascita() != null) {
            _hashCode += getComuneNascita().hashCode();
        }
        if (getComuneNascitaDesc() != null) {
            _hashCode += getComuneNascitaDesc().hashCode();
        }
        if (getAslAppartenenza() != null) {
            _hashCode += getAslAppartenenza().hashCode();
        }
        if (getAslAppartenenzaDesc() != null) {
            _hashCode += getAslAppartenenzaDesc().hashCode();
        }
        if (getAslAssistenza() != null) {
            _hashCode += getAslAssistenza().hashCode();
        }
        if (getAslAssistenzaDesc() != null) {
            _hashCode += getAslAssistenzaDesc().hashCode();
        }
        if (getCittadinanza() != null) {
            _hashCode += getCittadinanza().hashCode();
        }
        if (getCittadinanzaDesc() != null) {
            _hashCode += getCittadinanzaDesc().hashCode();
        }
        if (getTel1() != null) {
            _hashCode += getTel1().hashCode();
        }
        if (getTel2() != null) {
            _hashCode += getTel2().hashCode();
        }
        if (getTel3() != null) {
            _hashCode += getTel3().hashCode();
        }
        if (getTesseraTeam() != null) {
            _hashCode += getTesseraTeam().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Paziente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Paziente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglaRegole");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "siglaRegole"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPaziente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idPaziente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPazienteSGP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "idPazienteSGP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cognome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "cognome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "dataNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sesso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "sesso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoDomicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "indirizzoDomicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NCivicoDomicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "nCivicoDomicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comuneDomicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "comuneDomicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comuneDomicilioDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "comuneDomicilioDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("capDomicilio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "capDomicilio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indirizzoResidenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "indirizzoResidenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NCivicoResidenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "nCivicoResidenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comuneResidenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "comuneResidenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comuneResidenzaDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "comuneResidenzaDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("capResidenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "capResidenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comuneNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "comuneNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comuneNascitaDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "comuneNascitaDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aslAppartenenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "aslAppartenenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aslAppartenenzaDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "aslAppartenenzaDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aslAssistenza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "aslAssistenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aslAssistenzaDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "aslAssistenzaDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cittadinanza");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "cittadinanza"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cittadinanzaDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "cittadinanzaDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tel1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "tel1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tel2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "tel2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tel3");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "tel3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tesseraTeam");
        elemField.setXmlName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "tesseraTeam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "TesseraTeam"));
        elemField.setMinOccurs(0);
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
