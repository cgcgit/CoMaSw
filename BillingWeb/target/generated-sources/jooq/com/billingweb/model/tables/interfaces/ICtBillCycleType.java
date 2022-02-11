/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables.interfaces;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Table that stores the bill cycle type of the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ICtBillCycleType extends Serializable {

    /**
     * Setter for <code>public.ct_bill_cycle_type.bill_cycle_type_id</code>. Internal identifier of the bill cycle type
     */
    public void setBillCycleTypeId(Integer value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.bill_cycle_type_id</code>. Internal identifier of the bill cycle type
     */
    public Integer getBillCycleTypeId();

    /**
     * Setter for <code>public.ct_bill_cycle_type.code</code>. Code of the bill cycle type
     */
    public void setCode(String value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.code</code>. Code of the bill cycle type
     */
    public String getCode();

    /**
     * Setter for <code>public.ct_bill_cycle_type.name</code>. Name of the bill cycle type
     */
    public void setName(String value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.name</code>. Name of the bill cycle type
     */
    public String getName();

    /**
     * Setter for <code>public.ct_bill_cycle_type.description</code>. Description for the bill cycle type
     */
    public void setDescription(String value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.description</code>. Description for the bill cycle type
     */
    public String getDescription();

    /**
     * Setter for <code>public.ct_bill_cycle_type.billing_period_id</code>. Billing period for the bill cycle type
     */
    public void setBillingPeriodId(Integer value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.billing_period_id</code>. Billing period for the bill cycle type
     */
    public Integer getBillingPeriodId();

    /**
     * Setter for <code>public.ct_bill_cycle_type.bill_cycle_day</code>.
     */
    public void setBillCycleDay(Byte value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.bill_cycle_day</code>.
     */
    public Byte getBillCycleDay();

    /**
     * Setter for <code>public.ct_bill_cycle_type.bill_cycle_codenum</code>. Billing numbering code with which the invoice number is composed
     */
    public void setBillCycleCodenum(String value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.bill_cycle_codenum</code>. Billing numbering code with which the invoice number is composed
     */
    public String getBillCycleCodenum();

    /**
     * Setter for <code>public.ct_bill_cycle_type.status_id</code>.
     */
    public void setStatusId(Integer value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.status_id</code>.
     */
    public Integer getStatusId();

    /**
     * Setter for <code>public.ct_bill_cycle_type.input_date</code>.
     */
    public void setInputDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.input_date</code>.
     */
    public LocalDateTime getInputDate();

    /**
     * Setter for <code>public.ct_bill_cycle_type.input_user</code>.
     */
    public void setInputUser(String value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.input_user</code>.
     */
    public String getInputUser();

    /**
     * Setter for <code>public.ct_bill_cycle_type.modif_date</code>.
     */
    public void setModifDate(LocalDateTime value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.modif_date</code>.
     */
    public LocalDateTime getModifDate();

    /**
     * Setter for <code>public.ct_bill_cycle_type.modif_user</code>.
     */
    public void setModifUser(String value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.modif_user</code>.
     */
    public String getModifUser();

    /**
     * Setter for <code>public.ct_bill_cycle_type.corrective</code>. Flag for corrective cycle (true: corrective cycle, false: ordinary cycle)
     */
    public void setCorrective(Boolean value);

    /**
     * Getter for <code>public.ct_bill_cycle_type.corrective</code>. Flag for corrective cycle (true: corrective cycle, false: ordinary cycle)
     */
    public Boolean getCorrective();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common interface ICtBillCycleType
     */
    public void from(ICtBillCycleType from);

    /**
     * Copy data into another generated Record/POJO implementing the common interface ICtBillCycleType
     */
    public <E extends ICtBillCycleType> E into(E into);
}
