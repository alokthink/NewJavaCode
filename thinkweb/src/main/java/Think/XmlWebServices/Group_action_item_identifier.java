/**
 * Group_action_item_identifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Group_action_item_identifier  extends Think.XmlWebServices.ZZItemIdentifier  implements java.io.Serializable {
    private int new_group_member_action;  // attribute

    public Group_action_item_identifier() {
    }

    public Group_action_item_identifier(
           Think.XmlWebServices.ZZBoolean send_back_issues,
           int orderhdr_id,
           int order_item_seq,
           int new_group_member_action) {
       /* super(
            send_back_issues,
            orderhdr_id,
            order_item_seq);*/
        this.new_group_member_action = new_group_member_action;
    }


    /**
     * Gets the new_group_member_action value for this Group_action_item_identifier.
     * 
     * @return new_group_member_action
     */
    public int getNew_group_member_action() {
        return new_group_member_action;
    }


    /**
     * Sets the new_group_member_action value for this Group_action_item_identifier.
     * 
     * @param new_group_member_action
     */
    public void setNew_group_member_action(int new_group_member_action) {
        this.new_group_member_action = new_group_member_action;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Group_action_item_identifier)) return false;
        Group_action_item_identifier other = (Group_action_item_identifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.new_group_member_action == other.getNew_group_member_action();
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
        _hashCode += getNew_group_member_action();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Group_action_item_identifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">group_action_item_identifier"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("new_group_member_action");
        attrField.setXmlName(new javax.xml.namespace.QName("", "new_group_member_action"));
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
