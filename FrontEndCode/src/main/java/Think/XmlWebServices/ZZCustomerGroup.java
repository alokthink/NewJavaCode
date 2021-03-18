/**
 * ZZCustomerGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZCustomerGroup  implements java.io.Serializable {
    private int customer_id;  // attribute

    private int back_issue_ship_type;  // attribute

    private int bill_to_customer_address_seq;  // attribute

    private int bill_to_customer_id;  // attribute

    private java.util.Calendar creation_date;  // attribute

    private int customer_address_seq;  // attribute

    private java.lang.String customer_group;  // attribute

    private java.lang.String description;  // attribute

    private int fte_cnt_added;  // attribute

    private int fte_cnt_avail;  // attribute

    private int fte_count;  // attribute

    private int fte_grace_cnt;  // attribute

    private int fte_grace_pct;  // attribute

    private int new_group_member_action;  // attribute

    private int renew_to_customer_address_seq;  // attribute

    private int renew_to_customer_id;  // attribute

    private int rep_customer_address_seq;  // attribute

    private int rep_customer_id;  // attribute

    private int ship_type;  // attribute

    public ZZCustomerGroup() {
    }

    public ZZCustomerGroup(
           int customer_id,
           int back_issue_ship_type,
           int bill_to_customer_address_seq,
           int bill_to_customer_id,
           java.util.Calendar creation_date,
           int customer_address_seq,
           java.lang.String customer_group,
           java.lang.String description,
           int fte_cnt_added,
           int fte_cnt_avail,
           int fte_count,
           int fte_grace_cnt,
           int fte_grace_pct,
           int new_group_member_action,
           int renew_to_customer_address_seq,
           int renew_to_customer_id,
           int rep_customer_address_seq,
           int rep_customer_id,
           int ship_type) {
           this.customer_id = customer_id;
           this.back_issue_ship_type = back_issue_ship_type;
           this.bill_to_customer_address_seq = bill_to_customer_address_seq;
           this.bill_to_customer_id = bill_to_customer_id;
           this.creation_date = creation_date;
           this.customer_address_seq = customer_address_seq;
           this.customer_group = customer_group;
           this.description = description;
           this.fte_cnt_added = fte_cnt_added;
           this.fte_cnt_avail = fte_cnt_avail;
           this.fte_count = fte_count;
           this.fte_grace_cnt = fte_grace_cnt;
           this.fte_grace_pct = fte_grace_pct;
           this.new_group_member_action = new_group_member_action;
           this.renew_to_customer_address_seq = renew_to_customer_address_seq;
           this.renew_to_customer_id = renew_to_customer_id;
           this.rep_customer_address_seq = rep_customer_address_seq;
           this.rep_customer_id = rep_customer_id;
           this.ship_type = ship_type;
    }


    /**
     * Gets the customer_id value for this ZZCustomerGroup.
     * 
     * @return customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this ZZCustomerGroup.
     * 
     * @param customer_id
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the back_issue_ship_type value for this ZZCustomerGroup.
     * 
     * @return back_issue_ship_type
     */
    public int getBack_issue_ship_type() {
        return back_issue_ship_type;
    }


    /**
     * Sets the back_issue_ship_type value for this ZZCustomerGroup.
     * 
     * @param back_issue_ship_type
     */
    public void setBack_issue_ship_type(int back_issue_ship_type) {
        this.back_issue_ship_type = back_issue_ship_type;
    }


    /**
     * Gets the bill_to_customer_address_seq value for this ZZCustomerGroup.
     * 
     * @return bill_to_customer_address_seq
     */
    public int getBill_to_customer_address_seq() {
        return bill_to_customer_address_seq;
    }


    /**
     * Sets the bill_to_customer_address_seq value for this ZZCustomerGroup.
     * 
     * @param bill_to_customer_address_seq
     */
    public void setBill_to_customer_address_seq(int bill_to_customer_address_seq) {
        this.bill_to_customer_address_seq = bill_to_customer_address_seq;
    }


    /**
     * Gets the bill_to_customer_id value for this ZZCustomerGroup.
     * 
     * @return bill_to_customer_id
     */
    public int getBill_to_customer_id() {
        return bill_to_customer_id;
    }


    /**
     * Sets the bill_to_customer_id value for this ZZCustomerGroup.
     * 
     * @param bill_to_customer_id
     */
    public void setBill_to_customer_id(int bill_to_customer_id) {
        this.bill_to_customer_id = bill_to_customer_id;
    }


    /**
     * Gets the creation_date value for this ZZCustomerGroup.
     * 
     * @return creation_date
     */
    public java.util.Calendar getCreation_date() {
        return creation_date;
    }


    /**
     * Sets the creation_date value for this ZZCustomerGroup.
     * 
     * @param creation_date
     */
    public void setCreation_date(java.util.Calendar creation_date) {
        this.creation_date = creation_date;
    }


    /**
     * Gets the customer_address_seq value for this ZZCustomerGroup.
     * 
     * @return customer_address_seq
     */
    public int getCustomer_address_seq() {
        return customer_address_seq;
    }


    /**
     * Sets the customer_address_seq value for this ZZCustomerGroup.
     * 
     * @param customer_address_seq
     */
    public void setCustomer_address_seq(int customer_address_seq) {
        this.customer_address_seq = customer_address_seq;
    }


    /**
     * Gets the customer_group value for this ZZCustomerGroup.
     * 
     * @return customer_group
     */
    public java.lang.String getCustomer_group() {
        return customer_group;
    }


    /**
     * Sets the customer_group value for this ZZCustomerGroup.
     * 
     * @param customer_group
     */
    public void setCustomer_group(java.lang.String customer_group) {
        this.customer_group = customer_group;
    }


    /**
     * Gets the description value for this ZZCustomerGroup.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ZZCustomerGroup.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the fte_cnt_added value for this ZZCustomerGroup.
     * 
     * @return fte_cnt_added
     */
    public int getFte_cnt_added() {
        return fte_cnt_added;
    }


    /**
     * Sets the fte_cnt_added value for this ZZCustomerGroup.
     * 
     * @param fte_cnt_added
     */
    public void setFte_cnt_added(int fte_cnt_added) {
        this.fte_cnt_added = fte_cnt_added;
    }


    /**
     * Gets the fte_cnt_avail value for this ZZCustomerGroup.
     * 
     * @return fte_cnt_avail
     */
    public int getFte_cnt_avail() {
        return fte_cnt_avail;
    }


    /**
     * Sets the fte_cnt_avail value for this ZZCustomerGroup.
     * 
     * @param fte_cnt_avail
     */
    public void setFte_cnt_avail(int fte_cnt_avail) {
        this.fte_cnt_avail = fte_cnt_avail;
    }


    /**
     * Gets the fte_count value for this ZZCustomerGroup.
     * 
     * @return fte_count
     */
    public int getFte_count() {
        return fte_count;
    }


    /**
     * Sets the fte_count value for this ZZCustomerGroup.
     * 
     * @param fte_count
     */
    public void setFte_count(int fte_count) {
        this.fte_count = fte_count;
    }


    /**
     * Gets the fte_grace_cnt value for this ZZCustomerGroup.
     * 
     * @return fte_grace_cnt
     */
    public int getFte_grace_cnt() {
        return fte_grace_cnt;
    }


    /**
     * Sets the fte_grace_cnt value for this ZZCustomerGroup.
     * 
     * @param fte_grace_cnt
     */
    public void setFte_grace_cnt(int fte_grace_cnt) {
        this.fte_grace_cnt = fte_grace_cnt;
    }


    /**
     * Gets the fte_grace_pct value for this ZZCustomerGroup.
     * 
     * @return fte_grace_pct
     */
    public int getFte_grace_pct() {
        return fte_grace_pct;
    }


    /**
     * Sets the fte_grace_pct value for this ZZCustomerGroup.
     * 
     * @param fte_grace_pct
     */
    public void setFte_grace_pct(int fte_grace_pct) {
        this.fte_grace_pct = fte_grace_pct;
    }


    /**
     * Gets the new_group_member_action value for this ZZCustomerGroup.
     * 
     * @return new_group_member_action
     */
    public int getNew_group_member_action() {
        return new_group_member_action;
    }


    /**
     * Sets the new_group_member_action value for this ZZCustomerGroup.
     * 
     * @param new_group_member_action
     */
    public void setNew_group_member_action(int new_group_member_action) {
        this.new_group_member_action = new_group_member_action;
    }


    /**
     * Gets the renew_to_customer_address_seq value for this ZZCustomerGroup.
     * 
     * @return renew_to_customer_address_seq
     */
    public int getRenew_to_customer_address_seq() {
        return renew_to_customer_address_seq;
    }


    /**
     * Sets the renew_to_customer_address_seq value for this ZZCustomerGroup.
     * 
     * @param renew_to_customer_address_seq
     */
    public void setRenew_to_customer_address_seq(int renew_to_customer_address_seq) {
        this.renew_to_customer_address_seq = renew_to_customer_address_seq;
    }


    /**
     * Gets the renew_to_customer_id value for this ZZCustomerGroup.
     * 
     * @return renew_to_customer_id
     */
    public int getRenew_to_customer_id() {
        return renew_to_customer_id;
    }


    /**
     * Sets the renew_to_customer_id value for this ZZCustomerGroup.
     * 
     * @param renew_to_customer_id
     */
    public void setRenew_to_customer_id(int renew_to_customer_id) {
        this.renew_to_customer_id = renew_to_customer_id;
    }


    /**
     * Gets the rep_customer_address_seq value for this ZZCustomerGroup.
     * 
     * @return rep_customer_address_seq
     */
    public int getRep_customer_address_seq() {
        return rep_customer_address_seq;
    }


    /**
     * Sets the rep_customer_address_seq value for this ZZCustomerGroup.
     * 
     * @param rep_customer_address_seq
     */
    public void setRep_customer_address_seq(int rep_customer_address_seq) {
        this.rep_customer_address_seq = rep_customer_address_seq;
    }


    /**
     * Gets the rep_customer_id value for this ZZCustomerGroup.
     * 
     * @return rep_customer_id
     */
    public int getRep_customer_id() {
        return rep_customer_id;
    }


    /**
     * Sets the rep_customer_id value for this ZZCustomerGroup.
     * 
     * @param rep_customer_id
     */
    public void setRep_customer_id(int rep_customer_id) {
        this.rep_customer_id = rep_customer_id;
    }


    /**
     * Gets the ship_type value for this ZZCustomerGroup.
     * 
     * @return ship_type
     */
    public int getShip_type() {
        return ship_type;
    }


    /**
     * Sets the ship_type value for this ZZCustomerGroup.
     * 
     * @param ship_type
     */
    public void setShip_type(int ship_type) {
        this.ship_type = ship_type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZCustomerGroup)) return false;
        ZZCustomerGroup other = (ZZCustomerGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.customer_id == other.getCustomer_id() &&
            this.back_issue_ship_type == other.getBack_issue_ship_type() &&
            this.bill_to_customer_address_seq == other.getBill_to_customer_address_seq() &&
            this.bill_to_customer_id == other.getBill_to_customer_id() &&
            ((this.creation_date==null && other.getCreation_date()==null) || 
             (this.creation_date!=null &&
              this.creation_date.equals(other.getCreation_date()))) &&
            this.customer_address_seq == other.getCustomer_address_seq() &&
            ((this.customer_group==null && other.getCustomer_group()==null) || 
             (this.customer_group!=null &&
              this.customer_group.equals(other.getCustomer_group()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            this.fte_cnt_added == other.getFte_cnt_added() &&
            this.fte_cnt_avail == other.getFte_cnt_avail() &&
            this.fte_count == other.getFte_count() &&
            this.fte_grace_cnt == other.getFte_grace_cnt() &&
            this.fte_grace_pct == other.getFte_grace_pct() &&
            this.new_group_member_action == other.getNew_group_member_action() &&
            this.renew_to_customer_address_seq == other.getRenew_to_customer_address_seq() &&
            this.renew_to_customer_id == other.getRenew_to_customer_id() &&
            this.rep_customer_address_seq == other.getRep_customer_address_seq() &&
            this.rep_customer_id == other.getRep_customer_id() &&
            this.ship_type == other.getShip_type();
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
        _hashCode += getBack_issue_ship_type();
        _hashCode += getBill_to_customer_address_seq();
        _hashCode += getBill_to_customer_id();
        if (getCreation_date() != null) {
            _hashCode += getCreation_date().hashCode();
        }
        _hashCode += getCustomer_address_seq();
        if (getCustomer_group() != null) {
            _hashCode += getCustomer_group().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += getFte_cnt_added();
        _hashCode += getFte_cnt_avail();
        _hashCode += getFte_count();
        _hashCode += getFte_grace_cnt();
        _hashCode += getFte_grace_pct();
        _hashCode += getNew_group_member_action();
        _hashCode += getRenew_to_customer_address_seq();
        _hashCode += getRenew_to_customer_id();
        _hashCode += getRep_customer_address_seq();
        _hashCode += getRep_customer_id();
        _hashCode += getShip_type();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZCustomerGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZCustomerGroup"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("back_issue_ship_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "back_issue_ship_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_to_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_to_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("bill_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "bill_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("creation_date");
        attrField.setXmlName(new javax.xml.namespace.QName("", "creation_date"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("customer_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "customer_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fte_cnt_added");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fte_cnt_added"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fte_cnt_avail");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fte_cnt_avail"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fte_count");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fte_count"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fte_grace_cnt");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fte_grace_cnt"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("fte_grace_pct");
        attrField.setXmlName(new javax.xml.namespace.QName("", "fte_grace_pct"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("new_group_member_action");
        attrField.setXmlName(new javax.xml.namespace.QName("", "new_group_member_action"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renew_to_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renew_to_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("renew_to_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "renew_to_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rep_customer_address_seq");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rep_customer_address_seq"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rep_customer_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rep_customer_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ship_type");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ship_type"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
