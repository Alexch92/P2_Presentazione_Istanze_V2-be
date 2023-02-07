/**
 * ProtocolloWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.folium.impl;

public interface ProtocolloWebService extends java.rmi.Remote {
    public it.sincon.gepred.protocollo.folium.bean.WSEsito testLogin(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.WSEsito testStato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.VoceTitolario[] ricercaTitolarioPerCodiceDescrizione(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.VoceTitolario in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato[] ricercaProtocolli(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.Ricerca in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato protocolla(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.ImmagineDocumentale inserisciContenuto(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.ImmagineDocumentale in1, boolean in2) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.Assegnazione assegna(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.Assegnazione in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.ImmagineDocumentale recuperaContenuto(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException;
    public byte[] getContenutoDocumento(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.Allegato inserisciAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.Allegato in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.Allegato[] getAllegati(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.Allegato getAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException;
    public byte[] getContenutoAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException;
    public it.sincon.gepred.protocollo.folium.bean.Allegato rimuoviAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException;
}
