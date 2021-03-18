/**
 * Subscription_upgrade_downgrade_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Subscription_upgrade_downgrade_data  implements java.io.Serializable {
    private java.lang.Integer subscrip_id;

    private java.lang.Integer subscription_def_id;

    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private java.lang.String currency;

    private java.lang.Integer quantity;

    private java.lang.String region;

    private java.lang.String state;

    private Think.XmlWebServices.Upgrade_or_downgrade_enum upgrade_or_downgrade;  // attribute

    public Subscription_upgrade_downgrade_data() {
    }

    public Subscription_upgrade_downgrade_data(
           java.lang.Integer subscrip_id,
           java.lang.Integer subscription_def_id,
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           java.lang.String currency,
           java.lang.Integer quantity,
           java.lang.String region,
           java.lang.String state,
           Think.XmlWebServices.Upgrade_or_downgrade_enum upgrade_or_downgrade) {
           this.subscrip_id = subscrip_id;
           this.subscription_def_id = subscription_def_id;
           this.item_identifier = item_identifier;
           this.currency = currency;
           this.quantity = quantity;
           this.region = region;
           this.state = state;
           this.upgrade_or_downgrade = upgrade_or_downgrade;
    }


    /**
     * Gets the subscrip_id value for this Subscription_upgrade_downgrade_data.
     * 
     * @return subscrip_id
     */
    public java.lang.Integer getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this Subscription_upgrade_downgrade_data.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(java.lang.Integer subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the subscription_def_id value for this Subscription_upgrade_downgrade_data.
     * 
     * @return subscription_def_id
     */
    public java.lang.Integer getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this Subscription_upgrade_downgrade_data.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(java.lang.Integer subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the item_identifier value for this Subscription_upgrade_downgrade_data.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Subscription_upgrade_downgrade_data.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the currency value for this Subscription_upgrade_downgrade_data.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this Subscription_upgrade_downgrade_data.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the quantity value for this Subscription_upgrade_downgrade_data.
     * 
     * @return quantity
     */
    public java.lang.Integer getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this Subscription_upgrade_downgrade_data.
     * 
     * @param quantity
     */
    public void setQuantity(java.lang.Integer quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the region value for this Subscription_upgrade_downgrade_data.
     * 
     * @return region
     */
    public java.lang.String getRegion() {
        return region;
    }


    /**
     * Sets the region value for this Subscription_upgrade_downgrade_data.
     * 
     * @param region
     */
    public void setRegion(java.lang.String region) {
        this.region = region;
    }


    /**
     * Gets the state value for this Subscription_upgrade_downgrade_data.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this Subscription_upgrade_downgrade_data.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the upgrade_or_downgrade value for this Subscription_upgrade_downgrade_data.
     * 
     * @return upgrade_or_downgrade
     */
    public Think.XmlWebServices.Upgrade_or_downgrade_enum getUpgrade_or_downgrade() {
        return upgrade_or_downgrade;
    }


    /**
     * Sets the upgrade_or_downgrade value for this Subscription_upgrade_downgrade_data.
     * 
     * @param upgrade_or_downgrade
     */
    public void setUpgrade_or_downgrade(Think.XmlWebServices.Upgrade_or_downgrade_enum upgrade_or_downgrade) {
        this.upgrade_or_downgrade = upgrade_or_downgrade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Subscription_upgrade_downgrade_data)) return false;
        Subscription_upgrade_downgrade_data other = (Subscription_upgrade_downgrade_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subscrip_id==null && other.getSubscrip_id()==null) || 
             (this.subscrip_id!=null &&
              this.subscrip_id.equals(other.getSubscrip_id()))) &&
            ((this.subscription_def_id==null && other.getSubscription_def_id()==null) || 
             (this.subscription_def_id!=null &&
              this.subscription_def_id.equals(other.getSubscription_def_id()))) &&
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.quantity==null && other.getQuantity()==null) || 
             (this.quantity!=null &&
              this.quantity.equals(other.getQuantity()))) &&
            ((this.region==null && other.getRegion()==null) || 
             (this.region!=null &&
              this.region.equals(other.getRegion()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.upgrade_or_downgrade==null && other.getUpgrade_or_downgrade()==null) || 
             (this.upgrade_or_downgrade!=null &&
              this.upgrade_or_downgrade.equals(other.getUpgrade_or_downgrade())));
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
        if (getSubscrip_id() != null) {
            _hashCode += getSubscrip_id().hashCode();
        }
        if (getSubscription_def_id() != null) {
            _hashCode += getSubscription_def_id().hashCode();
        }
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getQuantity() != null) {
            _hashCode += getQuantity().hashCode();
        }
        if (getRegion() != null) {
            _hashCode += getRegion().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getUpgrade_or_downgrade() != null) {
            _hashCode += getUpgrade_or_downgrade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Subscription_upgrade_downgrade_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">subscription_upgrade_downgrade_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("upgrade_or_downgrade");
        attrField.setXmlName(new javax.xml.namespace.QName("", "upgrade_or_downgrade"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "upgrade_or_downgrade_enum"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subscrip_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "subscrip_id"));
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
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZItemIdentifier"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("region");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "region"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "state"));
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
