/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.daos;


import com.comasw.model.tables.CtProdServType;
import com.comasw.model.tables.records.CtProdServTypeRecord;

import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * Table that stores the promotion product relation types of the catalog for 
 * the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtProdServTypeDao extends DAOImpl<CtProdServTypeRecord, com.comasw.model.tables.pojos.CtProdServType, Integer> {

    /**
     * Create a new CtProdServTypeDao without any configuration
     */
    public CtProdServTypeDao() {
        super(CtProdServType.CT_PROD_SERV_TYPE, com.comasw.model.tables.pojos.CtProdServType.class);
    }

    /**
     * Create a new CtProdServTypeDao with an attached configuration
     */
    public CtProdServTypeDao(Configuration configuration) {
        super(CtProdServType.CT_PROD_SERV_TYPE, com.comasw.model.tables.pojos.CtProdServType.class, configuration);
    }

    @Override
    public Integer getId(com.comasw.model.tables.pojos.CtProdServType object) {
        return object.getProdServTypeId();
    }

    /**
     * Fetch records that have <code>prod_serv_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfProdServTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.PROD_SERV_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>prod_serv_type_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByProdServTypeId(Integer... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.PROD_SERV_TYPE_ID, values);
    }

    /**
     * Fetch a unique record that has <code>prod_serv_type_id = value</code>
     */
    public com.comasw.model.tables.pojos.CtProdServType fetchOneByProdServTypeId(Integer value) {
        return fetchOne(CtProdServType.CT_PROD_SERV_TYPE.PROD_SERV_TYPE_ID, value);
    }

    /**
     * Fetch records that have <code>product_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfProductTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.PRODUCT_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>product_type_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByProductTypeId(Integer... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.PRODUCT_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>service_type_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfServiceTypeId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.SERVICE_TYPE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>service_type_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByServiceTypeId(Integer... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.SERVICE_TYPE_ID, values);
    }

    /**
     * Fetch records that have <code>status_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfStatusId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.STATUS_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>status_id IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByStatusId(Integer... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.STATUS_ID, values);
    }

    /**
     * Fetch records that have <code>input_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfInputDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.INPUT_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_date IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByInputDate(LocalDateTime... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.INPUT_DATE, values);
    }

    /**
     * Fetch records that have <code>input_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfInputUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.INPUT_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>input_user IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByInputUser(String... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.INPUT_USER, values);
    }

    /**
     * Fetch records that have <code>modif_date BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfModifDate(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.MODIF_DATE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_date IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByModifDate(LocalDateTime... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.MODIF_DATE, values);
    }

    /**
     * Fetch records that have <code>modif_user BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchRangeOfModifUser(String lowerInclusive, String upperInclusive) {
        return fetchRange(CtProdServType.CT_PROD_SERV_TYPE.MODIF_USER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>modif_user IN (values)</code>
     */
    public List<com.comasw.model.tables.pojos.CtProdServType> fetchByModifUser(String... values) {
        return fetch(CtProdServType.CT_PROD_SERV_TYPE.MODIF_USER, values);
    }
}
