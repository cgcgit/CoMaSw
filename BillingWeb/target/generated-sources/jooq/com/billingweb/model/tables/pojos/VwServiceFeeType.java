/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables.pojos;


import com.billingweb.model.tables.interfaces.IVwServiceFeeType;

import java.math.BigDecimal;


/**
 * View showing the relationship between service types and the fee types associated 
 * with them - related to ct_serv_fee_type
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VwServiceFeeType implements IVwServiceFeeType {

    private static final long serialVersionUID = 1L;

    private Integer    servFeeTypeId;
    private Integer    servFeeTypeStatusId;
    private String     servFeeTypeStatusCode;
    private Integer    serviceTypeId;
    private String     serviceTypeCode;
    private String     serviceTypeName;
    private String     serviceTypeDescription;
    private Integer    serviceTypeStatusId;
    private String     serviceTypeStatusCode;
    private Integer    feeTypeId;
    private String     feeTypeCode;
    private String     feeTypeName;
    private String     feeTypeDescription;
    private Boolean    prorate;
    private BigDecimal price;
    private Integer    feeTypeStatusId;
    private String     feeTypeStatusCode;

    public VwServiceFeeType() {}

    public VwServiceFeeType(IVwServiceFeeType value) {
        this.servFeeTypeId = value.getServFeeTypeId();
        this.servFeeTypeStatusId = value.getServFeeTypeStatusId();
        this.servFeeTypeStatusCode = value.getServFeeTypeStatusCode();
        this.serviceTypeId = value.getServiceTypeId();
        this.serviceTypeCode = value.getServiceTypeCode();
        this.serviceTypeName = value.getServiceTypeName();
        this.serviceTypeDescription = value.getServiceTypeDescription();
        this.serviceTypeStatusId = value.getServiceTypeStatusId();
        this.serviceTypeStatusCode = value.getServiceTypeStatusCode();
        this.feeTypeId = value.getFeeTypeId();
        this.feeTypeCode = value.getFeeTypeCode();
        this.feeTypeName = value.getFeeTypeName();
        this.feeTypeDescription = value.getFeeTypeDescription();
        this.prorate = value.getProrate();
        this.price = value.getPrice();
        this.feeTypeStatusId = value.getFeeTypeStatusId();
        this.feeTypeStatusCode = value.getFeeTypeStatusCode();
    }

    public VwServiceFeeType(
        Integer    servFeeTypeId,
        Integer    servFeeTypeStatusId,
        String     servFeeTypeStatusCode,
        Integer    serviceTypeId,
        String     serviceTypeCode,
        String     serviceTypeName,
        String     serviceTypeDescription,
        Integer    serviceTypeStatusId,
        String     serviceTypeStatusCode,
        Integer    feeTypeId,
        String     feeTypeCode,
        String     feeTypeName,
        String     feeTypeDescription,
        Boolean    prorate,
        BigDecimal price,
        Integer    feeTypeStatusId,
        String     feeTypeStatusCode
    ) {
        this.servFeeTypeId = servFeeTypeId;
        this.servFeeTypeStatusId = servFeeTypeStatusId;
        this.servFeeTypeStatusCode = servFeeTypeStatusCode;
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeCode = serviceTypeCode;
        this.serviceTypeName = serviceTypeName;
        this.serviceTypeDescription = serviceTypeDescription;
        this.serviceTypeStatusId = serviceTypeStatusId;
        this.serviceTypeStatusCode = serviceTypeStatusCode;
        this.feeTypeId = feeTypeId;
        this.feeTypeCode = feeTypeCode;
        this.feeTypeName = feeTypeName;
        this.feeTypeDescription = feeTypeDescription;
        this.prorate = prorate;
        this.price = price;
        this.feeTypeStatusId = feeTypeStatusId;
        this.feeTypeStatusCode = feeTypeStatusCode;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.serv_fee_type_id</code>. serv_fee_type_id identifier of the service-fee type relation (field prod_fee_type_id from ct_service_type table)
     */
    @Override
    public Integer getServFeeTypeId() {
        return this.servFeeTypeId;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.serv_fee_type_id</code>. serv_fee_type_id identifier of the service-fee type relation (field prod_fee_type_id from ct_service_type table)
     */
    @Override
    public void setServFeeTypeId(Integer servFeeTypeId) {
        this.servFeeTypeId = servFeeTypeId;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.serv_fee_type_status_id</code>. Status id of the service-fee type relation (field status_id from ct_serv_fee_type table)
     */
    @Override
    public Integer getServFeeTypeStatusId() {
        return this.servFeeTypeStatusId;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.serv_fee_type_status_id</code>. Status id of the service-fee type relation (field status_id from ct_serv_fee_type table)
     */
    @Override
    public void setServFeeTypeStatusId(Integer servFeeTypeStatusId) {
        this.servFeeTypeStatusId = servFeeTypeStatusId;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.serv_fee_type_status_code</code>. Status code of the service-fee type relation
     */
    @Override
    public String getServFeeTypeStatusCode() {
        return this.servFeeTypeStatusCode;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.serv_fee_type_status_code</code>. Status code of the service-fee type relation
     */
    @Override
    public void setServFeeTypeStatusCode(String servFeeTypeStatusCode) {
        this.servFeeTypeStatusCode = servFeeTypeStatusCode;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.service_type_id</code>. Service_type_id for the service-fee type relation (field service_type_id from ct_service_type table)
     */
    @Override
    public Integer getServiceTypeId() {
        return this.serviceTypeId;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.service_type_id</code>. Service_type_id for the service-fee type relation (field service_type_id from ct_service_type table)
     */
    @Override
    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.service_type_code</code>. Code for the service type (field code from ct_service_type table)
     */
    @Override
    public String getServiceTypeCode() {
        return this.serviceTypeCode;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.service_type_code</code>. Code for the service type (field code from ct_service_type table)
     */
    @Override
    public void setServiceTypeCode(String serviceTypeCode) {
        this.serviceTypeCode = serviceTypeCode;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.service_type_name</code>. Name for the service type (field name from ct_service_type table)
     */
    @Override
    public String getServiceTypeName() {
        return this.serviceTypeName;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.service_type_name</code>. Name for the service type (field name from ct_service_type table)
     */
    @Override
    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.service_type_description</code>. Description for the service type (field description from ct_service_type table)
     */
    @Override
    public String getServiceTypeDescription() {
        return this.serviceTypeDescription;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.service_type_description</code>. Description for the service type (field description from ct_service_type table)
     */
    @Override
    public void setServiceTypeDescription(String serviceTypeDescription) {
        this.serviceTypeDescription = serviceTypeDescription;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.service_type_status_id</code>. Status_id for the service type (field status_id from ct_service_type table)
     */
    @Override
    public Integer getServiceTypeStatusId() {
        return this.serviceTypeStatusId;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.service_type_status_id</code>. Status_id for the service type (field status_id from ct_service_type table)
     */
    @Override
    public void setServiceTypeStatusId(Integer serviceTypeStatusId) {
        this.serviceTypeStatusId = serviceTypeStatusId;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.service_type_status_code</code>. Status code for the service_type
     */
    @Override
    public String getServiceTypeStatusCode() {
        return this.serviceTypeStatusCode;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.service_type_status_code</code>. Status code for the service_type
     */
    @Override
    public void setServiceTypeStatusCode(String serviceTypeStatusCode) {
        this.serviceTypeStatusCode = serviceTypeStatusCode;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.fee_type_id</code>. Fee_type_id for the service-fee type relation (field fee_type_id from ct_fee_type table)
     */
    @Override
    public Integer getFeeTypeId() {
        return this.feeTypeId;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.fee_type_id</code>. Fee_type_id for the service-fee type relation (field fee_type_id from ct_fee_type table)
     */
    @Override
    public void setFeeTypeId(Integer feeTypeId) {
        this.feeTypeId = feeTypeId;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.fee_type_code</code>. Code for the fee type (field code from ct_fee_type table)
     */
    @Override
    public String getFeeTypeCode() {
        return this.feeTypeCode;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.fee_type_code</code>. Code for the fee type (field code from ct_fee_type table)
     */
    @Override
    public void setFeeTypeCode(String feeTypeCode) {
        this.feeTypeCode = feeTypeCode;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.fee_type_name</code>. Name for the fee type (field name from ct_fee_type table)
     */
    @Override
    public String getFeeTypeName() {
        return this.feeTypeName;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.fee_type_name</code>. Name for the fee type (field name from ct_fee_type table)
     */
    @Override
    public void setFeeTypeName(String feeTypeName) {
        this.feeTypeName = feeTypeName;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.fee_type_description</code>. Description for the fee type (field description from ct_fee_type table)
     */
    @Override
    public String getFeeTypeDescription() {
        return this.feeTypeDescription;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.fee_type_description</code>. Description for the fee type (field description from ct_fee_type table)
     */
    @Override
    public void setFeeTypeDescription(String feeTypeDescription) {
        this.feeTypeDescription = feeTypeDescription;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.prorate</code>. Flag that indicates if the fee type is prorated (true) or not (false)(field prorate from ct_fee_type table)
     */
    @Override
    public Boolean getProrate() {
        return this.prorate;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.prorate</code>. Flag that indicates if the fee type is prorated (true) or not (false)(field prorate from ct_fee_type table)
     */
    @Override
    public void setProrate(Boolean prorate) {
        this.prorate = prorate;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.price</code>. Price for the fee type (field price from ct_fee_type table)
     */
    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.price</code>. Price for the fee type (field price from ct_fee_type table)
     */
    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.fee_type_status_id</code>. Status_id for the fee type (field status_id from ct_fee_type table)
     */
    @Override
    public Integer getFeeTypeStatusId() {
        return this.feeTypeStatusId;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.fee_type_status_id</code>. Status_id for the fee type (field status_id from ct_fee_type table)
     */
    @Override
    public void setFeeTypeStatusId(Integer feeTypeStatusId) {
        this.feeTypeStatusId = feeTypeStatusId;
    }

    /**
     * Getter for <code>public.vw_service_fee_type.fee_type_status_code</code>. Status code for the fee type
     */
    @Override
    public String getFeeTypeStatusCode() {
        return this.feeTypeStatusCode;
    }

    /**
     * Setter for <code>public.vw_service_fee_type.fee_type_status_code</code>. Status code for the fee type
     */
    @Override
    public void setFeeTypeStatusCode(String feeTypeStatusCode) {
        this.feeTypeStatusCode = feeTypeStatusCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VwServiceFeeType (");

        sb.append(servFeeTypeId);
        sb.append(", ").append(servFeeTypeStatusId);
        sb.append(", ").append(servFeeTypeStatusCode);
        sb.append(", ").append(serviceTypeId);
        sb.append(", ").append(serviceTypeCode);
        sb.append(", ").append(serviceTypeName);
        sb.append(", ").append(serviceTypeDescription);
        sb.append(", ").append(serviceTypeStatusId);
        sb.append(", ").append(serviceTypeStatusCode);
        sb.append(", ").append(feeTypeId);
        sb.append(", ").append(feeTypeCode);
        sb.append(", ").append(feeTypeName);
        sb.append(", ").append(feeTypeDescription);
        sb.append(", ").append(prorate);
        sb.append(", ").append(price);
        sb.append(", ").append(feeTypeStatusId);
        sb.append(", ").append(feeTypeStatusCode);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IVwServiceFeeType from) {
        setServFeeTypeId(from.getServFeeTypeId());
        setServFeeTypeStatusId(from.getServFeeTypeStatusId());
        setServFeeTypeStatusCode(from.getServFeeTypeStatusCode());
        setServiceTypeId(from.getServiceTypeId());
        setServiceTypeCode(from.getServiceTypeCode());
        setServiceTypeName(from.getServiceTypeName());
        setServiceTypeDescription(from.getServiceTypeDescription());
        setServiceTypeStatusId(from.getServiceTypeStatusId());
        setServiceTypeStatusCode(from.getServiceTypeStatusCode());
        setFeeTypeId(from.getFeeTypeId());
        setFeeTypeCode(from.getFeeTypeCode());
        setFeeTypeName(from.getFeeTypeName());
        setFeeTypeDescription(from.getFeeTypeDescription());
        setProrate(from.getProrate());
        setPrice(from.getPrice());
        setFeeTypeStatusId(from.getFeeTypeStatusId());
        setFeeTypeStatusCode(from.getFeeTypeStatusCode());
    }

    @Override
    public <E extends IVwServiceFeeType> E into(E into) {
        into.from(this);
        return into;
    }
}
