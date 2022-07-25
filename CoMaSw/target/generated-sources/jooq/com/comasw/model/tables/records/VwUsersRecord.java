/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.records;


import com.comasw.model.tables.VwUsers;
import com.comasw.model.tables.interfaces.IVwUsers;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VwUsersRecord extends TableRecordImpl<VwUsersRecord> implements Record5<Integer, String, String, Integer, String>, IVwUsers {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.vw_users.user_id</code>.
     */
    @Override
    public void setUserId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.vw_users.user_id</code>.
     */
    @Override
    public Integer getUserId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.vw_users.user_code</code>.
     */
    @Override
    public void setUserCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.vw_users.user_code</code>.
     */
    @Override
    public String getUserCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.vw_users.password</code>.
     */
    @Override
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.vw_users.password</code>.
     */
    @Override
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.vw_users.profile_id</code>.
     */
    @Override
    public void setProfileId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.vw_users.profile_id</code>.
     */
    @Override
    public Integer getProfileId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.vw_users.profile_code</code>.
     */
    @Override
    public void setProfileCode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.vw_users.profile_code</code>.
     */
    @Override
    public String getProfileCode() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, Integer, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return VwUsers.VW_USERS.USER_ID;
    }

    @Override
    public Field<String> field2() {
        return VwUsers.VW_USERS.USER_CODE;
    }

    @Override
    public Field<String> field3() {
        return VwUsers.VW_USERS.PASSWORD;
    }

    @Override
    public Field<Integer> field4() {
        return VwUsers.VW_USERS.PROFILE_ID;
    }

    @Override
    public Field<String> field5() {
        return VwUsers.VW_USERS.PROFILE_CODE;
    }

    @Override
    public Integer component1() {
        return getUserId();
    }

    @Override
    public String component2() {
        return getUserCode();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public Integer component4() {
        return getProfileId();
    }

    @Override
    public String component5() {
        return getProfileCode();
    }

    @Override
    public Integer value1() {
        return getUserId();
    }

    @Override
    public String value2() {
        return getUserCode();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public Integer value4() {
        return getProfileId();
    }

    @Override
    public String value5() {
        return getProfileCode();
    }

    @Override
    public VwUsersRecord value1(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public VwUsersRecord value2(String value) {
        setUserCode(value);
        return this;
    }

    @Override
    public VwUsersRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public VwUsersRecord value4(Integer value) {
        setProfileId(value);
        return this;
    }

    @Override
    public VwUsersRecord value5(String value) {
        setProfileCode(value);
        return this;
    }

    @Override
    public VwUsersRecord values(Integer value1, String value2, String value3, Integer value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IVwUsers from) {
        setUserId(from.getUserId());
        setUserCode(from.getUserCode());
        setPassword(from.getPassword());
        setProfileId(from.getProfileId());
        setProfileCode(from.getProfileCode());
    }

    @Override
    public <E extends IVwUsers> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VwUsersRecord
     */
    public VwUsersRecord() {
        super(VwUsers.VW_USERS);
    }

    /**
     * Create a detached, initialised VwUsersRecord
     */
    public VwUsersRecord(Integer userId, String userCode, String password, Integer profileId, String profileCode) {
        super(VwUsers.VW_USERS);

        setUserId(userId);
        setUserCode(userCode);
        setPassword(password);
        setProfileId(profileId);
        setProfileCode(profileCode);
    }
}