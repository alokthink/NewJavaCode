/**
 * History_list_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class History_list_response  implements java.io.Serializable {
    private Think.XmlWebServices.History_list history_list;

    public History_list_response() {
    }

    public History_list_response(
           Think.XmlWebServices.History_list history_list) {
           this.history_list = history_list;
    }


    /**
     * Gets the history_list value for this History_list_response.
     * 
     * @return history_list
     */
    public Think.XmlWebServices.History_list getHistory_list() {
        return history_list;
    }


    /**
     * Sets the history_list value for this History_list_response.
     * 
     * @param history_list
     */
    public void setHistory_list(Think.XmlWebServices.History_list history_list) {
        this.history_list = history_list;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof History_list_response)) return false;
        History_list_response other = (History_list_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.history_list==null && other.getHistory_list()==null) || 
             (this.history_list!=null &&
              this.history_list.equals(other.getHistory_list())));
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
        if (getHistory_list() != null) {
            _hashCode += getHistory_list().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(History_list_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">history_list_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("history_list");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "history_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">history_list"));
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
