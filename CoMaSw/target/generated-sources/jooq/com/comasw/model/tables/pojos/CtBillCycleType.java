/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.pojos;


import com.comasw.model.tables.interfaces.ICtBillCycleType;

import java.time.LocalDateTime;


/**
 * Table that stores the bill cycle type of the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtBillCycleType implements ICtBillCycleType {

    private static final long serialVersionUID = 1L;

    private Integer       billCycleTypeId;
    private String        code;
    private String        name;
    private String        description;
    private Integer       billingPeriodId;
    private Byte          billCycleDay;
    private String        billCycleCodenum;
    private Integer       statusId;
    private LocalDateTime inputDate;
    private String        inputUser;
    private LocalDateTime modifDate;
    private String        modifUser;
    private Boolean       corrective;

    public CtBillCycleType() {}

    public CtBillCycleType(ICtBillCycleType value) {
        this.billCycleTypeId = value.getBillCycleTypeId();
        this.code = value.getCode();
        this.name = value.getName();
        this.description = value.getDescription();
        this.billingPeriodId = value.getBillingPeriodId();
        this.billCycleDay = value.getBillCycleDay();
        this.billCycleCodenum = value.getBillCycleCodenum();
        this.statusId = value.getStatusId();
        this.inputDate = value.getInputDate();
        this.inputUser = value.getInputUser();
        this.modifDate = value.getModifDate();
        this.modifUser = value.getModifUser();
        this.corrective = value.getCorrective();
    }

    public CtBillCycleType(
        Integer       billCycleTypeId,
        String        code,
        String        name,
        String        description,
        Integer       billingPeriodId,
        Byte          billCycleDay,
        String        billCycleCodenum,
        Integer       statusId,
        LocalDateTime inputDate,
        String        inputUser,
        LocalDateTime modifDate,
        String        modifUser,
        Boolean       corrective
    ) {
        this.billCycleTypeId = billCycleTypeId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.billingPeriodId = billingPeriodId;
        this.billCycleDay = billCycleDay;
        this.billCycleCodenum = billCycleCodenum;
        this.statusId = statusId;
        this.inputDate = inputDate;
        this.inputUser = inputUser;
        this.modifDate = modifDate;
        this.modifUser = modifUser;
        this.corrective = corrective;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.bill_cycle_type_id</code>. Internal identifier of the bill cycle type
     */
    @Override
    public Integer getBillCycleTypeId() {
        return this.billCycleTypeId;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.bill_cycle_type_id</code>. Internal identifier of the bill cycle type
     */
    @Override
    public void setBillCycleTypeId(Integer billCycleTypeId) {
        this.billCycleTypeId = billCycleTypeId;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.code</code>. Code of the bill cycle type
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.code</code>. Code of the bill cycle type
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.name</code>. Name of the bill cycle type
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.name</code>. Name of the bill cycle type
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.description</code>. Description for the bill cycle type
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.description</code>. Description for the bill cycle type
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.billing_period_id</code>. Billing period for the bill cycle type
     */
    @Override
    public Integer getBillingPeriodId() {
        return this.billingPeriodId;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.billing_period_id</code>. Billing period for the bill cycle type
     */
    @Override
    public void setBillingPeriodId(Integer billingPeriodId) {
        this.billingPeriodId = billingPeriodId;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.bill_cycle_day</code>.
     */
    @Override
    public Byte getBillCycleDay() {
        return this.billCycleDay;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.bill_cycle_day</code>.
     */
    @Override
    public void setBillCycleDay(Byte billCycleDay) {
        this.billCycleDay = billCycleDay;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.bill_cycle_codenum</code>. Billing numbering code with which the invoice number is composed
     */
    @Override
    public String getBillCycleCodenum() {
        return this.billCycleCodenum;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.bill_cycle_codenum</code>. Billing numbering code with which the invoice number is composed
     */
    @Override
    public void setBillCycleCodenum(String billCycleCodenum) {
        this.billCycleCodenum = billCycleCodenum;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.status_id</code>.
     */
    @Override
    public Integer getStatusId() {
        return this.statusId;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.status_id</code>.
     */
    @Override
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.input_date</code>.
     */
    @Override
    public LocalDateTime getInputDate() {
        return this.inputDate;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.input_date</code>.
     */
    @Override
    public void setInputDate(LocalDateTime inputDate) {
        this.inputDate = inputDate;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.input_user</code>.
     */
    @Override
    public String getInputUser() {
        return this.inputUser;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.input_user</code>.
     */
    @Override
    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.modif_date</code>.
     */
    @Override
    public LocalDateTime getModifDate() {
        return this.modifDate;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.modif_date</code>.
     */
    @Override
    public void setModifDate(LocalDateTime modifDate) {
        this.modifDate = modifDate;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.modif_user</code>.
     */
    @Override
    public String getModifUser() {
        return this.modifUser;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.modif_user</code>.
     */
    @Override
    public void setModifUser(String modifUser) {
        this.modifUser = modifUser;
    }

    /**
     * Getter for <code>public.ct_bill_cycle_type.corrective</code>. Flag for corrective cycle (true: corrective cycle, false: ordinary cycle)
     */
    @Override
    public Boolean getCorrective() {
        return this.corrective;
    }

    /**
     * Setter for <code>public.ct_bill_cycle_type.corrective</code>. Flag for corrective cycle (true: corrective cycle, false: ordinary cycle)
     */
    @Override
    public void setCorrective(Boolean corrective) {
        this.corrective = corrective;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CtBillCycleType (");

        sb.append(billCycleTypeId);
        sb.append(", ").append(code);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(billingPeriodId);
        sb.append(", ").append(billCycleDay);
        sb.append(", ").append(billCycleCodenum);
        sb.append(", ").append(statusId);
        sb.append(", ").append(inputDate);
        sb.append(", ").append(inputUser);
        sb.append(", ").append(modifDate);
        sb.append(", ").append(modifUser);
        sb.append(", ").append(corrective);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ICtBillCycleType from) {
        setBillCycleTypeId(from.getBillCycleTypeId());
        setCode(from.getCode());
        setName(from.getName());
        setDescription(from.getDescription());
        setBillingPeriodId(from.getBillingPeriodId());
        setBillCycleDay(from.getBillCycleDay());
        setBillCycleCodenum(from.getBillCycleCodenum());
        setStatusId(from.getStatusId());
        setInputDate(from.getInputDate());
        setInputUser(from.getInputUser());
        setModifDate(from.getModifDate());
        setModifUser(from.getModifUser());
        setCorrective(from.getCorrective());
    }

    @Override
    public <E extends ICtBillCycleType> E into(E into) {
        into.from(this);
        return into;
    }
}
