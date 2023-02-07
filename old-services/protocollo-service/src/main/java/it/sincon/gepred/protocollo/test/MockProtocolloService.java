package it.sincon.gepred.protocollo.test;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.BeanUtils;

import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiAutenticazione;
import it.sincon.gepred.protocollo.bean.DatiEsito;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;
import it.sincon.gepred.protocollo.service.ProtocolloService;

public class MockProtocolloService implements ProtocolloService {

	private boolean generaSituazioneAnomala;
	private Map<String,Integer> protocolloAnno;
	private Map<DatiOutputProtocollo,DatiRichiestaProtocollo> protocollo;
	
	public MockProtocolloService(){
		protocollo = new HashMap<DatiOutputProtocollo, DatiRichiestaProtocollo>();
		protocolloAnno = new HashMap<String, Integer>();
	}
	
	
	public boolean isGeneraSituazioneAnomala() {
		return generaSituazioneAnomala;
	}

	public void setGeneraSituazioneAnomala(boolean generaSituazioneAnomala) {
		this.generaSituazioneAnomala = generaSituazioneAnomala;
	}

	@Override
	public DatiOutputProtocollo protocollaPratica(
			DatiRichiestaProtocollo datiProtocollazione, DatiAutenticazione datiAutenticazione) {
		DatiOutputProtocollo result = new DatiOutputProtocollo();
		DatiEsito esito = new DatiEsito();
		if (generaSituazioneAnomala)
		{
			esito.setCodice("100");
			esito.setDescrizione("Errore nel salvataggio del protocollo");
		}
		else
		{
			if (datiProtocollazione.getDatiProtocollazione()!=null && !protocollo.containsKey(datiProtocollazione.getDatiProtocollazione()))
			{
				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyy");
				String anno = df.format(date);
				result.setDataProtocollo(date);
				if (protocolloAnno.containsKey(anno))
				{
					result.setNumeroProtocollo(String.format("%7s",Integer.toString(protocolloAnno.get(anno)+1)).replaceAll(" ","0"));
					protocolloAnno.put(anno, protocolloAnno.get(anno)+1);
				}
				else
				{
					result.setNumeroProtocollo("0000001");
					protocolloAnno.put(anno, new Integer(1));
				}
				result.setIdProtocollo(new Long(protocollo.size()+1));
				protocollo.put(result, datiProtocollazione);
			}
			else
				protocollo.put(datiProtocollazione.getDatiProtocollazione(), datiProtocollazione);
			esito.setCodice("000");
			esito.setDescrizione("Operazione terminata con successo");
		}
		result.setEsito(esito);
		return result;
	}

	@Override
	public DatiRichiestaProtocollo consultaProtocollo(
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		DatiRichiestaProtocollo result = null;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		for(Map.Entry<DatiOutputProtocollo, DatiRichiestaProtocollo> row:protocollo.entrySet())
		{
			if (row.getKey().getNumeroProtocollo().equals(datiIdentificativiProtocollo.getNumeroProtocollo())&&df.format(row.getKey().getDataProtocollo()).equals(df.format(datiIdentificativiProtocollo.getDataProtocollo())))
			{
				result = new DatiRichiestaProtocollo();
				BeanUtils.copyProperties(row.getValue(), result);
				result.setAllegati(null);
				result.setDocumentoPrincipale(null);
				result.setDatiProtocollazione(row.getKey());
			}
		}
		if (result!=null)
		{
			DatiEsito esito = new DatiEsito();
			esito.setCodice("000");
			esito.setDescrizione("Operazione terminata con successo");
			result.setEsito(esito);
		}
		else
		{
			result = new DatiRichiestaProtocollo();
			DatiEsito esito = new DatiEsito();
			esito.setCodice("101");
			esito.setDescrizione("Errore nel recupero del protocollo");
			result.setEsito(esito);
		}
		return result;
	}

