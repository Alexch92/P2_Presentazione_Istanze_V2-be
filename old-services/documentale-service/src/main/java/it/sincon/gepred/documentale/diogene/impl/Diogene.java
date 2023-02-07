/**
 * Diogene.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.impl;

public interface Diogene extends java.rmi.Remote {
    public it.sincon.gepred.documentale.diogene.bean.WS_Download download(java.lang.String username, java.lang.String idDocumento, java.lang.String idVersione) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovaCartella(java.lang.String username, it.sincon.gepred.documentale.diogene.bean.WS_NuovaCartella cartella) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovoFascicolo(java.lang.String username, it.sincon.gepred.documentale.diogene.bean.WS_NuovoFascicolo fascicolo) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovaVersione(java.lang.String username, java.lang.String idDocumento, java.lang.String tipoContenitore, java.lang.String nomeFile, byte[] cotenutoFile) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovoDocumento(java.lang.String username, java.lang.String tipoContenitore, it.sincon.gepred.documentale.diogene.bean.WS_NuovoDocumento ws_documento) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto mostraContenuto(java.lang.String username, java.lang.String idAggregato) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio leggiDettaglio(java.lang.String username, java.lang.String idOggetto, java.lang.String tipoOggetto, java.lang.String tipoContenitore) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult ricerca(java.lang.String username, int maxDoc, it.sincon.gepred.documentale.diogene.bean.WS_RicercaType ricercaType) throws java.rmi.RemoteException;
    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio spostaDocumento(java.lang.String username, java.lang.String idDocumento, java.lang.String tipoContenitore, java.lang.String idAggregatoDestinazione) throws java.rmi.RemoteException;
}
