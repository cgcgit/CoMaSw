/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.daos;


import com.comasw.model.tables.MtApplicationMenu;
import com.comasw.model.tables.records.MtApplicationMenuRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * Table that stores the application's menu
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MtApplicationMenuDao extends DAOImpl<MtApplicationMenuRecord, com.comasw.model.tables.pojos.MtApplicationMenu, Integer> {

    /**
     * Create a new MtApplicationMenuDao without any configuration
     */
    public MtApplicationMenuDao() {
        super(MtApplicationMenu.MT_APPLICATION_MENU, com.comasw.model.tables.pojos.MtApplicationMenu.class);
    }

    /**
     * Create a new MtApplicationMenuDao with an attached configuration
     */
    public MtApplicationMenuDao(Configuration configuration) {
        super(MtApplicationMenu.MT_APPLICATION_MENU, com.comasw.model.tables.pojos.MtApplicationMenu.class, configuration);
    }

    @Override
    public Integer getId(com.comasw.model.tables.pojos.MtApplicationMenu object) {
        return object.getApplicationMenuId();
    }

    /**
     * Fetch records that have <code>application_menu_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfApplicationMenuId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.APPLICATION_MENU_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>application_menu_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByApplicationMenuId(Integer... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.APPLICATION_MENU_ID, values);
    }

    /**
     * Fetch a unique record that has <code>application_menu_id = value</code>
     */
    public com.comasw.model.tables.pojos.MtApplicationMenu fetchOneByApplicationMenuId(Integer value) {
        return fetchOne(MtApplicationMenu.MT_APPLICATION_MENU.APPLICATION_MENU_ID, value);
    }

    /**
     * Fetch records that have <code>application_parent_menu_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfApplicationParentMenuId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.APPLICATION_PARENT_MENU_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>application_parent_menu_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByApplicationParentMenuId(Integer... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.APPLICATION_PARENT_MENU_ID, values);
    }

    /**
     * Fetch records that have <code>has_children BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfHasChildren(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.HAS_CHILDREN, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>has_children IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByHasChildren(Boolean... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.HAS_CHILDREN, values);
    }

    /**
     * Fetch records that have <code>menu_level BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfMenuLevel(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.MENU_LEVEL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>menu_level IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByMenuLevel(Integer... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.MENU_LEVEL, values);
    }

    /**
     * Fetch records that have <code>position BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfPosition(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.POSITION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>position IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByPosition(Integer... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.POSITION, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByName(String... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.NAME, values);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByDescription(String... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>profile_code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfProfileCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.PROFILE_CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>profile_code IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByProfileCode(String... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.PROFILE_CODE, values);
    }

    /**
     * Fetch records that have <code>page BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchRangeOfPage(String lowerInclusive, String upperInclusive) {
        return fetchRange(MtApplicationMenu.MT_APPLICATION_MENU.PAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>page IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.MtApplicationMenu> fetchByPage(String... values) {
        return fetch(MtApplicationMenu.MT_APPLICATION_MENU.PAGE, values);
    }
}
