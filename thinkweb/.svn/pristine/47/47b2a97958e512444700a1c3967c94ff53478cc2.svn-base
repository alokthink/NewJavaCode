/**
 * Last_edit_date_select_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Last_edit_date_select_response  implements java.io.Serializable {
    private Think.XmlWebServices.Last_edit_date_select_responseEdit_trail edit_trail;

    public Last_edit_date_select_response() {
    }

    public Last_edit_date_select_response(
           Think.XmlWebServices.Last_edit_date_select_responseEdit_trail edit_trail) {
           this.edit_trail = edit_trail;
    }


    /**
     * Gets the edit_trail value for this Last_edit_date_select_response.
     * 
     * @return edit_trail
     */
    public Think.XmlWebServices.Last_edit_date_select_responseEdit_trail getEdit_trail() {
        return edit_trail;
    }


    /**
     * Sets the edit_trail value for this Last_edit_date_select_response.
     * 
     * @param edit_trail
     */
    public void setEdit_trail(Think.XmlWebServices.Last_edit_date_select_responseEdit_trail edit_trail) {
        this.edit_trail = edit_trail;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Last_edit_date_select_response)) return false;
        Last_edit_date_select_response other = (Last_edit_date_select_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.edit_trail==null && other.getEdit_trail()==null) || 
             (this.edit_trail!=null &&
              this.edit_trail.equals(other.getEdit_trail())));
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
        if (getEdit_trail() != null) {
            _hashCode += getEdit_trail().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Last_edit_date_select_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">last_edit_date_select_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edit_trail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "edit_trail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>last_edit_date_select_response>edit_trail"));
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
