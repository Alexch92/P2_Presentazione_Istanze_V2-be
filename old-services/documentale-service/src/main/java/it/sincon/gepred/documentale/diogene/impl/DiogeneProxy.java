package it.sincon.gepred.documentale.diogene.impl;

public class DiogeneProxy implements it.sincon.gepred.documentale.diogene.impl.Diogene {
  private String _endpoint = null;
  private it.sincon.gepred.documentale.diogene.impl.Diogene diogene = null;
  
  public DiogeneProxy() {
    _initDiogeneProxy();
  }
  
  public DiogeneProxy(String endpoint) {
    _endpoint = endpoint;
    _initDiogeneProxy();
  }
  
  private void _initDiogeneProxy() {
    try {
      diogene = (new it.sincon.gepred.documentale.diogene.impl.DiogeneServiceLocator()).getDiogene();
      if (diogene != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)diogene)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)diogene)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (diogene != null)
      ((javax.xml.rpc.Stub)diogene)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.sincon.gepred.documentale.diogene.impl.Diogene getDiogene() {
    if (diogene == null)
      _initDiogeneProxy();
    return diogene;
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_Download download(java.lang.String username, java.lang.String idDocumento, java.lang.String idVersione) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.download(username, idDocumento, idVersione);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovaCartella(java.lang.String username, it.sincon.gepred.documentale.diogene.bean.WS_NuovaCartella cartella) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.nuovaCartella(username, cartella);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovoFascicolo(java.lang.String username, it.sincon.gepred.documentale.diogene.bean.WS_NuovoFascicolo fascicolo) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.nuovoFascicolo(username, fascicolo);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovaVersione(java.lang.String username, java.lang.String idDocumento, java.lang.String tipoContenitore, java.lang.String nomeFile, byte[] cotenutoFile) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.nuovaVersione(username, idDocumento, tipoContenitore, nomeFile, cotenutoFile);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovoDocumento(java.lang.String username, java.lang.String tipoContenitore, it.sincon.gepred.documentale.diogene.bean.WS_NuovoDocumento ws_documento) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.nuovoDocumento(username, tipoContenitore, ws_documento);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto mostraContenuto(java.lang.String username, java.lang.String idAggregato) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.mostraContenuto(username, idAggregato);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio leggiDettaglio(java.lang.String username, java.lang.String idOggetto, java.lang.String tipoOggetto, java.lang.String tipoContenitore) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.leggiDettaglio(username, idOggetto, tipoOggetto, tipoContenitore);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult ricerca(java.lang.String username, int maxDoc, it.sincon.gepred.documentale.diogene.bean.WS_RicercaType ricercaType) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.ricerca(username, maxDoc, ricercaType);
  }
  
  public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio spostaDocumento(java.lang.String username, java.lang.String idDocumento, java.lang.String tipoContenitore, java.lang.String idAggregatoDestinazione) throws java.rmi.RemoteException{
    if (diogene == null)
      _initDiogeneProxy();
    return diogene.spostaDocumento(username, idDocumento, tipoContenitore, idAggregatoDestinazione);
  }
  
  
}