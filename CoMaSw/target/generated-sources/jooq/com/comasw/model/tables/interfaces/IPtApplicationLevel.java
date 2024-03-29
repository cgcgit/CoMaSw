/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.interfaces;


import java.io.Serializable;


/**
 * Table that stores the application level for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IPtApplicationLevel extends Serializable {

    /**
     * Setter for <code>public.pt_application_level.application_level_id</code>. Internal identifier of the application level
     */
    public void setApplicationLevelId(Integer value);

    /**
     * Getter for <code>public.pt_application_level.application_level_id</code>. Internal identifier of the application level
     */
    public Integer getApplicationLevelId();

    /**
     * Setter for <code>public.pt_application_level.code</code>. Code of the application level
     */
    public void setCode(String value);

    /**
     * Getter for <code>public.pt_application_level.code</code>. Code of the application level
     */
    public String getCode();

    /**
     * Setter for <code>public.pt_application_level.name</code>. Name of the application level
     */
    public void setName(String value);

    /**
     * Getter for <code>public.pt_application_level.name</code>. Name of the application level
     */
    public String getName();

    /**
     * Setter for <code>public.pt_application_level.description</code>. Description for the application level
     */
    public void setDescription(String value);

    /**
     * Getter for <code>public.pt_application_level.description</code>. Description for the application level
     */
    public String getDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IPtApplicationLevel
     */
    public void from(IPtApplicationLevel from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IPtApplicationLevel
     */
    public <E extends IPtApplicationLevel> E into(E into);
}
