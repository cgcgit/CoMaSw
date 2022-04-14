/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables.records;


import com.billingweb.model.tables.VwProductServiceType;
import com.billingweb.model.tables.interfaces.IVwProductServiceType;

import org.jooq.Field;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VwProductServiceTypeRecord extends TableRecordImpl<VwProductServiceTypeRecord> implements Record15<Integer, Integer, String, Integer, String, String, String, Integer, String, Integer, String, String, String, Integer, String>, IVwProductServiceType {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.vw_product_service_type.prod_serv_type_id</code>.
     */
    @Override
    public void setProdServTypeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.prod_serv_type_id</code>.
     */
    @Override
    public Integer getProdServTypeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.vw_product_service_type.prod_serv_type_status_id</code>.
     */
    @Override
    public void setProdServTypeStatusId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.prod_serv_type_status_id</code>.
     */
    @Override
    public Integer getProdServTypeStatusId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.vw_product_service_type.prod_serv_type_status_code</code>.
     */
    @Override
    public void setProdServTypeStatusCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.prod_serv_type_status_code</code>.
     */
    @Override
    public String getProdServTypeStatusCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.vw_product_service_type.product_type_id</code>.
     */
    @Override
    public void setProductTypeId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.product_type_id</code>.
     */
    @Override
    public Integer getProductTypeId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.vw_product_service_type.product_type_code</code>.
     */
    @Override
    public void setProductTypeCode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.product_type_code</code>.
     */
    @Override
    public String getProductTypeCode() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.vw_product_service_type.product_type_name</code>.
     */
    @Override
    public void setProductTypeName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.product_type_name</code>.
     */
    @Override
    public String getProductTypeName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.vw_product_service_type.product_type_description</code>.
     */
    @Override
    public void setProductTypeDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.product_type_description</code>.
     */
    @Override
    public String getProductTypeDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.vw_product_service_type.product_type_status_id</code>.
     */
    @Override
    public void setProductTypeStatusId(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.product_type_status_id</code>.
     */
    @Override
    public Integer getProductTypeStatusId() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.vw_product_service_type.product_type_status_code</code>.
     */
    @Override
    public void setProductTypeStatusCode(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.product_type_status_code</code>.
     */
    @Override
    public String getProductTypeStatusCode() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.vw_product_service_type.service_type_id</code>.
     */
    @Override
    public void setServiceTypeId(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.service_type_id</code>.
     */
    @Override
    public Integer getServiceTypeId() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.vw_product_service_type.service_type_code</code>.
     */
    @Override
    public void setServiceTypeCode(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.service_type_code</code>.
     */
    @Override
    public String getServiceTypeCode() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.vw_product_service_type.service_type_name</code>.
     */
    @Override
    public void setServiceTypeName(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.service_type_name</code>.
     */
    @Override
    public String getServiceTypeName() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.vw_product_service_type.service_type_description</code>.
     */
    @Override
    public void setServiceTypeDescription(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.service_type_description</code>.
     */
    @Override
    public String getServiceTypeDescription() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.vw_product_service_type.service_type_status_id</code>.
     */
    @Override
    public void setServiceTypeStatusId(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.service_type_status_id</code>.
     */
    @Override
    public Integer getServiceTypeStatusId() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>public.vw_product_service_type.service_type_status_code</code>.
     */
    @Override
    public void setServiceTypeStatusCode(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.vw_product_service_type.service_type_status_code</code>.
     */
    @Override
    public String getServiceTypeStatusCode() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Integer, Integer, String, Integer, String, String, String, Integer, String, Integer, String, String, String, Integer, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Integer, Integer, String, Integer, String, String, String, Integer, String, Integer, String, String, String, Integer, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PROD_SERV_TYPE_ID;
    }

    @Override
    public Field<Integer> field2() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PROD_SERV_TYPE_STATUS_ID;
    }

    @Override
    public Field<String> field3() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PROD_SERV_TYPE_STATUS_CODE;
    }

    @Override
    public Field<Integer> field4() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PRODUCT_TYPE_ID;
    }

    @Override
    public Field<String> field5() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PRODUCT_TYPE_CODE;
    }

    @Override
    public Field<String> field6() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PRODUCT_TYPE_NAME;
    }

    @Override
    public Field<String> field7() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PRODUCT_TYPE_DESCRIPTION;
    }

    @Override
    public Field<Integer> field8() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PRODUCT_TYPE_STATUS_ID;
    }

    @Override
    public Field<String> field9() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.PRODUCT_TYPE_STATUS_CODE;
    }

    @Override
    public Field<Integer> field10() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.SERVICE_TYPE_ID;
    }

    @Override
    public Field<String> field11() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.SERVICE_TYPE_CODE;
    }

    @Override
    public Field<String> field12() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.SERVICE_TYPE_NAME;
    }

    @Override
    public Field<String> field13() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.SERVICE_TYPE_DESCRIPTION;
    }

    @Override
    public Field<Integer> field14() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.SERVICE_TYPE_STATUS_ID;
    }

    @Override
    public Field<String> field15() {
        return VwProductServiceType.VW_PRODUCT_SERVICE_TYPE.SERVICE_TYPE_STATUS_CODE;
    }

    @Override
    public Integer component1() {
        return getProdServTypeId();
    }

    @Override
    public Integer component2() {
        return getProdServTypeStatusId();
    }

    @Override
    public String component3() {
        return getProdServTypeStatusCode();
    }

    @Override
    public Integer component4() {
        return getProductTypeId();
    }

    @Override
    public String component5() {
        return getProductTypeCode();
    }

    @Override
    public String component6() {
        return getProductTypeName();
    }

    @Override
    public String component7() {
        return getProductTypeDescription();
    }

    @Override
    public Integer component8() {
        return getProductTypeStatusId();
    }

    @Override
    public String component9() {
        return getProductTypeStatusCode();
    }

    @Override
    public Integer component10() {
        return getServiceTypeId();
    }

    @Override
    public String component11() {
        return getServiceTypeCode();
    }

    @Override
    public String component12() {
        return getServiceTypeName();
    }

    @Override
    public String component13() {
        return getServiceTypeDescription();
    }

    @Override
    public Integer component14() {
        return getServiceTypeStatusId();
    }

    @Override
    public String component15() {
        return getServiceTypeStatusCode();
    }

    @Override
    public Integer value1() {
        return getProdServTypeId();
    }

    @Override
    public Integer value2() {
        return getProdServTypeStatusId();
    }

    @Override
    public String value3() {
        return getProdServTypeStatusCode();
    }

    @Override
    public Integer value4() {
        return getProductTypeId();
    }

    @Override
    public String value5() {
        return getProductTypeCode();
    }

    @Override
    public String value6() {
        return getProductTypeName();
    }

    @Override
    public String value7() {
        return getProductTypeDescription();
    }

    @Override
    public Integer value8() {
        return getProductTypeStatusId();
    }

    @Override
    public String value9() {
        return getProductTypeStatusCode();
    }

    @Override
    public Integer value10() {
        return getServiceTypeId();
    }

    @Override
    public String value11() {
        return getServiceTypeCode();
    }

    @Override
    public String value12() {
        return getServiceTypeName();
    }

    @Override
    public String value13() {
        return getServiceTypeDescription();
    }

    @Override
    public Integer value14() {
        return getServiceTypeStatusId();
    }

    @Override
    public String value15() {
        return getServiceTypeStatusCode();
    }

    @Override
    public VwProductServiceTypeRecord value1(Integer value) {
        setProdServTypeId(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value2(Integer value) {
        setProdServTypeStatusId(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value3(String value) {
        setProdServTypeStatusCode(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value4(Integer value) {
        setProductTypeId(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value5(String value) {
        setProductTypeCode(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value6(String value) {
        setProductTypeName(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value7(String value) {
        setProductTypeDescription(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value8(Integer value) {
        setProductTypeStatusId(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value9(String value) {
        setProductTypeStatusCode(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value10(Integer value) {
        setServiceTypeId(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value11(String value) {
        setServiceTypeCode(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value12(String value) {
        setServiceTypeName(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value13(String value) {
        setServiceTypeDescription(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value14(Integer value) {
        setServiceTypeStatusId(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord value15(String value) {
        setServiceTypeStatusCode(value);
        return this;
    }

    @Override
    public VwProductServiceTypeRecord values(Integer value1, Integer value2, String value3, Integer value4, String value5, String value6, String value7, Integer value8, String value9, Integer value10, String value11, String value12, String value13, Integer value14, String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IVwProductServiceType from) {
        setProdServTypeId(from.getProdServTypeId());
        setProdServTypeStatusId(from.getProdServTypeStatusId());
        setProdServTypeStatusCode(from.getProdServTypeStatusCode());
        setProductTypeId(from.getProductTypeId());
        setProductTypeCode(from.getProductTypeCode());
        setProductTypeName(from.getProductTypeName());
        setProductTypeDescription(from.getProductTypeDescription());
        setProductTypeStatusId(from.getProductTypeStatusId());
        setProductTypeStatusCode(from.getProductTypeStatusCode());
        setServiceTypeId(from.getServiceTypeId());
        setServiceTypeCode(from.getServiceTypeCode());
        setServiceTypeName(from.getServiceTypeName());
        setServiceTypeDescription(from.getServiceTypeDescription());
        setServiceTypeStatusId(from.getServiceTypeStatusId());
        setServiceTypeStatusCode(from.getServiceTypeStatusCode());
    }

    @Override
    public <E extends IVwProductServiceType> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VwProductServiceTypeRecord
     */
    public VwProductServiceTypeRecord() {
        super(VwProductServiceType.VW_PRODUCT_SERVICE_TYPE);
    }

    /**
     * Create a detached, initialised VwProductServiceTypeRecord
     */
    public VwProductServiceTypeRecord(Integer prodServTypeId, Integer prodServTypeStatusId, String prodServTypeStatusCode, Integer productTypeId, String productTypeCode, String productTypeName, String productTypeDescription, Integer productTypeStatusId, String productTypeStatusCode, Integer serviceTypeId, String serviceTypeCode, String serviceTypeName, String serviceTypeDescription, Integer serviceTypeStatusId, String serviceTypeStatusCode) {
        super(VwProductServiceType.VW_PRODUCT_SERVICE_TYPE);

        setProdServTypeId(prodServTypeId);
        setProdServTypeStatusId(prodServTypeStatusId);
        setProdServTypeStatusCode(prodServTypeStatusCode);
        setProductTypeId(productTypeId);
        setProductTypeCode(productTypeCode);
        setProductTypeName(productTypeName);
        setProductTypeDescription(productTypeDescription);
        setProductTypeStatusId(productTypeStatusId);
        setProductTypeStatusCode(productTypeStatusCode);
        setServiceTypeId(serviceTypeId);
        setServiceTypeCode(serviceTypeCode);
        setServiceTypeName(serviceTypeName);
        setServiceTypeDescription(serviceTypeDescription);
        setServiceTypeStatusId(serviceTypeStatusId);
        setServiceTypeStatusCode(serviceTypeStatusCode);
    }
}