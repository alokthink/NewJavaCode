/**
 * Td_promotion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Think.XmlWebServices;

public class Td_promotion  extends Think.XmlWebServices.ZZWorkPromotion  implements java.io.Serializable {
    private Think.XmlWebServices.Td_promotion_offer[] td_promotion_offer;

    private java.lang.String job_id_descr;  // attribute

    private java.lang.String source_code_id_descr;  // attribute

    private java.lang.String promotion_def_descr;  // attribute

    private java.lang.String rate_class_id_descr;  // attribute

    private java.lang.String promotion_card_id_descr;  // attribute

    private java.lang.String discount_class_id_descr;  // attribute

    private java.lang.String oc_id_descr;  // attribute

    public Td_promotion() {
    }

    public Td_promotion(
           int job_id,
           int work_table_seq,
           int work_promotion_seq,
           int discount_class_id,
           int oc_id,
           int promotion_card_id,
           java.lang.String promotion_def,
           int promotion_def_test_seq,
           int promotion_effort_number,
           int rate_class_id,
           java.lang.String source_code,
           int source_code_id,
           java.lang.String source_format,
           int suppress_promotion_output,
           java.lang.String job_id_descr,
           java.lang.String source_code_id_descr,
           java.lang.String promotion_def_descr,
           java.lang.String rate_class_id_descr,
           java.lang.String promotion_card_id_descr,
           java.lang.String discount_class_id_descr,
           java.lang.String oc_id_descr,
           Think.XmlWebServices.Td_promotion_offer[] td_promotion_offer) {
        super(
            job_id,
            work_table_seq,
            work_promotion_seq,
            discount_class_id,
            oc_id,
            promotion_card_id,
            promotion_def,
            promotion_def_test_seq,
            promotion_effort_number,
            rate_class_id,
            source_code,
            source_code_id,
            source_format,
            suppress_promotion_output);
        this.job_id_descr = job_id_descr;
        this.source_code_id_descr = source_code_id_descr;
        this.promotion_def_descr = promotion_def_descr;
        this.rate_class_id_descr = rate_class_id_descr;
        this.promotion_card_id_descr = promotion_card_id_descr;
        this.discount_class_id_descr = discount_class_id_descr;
        this.oc_id_descr = oc_id_descr;
        this.td_promotion_offer = td_promotion_offer;
    }


    /**
     * Gets the td_promotion_offer value for this Td_promotion.
     * 
     * @return td_promotion_offer
     */
    public Think.XmlWebServices.Td_promotion_offer[] getTd_promotion_offer() {
        return td_promotion_offer;
    }


    /**
     * Sets the td_promotion_offer value for this Td_promotion.
     * 
     * @param td_promotion_offer
     */
    public void setTd_promotion_offer(Think.XmlWebServices.Td_promotion_offer[] td_promotion_offer) {
        this.td_promotion_offer = td_promotion_offer;
    }

    public Think.XmlWebServices.Td_promotion_offer getTd_promotion_offer(int i) {
        return this.td_promotion_offer[i];
    }

    public void setTd_promotion_offer(int i, Think.XmlWebServices.Td_promotion_offer _value) {
        this.td_promotion_offer[i] = _value;
    }


    /**
     * Gets the job_id_descr value for this Td_promotion.
     * 
     * @return job_id_descr
     */
    public java.lang.String getJob_id_descr() {
        return job_id_descr;
    }


    /**
     * Sets the job_id_descr value for this Td_promotion.
     * 
     * @param job_id_descr
     */
    public void setJob_id_descr(java.lang.String job_id_descr) {
        this.job_id_descr = job_id_descr;
    }


    /**
     * Gets the source_code_id_descr value for this Td_promotion.
     * 
     * @return source_code_id_descr
     */
    public java.lang.String getSource_code_id_descr() {
        return source_code_id_descr;
    }


    /**
     * Sets the source_code_id_descr value for this Td_promotion.
     * 
     * @param source_code_id_descr
     */
    public void setSource_code_id_descr(java.lang.String source_code_id_descr) {
        this.source_code_id_descr = source_code_id_descr;
    }


    /**
     * Gets the promotion_def_descr value for this Td_promotion.
     * 
     * @return promotion_def_descr
     */
    public java.lang.String getPromotion_def_descr() {
        return promotion_def_descr;
    }


    /**
     * Sets the promotion_def_descr value for this Td_promotion.
     * 
     * @param promotion_def_descr
     */
    public void setPromotion_def_descr(java.lang.String promotion_def_descr) {
        this.promotion_def_descr = promotion_def_descr;
    }


    /**
     * Gets the rate_class_id_descr value for this Td_promotion.
     * 
     * @return rate_class_id_descr
     */
    public java.lang.String getRate_class_id_descr() {
        return rate_class_id_descr;
    }


    /**
     * Sets the rate_class_id_descr value for this Td_promotion.
     * 
     * @param rate_class_id_descr
     */
    public void setRate_class_id_descr(java.lang.String rate_class_id_descr) {
        this.rate_class_id_descr = rate_class_id_descr;
    }


    /**
     * Gets the promotion_card_id_descr value for this Td_promotion.
     * 
     * @return promotion_card_id_descr
     */
    public java.lang.String getPromotion_card_id_descr() {
        return promotion_card_id_descr;
    }


    /**
     * Sets the promotion_card_id_descr value for this Td_promotion.
     * 
     * @param promotion_card_id_descr
     */
    public void setPromotion_card_id_descr(java.lang.String promotion_card_id_descr) {
        this.promotion_card_id_descr = promotion_card_id_descr;
    }


    /**
     * Gets the discount_class_id_descr value for this Td_promotion.
     * 
     * @return discount_class_id_descr
     */
    public java.lang.String getDiscount_class_id_descr() {
        return discount_class_id_descr;
    }


    /**
     * Sets the discount_class_id_descr value for this Td_promotion.
     * 
     * @param discount_class_id_descr
     */
    public void setDiscount_class_id_descr(java.lang.String discount_class_id_descr) {
        this.discount_class_id_descr = discount_class_id_descr;
    }


    /**
     * Gets the oc_id_descr value for this Td_promotion.
     * 
     * @return oc_id_descr
     */
    public java.lang.String getOc_id_descr() {
        return oc_id_descr;
    }


    /**
     * Sets the oc_id_descr value for this Td_promotion.
     * 
     * @param oc_id_descr
     */
    public void setOc_id_descr(java.lang.String oc_id_descr) {
        this.oc_id_descr = oc_id_descr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Td_promotion)) return false;
        Td_promotion other = (Td_promotion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.td_promotion_offer==null && other.getTd_promotion_offer()==null) || 
             (this.td_promotion_offer!=null &&
              java.util.Arrays.equals(this.td_promotion_offer, other.getTd_promotion_offer()))) &&
            ((this.job_id_descr==null && other.getJob_id_descr()==null) || 
             (this.job_id_descr!=null &&
              this.job_id_descr.equals(other.getJob_id_descr()))) &&
            ((this.source_code_id_descr==null && other.getSource_code_id_descr()==null) || 
             (this.source_code_id_descr!=null &&
              this.source_code_id_descr.equals(other.getSource_code_id_descr()))) &&
            ((this.promotion_def_descr==null && other.getPromotion_def_descr()==null) || 
             (this.promotion_def_descr!=null &&
              this.promotion_def_descr.equals(other.getPromotion_def_descr()))) &&
            ((this.rate_class_id_descr==null && other.getRate_class_id_descr()==null) || 
             (this.rate_class_id_descr!=null &&
              this.rate_class_id_descr.equals(other.getRate_class_id_descr()))) &&
            ((this.promotion_card_id_descr==null && other.getPromotion_card_id_descr()==null) || 
             (this.promotion_card_id_descr!=null &&
              this.promotion_card_id_descr.equals(other.getPromotion_card_id_descr()))) &&
            ((this.discount_class_id_descr==null && other.getDiscount_class_id_descr()==null) || 
             (this.discount_class_id_descr!=null &&
              this.discount_class_id_descr.equals(other.getDiscount_class_id_descr()))) &&
            ((this.oc_id_descr==null && other.getOc_id_descr()==null) || 
             (this.oc_id_descr!=null &&
              this.oc_id_descr.equals(other.getOc_id_descr())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getTd_promotion_offer() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTd_promotion_offer());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTd_promotion_offer(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJob_id_descr() != null) {
            _hashCode += getJob_id_descr().hashCode();
        }
        if (getSource_code_id_descr() != null) {
            _hashCode += getSource_code_id_descr().hashCode();
        }
        if (getPromotion_def_descr() != null) {
            _hashCode += getPromotion_def_descr().hashCode();
        }
        if (getRate_class_id_descr() != null) {
            _hashCode += getRate_class_id_descr().hashCode();
        }
        if (getPromotion_card_id_descr() != null) {
            _hashCode += getPromotion_card_id_descr().hashCode();
        }
        if (getDiscount_class_id_descr() != null) {
            _hashCode += getDiscount_class_id_descr().hashCode();
        }
        if (getOc_id_descr() != null) {
            _hashCode += getOc_id_descr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Td_promotion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", ">td_promotion"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("job_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "job_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("source_code_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "source_code_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("promotion_def_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "promotion_def_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("rate_class_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "rate_class_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("promotion_card_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "promotion_card_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("discount_class_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "discount_class_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("oc_id_descr");
        attrField.setXmlName(new javax.xml.namespace.QName("", "oc_id_descr"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("td_promotion_offer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_promotion_offer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Think/XmlWebServices/", "td_promotion_offer"));
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
