/**
 * Tenant_select_responseTenant.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Tenant_select_responseTenant  implements java.io.Serializable {
    private java.lang.String tenant;  // attribute

    private java.lang.String description;  // attribute

    private byte[] sid;  // attribute

    private java.lang.String password;  // attribute

    public Tenant_select_responseTenant() {
    }

    public Tenant_select_responseTenant(
           java.lang.String tenant,
           java.lang.String description,
           byte[] sid,
           java.lang.String password) {
           this.tenant = tenant;
           this.description = description;
           this.sid = sid;
           this.password = password;
    }


    /**
     * Gets the tenant value for this Tenant_select_responseTenant.
     * 
     * @return tenant
     */
    public java.lang.String getTenant() {
        return tenant;
    }


    /**
     * Sets the tenant value for this Tenant_select_responseTenant.
     * 
     * @param tenant
     */
    public void setTenant(java.lang.String tenant) {
        this.tenant = tenant;
    }


    /**
     * Gets the description value for this Tenant_select_responseTenant.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Tenant_select_responseTenant.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the sid value for this Tenant_select_responseTenant.
     * 
     * @return sid
     */
    public byte[] getSid() {
        return sid;
    }


    /**
     * Sets the sid value for this Tenant_select_responseTenant.
     * 
     * @param sid
     */
    public void setSid(byte[] sid) {
        this.sid = sid;
    }


    /**
     * Gets the password value for this Tenant_select_responseTenant.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this Tenant_select_responseTenant.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Tenant_select_responseTenant)) return false;
        Tenant_select_responseTenant other = (Tenant_select_responseTenant) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tenant==null && other.getTenant()==null) || 
             (this.tenant!=null &&
              this.tenant.equals(other.getTenant()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.sid==null && other.getSid()==null) || 
             (this.sid!=null &&
              java.util.Arrays.equals(this.sid, other.getSid()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword())));
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
        if (getTenant() != null) {
            _hashCode += getTenant().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getSid() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSid());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSid(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Tenant_select_responseTenant.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>tenant_select_response>tenant"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("tenant");
        attrField.setXmlName(new javax.xml.namespace.QName("", "tenant"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("description");
        attrField.setXmlName(new javax.xml.namespace.QName("", "description"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("sid");
        attrField.setXmlName(new javax.xml.namespace.QName("", "sid"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("password");
        attrField.setXmlName(new javax.xml.namespace.QName("", "password"));
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
