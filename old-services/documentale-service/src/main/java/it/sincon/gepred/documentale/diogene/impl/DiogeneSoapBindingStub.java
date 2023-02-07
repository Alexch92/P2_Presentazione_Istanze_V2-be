/**
 * DiogeneSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.impl;

public class DiogeneSoapBindingStub extends org.apache.axis.client.Stub implements it.sincon.gepred.documentale.diogene.impl.Diogene {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("download");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "idDocumento"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "idVersione"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Download"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_Download.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "downloadReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nuovaCartella");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "cartella"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovaCartella"), it.sincon.gepred.documentale.diogene.bean.WS_NuovaCartella.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovaCartellaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nuovoFascicolo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "fascicolo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovoFascicolo"), it.sincon.gepred.documentale.diogene.bean.WS_NuovoFascicolo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovoFascicoloReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nuovaVersione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "idDocumento"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "tipoContenitore"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nomeFile"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "cotenutoFile"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovaVersioneReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nuovoDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "tipoContenitore"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ws_documento"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovoDocumento"), it.sincon.gepred.documentale.diogene.bean.WS_NuovoDocumento.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovoDocumentoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("mostraContenuto");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "idAggregato"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_MostraContenuto"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "mostraContenutoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("leggiDettaglio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "idOggetto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "tipoOggetto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "tipoContenitore"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "leggiDettaglioReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ricerca");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "maxDoc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ricercaType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_RicercaType"), it.sincon.gepred.documentale.diogene.bean.WS_RicercaType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_RicercaResult"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ricercaReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("spostaDocumento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "idDocumento"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "tipoContenitore"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "idAggregatoDestinazione"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio"));
        oper.setReturnClass(it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "spostaDocumentoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

    }

    public DiogeneSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public DiogeneSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public DiogeneSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ArrayOf_tns1_Attributo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.Attributo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "Attributo");
            qName2 = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ArrayOf_tns1_Permesso");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.Permesso[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "Permesso");
            qName2 = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ArrayOf_tns1_WS_Aggregato");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Aggregato[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Aggregato");
            qName2 = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ArrayOf_tns1_WS_InfoDocumento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_InfoDocumento");
            qName2 = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ArrayOf_xsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "Attributo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.Attributo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "Permesso");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.Permesso.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Aggregato");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Aggregato.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Cartella");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Cartella.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Dettaglio");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Documento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Documento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Download");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Download.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FascicoloReale");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_FascicoloReale.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FascicoloTemporaneo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_FascicoloTemporaneo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_FileType");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_FileType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_InfoDocumento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_InfoDocumento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_MostraContenuto");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NumerazioneFascicolo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_NumerazioneFascicolo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovaCartella");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_NuovaCartella.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovoDocumento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_NuovoDocumento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_NuovoFascicolo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_NuovoFascicolo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Protocollo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Protocollo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Repertorio");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Repertorio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_Result");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_RicercaResult");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_RicercaType");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_RicercaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_SoggettoFascicolo");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_SoggettoFascicolo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://model.diogenews.sistemapuglia.innovapuglia.it", "WS_TipologiaDocumento");
            cachedSerQNames.add(qName);
            cls = it.sincon.gepred.documentale.diogene.bean.WS_TipologiaDocumento.class;
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

    public it.sincon.gepred.documentale.diogene.bean.WS_Download download(java.lang.String username, java.lang.String idDocumento, java.lang.String idVersione) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "download"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, idDocumento, idVersione});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Download) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Download) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_Download.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovaCartella(java.lang.String username, it.sincon.gepred.documentale.diogene.bean.WS_NuovaCartella cartella) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovaCartella"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, cartella});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovoFascicolo(java.lang.String username, it.sincon.gepred.documentale.diogene.bean.WS_NuovoFascicolo fascicolo) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovoFascicolo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, fascicolo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovaVersione(java.lang.String username, java.lang.String idDocumento, java.lang.String tipoContenitore, java.lang.String nomeFile, byte[] cotenutoFile) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovaVersione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, idDocumento, tipoContenitore, nomeFile, cotenutoFile});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio nuovoDocumento(java.lang.String username, java.lang.String tipoContenitore, it.sincon.gepred.documentale.diogene.bean.WS_NuovoDocumento ws_documento) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "nuovoDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, tipoContenitore, ws_documento});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto mostraContenuto(java.lang.String username, java.lang.String idAggregato) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "mostraContenuto"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, idAggregato});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_MostraContenuto.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio leggiDettaglio(java.lang.String username, java.lang.String idOggetto, java.lang.String tipoOggetto, java.lang.String tipoContenitore) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "leggiDettaglio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, idOggetto, tipoOggetto, tipoContenitore});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult ricerca(java.lang.String username, int maxDoc, it.sincon.gepred.documentale.diogene.bean.WS_RicercaType ricercaType) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "ricerca"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, new java.lang.Integer(maxDoc), ricercaType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_RicercaResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio spostaDocumento(java.lang.String username, java.lang.String idDocumento, java.lang.String tipoContenitore, java.lang.String idAggregatoDestinazione) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://diogenews.sistemapuglia.innovapuglia.it", "spostaDocumento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {username, idDocumento, tipoContenitore, idAggregatoDestinazione});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio) org.apache.axis.utils.JavaUtils.convert(_resp, it.sincon.gepred.documentale.diogene.bean.WS_Dettaglio.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
