/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables.daos;


import com.billingweb.model.tables.CtAccountType;
import com.billingweb.model.tables.records.CtAccountTypeRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * Table that stores the account types of the catalog for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtAccountTypeDao extends DAOImpl<CtAccountTypeRecord, com.billingweb.model.tables.pojos.CtAccountType, Integer> {

    /**
     * Create a new CtAccountTypeDao without any configuration
     */
    public CtAccountTypeDao() {
        super(CtAccountType.CT_ACCOUNT_TYPE, com.billingweb.model.tables.pojos.CtAccountType.class);
    }

    /**
     * Create a new CtAccountTypeDao with an attached configuration
     */
    public CtAccountTypeDao(Configuration configuration) {
        super(CtAccountType.CT_ACCOUNT_TYPE, com.billingweb.model.tables.pojos.CtAccountType.class, configuration);
    }

    @Override
    public Integer getId(com.billingweb.model.tables.pojos.CtAccountType object) {
        return object.getAccountTypeId();
    }

    /**
     * Fetch records that have <code>account_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfAccountTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.ACCOUNT_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>account_type_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByAccountTypeId(Integer... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.ACCOUNT_TYPE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>account_type_id = value</code>
     */
    public com.billingweb.model.tables.pojos.CtAccountType fetchOneByAccountTypeId(Integer value) {
        return fetchOne(CtAccountType.CT_ACCOUNT_TYPE.ACCOUNT_TYPE_ID, value);
    }

    /**
     * Fetch records that have <code>entity_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfEntityTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.ENTITY_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>entity_type_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByEntityTypeId(Integer... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.ENTITY_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByCode(String... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.CODE, values);
    }

    /**
     * Fetch a unique record that has <code>code = value</code>
     */
    public com.billingweb.model.tables.pojos.CtAccountType fetchOneByCode(String value) {
        return fetchOne(CtAccountType.CT_ACCOUNT_TYPE.CODE, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByName(String... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public com.billingweb.model.tables.pojos.CtAccountType fetchOneByName(String value) {
        return fetchOne(CtAccountType.CT_ACCOUNT_TYPE.NAME, value);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByDescription(String... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>ordinary_bill_cycle_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfOrdinaryBillCycleTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.ORDINARY_BILL_CYCLE_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>ordinary_bill_cycle_type_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByOrdinaryBillCycleTypeId(Integer... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.ORDINARY_BILL_CYCLE_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>corrective_bill_cycle_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfCorrectiveBillCycleTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.CORRECTIVE_BILL_CYCLE_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>corrective_bill_cycle_type_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByCorrectiveBillCycleTypeId(Integer... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.CORRECTIVE_BILL_CYCLE_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>status_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfStatusId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.STATUS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByStatusId(Integer... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.STATUS_ID, values);
    }

    /**
     * Fetch records that have <code>input_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfInputDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.INPUT_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_date IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByInputDate(LocalDateTime... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.INPUT_DATE, values);
    }

    /**
     * Fetch records that have <code>input_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfInputUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.INPUT_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_user IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByInputUser(String... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.INPUT_USER, values);
    }

    /**
     * Fetch records that have <code>modif_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfModifDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.MODIF_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_date IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByModifDate(LocalDateTime... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.MODIF_DATE, values);
    }

    /**
     * Fetch records that have <code>modif_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfModifUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.MODIF_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_user IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByModifUser(String... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.MODIF_USER, values);
    }

    /**
     * Fetch records that have <code>payment_method_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchRangeOfPaymentMethodId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtAccountType.CT_ACCOUNT_TYPE.PAYMENT_METHOD_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>payment_method_id IN (values)</code>
     */
    public List<com.billingweb.model.tables.pojos.CtAccountType> fetchByPaymentMethodId(Integer... values) {
        return fetch(CtAccountType.CT_ACCOUNT_TYPE.PAYMENT_METHOD_ID, values);
    }
}
