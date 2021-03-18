/**
 * Transfer_customer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Transfer_customer  extends Think.XmlWebServices.ZZCustomer  implements java.io.Serializable {
    private Think.XmlWebServices.Customer_address[] customer_address;

    private Think.XmlWebServices.Transfer_role_enum transfer_role;  // attribute

    public Transfer_customer() {
    }

    public Transfer_customer(
           int customer_id,
           java.lang.String company,
           java.util.Calendar creation_date,
           java.lang.String credit_status,
           java.lang.String customer_category,
           int def_bill_to_cust_addr_seq,
           int def_renew_to_cust_addr_seq,
           int default_bill_to_customer_id,
           int default_cust_addr_seq,
           int default_renew_to_customer_id,
           java.lang.String email,
           byte[] email_authorization,
           java.lang.String fname,
           int inactive,
           java.lang.String initial_name,
           java.lang.String institutional_identifier,
           java.lang.String list_rental_category,
           java.lang.String lname,
           int nbr_times_issued,
           int oc_id,
           java.lang.String old_customer_id,
           java.lang.String old_email,
           java.lang.String parent_inst_identifier,
           int prospect_only,
           int sales_representative_id,
           java.lang.String salutation,
           java.lang.String suffix,
           java.lang.String title,
           java.lang.String user_code,
           Think.XmlWebServices.Transfer_role_enum transfer_role,
           Think.XmlWebServices.Customer_address[] customer_address) {
        super(
            customer_id,
            company,
            creation_date,
            credit_status,
            customer_category,
            def_bill_to_cust_addr_seq,
            def_renew_to_cust_addr_seq,
            default_bill_to_customer_id,
            default_cust_addr_seq,
            default_renew_to_customer_id,
            email,
            email_authorization,
            fname,
            inactive,
            initial_name,
            institutional_identifier,
            list_rental_category,
            lname,
            nbr_times_issued,
            oc_id,
            old_customer_id,
            old_email,
            parent_inst_identifier,
            prospect_only,
            sales_representative_id,
            salutation,
            suffix,
            title,
            user_code);
        this.transfer_role = transfer_role;
        this.customer_address = customer_address;
    }


    /**
     * Gets the customer_address value for this Transfer_customer.
     * 
     * @return customer_address
     */
    public Think.XmlWebServices.Customer_address[] getCustomer_address() {
        return customer_address;
    }


    /**
     * Sets the customer_address value for this Transfer_customer.
     * 
     * @param customer_address
     */
    public void setCustomer_address(Think.XmlWebServices.Customer_address[] customer_address) {
        this.customer_address = customer_address;
    }

    public Think.XmlWebServices.Customer_address getCustomer_address(int i) {
        return this.customer_address[i];
    }

    public void setCustomer_address(int i, Think.XmlWebServices.Customer_address _value) {
        this.customer_address[i] = _value;
    }


    /**
     * Gets the transfer_role value for this Transfer_customer.
     * 
     * @return transfer_role
     */
    public Think.XmlWebServices.Transfer_role_enum getTransfer_role() {
        return transfer_role;
    }


    /**
     * Sets the transfer_role value for this Transfer_customer.
     * 
     * @param transfer_role
     */
    public void setTransfer_role(Think.XmlWebServices.Transfer_role_enum transfer_role) {
        this.transfer_role = transfer_role;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Transfer_customer)) return false;
        Transfer_customer other = (Transfer_customer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customer_address==null && other.getCustomer_address()==null) || 
             (this.customer_address!=null &&
              java.util.Arrays.equals(this.customer_address, other.getCustomer_address()))) &&
            ((this.transfer_role==null && other.getTransfer_role()==null) || 
             (this.transfer_role!=null &&
              this.transfer_role.equals(other.getTransfer_role())));
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
        if (getCustomer_address() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCustomer_address());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCustomer_address(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTransfer_role() != null) {
            _hashCode += getTransfer_role().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Transfer_customer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">transfer_customer"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("transfer_role");
        attrField.setXmlName(new javax.xml.namespace.QName("", "transfer_role"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "transfer_role_enum"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_address"));
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
