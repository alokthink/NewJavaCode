/**
 * ThinkWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public interface ThinkWS extends javax.xml.rpc.Service {

/**
 * THINK Subscription XML Web services.
 */
    public java.lang.String getThinkSoapAddress();

    public Think.XmlWebServices.ThinkSoap getThinkSoap() throws javax.xml.rpc.ServiceException;

    public Think.XmlWebServices.ThinkSoap getThinkSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
