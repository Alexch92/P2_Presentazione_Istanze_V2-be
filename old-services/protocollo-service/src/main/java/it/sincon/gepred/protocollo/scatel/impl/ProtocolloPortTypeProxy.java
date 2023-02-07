package it.sincon.gepred.protocollo.scatel.impl;

public class ProtocolloPortTypeProxy implements it.sincon.gepred.protocollo.scatel.impl.ProtocolloPortType {
  private String _endpoint = null;
  private it.sincon.gepred.protocollo.scatel.impl.ProtocolloPortType protocolloPortType = null;
  
  public ProtocolloPortTypeProxy() {
    _initProtocolloPortTypeProxy();
  }
  
  public ProtocolloPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initProtocolloPortTypeProxy();
  }
  
  private void _initProtocolloPortTypeProxy() {
    try {
      protocolloPortType = (new it.sincon.gepred.protocollo.scatel.impl.ProtocolloWSLocator()).getProtocolloPort();
      if (protocolloPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)protocolloPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)protocolloPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (protocolloPortType != null)
      ((javax.xml.rpc.Stub)protocolloPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.sincon.gepred.protocollo.scatel.impl.ProtocolloPortType getProtocolloPortType() {
    if (protocolloPortType == null)
      _initProtocolloPortTypeProxy();
    return protocolloPortType;
  }
  
  public it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo eseguiProtocollazione(it.sincon.gepred.protocollo.scatel.bean.ParametriEseguiProtocollo arg1, String authorization) throws java.rmi.RemoteException{
    if (protocolloPortType == null)
      _initProtocolloPortTypeProxy();
    return protocolloPortType.eseguiProtocollazione(arg1, authorization);
  }
  
  public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO ricercaAOO(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAOO arg1) throws java.rmi.RemoteException{
    if (protocolloPortType == null)
      _initProtocolloPortTypeProxy();
    return protocolloPortType.ricercaAOO(arg1);
  }
  
  public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo ricercaProtocolli(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaProtocollo arg1) throws java.rmi.RemoteException{
    if (protocolloPortType == null)
      _initProtocolloPortTypeProxy();
    return protocolloPortType.ricercaProtocolli(arg1);
  }
  
  public it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo prelevaDettaglioProtocollo(it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaProtocollo inputpar) throws java.rmi.RemoteException{
    if (protocolloPortType == null)
      _initProtocolloPortTypeProxy();
    return protocolloPortType.prelevaDettaglioProtocollo(inputpar);
  }
  
  public it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati prelevaDocumentiProtocollo(it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaDocumentiProtocollo inputpar) throws java.rmi.RemoteException{
    if (protocolloPortType == null)
      _initProtocolloPortTypeProxy();
    return protocolloPortType.prelevaDocumentiProtocollo(inputpar);
  }
  
  public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo ricercaAssegnazioniInoltri(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAssegnazioniInoltriProtocollo inputpar) throws java.rmi.RemoteException{
    if (protocolloPortType == null)
      _initProtocolloPortTypeProxy();
    return protocolloPortType.ricercaAssegnazioniInoltri(inputpar);
  }
  
  
}