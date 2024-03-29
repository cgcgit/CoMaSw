/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.daos;


import com.comasw.model.tables.CtConsumptionType;
import com.comasw.model.tables.records.CtConsumptionTypeRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * Table that stores the consumption types of the catalog for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtConsumptionTypeDao extends DAOImpl<CtConsumptionTypeRecord, com.comasw.model.tables.pojos.CtConsumptionType, Integer> {

    /**
     * Create a new CtConsumptionTypeDao without any configuration
     */
    public CtConsumptionTypeDao() {
        super(CtConsumptionType.CT_CONSUMPTION_TYPE, com.comasw.model.tables.pojos.CtConsumptionType.class);
    }

    /**
     * Create a new CtConsumptionTypeDao with an attached configuration
     */
    public CtConsumptionTypeDao(Configuration configuration) {
        super(CtConsumptionType.CT_CONSUMPTION_TYPE, com.comasw.model.tables.pojos.CtConsumptionType.class, configuration);
    }

    @Override
    public Integer getId(com.comasw.model.tables.pojos.CtConsumptionType object) {
        return object.getConsumptionTypeId();
    }

    /**
     * Fetch records that have <code>consumption_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfConsumptionTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.CONSUMPTION_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>consumption_type_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByConsumptionTypeId(Integer... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.CONSUMPTION_TYPE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>consumption_type_id = value</code>
     */
    public com.comasw.model.tables.pojos.CtConsumptionType fetchOneByConsumptionTypeId(Integer value) {
        return fetchOne(CtConsumptionType.CT_CONSUMPTION_TYPE.CONSUMPTION_TYPE_ID, value);
    }

    /**
     * Fetch records that have <code>entity_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfEntityTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.ENTITY_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>entity_type_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByEntityTypeId(Integer... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.ENTITY_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByCode(String... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.CODE, values);
    }

    /**
     * Fetch a unique record that has <code>code = value</code>
     */
    public com.comasw.model.tables.pojos.CtConsumptionType fetchOneByCode(String value) {
        return fetchOne(CtConsumptionType.CT_CONSUMPTION_TYPE.CODE, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByName(String... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public com.comasw.model.tables.pojos.CtConsumptionType fetchOneByName(String value) {
        return fetchOne(CtConsumptionType.CT_CONSUMPTION_TYPE.NAME, value);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByDescription(String... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>status_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfStatusId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.STATUS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByStatusId(Integer... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.STATUS_ID, values);
    }

    /**
     * Fetch records that have <code>input_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfInputDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.INPUT_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_date IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByInputDate(LocalDateTime... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.INPUT_DATE, values);
    }

    /**
     * Fetch records that have <code>input_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfInputUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.INPUT_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_user IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByInputUser(String... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.INPUT_USER, values);
    }

    /**
     * Fetch records that have <code>modif_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfModifDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.MODIF_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_date IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByModifDate(LocalDateTime... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.MODIF_DATE, values);
    }

    /**
     * Fetch records that have <code>modif_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfModifUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.MODIF_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_user IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByModifUser(String... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.MODIF_USER, values);
    }

    /**
     * Fetch records that have <code>consumption_class_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchRangeOfConsumptionClassId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtConsumptionType.CT_CONSUMPTION_TYPE.CONSUMPTION_CLASS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>consumption_class_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtConsumptionType> fetchByConsumptionClassId(Integer... values) {
        return fetch(CtConsumptionType.CT_CONSUMPTION_TYPE.CONSUMPTION_CLASS_ID, values);
    }
}
