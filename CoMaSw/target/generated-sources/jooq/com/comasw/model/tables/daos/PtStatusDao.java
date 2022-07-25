/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.daos;


import com.comasw.model.tables.PtStatus;
import com.comasw.model.tables.records.PtStatusRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * Table that stores the status for the entities of the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PtStatusDao extends DAOImpl<PtStatusRecord, com.comasw.model.tables.pojos.PtStatus, Integer> {

    /**
     * Create a new PtStatusDao without any configuration
     */
    public PtStatusDao() {
        super(PtStatus.PT_STATUS, com.comasw.model.tables.pojos.PtStatus.class);
    }

    /**
     * Create a new PtStatusDao with an attached configuration
     */
    public PtStatusDao(Configuration configuration) {
        super(PtStatus.PT_STATUS, com.comasw.model.tables.pojos.PtStatus.class, configuration);
    }

    @Override
    public Integer getId(com.comasw.model.tables.pojos.PtStatus object) {
        return object.getStatusId();
    }

    /**
     * Fetch records that have <code>status_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchRangeOfStatusId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(PtStatus.PT_STATUS.STATUS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchByStatusId(Integer... values) {
        return fetch(PtStatus.PT_STATUS.STATUS_ID, values);
    }

    /**
     * Fetch a unique record that has <code>status_id = value</code>
     */
    public com.comasw.model.tables.pojos.PtStatus fetchOneByStatusId(Integer value) {
        return fetchOne(PtStatus.PT_STATUS.STATUS_ID, value);
    }

    /**
     * Fetch records that have <code>code BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchRangeOfCode(String lowerInclusive, String upperInclusive) {
        return fetchRange(PtStatus.PT_STATUS.CODE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>code IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchByCode(String... values) {
        return fetch(PtStatus.PT_STATUS.CODE, values);
    }

    /**
     * Fetch a unique record that has <code>code = value</code>
     */
    public com.comasw.model.tables.pojos.PtStatus fetchOneByCode(String value) {
        return fetchOne(PtStatus.PT_STATUS.CODE, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(PtStatus.PT_STATUS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchByName(String... values) {
        return fetch(PtStatus.PT_STATUS.NAME, values);
    }

    /**
     * Fetch a unique record that has <code>name = value</code>
     */
    public com.comasw.model.tables.pojos.PtStatus fetchOneByName(String value) {
        return fetchOne(PtStatus.PT_STATUS.NAME, value);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(PtStatus.PT_STATUS.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.PtStatus> fetchByDescription(String... values) {
        return fetch(PtStatus.PT_STATUS.DESCRIPTION, values);
    }
}