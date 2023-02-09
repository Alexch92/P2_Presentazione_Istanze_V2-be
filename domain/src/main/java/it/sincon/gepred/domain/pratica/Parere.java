package it.sincon.gepred.domain.pratica;

import it.sincon.gepred.domain.Referente;
import it.sincon.gepred.domain.pratica.Pratica;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * Classe che definisce il parere richiesto per una pratica
 * @author Maria Michela Birtolo
 *
 */
@Entity
@Table(name = "tb_parere")
public class Parere extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "fk_pratica", insertable = false, nullable = false)
	Pratica pratica;
	
	@Column(name = "descrizione",length=255, nullable = false)
	private String descrizione;
	
	@JoinColumn(name = "fk_tipoparere",nullable = false)
	private TipoParere tipoParere;
	
	@JoinColumn(name = "fk_ente", nullable = false)
	private Referente ente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_proto_u", nullable = true)
	private Date dataProtoUscita;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_proto_r", nullable = true)
	private Date dataProtoRisposta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_scadenza", nullable = true)
	private Date dataScadenza;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_risposta", nullable = true)
	private Date dataRisposta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_vis_parere", nullable = true)
	private Date dataVisualizzazioneParere;
	
	@Column(name="numero_proto_u", nullable = true, length = 155)
	private String numeroProtoUscita;
	
	@Column(name="numero_proto_r", nullable = true, length = 155)
	private String numeroProtoRisposta;
	
	@Column(name="completato_u",nullable=false, length=1)
	private boolean completatoUscita;
	
	@Column(name="completato_r",nullable=false, length=1)
	private boolean completatoRisposta;
	
	@JoinColumn(name = "fk_esito", nullable = true)
	private EsitoParere esito;
	
	@Column(name="url_allegato_r", nullable = true, length = 255)
	private String urlAllegatoRisposta;
	
	@Column(name="url_allegato_u", nullable= true, length = 255)
	private String urlAllegatoUscita;
	
	@Column(name="doc_file_uuid_r", nullable= true, length = 45)
	private String uuidFileRisposta;
	@Column(name="doc_file_nome_r", nullable= true, length = 100)
	private String nomeFileRisposta;
	
	@Column(name="doc_file_uuid_u", nullable= true, length = 45)
	private String uuidFileUscita;
	@Column(name="doc_file_nome_u", nullable= true, length = 100)
	private String nomeFileUscita;
	
	public void setId(long pk){
		this.setId(pk);
	}
	
	public Date getDataRisposta() {
		return dataRisposta;
	}

	public void setDataRisposta(Date dataRisposta) {
		this.dataRisposta = dataRisposta;
	}

	public Date getDataVisualizzazioneParere() {
		return dataVisualizzazioneParere;
	}

	public void setDataVisualizzazioneParere(Date dataVisualizzazioneParere) {
		this.dataVisualizzazioneParere = dataVisualizzazioneParere;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getUuidFileRisposta() {
		return uuidFileRisposta;
	}

	public void setUuidFileRisposta(String uuidFileRisposta) {
		this.uuidFileRisposta = uuidFileRisposta;
	}

	public String getNomeFileRisposta() {
		return nomeFileRisposta;
	}

	public void setNomeFileRisposta(String nomeFileRisposta) {
		this.nomeFileRisposta = nomeFileRisposta;
	}

	public String getUuidFileUscita() {
		return uuidFileUscita;
	}

	public void setUuidFileUscita(String uuidFileUscita) {
		this.uuidFileUscita = uuidFileUscita;
	}

	public String getNomeFileUscita() {
		return nomeFileUscita;
	}

	public void setNomeFileUscita(String nomeFileUscita) {
		this.nomeFileUscita = nomeFileUscita;
	}

	public String getUrlAllegatoRisposta() {
		return urlAllegatoRisposta;
	}

	public void setUrlAllegatoRisposta(String urlAllegatoRisposta) {
		this.urlAllegatoRisposta = urlAllegatoRisposta;
	}

	public String getUrlAllegatoUscita() {
		return urlAllegatoUscita;
	}

	public void setUrlAllegatoUscita(String urlAllegatoUscita) {
		this.urlAllegatoUscita = urlAllegatoUscita;
	}

	@Transient
	private File allegatoParereRisposta;
	
	
	public File getAllegatoParereRisposta() {
		return allegatoParereRisposta;
	}

	public void setAllegatoParereRisposta(File allegatoParereRisposta) {
		this.allegatoParereRisposta = allegatoParereRisposta;
	}
	
	@Transient
	private File allegatoParereUscita;
	
	public File getAllegatoParereUscita() {
		return allegatoParereUscita;
	}

	public void setAllegatoParereUscita(File allegatoParereUscita) {
		this.allegatoParereUscita = allegatoParereUscita;
	}

	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoParere getTipoParere() {
		return tipoParere;
	}

	public void setTipoParere(TipoParere tipoParere) {
		this.tipoParere = tipoParere;
	}

	public Referente getEnte() {
		return ente;
	}

	public void setEnte(Referente ente) {
		this.ente = ente;
	}

	public Date getDataProtoUscita() {
		return dataProtoUscita;
	}

	public void setDataProtoUscita(Date dataProtoUscita) {
		this.dataProtoUscita = dataProtoUscita;
	}

	public Date getDataProtoRisposta() {
		return dataProtoRisposta;
	}

	public void setDataProtoRisposta(Date dataProtoRisposta) {
		this.dataProtoRisposta = dataProtoRisposta;
	}

	public String getNumeroProtoUscita() {
		return numeroProtoUscita;
	}

	public void setNumeroProtoUscita(String numeroProtoUscita) {
		this.numeroProtoUscita = numeroProtoUscita;
	}

	public String getNumeroProtoRisposta() {
		return numeroProtoRisposta;
	}

	public void setNumeroProtoRisposta(String numeroProtoRisposta) {
		this.numeroProtoRisposta = numeroProtoRisposta;
	}

	public EsitoParere getEsito() {
		return esito;
	}

	public void setEsito(EsitoParere esito) {
		this.esito = esito;
	}

	public boolean isCompletatoUscita() {
		return completatoUscita;
	}

	public void setCompletatoUscita(boolean completatoUscita) {
		this.completatoUscita = completatoUscita;
	}

	public boolean isCompletatoRisposta() {
		return completatoRisposta;
	}

	public void setCompletatoRisposta(boolean completatoRisposta) {
		this.completatoRisposta = completatoRisposta;
	}

}
