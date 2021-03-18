/**
 * Amount_conversion_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Amount_conversion_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private java.lang.String currency;

    private Think.XmlWebServices.Amount_struct[] amount_struct;

    private java.lang.String dsn;  // attribute

    private Think.XmlWebServices.ZZBoolean sum;  // attribute

    public Amount_conversion_request() {
    }

    public Amount_conversion_request(
           Think.XmlWebServices.User_login_data user_login_data,
           java.lang.String currency,
           Think.XmlWebServices.Amount_struct[] amount_struct,
           java.lang.String dsn,
           Think.XmlWebServices.ZZBoolean sum) {
           this.user_login_data = user_login_data;
           this.currency = currency;
           this.amount_struct = amount_struct;
           this.dsn = dsn;
           this.sum = sum;
    }


    /**
     * Gets the user_login_data value for this Amount_conversion_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Amount_conversion_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the currency value for this Amount_conversion_request.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Amount_conversion_request.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the amount_struct value for this Amount_conversion_request.
     * 
     * @return amount_struct
     */
    public Think.XmlWebServices.Amount_struct[] getAmount_struct() {
        return amount_struct;
    }


    /**
     * Sets the amount_struct value for this Amount_conversion_request.
     * 
     * @param amount_struct
     */
    public void setAmount_struct(Think.XmlWebServices.Amount_struct[] amount_struct) {
        this.amount_struct = amount_struct;
    }

    public Think.XmlWebServices.Amount_struct getAmount_struct(int i) {
        return this.amount_struct[i];
    }

    public void setAmount_struct(int i, Think.XmlWebServices.Amount_struct _value) {
        this.amount_struct[i] = _value;
    }


    /**
     * Gets the dsn value for this Amount_conversion_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Amount_conversion_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the sum value for this Amount_conversion_request.
     * 
     * @return sum
     */
    public Think.XmlWebServices.ZZBoolean getSum() {
        return sum;
    }


    /**
     * Sets the sum value for this Amount_conversion_request.
     * 
     * @param sum
     */
    public void setSum(Think.XmlWebServices.ZZBoolean sum) {
        this.sum = sum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Amount_conversion_request)) return false;
        Amount_conversion_request other = (Amount_conversion_request) obj;
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
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.amount_struct==null && other.getAmount_struct()==null) || 
             (this.amount_struct!=null &&
              java.util.Arrays.equals(this.amount_struct, other.getAmount_struct()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.sum==null && other.getSum()==null) || 
             (this.sum!=null &&
              this.sum.equals(other.getSum())));
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
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getAmount_struct() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAmount_struct());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAmount_struct(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDsn() != null) {
            _hashCode += getDsn().hashCode();
        }
        if (getSum() != null) {
            _hashCode += getSum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Amount_conversion_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">amount_conversion_request"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("dsn");
        attrField.setXmlName(new javax.xml.namespace.QName("", "dsn"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sum");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sum"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount_struct");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "amount_struct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "amount_struct"));
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
