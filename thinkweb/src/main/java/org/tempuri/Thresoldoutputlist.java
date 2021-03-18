/**
 * Thresoldoutputlist.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Thresoldoutputlist  implements java.io.Serializable {
    private java.lang.String range;

    private java.lang.String name;

    private java.lang.String options;

    private java.lang.String defaultoption;

    private java.lang.String notify;

    public Thresoldoutputlist() {
    }

    public Thresoldoutputlist(
           java.lang.String range,
           java.lang.String name,
           java.lang.String options,
           java.lang.String defaultoption,
           java.lang.String notify) {
           this.range = range;
           this.name = name;
           this.options = options;
           this.defaultoption = defaultoption;
           this.notify = notify;
    }


    /**
     * Gets the range value for this Thresoldoutputlist.
     * 
     * @return range
     */
    public java.lang.String getRange() {
        return range;
    }


    /**
     * Sets the range value for this Thresoldoutputlist.
     * 
     * @param range
     */
    public void setRange(java.lang.String range) {
        this.range = range;
    }


    /**
     * Gets the name value for this Thresoldoutputlist.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Thresoldoutputlist.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the options value for this Thresoldoutputlist.
     * 
     * @return options
     */
    public java.lang.String getOptions() {
        return options;
    }


    /**
     * Sets the options value for this Thresoldoutputlist.
     * 
     * @param options
     */
    public void setOptions(java.lang.String options) {
        this.options = options;
    }


    /**
     * Gets the defaultoption value for this Thresoldoutputlist.
     * 
     * @return defaultoption
     */
    public java.lang.String getDefaultoption() {
        return defaultoption;
    }


    /**
     * Sets the defaultoption value for this Thresoldoutputlist.
     * 
     * @param defaultoption
     */
    public void setDefaultoption(java.lang.String defaultoption) {
        this.defaultoption = defaultoption;
    }


    /**
     * Gets the notify value for this Thresoldoutputlist.
     * 
     * @return notify
     */
    public java.lang.String getNotify() {
        return notify;
    }


    /**
     * Sets the notify value for this Thresoldoutputlist.
     * 
     * @param notify
     */
    public void setNotify(java.lang.String notify) {
        this.notify = notify;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Thresoldoutputlist)) return false;
        Thresoldoutputlist other = (Thresoldoutputlist) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.range==null && other.getRange()==null) || 
             (this.range!=null &&
              this.range.equals(other.getRange()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.options==null && other.getOptions()==null) || 
             (this.options!=null &&
              this.options.equals(other.getOptions()))) &&
            ((this.defaultoption==null && other.getDefaultoption()==null) || 
             (this.defaultoption!=null &&
              this.defaultoption.equals(other.getDefaultoption()))) &&
            ((this.notify==null && other.getNotify()==null) || 
             (this.notify!=null &&
              this.notify.equals(other.getNotify())));
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
        if (getRange() != null) {
            _hashCode += getRange().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOptions() != null) {
            _hashCode += getOptions().hashCode();
        }
        if (getDefaultoption() != null) {
            _hashCode += getDefaultoption().hashCode();
        }
        if (getNotify() != null) {
            _hashCode += getNotify().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Thresoldoutputlist.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "thresoldoutputlist"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("range");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Range"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("options");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Options"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultoption");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Defaultoption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notify");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Notify"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
