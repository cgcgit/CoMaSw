/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.records;


import com.comasw.model.tables.VwPromotionFeeTypeDiscount;
import com.comasw.model.tables.interfaces.IVwPromotionFeeTypeDiscount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VwPromotionFeeTypeDiscountRecord extends TableRecordImpl<VwPromotionFeeTypeDiscountRecord> implements IVwPromotionFeeTypeDiscount {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promo_fee_type_discount_id</code>.
     */
    @Override
    public void setPromoFeeTypeDiscountId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promo_fee_type_discount_id</code>.
     */
    @Override
    public Integer getPromoFeeTypeDiscountId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promo_fee_type_disc_status_id</code>.
     */
    @Override
    public void setPromoFeeTypeDiscStatusId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promo_fee_type_disc_status_id</code>.
     */
    @Override
    public Integer getPromoFeeTypeDiscStatusId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promo_fee_type_disc_status_code</code>.
     */
    @Override
    public void setPromoFeeTypeDiscStatusCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promo_fee_type_disc_status_code</code>.
     */
    @Override
    public String getPromoFeeTypeDiscStatusCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_id</code>.
     */
    @Override
    public void setPromotionTypeId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_id</code>.
     */
    @Override
    public Integer getPromotionTypeId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_start_date</code>.
     */
    @Override
    public void setPromotionTypeStartDate(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_start_date</code>.
     */
    @Override
    public LocalDateTime getPromotionTypeStartDate() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_end_date</code>.
     */
    @Override
    public void setPromotionTypeEndDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_end_date</code>.
     */
    @Override
    public LocalDateTime getPromotionTypeEndDate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_code</code>.
     */
    @Override
    public void setPromotionTypeCode(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_code</code>.
     */
    @Override
    public String getPromotionTypeCode() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_name</code>.
     */
    @Override
    public void setPromotionTypeName(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_name</code>.
     */
    @Override
    public String getPromotionTypeName() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_description</code>.
     */
    @Override
    public void setPromotionTypeDescription(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_description</code>.
     */
    @Override
    public String getPromotionTypeDescription() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.application_level_id</code>.
     */
    @Override
    public void setApplicationLevelId(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.application_level_id</code>.
     */
    @Override
    public Integer getApplicationLevelId() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.application_level_code</code>.
     */
    @Override
    public void setApplicationLevelCode(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.application_level_code</code>.
     */
    @Override
    public String getApplicationLevelCode() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.discount_type_id</code>.
     */
    @Override
    public void setDiscountTypeId(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.discount_type_id</code>.
     */
    @Override
    public Integer getDiscountTypeId() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.discount_type_code</code>.
     */
    @Override
    public void setDiscountTypeCode(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.discount_type_code</code>.
     */
    @Override
    public String getDiscountTypeCode() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.discount_type_name</code>.
     */
    @Override
    public void setDiscountTypeName(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.discount_type_name</code>.
     */
    @Override
    public String getDiscountTypeName() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.discount_type_description</code>.
     */
    @Override
    public void setDiscountTypeDescription(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.discount_type_description</code>.
     */
    @Override
    public String getDiscountTypeDescription() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.application_level_description</code>.
     */
    @Override
    public void setApplicationLevelDescription(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.application_level_description</code>.
     */
    @Override
    public String getApplicationLevelDescription() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_discount_value</code>.
     */
    @Override
    public void setPromotionTypeDiscountValue(BigDecimal value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_discount_value</code>.
     */
    @Override
    public BigDecimal getPromotionTypeDiscountValue() {
        return (BigDecimal) get(16);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_status_id</code>.
     */
    @Override
    public void setPromotionTypeStatusId(Integer value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_status_id</code>.
     */
    @Override
    public Integer getPromotionTypeStatusId() {
        return (Integer) get(17);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.promotion_type_status_code</code>.
     */
    @Override
    public void setPromotionTypeStatusCode(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.promotion_type_status_code</code>.
     */
    @Override
    public String getPromotionTypeStatusCode() {
        return (String) get(18);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_id</code>.
     */
    @Override
    public void setFeeTypeId(Integer value) {
        set(19, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_id</code>.
     */
    @Override
    public Integer getFeeTypeId() {
        return (Integer) get(19);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_start_date</code>.
     */
    @Override
    public void setFeeTypeStartDate(LocalDateTime value) {
        set(20, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_start_date</code>.
     */
    @Override
    public LocalDateTime getFeeTypeStartDate() {
        return (LocalDateTime) get(20);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_end_date</code>.
     */
    @Override
    public void setFeeTypeEndDate(LocalDateTime value) {
        set(21, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_end_date</code>.
     */
    @Override
    public LocalDateTime getFeeTypeEndDate() {
        return (LocalDateTime) get(21);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_code</code>.
     */
    @Override
    public void setFeeTypeCode(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_code</code>.
     */
    @Override
    public String getFeeTypeCode() {
        return (String) get(22);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_name</code>.
     */
    @Override
    public void setFeeTypeName(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_name</code>.
     */
    @Override
    public String getFeeTypeName() {
        return (String) get(23);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_description</code>.
     */
    @Override
    public void setFeeTypeDescription(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_description</code>.
     */
    @Override
    public String getFeeTypeDescription() {
        return (String) get(24);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.prorate</code>.
     */
    @Override
    public void setProrate(Boolean value) {
        set(25, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.prorate</code>.
     */
    @Override
    public Boolean getProrate() {
        return (Boolean) get(25);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.price</code>.
     */
    @Override
    public void setPrice(BigDecimal value) {
        set(26, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.price</code>.
     */
    @Override
    public BigDecimal getPrice() {
        return (BigDecimal) get(26);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_status_id</code>.
     */
    @Override
    public void setFeeTypeStatusId(Integer value) {
        set(27, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_status_id</code>.
     */
    @Override
    public Integer getFeeTypeStatusId() {
        return (Integer) get(27);
    }

    /**
     * Setter for <code>public.vw_promotion_fee_type_discount.fee_type_status_code</code>.
     */
    @Override
    public void setFeeTypeStatusCode(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>public.vw_promotion_fee_type_discount.fee_type_status_code</code>.
     */
    @Override
    public String getFeeTypeStatusCode() {
        return (String) get(28);
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IVwPromotionFeeTypeDiscount from) {
        setPromoFeeTypeDiscountId(from.getPromoFeeTypeDiscountId());
        setPromoFeeTypeDiscStatusId(from.getPromoFeeTypeDiscStatusId());
        setPromoFeeTypeDiscStatusCode(from.getPromoFeeTypeDiscStatusCode());
        setPromotionTypeId(from.getPromotionTypeId());
        setPromotionTypeStartDate(from.getPromotionTypeStartDate());
        setPromotionTypeEndDate(from.getPromotionTypeEndDate());
        setPromotionTypeCode(from.getPromotionTypeCode());
        setPromotionTypeName(from.getPromotionTypeName());
        setPromotionTypeDescription(from.getPromotionTypeDescription());
        setApplicationLevelId(from.getApplicationLevelId());
        setApplicationLevelCode(from.getApplicationLevelCode());
        setDiscountTypeId(from.getDiscountTypeId());
        setDiscountTypeCode(from.getDiscountTypeCode());
        setDiscountTypeName(from.getDiscountTypeName());
        setDiscountTypeDescription(from.getDiscountTypeDescription());
        setApplicationLevelDescription(from.getApplicationLevelDescription());
        setPromotionTypeDiscountValue(from.getPromotionTypeDiscountValue());
        setPromotionTypeStatusId(from.getPromotionTypeStatusId());
        setPromotionTypeStatusCode(from.getPromotionTypeStatusCode());
        setFeeTypeId(from.getFeeTypeId());
        setFeeTypeStartDate(from.getFeeTypeStartDate());
        setFeeTypeEndDate(from.getFeeTypeEndDate());
        setFeeTypeCode(from.getFeeTypeCode());
        setFeeTypeName(from.getFeeTypeName());
        setFeeTypeDescription(from.getFeeTypeDescription());
        setProrate(from.getProrate());
        setPrice(from.getPrice());
        setFeeTypeStatusId(from.getFeeTypeStatusId());
        setFeeTypeStatusCode(from.getFeeTypeStatusCode());
    }

    @Override
    public <E extends IVwPromotionFeeTypeDiscount> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VwPromotionFeeTypeDiscountRecord
     */
    public VwPromotionFeeTypeDiscountRecord() {
        super(VwPromotionFeeTypeDiscount.VW_PROMOTION_FEE_TYPE_DISCOUNT);
    }

    /**
     * Create a detached, initialised VwPromotionFeeTypeDiscountRecord
     */
    public VwPromotionFeeTypeDiscountRecord(Integer promoFeeTypeDiscountId, Integer promoFeeTypeDiscStatusId, String promoFeeTypeDiscStatusCode, Integer promotionTypeId, LocalDateTime promotionTypeStartDate, LocalDateTime promotionTypeEndDate, String promotionTypeCode, String promotionTypeName, String promotionTypeDescription, Integer applicationLevelId, String applicationLevelCode, Integer discountTypeId, String discountTypeCode, String discountTypeName, String discountTypeDescription, String applicationLevelDescription, BigDecimal promotionTypeDiscountValue, Integer promotionTypeStatusId, String promotionTypeStatusCode, Integer feeTypeId, LocalDateTime feeTypeStartDate, LocalDateTime feeTypeEndDate, String feeTypeCode, String feeTypeName, String feeTypeDescription, Boolean prorate, BigDecimal price, Integer feeTypeStatusId, String feeTypeStatusCode) {
        super(VwPromotionFeeTypeDiscount.VW_PROMOTION_FEE_TYPE_DISCOUNT);

        setPromoFeeTypeDiscountId(promoFeeTypeDiscountId);
        setPromoFeeTypeDiscStatusId(promoFeeTypeDiscStatusId);
        setPromoFeeTypeDiscStatusCode(promoFeeTypeDiscStatusCode);
        setPromotionTypeId(promotionTypeId);
        setPromotionTypeStartDate(promotionTypeStartDate);
        setPromotionTypeEndDate(promotionTypeEndDate);
        setPromotionTypeCode(promotionTypeCode);
        setPromotionTypeName(promotionTypeName);
        setPromotionTypeDescription(promotionTypeDescription);
        setApplicationLevelId(applicationLevelId);
        setApplicationLevelCode(applicationLevelCode);
        setDiscountTypeId(discountTypeId);
        setDiscountTypeCode(discountTypeCode);
        setDiscountTypeName(discountTypeName);
        setDiscountTypeDescription(discountTypeDescription);
        setApplicationLevelDescription(applicationLevelDescription);
        setPromotionTypeDiscountValue(promotionTypeDiscountValue);
        setPromotionTypeStatusId(promotionTypeStatusId);
        setPromotionTypeStatusCode(promotionTypeStatusCode);
        setFeeTypeId(feeTypeId);
        setFeeTypeStartDate(feeTypeStartDate);
        setFeeTypeEndDate(feeTypeEndDate);
        setFeeTypeCode(feeTypeCode);
        setFeeTypeName(feeTypeName);
        setFeeTypeDescription(feeTypeDescription);
        setProrate(prorate);
        setPrice(price);
        setFeeTypeStatusId(feeTypeStatusId);
        setFeeTypeStatusCode(feeTypeStatusCode);
    }
}
