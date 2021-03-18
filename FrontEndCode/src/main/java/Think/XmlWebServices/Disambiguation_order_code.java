/**
 * Disambiguation_order_code.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Disambiguation_order_code  implements java.io.Serializable {
    private int order_code_id;

    private java.lang.Integer disambiguation_source_code_id;

    private java.lang.Integer customer_id;

    private Think.XmlWebServices.ZZItemIdentifier item_identifier;

    private java.lang.Integer pkg_def_id;  // attribute

    private Think.XmlWebServices.ZZBoolean suppress_if_unambiguous;  // attribute

    public Disambiguation_order_code() {
    }

    public Disambiguation_order_code(
           int order_code_id,
           java.lang.Integer disambiguation_source_code_id,
           java.lang.Integer customer_id,
           Think.XmlWebServices.ZZItemIdentifier item_identifier,
           java.lang.Integer pkg_def_id,
           Think.XmlWebServices.ZZBoolean suppress_if_unambiguous) {
           this.order_code_id = order_code_id;
           this.disambiguation_source_code_id = disambiguation_source_code_id;
           this.customer_id = customer_id;
           this.item_identifier = item_identifier;
           this.pkg_def_id = pkg_def_id;
           this.suppress_if_unambiguous = suppress_if_unambiguous;
    }


    /**
     * Gets the order_code_id value for this Disambiguation_order_code.
     * 
     * @return order_code_id
     */
    public int getOrder_code_id() {
        return order_code_id;
    }


    /**
     * Sets the order_code_id value for this Disambiguation_order_code.
     * 
     * @param order_code_id
     */
    public void setOrder_code_id(int order_code_id) {
        this.order_code_id = order_code_id;
    }


    /**
     * Gets the disambiguation_source_code_id value for this Disambiguation_order_code.
     * 
     * @return disambiguation_source_code_id
     */
    public java.lang.Integer getDisambiguation_source_code_id() {
        return disambiguation_source_code_id;
    }


    /**
     * Sets the disambiguation_source_code_id value for this Disambiguation_order_code.
     * 
     * @param disambiguation_source_code_id
     */
    public void setDisambiguation_source_code_id(java.lang.Integer disambiguation_source_code_id) {
        this.disambiguation_source_code_id = disambiguation_source_code_id;
    }


    /**
     * Gets the customer_id value for this Disambiguation_order_code.
     * 
     * @return customer_id
     */
    public java.lang.Integer getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Disambiguation_order_code.
     * 
     * @param customer_id
     */
    public void setCustomer_id(java.lang.Integer customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the item_identifier value for this Disambiguation_order_code.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Disambiguation_order_code.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier item_identifier) {
        this.item_identifier = item_identifier;
    }


    /**
     * Gets the pkg_def_id value for this Disambiguation_order_code.
     * 
     * @return pkg_def_id
     */
    public java.lang.Integer getPkg_def_id() {
        return pkg_def_id;
    }


    /**
     * Sets the pkg_def_id value for this Disambiguation_order_code.
     * 
     * @param pkg_def_id
     */
    public void setPkg_def_id(java.lang.Integer pkg_def_id) {
        this.pkg_def_id = pkg_def_id;
    }


    /**
     * Gets the suppress_if_unambiguous value for this Disambiguation_order_code.
     * 
     * @return suppress_if_unambiguous
     */
    public Think.XmlWebServices.ZZBoolean getSuppress_if_unambiguous() {
        return suppress_if_unambiguous;
    }


    /**
     * Sets the suppress_if_unambiguous value for this Disambiguation_order_code.
     * 
     * @param suppress_if_unambiguous
     */
    public void setSuppress_if_unambiguous(Think.XmlWebServices.ZZBoolean suppress_if_unambiguous) {
        this.suppress_if_unambiguous = suppress_if_unambiguous;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Disambiguation_order_code)) return false;
        Disambiguation_order_code other = (Disambiguation_order_code) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.order_code_id == other.getOrder_code_id() &&
            ((this.disambiguation_source_code_id==null && other.getDisambiguation_source_code_id()==null) || 
             (this.disambiguation_source_code_id!=null &&
              this.disambiguation_source_code_id.equals(other.getDisambiguation_source_code_id()))) &&
            ((this.customer_id==null && other.getCustomer_id()==null) || 
             (this.customer_id!=null &&
              this.customer_id.equals(other.getCustomer_id()))) &&
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              this.item_identifier.equals(other.getItem_identifier()))) &&
            ((this.pkg_def_id==null && other.getPkg_def_id()==null) || 
             (this.pkg_def_id!=null &&
              this.pkg_def_id.equals(other.getPkg_def_id()))) &&
            ((this.suppress_if_unambiguous==null && other.getSuppress_if_unambiguous()==null) || 
             (this.suppress_if_unambiguous!=null &&
              this.suppress_if_unambiguous.equals(other.getSuppress_if_unambiguous())));
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
        _hashCode += getOrder_code_id();
        if (getDisambiguation_source_code_id() != null) {
            _hashCode += getDisambiguation_source_code_id().hashCode();
        }
        if (getCustomer_id() != null) {
            _hashCode += getCustomer_id().hashCode();
        }
        if (getItem_identifier() != null) {
            _hashCode += getItem_identifier().hashCode();
        }
        if (getPkg_def_id() != null) {
            _hashCode += getPkg_def_id().hashCode();
        }
        if (getSuppress_if_unambiguous() != null) {
            _hashCode += getSuppress_if_unambiguous().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Disambiguation_order_code.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">disambiguation_order_code"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("pkg_def_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "pkg_def_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("suppress_if_unambiguous");
        attrField.setXmlName(new javax.xml.namespace.QName("", "suppress_if_unambiguous"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "order_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disambiguation_source_code_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "disambiguation_source_code_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_id"));
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
