/**
 * ServiziBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class ServiziBindingStub extends org.apache.axis.client.Stub implements it.puglia.sanita.cup.Servizi {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[11];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLogin");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaLogin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaLogin"), it.puglia.sanita.cup.RichiestaLogin.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaLogin"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaLogin.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaLogin"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPaziente");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaPaziente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPaziente"), it.puglia.sanita.cup.RichiestaPaziente.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPaziente"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaPaziente.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaPaziente"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setPaziente");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaSetPaziente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPaziente"), it.puglia.sanita.cup.RichiestaPaziente.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaSetPaziente"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaSetPaziente.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaSetPaziente"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getListaDisponibilita");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaListaDisponibilita"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaListaDisponibilita"), it.puglia.sanita.cup.RichiestaListaDisponibilita.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaListaDisponibilita"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaListaDisponibilita.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaListaDisponibilita"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setPrenota");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaPrenota"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPrenota"), it.puglia.sanita.cup.RichiestaPrenota.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPrenota"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaPrenota.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaPrenota"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setPrenotaPrimaDisponibilita");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaListaDisponibilita"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaListaDisponibilita"), it.puglia.sanita.cup.RichiestaListaDisponibilita.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPrenota"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaPrenota.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaPrenota"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPromemoria");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaPromemoria"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPromemoria"), it.puglia.sanita.cup.RichiestaPromemoria.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPromemoria"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaPromemoria.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaPromemoria"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setCancella");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaCancella"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaCancella"), it.puglia.sanita.cup.RichiestaCancella.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaCancella"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaCancella.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaCancella"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPrescrizioni");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaPrescrizioni"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPrescrizioni"), it.puglia.sanita.cup.RichiestaPrescrizioni.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPrescrizioni"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaPrescrizioni.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaPrescrizioni"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setRegistrazione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaRegistrazione"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaRegistrazione"), it.puglia.sanita.cup.RichiestaRegistrazione.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaRegistrazione"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaRegistrazione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaRegistrazione"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setCambiaStatoPrestazione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "richiestaCambiaStatoPrestazione"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaCambiaStatoPrestazione"), it.puglia.sanita.cup.RichiestaCambiaStatoPrestazione.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaCambiaStatoPrestazione"));
        oper.setReturnClass(it.puglia.sanita.cup.RispostaCambiaStatoPrestazione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "rispostaCambiaStatoPrestazione"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

    }

    public ServiziBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ServiziBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ServiziBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Appuntamento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Ente");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Ente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Errore");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Errore.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "ListaAppuntamenti");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Appuntamento[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Appuntamento");
            qName2 = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "appuntamento");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "ListaPrescrizioni");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Prescrizione[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prescrizione");
            qName2 = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "prescrizione");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "ListaPrestazioni");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Prestazione[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prestazione");
            qName2 = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "prestazione");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Operatore");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Operatore.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Paziente");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Paziente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prescrizione");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Prescrizione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Prestazione");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Prestazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaCambiaStatoPrestazione");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaCambiaStatoPrestazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaCancella");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaCancella.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaListaDisponibilita");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaListaDisponibilita.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaLogin");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaLogin.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPaziente");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaPaziente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPrenota");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaPrenota.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPrescrizioni");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaPrescrizioni.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaPromemoria");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaPromemoria.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RichiestaRegistrazione");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RichiestaRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaCambiaStatoPrestazione");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaCambiaStatoPrestazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaCancella");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaCancella.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaListaDisponibilita");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaListaDisponibilita.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaLogin");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaLogin.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPaziente");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaPaziente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPrenota");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaPrenota.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPrescrizioni");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaPrescrizioni.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaPromemoria");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaPromemoria.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaRegistrazione");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "RispostaSetPaziente");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.RispostaSetPaziente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Sede");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Sede.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "TesseraTeam");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.TesseraTeam.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Unita");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Unita.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "Vincolo");
            cachedSerQNames.add(qName);
            cls = it.puglia.sanita.cup.Vincolo.class;
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

    public it.puglia.sanita.cup.RispostaLogin getLogin(it.puglia.sanita.cup.RichiestaLogin richiestaLogin) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "getLogin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaLogin});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaLogin) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaLogin) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaLogin.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaPaziente getPaziente(it.puglia.sanita.cup.RichiestaPaziente richiestaPaziente) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "getPaziente"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaPaziente});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaPaziente) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaPaziente) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaPaziente.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaSetPaziente setPaziente(it.puglia.sanita.cup.RichiestaPaziente richiestaSetPaziente) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "setPaziente"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaSetPaziente});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaSetPaziente) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaSetPaziente) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaSetPaziente.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaListaDisponibilita getListaDisponibilita(it.puglia.sanita.cup.RichiestaListaDisponibilita richiestaListaDisponibilita) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "getListaDisponibilita"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaListaDisponibilita});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaListaDisponibilita) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaListaDisponibilita) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaListaDisponibilita.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaPrenota setPrenota(it.puglia.sanita.cup.RichiestaPrenota richiestaPrenota) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "setPrenota"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaPrenota});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaPrenota) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaPrenota) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaPrenota.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaPrenota setPrenotaPrimaDisponibilita(it.puglia.sanita.cup.RichiestaListaDisponibilita richiestaListaDisponibilita) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "setPrenotaPrimaDisponibilita"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaListaDisponibilita});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaPrenota) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaPrenota) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaPrenota.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaPromemoria getPromemoria(it.puglia.sanita.cup.RichiestaPromemoria richiestaPromemoria) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "getPromemoria"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaPromemoria});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaPromemoria) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaPromemoria) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaPromemoria.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaCancella setCancella(it.puglia.sanita.cup.RichiestaCancella richiestaCancella) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "setCancella"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaCancella});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaCancella) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaCancella) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaCancella.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaPrescrizioni getPrescrizioni(it.puglia.sanita.cup.RichiestaPrescrizioni richiestaPrescrizioni) throws java.rmi.RemoteException {
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
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "getPrescrizioni"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaPrescrizioni});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaPrescrizioni) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaPrescrizioni) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaPrescrizioni.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaRegistrazione setRegistrazione(it.puglia.sanita.cup.RichiestaRegistrazione richiestaRegistrazione) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "setRegistrazione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaRegistrazione});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaRegistrazione) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaRegistrazione) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaRegistrazione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public it.puglia.sanita.cup.RispostaCambiaStatoPrestazione setCambiaStatoPrestazione(it.puglia.sanita.cup.RichiestaCambiaStatoPrestazione richiestaCambiaStatoPrestazione) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "setCambiaStatoPrestazione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {richiestaCambiaStatoPrestazione});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.puglia.sanita.cup.RispostaCambiaStatoPrestazione) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.puglia.sanita.cup.RispostaCambiaStatoPrestazione) org.apache.axis.utils.JavaUtils.convert(_resp, it.puglia.sanita.cup.RispostaCambiaStatoPrestazione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
