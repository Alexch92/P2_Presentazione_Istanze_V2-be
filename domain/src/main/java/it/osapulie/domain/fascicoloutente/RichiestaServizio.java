package it.osapulie.domain.fascicoloutente;

//import it.osapulie.domain.ComuneISA;
import it.osapulie.domain.ProfiloUtente;
import it.osapulie.domain.servizi.Servizio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "tb_richiesta_servizio")
public class RichiestaServizio extends AbstractPersistable<Long> {

	private static final long serialVersionUID = -5303720382892396010L;

	@JoinColumn(name = "fk_fascicolo", nullable = false)
	private FascicoloUtente fascicolo;

	//@JoinColumn(name = "fk_comune")
	//private ComuneISA comuneErogatore;

	@Column(name = "nome_servizio", nullable = false, updatable = false, length = 128)
	private String nomeServizio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_richiesta")
	private Date dataRichiesta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_risposta")
	private Date dataRisposta;

	@JoinColumn(name = "fk_delegante")
	private ProfiloUtente delegante;

	@JoinColumn(name = "fk_servizio", nullable = false)
	private Servizio servizio;

	@Column(name = "ricercabile")
	private boolean ricercabileDaComune;

	@Column(name = "checksum", nullable = true, length = 256)
	private String checksum;

	public ProfiloUtente getDelegante() {
		return delegante;
	}

	public void setDelegante(ProfiloUtente delegante) {
		this.delegante = delegante;
	}

	public FascicoloUtente getFascicolo() {
		return fascicolo;
	}

	public void setFascicolo(FascicoloUtente fascicolo) {
		this.fascicolo = fascicolo;
	}

	/*public ComuneISA getComuneErogatore() {
		return comuneErogatore;
	}

	public void setComuneErogatore(ComuneISA comuneErogatore) {
		this.comuneErogatore = comuneErogatore;
	}
*/
	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public Date getDataRisposta() {
		return dataRisposta;
	}

	public void setDataRisposta(Date dataRisposta) {
		this.dataRisposta = dataRisposta;
	}

	public Servizio getServizio() {
		return servizio;
	}

	public void setServizio(Servizio servizio) {
		this.servizio = servizio;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public boolean isRicercabileDaComune() {
		return ricercabileDaComune;
	}

	public void setRicercabileDaComune(boolean ricercabileDaComune) {
		this.ricercabileDaComune = ricercabileDaComune;
	}
}
