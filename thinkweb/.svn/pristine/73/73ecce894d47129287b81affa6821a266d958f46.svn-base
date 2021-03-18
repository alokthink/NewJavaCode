/**
 * Event_queue_add_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Event_queue_add_response  implements java.io.Serializable {
    private Think.XmlWebServices.ZZEventQueue event_queue;

    public Event_queue_add_response() {
    }

    public Event_queue_add_response(
           Think.XmlWebServices.ZZEventQueue event_queue) {
           this.event_queue = event_queue;
    }


    /**
     * Gets the event_queue value for this Event_queue_add_response.
     * 
     * @return event_queue
     */
    public Think.XmlWebServices.ZZEventQueue getEvent_queue() {
        return event_queue;
    }


    /**
     * Sets the event_queue value for this Event_queue_add_response.
     * 
     * @param event_queue
     */
    public void setEvent_queue(Think.XmlWebServices.ZZEventQueue event_queue) {
        this.event_queue = event_queue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Event_queue_add_response)) return false;
        Event_queue_add_response other = (Event_queue_add_response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.event_queue==null && other.getEvent_queue()==null) || 
             (this.event_queue!=null &&
              this.event_queue.equals(other.getEvent_queue())));
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
        if (getEvent_queue() != null) {
            _hashCode += getEvent_queue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Event_queue_add_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">event_queue_add_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("event_queue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "event_queue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZEventQueue"));
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
