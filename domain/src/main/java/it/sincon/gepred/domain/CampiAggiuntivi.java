package it.sincon.gepred.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import javax.persistence.Table;


//import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * @author Eligio Cavallo
 * @author Angelo Pascadopoli
 * @author Giuseppe Cellamare
 *
 */
@Entity
@Table(name = "tb_campiaggiuntivi")
public class CampiAggiuntivi extends AbstractPersistable<Long> implements Serializable{

	private static final long serialVersionUID = 7612629974513650558L;

	@Column(name = "label",length=500 ,nullable = false)
	private String label;
	
	@Column(name = "labelBackOffice",length=500 ,nullable = true)
	private String labelBackOffice;
	
	@Column(name = "tipologia",length=1, nullable = false)
	private String tipologia;
	
	@Column(name = "ricercabile",length=1, nullable = true)
	private boolean ricercabile;
	
	@Column(name="disabled",nullable=false,length=1)
	private boolean campoDisabilitato;
	
	@Column(name="classe_css",nullable=true, length=255)
	private String classeCSS;
	
	@Column(name = "controllo", nullable = true)
	private String controllo; 
	
	@Column(name = "condizione_punteggio", nullable = true)
	private String condizionePunteggio; 
	
	@Column(name = "punteggio", nullable = true)
	private int punteggio; 
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parent")
	private List<CampiAggiuntivi> children;
	
	@OneToMany(mappedBy ="campiAggiuntivi", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CampiAggiuntiviListaValori> valori;
	
	@ManyToOne
	@JoinColumn(name = "fk_parent")
	private CampiAggiuntivi parent;

	@Column(name = "listaValori")
	private String listaValori;
	
	@Column(name = "dimensione", nullable = true)
	private Byte dimensione;
	
	@Transient
	private String valoreRicerca;
	
	@Column(name = "note", length=255, nullable =true)
	private String note;
	
	public void setId(Long id) {
		super.setId(id);
	}
	
	/*@OneToMany(mappedBy = "campiAggiuntivi", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CampiAggiuntiviTipoPratica> campiAggiuntiviTipoPratica;*/
	
	/*@OneToMany(mappedBy = "campiAggiuntivi", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CampiAggiuntiviPratica> campiAggiuntiviPratica;*/
	
/*	@Column(name = "visibile",length=1, nullable = false)//1=Front-End 0= Back-End 2=Entrambi /Default=Back-End
	private int visibile;*/
	
	/*@OrderBy
	@Column(name = "posizione",length=3, nullable = false)
	private Integer posizione;*/
	
	/*@OrderBy
	@Column(name = "accessibile", length=1, nullable = false)
	private int accessibile; // 0 - Pagina Principale, 1 - Tab, 2 - Entrambi, default = 0
*/	
	/*@JoinColumn( name = "fk_tipologia",nullable = true)
	private TipoPratica tipoPratica;
	
	@OneToMany(mappedBy = "tipoPratica")
	private List<TipoPratica> tipoPratiche;*/
	
/*	public int getVisibile() {
		return visibile;
	}

	public void setVisibile(int visibile) {
		this.visibile = visibile;
	}
*/
	
	/*public List<CampiAggiuntiviPratica> getCampiAggiuntiviPratica() {
		return campiAggiuntiviPratica;
	}

	public void setCampiAggiuntiviPratica(
			List<CampiAggiuntiviPratica> campiAggiuntiviPratica) {
		this.campiAggiuntiviPratica = campiAggiuntiviPratica;
	}*/
	
	/*public List<CampiAggiuntiviTipoPratica> getCampiAggiuntiviTipoPratica() {
		return campiAggiuntiviTipoPratica;
	}
	
	public void setCampiAggiuntiviTipoPratica(
			List<CampiAggiuntiviTipoPratica> campiAggiuntiviTipoPratica) {
		this.campiAggiuntiviTipoPratica = campiAggiuntiviTipoPratica;
	}*/

	public String getControllo() {
		return controllo;
	}

	public void setControllo(String controllo) {
		this.controllo = controllo;
	}

	/*public List<TipoPratica> getTipoPratiche() {
		return tipoPratiche;
	}

	public void setTipoPratiche(List<TipoPratica> tipoPratiche) {
		this.tipoPratiche = tipoPratiche;
	}*/

	public List<CampiAggiuntivi> getChildren() {
		return children;
	}

	public void setChildren(List<CampiAggiuntivi> children) {
		this.children = children;
	}

	public CampiAggiuntivi getParent() {
		return parent;
	}

	public void setParent(CampiAggiuntivi parent) {
		this.parent = parent;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	public String getTipologia() {
		return tipologia;
	}

/*	public Integer getPosizione() {
		return posizione;
	}*/

	public void setListaValori(String listaValori) {
		this.listaValori = listaValori;
	}
	
	public String getListaValori() {
		return listaValori;
	}

/*	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
	}*/

	/**
	 * Restituisce la lista valori come un array di stringhe
	 * @return String[]
	 */
	public String[] getListaValoriArray(){
		return this.listaValori.split(",");
	}

	public boolean isRicercabile() {
		return ricercabile;
	}

	public void setRicercabile(boolean ricercabile) {
		this.ricercabile = ricercabile;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Byte getDimensione() {
		return dimensione;
	}

	public void setDimensione(Byte dimensione) {
		this.dimensione = dimensione;
	}

	/*public TipoPratica getTipoPratica() {
		return tipoPratica;
	}

	public void setTipoPratica(TipoPratica tipoPratica) {
		this.tipoPratica = tipoPratica;
	}
	*/
	public String getValoreRicerca() {
		return valoreRicerca;
	}

	public void setValoreRicerca(String valoreRicerca) {
		this.valoreRicerca = valoreRicerca;
	}

	public List<CampiAggiuntiviListaValori> getValori() {
		return valori;
	}

	public void setValori(List<CampiAggiuntiviListaValori> valori) {
		this.valori = valori;
	}

	public boolean isCampoDisabilitato() {
		return campoDisabilitato;
	}

	public void setCampoDisabilitato(boolean campoDisabilitato) {
		this.campoDisabilitato = campoDisabilitato;
	}

	public String getClasseCSS() {
		return classeCSS;
	}

	public void setClasseCSS(String classeCSS) {
		this.classeCSS = classeCSS;
	}

	public String getLabelBackOffice() {
		return labelBackOffice;
	}

	public void setLabelBackOffice(String labelBackOffice) {
		this.labelBackOffice = labelBackOffice;
	}

	public String getCondizionePunteggio() {
		return condizionePunteggio;
	}

	public void setCondizionePunteggio(String condizionePunteggio) {
		this.condizionePunteggio = condizionePunteggio;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	

/*	public int getAccessibile() {
		return accessibile;
	}

	public void setAccessibile(int accessibile) {
		this.accessibile = accessibile;
	}*/
	
}
