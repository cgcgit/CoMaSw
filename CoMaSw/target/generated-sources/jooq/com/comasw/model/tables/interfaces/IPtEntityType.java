/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.interfaces;


import java.io.Serializable;


/**
 * Table that stores the entity type of the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IPtEntityType extends Serializable {

    /**
     * Setter for <code>public.pt_entity_type.entity_type_id</code>. Internal identifier of the entity type
     */
    public void setEntityTypeId(Integer value);

    /**
     * Getter for <code>public.pt_entity_type.entity_type_id</code>. Internal identifier of the entity type
     */
    public Integer getEntityTypeId();

    /**
     * Setter for <code>public.pt_entity_type.code</code>. Code of the entity type
     */
    public void setCode(String value);

    /**
     * Getter for <code>public.pt_entity_type.code</code>. Code of the entity type
     */
    public String getCode();

    /**
     * Setter for <code>public.pt_entity_type.name</code>. Name of the entity type
     */
    public void setName(String value);

    /**
     * Getter for <code>public.pt_entity_type.name</code>. Name of the entity type
     */
    public String getName();

    /**
     * Setter for <code>public.pt_entity_type.description</code>. Description for the entity type
     */
    public void setDescription(String value);

    /**
     * Getter for <code>public.pt_entity_type.description</code>. Description for the entity type
     */
    public String getDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IPtEntityType
     */
    public void from(IPtEntityType from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IPtEntityType
     */
    public <E extends IPtEntityType> E into(E into);
}
