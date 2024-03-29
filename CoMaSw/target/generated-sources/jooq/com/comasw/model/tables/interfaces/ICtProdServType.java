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
public interface ICtProdServType extends Serializable {

    /**
     * Setter for <code>public.ct_prod_serv_type.prod_serv_type_id</code>. Internal identifier of the product-service relation type
     */
    public void setProdServTypeId(Integer value);

    /**
     * Getter for <code>public.ct_prod_serv_type.prod_serv_type_id</code>. Internal identifier of the product-service relation type
     */
    public Integer getProdServTypeId();

    /**
     * Setter for <code>public.ct_prod_serv_type.product_type_id</code>. Product_type_id for the product-service relation
     */
    public void setProductTypeId(Integer value);

    /**
     * Getter for <code>public.ct_prod_serv_type.product_type_id</code>. Product_type_id for the product-service relation
     */
    public Integer getProductTypeId();

    /**
     * Setter for <code>public.ct_prod_serv_type.service_type_id</code>. Service_type_id for the product-service relation
     */
    public void setServiceTypeId(Integer value);

    /**
     * Getter for <code>public.ct_prod_serv_type.service_type_id</code>. Service_type_id for the product-service relation
     */
    public Integer getServiceTypeId();

    /**
     * Setter for <code>public.ct_prod_serv_type.status_id</code>. Status id for the product-service relation type
     */
    public void setStatusId(Integer value);

    /**
     * Getter for <code>public.ct_prod_serv_type.status_id</code>. Status id for the product-service relation type
     */
    public Integer getStatusId();

    /**
     * Setter for <code>public.ct_prod_serv_type.input_date</code>. Date on which the record was created
     */
    public void setInputDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_prod_serv_type.input_date</code>. Date on which the record was created
     */
    public LocalDateTime getInputDate();

    /**
     * Setter for <code>public.ct_prod_serv_type.input_user</code>. User who was modified the record
     */
    public void setInputUser(String value);

    /**
     * Getter for <code>public.ct_prod_serv_type.input_user</code>. User who was modified the record
     */
    public String getInputUser();

    /**
     * Setter for <code>public.ct_prod_serv_type.modif_date</code>. Date of the last modification of the record
     */
    public void setModifDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_prod_serv_type.modif_date</code>. Date of the last modification of the record
     */
    public LocalDateTime getModifDate();

    /**
     * Setter for <code>public.ct_prod_serv_type.modif_user</code>.
     */
    public void setModifUser(String value);

    /**
     * Getter for <code>public.ct_prod_serv_type.modif_user</code>.
     */
    public String getModifUser();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ICtProdServType
     */
    public void from(ICtProdServType from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ICtProdServType
     */
    public <E extends ICtProdServType> E into(E into);
}
