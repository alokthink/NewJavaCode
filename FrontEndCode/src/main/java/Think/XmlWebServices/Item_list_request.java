/**
 * Item_list_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Item_list_request  implements java.io.Serializable {
    private Think.XmlWebServices.User_login_data user_login_data;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private java.lang.Integer order_code_id;

    private java.lang.String offer_code;

    private java.lang.String generic_promotion_code;

    private java.lang.String shipping_price_list;

    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private java.lang.Integer source_code_id;

    private java.lang.Integer start_issue_id;

    private java.lang.Integer subscription_def_id;

    private java.lang.Integer pkg_def_id;

    private java.lang.Integer product_id;

    private java.lang.Integer package_order_code_id;

    private java.lang.Integer package_orderhdr_id;

    private java.lang.String package_content_or_seq;

    private Think.XmlWebServices.Pkg_disambiguation_data[] pkg_disambiguation_data;

    private Think.XmlWebServices.Disambiguation_order_code[] disambiguation_order_code;

    private Think.XmlWebServices.Order_item[] items_in_progress;

    private java.lang.String dsn;  // attribute

    private java.lang.String language_code;  // attribute

    private Think.XmlWebServices.ZZBoolean disambiguate;  // attribute

    private Think.XmlWebServices.ZZBoolean internet_only;  // attribute

    private Think.XmlWebServices.ZZBoolean package_member;  // attribute

    public Item_list_request() {
    }

    public Item_list_request(
           Think.XmlWebServices.User_login_data user_login_data,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           java.lang.Integer order_code_id,
           java.lang.String offer_code,
           java.lang.String generic_promotion_code,
           java.lang.String shipping_price_list,
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           java.lang.Integer source_code_id,
           java.lang.Integer start_issue_id,
           java.lang.Integer subscription_def_id,
           java.lang.Integer pkg_def_id,
           java.lang.Integer product_id,
           java.lang.Integer package_order_code_id,
           java.lang.Integer package_orderhdr_id,
           java.lang.String package_content_or_seq,
           Think.XmlWebServices.Pkg_disambiguation_data[] pkg_disambiguation_data,
           Think.XmlWebServices.Disambiguation_order_code[] disambiguation_order_code,
           Think.XmlWebServices.Order_item[] items_in_progress,
           java.lang.String dsn,
           java.lang.String language_code,
           Think.XmlWebServices.ZZBoolean disambiguate,
           Think.XmlWebServices.ZZBoolean internet_only,
           Think.XmlWebServices.ZZBoolean package_member) {
           this.user_login_data = user_login_data;
           this.customer_identifier = customer_identifier;
           this.order_code_id = order_code_id;
           this.offer_code = offer_code;
           this.generic_promotion_code = generic_promotion_code;
           this.shipping_price_list = shipping_price_list;
           this.item_identifier = item_identifier;
           this.source_code_id = source_code_id;
           this.start_issue_id = start_issue_id;
           this.subscription_def_id = subscription_def_id;
           this.pkg_def_id = pkg_def_id;
           this.product_id = product_id;
           this.package_order_code_id = package_order_code_id;
           this.package_orderhdr_id = package_orderhdr_id;
           this.package_content_or_seq = package_content_or_seq;
           this.pkg_disambiguation_data = pkg_disambiguation_data;
           this.disambiguation_order_code = disambiguation_order_code;
           this.items_in_progress = items_in_progress;
           this.dsn = dsn;
           this.language_code = language_code;
           this.disambiguate = disambiguate;
           this.internet_only = internet_only;
           this.package_member = package_member;
    }


    /**
     * Gets the user_login_data value for this Item_list_request.
     * 
     * @return user_login_data
     */
    public Think.XmlWebServices.User_login_data getUser_login_data() {
        return user_login_data;
    }


    /**
     * Sets the user_login_data value for this Item_list_request.
     * 
     * @param user_login_data
     */
    public void setUser_login_data(Think.XmlWebServices.User_login_data user_login_data) {
        this.user_login_data = user_login_data;
    }


    /**
     * Gets the customer_identifier value for this Item_list_request.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Item_list_request.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the order_code_id value for this Item_list_request.
     * 
     * @return order_code_id
     */
    public java.lang.Integer getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Item_list_request.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(java.lang.Integer order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the offer_code value for this Item_list_request.
     * 
     * @return offer_code
     */
    public java.lang.String getOffer_code() {
        return offer_code;
    }


    /**
     * Sets the offer_code value for this Item_list_request.
     * 
     * @param offer_code
     */
    public void setOffer_code(java.lang.String offer_code) {
        this.offer_code = offer_code;
    }


    /**
     * Gets the generic_promotion_code value for this Item_list_request.
     * 
     * @return generic_promotion_code
     */
    public java.lang.String getGeneric_promotion_code() {
        return generic_promotion_code;
    }


    /**
     * Sets the generic_promotion_code value for this Item_list_request.
     * 
     * @param generic_promotion_code
     */
    public void setGeneric_promotion_code(java.lang.String generic_promotion_code) {
        this.generic_promotion_code = generic_promotion_code;
    }


    /**
     * Gets the shipping_price_list value for this Item_list_request.
     * 
     * @return shipping_price_list
     */
    public java.lang.String getShipping_price_list() {
        return shipping_price_list;
    }


    /**
     * Sets the shipping_price_list value for this Item_list_request.
     * 
     * @param shipping_price_list
     */
    public void setShipping_price_list(java.lang.String shipping_price_list) {
        this.shipping_price_list = shipping_price_list;
    }


    /**
     * Gets the item_identifier value for this Item_list_request.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Item_list_request.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the source_code_id value for this Item_list_request.
     * 
     * @return source_code_id
     */
    public java.lang.Integer getSource_code_id() {
        return source_code_id;
    }


    /**
     * Sets the source_code_id value for this Item_list_request.
     * 
     * @param source_code_id
     */
    public void setSource_code_id(java.lang.Integer source_code_id) {
        this.source_code_id = source_code_id;
    }


    /**
     * Gets the start_issue_id value for this Item_list_request.
     * 
     * @return start_issue_id
     */
    public java.lang.Integer getStart_issue_id() {
        return start_issue_id;
    }


    /**
     * Sets the start_issue_id value for this Item_list_request.
     * 
     * @param start_issue_id
     */
    public void setStart_issue_id(java.lang.Integer start_issue_id) {
        this.start_issue_id = start_issue_id;
    }


    /**
     * Gets the subscription_def_id value for this Item_list_request.
     * 
     * @return subscription_def_id
     */
    public java.lang.Integer getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this Item_list_request.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(java.lang.Integer subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the pkg_def_id value for this Item_list_request.
     * 
     * @return pkg_def_id
     */
    public java.lang.Integer getPkg_def_id() {
        return pkg_def_id;
    }


    /**
     * Sets the pkg_def_id value for this Item_list_request.
     * 
     * @param pkg_def_id
     */
    public void setPkg_def_id(java.lang.Integer pkg_def_id) {
        this.pkg_def_id = pkg_def_id;
    }


    /**
     * Gets the product_id value for this Item_list_request.
     * 
     * @return product_id
     */
    public java.lang.Integer getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this Item_list_request.
     * 
     * @param product_id
     */
    public void setProduct_id(java.lang.Integer product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the package_order_code_id value for this Item_list_request.
     * 
     * @return package_order_code_id
     */
    public java.lang.Integer getPackage_order_code_id() {
        return package_order_code_id;
    }


    /**
     * Sets the package_order_code_id value for this Item_list_request.
     * 
     * @param package_order_code_id
     */
    public void setPackage_order_code_id(java.lang.Integer package_order_code_id) {
        this.package_order_code_id = package_order_code_id;
    }


    /**
     * Gets the package_orderhdr_id value for this Item_list_request.
     * 
     * @return package_orderhdr_id
     */
    public java.lang.Integer getPackage_orderhdr_id() {
        return package_orderhdr_id;
    }


    /**
     * Sets the package_orderhdr_id value for this Item_list_request.
     * 
     * @param package_orderhdr_id
     */
    public void setPackage_orderhdr_id(java.lang.Integer package_orderhdr_id) {
        this.package_orderhdr_id = package_orderhdr_id;
    }


    /**
     * Gets the package_content_or_seq value for this Item_list_request.
     * 
     * @return package_content_or_seq
     */
    public java.lang.String getPackage_content_or_seq() {
        return package_content_or_seq;
    }


    /**
     * Sets the package_content_or_seq value for this Item_list_request.
     * 
     * @param package_content_or_seq
     */
    public void setPackage_content_or_seq(java.lang.String package_content_or_seq) {
        this.package_content_or_seq = package_content_or_seq;
    }


    /**
     * Gets the pkg_disambiguation_data value for this Item_list_request.
     * 
     * @return pkg_disambiguation_data
     */
    public Think.XmlWebServices.Pkg_disambiguation_data[] getPkg_disambiguation_data() {
        return pkg_disambiguation_data;
    }


    /**
     * Sets the pkg_disambiguation_data value for this Item_list_request.
     * 
     * @param pkg_disambiguation_data
     */
    public void setPkg_disambiguation_data(Think.XmlWebServices.Pkg_disambiguation_data[] pkg_disambiguation_data) {
        this.pkg_disambiguation_data = pkg_disambiguation_data;
    }

    public Think.XmlWebServices.Pkg_disambiguation_data getPkg_disambiguation_data(int i) {
        return this.pkg_disambiguation_data[i];
    }

    public void setPkg_disambiguation_data(int i, Think.XmlWebServices.Pkg_disambiguation_data _value) {
        this.pkg_disambiguation_data[i] = _value;
    }


    /**
     * Gets the disambiguation_order_code value for this Item_list_request.
     * 
     * @return disambiguation_order_code
     */
    public Think.XmlWebServices.Disambiguation_order_code[] getDisambiguation_order_code() {
        return disambiguation_order_code;
    }


    /**
     * Sets the disambiguation_order_code value for this Item_list_request.
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
     * Gets the items_in_progress value for this Item_list_request.
     * 
     * @return items_in_progress
     */
    public Think.XmlWebServices.Order_item[] getItems_in_progress() {
        return items_in_progress;
    }


    /**
     * Sets the items_in_progress value for this Item_list_request.
     * 
     * @param items_in_progress
     */
    public void setItems_in_progress(Think.XmlWebServices.Order_item[] items_in_progress) {
        this.items_in_progress = items_in_progress;
    }


    /**
     * Gets the dsn value for this Item_list_request.
     * 
     * @return dsn
     */
    public java.lang.String getDsn() {
        return dsn;
    }


    /**
     * Sets the dsn value for this Item_list_request.
     * 
     * @param dsn
     */
    public void setDsn(java.lang.String dsn) {
        this.dsn = dsn;
    }


    /**
     * Gets the language_code value for this Item_list_request.
     * 
     * @return language_code
     */
    public java.lang.String getLanguage_code() {
        return language_code;
    }


    /**
     * Sets the language_code value for this Item_list_request.
     * 
     * @param language_code
     */
    public void setLanguage_code(java.lang.String language_code) {
        this.language_code = language_code;
    }


    /**
     * Gets the disambiguate value for this Item_list_request.
     * 
     * @return disambiguate
     */
    public Think.XmlWebServices.ZZBoolean getDisambiguate() {
        return disambiguate;
    }


    /**
     * Sets the disambiguate value for this Item_list_request.
     * 
     * @param disambiguate
     */
    public void setDisambiguate(Think.XmlWebServices.ZZBoolean disambiguate) {
        this.disambiguate = disambiguate;
    }


    /**
     * Gets the internet_only value for this Item_list_request.
     * 
     * @return internet_only
     */
    public Think.XmlWebServices.ZZBoolean getInternet_only() {
        return internet_only;
    }


    /**
     * Sets the internet_only value for this Item_list_request.
     * 
     * @param internet_only
     */
    public void setInternet_only(Think.XmlWebServices.ZZBoolean internet_only) {
        this.internet_only = internet_only;
    }


    /**
     * Gets the package_member value for this Item_list_request.
     * 
     * @return package_member
     */
    public Think.XmlWebServices.ZZBoolean getPackage_member() {
        return package_member;
    }


    /**
     * Sets the package_member value for this Item_list_request.
     * 
     * @param package_member
     */
    public void setPackage_member(Think.XmlWebServices.ZZBoolean package_member) {
        this.package_member = package_member;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item_list_request)) return false;
        Item_list_request other = (Item_list_request) obj;
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
            ((this.order_code_id==null && other.getOrder_code_id()==null) || 
             (this.order_code_id!=null &&
              this.order_code_id.equals(other.getOrder_code_id()))) &&
            ((this.offer_code==null && other.getOffer_code()==null) || 
             (this.offer_code!=null &&
              this.offer_code.equals(other.getOffer_code()))) &&
            ((this.generic_promotion_code==null && other.getGeneric_promotion_code()==null) || 
             (this.generic_promotion_code!=null &&
              this.generic_promotion_code.equals(other.getGeneric_promotion_code()))) &&
            ((this.shipping_price_list==null && other.getShipping_price_list()==null) || 
             (this.shipping_price_list!=null &&
              this.shipping_price_list.equals(other.getShipping_price_list()))) &&
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.source_code_id==null && other.getSource_code_id()==null) || 
             (this.source_code_id!=null &&
              this.source_code_id.equals(other.getSource_code_id()))) &&
            ((this.start_issue_id==null && other.getStart_issue_id()==null) || 
             (this.start_issue_id!=null &&
              this.start_issue_id.equals(other.getStart_issue_id()))) &&
            ((this.subscription_def_id==null && other.getSubscription_def_id()==null) || 
             (this.subscription_def_id!=null &&
              this.subscription_def_id.equals(other.getSubscription_def_id()))) &&
            ((this.pkg_def_id==null && other.getPkg_def_id()==null) || 
             (this.pkg_def_id!=null &&
              this.pkg_def_id.equals(other.getPkg_def_id()))) &&
            ((this.product_id==null && other.getProduct_id()==null) || 
             (this.product_id!=null &&
              this.product_id.equals(other.getProduct_id()))) &&
            ((this.package_order_code_id==null && other.getPackage_order_code_id()==null) || 
             (this.package_order_code_id!=null &&
              this.package_order_code_id.equals(other.getPackage_order_code_id()))) &&
            ((this.package_orderhdr_id==null && other.getPackage_orderhdr_id()==null) || 
             (this.package_orderhdr_id!=null &&
              this.package_orderhdr_id.equals(other.getPackage_orderhdr_id()))) &&
            ((this.package_content_or_seq==null && other.getPackage_content_or_seq()==null) || 
             (this.package_content_or_seq!=null &&
              this.package_content_or_seq.equals(other.getPackage_content_or_seq()))) &&
            ((this.pkg_disambiguation_data==null && other.getPkg_disambiguation_data()==null) || 
             (this.pkg_disambiguation_data!=null &&
              java.util.Arrays.equals(this.pkg_disambiguation_data, other.getPkg_disambiguation_data()))) &&
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
            ((this.disambiguate==null && other.getDisambiguate()==null) || 
             (this.disambiguate!=null &&
              this.disambiguate.equals(other.getDisambiguate()))) &&
            ((this.internet_only==null && other.getInternet_only()==null) || 
             (this.internet_only!=null &&
              this.internet_only.equals(other.getInternet_only()))) &&
            ((this.package_member==null && other.getPackage_member()==null) || 
             (this.package_member!=null &&
              this.package_member.equals(other.getPackage_member())));
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
        if (getOrder_code_id() != null) {
            _hashCode += getOrder_code_id().hashCode();
        }
        if (getOffer_code() != null) {
            _hashCode += getOffer_code().hashCode();
        }
        if (getGeneric_promotion_code() != null) {
            _hashCode += getGeneric_promotion_code().hashCode();
        }
        if (getShipping_price_list() != null) {
            _hashCode += getShipping_price_list().hashCode();
        }
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getSource_code_id() != null) {
            _hashCode += getSource_code_id().hashCode();
        }
        if (getStart_issue_id() != null) {
            _hashCode += getStart_issue_id().hashCode();
        }
        if (getSubscription_def_id() != null) {
            _hashCode += getSubscription_def_id().hashCode();
        }
        if (getPkg_def_id() != null) {
            _hashCode += getPkg_def_id().hashCode();
        }
        if (getProduct_id() != null) {
            _hashCode += getProduct_id().hashCode();
        }
        if (getPackage_order_code_id() != null) {
            _hashCode += getPackage_order_code_id().hashCode();
        }
        if (getPackage_orderhdr_id() != null) {
            _hashCode += getPackage_orderhdr_id().hashCode();
        }
        if (getPackage_content_or_seq() != null) {
            _hashCode += getPackage_content_or_seq().hashCode();
        }
        if (getPkg_disambiguation_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPkg_disambiguation_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPkg_disambiguation_data(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getDisambiguate() != null) {
            _hashCode += getDisambiguate().hashCode();
        }
        if (getInternet_only() != null) {
            _hashCode += getInternet_only().hashCode();
        }
        if (getPackage_member() != null) {
            _hashCode += getPackage_member().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item_list_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">item_list_request"));
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
        attrField.setFieldName("internet_only");
        attrField.setXmlName(new javax.xml.namespace.QName("", "internet_only"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("package_member");
        attrField.setXmlName(new javax.xml.namespace.QName("", "package_member"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
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
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("offer_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "offer_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generic_promotion_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "generic_promotion_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shipping_price_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "shipping_price_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("start_issue_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "start_issue_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscription_def_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscription_def_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pkg_def_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pkg_def_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("product_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "product_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("package_order_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "package_order_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("package_orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "package_orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("package_content_or_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "package_content_or_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pkg_disambiguation_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pkg_disambiguation_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pkg_disambiguation_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disambiguation_order_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "disambiguation_order_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "disambiguation_order_code"));
        elemField.setMinOccurs(0);
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
