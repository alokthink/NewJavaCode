/**
 * Currency_select_responseCurrency.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Currency_select_responseCurrency  implements java.io.Serializable {
    private java.lang.String currency;  // attribute

    private java.lang.String user_code;  // attribute

    private java.lang.String description;  // attribute

    private java.math.BigDecimal exchange_rate;  // attribute

    private int n_decimal_places;  // attribute

    private java.util.Calendar change_date;  // attribute

    private java.lang.String currency_symbol;  // attribute

    private java.lang.String html_symbol;  // attribute

    private int iso4217_num_code;  // attribute

    private int date_stamp;  // attribute

    public Currency_select_responseCurrency() {
    }

    public Currency_select_responseCurrency(
           java.lang.String currency,
           java.lang.String user_code,
           java.lang.String description,
           java.math.BigDecimal exchange_rate,
           int n_decimal_places,
           java.util.Calendar change_date,
           java.lang.String currency_symbol,
           java.lang.String html_symbol,
           int iso4217_num_code,
           int date_stamp) {
           this.currency = currency;
           this.user_code = user_code;
           this.description = description;
           this.exchange_rate = exchange_rate;
           this.n_decimal_places = n_decimal_places;
           this.change_date = change_date;
           this.currency_symbol = currency_symbol;
           this.html_symbol = html_symbol;
           this.iso4217_num_code = iso4217_num_code;
           this.date_stamp = date_stamp;
    }


    /**
     * Gets the currency value for this Currency_select_responseCurrency.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Currency_select_responseCurrency.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the user_code value for this Currency_select_responseCurrency.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this Currency_select_responseCurrency.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }


    /**
     * Gets the description value for this Currency_select_responseCurrency.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Currency_select_responseCurrency.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the exchange_rate value for this Currency_select_responseCurrency.
     * 
     * @return exchange_rate
     */
    public java.math.BigDecimal getExchange_rate() {
        return exchange_rate;
    }


    /**
     * Sets the exchange_rate value for this Currency_select_responseCurrency.
     * 
     * @param exchange_rate
     */
    public void setExchange_rate(java.math.BigDecimal exchange_rate) {
        this.exchange_rate = exchange_rate;
    }


    /**
     * Gets the n_decimal_places value for this Currency_select_responseCurrency.
     * 
     * @return n_decimal_places
     */
    public int getN_decimal_places() {
        return n_decimal_places;
    }


    /**
     * Sets the n_decimal_places value for this Currency_select_responseCurrency.
     * 
     * @param n_decimal_places
     */
    public void setN_decimal_places(int n_decimal_places) {
        this.n_decimal_places = n_decimal_places;
    }


    /**
     * Gets the change_date value for this Currency_select_responseCurrency.
     * 
     * @return change_date
     */
    public java.util.Calendar getChange_date() {
        return change_date;
    }


    /**
     * Sets the change_date value for this Currency_select_responseCurrency.
     * 
     * @param change_date
     */
    public void setChange_date(java.util.Calendar change_date) {
        this.change_date = change_date;
    }


    /**
     * Gets the currency_symbol value for this Currency_select_responseCurrency.
     * 
     * @return currency_symbol
     */
    public java.lang.String getCurrency_symbol() {
        return currency_symbol;
    }


    /**
     * Sets the currency_symbol value for this Currency_select_responseCurrency.
     * 
     * @param currency_symbol
     */
    public void setCurrency_symbol(java.lang.String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }


    /**
     * Gets the html_symbol value for this Currency_select_responseCurrency.
     * 
     * @return html_symbol
     */
    public java.lang.String getHtml_symbol() {
        return html_symbol;
    }


    /**
     * Sets the html_symbol value for this Currency_select_responseCurrency.
     * 
     * @param html_symbol
     */
    public void setHtml_symbol(java.lang.String html_symbol) {
        this.html_symbol = html_symbol;
    }


    /**
     * Gets the iso4217_num_code value for this Currency_select_responseCurrency.
     * 
     * @return iso4217_num_code
     */
    public int getIso4217_num_code() {
        return iso4217_num_code;
    }


    /**
     * Sets the iso4217_num_code value for this Currency_select_responseCurrency.
     * 
     * @param iso4217_num_code
     */
    public void setIso4217_num_code(int iso4217_num_code) {
        this.iso4217_num_code = iso4217_num_code;
    }


    /**
     * Gets the date_stamp value for this Currency_select_responseCurrency.
     * 
     * @return date_stamp
     */
    public int getDate_stamp() {
        return date_stamp;
    }


    /**
     * Sets the date_stamp value for this Currency_select_responseCurrency.
     * 
     * @param date_stamp
     */
    public void setDate_stamp(int date_stamp) {
        this.date_stamp = date_stamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Currency_select_responseCurrency)) return false;
        Currency_select_responseCurrency other = (Currency_select_responseCurrency) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.exchange_rate==null && other.getExchange_rate()==null) || 
             (this.exchange_rate!=null &&
              this.exchange_rate.equals(other.getExchange_rate()))) &&
            this.n_decimal_places == other.getN_decimal_places() &&
            ((this.change_date==null && other.getChange_date()==null) || 
             (this.change_date!=null &&
              this.change_date.equals(other.getChange_date()))) &&
            ((this.currency_symbol==null && other.getCurrency_symbol()==null) || 
             (this.currency_symbol!=null &&
              this.currency_symbol.equals(other.getCurrency_symbol()))) &&
            ((this.html_symbol==null && other.getHtml_symbol()==null) || 
             (this.html_symbol!=null &&
              this.html_symbol.equals(other.getHtml_symbol()))) &&
            this.iso4217_num_code == other.getIso4217_num_code() &&
            this.date_stamp == other.getDate_stamp();
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
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getExchange_rate() != null) {
            _hashCode += getExchange_rate().hashCode();
        }
        _hashCode += getN_decimal_places();
        if (getChange_date() != null) {
            _hashCode += getChange_date().hashCode();
        }
        if (getCurrency_symbol() != null) {
            _hashCode += getCurrency_symbol().hashCode();
        }
        if (getHtml_symbol() != null) {
            _hashCode += getHtml_symbol().hashCode();
        }
        _hashCode += getIso4217_num_code();
        _hashCode += getDate_stamp();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Currency_select_responseCurrency.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>currency_select_response>currency"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("exchange_rate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "exchange_rate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZMoney"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("n_decimal_places");
        attrField.setXmlName(new javax.xml.namespace.QName("", "n_decimal_places"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("change_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "change_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("currency_symbol");
        attrField.setXmlName(new javax.xml.namespace.QName("", "currency_symbol"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("html_symbol");
        attrField.setXmlName(new javax.xml.namespace.QName("", "html_symbol"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("iso4217_num_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "iso4217_num_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("date_stamp");
        attrField.setXmlName(new javax.xml.namespace.QName("", "date_stamp"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
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
