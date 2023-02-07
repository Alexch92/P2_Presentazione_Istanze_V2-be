/**
 * DiogeneService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.sincon.gepred.documentale.diogene.impl;

public interface DiogeneService extends javax.xml.rpc.Service {
    public java.lang.String getDiogeneAddress();

    public it.sincon.gepred.documentale.diogene.impl.Diogene getDiogene() throws javax.xml.rpc.ServiceException;

    public it.sincon.gepred.documentale.diogene.impl.Diogene getDiogene(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
