/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.interfaces;


import java.io.Serializable;


/**
 * Table that stores application profiles
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IItProfiles extends Serializable {

    /**
     * Setter for <code>public.it_profiles.profile_id</code>. InternaL identifier of the profile
     */
    public void setProfileId(Integer value);

    /**
     * Getter for <code>public.it_profiles.profile_id</code>. InternaL identifier of the profile
     */
    public Integer getProfileId();

    /**
     * Setter for <code>public.it_profiles.profile_code</code>. Code of the profile
     */
    public void setProfileCode(String value);

    /**
     * Getter for <code>public.it_profiles.profile_code</code>. Code of the profile
     */
    public String getProfileCode();

    /**
     * Setter for <code>public.it_profiles.description</code>. Description for the profile
     */
    public void setDescription(String value);

    /**
     * Getter for <code>public.it_profiles.description</code>. Description for the profile
     */
    public String getDescription();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface IItProfiles
     */
    public void from(IItProfiles from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface IItProfiles
     */
    public <E extends IItProfiles> E into(E into);
}
