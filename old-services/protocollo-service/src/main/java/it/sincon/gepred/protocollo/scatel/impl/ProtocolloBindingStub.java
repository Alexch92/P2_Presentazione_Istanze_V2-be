/**
 * ProtocolloBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.protocollo.scatel.impl;

import java.util.Hashtable;

import org.apache.axis.transport.http.HTTPConstants;

public class ProtocolloBindingStub extends org.apache.axis.client.Stub implements it.sincon.gepred.protocollo.scatel.impl.ProtocolloPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EseguiProtocollazione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ParametriEseguiProtocollo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriEseguiProtocollo"), it.sincon.gepred.protocollo.scatel.bean.ParametriEseguiProtocollo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaProtocollo"));
        oper.setReturnClass(it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RispostaProtocollo"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RicercaAOO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ParametriRicercaAOO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRicercaAOO"), it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAOO.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaAOO"));
        oper.setReturnClass(it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RispostaRicercaAOO"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RicercaProtocolli");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ParametriRicercaProtocollo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRicercaProtocollo"), it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaProtocollo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaProtocollo"));
        oper.setReturnClass(it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RispostaRicercaProtocollo"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PrelevaDettaglioProtocollo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ParametriRichiestaProtocollo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRichiestaProtocollo"), it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaProtocollo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaDettaglioProtocollo"));
        oper.setReturnClass(it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RispostaDettaglioProtocollo"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PrelevaDocumentiProtocollo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ParametriRichiestaDocumentiProtocollo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRichiestaDocumentiProtocollo"), it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaDocumentiProtocollo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaPrelievoDocumentiProtocollati"));
        oper.setReturnClass(it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RispostaPrelievoDocumentiProtocollati"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RicercaAssegnazioniInoltri");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "ParametriRicercaAssegnazioniInoltriProtocollo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRicercaAssegnazioniInoltriProtocollo"), it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAssegnazioniInoltriProtocollo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaAssegnazioniInoltriProtocollo"));
        oper.setReturnClass(it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", "RispostaRicercaAssegnazioniInoltriProtocollo"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

    }

    public ProtocolloBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ProtocolloBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ProtocolloBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">>Documento>tipoRiferimento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.DocumentoTipoRiferimento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">>IndirizzoTelematico>tipo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematicoTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">>OraRegistrazione>tempo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.OraRegistrazioneTempo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">>UnitaOrganizzativa>tipo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.UnitaOrganizzativaTipo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Allegati");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Allegati.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Amministrazione");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Amministrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">AnagraficaAOO");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.AnagraficaAOO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">AOO");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.AOO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Classifica");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Classifica.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Comune");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Comune.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">CredenzialiUtente");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.CredenzialiUtente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Descrizione");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Descrizione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Destinatario");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Destinatario.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Destinazione");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Destinazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Documento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Documento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Esito");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Esito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Fascicolo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Fascicolo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Fax");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Fax.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Identificatore");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Identificatore.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Impronta");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Impronta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ImprontaMIME");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ImprontaMIME.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoPostale");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.IndirizzoPostale.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">IndirizzoTelematico");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.IndirizzoTelematico.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Intestazione");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Intestazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Livello");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Livello.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">MatchingAssegnazioniInoltri");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.MatchingAssegnazioniInoltri.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">MatchingDocumenti");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.MatchingDocumenti.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">MatchingProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.MatchingProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Messaggio");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Messaggio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">MessaggioRicevuto");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.MessaggioRicevuto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Mittente");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Mittente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">OraRegistrazione");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.OraRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Origine");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Origine.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriEseguiProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ParametriEseguiProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRicercaAOO");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAOO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRicercaAssegnazioniInoltriProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAssegnazioniInoltriProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRicercaProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRichiestaDocumentiProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaDocumentiProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ParametriRichiestaProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">PerConoscenza");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.PerConoscenza.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Persona");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Persona.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">PrimaRegistrazione");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.PrimaRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Procedimento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Procedimento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ProtocolloEmergenza");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ProtocolloEmergenza.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">ProtocolloMittente");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.ProtocolloMittente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Responsabile");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Responsabile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Riferimenti");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Riferimenti.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaDettaglioProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaPrelievoDocumentiProtocollati");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaAOO");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaAssegnazioniInoltriProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">RispostaRicercaProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Ruolo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Ruolo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Segnatura");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Segnatura.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">SegnaturaProtocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.SegnaturaProtocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Telefono");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Telefono.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">Toponimo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.Toponimo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://protocolloWS.egov.rupar.puglia.it/protocollo", ">UnitaOrganizzativa");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.protocollo.scatel.bean.UnitaOrganizzativa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo eseguiProtocollazione(
    		it.sincon.gepred.protocollo.scatel.bean.ParametriEseguiProtocollo arg1,
    		String authorization) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("EseguiProtocollazione");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "EseguiProtocollazione"));
        
        // add authorization bearer to the request header...
        Hashtable<String, String> headers = (Hashtable<String, String>)_call.getProperty(HTTPConstants.REQUEST_HEADERS);
        if (headers == null) {
        	headers = new Hashtable<String, String>();
        }
        headers.put(HTTPConstants.HEADER_AUTHORIZATION, authorization);
        _call.setProperty(HTTPConstants.REQUEST_HEADERS, headers);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.protocollo.scatel.bean.RispostaProtocollo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO ricercaAOO(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAOO arg1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RicercaAOO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAOO.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo ricercaProtocolli(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaProtocollo arg1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RicercaProtocolli"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaProtocollo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo prelevaDettaglioProtocollo(it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaProtocollo inputpar) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PrelevaDettaglioProtocollo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inputpar});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.protocollo.scatel.bean.RispostaDettaglioProtocollo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati prelevaDocumentiProtocollo(it.sincon.gepred.protocollo.scatel.bean.ParametriRichiestaDocumentiProtocollo inputpar) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PrelevaDocumentiProtocollo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inputpar});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.protocollo.scatel.bean.RispostaPrelievoDocumentiProtocollati.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo ricercaAssegnazioniInoltri(it.sincon.gepred.protocollo.scatel.bean.ParametriRicercaAssegnazioniInoltriProtocollo inputpar) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RicercaAssegnazioniInoltri"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {inputpar});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.protocollo.scatel.bean.RispostaRicercaAssegnazioniInoltriProtocollo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
