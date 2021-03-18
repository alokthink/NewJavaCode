/**
 * Disambiguation_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Disambiguation_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Disambiguation_order_code[] disambiguation_order_code;

    private Think.XmlWebServices.Order_item[] items_in_progress;

    private java.lang.String dsn;  // attribute

    private java.lang.String language_code;  // attribute

    private Think.XmlWebServices.ZZBoolean internet_only;  // attribute

    public Disambiguation_list_request() {
    }

    public Disambiguation_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Disambiguation_order_code[] disambiguation_order_code,
           Think.XmlWebServices.Order_item[] items_in_progress,
           java.lang.String dsn,
           java.lang.String language_code,
           Think.XmlWebServices.ZZBoolean internet_only) {
           this.user_login_data = user_login_data;
           this.disambiguation_order_code = disambiguation_order_code;
           this.items_in_progress = items_in_progress;
           this.dsn = dsn;
           this.language_code = language_code;
           this.internet_only = internet_only;
    }


    /**
     * Gets the user_login_data value for this Disambiguation_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Disambiguation_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the disambiguation_order_code value for this Disambiguation_list_request.
     * 
     * @return disambiguation_order_code
     */
    public Think.XmlWebServices.Disambiguation_order_code[] getDisambiguation_order_code() {
        return disambiguation_order_code;
    }


    /**
     * Sets the disambiguation_order_code value for this Disambiguation_list_request.
     * 
     * @param disambiguation_order_code
     */
    public void setDisambiguation_order_code(Think.XmlWebServices.Disambiguation_order_code[] disambiguation_order_code) {
        this.disambiguation_order_code = disambiguation_order_code;
    }

    public Think.XmlWebServices.Disambiguation_order_code getDisambiguation_order_code(int i) {
        return this.disambiguation_order_code[i];
    }

    public void setDisambiguation_order_code(int i, Think.XmlWebServices.Disambiguation_order_code _value) {
        this.disambiguation_order_code[i] = _value;
    }


    /**
     * Gets the items_in_progress value for this Disambiguation_list_request.
     * 
     * @return items_in_progress
     */
    public Think.XmlWebServices.Order_item[] getItems_in_progress() {
        return items_in_progress;
    }


    /**
     * Sets the items_in_progress value for this Disambiguation_list_request.
     * 
     * @param items_in_progress
     */
    public void setItems_in_progress(Think.XmlWebServices.Order_item[] items_in_progress) {
        this.items_in_progress = items_in_progress;
    }


    /**
     * Gets the dsn value for this Disambiguation_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Disambiguation_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the language_code value for this Disambiguation_list_request.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Disambiguation_list_request.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }


    /**
     * Gets the internet_only value for this Disambiguation_list_request.
     * 
     * @return internet_only
     */
    public Think.XmlWebServices.ZZBoolean getInternet_only() {
        return internet_only;
    }


    /**
     * Sets the internet_only value for this Disambiguation_list_request.
     * 
     * @param internet_only
     */
    public void setInternet_only(Think.XmlWebServices.ZZBoolean internet_only) {
        this.internet_only = internet_only;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Disambiguation_list_request)) return false;
        Disambiguation_list_request other = (Disambiguation_list_request) obj;
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
            ((this.disambiguation_order_code==null && other.getDisambiguation_order_code()==null) || 
             (this.disambiguation_order_code!=null &&
              java.util.Arrays.equals(this.disambiguation_order_code, other.getDisambiguation_order_code()))) &&
            ((this.items_in_progress==null && other.getItems_in_progress()==null) || 
             (this.items_in_progress!=null &&
              java.util.Arrays.equals(this.items_in_progress, other.getItems_in_progress()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.language_code==null && other.getLanguage_code()==null) || 
             (this.language_code!=null &&
              this.language_code.equals(other.getLanguage_code()))) &&
            ((this.internet_only==null && other.getInternet_only()==null) || 
             (this.internet_only!=null &&
              this.internet_only.equals(other.getInternet_only())));
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
        if (getDisambiguation_order_code() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDisambiguation_order_code());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDisambiguation_order_code(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getItems_in_progress() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItems_in_progress());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItems_in_progress(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Disambiguation_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">disambiguation_list_request"));
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
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disambiguation_order_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "disambiguation_order_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "disambiguation_order_code"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("items_in_progress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "items_in_progress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">items_in_progress"));
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
