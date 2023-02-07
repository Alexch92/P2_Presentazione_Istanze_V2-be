/**
 * ProtocolloPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.impl;

public interface ProtocolloPortType extends java.rmi.Remote {
    public it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo eseguiProtocollazione(it.sincon.gepred.protocollo.scatel.bean.ParametriEseguiProtocollo arg1, String authorization) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO ricercaAOO(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAOO arg1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo ricercaProtocolli(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaProtocollo arg1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo prelevaDettaglioProtocollo(it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaProtocollo inputpar) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati prelevaDocumentiProtocollo(it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaDocumentiProtocollo inputpar) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo ricercaAssegnazioniInoltri(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAssegnazioniInoltriProtocollo inputpar) throws java.rmi.RemoteException;
}
