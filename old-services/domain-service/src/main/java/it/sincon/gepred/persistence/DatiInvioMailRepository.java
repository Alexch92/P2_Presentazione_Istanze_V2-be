package it.sincon.gepred.persistence;
import java.util.List;

import it.sincon.gepred.domain.AllegatiPratica;
import it.sincon.gepred.domain.DatiInvioMail;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Maria MIchela Birtolo
 *
 */

public interface DatiInvioMailRepository  extends JpaRepository<DatiInvioMail,Long> {
	List<DatiInvioMail> findByDestinatarioAndInviatoAndAllegato(String _dest, boolean _inviato, AllegatiPratica _allegato);
}



