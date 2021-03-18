/**
 * Transfer_item_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Transfer_item_identifier  extends Think.XmlWebServices.ZZItemIdentifier  implements java.io.Serializable {
    private java.lang.Integer customer_id;

    private java.lang.Integer customer_address_seq;

    private java.lang.Integer bill_to_customer_id;

    private java.lang.Integer bill_to_customer_address_seq;

    private java.lang.Integer renew_to_customer_id;

    private java.lang.Integer renew_to_customer_address_seq;

    public Transfer_item_identifier() {
    }

    public Transfer_item_identifier(
           Think.XmlWebServices.ZZBoolean send_back_issues,
           int orderhdr_id,
           int order_item_seq,
           java.lang.Integer customer_id,
           java.lang.Integer customer_address_seq,
           java.lang.Integer bill_to_customer_id,
           java.lang.Integer bill_to_customer_address_seq,
           java.lang.Integer renew_to_customer_id,
           java.lang.Integer renew_to_customer_address_seq) {
        /*super(
            send_back_issues,
            orderhdr_id,
            order_item_seq);*/
        this.customer_id = customer_id;
        this.customer_address_seq = customer_address_seq;
        this.bill_to_customer_id = bill_to_customer_id;
        this.bill_to_customer_address_seq = bill_to_customer_address_seq;
        this.renew_to_customer_id = renew_to_customer_id;
        this.renew_to_customer_address_seq = renew_to_customer_address_seq;
    }


    /**
     * Gets the customer_id value for this Transfer_item_identifier.
     * 
     * @return customer_id
     */
    public java.lang.Integer getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Transfer_item_identifier.
     * 
     * @param customer_id
     */
    public void setCustomer_id(java.lang.Integer customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the customer_address_seq value for this Transfer_item_identifier.
     * 
     * @return customer_address_seq
     */
    public java.lang.Integer getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this Transfer_item_identifier.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(java.lang.Integer customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the bill_to_customer_id value for this Transfer_item_identifier.
     * 
     * @return bill_to_customer_id
     */
    public java.lang.Integer getBill_to_customer_id() {
        return bill_to_customer_id;
    }


    /**
     * Sets the bill_to_customer_id value for this Transfer_item_identifier.
     * 
     * @param bill_to_customer_id
     */
    public void setBill_to_customer_id(java.lang.Integer bill_to_customer_id) {
        this.bill_to_customer_id = bill_to_customer_id;
    }


    /**
     * Gets the bill_to_customer_address_seq value for this Transfer_item_identifier.
     * 
     * @return bill_to_customer_address_seq
     */
    public java.lang.Integer getBill_to_customer_address_seq() {
        return bill_to_customer_address_seq;
    }


    /**
     * Sets the bill_to_customer_address_seq value for this Transfer_item_identifier.
     * 
     * @param bill_to_customer_address_seq
     */
    public void setBill_to_customer_address_seq(java.lang.Integer bill_to_customer_address_seq) {
        this.bill_to_customer_address_seq = bill_to_customer_address_seq;
    }


    /**
     * Gets the renew_to_customer_id value for this Transfer_item_identifier.
     * 
     * @return renew_to_customer_id
     */
    public java.lang.Integer getRenew_to_customer_id() {
        return renew_to_customer_id;
    }


    /**
     * Sets the renew_to_customer_id value for this Transfer_item_identifier.
     * 
     * @param renew_to_customer_id
     */
    public void setRenew_to_customer_id(java.lang.Integer renew_to_customer_id) {
        this.renew_to_customer_id = renew_to_customer_id;
    }


    /**
     * Gets the renew_to_customer_address_seq value for this Transfer_item_identifier.
     * 
     * @return renew_to_customer_address_seq
     */
    public java.lang.Integer getRenew_to_customer_address_seq() {
        return renew_to_customer_address_seq;
    }


    /**
     * Sets the renew_to_customer_address_seq value for this Transfer_item_identifier.
     * 
     * @param renew_to_customer_address_seq
     */
    public void setRenew_to_customer_address_seq(java.lang.Integer renew_to_customer_address_seq) {
        this.renew_to_customer_address_seq = renew_to_customer_address_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Transfer_item_identifier)) return false;
        Transfer_item_identifier other = (Transfer_item_identifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customer_id==null && other.getCustomer_id()==null) || 
             (this.customer_id!=null &&
              this.customer_id.equals(other.getCustomer_id()))) &&
            ((this.customer_address_seq==null && other.getCustomer_address_seq()==null) || 
             (this.customer_address_seq!=null &&
              this.customer_address_seq.equals(other.getCustomer_address_seq()))) &&
            ((this.bill_to_customer_id==null && other.getBill_to_customer_id()==null) || 
             (this.bill_to_customer_id!=null &&
              this.bill_to_customer_id.equals(other.getBill_to_customer_id()))) &&
            ((this.bill_to_customer_address_seq==null && other.getBill_to_customer_address_seq()==null) || 
             (this.bill_to_customer_address_seq!=null &&
              this.bill_to_customer_address_seq.equals(other.getBill_to_customer_address_seq()))) &&
            ((this.renew_to_customer_id==null && other.getRenew_to_customer_id()==null) || 
             (this.renew_to_customer_id!=null &&
              this.renew_to_customer_id.equals(other.getRenew_to_customer_id()))) &&
            ((this.renew_to_customer_address_seq==null && other.getRenew_to_customer_address_seq()==null) || 
             (this.renew_to_customer_address_seq!=null &&
              this.renew_to_customer_address_seq.equals(other.getRenew_to_customer_address_seq())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCustomer_id() != null) {
            _hashCode += getCustomer_id().hashCode();
        }
        if (getCustomer_address_seq() != null) {
            _hashCode += getCustomer_address_seq().hashCode();
        }
        if (getBill_to_customer_id() != null) {
            _hashCode += getBill_to_customer_id().hashCode();
        }
        if (getBill_to_customer_address_seq() != null) {
            _hashCode += getBill_to_customer_address_seq().hashCode();
        }
        if (getRenew_to_customer_id() != null) {
            _hashCode += getRenew_to_customer_id().hashCode();
        }
        if (getRenew_to_customer_address_seq() != null) {
            _hashCode += getRenew_to_customer_address_seq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Transfer_item_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">transfer_item_identifier"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("bill_to_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bill_to_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_to_customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "bill_to_customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renew_to_customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renew_to_customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renew_to_customer_address_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "renew_to_customer_address_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
