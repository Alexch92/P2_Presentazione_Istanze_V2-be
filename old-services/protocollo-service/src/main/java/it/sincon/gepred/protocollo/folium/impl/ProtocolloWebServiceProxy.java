package it.sincon.gepred.protocollo.folium.impl;

public class ProtocolloWebServiceProxy implements it.sincon.gepred.protocollo.folium.impl.ProtocolloWebService {
  private String _endpoint = null;
  private it.sincon.gepred.protocollo.folium.impl.ProtocolloWebService protocolloWebService = null;
  
  public ProtocolloWebServiceProxy() {
    _initProtocolloWebServiceProxy();
  }
  
  public ProtocolloWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initProtocolloWebServiceProxy();
  }
  
  private void _initProtocolloWebServiceProxy() {
    try {
      protocolloWebService = (new it.sincon.gepred.protocollo.folium.impl.ProtocolloWebServiceServiceLocator()).getProtocolloWebService();
      if (protocolloWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)protocolloWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)protocolloWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (protocolloWebService != null)
      ((javax.xml.rpc.Stub)protocolloWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.sincon.gepred.protocollo.folium.impl.ProtocolloWebService getProtocolloWebService() {
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService;
  }
  
  public it.sincon.gepred.protocollo.folium.bean.WSEsito testLogin(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.testLogin(in0);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.WSEsito testStato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.testStato(in0);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.VoceTitolario[] ricercaTitolarioPerCodiceDescrizione(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.VoceTitolario in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.ricercaTitolarioPerCodiceDescrizione(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato[] ricercaProtocolli(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.Ricerca in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.ricercaProtocolli(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato protocolla(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.DocumentoProtocollato in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.protocolla(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.ImmagineDocumentale inserisciContenuto(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.ImmagineDocumentale in1, boolean in2) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.inserisciContenuto(in0, in1, in2);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.Assegnazione assegna(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.Assegnazione in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.assegna(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.ImmagineDocumentale recuperaContenuto(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.recuperaContenuto(in0, in1);
  }
  
  public byte[] getContenutoDocumento(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.getContenutoDocumento(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.Allegato inserisciAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, it.sincon.gepred.protocollo.folium.bean.Allegato in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.inserisciAllegato(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.Allegato[] getAllegati(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.getAllegati(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.Allegato getAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.getAllegato(in0, in1);
  }
  
  public byte[] getContenutoAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.getContenutoAllegato(in0, in1);
  }
  
  public it.sincon.gepred.protocollo.folium.bean.Allegato rimuoviAllegato(it.sincon.gepred.protocollo.folium.bean.WSAuthentication in0, long in1) throws java.rmi.RemoteException{
    if (protocolloWebService == null)
      _initProtocolloWebServiceProxy();
    return protocolloWebService.rimuoviAllegato(in0, in1);
  }
  
  
}