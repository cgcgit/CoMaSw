/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.pojos;


import com.comasw.model.tables.interfaces.ICtFeeType;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Table that stores the fee types of the catalog for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtFeeType implements ICtFeeType {

    private static final long serialVersionUID = 1L;

    private Integer       feeTypeId;
    private Integer       entityTypeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String        code;
    private String        name;
    private String        description;
    private Integer       applicationLevelId;
    private Boolean       prorate;
    private BigDecimal    price;
    private Integer       statusId;
    private LocalDateTime inputDate;
    private String        inputUser;
    private LocalDateTime modifDate;
    private String        modifUser;

    public CtFeeType() {}

    public CtFeeType(ICtFeeType value) {
        this.feeTypeId = value.getFeeTypeId();
        this.entityTypeId = value.getEntityTypeId();
        this.startDate = value.getStartDate();
        this.endDate = value.getEndDate();
        this.code = value.getCode();
        this.name = value.getName();
        this.description = value.getDescription();
        this.applicationLevelId = value.getApplicationLevelId();
        this.prorate = value.getProrate();
        this.price = value.getPrice();
        this.statusId = value.getStatusId();
        this.inputDate = value.getInputDate();
        this.inputUser = value.getInputUser();
        this.modifDate = value.getModifDate();
        this.modifUser = value.getModifUser();
    }

    public CtFeeType(
        Integer       feeTypeId,
        Integer       entityTypeId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String        code,
        String        name,
        String        description,
        Integer       applicationLevelId,
        Boolean       prorate,
        BigDecimal    price,
        Integer       statusId,
        LocalDateTime inputDate,
        String        inputUser,
        LocalDateTime modifDate,
        String        modifUser
    ) {
        this.feeTypeId = feeTypeId;
        this.entityTypeId = entityTypeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
        this.name = name;
        this.description = description;
        this.applicationLevelId = applicationLevelId;
        this.prorate = prorate;
        this.price = price;
        this.statusId = statusId;
        this.inputDate = inputDate;
        this.inputUser = inputUser;
        this.modifDate = modifDate;
        this.modifUser = modifUser;
    }

    /**
     * Getter for <code>public.ct_fee_type.fee_type_id</code>. Internal identifier of the fee type
     */
    @Override
    public Integer getFeeTypeId() {
        return this.feeTypeId;
    }

    /**
     * Setter for <code>public.ct_fee_type.fee_type_id</code>. Internal identifier of the fee type
     */
    @Override
    public void setFeeTypeId(Integer feeTypeId) {
        this.feeTypeId = feeTypeId;
    }

    /**
     * Getter for <code>public.ct_fee_type.entity_type_id</code>. Entity_id for the fee type
     */
    @Override
    public Integer getEntityTypeId() {
        return this.entityTypeId;
    }

    /**
     * Setter for <code>public.ct_fee_type.entity_type_id</code>. Entity_id for the fee type
     */
    @Override
    public void setEntityTypeId(Integer entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    /**
     * Getter for <code>public.ct_fee_type.start_date</code>. Start_date for the fee type
     */
    @Override
    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    /**
     * Setter for <code>public.ct_fee_type.start_date</code>. Start_date for the fee type
     */
    @Override
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter for <code>public.ct_fee_type.end_date</code>. End_date for the fee type
     */
    @Override
    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    /**
     * Setter for <code>public.ct_fee_type.end_date</code>. End_date for the fee type
     */
    @Override
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Getter for <code>public.ct_fee_type.code</code>. Code of the fee type
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Setter for <code>public.ct_fee_type.code</code>. Code of the fee type
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for <code>public.ct_fee_type.name</code>. Name of the fee type
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.ct_fee_type.name</code>. Name of the fee type
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.ct_fee_type.description</code>. Description for the fee type
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.ct_fee_type.description</code>. Description for the fee type
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for <code>public.ct_fee_type.application_level_id</code>. Application level id for the fee type
     */
    @Override
    public Integer getApplicationLevelId() {
        return this.applicationLevelId;
    }

    /**
     * Setter for <code>public.ct_fee_type.application_level_id</code>. Application level id for the fee type
     */
    @Override
    public void setApplicationLevelId(Integer applicationLevelId) {
        this.applicationLevelId = applicationLevelId;
    }

    /**
     * Getter for <code>public.ct_fee_type.prorate</code>. Flag for prorate (true: prorated fee)
     */
    @Override
    public Boolean getProrate() {
        return this.prorate;
    }

    /**
     * Setter for <code>public.ct_fee_type.prorate</code>. Flag for prorate (true: prorated fee)
     */
    @Override
    public void setProrate(Boolean prorate) {
        this.prorate = prorate;
    }

    /**
     * Getter for <code>public.ct_fee_type.price</code>. Price for the fee type
     */
    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>public.ct_fee_type.price</code>. Price for the fee type
     */
    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Getter for <code>public.ct_fee_type.status_id</code>. Status id for the fee type
     */
    @Override
    public Integer getStatusId() {
        return this.statusId;
    }

    /**
     * Setter for <code>public.ct_fee_type.status_id</code>. Status id for the fee type
     */
    @Override
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    /**
     * Getter for <code>public.ct_fee_type.input_date</code>. Date on which the record was created
     */
    @Override
    public LocalDateTime getInputDate() {
        return this.inputDate;
    }

    /**
     * Setter for <code>public.ct_fee_type.input_date</code>. Date on which the record was created
     */
    @Override
    public void setInputDate(LocalDateTime inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * Getter for <code>public.ct_fee_type.input_user</code>. User who was created the record
     */
    @Override
    public String getInputUser() {
        return this.inputUser;
    }

    /**
     * Setter for <code>public.ct_fee_type.input_user</code>. User who was created the record
     */
    @Override
    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    /**
     * Getter for <code>public.ct_fee_type.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public LocalDateTime getModifDate() {
        return this.modifDate;
    }

    /**
     * Setter for <code>public.ct_fee_type.modif_date</code>. Date of the last modification of the record
     */
    @Override
    public void setModifDate(LocalDateTime modifDate) {
        this.modifDate = modifDate;
    }

    /**
     * Getter for <code>public.ct_fee_type.modif_user</code>. User who was modified the record
     */
    @Override
    public String getModifUser() {
        return this.modifUser;
    }

    /**
     * Setter for <code>public.ct_fee_type.modif_user</code>. User who was modified the record
     */
    @Override
    public void setModifUser(String modifUser) {
        this.modifUser = modifUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CtFeeType (");

        sb.append(feeTypeId);
        sb.append(", ").append(entityTypeId);
        sb.append(", ").append(startDate);
        sb.append(", ").append(endDate);
        sb.append(", ").append(code);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(applicationLevelId);
        sb.append(", ").append(prorate);
        sb.append(", ").append(price);
        sb.append(", ").append(statusId);
        sb.append(", ").append(inputDate);
        sb.append(", ").append(inputUser);
        sb.append(", ").append(modifDate);
        sb.append(", ").append(modifUser);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ICtFeeType from) {
        setFeeTypeId(from.getFeeTypeId());
        setEntityTypeId(from.getEntityTypeId());
        setStartDate(from.getStartDate());
        setEndDate(from.getEndDate());
        setCode(from.getCode());
        setName(from.getName());
        setDescription(from.getDescription());
        setApplicationLevelId(from.getApplicationLevelId());
        setProrate(from.getProrate());
        setPrice(from.getPrice());
        setStatusId(from.getStatusId());
        setInputDate(from.getInputDate());
        setInputUser(from.getInputUser());
        setModifDate(from.getModifDate());
        setModifUser(from.getModifUser());
    }

    @Override
    public <E extends ICtFeeType> E into(E into) {
        into.from(this);
        return into;
    }
}
