/**
 * Deal_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Deal_data  implements java.io.Serializable {
    private java.lang.String deal;

    private java.lang.String description;

    private java.lang.String deal_type;

    private java.lang.String deal_status;

    private Think.XmlWebServices.Customer_identifier customer_identifier;

    private java.util.Date start_date;

    private java.util.Date end_date;

    private boolean deal_ord_cust_required;

    private Think.XmlWebServices.Deal_order_code_data[] deal_order_code_datas;

    private Think.XmlWebServices.Deal_ordering_customer_data[] deal_ordering_customer_datas;

    public Deal_data() {
    }

    public Deal_data(
           java.lang.String deal,
           java.lang.String description,
           java.lang.String deal_type,
           java.lang.String deal_status,
           Think.XmlWebServices.Customer_identifier customer_identifier,
           java.util.Date start_date,
           java.util.Date end_date,
           boolean deal_ord_cust_required,
           Think.XmlWebServices.Deal_order_code_data[] deal_order_code_datas,
           Think.XmlWebServices.Deal_ordering_customer_data[] deal_ordering_customer_datas) {
           this.deal = deal;
           this.description = description;
           this.deal_type = deal_type;
           this.deal_status = deal_status;
           this.customer_identifier = customer_identifier;
           this.start_date = start_date;
           this.end_date = end_date;
           this.deal_ord_cust_required = deal_ord_cust_required;
           this.deal_order_code_datas = deal_order_code_datas;
           this.deal_ordering_customer_datas = deal_ordering_customer_datas;
    }


    /**
     * Gets the deal value for this Deal_data.
     * 
     * @return deal
     */
    public java.lang.String getDeal() {
        return deal;
    }


    /**
     * Sets the deal value for this Deal_data.
     * 
     * @param deal
     */
    public void setDeal(java.lang.String deal) {
        this.deal = deal;
    }


    /**
     * Gets the description value for this Deal_data.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Deal_data.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the deal_type value for this Deal_data.
     * 
     * @return deal_type
     */
    public java.lang.String getDeal_type() {
        return deal_type;
    }


    /**
     * Sets the deal_type value for this Deal_data.
     * 
     * @param deal_type
     */
    public void setDeal_type(java.lang.String deal_type) {
        this.deal_type = deal_type;
    }


    /**
     * Gets the deal_status value for this Deal_data.
     * 
     * @return deal_status
     */
    public java.lang.String getDeal_status() {
        return deal_status;
    }


    /**
     * Sets the deal_status value for this Deal_data.
     * 
     * @param deal_status
     */
    public void setDeal_status(java.lang.String deal_status) {
        this.deal_status = deal_status;
    }


    /**
     * Gets the customer_identifier value for this Deal_data.
     * 
     * @return customer_identifier
     */
    public Think.XmlWebServices.Customer_identifier getCustomer_identifier() {
        return customer_identifier;
    }


    /**
     * Sets the customer_identifier value for this Deal_data.
     * 
     * @param customer_identifier
     */
    public void setCustomer_identifier(Think.XmlWebServices.Customer_identifier customer_identifier) {
        this.customer_identifier = customer_identifier;
    }


    /**
     * Gets the start_date value for this Deal_data.
     * 
     * @return start_date
     */
    public java.util.Date getStart_date() {
        return start_date;
    }


    /**
     * Sets the start_date value for this Deal_data.
     * 
     * @param start_date
     */
    public void setStart_date(java.util.Date start_date) {
        this.start_date = start_date;
    }


    /**
     * Gets the end_date value for this Deal_data.
     * 
     * @return end_date
     */
    public java.util.Date getEnd_date() {
        return end_date;
    }


    /**
     * Sets the end_date value for this Deal_data.
     * 
     * @param end_date
     */
    public void setEnd_date(java.util.Date end_date) {
        this.end_date = end_date;
    }


    /**
     * Gets the deal_ord_cust_required value for this Deal_data.
     * 
     * @return deal_ord_cust_required
     */
    public boolean isDeal_ord_cust_required() {
        return deal_ord_cust_required;
    }


    /**
     * Sets the deal_ord_cust_required value for this Deal_data.
     * 
     * @param deal_ord_cust_required
     */
    public void setDeal_ord_cust_required(boolean deal_ord_cust_required) {
        this.deal_ord_cust_required = deal_ord_cust_required;
    }


    /**
     * Gets the deal_order_code_datas value for this Deal_data.
     * 
     * @return deal_order_code_datas
     */
    public Think.XmlWebServices.Deal_order_code_data[] getDeal_order_code_datas() {
        return deal_order_code_datas;
    }


    /**
     * Sets the deal_order_code_datas value for this Deal_data.
     * 
     * @param deal_order_code_datas
     */
    public void setDeal_order_code_datas(Think.XmlWebServices.Deal_order_code_data[] deal_order_code_datas) {
        this.deal_order_code_datas = deal_order_code_datas;
    }


    /**
     * Gets the deal_ordering_customer_datas value for this Deal_data.
     * 
     * @return deal_ordering_customer_datas
     */
    public Think.XmlWebServices.Deal_ordering_customer_data[] getDeal_ordering_customer_datas() {
        return deal_ordering_customer_datas;
    }


    /**
     * Sets the deal_ordering_customer_datas value for this Deal_data.
     * 
     * @param deal_ordering_customer_datas
     */
    public void setDeal_ordering_customer_datas(Think.XmlWebServices.Deal_ordering_customer_data[] deal_ordering_customer_datas) {
        this.deal_ordering_customer_datas = deal_ordering_customer_datas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Deal_data)) return false;
        Deal_data other = (Deal_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deal==null && other.getDeal()==null) || 
             (this.deal!=null &&
              this.deal.equals(other.getDeal()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.deal_type==null && other.getDeal_type()==null) || 
             (this.deal_type!=null &&
              this.deal_type.equals(other.getDeal_type()))) &&
            ((this.deal_status==null && other.getDeal_status()==null) || 
             (this.deal_status!=null &&
              this.deal_status.equals(other.getDeal_status()))) &&
            ((this.customer_identifier==null && other.getCustomer_identifier()==null) || 
             (this.customer_identifier!=null &&
              this.customer_identifier.equals(other.getCustomer_identifier()))) &&
            ((this.start_date==null && other.getStart_date()==null) || 
             (this.start_date!=null &&
              this.start_date.equals(other.getStart_date()))) &&
            ((this.end_date==null && other.getEnd_date()==null) || 
             (this.end_date!=null &&
              this.end_date.equals(other.getEnd_date()))) &&
            this.deal_ord_cust_required == other.isDeal_ord_cust_required() &&
            ((this.deal_order_code_datas==null && other.getDeal_order_code_datas()==null) || 
             (this.deal_order_code_datas!=null &&
              java.util.Arrays.equals(this.deal_order_code_datas, other.getDeal_order_code_datas()))) &&
            ((this.deal_ordering_customer_datas==null && other.getDeal_ordering_customer_datas()==null) || 
             (this.deal_ordering_customer_datas!=null &&
              java.util.Arrays.equals(this.deal_ordering_customer_datas, other.getDeal_ordering_customer_datas())));
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
        if (getDeal() != null) {
            _hashCode += getDeal().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDeal_type() != null) {
            _hashCode += getDeal_type().hashCode();
        }
        if (getDeal_status() != null) {
            _hashCode += getDeal_status().hashCode();
        }
        if (getCustomer_identifier() != null) {
            _hashCode += getCustomer_identifier().hashCode();
        }
        if (getStart_date() != null) {
            _hashCode += getStart_date().hashCode();
        }
        if (getEnd_date() != null) {
            _hashCode += getEnd_date().hashCode();
        }
        _hashCode += (isDeal_ord_cust_required() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDeal_order_code_datas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeal_order_code_datas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeal_order_code_datas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDeal_ordering_customer_datas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeal_ordering_customer_datas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeal_ordering_customer_datas(), i);
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
        new org.apache.axis.description.TypeDesc(Deal_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">deal_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "customer_identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_identifier"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "start_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("end_date");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "end_date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_ord_cust_required");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_ord_cust_required"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_order_code_datas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_order_code_datas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_order_code_data"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deal_ordering_customer_datas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_ordering_customer_datas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "deal_ordering_customer_data"));
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
