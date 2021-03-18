/**
 * Deposit_payment_information_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Deposit_payment_information_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private java.lang.String currency;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean verbose_response;  // attribute

    private Think.XmlWebServices.ZZBoolean cleared_payments_only;  // attribute

    private Think.XmlWebServices.ZZBoolean show_available_amounts_only;  // attribute

    private java.lang.String filter;  // attribute

    public Deposit_payment_information_request() {
    }

    public Deposit_payment_information_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           java.lang.String currency,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean verbose_response,
           Think.XmlWebServices.ZZBoolean cleared_payments_only,
           Think.XmlWebServices.ZZBoolean show_available_amounts_only,
           java.lang.String filter) {
           this.user_login_data = user_login_data;
           this.customer_identifier = customer_identifier;
           this.currency = currency;
           this.dsn = dsn;
           this.verbose_response = verbose_response;
           this.cleared_payments_only = cleared_payments_only;
           this.show_available_amounts_only = show_available_amounts_only;
           this.filter = filter;
    }


    /**
     * Gets the user_login_data value for this Deposit_payment_information_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Deposit_payment_information_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_identifier value for this Deposit_payment_information_request.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Deposit_payment_information_request.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the currency value for this Deposit_payment_information_request.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Deposit_payment_information_request.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the dsn value for this Deposit_payment_information_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Deposit_payment_information_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the verbose_response value for this Deposit_payment_information_request.
     * 
     * @return verbose_response
     */
    public Think.XmlWebServices.ZZBoolean getVerbose_response() {
        return verbose_response;
    }


    /**
     * Sets the verbose_response value for this Deposit_payment_information_request.
     * 
     * @param verbose_response
     */
    public void setVerbose_response(Think.XmlWebServices.ZZBoolean verbose_response) {
        this.verbose_response = verbose_response;
    }


    /**
     * Gets the cleared_payments_only value for this Deposit_payment_information_request.
     * 
     * @return cleared_payments_only
     */
    public Think.XmlWebServices.ZZBoolean getCleared_payments_only() {
        return cleared_payments_only;
    }


    /**
     * Sets the cleared_payments_only value for this Deposit_payment_information_request.
     * 
     * @param cleared_payments_only
     */
    public void setCleared_payments_only(Think.XmlWebServices.ZZBoolean cleared_payments_only) {
        this.cleared_payments_only = cleared_payments_only;
    }


    /**
     * Gets the show_available_amounts_only value for this Deposit_payment_information_request.
     * 
     * @return show_available_amounts_only
     */
    public Think.XmlWebServices.ZZBoolean getShow_available_amounts_only() {
        return show_available_amounts_only;
    }


    /**
     * Sets the show_available_amounts_only value for this Deposit_payment_information_request.
     * 
     * @param show_available_amounts_only
     */
    public void setShow_available_amounts_only(Think.XmlWebServices.ZZBoolean show_available_amounts_only) {
        this.show_available_amounts_only = show_available_amounts_only;
    }


    /**
     * Gets the filter value for this Deposit_payment_information_request.
     * 
     * @return filter
     */
    public java.lang.String getFilter() {
        return filter;
    }


    /**
     * Sets the filter value for this Deposit_payment_information_request.
     * 
     * @param filter
     */
    public void setFilter(java.lang.String filter) {
        this.filter = filter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Deposit_payment_information_request)) return false;
        Deposit_payment_information_request other = (Deposit_payment_information_request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_login_data==null && other.getUser_login_data()==null) || 
             (this.user_login_data!=null &&
              this.user_login_data.equals(other.getUser_login_data()))) &&
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.verbose_response==null && other.getVerbose_response()==null) || 
             (this.verbose_response!=null &&
              this.verbose_response.equals(other.getVerbose_response()))) &&
            ((this.cleared_payments_only==null && other.getCleared_payments_only()==null) || 
             (this.cleared_payments_only!=null &&
              this.cleared_payments_only.equals(other.getCleared_payments_only()))) &&
            ((this.show_available_amounts_only==null && other.getShow_available_amounts_only()==null) || 
             (this.show_available_amounts_only!=null &&
              this.show_available_amounts_only.equals(other.getShow_available_amounts_only()))) &&
            ((this.filter==null && other.getFilter()==null) || 
             (this.filter!=null &&
              this.filter.equals(other.getFilter())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getUser_login_data() != null) {
            _hashCode += getUser_login_data().hashCode();
        }
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getVerbose_response() != null) {
            _hashCode += getVerbose_response().hashCode();
        }
        if (getCleared_payments_only() != null) {
            _hashCode += getCleared_payments_only().hashCode();
        }
        if (getShow_available_amounts_only() != null) {
            _hashCode += getShow_available_amounts_only().hashCode();
        }
        if (getFilter() != null) {
            _hashCode += getFilter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Deposit_payment_information_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">deposit_payment_information_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("verbose_response");
        attrField.setXmlName(new javax.xml.namespace.QName("", "verbose_response"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cleared_payments_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cleared_payments_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("show_available_amounts_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "show_available_amounts_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("filter");
        attrField.setXmlName(new javax.xml.namespace.QName("", "filter"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
