/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.interfaces;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Table that stores the promotion service relation types of the catalog for 
 * the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ICtPromoServType extends Serializable {

    /**
     * Setter for <code>public.ct_promo_serv_type.promo_serv_type_id</code>. Internal identifier of the promotion-service relation type
     */
    public void setPromoServTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promo_serv_type.promo_serv_type_id</code>. Internal identifier of the promotion-service relation type
     */
    public Integer getPromoServTypeId();

    /**
     * Setter for <code>public.ct_promo_serv_type.promotion_type_id</code>. Promotion_type_id for the promotion-service relation
     */
    public void setPromotionTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promo_serv_type.promotion_type_id</code>. Promotion_type_id for the promotion-service relation
     */
    public Integer getPromotionTypeId();

    /**
     * Setter for <code>public.ct_promo_serv_type.service_type_id</code>. Service_type_id for the promotion-service relation
     */
    public void setServiceTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promo_serv_type.service_type_id</code>. Service_type_id for the promotion-service relation
     */
    public Integer getServiceTypeId();

    /**
     * Setter for <code>public.ct_promo_serv_type.status_id</code>. Status id for the promotion-service relation type
     */
    public void setStatusId(Integer value);

    /**
     * Getter for <code>public.ct_promo_serv_type.status_id</code>. Status id for the promotion-service relation type
     */
    public Integer getStatusId();

    /**
     * Setter for <code>public.ct_promo_serv_type.input_date</code>. Date on which the record was created
     */
    public void setInputDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promo_serv_type.input_date</code>. Date on which the record was created
     */
    public LocalDateTime getInputDate();

    /**
     * Setter for <code>public.ct_promo_serv_type.input_user</code>. User who was modified the record
     */
    public void setInputUser(String value);

    /**
     * Getter for <code>public.ct_promo_serv_type.input_user</code>. User who was modified the record
     */
    public String getInputUser();

    /**
     * Setter for <code>public.ct_promo_serv_type.modif_date</code>. Date of the last modification of the record
     */
    public void setModifDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promo_serv_type.modif_date</code>. Date of the last modification of the record
     */
    public LocalDateTime getModifDate();

    /**
     * Setter for <code>public.ct_promo_serv_type.modif_user</code>.
     */
    public void setModifUser(String value);

    /**
     * Getter for <code>public.ct_promo_serv_type.modif_user</code>.
     */
    public String getModifUser();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ICtPromoServType
     */
    public void from(ICtPromoServType from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ICtPromoServType
     */
    public <E extends ICtPromoServType> E into(E into);
}