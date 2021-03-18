/**
 * Current_issue_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Current_issue_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Current_issue_select_responseCurrent_issue current_issue;

    public Current_issue_select_response() {
    }

    public Current_issue_select_response(
           Think.XmlWebServices.Current_issue_select_responseCurrent_issue current_issue) {
           this.current_issue = current_issue;
    }


    /**
     * Gets the current_issue value for this Current_issue_select_response.
     * 
     * @return current_issue
     */
    public Think.XmlWebServices.Current_issue_select_responseCurrent_issue getCurrent_issue() {
        return current_issue;
    }


    /**
     * Sets the current_issue value for this Current_issue_select_response.
     * 
     * @param current_issue
     */
    public void setCurrent_issue(Think.XmlWebServices.Current_issue_select_responseCurrent_issue current_issue) {
        this.current_issue = current_issue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Current_issue_select_response)) return false;
        Current_issue_select_response other = (Current_issue_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.current_issue==null && other.getCurrent_issue()==null) || 
             (this.current_issue!=null &&
              this.current_issue.equals(other.getCurrent_issue())));
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
        if (getCurrent_issue() != null) {
            _hashCode += getCurrent_issue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Current_issue_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">current_issue_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("current_issue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "current_issue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>current_issue_select_response>current_issue"));
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
