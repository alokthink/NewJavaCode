/**
 * Td_customer_group.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_customer_group  extends Think.XmlWebServices.ZZCustomerGroup  implements java.io.Serializable {
    private java.lang.String ship_type_descr;  // attribute

    private java.lang.String back_issue_ship_type_descr;  // attribute

    private java.lang.String new_group_member_action_descr;  // attribute

    public Td_customer_group() {
    }

    public Td_customer_group(
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
           int ship_type,
           java.lang.String ship_type_descr,
           java.lang.String back_issue_ship_type_descr,
           java.lang.String new_group_member_action_descr) {
        super(
            customer_id,
            back_issue_ship_type,
            bill_to_customer_address_seq,
            bill_to_customer_id,
            creation_date,
            customer_address_seq,
            customer_group,
            description,
            fte_cnt_added,
            fte_cnt_avail,
            fte_count,
            fte_grace_cnt,
            fte_grace_pct,
            new_group_member_action,
            renew_to_customer_address_seq,
            renew_to_customer_id,
            rep_customer_address_seq,
            rep_customer_id,
            ship_type);
        this.ship_type_descr = ship_type_descr;
        this.back_issue_ship_type_descr = back_issue_ship_type_descr;
        this.new_group_member_action_descr = new_group_member_action_descr;
    }


    /**
     * Gets the ship_type_descr value for this Td_customer_group.
     * 
     * @return ship_type_descr
     */
    public java.lang.String getShip_type_descr() {
        return ship_type_descr;
    }


    /**
     * Sets the ship_type_descr value for this Td_customer_group.
     * 
     * @param ship_type_descr
     */
    public void setShip_type_descr(java.lang.String ship_type_descr) {
        this.ship_type_descr = ship_type_descr;
    }


    /**
     * Gets the back_issue_ship_type_descr value for this Td_customer_group.
     * 
     * @return back_issue_ship_type_descr
     */
    public java.lang.String getBack_issue_ship_type_descr() {
        return back_issue_ship_type_descr;
    }


    /**
     * Sets the back_issue_ship_type_descr value for this Td_customer_group.
     * 
     * @param back_issue_ship_type_descr
     */
    public void setBack_issue_ship_type_descr(java.lang.String back_issue_ship_type_descr) {
        this.back_issue_ship_type_descr = back_issue_ship_type_descr;
    }


    /**
     * Gets the new_group_member_action_descr value for this Td_customer_group.
     * 
     * @return new_group_member_action_descr
     */
    public java.lang.String getNew_group_member_action_descr() {
        return new_group_member_action_descr;
    }


    /**
     * Sets the new_group_member_action_descr value for this Td_customer_group.
     * 
     * @param new_group_member_action_descr
     */
    public void setNew_group_member_action_descr(java.lang.String new_group_member_action_descr) {
        this.new_group_member_action_descr = new_group_member_action_descr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_customer_group)) return false;
        Td_customer_group other = (Td_customer_group) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ship_type_descr==null && other.getShip_type_descr()==null) || 
             (this.ship_type_descr!=null &&
              this.ship_type_descr.equals(other.getShip_type_descr()))) &&
            ((this.back_issue_ship_type_descr==null && other.getBack_issue_ship_type_descr()==null) || 
             (this.back_issue_ship_type_descr!=null &&
              this.back_issue_ship_type_descr.equals(other.getBack_issue_ship_type_descr()))) &&
            ((this.new_group_member_action_descr==null && other.getNew_group_member_action_descr()==null) || 
             (this.new_group_member_action_descr!=null &&
              this.new_group_member_action_descr.equals(other.getNew_group_member_action_descr())));
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
        if (getShip_type_descr() != null) {
            _hashCode += getShip_type_descr().hashCode();
        }
        if (getBack_issue_ship_type_descr() != null) {
            _hashCode += getBack_issue_ship_type_descr().hashCode();
        }
        if (getNew_group_member_action_descr() != null) {
            _hashCode += getNew_group_member_action_descr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_customer_group.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_customer_group"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("ship_type_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "ship_type_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("back_issue_ship_type_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "back_issue_ship_type_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("new_group_member_action_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "new_group_member_action_descr"));
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
