package it.puglia.sanita.cup;

public class ServiziProxy implements it.puglia.sanita.cup.Servizi {
  private String _endpoint = null;
  private it.puglia.sanita.cup.Servizi servizi = null;
  
  public ServiziProxy() {
    _initServiziProxy();
  }
  
  public ServiziProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiziProxy();
  }
  
  private void _initServiziProxy() {
    try {
      servizi = (new it.puglia.sanita.cup.WssgpLocator()).getwssgp();
      if (servizi != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servizi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servizi)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servizi != null)
      ((javax.xml.rpc.Stub)servizi)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public it.puglia.sanita.cup.Servizi getServizi() {
    if (servizi == null)
      _initServiziProxy();
    return servizi;
  }
  
  public it.puglia.sanita.cup.RispostaLogin getLogin(it.puglia.sanita.cup.RichiestaLogin richiestaLogin) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.getLogin(richiestaLogin);
  }
  
  public it.puglia.sanita.cup.RispostaPaziente getPaziente(it.puglia.sanita.cup.RichiestaPaziente richiestaPaziente) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.getPaziente(richiestaPaziente);
  }
  
  public it.puglia.sanita.cup.RispostaSetPaziente setPaziente(it.puglia.sanita.cup.RichiestaPaziente richiestaSetPaziente) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.setPaziente(richiestaSetPaziente);
  }
  
  public it.puglia.sanita.cup.RispostaListaDisponibilita getListaDisponibilita(it.puglia.sanita.cup.RichiestaListaDisponibilita richiestaListaDisponibilita) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.getListaDisponibilita(richiestaListaDisponibilita);
  }
  
  public it.puglia.sanita.cup.RispostaPrenota setPrenota(it.puglia.sanita.cup.RichiestaPrenota richiestaPrenota) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.setPrenota(richiestaPrenota);
  }
  
  public it.puglia.sanita.cup.RispostaPrenota setPrenotaPrimaDisponibilita(it.puglia.sanita.cup.RichiestaListaDisponibilita richiestaListaDisponibilita) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.setPrenotaPrimaDisponibilita(richiestaListaDisponibilita);
  }
  
  public it.puglia.sanita.cup.RispostaPromemoria getPromemoria(it.puglia.sanita.cup.RichiestaPromemoria richiestaPromemoria) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.getPromemoria(richiestaPromemoria);
  }
  
  public it.puglia.sanita.cup.RispostaCancella setCancella(it.puglia.sanita.cup.RichiestaCancella richiestaCancella) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.setCancella(richiestaCancella);
  }
  
  public it.puglia.sanita.cup.RispostaPrescrizioni getPrescrizioni(it.puglia.sanita.cup.RichiestaPrescrizioni richiestaPrescrizioni) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.getPrescrizioni(richiestaPrescrizioni);
  }
  
  public it.puglia.sanita.cup.RispostaRegistrazione setRegistrazione(it.puglia.sanita.cup.RichiestaRegistrazione richiestaRegistrazione) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.setRegistrazione(richiestaRegistrazione);
  }
  
  public it.puglia.sanita.cup.RispostaCambiaStatoPrestazione setCambiaStatoPrestazione(it.puglia.sanita.cup.RichiestaCambiaStatoPrestazione richiestaCambiaStatoPrestazione) throws java.rmi.RemoteException{
    if (servizi == null)
      _initServiziProxy();
    return servizi.setCambiaStatoPrestazione(richiestaCambiaStatoPrestazione);
  }
  
  
}