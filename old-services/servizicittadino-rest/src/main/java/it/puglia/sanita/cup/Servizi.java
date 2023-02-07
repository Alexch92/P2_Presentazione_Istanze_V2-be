/**
 * Servizi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public interface Servizi extends java.rmi.Remote {
    public it.puglia.sanita.cup.RispostaLogin getLogin(it.puglia.sanita.cup.RichiestaLogin richiestaLogin) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaPaziente getPaziente(it.puglia.sanita.cup.RichiestaPaziente richiestaPaziente) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaSetPaziente setPaziente(it.puglia.sanita.cup.RichiestaPaziente richiestaSetPaziente) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaListaDisponibilita getListaDisponibilita(it.puglia.sanita.cup.RichiestaListaDisponibilita richiestaListaDisponibilita) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaPrenota setPrenota(it.puglia.sanita.cup.RichiestaPrenota richiestaPrenota) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaPrenota setPrenotaPrimaDisponibilita(it.puglia.sanita.cup.RichiestaListaDisponibilita richiestaListaDisponibilita) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaPromemoria getPromemoria(it.puglia.sanita.cup.RichiestaPromemoria richiestaPromemoria) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaCancella setCancella(it.puglia.sanita.cup.RichiestaCancella richiestaCancella) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaPrescrizioni getPrescrizioni(it.puglia.sanita.cup.RichiestaPrescrizioni richiestaPrescrizioni) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaRegistrazione setRegistrazione(it.puglia.sanita.cup.RichiestaRegistrazione richiestaRegistrazione) throws java.rmi.RemoteException;
    public it.puglia.sanita.cup.RispostaCambiaStatoPrestazione setCambiaStatoPrestazione(it.puglia.sanita.cup.RichiestaCambiaStatoPrestazione richiestaCambiaStatoPrestazione) throws java.rmi.RemoteException;
}
