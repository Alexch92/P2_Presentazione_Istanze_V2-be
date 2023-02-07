/**
 * WssgpLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.puglia.sanita.cup;

public class WssgpLocator extends org.apache.axis.client.Service implements it.puglia.sanita.cup.Wssgp {

    public WssgpLocator() {
    }


    public WssgpLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WssgpLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wssgp
    private java.lang.String wssgp_address = "http://localhost:8080/wssgp/wssgp";

    public java.lang.String getwssgpAddress() {
        return wssgp_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wssgpWSDDServiceName = "wssgp";

    public java.lang.String getwssgpWSDDServiceName() {
        return wssgpWSDDServiceName;
    }

    public void setwssgpWSDDServiceName(java.lang.String name) {
        wssgpWSDDServiceName = name;
    }

    public it.puglia.sanita.cup.Servizi getwssgp() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wssgp_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwssgp(endpoint);
    }

    public it.puglia.sanita.cup.Servizi getwssgp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.puglia.sanita.cup.ServiziBindingStub _stub = new it.puglia.sanita.cup.ServiziBindingStub(portAddress, this);
            _stub.setPortName(getwssgpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwssgpEndpointAddress(java.lang.String address) {
        wssgp_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.puglia.sanita.cup.Servizi.class.isAssignableFrom(serviceEndpointInterface)) {
                it.puglia.sanita.cup.ServiziBindingStub _stub = new it.puglia.sanita.cup.ServiziBindingStub(new java.net.URL(wssgp_address), this);
                _stub.setPortName(getwssgpWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("wssgp".equals(inputPortName)) {
            return getwssgp();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "wssgp");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://cup.sanita.puglia.it/", "wssgp"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wssgp".equals(portName)) {
            setwssgpEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
