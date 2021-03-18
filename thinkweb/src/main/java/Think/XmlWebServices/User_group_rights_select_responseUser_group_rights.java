/**
 * User_group_rights_select_responseUser_group_rights.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class User_group_rights_select_responseUser_group_rights  implements java.io.Serializable {
    private java.lang.String user_group;  // attribute

    private int oc_id;  // attribute

    private int report_category_id;  // attribute

    private int right_desc_id;  // attribute

    private java.lang.String oc_desc;  // attribute

    private java.lang.String report_category_desc;  // attribute

    private java.lang.String right_desc;  // attribute

    public User_group_rights_select_responseUser_group_rights() {
    }

    public User_group_rights_select_responseUser_group_rights(
           java.lang.String user_group,
           int oc_id,
           int report_category_id,
           int right_desc_id,
           java.lang.String oc_desc,
           java.lang.String report_category_desc,
           java.lang.String right_desc) {
           this.user_group = user_group;
           this.oc_id = oc_id;
           this.report_category_id = report_category_id;
           this.right_desc_id = right_desc_id;
           this.oc_desc = oc_desc;
           this.report_category_desc = report_category_desc;
           this.right_desc = right_desc;
    }


    /**
     * Gets the user_group value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @return user_group
     */
    public java.lang.String getUser_group() {
        return user_group;
    }


    /**
     * Sets the user_group value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @param user_group
     */
    public void setUser_group(java.lang.String user_group) {
        this.user_group = user_group;
    }


    /**
     * Gets the oc_id value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @return oc_id
     */
    public int getOc_id() {
        return oc_id;
    }


    /**
     * Sets the oc_id value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @param oc_id
     */
    public void setOc_id(int oc_id) {
        this.oc_id = oc_id;
    }


    /**
     * Gets the report_category_id value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @return report_category_id
     */
    public int getReport_category_id() {
        return report_category_id;
    }


    /**
     * Sets the report_category_id value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @param report_category_id
     */
    public void setReport_category_id(int report_category_id) {
        this.report_category_id = report_category_id;
    }


    /**
     * Gets the right_desc_id value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @return right_desc_id
     */
    public int getRight_desc_id() {
        return right_desc_id;
    }


    /**
     * Sets the right_desc_id value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @param right_desc_id
     */
    public void setRight_desc_id(int right_desc_id) {
        this.right_desc_id = right_desc_id;
    }


    /**
     * Gets the oc_desc value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @return oc_desc
     */
    public java.lang.String getOc_desc() {
        return oc_desc;
    }


    /**
     * Sets the oc_desc value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @param oc_desc
     */
    public void setOc_desc(java.lang.String oc_desc) {
        this.oc_desc = oc_desc;
    }


    /**
     * Gets the report_category_desc value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @return report_category_desc
     */
    public java.lang.String getReport_category_desc() {
        return report_category_desc;
    }


    /**
     * Sets the report_category_desc value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @param report_category_desc
     */
    public void setReport_category_desc(java.lang.String report_category_desc) {
        this.report_category_desc = report_category_desc;
    }


    /**
     * Gets the right_desc value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @return right_desc
     */
    public java.lang.String getRight_desc() {
        return right_desc;
    }


    /**
     * Sets the right_desc value for this User_group_rights_select_responseUser_group_rights.
     * 
     * @param right_desc
     */
    public void setRight_desc(java.lang.String right_desc) {
        this.right_desc = right_desc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof User_group_rights_select_responseUser_group_rights)) return false;
        User_group_rights_select_responseUser_group_rights other = (User_group_rights_select_responseUser_group_rights) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_group==null && other.getUser_group()==null) || 
             (this.user_group!=null &&
              this.user_group.equals(other.getUser_group()))) &&
            this.oc_id == other.getOc_id() &&
            this.report_category_id == other.getReport_category_id() &&
            this.right_desc_id == other.getRight_desc_id() &&
            ((this.oc_desc==null && other.getOc_desc()==null) || 
             (this.oc_desc!=null &&
              this.oc_desc.equals(other.getOc_desc()))) &&
            ((this.report_category_desc==null && other.getReport_category_desc()==null) || 
             (this.report_category_desc!=null &&
              this.report_category_desc.equals(other.getReport_category_desc()))) &&
            ((this.right_desc==null && other.getRight_desc()==null) || 
             (this.right_desc!=null &&
              this.right_desc.equals(other.getRight_desc())));
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
        if (getUser_group() != null) {
            _hashCode += getUser_group().hashCode();
        }
        _hashCode += getOc_id();
        _hashCode += getReport_category_id();
        _hashCode += getRight_desc_id();
        if (getOc_desc() != null) {
            _hashCode += getOc_desc().hashCode();
        }
        if (getReport_category_desc() != null) {
            _hashCode += getReport_category_desc().hashCode();
        }
        if (getRight_desc() != null) {
            _hashCode += getRight_desc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(User_group_rights_select_responseUser_group_rights.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>user_group_rights_select_response>user_group_rights"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("user_group");
        attrField.setXmlName(new javax.xml.namespace.QName("", "user_group"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("report_category_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "report_category_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("right_desc_id");
        attrField.setXmlName(new javax.xml.namespace.QName("", "right_desc_id"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_desc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("report_category_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "report_category_desc"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("right_desc");
        attrField.setXmlName(new javax.xml.namespace.QName("", "right_desc"));
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
