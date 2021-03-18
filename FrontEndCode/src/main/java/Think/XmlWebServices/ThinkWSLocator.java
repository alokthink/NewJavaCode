/**
 * ThinkWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;
import com.mps.think.util.PropertyUtilityClass;


@SuppressWarnings("serial")
public class ThinkWSLocator extends org.apache.axis.client.Service implements Think.XmlWebServices.ThinkWS 
{
	private java.lang.String ThinkSoap_address = new PropertyUtilityClass().getQuery("ThinkSoap_address");
	
	public ThinkWSLocator() 
	{
    }

    public ThinkWSLocator(org.apache.axis.EngineConfiguration config) 
    {
        super(config);
    }

    public ThinkWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException 
    {
        super(wsdlLoc, sName);
    }

    public java.lang.String getThinkSoapAddress() 
    {
    	if(null!=ThinkSoap_address)
		{
			  if(!"".equals(ThinkSoap_address.trim()))
			  {
				  ThinkSoap_address=ThinkSoap_address.trim();
			  }
	    }
        return ThinkSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ThinkSoapWSDDServiceName = "ThinkSoap";

    public java.lang.String getThinkSoapWSDDServiceName() {
        return ThinkSoapWSDDServiceName;
    }

    public void setThinkSoapWSDDServiceName(java.lang.String name) {
        ThinkSoapWSDDServiceName = name;
    }

    public Think.XmlWebServices.ThinkSoap getThinkSoap() throws javax.xml.rpc.ServiceException 
    {
       java.net.URL endpoint=null;
        try 
        {
        	if(null!=ThinkSoap_address)
			{
			   if(!"".equals(ThinkSoap_address.trim()))
			   {
				  endpoint = new java.net.URL(ThinkSoap_address.trim());
			   }else
			   {
				  endpoint = new java.net.URL(ThinkSoap_address);
			   }
			}
        	else
			{
			   endpoint = new java.net.URL(ThinkSoap_address);
			}
        }
        catch (java.net.MalformedURLException e) 
        {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getThinkSoap(endpoint);
    }

    public Think.XmlWebServices.ThinkSoap getThinkSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Think.XmlWebServices.ThinkSoapStub _stub = new Think.XmlWebServices.ThinkSoapStub(portAddress, this);
            _stub.setPortName(getThinkSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setThinkSoapEndpointAddress(java.lang.String address) {
        ThinkSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException 
    {
        try 
        {
            if (Think.XmlWebServices.ThinkSoap.class.isAssignableFrom(serviceEndpointInterface)) 
            {
            	if(null!=ThinkSoap_address)
    			{
    			   if(!"".equals(ThinkSoap_address.trim()))
    			   {
    				   ThinkSoap_address=ThinkSoap_address.trim();
    			   }
    			}
                Think.XmlWebServices.ThinkSoapStub _stub = new Think.XmlWebServices.ThinkSoapStub(new java.net.URL(ThinkSoap_address), this);
                _stub.setPortName(getThinkSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) 
        {
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
        if ("ThinkSoap".equals(inputPortName)) {
            return getThinkSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ThinkWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ThinkSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ThinkSoap".equals(portName)) {
            setThinkSoapEndpointAddress(address);
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
