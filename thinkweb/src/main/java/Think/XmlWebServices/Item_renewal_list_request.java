/**
 * Item_renewal_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Item_renewal_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private int subscrip_id;

    private java.lang.Integer source_code_id;

    private java.lang.Integer agency_customer_id;

    private Think.XmlWebServices.Order_code_data order_code_data;

    private Think.XmlWebServices.Renewal_history_offer renewal_history_offer;

    private Think.XmlWebServices.Renewal_card_offer renewal_card_offer;

    private Think.XmlWebServices.Pkg_mbr_disambiguation_data[] pkg_mbr_disambiguation_list;

    private java.lang.String dsn;  // attribute

    private java.lang.String language_code;  // attribute

    private Think.XmlWebServices.ZZBoolean disambiguate;  // attribute

    private Think.XmlWebServices.ZZBoolean want_default_address_warning;  // attribute

    public Item_renewal_list_request() {
    }

    public Item_renewal_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           int subscrip_id,
           java.lang.Integer source_code_id,
           java.lang.Integer agency_customer_id,
           Think.XmlWebServices.Order_code_data order_code_data,
           Think.XmlWebServices.Renewal_history_offer renewal_history_offer,
           Think.XmlWebServices.Renewal_card_offer renewal_card_offer,
           Think.XmlWebServices.Pkg_mbr_disambiguation_data[] pkg_mbr_disambiguation_list,
           java.lang.String dsn,
           java.lang.String language_code,
           Think.XmlWebServices.ZZBoolean disambiguate,
           Think.XmlWebServices.ZZBoolean want_default_address_warning) {
           this.user_login_data = user_login_data;
           this.subscrip_id = subscrip_id;
           this.source_code_id = source_code_id;
           this.agency_customer_id = agency_customer_id;
           this.order_code_data = order_code_data;
           this.renewal_history_offer = renewal_history_offer;
           this.renewal_card_offer = renewal_card_offer;
           this.pkg_mbr_disambiguation_list = pkg_mbr_disambiguation_list;
           this.dsn = dsn;
           this.language_code = language_code;
           this.disambiguate = disambiguate;
           this.want_default_address_warning = want_default_address_warning;
    }


    /**
     * Gets the user_login_data value for this Item_renewal_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Item_renewal_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the subscrip_id value for this Item_renewal_list_request.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Item_renewal_list_request.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the source_code_id value for this Item_renewal_list_request.
     * 
     * @return source_code_id
     */
    public java.lang.Integer getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Item_renewal_list_request.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(java.lang.Integer source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the agency_customer_id value for this Item_renewal_list_request.
     * 
     * @return agency_customer_id
     */
    public java.lang.Integer getAgency_customer_id() {
        return agency_customer_id;
    }


    /**
     * Sets the agency_customer_id value for this Item_renewal_list_request.
     * 
     * @param agency_customer_id
     */
    public void setAgency_customer_id(java.lang.Integer agency_customer_id) {
        this.agency_customer_id = agency_customer_id;
    }


    /**
     * Gets the order_code_data value for this Item_renewal_list_request.
     * 
     * @return order_code_data
     */
    public Think.XmlWebServices.Order_code_data getOrder_code_data() {
        return order_code_data;
    }


    /**
     * Sets the order_code_data value for this Item_renewal_list_request.
     * 
     * @param order_code_data
     */
    public void setOrder_code_data(Think.XmlWebServices.Order_code_data order_code_data) {
        this.order_code_data = order_code_data;
    }


    /**
     * Gets the renewal_history_offer value for this Item_renewal_list_request.
     * 
     * @return renewal_history_offer
     */
    public Think.XmlWebServices.Renewal_history_offer getRenewal_history_offer() {
        return renewal_history_offer;
    }


    /**
     * Sets the renewal_history_offer value for this Item_renewal_list_request.
     * 
     * @param renewal_history_offer
     */
    public void setRenewal_history_offer(Think.XmlWebServices.Renewal_history_offer renewal_history_offer) {
        this.renewal_history_offer = renewal_history_offer;
    }


    /**
     * Gets the renewal_card_offer value for this Item_renewal_list_request.
     * 
     * @return renewal_card_offer
     */
    public Think.XmlWebServices.Renewal_card_offer getRenewal_card_offer() {
        return renewal_card_offer;
    }


    /**
     * Sets the renewal_card_offer value for this Item_renewal_list_request.
     * 
     * @param renewal_card_offer
     */
    public void setRenewal_card_offer(Think.XmlWebServices.Renewal_card_offer renewal_card_offer) {
        this.renewal_card_offer = renewal_card_offer;
    }


    /**
     * Gets the pkg_mbr_disambiguation_list value for this Item_renewal_list_request.
     * 
     * @return pkg_mbr_disambiguation_list
     */
    public Think.XmlWebServices.Pkg_mbr_disambiguation_data[] getPkg_mbr_disambiguation_list() {
        return pkg_mbr_disambiguation_list;
    }


    /**
     * Sets the pkg_mbr_disambiguation_list value for this Item_renewal_list_request.
     * 
     * @param pkg_mbr_disambiguation_list
     */
    public void setPkg_mbr_disambiguation_list(Think.XmlWebServices.Pkg_mbr_disambiguation_data[] pkg_mbr_disambiguation_list) {
        this.pkg_mbr_disambiguation_list = pkg_mbr_disambiguation_list;
    }


    /**
     * Gets the dsn value for this Item_renewal_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Item_renewal_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the language_code value for this Item_renewal_list_request.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Item_renewal_list_request.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }


    /**
     * Gets the disambiguate value for this Item_renewal_list_request.
     * 
     * @return disambiguate
     */
    public Think.XmlWebServices.ZZBoolean getDisambiguate() {
        return disambiguate;
    }


    /**
     * Sets the disambiguate value for this Item_renewal_list_request.
     * 
     * @param disambiguate
     */
    public void setDisambiguate(Think.XmlWebServices.ZZBoolean disambiguate) {
        this.disambiguate = disambiguate;
    }


    /**
     * Gets the want_default_address_warning value for this Item_renewal_list_request.
     * 
     * @return want_default_address_warning
     */
    public Think.XmlWebServices.ZZBoolean getWant_default_address_warning() {
        return want_default_address_warning;
    }


    /**
     * Sets the want_default_address_warning value for this Item_renewal_list_request.
     * 
     * @param want_default_address_warning
     */
    public void setWant_default_address_warning(Think.XmlWebServices.ZZBoolean want_default_address_warning) {
        this.want_default_address_warning = want_default_address_warning;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item_renewal_list_request)) return false;
        Item_renewal_list_request other = (Item_renewal_list_request) obj;
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
            this.subscrip_id == other.getSubscrip_id() &&
            ((this.source_code_id==null && other.getSource_code_id()==null) || 
             (this.source_code_id!=null &&
              this.source_code_id.equals(other.getSource_code_id()))) &&
            ((this.agency_customer_id==null && other.getAgency_customer_id()==null) || 
             (this.agency_customer_id!=null &&
              this.agency_customer_id.equals(other.getAgency_customer_id()))) &&
            ((this.order_code_data==null && other.getOrder_code_data()==null) || 
             (this.order_code_data!=null &&
              this.order_code_data.equals(other.getOrder_code_data()))) &&
            ((this.renewal_history_offer==null && other.getRenewal_history_offer()==null) || 
             (this.renewal_history_offer!=null &&
              this.renewal_history_offer.equals(other.getRenewal_history_offer()))) &&
            ((this.renewal_card_offer==null && other.getRenewal_card_offer()==null) || 
             (this.renewal_card_offer!=null &&
              this.renewal_card_offer.equals(other.getRenewal_card_offer()))) &&
            ((this.pkg_mbr_disambiguation_list==null && other.getPkg_mbr_disambiguation_list()==null) || 
             (this.pkg_mbr_disambiguation_list!=null &&
              java.util.Arrays.equals(this.pkg_mbr_disambiguation_list, other.getPkg_mbr_disambiguation_list()))) &&
            ((this.dsn==null && other.getDsn()==null) || 
             (this.dsn!=null &&
              this.dsn.equals(other.getDsn()))) &&
            ((this.language_code==null && other.getLanguage_code()==null) || 
             (this.language_code!=null &&
              this.language_code.equals(other.getLanguage_code()))) &&
            ((this.disambiguate==null && other.getDisambiguate()==null) || 
             (this.disambiguate!=null &&
              this.disambiguate.equals(other.getDisambiguate()))) &&
            ((this.want_default_address_warning==null && other.getWant_default_address_warning()==null) || 
             (this.want_default_address_warning!=null &&
              this.want_default_address_warning.equals(other.getWant_default_address_warning())));
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
        _hashCode += getSubscrip_id();
        if (getSource_code_id() != null) {
            _hashCode += getSource_code_id().hashCode();
        }
        if (getAgency_customer_id() != null) {
            _hashCode += getAgency_customer_id().hashCode();
        }
        if (getOrder_code_data() != null) {
            _hashCode += getOrder_code_data().hashCode();
        }
        if (getRenewal_history_offer() != null) {
            _hashCode += getRenewal_history_offer().hashCode();
        }
        if (getRenewal_card_offer() != null) {
            _hashCode += getRenewal_card_offer().hashCode();
        }
        if (getPkg_mbr_disambiguation_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPkg_mbr_disambiguation_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPkg_mbr_disambiguation_list(), i);
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
        if (getDisambiguate() != null) {
            _hashCode += getDisambiguate().hashCode();
        }
        if (getWant_default_address_warning() != null) {
            _hashCode += getWant_default_address_warning().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item_renewal_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_renewal_list_request"));
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
        attrField.setFieldName("disambiguate");
        attrField.setXmlName(new javax.xml.namespace.QName("", "disambiguate"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("want_default_address_warning");
        attrField.setXmlName(new javax.xml.namespace.QName("", "want_default_address_warning"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_login_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "user_login_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">user_login_data"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("source_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "source_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agency_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "agency_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">order_code_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_history_offer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_history_offer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">renewal_history_offer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewal_card_offer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renewal_card_offer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">renewal_card_offer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pkg_mbr_disambiguation_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pkg_mbr_disambiguation_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">pkg_mbr_disambiguation_list"));
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
