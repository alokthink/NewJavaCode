/**
 * Auxiliary_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Auxiliary_data  implements java.io.Serializable {
    private java.lang.Integer int_val;

    private java.lang.String text_val;

    private java.math.BigDecimal dec_val;

    private java.util.Date date_val;

    private java.lang.String name;  // attribute

    public Auxiliary_data() {
    }

    public Auxiliary_data(
           java.lang.Integer int_val,
           java.lang.String text_val,
           java.math.BigDecimal dec_val,
           java.util.Date date_val,
           java.lang.String name) {
           this.int_val = int_val;
           this.text_val = text_val;
           this.dec_val = dec_val;
           this.date_val = date_val;
           this.name = name;
    }


    /**
     * Gets the int_val value for this Auxiliary_data.
     * 
     * @return int_val
     */
    public java.lang.Integer getInt_val() {
        return int_val;
    }


    /**
     * Sets the int_val value for this Auxiliary_data.
     * 
     * @param int_val
     */
    public void setInt_val(java.lang.Integer int_val) {
        this.int_val = int_val;
    }


    /**
     * Gets the text_val value for this Auxiliary_data.
     * 
     * @return text_val
     */
    public java.lang.String getText_val() {
        return text_val;
    }


    /**
     * Sets the text_val value for this Auxiliary_data.
     * 
     * @param text_val
     */
    public void setText_val(java.lang.String text_val) {
        this.text_val = text_val;
    }


    /**
     * Gets the dec_val value for this Auxiliary_data.
     * 
     * @return dec_val
     */
    public java.math.BigDecimal getDec_val() {
        return dec_val;
    }


    /**
     * Sets the dec_val value for this Auxiliary_data.
     * 
     * @param dec_val
     */
    public void setDec_val(java.math.BigDecimal dec_val) {
        this.dec_val = dec_val;
    }


    /**
     * Gets the date_val value for this Auxiliary_data.
     * 
     * @return date_val
     */
    public java.util.Date getDate_val() {
        return date_val;
    }


    /**
     * Sets the date_val value for this Auxiliary_data.
     * 
     * @param date_val
     */
    public void setDate_val(java.util.Date date_val) {
        this.date_val = date_val;
    }


    /**
     * Gets the name value for this Auxiliary_data.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Auxiliary_data.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Auxiliary_data)) return false;
        Auxiliary_data other = (Auxiliary_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.int_val==null && other.getInt_val()==null) || 
             (this.int_val!=null &&
              this.int_val.equals(other.getInt_val()))) &&
            ((this.text_val==null && other.getText_val()==null) || 
             (this.text_val!=null &&
              this.text_val.equals(other.getText_val()))) &&
            ((this.dec_val==null && other.getDec_val()==null) || 
             (this.dec_val!=null &&
              this.dec_val.equals(other.getDec_val()))) &&
            ((this.date_val==null && other.getDate_val()==null) || 
             (this.date_val!=null &&
              this.date_val.equals(other.getDate_val()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
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
        if (getInt_val() != null) {
            _hashCode += getInt_val().hashCode();
        }
        if (getText_val() != null) {
            _hashCode += getText_val().hashCode();
        }
        if (getDec_val() != null) {
            _hashCode += getDec_val().hashCode();
        }
        if (getDate_val() != null) {
            _hashCode += getDate_val().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Auxiliary_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">auxiliary_data"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("name");
        attrField.setXmlName(new javax.xml.namespace.QName("", "name"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("int_val");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "int_val"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text_val");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "text_val"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dec_val");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "dec_val"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_val");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "date_val"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
