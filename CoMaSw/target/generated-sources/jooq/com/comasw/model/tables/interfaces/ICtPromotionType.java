/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.interfaces;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ICtPromotionType extends Serializable {

    /**
     * Setter for <code>public.ct_promotion_type.promotion_type_id</code>. Internal identifier of the promotion type
     */
    public void setPromotionTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promotion_type.promotion_type_id</code>. Internal identifier of the promotion type
     */
    public Integer getPromotionTypeId();

    /**
     * Setter for <code>public.ct_promotion_type.entity_type_id</code>. Entity_id for the promotion type
     */
    public void setEntityTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promotion_type.entity_type_id</code>. Entity_id for the promotion type
     */
    public Integer getEntityTypeId();

    /**
     * Setter for <code>public.ct_promotion_type.start_date</code>. Start_date for the promotion type
     */
    public void setStartDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promotion_type.start_date</code>. Start_date for the promotion type
     */
    public LocalDateTime getStartDate();

    /**
     * Setter for <code>public.ct_promotion_type.end_date</code>. End_date for the promotion type
     */
    public void setEndDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promotion_type.end_date</code>. End_date for the promotion type
     */
    public LocalDateTime getEndDate();

    /**
     * Setter for <code>public.ct_promotion_type.code</code>. Code of the promotion type
     */
    public void setCode(String value);

    /**
     * Getter for <code>public.ct_promotion_type.code</code>. Code of the promotion type
     */
    public String getCode();

    /**
     * Setter for <code>public.ct_promotion_type.name</code>. Name of the promotion type
     */
    public void setName(String value);

    /**
     * Getter for <code>public.ct_promotion_type.name</code>. Name of the promotion type
     */
    public String getName();

    /**
     * Setter for <code>public.ct_promotion_type.description</code>. Description for the promotion type
     */
    public void setDescription(String value);

    /**
     * Getter for <code>public.ct_promotion_type.description</code>. Description for the promotion type
     */
    public String getDescription();

    /**
     * Setter for <code>public.ct_promotion_type.application_level_id</code>. Application level id for the promotion type
     */
    public void setApplicationLevelId(Integer value);

    /**
     * Getter for <code>public.ct_promotion_type.application_level_id</code>. Application level id for the promotion type
     */
    public Integer getApplicationLevelId();

    /**
     * Setter for <code>public.ct_promotion_type.discount_type_id</code>. Discount Type id for the promotion type
     */
    public void setDiscountTypeId(Integer value);

    /**
     * Getter for <code>public.ct_promotion_type.discount_type_id</code>. Discount Type id for the promotion type
     */
    public Integer getDiscountTypeId();

    /**
     * Setter for <code>public.ct_promotion_type.discount_value</code>. Discount value for the promotion type
     */
    public void setDiscountValue(BigDecimal value);

    /**
     * Getter for <code>public.ct_promotion_type.discount_value</code>. Discount value for the promotion type
     */
    public BigDecimal getDiscountValue();

    /**
     * Setter for <code>public.ct_promotion_type.status_id</code>. Status id for the promotion type
     */
    public void setStatusId(Integer value);

    /**
     * Getter for <code>public.ct_promotion_type.status_id</code>. Status id for the promotion type
     */
    public Integer getStatusId();

    /**
     * Setter for <code>public.ct_promotion_type.input_date</code>. Date on which the record was created
     */
    public void setInputDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promotion_type.input_date</code>. Date on which the record was created
     */
    public LocalDateTime getInputDate();

    /**
     * Setter for <code>public.ct_promotion_type.input_user</code>. User who was created the record
     */
    public void setInputUser(String value);

    /**
     * Getter for <code>public.ct_promotion_type.input_user</code>. User who was created the record
     */
    public String getInputUser();

    /**
     * Setter for <code>public.ct_promotion_type.modif_date</code>. Date on which the record was modified (last modified)
     */
    public void setModifDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_promotion_type.modif_date</code>. Date on which the record was modified (last modified)
     */
    public LocalDateTime getModifDate();

    /**
     * Setter for <code>public.ct_promotion_type.modif_user</code>. User who was modified the record
     */
    public void setModifUser(String value);

    /**
     * Getter for <code>public.ct_promotion_type.modif_user</code>. User who was modified the record
     */
    public String getModifUser();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ICtPromotionType
     */
    public void from(ICtPromotionType from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ICtPromotionType
     */
    public <E extends ICtPromotionType> E into(E into);
}
