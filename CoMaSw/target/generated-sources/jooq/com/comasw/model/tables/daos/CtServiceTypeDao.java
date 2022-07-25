/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.daos;


import com.comasw.model.tables.CtServiceType;
import com.comasw.model.tables.records.CtServiceTypeRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * Table that stores the service types of the catalog for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtServiceTypeDao extends DAOImpl<CtServiceTypeRecord, com.comasw.model.tables.pojos.CtServiceType, Integer> {

    /**
     * Create a new CtServiceTypeDao without any configuration
     */
    public CtServiceTypeDao() {
        super(CtServiceType.CT_SERVICE_TYPE, com.comasw.model.tables.pojos.CtServiceType.class);
    }

    /**
     * Create a new CtServiceTypeDao with an attached configuration
     */
    public CtServiceTypeDao(Configuration configuration) {
        super(CtServiceType.CT_SERVICE_TYPE, com.comasw.model.tables.pojos.CtServiceType.class, configuration);
    }

    @Override
    public Integer getId(com.comasw.model.tables.pojos.CtServiceType object) {
        return object.getServiceTypeId();
    }

    /**
     * Fetch records that have <code>service_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfServiceTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.SERVICE_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>service_type_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByServiceTypeId(Integer... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.SERVICE_TYPE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>service_type_id = value</code>
     */
    public com.comasw.model.tables.pojos.CtServiceType fetchOneByServiceTypeId(Integer value) {
        return fetchOne(CtServiceType.CT_SERVICE_TYPE.SERVICE_TYPE_ID, value);
    }

    /**
     * Fetch records that have <code>entity_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfEntityTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.ENTITY_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>entity_type_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByEntityTypeId(Integer... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.ENTITY_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByCode(String... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.CODE, values);
    }

    /**
     * Fetch a unique record that has <code>code = value</code>
     */
    public com.comasw.model.tables.pojos.CtServiceType fetchOneByCode(String value) {
        return fetchOne(CtServiceType.CT_SERVICE_TYPE.CODE, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByName(String... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public com.comasw.model.tables.pojos.CtServiceType fetchOneByName(String value) {
        return fetchOne(CtServiceType.CT_SERVICE_TYPE.NAME, value);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByDescription(String... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>status_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfStatusId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.STATUS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByStatusId(Integer... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.STATUS_ID, values);
    }

    /**
     * Fetch records that have <code>input_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfInputDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.INPUT_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_date IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByInputDate(LocalDateTime... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.INPUT_DATE, values);
    }

    /**
     * Fetch records that have <code>input_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfInputUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.INPUT_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_user IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByInputUser(String... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.INPUT_USER, values);
    }

    /**
     * Fetch records that have <code>modif_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfModifDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.MODIF_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_date IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByModifDate(LocalDateTime... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.MODIF_DATE, values);
    }

    /**
     * Fetch records that have <code>modif_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchRangeOfModifUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtServiceType.CT_SERVICE_TYPE.MODIF_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_user IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtServiceType> fetchByModifUser(String... values) {
        return fetch(CtServiceType.CT_SERVICE_TYPE.MODIF_USER, values);
    }
}