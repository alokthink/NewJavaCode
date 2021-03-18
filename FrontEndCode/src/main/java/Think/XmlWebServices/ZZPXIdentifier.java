/**
 * ZZPXIdentifier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class ZZPXIdentifier  implements java.io.Serializable {
    private int pending_xaction_header_id;

    private java.lang.Integer pending_xaction_seq;

    public ZZPXIdentifier() {
    }

    public ZZPXIdentifier(
           int pending_xaction_header_id,
           java.lang.Integer pending_xaction_seq) {
           this.pending_xaction_header_id = pending_xaction_header_id;
           this.pending_xaction_seq = pending_xaction_seq;
    }


    /**
     * Gets the pending_xaction_header_id value for this ZZPXIdentifier.
     * 
     * @return pending_xaction_header_id
     */
    public int getPending_xaction_header_id() {
        return pending_xaction_header_id;
    }


    /**
     * Sets the pending_xaction_header_id value for this ZZPXIdentifier.
     * 
     * @param pending_xaction_header_id
     */
    public void setPending_xaction_header_id(int pending_xaction_header_id) {
        this.pending_xaction_header_id = pending_xaction_header_id;
    }


    /**
     * Gets the pending_xaction_seq value for this ZZPXIdentifier.
     * 
     * @return pending_xaction_seq
     */
    public java.lang.Integer getPending_xaction_seq() {
        return pending_xaction_seq;
    }


    /**
     * Sets the pending_xaction_seq value for this ZZPXIdentifier.
     * 
     * @param pending_xaction_seq
     */
    public void setPending_xaction_seq(java.lang.Integer pending_xaction_seq) {
        this.pending_xaction_seq = pending_xaction_seq;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZZPXIdentifier)) return false;
        ZZPXIdentifier other = (ZZPXIdentifier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.pending_xaction_header_id == other.getPending_xaction_header_id() &&
            ((this.pending_xaction_seq==null && other.getPending_xaction_seq()==null) || 
             (this.pending_xaction_seq!=null &&
              this.pending_xaction_seq.equals(other.getPending_xaction_seq())));
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
        _hashCode += getPending_xaction_header_id();
        if (getPending_xaction_seq() != null) {
            _hashCode += getPending_xaction_seq().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZZPXIdentifier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "ZZPXIdentifier"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pending_xaction_header_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pending_xaction_header_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pending_xaction_seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "pending_xaction_seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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

	@Override
	public String toString() {
		return "ZZPXIdentifier [pending_xaction_header_id=" + pending_xaction_header_id + ", pending_xaction_seq="
				+ pending_xaction_seq + ", __equalsCalc=" + __equalsCalc + ", __hashCodeCalc=" + __hashCodeCalc + "]";
	}
    

}
