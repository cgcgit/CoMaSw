/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables.records;


import com.billingweb.model.tables.CtPromoConsumTypeDiscount;
import com.billingweb.model.tables.interfaces.ICtPromoConsumTypeDiscount;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Table that stores the promotion fee discount relation types of the catalog 
 * for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtPromoConsumTypeDiscountRecord extends UpdatableRecordImpl<CtPromoConsumTypeDiscountRecord> implements Record9<Integer, Integer, Integer, Integer, Integer, LocalDateTime, String, LocalDateTime, String>, ICtPromoConsumTypeDiscount {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.promo_consum_type_discount_id</code>. Internal identifier of the promotion-consumption discount relation type
     */
    @Override
    public void setPromoConsumTypeDiscountId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.promo_consum_type_discount_id</code>. Internal identifier of the promotion-consumption discount relation type
     */
    @Override
    public Integer getPromoConsumTypeDiscountId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.promotion_type_id</code>. Promotion_type_id for the promotion-consumption discount relation
     */
    @Override
    public void setPromotionTypeId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.promotion_type_id</code>. Promotion_type_id for the promotion-consumption discount relation
     */
    @Override
    public Integer getPromotionTypeId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.consumption_type_id</code>. Consumption_type_id for the promotion-consumption discount relation
     */
    @Override
    public void setConsumptionTypeId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.consumption_type_id</code>. Consumption_type_id for the promotion-consumption discount relation
     */
    @Override
    public Integer getConsumptionTypeId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.consum_type_discount_class_id</code>. Type id (entity_type_id) of the discount class for the promotion-consumption discount relation
     */
    @Override
    public void setConsumTypeDiscountClassId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.consum_type_discount_class_id</code>. Type id (entity_type_id) of the discount class for the promotion-consumption discount relation
     */
    @Override
    public Integer getConsumTypeDiscountClassId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.status_id</code>. Status id for the promotion-consumption discount relation type
     */
    @Override
    public void setStatusId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.status_id</code>. Status id for the promotion-consumption discount relation type
     */
    @Override
    public Integer getStatusId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.input_date</code>. Date on which the record was created
     */
    @Override
    public void setInputDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.input_date</code>. Date on which the record was created
     */
    @Override
    public LocalDateTime getInputDate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.input_user</code>. User who was modified the record
     */
    @Override
    public void setInputUser(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.input_user</code>. User who was modified the record
     */
    @Override
    public String getInputUser() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public void setModifDate(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public LocalDateTime getModifDate() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.modif_user</code>.
     */
    @Override
    public void setModifUser(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.modif_user</code>.
     */
    @Override
    public String getModifUser() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, Integer, Integer, Integer, LocalDateTime, String, LocalDateTime, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, Integer, Integer, Integer, Integer, LocalDateTime, String, LocalDateTime, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.PROMO_CONSUM_TYPE_DISCOUNT_ID;
    }

    @Override
    public Field<Integer> field2() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.PROMOTION_TYPE_ID;
    }

    @Override
    public Field<Integer> field3() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.CONSUMPTION_TYPE_ID;
    }

    @Override
    public Field<Integer> field4() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.CONSUM_TYPE_DISCOUNT_CLASS_ID;
    }

    @Override
    public Field<Integer> field5() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.STATUS_ID;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.INPUT_DATE;
    }

    @Override
    public Field<String> field7() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.INPUT_USER;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.MODIF_DATE;
    }

    @Override
    public Field<String> field9() {
        return CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.MODIF_USER;
    }

    @Override
    public Integer component1() {
        return getPromoConsumTypeDiscountId();
    }

    @Override
    public Integer component2() {
        return getPromotionTypeId();
    }

    @Override
    public Integer component3() {
        return getConsumptionTypeId();
    }

    @Override
    public Integer component4() {
        return getConsumTypeDiscountClassId();
    }

    @Override
    public Integer component5() {
        return getStatusId();
    }

    @Override
    public LocalDateTime component6() {
        return getInputDate();
    }

    @Override
    public String component7() {
        return getInputUser();
    }

    @Override
    public LocalDateTime component8() {
        return getModifDate();
    }

    @Override
    public String component9() {
        return getModifUser();
    }

    @Override
    public Integer value1() {
        return getPromoConsumTypeDiscountId();
    }

    @Override
    public Integer value2() {
        return getPromotionTypeId();
    }

    @Override
    public Integer value3() {
        return getConsumptionTypeId();
    }

    @Override
    public Integer value4() {
        return getConsumTypeDiscountClassId();
    }

    @Override
    public Integer value5() {
        return getStatusId();
    }

    @Override
    public LocalDateTime value6() {
        return getInputDate();
    }

    @Override
    public String value7() {
        return getInputUser();
    }

    @Override
    public LocalDateTime value8() {
        return getModifDate();
    }

    @Override
    public String value9() {
        return getModifUser();
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value1(Integer value) {
        setPromoConsumTypeDiscountId(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value2(Integer value) {
        setPromotionTypeId(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value3(Integer value) {
        setConsumptionTypeId(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value4(Integer value) {
        setConsumTypeDiscountClassId(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value5(Integer value) {
        setStatusId(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value6(LocalDateTime value) {
        setInputDate(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value7(String value) {
        setInputUser(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value8(LocalDateTime value) {
        setModifDate(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord value9(String value) {
        setModifUser(value);
        return this;
    }

    @Override
    public CtPromoConsumTypeDiscountRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Integer value5, LocalDateTime value6, String value7, LocalDateTime value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ICtPromoConsumTypeDiscount from) {
        setPromoConsumTypeDiscountId(from.getPromoConsumTypeDiscountId());
        setPromotionTypeId(from.getPromotionTypeId());
        setConsumptionTypeId(from.getConsumptionTypeId());
        setConsumTypeDiscountClassId(from.getConsumTypeDiscountClassId());
        setStatusId(from.getStatusId());
        setInputDate(from.getInputDate());
        setInputUser(from.getInputUser());
        setModifDate(from.getModifDate());
        setModifUser(from.getModifUser());
    }

    @Override
    public <E extends ICtPromoConsumTypeDiscount> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CtPromoConsumTypeDiscountRecord
     */
    public CtPromoConsumTypeDiscountRecord() {
        super(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT);
    }

    /**
     * Create a detached, initialised CtPromoConsumTypeDiscountRecord
     */
    public CtPromoConsumTypeDiscountRecord(Integer promoConsumTypeDiscountId, Integer promotionTypeId, Integer consumptionTypeId, Integer consumTypeDiscountClassId, Integer statusId, LocalDateTime inputDate, String inputUser, LocalDateTime modifDate, String modifUser) {
        super(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT);

        setPromoConsumTypeDiscountId(promoConsumTypeDiscountId);
        setPromotionTypeId(promotionTypeId);
        setConsumptionTypeId(consumptionTypeId);
        setConsumTypeDiscountClassId(consumTypeDiscountClassId);
        setStatusId(statusId);
        setInputDate(inputDate);
        setInputUser(inputUser);
        setModifDate(modifDate);
        setModifUser(modifUser);
    }
}