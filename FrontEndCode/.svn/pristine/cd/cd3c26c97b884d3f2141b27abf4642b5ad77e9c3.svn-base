/**
 * Jqs_queue_delete_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Jqs_queue_delete_response  implements java.io.Serializable {
    private Think.XmlWebServices.Jqs_queue_delete_responseJqs_queue jqs_queue;

    public Jqs_queue_delete_response() {
    }

    public Jqs_queue_delete_response(
           Think.XmlWebServices.Jqs_queue_delete_responseJqs_queue jqs_queue) {
           this.jqs_queue = jqs_queue;
    }


    /**
     * Gets the jqs_queue value for this Jqs_queue_delete_response.
     * 
     * @return jqs_queue
     */
    public Think.XmlWebServices.Jqs_queue_delete_responseJqs_queue getJqs_queue() {
        return jqs_queue;
    }


    /**
     * Sets the jqs_queue value for this Jqs_queue_delete_response.
     * 
     * @param jqs_queue
     */
    public void setJqs_queue(Think.XmlWebServices.Jqs_queue_delete_responseJqs_queue jqs_queue) {
        this.jqs_queue = jqs_queue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Jqs_queue_delete_response)) return false;
        Jqs_queue_delete_response other = (Jqs_queue_delete_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jqs_queue==null && other.getJqs_queue()==null) || 
             (this.jqs_queue!=null &&
              this.jqs_queue.equals(other.getJqs_queue())));
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
        if (getJqs_queue() != null) {
            _hashCode += getJqs_queue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Jqs_queue_delete_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">jqs_queue_delete_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jqs_queue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "jqs_queue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">>jqs_queue_delete_response>jqs_queue"));
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
