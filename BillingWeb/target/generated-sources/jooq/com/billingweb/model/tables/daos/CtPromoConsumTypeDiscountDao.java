/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables.daos;


import com.billingweb.model.tables.CtPromoConsumTypeDiscount;
import com.billingweb.model.tables.records.CtPromoConsumTypeDiscountRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * Table that stores the promotion fee discount relation types of the catalog 
 * for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtPromoConsumTypeDiscountDao extends DAOImpl<CtPromoConsumTypeDiscountRecord, com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount, Integer> {

    /**
     * Create a new CtPromoConsumTypeDiscountDao without any configuration
     */
    public CtPromoConsumTypeDiscountDao() {
        super(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT, com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount.class);
    }

    /**
     * Create a new CtPromoConsumTypeDiscountDao with an attached configuration
     */
    public CtPromoConsumTypeDiscountDao(Configuration configuration) {
        super(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT, com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount.class, configuration);
    }

    @Override
    public Integer getId(com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount object) {
        return object.getPromoConsumTypeDiscountId();
    }

    /**
     * Fetch records that have <code>promo_consum_type_discount_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfPromoConsumTypeDiscountId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.PROMO_CONSUM_TYPE_DISCOUNT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>promo_consum_type_discount_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByPromoConsumTypeDiscountId(Integer... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.PROMO_CONSUM_TYPE_DISCOUNT_ID, values);
    }

    /**
     * Fetch a unique record that has <code>promo_consum_type_discount_id = value</code>
     */
    public com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount fetchOneByPromoConsumTypeDiscountId(Integer value) {
        return fetchOne(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.PROMO_CONSUM_TYPE_DISCOUNT_ID, value);
    }

    /**
     * Fetch records that have <code>promotion_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfPromotionTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.PROMOTION_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>promotion_type_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByPromotionTypeId(Integer... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.PROMOTION_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>consumption_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfConsumptionTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.CONSUMPTION_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>consumption_type_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByConsumptionTypeId(Integer... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.CONSUMPTION_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>status_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfStatusId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.STATUS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByStatusId(Integer... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.STATUS_ID, values);
    }

    /**
     * Fetch records that have <code>input_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfInputDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.INPUT_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_date IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByInputDate(LocalDateTime... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.INPUT_DATE, values);
    }

    /**
     * Fetch records that have <code>input_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfInputUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.INPUT_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_user IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByInputUser(String... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.INPUT_USER, values);
    }

    /**
     * Fetch records that have <code>modif_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfModifDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.MODIF_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_date IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByModifDate(LocalDateTime... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.MODIF_DATE, values);
    }

    /**
     * Fetch records that have <code>modif_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchRangeOfModifUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.MODIF_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_user IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtPromoConsumTypeDiscount> fetchByModifUser(String... values) {
        return fetch(CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT.MODIF_USER, values);
    }
}
