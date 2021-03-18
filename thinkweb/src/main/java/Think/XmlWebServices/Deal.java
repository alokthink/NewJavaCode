/**
 * Deal.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Deal  extends Think.XmlWebServices.ZZDeal  implements java.io.Serializable {
    private Think.XmlWebServices.ZZDealOrderCode[] deal_order_code;

    private Think.XmlWebServices.ZZDealOrderingCustomer[] deal_ordering_customer;

    public Deal() {
    }

    public Deal(
           int deal_id,
           int customer_id,
           java.lang.String deal,
           int deal_ord_cust_required,
           java.lang.String deal_status,
           java.lang.String deal_type,
           java.lang.String description,
           java.util.Date end_date,
           java.util.Date start_date,
           Think.XmlWebServices.ZZDealOrderCode[] deal_order_code,
           Think.XmlWebServices.ZZDealOrderingCustomer[] deal_ordering_customer) {
        super(
            deal_id,
            customer_id,
            deal,
            deal_ord_cust_required,
            deal_status,
            deal_type,
            description,
            end_date,
            start_date);
        this.deal_order_code = deal_order_code;
        this.deal_ordering_customer = deal_ordering_customer;
    }


    /**
     * Gets the deal_order_code value for this Deal.
     * 
     * @return deal_order_code
     */
    public Think.XmlWebServices.ZZDealOrderCode[] getDeal_order_code() {
        return deal_order_code;
    }


    /**
     * Sets the deal_order_code value for this Deal.
     * 
     * @param deal_order_code
     */
    public void setDeal_order_code(Think.XmlWebServices.ZZDealOrderCode[] deal_order_code) {
        this.deal_order_code = deal_order_code;
    }

    public Think.XmlWebServices.ZZDealOrderCode getDeal_order_code(int i) {
        return this.deal_order_code[i];
    }

    public void setDeal_order_code(int i, Think.XmlWebServices.ZZDealOrderCode _value) {
        this.deal_order_code[i] = _value;
    }


    /**
     * Gets the deal_ordering_customer value for this Deal.
     * 
     * @return deal_ordering_customer
     */
    public Think.XmlWebServices.ZZDealOrderingCustomer[] getDeal_ordering_customer() {
        return deal_ordering_customer;
    }


    /**
     * Sets the deal_ordering_customer value for this Deal.
     * 
     * @param deal_ordering_customer
     */
    public void setDeal_ordering_customer(Think.XmlWebServices.ZZDealOrderingCustomer[] deal_ordering_customer) {
        this.deal_ordering_customer = deal_ordering_customer;
    }

    public Think.XmlWebServices.ZZDealOrderingCustomer getDeal_ordering_customer(int i) {
        return this.deal_ordering_customer[i];
    }

    public void setDeal_ordering_customer(int i, Think.XmlWebServices.ZZDealOrderingCustomer _value) {
        this.deal_ordering_customer[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Deal)) return false;
        Deal other = (Deal) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.deal_order_code==null && other.getDeal_order_code()==null) || 
             (this.deal_order_code!=null &&
              java.util.Arrays.equals(this.deal_order_code, other.getDeal_order_code()))) &&
            ((this.deal_ordering_customer==null && other.getDeal_ordering_customer()==null) || 
             (this.deal_ordering_customer!=null &&
              java.util.Arrays.equals(this.deal_ordering_customer, other.getDeal_ordering_customer())));
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
        if (getDeal_order_code() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeal_order_code());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeal_order_code(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeal_ordering_customer() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeal_ordering_customer());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeal_ordering_customer(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Deal.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">deal"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_order_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_order_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_order_code"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_ordering_customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_ordering_customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_ordering_customer"));
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
