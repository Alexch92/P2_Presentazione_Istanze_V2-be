
package it.sincon.gepred.protocollo.adoc.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.sincon.gepred.protocollo.adoc.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddAllegatura_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "addAllegatura");
    private final static QName _RichiestaProtocolloProvvisorio_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "richiestaProtocolloProvvisorio");
    private final static QName _GetDestinatariProtocollo_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "getDestinatariProtocollo");
    private final static QName _RichiestaProtocolloProvvisorioResponse_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "richiestaProtocolloProvvisorioResponse");
    private final static QName _GetProtocolloResponse_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "getProtocolloResponse");
    private final static QName _GetMittenteProtocollo_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "getMittenteProtocollo");
    private final static QName _GetMittenteProtocolloResponse_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "getMittenteProtocolloResponse");
    private final static QName _RichiestaProtocollo_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "richiestaProtocollo");
    private final static QName _RichiestaProtocolloResponse_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "richiestaProtocolloResponse");
    private final static QName _CompletamentoProtocolloProvvisorioResponse_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "completamentoProtocolloProvvisorioResponse");
    private final static QName _GetDestinatariProtocolloResponse_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "getDestinatariProtocolloResponse");
    private final static QName _CompletamentoProtocolloProvvisorio_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "completamentoProtocolloProvvisorio");
    private final static QName _AddAllegaturaResponse_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "addAllegaturaResponse");
    private final static QName _GetProtocollo_QNAME = new QName("http://server.ws.protocollo.linksmt.it/", "getProtocollo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.sincon.gepred.protocollo.adoc.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest }
     * 
     */
    public CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest createCompletamentoProtocolloProvvisorioProtocolloDaCompletareRequest() {
        return new CompletamentoProtocolloProvvisorio.ProtocolloDaCompletareRequest();
    }

    /**
     * Create an instance of {@link RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest }
     * 
     */
    public RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest createRichiestaProtocolloProvvisorioProtocolloProvvisorioRequest() {
        return new RichiestaProtocolloProvvisorio.ProtocolloProvvisorioRequest();
    }

    /**
     * Create an instance of {@link GetMittenteProtocollo }
     * 
     */
    public GetMittenteProtocollo createGetMittenteProtocollo() {
        return new GetMittenteProtocollo();
    }

    /**
     * Create an instance of {@link RichiestaProtocolloResponse }
     * 
     */
    public RichiestaProtocolloResponse createRichiestaProtocolloResponse() {
        return new RichiestaProtocolloResponse();
    }

    /**
     * Create an instance of {@link GetProtocolloResponse }
     * 
     */
    public GetProtocolloResponse createGetProtocolloResponse() {
        return new GetProtocolloResponse();
    }

    /**
     * Create an instance of {@link GetDestinatariProtocolloResponse.Return }
     * 
     */
    public GetDestinatariProtocolloResponse.Return createGetDestinatariProtocolloResponseReturn() {
        return new GetDestinatariProtocolloResponse.Return();
    }

    /**
     * Create an instance of {@link GetMittenteProtocolloResponse.Return }
     * 
     */
    public GetMittenteProtocolloResponse.Return createGetMittenteProtocolloResponseReturn() {
        return new GetMittenteProtocolloResponse.Return();
    }

    /**
     * Create an instance of {@link CompletamentoProtocolloProvvisorioResponse.Return }
     * 
     */
    public CompletamentoProtocolloProvvisorioResponse.Return createCompletamentoProtocolloProvvisorioResponseReturn() {
        return new CompletamentoProtocolloProvvisorioResponse.Return();
    }

    /**
     * Create an instance of {@link RichiestaProtocolloProvvisorioResponse.Return }
     * 
     */
    public RichiestaProtocolloProvvisorioResponse.Return createRichiestaProtocolloProvvisorioResponseReturn() {
        return new RichiestaProtocolloProvvisorioResponse.Return();
    }

    /**
     * Create an instance of {@link AddAllegaturaResponse.Return }
     * 
     */
    public AddAllegaturaResponse.Return createAddAllegaturaResponseReturn() {
        return new AddAllegaturaResponse.Return();
    }

    /**
     * Create an instance of {@link GetMittenteProtocolloResponse }
     * 
     */
    public GetMittenteProtocolloResponse createGetMittenteProtocolloResponse() {
        return new GetMittenteProtocolloResponse();
    }

    /**
     * Create an instance of {@link GetProtocollo }
     * 
     */
    public GetProtocollo createGetProtocollo() {
        return new GetProtocollo();
    }

    /**
     * Create an instance of {@link GetProtocollo.ProtocolloInformazioniRequest }
     * 
     */
    public GetProtocollo.ProtocolloInformazioniRequest createGetProtocolloProtocolloInformazioniRequest() {
        return new GetProtocollo.ProtocolloInformazioniRequest();
    }

    /**
     * Create an instance of {@link GetDestinatariProtocollo }
     * 
     */
    public GetDestinatariProtocollo createGetDestinatariProtocollo() {
        return new GetDestinatariProtocollo();
    }

    /**
     * Create an instance of {@link AddAllegatura.AllegaturaRequest }
     * 
     */
    public AddAllegatura.AllegaturaRequest createAddAllegaturaAllegaturaRequest() {
        return new AddAllegatura.AllegaturaRequest();
    }

    /**
     * Create an instance of {@link GetProtocolloResponse.Return }
     * 
     */
    public GetProtocolloResponse.Return createGetProtocolloResponseReturn() {
        return new GetProtocolloResponse.Return();
    }

    /**
     * Create an instance of {@link GetDestinatariProtocolloResponse }
     * 
     */
    public GetDestinatariProtocolloResponse createGetDestinatariProtocolloResponse() {
        return new GetDestinatariProtocolloResponse();
    }

    /**
     * Create an instance of {@link RichiestaProtocollo }
     * 
     */
    public RichiestaProtocollo createRichiestaProtocollo() {
        return new RichiestaProtocollo();
    }

    /**
     * Create an instance of {@link RichiestaProtocolloProvvisorio }
     * 
     */
    public RichiestaProtocolloProvvisorio createRichiestaProtocolloProvvisorio() {
        return new RichiestaProtocolloProvvisorio();
    }

    /**
     * Create an instance of {@link GetMittenteProtocollo.MittenteProtocolloRequest }
     * 
     */
    public GetMittenteProtocollo.MittenteProtocolloRequest createGetMittenteProtocolloMittenteProtocolloRequest() {
        return new GetMittenteProtocollo.MittenteProtocolloRequest();
    }

    /**
     * Create an instance of {@link GetDestinatariProtocollo.DestinatarioProtocolloRequest }
     * 
     */
    public GetDestinatariProtocollo.DestinatarioProtocolloRequest createGetDestinatariProtocolloDestinatarioProtocolloRequest() {
        return new GetDestinatariProtocollo.DestinatarioProtocolloRequest();
    }

    /**
     * Create an instance of {@link CompletamentoProtocolloProvvisorioResponse }
     * 
     */
    public CompletamentoProtocolloProvvisorioResponse createCompletamentoProtocolloProvvisorioResponse() {
        return new CompletamentoProtocolloProvvisorioResponse();
    }

    /**
     * Create an instance of {@link AddAllegaturaResponse }
     * 
     */
    public AddAllegaturaResponse createAddAllegaturaResponse() {
        return new AddAllegaturaResponse();
    }

    /**
     * Create an instance of {@link AddAllegatura }
     * 
     */
    public AddAllegatura createAddAllegatura() {
        return new AddAllegatura();
    }

    /**
     * Create an instance of {@link CompletamentoProtocolloProvvisorio }
     * 
     */
    public CompletamentoProtocolloProvvisorio createCompletamentoProtocolloProvvisorio() {
        return new CompletamentoProtocolloProvvisorio();
    }

    /**
     * Create an instance of {@link RichiestaProtocolloProvvisorioResponse }
     * 
     */
    public RichiestaProtocolloProvvisorioResponse createRichiestaProtocolloProvvisorioResponse() {
        return new RichiestaProtocolloProvvisorioResponse();
    }

    /**
     * Create an instance of {@link RichiestaProtocollo.ProtocolloRequest }
     * 
     */
    public RichiestaProtocollo.ProtocolloRequest createRichiestaProtocolloProtocolloRequest() {
        return new RichiestaProtocollo.ProtocolloRequest();
    }

    /**
     * Create an instance of {@link RichiestaProtocolloResponse.Return }
     * 
     */
    public RichiestaProtocolloResponse.Return createRichiestaProtocolloResponseReturn() {
        return new RichiestaProtocolloResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAllegatura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "addAllegatura")
    public JAXBElement<AddAllegatura> createAddAllegatura(AddAllegatura value) {
        return new JAXBElement<AddAllegatura>(_AddAllegatura_QNAME, AddAllegatura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RichiestaProtocolloProvvisorio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "richiestaProtocolloProvvisorio")
    public JAXBElement<RichiestaProtocolloProvvisorio> createRichiestaProtocolloProvvisorio(RichiestaProtocolloProvvisorio value) {
        return new JAXBElement<RichiestaProtocolloProvvisorio>(_RichiestaProtocolloProvvisorio_QNAME, RichiestaProtocolloProvvisorio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDestinatariProtocollo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "getDestinatariProtocollo")
    public JAXBElement<GetDestinatariProtocollo> createGetDestinatariProtocollo(GetDestinatariProtocollo value) {
        return new JAXBElement<GetDestinatariProtocollo>(_GetDestinatariProtocollo_QNAME, GetDestinatariProtocollo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RichiestaProtocolloProvvisorioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "richiestaProtocolloProvvisorioResponse")
    public JAXBElement<RichiestaProtocolloProvvisorioResponse> createRichiestaProtocolloProvvisorioResponse(RichiestaProtocolloProvvisorioResponse value) {
        return new JAXBElement<RichiestaProtocolloProvvisorioResponse>(_RichiestaProtocolloProvvisorioResponse_QNAME, RichiestaProtocolloProvvisorioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProtocolloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "getProtocolloResponse")
    public JAXBElement<GetProtocolloResponse> createGetProtocolloResponse(GetProtocolloResponse value) {
        return new JAXBElement<GetProtocolloResponse>(_GetProtocolloResponse_QNAME, GetProtocolloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMittenteProtocollo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "getMittenteProtocollo")
    public JAXBElement<GetMittenteProtocollo> createGetMittenteProtocollo(GetMittenteProtocollo value) {
        return new JAXBElement<GetMittenteProtocollo>(_GetMittenteProtocollo_QNAME, GetMittenteProtocollo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMittenteProtocolloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "getMittenteProtocolloResponse")
    public JAXBElement<GetMittenteProtocolloResponse> createGetMittenteProtocolloResponse(GetMittenteProtocolloResponse value) {
        return new JAXBElement<GetMittenteProtocolloResponse>(_GetMittenteProtocolloResponse_QNAME, GetMittenteProtocolloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RichiestaProtocollo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "richiestaProtocollo")
    public JAXBElement<RichiestaProtocollo> createRichiestaProtocollo(RichiestaProtocollo value) {
        return new JAXBElement<RichiestaProtocollo>(_RichiestaProtocollo_QNAME, RichiestaProtocollo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RichiestaProtocolloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "richiestaProtocolloResponse")
    public JAXBElement<RichiestaProtocolloResponse> createRichiestaProtocolloResponse(RichiestaProtocolloResponse value) {
        return new JAXBElement<RichiestaProtocolloResponse>(_RichiestaProtocolloResponse_QNAME, RichiestaProtocolloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompletamentoProtocolloProvvisorioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "completamentoProtocolloProvvisorioResponse")
    public JAXBElement<CompletamentoProtocolloProvvisorioResponse> createCompletamentoProtocolloProvvisorioResponse(CompletamentoProtocolloProvvisorioResponse value) {
        return new JAXBElement<CompletamentoProtocolloProvvisorioResponse>(_CompletamentoProtocolloProvvisorioResponse_QNAME, CompletamentoProtocolloProvvisorioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDestinatariProtocolloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "getDestinatariProtocolloResponse")
    public JAXBElement<GetDestinatariProtocolloResponse> createGetDestinatariProtocolloResponse(GetDestinatariProtocolloResponse value) {
        return new JAXBElement<GetDestinatariProtocolloResponse>(_GetDestinatariProtocolloResponse_QNAME, GetDestinatariProtocolloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompletamentoProtocolloProvvisorio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "completamentoProtocolloProvvisorio")
    public JAXBElement<CompletamentoProtocolloProvvisorio> createCompletamentoProtocolloProvvisorio(CompletamentoProtocolloProvvisorio value) {
        return new JAXBElement<CompletamentoProtocolloProvvisorio>(_CompletamentoProtocolloProvvisorio_QNAME, CompletamentoProtocolloProvvisorio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAllegaturaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "addAllegaturaResponse")
    public JAXBElement<AddAllegaturaResponse> createAddAllegaturaResponse(AddAllegaturaResponse value) {
        return new JAXBElement<AddAllegaturaResponse>(_AddAllegaturaResponse_QNAME, AddAllegaturaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProtocollo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.protocollo.linksmt.it/", name = "getProtocollo")
    public JAXBElement<GetProtocollo> createGetProtocollo(GetProtocollo value) {
        return new JAXBElement<GetProtocollo>(_GetProtocollo_QNAME, GetProtocollo.class, null, value);
    }

}
