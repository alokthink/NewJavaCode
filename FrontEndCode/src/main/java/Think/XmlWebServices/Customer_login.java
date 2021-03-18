/**
 * Customer_login.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Customer_login  extends Think.XmlWebServices.ZZCustomerLogin  implements java.io.Serializable {
    private Think.XmlWebServices.Auxiliary_data[] auxiliary_data;

    public Customer_login() {
    }

    public Customer_login(
           int customer_login_id,
           java.util.Calendar creation_date,
           int customer_id,
           int customer_login_question_id,
           java.lang.String hint,
           int invalid_auth_attempts,
           int is_primary_login,
           int locked_out,
           java.util.Calendar lockout_start,
           java.lang.String login,
           java.lang.String password,
           int pending_xaction_header_id,
           int pending_xaction_seq,
           java.lang.String response,
           int salt,
           java.util.Calendar temp_expire,
           Think.XmlWebServices.Auxiliary_data[] auxiliary_data) {
        super(
            customer_login_id,
            creation_date,
            customer_id,
            customer_login_question_id,
            hint,
            invalid_auth_attempts,
            is_primary_login,
            locked_out,
            lockout_start,
            login,
            password,
            pending_xaction_header_id,
            pending_xaction_seq,
            response,
            salt,
            temp_expire);
        this.auxiliary_data = auxiliary_data;
    }


    /**
     * Gets the auxiliary_data value for this Customer_login.
     * 
     * @return auxiliary_data
     */
    public Think.XmlWebServices.Auxiliary_data[] getAuxiliary_data() {
        return auxiliary_data;
    }


    /**
     * Sets the auxiliary_data value for this Customer_login.
     * 
     * @param auxiliary_data
     */
    public void setAuxiliary_data(Think.XmlWebServices.Auxiliary_data[] auxiliary_data) {
        this.auxiliary_data = auxiliary_data;
    }

    public Think.XmlWebServices.Auxiliary_data getAuxiliary_data(int i) {
        return this.auxiliary_data[i];
    }

    public void setAuxiliary_data(int i, Think.XmlWebServices.Auxiliary_data _value) {
        this.auxiliary_data[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer_login)) return false;
        Customer_login other = (Customer_login) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.auxiliary_data==null && other.getAuxiliary_data()==null) || 
             (this.auxiliary_data!=null &&
              java.util.Arrays.equals(this.auxiliary_data, other.getAuxiliary_data())));
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
        if (getAuxiliary_data() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAuxiliary_data());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAuxiliary_data(), i);
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
        new org.apache.axis.description.TypeDesc(Customer_login.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">customer_login"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auxiliary_data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auxiliary_data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "auxiliary_data"));
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
