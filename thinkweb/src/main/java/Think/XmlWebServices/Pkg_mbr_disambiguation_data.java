/**
 * Pkg_mbr_disambiguation_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Pkg_mbr_disambiguation_data  implements java.io.Serializable {
    private java.lang.Integer order_code_id;

    private java.lang.Integer subscription_def_id;

    private java.lang.Integer product_id;

    private java.lang.Integer issue_id;

    private java.lang.Integer addon_to_orderhdr_id;

    private java.lang.Integer addon_to_order_item_seq;

    private java.lang.String addon_to;

    public Pkg_mbr_disambiguation_data() {
    }

    public Pkg_mbr_disambiguation_data(
           java.lang.Integer order_code_id,
           java.lang.Integer subscription_def_id,
           java.lang.Integer product_id,
           java.lang.Integer issue_id,
           java.lang.Integer addon_to_orderhdr_id,
           java.lang.Integer addon_to_order_item_seq,
           java.lang.String addon_to) {
           this.order_code_id = order_code_id;
           this.subscription_def_id = subscription_def_id;
           this.product_id = product_id;
           this.issue_id = issue_id;
           this.addon_to_orderhdr_id = addon_to_orderhdr_id;
           this.addon_to_order_item_seq = addon_to_order_item_seq;
           this.addon_to = addon_to;
    }


    /**
     * Gets the order_code_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @return order_code_id
     */
    public java.lang.Integer getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(java.lang.Integer order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the subscription_def_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @return subscription_def_id
     */
    public java.lang.Integer getSubscription_def_id() {
        return subscription_def_id;
    }


    /**
     * Sets the subscription_def_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @param subscription_def_id
     */
    public void setSubscription_def_id(java.lang.Integer subscription_def_id) {
        this.subscription_def_id = subscription_def_id;
    }


    /**
     * Gets the product_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @return product_id
     */
    public java.lang.Integer getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @param product_id
     */
    public void setProduct_id(java.lang.Integer product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the issue_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @return issue_id
     */
    public java.lang.Integer getIssue_id() {
        return issue_id;
    }


    /**
     * Sets the issue_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @param issue_id
     */
    public void setIssue_id(java.lang.Integer issue_id) {
        this.issue_id = issue_id;
    }


    /**
     * Gets the addon_to_orderhdr_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @return addon_to_orderhdr_id
     */
    public java.lang.Integer getAddon_to_orderhdr_id() {
        return addon_to_orderhdr_id;
    }


    /**
     * Sets the addon_to_orderhdr_id value for this Pkg_mbr_disambiguation_data.
     * 
     * @param addon_to_orderhdr_id
     */
    public void setAddon_to_orderhdr_id(java.lang.Integer addon_to_orderhdr_id) {
        this.addon_to_orderhdr_id = addon_to_orderhdr_id;
    }


    /**
     * Gets the addon_to_order_item_seq value for this Pkg_mbr_disambiguation_data.
     * 
     * @return addon_to_order_item_seq
     */
    public java.lang.Integer getAddon_to_order_item_seq() {
        return addon_to_order_item_seq;
    }


    /**
     * Sets the addon_to_order_item_seq value for this Pkg_mbr_disambiguation_data.
     * 
     * @param addon_to_order_item_seq
     */
    public void setAddon_to_order_item_seq(java.lang.Integer addon_to_order_item_seq) {
        this.addon_to_order_item_seq = addon_to_order_item_seq;
    }


    /**
     * Gets the addon_to value for this Pkg_mbr_disambiguation_data.
     * 
     * @return addon_to
     */
    public java.lang.String getAddon_to() {
        return addon_to;
    }


    /**
     * Sets the addon_to value for this Pkg_mbr_disambiguation_data.
     * 
     * @param addon_to
     */
    public void setAddon_to(java.lang.String addon_to) {
        this.addon_to = addon_to;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pkg_mbr_disambiguation_data)) return false;
        Pkg_mbr_disambiguation_data other = (Pkg_mbr_disambiguation_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.order_code_id==null && other.getOrder_code_id()==null) || 
             (this.order_code_id!=null &&
              this.order_code_id.equals(other.getOrder_code_id()))) &&
            ((this.subscription_def_id==null && other.getSubscription_def_id()==null) || 
             (this.subscription_def_id!=null &&
              this.subscription_def_id.equals(other.getSubscription_def_id()))) &&
            ((this.product_id==null && other.getProduct_id()==null) || 
             (this.product_id!=null &&
              this.product_id.equals(other.getProduct_id()))) &&
            ((this.issue_id==null && other.getIssue_id()==null) || 
             (this.issue_id!=null &&
              this.issue_id.equals(other.getIssue_id()))) &&
            ((this.addon_to_orderhdr_id==null && other.getAddon_to_orderhdr_id()==null) || 
             (this.addon_to_orderhdr_id!=null &&
              this.addon_to_orderhdr_id.equals(other.getAddon_to_orderhdr_id()))) &&
            ((this.addon_to_order_item_seq==null && other.getAddon_to_order_item_seq()==null) || 
             (this.addon_to_order_item_seq!=null &&
              this.addon_to_order_item_seq.equals(other.getAddon_to_order_item_seq()))) &&
            ((this.addon_to==null && other.getAddon_to()==null) || 
             (this.addon_to!=null &&
              this.addon_to.equals(other.getAddon_to())));
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
        if (getOrder_code_id() != null) {
            _hashCode += getOrder_code_id().hashCode();
        }
        if (getSubscription_def_id() != null) {
            _hashCode += getSubscription_def_id().hashCode();
        }
        if (getProduct_id() != null) {
            _hashCode += getProduct_id().hashCode();
        }
        if (getIssue_id() != null) {
            _hashCode += getIssue_id().hashCode();
        }
        if (getAddon_to_orderhdr_id() != null) {
            _hashCode += getAddon_to_orderhdr_id().hashCode();
        }
        if (getAddon_to_order_item_seq() != null) {
            _hashCode += getAddon_to_order_item_seq().hashCode();
        }
        if (getAddon_to() != null) {
            _hashCode += getAddon_to().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pkg_mbr_disambiguation_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">pkg_mbr_disambiguation_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_id"));
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
        elemField.setFieldName("product_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "product_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issue_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "issue_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addon_to_orderhdr_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "addon_to_orderhdr_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addon_to_order_item_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "addon_to_order_item_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addon_to");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "addon_to"));
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
