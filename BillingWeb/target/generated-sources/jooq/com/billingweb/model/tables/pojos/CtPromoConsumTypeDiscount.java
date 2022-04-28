/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables.pojos;


import com.billingweb.model.tables.interfaces.ICtPromoConsumTypeDiscount;

import java.time.LocalDateTime;


/**
 * Table that stores the promotion fee discount relation types of the catalog 
 * for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtPromoConsumTypeDiscount implements ICtPromoConsumTypeDiscount {

    private static final long serialVersionUID = 1L;

    private Integer       promoConsumTypeDiscountId;
    private Integer       promotionTypeId;
    private Integer       consumptionTypeId;
    private Integer       statusId;
    private LocalDateTime inputDate;
    private String        inputUser;
    private LocalDateTime modifDate;
    private String        modifUser;

    public CtPromoConsumTypeDiscount() {}

    public CtPromoConsumTypeDiscount(ICtPromoConsumTypeDiscount value) {
        this.promoConsumTypeDiscountId = value.getPromoConsumTypeDiscountId();
        this.promotionTypeId = value.getPromotionTypeId();
        this.consumptionTypeId = value.getConsumptionTypeId();
        this.statusId = value.getStatusId();
        this.inputDate = value.getInputDate();
        this.inputUser = value.getInputUser();
        this.modifDate = value.getModifDate();
        this.modifUser = value.getModifUser();
    }

    public CtPromoConsumTypeDiscount(
        Integer       promoConsumTypeDiscountId,
        Integer       promotionTypeId,
        Integer       consumptionTypeId,
        Integer       statusId,
        LocalDateTime inputDate,
        String        inputUser,
        LocalDateTime modifDate,
        String        modifUser
    ) {
        this.promoConsumTypeDiscountId = promoConsumTypeDiscountId;
        this.promotionTypeId = promotionTypeId;
        this.consumptionTypeId = consumptionTypeId;
        this.statusId = statusId;
        this.inputDate = inputDate;
        this.inputUser = inputUser;
        this.modifDate = modifDate;
        this.modifUser = modifUser;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.promo_consum_type_discount_id</code>. Internal identifier of the promotion-consumption discount relation type
     */
    @Override
    public Integer getPromoConsumTypeDiscountId() {
        return this.promoConsumTypeDiscountId;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.promo_consum_type_discount_id</code>. Internal identifier of the promotion-consumption discount relation type
     */
    @Override
    public void setPromoConsumTypeDiscountId(Integer promoConsumTypeDiscountId) {
        this.promoConsumTypeDiscountId = promoConsumTypeDiscountId;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.promotion_type_id</code>. Promotion_type_id for the promotion-consumption discount relation
     */
    @Override
    public Integer getPromotionTypeId() {
        return this.promotionTypeId;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.promotion_type_id</code>. Promotion_type_id for the promotion-consumption discount relation
     */
    @Override
    public void setPromotionTypeId(Integer promotionTypeId) {
        this.promotionTypeId = promotionTypeId;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.consumption_type_id</code>. Consumption_type_id for the promotion-consumption discount relation
     */
    @Override
    public Integer getConsumptionTypeId() {
        return this.consumptionTypeId;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.consumption_type_id</code>. Consumption_type_id for the promotion-consumption discount relation
     */
    @Override
    public void setConsumptionTypeId(Integer consumptionTypeId) {
        this.consumptionTypeId = consumptionTypeId;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.status_id</code>. Status id for the promotion-consumption discount relation type
     */
    @Override
    public Integer getStatusId() {
        return this.statusId;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.status_id</code>. Status id for the promotion-consumption discount relation type
     */
    @Override
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.input_date</code>. Date on which the record was created
     */
    @Override
    public LocalDateTime getInputDate() {
        return this.inputDate;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.input_date</code>. Date on which the record was created
     */
    @Override
    public void setInputDate(LocalDateTime inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.input_user</code>. User who was modified the record
     */
    @Override
    public String getInputUser() {
        return this.inputUser;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.input_user</code>. User who was modified the record
     */
    @Override
    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public LocalDateTime getModifDate() {
        return this.modifDate;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public void setModifDate(LocalDateTime modifDate) {
        this.modifDate = modifDate;
    }

    /**
     * Getter for <code>public.ct_promo_consum_type_discount.modif_user</code>.
     */
    @Override
    public String getModifUser() {
        return this.modifUser;
    }

    /**
     * Setter for <code>public.ct_promo_consum_type_discount.modif_user</code>.
     */
    @Override
    public void setModifUser(String modifUser) {
        this.modifUser = modifUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CtPromoConsumTypeDiscount (");

        sb.append(promoConsumTypeDiscountId);
        sb.append(", ").append(promotionTypeId);
        sb.append(", ").append(consumptionTypeId);
        sb.append(", ").append(statusId);
        sb.append(", ").append(inputDate);
        sb.append(", ").append(inputUser);
        sb.append(", ").append(modifDate);
        sb.append(", ").append(modifUser);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ICtPromoConsumTypeDiscount from) {
        setPromoConsumTypeDiscountId(from.getPromoConsumTypeDiscountId());
        setPromotionTypeId(from.getPromotionTypeId());
        setConsumptionTypeId(from.getConsumptionTypeId());
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
}
