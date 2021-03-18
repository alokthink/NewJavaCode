/**
 * Group_member_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Group_member_data  implements java.io.Serializable {
    private int customer_group_customer_id;

    private java.lang.Integer customer_address_seq;

    private java.lang.Integer n_copies;

    private java.lang.Boolean active;

    private java.lang.Boolean authorized;

    private Think.XmlWebServices.ZZItemIdentifier[] item_identifier;

    private Think.XmlWebServices.ZZBoolean delete;  // attribute

    public Group_member_data() {
    }

    public Group_member_data(
           int customer_group_customer_id,
           java.lang.Integer customer_address_seq,
           java.lang.Integer n_copies,
           java.lang.Boolean active,
           java.lang.Boolean authorized,
           Think.XmlWebServices.ZZItemIdentifier[] item_identifier,
           Think.XmlWebServices.ZZBoolean delete) {
           this.customer_group_customer_id = customer_group_customer_id;
           this.customer_address_seq = customer_address_seq;
           this.n_copies = n_copies;
           this.active = active;
           this.authorized = authorized;
           this.item_identifier = item_identifier;
           this.delete = delete;
    }


    /**
     * Gets the customer_group_customer_id value for this Group_member_data.
     * 
     * @return customer_group_customer_id
     */
    public int getCustomer_group_customer_id() {
        return customer_group_customer_id;
    }


    /**
     * Sets the customer_group_customer_id value for this Group_member_data.
     * 
     * @param customer_group_customer_id
     */
    public void setCustomer_group_customer_id(int customer_group_customer_id) {
        this.customer_group_customer_id = customer_group_customer_id;
    }


    /**
     * Gets the customer_address_seq value for this Group_member_data.
     * 
     * @return customer_address_seq
     */
    public java.lang.Integer getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Group_member_data.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(java.lang.Integer customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the n_copies value for this Group_member_data.
     * 
     * @return n_copies
     */
    public java.lang.Integer getN_copies() {
        return n_copies;
    }


    /**
     * Sets the n_copies value for this Group_member_data.
     * 
     * @param n_copies
     */
    public void setN_copies(java.lang.Integer n_copies) {
        this.n_copies = n_copies;
    }


    /**
     * Gets the active value for this Group_member_data.
     * 
     * @return active
     */
    public java.lang.Boolean getActive() {
        return active;
    }


    /**
     * Sets the active value for this Group_member_data.
     * 
     * @param active
     */
    public void setActive(java.lang.Boolean active) {
        this.active = active;
    }


    /**
     * Gets the authorized value for this Group_member_data.
     * 
     * @return authorized
     */
    public java.lang.Boolean getAuthorized() {
        return authorized;
    }


    /**
     * Sets the authorized value for this Group_member_data.
     * 
     * @param authorized
     */
    public void setAuthorized(java.lang.Boolean authorized) {
        this.authorized = authorized;
    }


    /**
     * Gets the item_identifier value for this Group_member_data.
     * 
     * @return item_identifier
     */
    public Think.XmlWebServices.ZZItemIdentifier[] getItem_identifier() {
        return item_identifier;
    }


    /**
     * Sets the item_identifier value for this Group_member_data.
     * 
     * @param item_identifier
     */
    public void setItem_identifier(Think.XmlWebServices.ZZItemIdentifier[] item_identifier) {
        this.item_identifier = item_identifier;
    }

    public Think.XmlWebServices.ZZItemIdentifier getItem_identifier(int i) {
        return this.item_identifier[i];
    }

    public void setItem_identifier(int i, Think.XmlWebServices.ZZItemIdentifier _value) {
        this.item_identifier[i] = _value;
    }


    /**
     * Gets the delete value for this Group_member_data.
     * 
     * @return delete
     */
    public Think.XmlWebServices.ZZBoolean getDelete() {
        return delete;
    }


    /**
     * Sets the delete value for this Group_member_data.
     * 
     * @param delete
     */
    public void setDelete(Think.XmlWebServices.ZZBoolean delete) {
        this.delete = delete;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Group_member_data)) return false;
        Group_member_data other = (Group_member_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_group_customer_id == other.getCustomer_group_customer_id() &&
            ((this.customer_address_seq==null && other.getCustomer_address_seq()==null) || 
             (this.customer_address_seq!=null &&
              this.customer_address_seq.equals(other.getCustomer_address_seq()))) &&
            ((this.n_copies==null && other.getN_copies()==null) || 
             (this.n_copies!=null &&
              this.n_copies.equals(other.getN_copies()))) &&
            ((this.active==null && other.getActive()==null) || 
             (this.active!=null &&
              this.active.equals(other.getActive()))) &&
            ((this.authorized==null && other.getAuthorized()==null) || 
             (this.authorized!=null &&
              this.authorized.equals(other.getAuthorized()))) &&
            ((this.item_identifier==null && other.getItem_identifier()==null) || 
             (this.item_identifier!=null &&
              java.util.Arrays.equals(this.item_identifier, other.getItem_identifier()))) &&
            ((this.delete==null && other.getDelete()==null) || 
             (this.delete!=null &&
              this.delete.equals(other.getDelete())));
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
        _hashCode += getCustomer_group_customer_id();
        if (getCustomer_address_seq() != null) {
            _hashCode += getCustomer_address_seq().hashCode();
        }
        if (getN_copies() != null) {
            _hashCode += getN_copies().hashCode();
        }
        if (getActive() != null) {
            _hashCode += getActive().hashCode();
        }
        if (getAuthorized() != null) {
            _hashCode += getAuthorized().hashCode();
        }
        if (getItem_identifier() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getItem_identifier());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getItem_identifier(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDelete() != null) {
            _hashCode += getDelete().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Group_member_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">group_member_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("delete");
        attrField.setXmlName(new javax.xml.namespace.QName("", "delete"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZBoolean"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_group_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_group_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("n_copies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "n_copies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorized");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "authorized"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("item_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "item_identifier"));
        elemField.setMinOccurs(0);
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
