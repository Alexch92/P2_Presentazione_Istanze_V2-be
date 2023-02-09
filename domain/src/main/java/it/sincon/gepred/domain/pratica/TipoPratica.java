package it.sincon.gepred.domain.pratica;

import it.sincon.gepred.domain.Allegati;
import it.sincon.gepred.domain.Attivita;
import it.sincon.gepred.domain.CampiAggiuntivi;
import it.sincon.gepred.domain.CampiAggiuntiviTipoPratica;
import it.sincon.gepred.domain.TipoPraticaAttivita;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;


//import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe che definisce la tipologia di pratica
 * 
 * @author Maria Michela Birtolo
 * @author Antonio Santomauro
 */
@Entity
@Table(name = "tb_tipopratica")
public class TipoPratica extends AbstractPersistable<Long> implements Serializable {

	private static final long serialVersionUID = -247798258529795889L;
	
	@Column(name="descrizione", length=255)
	private String descrizione;
	
	@OneToMany(mappedBy = "tipoPratica",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OrderBy("posizione")
	private List<Allegati> allegati;
	
	@OneToMany(mappedBy = "tipoPratica",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Modelli> modelli;
	
	@OneToMany(mappedBy = "tipoPratica",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TipoPraticaTab> schede;
	
	@Transient
	private List<Allegati> daCancellare;
	
	/*@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable( name = "tb_tipopratica_cagg",
		joinColumns = @JoinColumn( name = "tipopratica_id", referencedColumnName="ID" ),
		inverseJoinColumns = @JoinColumn( name = "campiaggiuntivi_id", referencedColumnName="ID" ) )*/
	
	@OneToMany(mappedBy = "tipoPratica", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("posizione")
	private List<CampiAggiuntiviTipoPratica> campiAggiuntiviTipoPratica;
	
	/*@ManyToMany( fetch = FetchType.LAZY )
	@JoinTable( name = "tb_tipopratica_attivita",
		joinColumns = @JoinColumn( name =  tipo pratica "tipopratica_id", referencedColumnName="ID" ),
		inverseJoinColumns = @JoinColumn( name =  attivita  "attivita_id", referencedColumnName="ID" ) )
	private List<Attivita> attivita;*/
	
	@OneToMany(mappedBy = "tipoPratica", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TipoPraticaAttivita> tipoPraticaAttivita;
	
	@Column(name="link", length=255)
	private String link;
	
	@Column(name="descr_link", length=255)
	private String descr_link;
	
	@Column(name="link2", length=255)
	private String link2;
	
	@Column(name="descr_link2", length=255)
	private String descr_link2;
	
	@Column(name="link3", length=255)
	private String link3;
	
	@Column(name="descr_link3", length=255)
	private String descr_link3;
	
	@Column(name="workflow", length=255)
	private String workflow;
	
	@JoinColumn(name = "fk_categoria", nullable = false)
	private CategoriePratiche categoria;
	
	@Column(name = "configurazione", nullable = false, length = 1)
	private byte configurazione;
	
	@Column(name = "prefisso", nullable = true, length = 10)
	private String prefisso;
	
	@Column(name = "frontend",length=1, nullable = false)
	private boolean frontend;
	
	@Column(name="frontend_editjsp_name", length=45)
	private String frontendEditJspName;
	
	@Column(name="destinatari_mail", length=255)
	private String listaDestinatariMail;
	
	@Column(name="mittente_mail",length=255)
	private String mittenteMail;

	@Column(name="frontend_report_name", length=255)
	private String frontendReportName;
	
	@Column(name="id_tipopratica_correlata")
	private Long idTipoPraticaCorrelata;
	
	@Transient
	private byte showMittDest;

	@Transient
	private byte showLocalita;
	
	@Transient
	private byte showTipoInt;
	
	@Transient
	private byte automaticAssign;
	
	@Transient
	private byte showInviaMailDaAllegato;
	
	@Transient
	private byte showVisibileOnLine;
	
	@Transient
	private byte automaticProtocol;

	
	public byte getAutomaticProtocol() {
		return automaticProtocol;
	}

	public void setAutomaticProtocol(byte automaticProtocol) {
		this.automaticProtocol = automaticProtocol;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public boolean isFrontend() {
		return frontend;
	}

	public void setFrontend(boolean frontend) {
		this.frontend = frontend;
	}

	@Transient
	private byte showStato;
	
 	public String getWorkflow() {
		return workflow;
	}
	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}

	public String getLink2() {
		return link2;
	}
	public void setLink2(String link2) {
		this.link2 = link2;
	}

	public String getDescr_link2() {
		return descr_link2;
	}
	public void setDescr_link2(String descr_link2) {
		this.descr_link2 = descr_link2;
	}

	public String getLink3() {
		return link3;
	}
	public void setLink3(String link3) {
		this.link3 = link3;
	}

	public String getDescr_link3() {
		return descr_link3;
	}
	public void setDescr_link3(String descr_link3) {
		this.descr_link3 = descr_link3;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getDescr_link() {
		return descr_link;
	}
	public void setDescr_link(String descr_link) {
		this.descr_link = descr_link;
	}

	/*public List<Attivita> getAttivita() {
		return attivita;
	}
	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}*/

	public List<TipoPraticaAttivita> getTipoPraticaAttivita() {
		return tipoPraticaAttivita;
	}
	public void setTipoPraticaAttivita(List<TipoPraticaAttivita> tipoPraticaAttivita) {
		this.tipoPraticaAttivita = tipoPraticaAttivita;
	}
	
	public List<CampiAggiuntiviTipoPratica> getCampiAggiuntiviTipoPratica() {
		return campiAggiuntiviTipoPratica;
	}
	public void setCampiAggiuntiviTipoPratica(List<CampiAggiuntiviTipoPratica> campiAggiuntiviTipoPratica) {
		this.campiAggiuntiviTipoPratica = campiAggiuntiviTipoPratica;
	}

	public List<Allegati> getAllegati() {
		return allegati;
	}
	public void setAllegati(List<Allegati> allegati) {
		this.allegati = allegati;
	}
	
	public List<Modelli> getModelli() {
		return modelli;
	}
	public void setModelli(List<Modelli> modelli) {
		this.modelli = modelli;
	}
  
	public List<TipoPraticaTab> getSchede() {
		return schede;
	}
	public void setSchede(List<TipoPraticaTab> schede) {
		this.schede = schede;
	}

	public List<Allegati> getDaCancellare() {
		return daCancellare;
	}
	public void setDaCancellare(List<Allegati> daCancellare) {
		this.daCancellare = daCancellare;
	}

	public String getDescrizione() {		
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public CategoriePratiche getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriePratiche categoria) {
		this.categoria = categoria;
	}

	public byte getConfigurazione() {
		return configurazione;
	}
	public void setConfigurazione(byte configurazione) {
		this.configurazione = configurazione;
	}
	
	public byte getShowMittDest() {
		return showMittDest;
	}
	public void setShowMittDest(byte showMittDest) {
		this.showMittDest = showMittDest;
	}

	public byte getShowLocalita() {
		return showLocalita;
	}
	public void setShowLocalita(byte showLocalita) {
		this.showLocalita = showLocalita;
	}

	public byte getShowTipoInt() {
		return showTipoInt;
	}
	public void setShowTipoInt(byte showTipoInt) {
		this.showTipoInt = showTipoInt;
	}

	public byte getShowStato() {
		return showStato;
	}
	public void setShowStato(byte showStato) {
		this.showStato = showStato;
	}

	public byte getAutomaticAssign() {
		return automaticAssign;
	}
	public void setAutomaticAssign(byte automaticAssign) {
		this.automaticAssign = automaticAssign;
	}

	public String getPrefisso() {
		return prefisso;
	}
	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}
	
	public String getFrontendEditJspName() {
		return frontendEditJspName;
	}
	public void setFrontendEditJspName(String frontendEditJspName) {
		this.frontendEditJspName = frontendEditJspName;
	}
	
	public byte getShowInviaMailDaAllegato() {
		return showInviaMailDaAllegato;
	}
	public void setShowInviaMailDaAllegato(byte showInviaMailDaAllegato) {
		this.showInviaMailDaAllegato = showInviaMailDaAllegato;
	}
	
	public byte getShowVisibileOnLine() {
		return showVisibileOnLine;
	}
	public void setShowVisibileOnLine(byte showVisibileOnLine) {
		this.showVisibileOnLine = showVisibileOnLine;
	}
	
	public String getListaDestinatariMail() {
		return listaDestinatariMail;
	}
	public void setListaDestinatariMail(String listaDestinatariMail) {
		this.listaDestinatariMail = listaDestinatariMail;
	}

	/**
	 * Metodo utility per la generazione di un oggetto JSON che 
	 * sarà usato per il calcolo automatico della data di scadenza di un'attività
	 * 
	 * @return lista in formato JSON delle attività con relative scadenze
	 * @throws JSONException
	 * @author Angelo Pascadopoli
	 */
	public JSONObject getScadenzaAttivita() throws JSONException {
		HashMap<Long, Integer> mappa = new HashMap<Long, Integer>();
		for (TipoPraticaAttivita tpa:tipoPraticaAttivita) {
			mappa.put(tpa.getAttivita().getId(), tpa.getScadenza());
		}
		JSONObject json = new JSONObject();
		json.put("activities", mappa);
		return json;
	}
	
	public List<Tab> getCustomTabs()
	{
		List<Tab> tabs = new ArrayList<Tab>();
		for(TipoPraticaTab scheda:schede)
		{
			if (scheda.getTab()!=null)
			{
				if ((!scheda.isNew() && scheda.getTab().isCancellabile()) )
					tabs.add(scheda.getTab());
				else if (scheda.getTab().isMaster())
					tabs.add(scheda.getTab());
			}
		}
		return tabs;
	}

	public String getMittenteMail() {
		return mittenteMail;
	}
	public void setMittenteMail(String mittenteMail) {
		this.mittenteMail = mittenteMail;
	}

	public String getFrontendReportName() {
		return frontendReportName;
	}
	public void setFrontendReportName(String frontendReportName) {
		this.frontendReportName = frontendReportName;
	}

	public Long getIdTipoPraticaCorrelata() {
		return idTipoPraticaCorrelata;
	}

	public void setIdTipoPraticaCorrelata(Long idTipoPraticaCorrelata) {
		this.idTipoPraticaCorrelata = idTipoPraticaCorrelata;
	}
	
	
}
