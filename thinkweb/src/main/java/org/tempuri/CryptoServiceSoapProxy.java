package org.tempuri;

public class CryptoServiceSoapProxy implements org.tempuri.CryptoServiceSoap {
  private String _endpoint = null;
  private org.tempuri.CryptoServiceSoap cryptoServiceSoap = null;
  
  public CryptoServiceSoapProxy() {
    _initCryptoServiceSoapProxy();
  }
  
  public CryptoServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCryptoServiceSoapProxy();
  }
  
  private void _initCryptoServiceSoapProxy() {
    try {
      cryptoServiceSoap = (new org.tempuri.CryptoServiceLocator()).getCryptoServiceSoap();
      if (cryptoServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cryptoServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cryptoServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cryptoServiceSoap != null)
      ((javax.xml.rpc.Stub)cryptoServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.CryptoServiceSoap getCryptoServiceSoap() {
    if (cryptoServiceSoap == null)
      _initCryptoServiceSoapProxy();
    return cryptoServiceSoap;
  }
  
  public org.tempuri.Thresoldoutputlist thresholdOptionList(java.lang.String DSN, java.lang.String userName, java.lang.String password, int customer_id, int oc_id, int order_code_id, java.lang.String currency, java.math.BigDecimal item_amount, java.math.BigDecimal total_amount_paid_on_item, java.math.BigDecimal total_amount_paid_this_payment, java.math.BigDecimal amount_to_apply, int billing_type, int order_item_type, int subscrip_start_type) throws java.rmi.RemoteException{
    if (cryptoServiceSoap == null)
      _initCryptoServiceSoapProxy();
    return cryptoServiceSoap.thresholdOptionList(DSN, userName, password, customer_id, oc_id, order_code_id, currency, item_amount, total_amount_paid_on_item, total_amount_paid_this_payment, amount_to_apply, billing_type, order_item_type, subscrip_start_type);
  }
  
  public java.lang.String encryption(java.lang.String encryptstring) throws java.rmi.RemoteException{
    if (cryptoServiceSoap == null)
      _initCryptoServiceSoapProxy();
    return cryptoServiceSoap.encryption(encryptstring);
  }
  
  public java.lang.String decryption(java.lang.String decryptstring) throws java.rmi.RemoteException{
    if (cryptoServiceSoap == null)
      _initCryptoServiceSoapProxy();
    return cryptoServiceSoap.decryption(decryptstring);
  }
  
  
}