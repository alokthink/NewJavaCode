/**
 * Price_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Price_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Price_list_data[] price_list_data;

    private java.lang.String dsn;  // attribute

    private java.lang.String language_code;  // attribute

    private Think.XmlWebServices.ZZBoolean internet_only;  // attribute

    private Think.XmlWebServices.ZZBoolean ignore_override_price;  // attribute

    private Think.XmlWebServices.ZZBoolean ignore_inactive_source;  // attribute

    public Price_list_request() {
    }

    public Price_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Price_list_data[] price_list_data,
           java.lang.String dsn,
           java.lang.String language_code,
           Think.XmlWebServices.ZZBoolean internet_only,
           Think.XmlWebServices.ZZBoolean ignore_override_price,
           Think.XmlWebServices.ZZBoolean ignore_inactive_source) {
           this.user_login_data = user_login_data;
           this.price_list_data = price_list_data;
           this.dsn = dsn;
           this.language_code = language_code;
           this.internet_only = internet_only;
           this.ignore_override_price = ignore_override_price;
           this.ignore_inactive_source = ignore_inactive_source;
    }


    /**
     * Gets the user_login_data value for this Price_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Price_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the price_list_data value for this Price_list_request.
     * 
     * @return price_list_data
     */
    public Think.XmlWebServices.Price_list_data[] getPrice_list_data() {
        return price_list_data;
    }


    /**
     * Sets the price_list_data value for this Price_list_request.
     * 
     * @param price_list_data
     */
    public void setPrice_list_data(Think.XmlWebServices.Price_list_data[] price_list_data) {
        this.price_list_data = price_list_data;
    }

    public Think.XmlWebServices.Price_list_data getPrice_list_data(int i) {
        return this.price_list_data[i];
    }

    public void setPrice_list_data(int i, Think.XmlWebServices.Price_list_data _value) {
        this.price_list_data[i] = _value;
    }


    /**
     * Gets the dsn value for this Price_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Price_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the language_code value for this Price_list_request.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Price_list_request.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }


    /**
     * Gets the internet_only value for this Price_list_request.
     * 
     * @return internet_only
     */
    public Think.XmlWebServices.ZZBoolean getInternet_only() {
        return internet_only;
    }


    /**
     * Sets the internet_only value for this Price_list_request.
     * 
     * @param internet_only
     */
    public void setInternet_only(Think.XmlWebServices.ZZBoolean internet_only) {
        this.internet_only = internet_only;
    }


    /**
     * Gets the ignore_override_price value for this Price_list_request.
     * 
     * @return ignore_override_price
     */
    public Think.XmlWebServices.ZZBoolean getIgnore_override_price() {
        return ignore_override_price;
    }


    /**
     * Sets the ignore_override_price value for this Price_list_request.
     * 
     * @param ignore_override_price
     */
    public void setIgnore_override_price(Think.XmlWebServices.ZZBoolean ignore_override_price) {
        this.ignore_override_price = ignore_override_price;
    }


    /**
     * Gets the ignore_inactive_source value for this Price_list_request.
     * 
     * @return ignore_inactive_source
     */
    public Think.XmlWebServices.ZZBoolean getIgnore_inactive_source() {
        return ignore_inactive_source;
    }


    /**
     * Sets the ignore_inactive_source value for this Price_list_request.
     * 
     * @param ignore_inactive_source
     */
    public void setIgnore_inactive_source(Think.XmlWebServices.ZZBoolean ignore_inactive_source) {
        this.ignore_inactive_source = ignore_inactive_source;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Price_list_request)) return false;
        Price_list_request other = (Price_list_request) obj;
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
            ((this.price_list_data==null && other.getPrice_list_data()==null) || 
             (this.price_list_data!=null &&
              java.util.Arrays.equals(this.price_list_data, other.getPrice_list_data()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.language_code==null && other.getLanguage_code()==null) || 
             (this.language_code!=null &&
              this.language_code.equals(other.getLanguage_code()))) &&
            ((this.internet_only==null && other.getInternet_only()==null) || 
             (this.internet_only!=null &&
              this.internet_only.equals(other.getInternet_only()))) &&
            ((this.ignore_override_price==null && other.getIgnore_override_price()==null) || 
             (this.ignore_override_price!=null &&
              this.ignore_override_price.equals(other.getIgnore_override_price()))) &&
            ((this.ignore_inactive_source==null && other.getIgnore_inactive_source()==null) || 
             (this.ignore_inactive_source!=null &&
              this.ignore_inactive_source.equals(other.getIgnore_inactive_source())));
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
        if (getPrice_list_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrice_list_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrice_list_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getLanguage_code() != null) {
            _hashCode += getLanguage_code().hashCode();
        }
        if (getInternet_only() != null) {
            _hashCode += getInternet_only().hashCode();
        }
        if (getIgnore_override_price() != null) {
            _hashCode += getIgnore_override_price().hashCode();
        }
        if (getIgnore_inactive_source() != null) {
            _hashCode += getIgnore_inactive_source().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Price_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">price_list_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("language_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "language_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("internet_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "internet_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ignore_override_price");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ignore_override_price"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ignore_inactive_source");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ignore_inactive_source"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price_list_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "price_list_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "price_list_data"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
