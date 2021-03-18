/**
 * CryptoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class CryptoServiceLocator extends org.apache.axis.client.Service implements org.tempuri.CryptoService {

    public CryptoServiceLocator() {
    }


    public CryptoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CryptoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CryptoServiceSoap
    private java.lang.String CryptoServiceSoap_address = "http://10.33.5.71/ThinkCryptoService/CryptoService.asmx";

    public java.lang.String getCryptoServiceSoapAddress() {
        return CryptoServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CryptoServiceSoapWSDDServiceName = "CryptoServiceSoap";

    public java.lang.String getCryptoServiceSoapWSDDServiceName() {
        return CryptoServiceSoapWSDDServiceName;
    }

    public void setCryptoServiceSoapWSDDServiceName(java.lang.String name) {
        CryptoServiceSoapWSDDServiceName = name;
    }

    public org.tempuri.CryptoServiceSoap getCryptoServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CryptoServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCryptoServiceSoap(endpoint);
    }

    public org.tempuri.CryptoServiceSoap getCryptoServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.CryptoServiceSoapStub _stub = new org.tempuri.CryptoServiceSoapStub(portAddress, this);
            _stub.setPortName(getCryptoServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCryptoServiceSoapEndpointAddress(java.lang.String address) {
        CryptoServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.CryptoServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.CryptoServiceSoapStub _stub = new org.tempuri.CryptoServiceSoapStub(new java.net.URL(CryptoServiceSoap_address), this);
                _stub.setPortName(getCryptoServiceSoapWSDDServiceName());
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
        if ("CryptoServiceSoap".equals(inputPortName)) {
            return getCryptoServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "CryptoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "CryptoServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CryptoServiceSoap".equals(portName)) {
            setCryptoServiceSoapEndpointAddress(address);
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
