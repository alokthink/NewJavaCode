/**
 * ZZService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZService  implements java.io.Serializable {
    private int customer_id;  // attribute

    private int service_seq;  // attribute

    private java.lang.String cause_code;  // attribute

    private java.lang.String claim_ref_nbr;  // attribute

    private java.lang.String complaint_code;  // attribute

    private java.util.Date complaint_date;  // attribute

    private java.util.Date followup_date;  // attribute

    private int order_item_seq;  // attribute

    private int orderhdr_id;  // attribute

    private java.lang.String service_code;  // attribute

    private java.util.Date service_date;  // attribute

    private int service_status;  // attribute

    private int subscrip_id;  // attribute

    private java.lang.String user_code;  // attribute

    public ZZService() {
    }

    public ZZService(
           int customer_id,
           int service_seq,
           java.lang.String cause_code,
           java.lang.String claim_ref_nbr,
           java.lang.String complaint_code,
           java.util.Date complaint_date,
           java.util.Date followup_date,
           int order_item_seq,
           int orderhdr_id,
           java.lang.String service_code,
           java.util.Date service_date,
           int service_status,
           int subscrip_id,
           java.lang.String user_code) {
           this.customer_id = customer_id;
           this.service_seq = service_seq;
           this.cause_code = cause_code;
           this.claim_ref_nbr = claim_ref_nbr;
           this.complaint_code = complaint_code;
           this.complaint_date = complaint_date;
           this.followup_date = followup_date;
           this.order_item_seq = order_item_seq;
           this.orderhdr_id = orderhdr_id;
           this.service_code = service_code;
           this.service_date = service_date;
           this.service_status = service_status;
           this.subscrip_id = subscrip_id;
           this.user_code = user_code;
    }


    /**
     * Gets the customer_id value for this ZZService.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZService.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the service_seq value for this ZZService.
     * 
     * @return service_seq
     */
    public int getService_seq() {
        return service_seq;
    }


    /**
     * Sets the service_seq value for this ZZService.
     * 
     * @param service_seq
     */
    public void setService_seq(int service_seq) {
        this.service_seq = service_seq;
    }


    /**
     * Gets the cause_code value for this ZZService.
     * 
     * @return cause_code
     */
    public java.lang.String getCause_code() {
        return cause_code;
    }


    /**
     * Sets the cause_code value for this ZZService.
     * 
     * @param cause_code
     */
    public void setCause_code(java.lang.String cause_code) {
        this.cause_code = cause_code;
    }


    /**
     * Gets the claim_ref_nbr value for this ZZService.
     * 
     * @return claim_ref_nbr
     */
    public java.lang.String getClaim_ref_nbr() {
        return claim_ref_nbr;
    }


    /**
     * Sets the claim_ref_nbr value for this ZZService.
     * 
     * @param claim_ref_nbr
     */
    public void setClaim_ref_nbr(java.lang.String claim_ref_nbr) {
        this.claim_ref_nbr = claim_ref_nbr;
    }


    /**
     * Gets the complaint_code value for this ZZService.
     * 
     * @return complaint_code
     */
    public java.lang.String getComplaint_code() {
        return complaint_code;
    }


    /**
     * Sets the complaint_code value for this ZZService.
     * 
     * @param complaint_code
     */
    public void setComplaint_code(java.lang.String complaint_code) {
        this.complaint_code = complaint_code;
    }


    /**
     * Gets the complaint_date value for this ZZService.
     * 
     * @return complaint_date
     */
    public java.util.Date getComplaint_date() {
        return complaint_date;
    }


    /**
     * Sets the complaint_date value for this ZZService.
     * 
     * @param complaint_date
     */
    public void setComplaint_date(java.util.Date complaint_date) {
        this.complaint_date = complaint_date;
    }


    /**
     * Gets the followup_date value for this ZZService.
     * 
     * @return followup_date
     */
    public java.util.Date getFollowup_date() {
        return followup_date;
    }


    /**
     * Sets the followup_date value for this ZZService.
     * 
     * @param followup_date
     */
    public void setFollowup_date(java.util.Date followup_date) {
        this.followup_date = followup_date;
    }


    /**
     * Gets the order_item_seq value for this ZZService.
     * 
     * @return order_item_seq
     */
    public int getOrder_item_seq() {
        return order_item_seq;
    }


    /**
     * Sets the order_item_seq value for this ZZService.
     * 
     * @param order_item_seq
     */
    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }


    /**
     * Gets the orderhdr_id value for this ZZService.
     * 
     * @return orderhdr_id
     */
    public int getOrderhdr_id() {
        return orderhdr_id;
    }


    /**
     * Sets the orderhdr_id value for this ZZService.
     * 
     * @param orderhdr_id
     */
    public void setOrderhdr_id(int orderhdr_id) {
        this.orderhdr_id = orderhdr_id;
    }


    /**
     * Gets the service_code value for this ZZService.
     * 
     * @return service_code
     */
    public java.lang.String getService_code() {
        return service_code;
    }


    /**
     * Sets the service_code value for this ZZService.
     * 
     * @param service_code
     */
    public void setService_code(java.lang.String service_code) {
        this.service_code = service_code;
    }


    /**
     * Gets the service_date value for this ZZService.
     * 
     * @return service_date
     */
    public java.util.Date getService_date() {
        return service_date;
    }


    /**
     * Sets the service_date value for this ZZService.
     * 
     * @param service_date
     */
    public void setService_date(java.util.Date service_date) {
        this.service_date = service_date;
    }


    /**
     * Gets the service_status value for this ZZService.
     * 
     * @return service_status
     */
    public int getService_status() {
        return service_status;
    }


    /**
     * Sets the service_status value for this ZZService.
     * 
     * @param service_status
     */
    public void setService_status(int service_status) {
        this.service_status = service_status;
    }


    /**
     * Gets the subscrip_id value for this ZZService.
     * 
     * @return subscrip_id
     */
    public int getSubscrip_id() {
        return subscrip_id;
    }


    /**
     * Sets the subscrip_id value for this ZZService.
     * 
     * @param subscrip_id
     */
    public void setSubscrip_id(int subscrip_id) {
        this.subscrip_id = subscrip_id;
    }


    /**
     * Gets the user_code value for this ZZService.
     * 
     * @return user_code
     */
    public java.lang.String getUser_code() {
        return user_code;
    }


    /**
     * Sets the user_code value for this ZZService.
     * 
     * @param user_code
     */
    public void setUser_code(java.lang.String user_code) {
        this.user_code = user_code;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZService)) return false;
        ZZService other = (ZZService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_id == other.getCustomer_id() &&
            this.service_seq == other.getService_seq() &&
            ((this.cause_code==null && other.getCause_code()==null) || 
             (this.cause_code!=null &&
              this.cause_code.equals(other.getCause_code()))) &&
            ((this.claim_ref_nbr==null && other.getClaim_ref_nbr()==null) || 
             (this.claim_ref_nbr!=null &&
              this.claim_ref_nbr.equals(other.getClaim_ref_nbr()))) &&
            ((this.complaint_code==null && other.getComplaint_code()==null) || 
             (this.complaint_code!=null &&
              this.complaint_code.equals(other.getComplaint_code()))) &&
            ((this.complaint_date==null && other.getComplaint_date()==null) || 
             (this.complaint_date!=null &&
              this.complaint_date.equals(other.getComplaint_date()))) &&
            ((this.followup_date==null && other.getFollowup_date()==null) || 
             (this.followup_date!=null &&
              this.followup_date.equals(other.getFollowup_date()))) &&
            this.order_item_seq == other.getOrder_item_seq() &&
            this.orderhdr_id == other.getOrderhdr_id() &&
            ((this.service_code==null && other.getService_code()==null) || 
             (this.service_code!=null &&
              this.service_code.equals(other.getService_code()))) &&
            ((this.service_date==null && other.getService_date()==null) || 
             (this.service_date!=null &&
              this.service_date.equals(other.getService_date()))) &&
            this.service_status == other.getService_status() &&
            this.subscrip_id == other.getSubscrip_id() &&
            ((this.user_code==null && other.getUser_code()==null) || 
             (this.user_code!=null &&
              this.user_code.equals(other.getUser_code())));
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
        _hashCode += getCustomer_id();
        _hashCode += getService_seq();
        if (getCause_code() != null) {
            _hashCode += getCause_code().hashCode();
        }
        if (getClaim_ref_nbr() != null) {
            _hashCode += getClaim_ref_nbr().hashCode();
        }
        if (getComplaint_code() != null) {
            _hashCode += getComplaint_code().hashCode();
        }
        if (getComplaint_date() != null) {
            _hashCode += getComplaint_date().hashCode();
        }
        if (getFollowup_date() != null) {
            _hashCode += getFollowup_date().hashCode();
        }
        _hashCode += getOrder_item_seq();
        _hashCode += getOrderhdr_id();
        if (getService_code() != null) {
            _hashCode += getService_code().hashCode();
        }
        if (getService_date() != null) {
            _hashCode += getService_date().hashCode();
        }
        _hashCode += getService_status();
        _hashCode += getSubscrip_id();
        if (getUser_code() != null) {
            _hashCode += getUser_code().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZService"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("cause_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "cause_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("claim_ref_nbr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "claim_ref_nbr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("complaint_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "complaint_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("complaint_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "complaint_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("followup_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "followup_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("order_item_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "order_item_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("orderhdr_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "orderhdr_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("service_status");
        attrField.setXmlName(new javax.xml.namespace.QName("", "service_status"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("subscrip_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "subscrip_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_code");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_code"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
