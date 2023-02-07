package it.sincon.gepred.protocollo.service;

import java.io.Serializable;
import java.util.SortedMap;

import it.sincon.gepred.protocollo.bean.AllegatoProtocollo;
import it.sincon.gepred.protocollo.bean.DatiAutenticazione;
import it.sincon.gepred.protocollo.bean.DatiOutputProtocollo;
import it.sincon.gepred.protocollo.bean.DatiRichiestaProtocollo;
import it.sincon.gepred.protocollo.bean.MezzoSpedizioneEnum;

public interface ProtocolloService {
	
	public DatiOutputProtocollo protocollaPratica(DatiRichiestaProtocollo datiProtocollazione, DatiAutenticazione datiAutenticazione);
	public DatiRichiestaProtocollo consultaProtocollo(DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione);
	public DatiOutputProtocollo completaProtocollazioneProvvisoria(AllegatoProtocollo documentoPrincipale,DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione);
	public DatiOutputProtocollo allegaDocumentoAProtocollo(AllegatoProtocollo allegato,DatiOutputProtocollo datiIdentificativiProtocollo, DatiAutenticazione datiAutenticazione);
	public SortedMap<MezzoSpedizioneEnum, Serializable> traduciMezziSpedizione();
	public boolean isSettatoInviaPc();
	public boolean isImplementedCompletamento();
	public boolean isImplementedProtocolloUscita();

}