	@Override
	public DatiOutputProtocollo allegaDocumentoAProtocollo(
			AllegatoProtocollo allegato,
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		DatiOutputProtocollo result = null;
		DatiRichiestaProtocollo drp = null;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		for(Map.Entry<DatiOutputProtocollo, DatiRichiestaProtocollo> row:protocollo.entrySet())
		{
			if (row.getKey().getNumeroProtocollo().equals(datiIdentificativiProtocollo.getNumeroProtocollo())&&df.format(row.getKey().getDataProtocollo()).equals(df.format(datiIdentificativiProtocollo.getDataProtocollo())))
				drp = row.getValue();
		}
		if (drp!=null)
		{
			drp.getAllegati().add(allegato);
			result = new DatiOutputProtocollo();
			result.setDataProtocollo(datiIdentificativiProtocollo.getDataProtocollo());
			result.setIdProtocollo(datiIdentificativiProtocollo.getIdProtocollo());
			result.setNumeroProtocollo(datiIdentificativiProtocollo.getNumeroProtocollo());
			DatiEsito esito = new DatiEsito();
			esito.setCodice("000");
			esito.setDescrizione("Operazione terminata con successo");
			result.setEsito(esito);
		}
		else
		{
			result = new DatiOutputProtocollo();
			DatiEsito esito = new DatiEsito();
			esito.setCodice("101");
			esito.setDescrizione("Errore nel recupero del protocollo");
			result.setEsito(esito);
		}
		return result;
	}

	@Override
	public SortedMap<MezzoSpedizioneEnum, Serializable> traduciMezziSpedizione() {
		SortedMap<MezzoSpedizioneEnum,Serializable> result = null;
		if (!generaSituazioneAnomala)
		{
			result = new TreeMap<MezzoSpedizioneEnum, Serializable>();
			result.put(MezzoSpedizioneEnum.EMAIL_ORDINARIA, "MAILST");
			result.put(MezzoSpedizioneEnum.POSTA_ORDINARIA, "PTORDI");
			result.put(MezzoSpedizioneEnum.POSTA_PRIORITARIA, "PTPRIO");
			result.put(MezzoSpedizioneEnum.RACCOMANDATA_A_MANO, "RACCAM");
			result.put(MezzoSpedizioneEnum.RACCOMANDATA_AR, "RACCAR");
			result.put(MezzoSpedizioneEnum.RACCOMANDATA_ORDINARIA, "RACCST");
			result.put(MezzoSpedizioneEnum.EMAIL_AO, "MAILAO");
			result.put(MezzoSpedizioneEnum.EMAIL_AM, "MAILAM");
		}
		return result;
	}


	@Override
	public DatiOutputProtocollo completaProtocollazioneProvvisoria(
			AllegatoProtocollo documentoPrincipale,
			DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione) {
		DatiOutputProtocollo result = null;
		DatiRichiestaProtocollo drp = null;
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		for(Map.Entry<DatiOutputProtocollo, DatiRichiestaProtocollo> row:protocollo.entrySet())
		{
			if (row.getKey().getNumeroProtocollo().equals(datiIdentificativiProtocollo.getNumeroProtocollo())&&df.format(row.getKey().getDataProtocollo()).equals(df.format(datiIdentificativiProtocollo.getDataProtocollo())))
				drp = row.getValue();
		}
		if (drp!=null)
		{
			drp.setDocumentoPrincipale(documentoPrincipale);
			result = new DatiOutputProtocollo();
			result.setDataProtocollo(datiIdentificativiProtocollo.getDataProtocollo());
			result.setIdProtocollo(datiIdentificativiProtocollo.getIdProtocollo());
			result.setNumeroProtocollo(datiIdentificativiProtocollo.getNumeroProtocollo());
			DatiEsito esito = new DatiEsito();
			esito.setCodice("000");
			esito.setDescrizione("Operazione terminata con successo");
			result.setEsito(esito);
		}
		else
		{
			result = new DatiOutputProtocollo();
			DatiEsito esito = new DatiEsito();
			esito.setCodice("101");
			esito.setDescrizione("Impossibile effettuare il completamento");
			result.setEsito(esito);
		}
		return result;
	}


	@Override
	public boolean isSettatoInviaPc() {
		return true;
	}


	@Override
	public boolean isImplementedCompletamento() {
		return true;
	}


	@Override
	public boolean isImplementedProtocolloUscita() {
		return true;
	}

}
