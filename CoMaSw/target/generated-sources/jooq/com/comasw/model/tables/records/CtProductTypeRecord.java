/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.records;


import com.comasw.model.tables.CtProductType;
import com.comasw.model.tables.interfaces.ICtProductType;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Table that stores the product types of the catalog for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtProductTypeRecord extends UpdatableRecordImpl<CtProductTypeRecord> implements Record10<Integer, Integer, String, String, String, Integer, LocalDateTime, String, LocalDateTime, String>, ICtProductType {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.ct_product_type.product_type_id</code>. Internal identifier of the product type
     */
    @Override
    public void setProductTypeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.ct_product_type.product_type_id</code>. Internal identifier of the product type
     */
    @Override
    public Integer getProductTypeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.ct_product_type.entity_type_id</code>. Entity_id for the product type
     */
    @Override
    public void setEntityTypeId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.ct_product_type.entity_type_id</code>. Entity_id for the product type
     */
    @Override
    public Integer getEntityTypeId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.ct_product_type.code</code>. Code of the product type
     */
    @Override
    public void setCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.ct_product_type.code</code>. Code of the product type
     */
    @Override
    public String getCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.ct_product_type.name</code>. Name of the product type
     */
    @Override
    public void setName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.ct_product_type.name</code>. Name of the product type
     */
    @Override
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.ct_product_type.description</code>. Description for the product type
     */
    @Override
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.ct_product_type.description</code>. Description for the product type
     */
    @Override
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.ct_product_type.status_id</code>. Status id for the product type
     */
    @Override
    public void setStatusId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.ct_product_type.status_id</code>. Status id for the product type
     */
    @Override
    public Integer getStatusId() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.ct_product_type.input_date</code>. Date on which the record was created
     */
    @Override
    public void setInputDate(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.ct_product_type.input_date</code>. Date on which the record was created
     */
    @Override
    public LocalDateTime getInputDate() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.ct_product_type.input_user</code>. User who was modified the record
     */
    @Override
    public void setInputUser(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.ct_product_type.input_user</code>. User who was modified the record
     */
    @Override
    public String getInputUser() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.ct_product_type.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public void setModifDate(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.ct_product_type.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public LocalDateTime getModifDate() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>public.ct_product_type.modif_user</code>.
     */
    @Override
    public void setModifUser(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.ct_product_type.modif_user</code>.
     */
    @Override
    public String getModifUser() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, Integer, String, String, String, Integer, LocalDateTime, String, LocalDateTime, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, Integer, String, String, String, Integer, LocalDateTime, String, LocalDateTime, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return CtProductType.CT_PRODUCT_TYPE.PRODUCT_TYPE_ID;
    }

    @Override
    public Field<Integer> field2() {
        return CtProductType.CT_PRODUCT_TYPE.ENTITY_TYPE_ID;
    }

    @Override
    public Field<String> field3() {
        return CtProductType.CT_PRODUCT_TYPE.CODE;
    }

    @Override
    public Field<String> field4() {
        return CtProductType.CT_PRODUCT_TYPE.NAME;
    }

    @Override
    public Field<String> field5() {
        return CtProductType.CT_PRODUCT_TYPE.DESCRIPTION;
    }

    @Override
    public Field<Integer> field6() {
        return CtProductType.CT_PRODUCT_TYPE.STATUS_ID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return CtProductType.CT_PRODUCT_TYPE.INPUT_DATE;
    }

    @Override
    public Field<String> field8() {
        return CtProductType.CT_PRODUCT_TYPE.INPUT_USER;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return CtProductType.CT_PRODUCT_TYPE.MODIF_DATE;
    }

    @Override
    public Field<String> field10() {
        return CtProductType.CT_PRODUCT_TYPE.MODIF_USER;
    }

    @Override
    public Integer component1() {
        return getProductTypeId();
    }

    @Override
    public Integer component2() {
        return getEntityTypeId();
    }

    @Override
    public String component3() {
        return getCode();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public Integer component6() {
        return getStatusId();
    }

    @Override
    public LocalDateTime component7() {
        return getInputDate();
    }

    @Override
    public String component8() {
        return getInputUser();
    }

    @Override
    public LocalDateTime component9() {
        return getModifDate();
    }

    @Override
    public String component10() {
        return getModifUser();
    }

    @Override
    public Integer value1() {
        return getProductTypeId();
    }

    @Override
    public Integer value2() {
        return getEntityTypeId();
    }

    @Override
    public String value3() {
        return getCode();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public Integer value6() {
        return getStatusId();
    }

    @Override
    public LocalDateTime value7() {
        return getInputDate();
    }

    @Override
    public String value8() {
        return getInputUser();
    }

    @Override
    public LocalDateTime value9() {
        return getModifDate();
    }

    @Override
    public String value10() {
        return getModifUser();
    }

    @Override
    public CtProductTypeRecord value1(Integer value) {
        setProductTypeId(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value2(Integer value) {
        setEntityTypeId(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value3(String value) {
        setCode(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value6(Integer value) {
        setStatusId(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value7(LocalDateTime value) {
        setInputDate(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value8(String value) {
        setInputUser(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value9(LocalDateTime value) {
        setModifDate(value);
        return this;
    }

    @Override
    public CtProductTypeRecord value10(String value) {
        setModifUser(value);
        return this;
    }

    @Override
    public CtProductTypeRecord values(Integer value1, Integer value2, String value3, String value4, String value5, Integer value6, LocalDateTime value7, String value8, LocalDateTime value9, String value10) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ICtProductType from) {
        setProductTypeId(from.getProductTypeId());
        setEntityTypeId(from.getEntityTypeId());
        setCode(from.getCode());
        setName(from.getName());
        setDescription(from.getDescription());
        setStatusId(from.getStatusId());
        setInputDate(from.getInputDate());
        setInputUser(from.getInputUser());
        setModifDate(from.getModifDate());
        setModifUser(from.getModifUser());
    }

    @Override
    public <E extends ICtProductType> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CtProductTypeRecord
     */
    public CtProductTypeRecord() {
        super(CtProductType.CT_PRODUCT_TYPE);
    }

    /**
     * Create a detached, initialised CtProductTypeRecord
     */
    public CtProductTypeRecord(Integer productTypeId, Integer entityTypeId, String code, String name, String description, Integer statusId, LocalDateTime inputDate, String inputUser, LocalDateTime modifDate, String modifUser) {
        super(CtProductType.CT_PRODUCT_TYPE);

        setProductTypeId(productTypeId);
        setEntityTypeId(entityTypeId);
        setCode(code);
        setName(name);
        setDescription(description);
        setStatusId(statusId);
        setInputDate(inputDate);
        setInputUser(inputUser);
        setModifDate(modifDate);
        setModifUser(modifUser);
    }
}
