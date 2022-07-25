/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.pojos;


import com.comasw.model.tables.interfaces.ICtPromoProdType;

import java.time.LocalDateTime;


/**
 * Table that stores the promotion product relation types of the catalog for 
 * the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtPromoProdType implements ICtPromoProdType {

    private static final long serialVersionUID = 1L;

    private Integer       promoProdTypeId;
    private Integer       promotionTypeId;
    private Integer       productTypeId;
    private Integer       statusId;
    private LocalDateTime inputDate;
    private String        inputUser;
    private LocalDateTime modifDate;
    private String        modifUser;

    public CtPromoProdType() {}

    public CtPromoProdType(ICtPromoProdType value) {
        this.promoProdTypeId = value.getPromoProdTypeId();
        this.promotionTypeId = value.getPromotionTypeId();
        this.productTypeId = value.getProductTypeId();
        this.statusId = value.getStatusId();
        this.inputDate = value.getInputDate();
        this.inputUser = value.getInputUser();
        this.modifDate = value.getModifDate();
        this.modifUser = value.getModifUser();
    }

    public CtPromoProdType(
        Integer       promoProdTypeId,
        Integer       promotionTypeId,
        Integer       productTypeId,
        Integer       statusId,
        LocalDateTime inputDate,
        String        inputUser,
        LocalDateTime modifDate,
        String        modifUser
    ) {
        this.promoProdTypeId = promoProdTypeId;
        this.promotionTypeId = promotionTypeId;
        this.productTypeId = productTypeId;
        this.statusId = statusId;
        this.inputDate = inputDate;
        this.inputUser = inputUser;
        this.modifDate = modifDate;
        this.modifUser = modifUser;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.promo_prod_type_id</code>. Internal identifier of the promotion-product relation type
     */
    @Override
    public Integer getPromoProdTypeId() {
        return this.promoProdTypeId;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.promo_prod_type_id</code>. Internal identifier of the promotion-product relation type
     */
    @Override
    public void setPromoProdTypeId(Integer promoProdTypeId) {
        this.promoProdTypeId = promoProdTypeId;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.promotion_type_id</code>. Promotion_type_id for the promotion-product relation
     */
    @Override
    public Integer getPromotionTypeId() {
        return this.promotionTypeId;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.promotion_type_id</code>. Promotion_type_id for the promotion-product relation
     */
    @Override
    public void setPromotionTypeId(Integer promotionTypeId) {
        this.promotionTypeId = promotionTypeId;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.product_type_id</code>. Product_type_id for the promotion-product relation
     */
    @Override
    public Integer getProductTypeId() {
        return this.productTypeId;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.product_type_id</code>. Product_type_id for the promotion-product relation
     */
    @Override
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.status_id</code>. Status id for the promotion-product relation type
     */
    @Override
    public Integer getStatusId() {
        return this.statusId;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.status_id</code>. Status id for the promotion-product relation type
     */
    @Override
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.input_date</code>. Date on which the record was created
     */
    @Override
    public LocalDateTime getInputDate() {
        return this.inputDate;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.input_date</code>. Date on which the record was created
     */
    @Override
    public void setInputDate(LocalDateTime inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.input_user</code>. User who was modified the record
     */
    @Override
    public String getInputUser() {
        return this.inputUser;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.input_user</code>. User who was modified the record
     */
    @Override
    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public LocalDateTime getModifDate() {
        return this.modifDate;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public void setModifDate(LocalDateTime modifDate) {
        this.modifDate = modifDate;
    }

    /**
     * Getter for <code>public.ct_promo_prod_type.modif_user</code>.
     */
    @Override
    public String getModifUser() {
        return this.modifUser;
    }

    /**
     * Setter for <code>public.ct_promo_prod_type.modif_user</code>.
     */
    @Override
    public void setModifUser(String modifUser) {
        this.modifUser = modifUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CtPromoProdType (");

        sb.append(promoProdTypeId);
        sb.append(", ").append(promotionTypeId);
        sb.append(", ").append(productTypeId);
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
    public void from(ICtPromoProdType from) {
        setPromoProdTypeId(from.getPromoProdTypeId());
        setPromotionTypeId(from.getPromotionTypeId());
        setProductTypeId(from.getProductTypeId());
        setStatusId(from.getStatusId());
        setInputDate(from.getInputDate());
        setInputUser(from.getInputUser());
        setModifDate(from.getModifDate());
        setModifUser(from.getModifUser());
    }

    @Override
    public <E extends ICtPromoProdType> E into(E into) {
        into.from(this);
        return into;
    }
}