/**
 * Process_data.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Process_data  implements java.io.Serializable {
    private java.lang.String on_hold_email;

    private java.lang.String output_ready_email;

    private java.lang.String review_ready_email;

    private java.lang.String job_done_email;

    private java.lang.String warning_email;

    private java.lang.String fatal_email;

    private java.lang.String no_connect_email;

    private java.lang.Integer notification_bits;

    public Process_data() {
    }

    public Process_data(
           java.lang.String on_hold_email,
           java.lang.String output_ready_email,
           java.lang.String review_ready_email,
           java.lang.String job_done_email,
           java.lang.String warning_email,
           java.lang.String fatal_email,
           java.lang.String no_connect_email,
           java.lang.Integer notification_bits) {
           this.on_hold_email = on_hold_email;
           this.output_ready_email = output_ready_email;
           this.review_ready_email = review_ready_email;
           this.job_done_email = job_done_email;
           this.warning_email = warning_email;
           this.fatal_email = fatal_email;
           this.no_connect_email = no_connect_email;
           this.notification_bits = notification_bits;
    }


    /**
     * Gets the on_hold_email value for this Process_data.
     * 
     * @return on_hold_email
     */
    public java.lang.String getOn_hold_email() {
        return on_hold_email;
    }


    /**
     * Sets the on_hold_email value for this Process_data.
     * 
     * @param on_hold_email
     */
    public void setOn_hold_email(java.lang.String on_hold_email) {
        this.on_hold_email = on_hold_email;
    }


    /**
     * Gets the output_ready_email value for this Process_data.
     * 
     * @return output_ready_email
     */
    public java.lang.String getOutput_ready_email() {
        return output_ready_email;
    }


    /**
     * Sets the output_ready_email value for this Process_data.
     * 
     * @param output_ready_email
     */
    public void setOutput_ready_email(java.lang.String output_ready_email) {
        this.output_ready_email = output_ready_email;
    }


    /**
     * Gets the review_ready_email value for this Process_data.
     * 
     * @return review_ready_email
     */
    public java.lang.String getReview_ready_email() {
        return review_ready_email;
    }


    /**
     * Sets the review_ready_email value for this Process_data.
     * 
     * @param review_ready_email
     */
    public void setReview_ready_email(java.lang.String review_ready_email) {
        this.review_ready_email = review_ready_email;
    }


    /**
     * Gets the job_done_email value for this Process_data.
     * 
     * @return job_done_email
     */
    public java.lang.String getJob_done_email() {
        return job_done_email;
    }


    /**
     * Sets the job_done_email value for this Process_data.
     * 
     * @param job_done_email
     */
    public void setJob_done_email(java.lang.String job_done_email) {
        this.job_done_email = job_done_email;
    }


    /**
     * Gets the warning_email value for this Process_data.
     * 
     * @return warning_email
     */
    public java.lang.String getWarning_email() {
        return warning_email;
    }


    /**
     * Sets the warning_email value for this Process_data.
     * 
     * @param warning_email
     */
    public void setWarning_email(java.lang.String warning_email) {
        this.warning_email = warning_email;
    }


    /**
     * Gets the fatal_email value for this Process_data.
     * 
     * @return fatal_email
     */
    public java.lang.String getFatal_email() {
        return fatal_email;
    }


    /**
     * Sets the fatal_email value for this Process_data.
     * 
     * @param fatal_email
     */
    public void setFatal_email(java.lang.String fatal_email) {
        this.fatal_email = fatal_email;
    }


    /**
     * Gets the no_connect_email value for this Process_data.
     * 
     * @return no_connect_email
     */
    public java.lang.String getNo_connect_email() {
        return no_connect_email;
    }


    /**
     * Sets the no_connect_email value for this Process_data.
     * 
     * @param no_connect_email
     */
    public void setNo_connect_email(java.lang.String no_connect_email) {
        this.no_connect_email = no_connect_email;
    }


    /**
     * Gets the notification_bits value for this Process_data.
     * 
     * @return notification_bits
     */
    public java.lang.Integer getNotification_bits() {
        return notification_bits;
    }


    /**
     * Sets the notification_bits value for this Process_data.
     * 
     * @param notification_bits
     */
    public void setNotification_bits(java.lang.Integer notification_bits) {
        this.notification_bits = notification_bits;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Process_data)) return false;
        Process_data other = (Process_data) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.on_hold_email==null && other.getOn_hold_email()==null) || 
             (this.on_hold_email!=null &&
              this.on_hold_email.equals(other.getOn_hold_email()))) &&
            ((this.output_ready_email==null && other.getOutput_ready_email()==null) || 
             (this.output_ready_email!=null &&
              this.output_ready_email.equals(other.getOutput_ready_email()))) &&
            ((this.review_ready_email==null && other.getReview_ready_email()==null) || 
             (this.review_ready_email!=null &&
              this.review_ready_email.equals(other.getReview_ready_email()))) &&
            ((this.job_done_email==null && other.getJob_done_email()==null) || 
             (this.job_done_email!=null &&
              this.job_done_email.equals(other.getJob_done_email()))) &&
            ((this.warning_email==null && other.getWarning_email()==null) || 
             (this.warning_email!=null &&
              this.warning_email.equals(other.getWarning_email()))) &&
            ((this.fatal_email==null && other.getFatal_email()==null) || 
             (this.fatal_email!=null &&
              this.fatal_email.equals(other.getFatal_email()))) &&
            ((this.no_connect_email==null && other.getNo_connect_email()==null) || 
             (this.no_connect_email!=null &&
              this.no_connect_email.equals(other.getNo_connect_email()))) &&
            ((this.notification_bits==null && other.getNotification_bits()==null) || 
             (this.notification_bits!=null &&
              this.notification_bits.equals(other.getNotification_bits())));
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
        if (getOn_hold_email() != null) {
            _hashCode += getOn_hold_email().hashCode();
        }
        if (getOutput_ready_email() != null) {
            _hashCode += getOutput_ready_email().hashCode();
        }
        if (getReview_ready_email() != null) {
            _hashCode += getReview_ready_email().hashCode();
        }
        if (getJob_done_email() != null) {
            _hashCode += getJob_done_email().hashCode();
        }
        if (getWarning_email() != null) {
            _hashCode += getWarning_email().hashCode();
        }
        if (getFatal_email() != null) {
            _hashCode += getFatal_email().hashCode();
        }
        if (getNo_connect_email() != null) {
            _hashCode += getNo_connect_email().hashCode();
        }
        if (getNotification_bits() != null) {
            _hashCode += getNotification_bits().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Process_data.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">process_data"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("on_hold_email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "on_hold_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("output_ready_email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "output_ready_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("review_ready_email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "review_ready_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("job_done_email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "job_done_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warning_email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "warning_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fatal_email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "fatal_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("no_connect_email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "no_connect_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notification_bits");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "notification_bits"));
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

}
