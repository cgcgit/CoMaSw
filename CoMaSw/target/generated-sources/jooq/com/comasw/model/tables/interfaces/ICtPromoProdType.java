/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.interfaces;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Table that stores the promotion product relation types of the catalog for 
 * the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ICtPromoProdType extends Serializable {

    /**
     * Setter for <code>public.ct_promo_prod_type.promo_prod_type_id</code>. Internal identifier of the promotion-product relation type
     */
    public void setPromoProdTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promo_prod_type.promo_prod_type_id</code>. Internal identifier of the promotion-product relation type
     */
    public Integer getPromoProdTypeId();

    /**
     * Setter for <code>public.ct_promo_prod_type.promotion_type_id</code>. Promotion_type_id for the promotion-product relation
     */
    public void setPromotionTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promo_prod_type.promotion_type_id</code>. Promotion_type_id for the promotion-product relation
     */
    public Integer getPromotionTypeId();

    /**
     * Setter for <code>public.ct_promo_prod_type.product_type_id</code>. Product_type_id for the promotion-product relation
     */
    public void setProductTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promo_prod_type.product_type_id</code>. Product_type_id for the promotion-product relation
     */
    public Integer getProductTypeId();

    /**
     * Setter for <code>public.ct_promo_prod_type.status_id</code>. Status id for the promotion-product relation type
     */
    public void setStatusId(Integer value);

    /**
     * Getter for <code>public.ct_promo_prod_type.status_id</code>. Status id for the promotion-product relation type
     */
    public Integer getStatusId();

    /**
     * Setter for <code>public.ct_promo_prod_type.input_date</code>. Date on which the record was created
     */
    public void setInputDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promo_prod_type.input_date</code>. Date on which the record was created
     */
    public LocalDateTime getInputDate();

    /**
     * Setter for <code>public.ct_promo_prod_type.input_user</code>. User who was modified the record
     */
    public void setInputUser(String value);

    /**
     * Getter for <code>public.ct_promo_prod_type.input_user</code>. User who was modified the record
     */
    public String getInputUser();

    /**
     * Setter for <code>public.ct_promo_prod_type.modif_date</code>. Date of the last modification of the record
     */
    public void setModifDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promo_prod_type.modif_date</code>. Date of the last modification of the record
     */
    public LocalDateTime getModifDate();

    /**
     * Setter for <code>public.ct_promo_prod_type.modif_user</code>.
     */
    public void setModifUser(String value);

    /**
     * Getter for <code>public.ct_promo_prod_type.modif_user</code>.
     */
    public String getModifUser();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ICtPromoProdType
     */
    public void from(ICtPromoProdType from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ICtPromoProdType
     */
    public <E extends ICtPromoProdType> E into(E into);
}