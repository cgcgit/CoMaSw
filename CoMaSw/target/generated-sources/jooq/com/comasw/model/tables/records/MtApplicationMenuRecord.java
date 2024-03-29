/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.records;


import com.comasw.model.tables.MtApplicationMenu;
import com.comasw.model.tables.interfaces.IMtApplicationMenu;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Table that stores the application's menu
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MtApplicationMenuRecord extends UpdatableRecordImpl<MtApplicationMenuRecord> implements Record9<Integer, Integer, Boolean, Integer, Integer, String, String, String, String>, IMtApplicationMenu {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.mt_application_menu.application_menu_id</code>. Internal identifier of the menu item
     */
    @Override
    public void setApplicationMenuId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.application_menu_id</code>. Internal identifier of the menu item
     */
    @Override
    public Integer getApplicationMenuId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.mt_application_menu.application_parent_menu_id</code>. Internal identifier of the parent menu item, if exists
     */
    @Override
    public void setApplicationParentMenuId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.application_parent_menu_id</code>. Internal identifier of the parent menu item, if exists
     */
    @Override
    public Integer getApplicationParentMenuId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.mt_application_menu.has_children</code>. Flag that indicates if the item menu has children (true or false)
     */
    @Override
    public void setHasChildren(Boolean value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.has_children</code>. Flag that indicates if the item menu has children (true or false)
     */
    @Override
    public Boolean getHasChildren() {
        return (Boolean) get(2);
    }

    /**
     * Setter for <code>public.mt_application_menu.menu_level</code>. Level of the menu item in the menu hierarchy
     */
    @Override
    public void setMenuLevel(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.menu_level</code>. Level of the menu item in the menu hierarchy
     */
    @Override
    public Integer getMenuLevel() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.mt_application_menu.position</code>. Position of the menu item in the menu level
     */
    @Override
    public void setPosition(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.position</code>. Position of the menu item in the menu level
     */
    @Override
    public Integer getPosition() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.mt_application_menu.name</code>. Name to shown in the menu application
     */
    @Override
    public void setName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.name</code>. Name to shown in the menu application
     */
    @Override
    public String getName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.mt_application_menu.description</code>. Description of the menu item
     */
    @Override
    public void setDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.description</code>. Description of the menu item
     */
    @Override
    public String getDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.mt_application_menu.profile_code</code>. Profiles authoriced to see the menu item
     */
    @Override
    public void setProfileCode(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.profile_code</code>. Profiles authoriced to see the menu item
     */
    @Override
    public String getProfileCode() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.mt_application_menu.page</code>. JSF to redirect when the menu item is selected
     */
    @Override
    public void setPage(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.mt_application_menu.page</code>. JSF to redirect when the menu item is selected
     */
    @Override
    public String getPage() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, Boolean, Integer, Integer, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, Integer, Boolean, Integer, Integer, String, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return MtApplicationMenu.MT_APPLICATION_MENU.APPLICATION_MENU_ID;
    }

    @Override
    public Field<Integer> field2() {
        return MtApplicationMenu.MT_APPLICATION_MENU.APPLICATION_PARENT_MENU_ID;
    }

    @Override
    public Field<Boolean> field3() {
        return MtApplicationMenu.MT_APPLICATION_MENU.HAS_CHILDREN;
    }

    @Override
    public Field<Integer> field4() {
        return MtApplicationMenu.MT_APPLICATION_MENU.MENU_LEVEL;
    }

    @Override
    public Field<Integer> field5() {
        return MtApplicationMenu.MT_APPLICATION_MENU.POSITION;
    }

    @Override
    public Field<String> field6() {
        return MtApplicationMenu.MT_APPLICATION_MENU.NAME;
    }

    @Override
    public Field<String> field7() {
        return MtApplicationMenu.MT_APPLICATION_MENU.DESCRIPTION;
    }

    @Override
    public Field<String> field8() {
        return MtApplicationMenu.MT_APPLICATION_MENU.PROFILE_CODE;
    }

    @Override
    public Field<String> field9() {
        return MtApplicationMenu.MT_APPLICATION_MENU.PAGE;
    }

    @Override
    public Integer component1() {
        return getApplicationMenuId();
    }

    @Override
    public Integer component2() {
        return getApplicationParentMenuId();
    }

    @Override
    public Boolean component3() {
        return getHasChildren();
    }

    @Override
    public Integer component4() {
        return getMenuLevel();
    }

    @Override
    public Integer component5() {
        return getPosition();
    }

    @Override
    public String component6() {
        return getName();
    }

    @Override
    public String component7() {
        return getDescription();
    }

    @Override
    public String component8() {
        return getProfileCode();
    }

    @Override
    public String component9() {
        return getPage();
    }

    @Override
    public Integer value1() {
        return getApplicationMenuId();
    }

    @Override
    public Integer value2() {
        return getApplicationParentMenuId();
    }

    @Override
    public Boolean value3() {
        return getHasChildren();
    }

    @Override
    public Integer value4() {
        return getMenuLevel();
    }

    @Override
    public Integer value5() {
        return getPosition();
    }

    @Override
    public String value6() {
        return getName();
    }

    @Override
    public String value7() {
        return getDescription();
    }

    @Override
    public String value8() {
        return getProfileCode();
    }

    @Override
    public String value9() {
        return getPage();
    }

    @Override
    public MtApplicationMenuRecord value1(Integer value) {
        setApplicationMenuId(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value2(Integer value) {
        setApplicationParentMenuId(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value3(Boolean value) {
        setHasChildren(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value4(Integer value) {
        setMenuLevel(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value5(Integer value) {
        setPosition(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value6(String value) {
        setName(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value7(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value8(String value) {
        setProfileCode(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord value9(String value) {
        setPage(value);
        return this;
    }

    @Override
    public MtApplicationMenuRecord values(Integer value1, Integer value2, Boolean value3, Integer value4, Integer value5, String value6, String value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IMtApplicationMenu from) {
        setApplicationMenuId(from.getApplicationMenuId());
        setApplicationParentMenuId(from.getApplicationParentMenuId());
        setHasChildren(from.getHasChildren());
        setMenuLevel(from.getMenuLevel());
        setPosition(from.getPosition());
        setName(from.getName());
        setDescription(from.getDescription());
        setProfileCode(from.getProfileCode());
        setPage(from.getPage());
    }

    @Override
    public <E extends IMtApplicationMenu> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MtApplicationMenuRecord
     */
    public MtApplicationMenuRecord() {
        super(MtApplicationMenu.MT_APPLICATION_MENU);
    }

    /**
     * Create a detached, initialised MtApplicationMenuRecord
     */
    public MtApplicationMenuRecord(Integer applicationMenuId, Integer applicationParentMenuId, Boolean hasChildren, Integer menuLevel, Integer position, String name, String description, String profileCode, String page) {
        super(MtApplicationMenu.MT_APPLICATION_MENU);

        setApplicationMenuId(applicationMenuId);
        setApplicationParentMenuId(applicationParentMenuId);
        setHasChildren(hasChildren);
        setMenuLevel(menuLevel);
        setPosition(position);
        setName(name);
        setDescription(description);
        setProfileCode(profileCode);
        setPage(page);
    }
}
