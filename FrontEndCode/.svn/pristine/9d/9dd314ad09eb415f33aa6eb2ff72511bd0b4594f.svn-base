/**
 * Trusted_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Trusted_data  implements java.io.Serializable {
    private Think.XmlWebServices.Key[] keys;

    private Think.XmlWebServices.Changes changes;

    private java.lang.String quaycester;  // attribute

    public Trusted_data() {
    }

    public Trusted_data(
           Think.XmlWebServices.Key[] keys,
           Think.XmlWebServices.Changes changes,
           java.lang.String quaycester) {
           this.keys = keys;
           this.changes = changes;
           this.quaycester = quaycester;
    }


    /**
     * Gets the keys value for this Trusted_data.
     * 
     * @return keys
     */
    public Think.XmlWebServices.Key[] getKeys() {
        return keys;
    }


    /**
     * Sets the keys value for this Trusted_data.
     * 
     * @param keys
     */
    public void setKeys(Think.XmlWebServices.Key[] keys) {
        this.keys = keys;
    }


    /**
     * Gets the changes value for this Trusted_data.
     * 
     * @return changes
     */
    public Think.XmlWebServices.Changes getChanges() {
        return changes;
    }


    /**
     * Sets the changes value for this Trusted_data.
     * 
     * @param changes
     */
    public void setChanges(Think.XmlWebServices.Changes changes) {
        this.changes = changes;
    }


    /**
     * Gets the quaycester value for this Trusted_data.
     * 
     * @return quaycester
     */
    public java.lang.String getQuaycester() {
        return quaycester;
    }


    /**
     * Sets the quaycester value for this Trusted_data.
     * 
     * @param quaycester
     */
    public void setQuaycester(java.lang.String quaycester) {
        this.quaycester = quaycester;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Trusted_data)) return false;
        Trusted_data other = (Trusted_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keys==null && other.getKeys()==null) || 
             (this.keys!=null &&
              java.util.Arrays.equals(this.keys, other.getKeys()))) &&
            ((this.changes==null && other.getChanges()==null) || 
             (this.changes!=null &&
              this.changes.equals(other.getChanges()))) &&
            ((this.quaycester==null && other.getQuaycester()==null) || 
             (this.quaycester!=null &&
              this.quaycester.equals(other.getQuaycester())));
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
        if (getKeys() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeys());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeys(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getChanges() != null) {
            _hashCode += getChanges().hashCode();
        }
        if (getQuaycester() != null) {
            _hashCode += getQuaycester().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Trusted_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">trusted_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("quaycester");
        attrField.setXmlName(new javax.xml.namespace.QName("", "quaycester"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keys");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "keys"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">keys"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "changes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">changes"));
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
