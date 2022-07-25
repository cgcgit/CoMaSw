/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables;


import com.comasw.model.Public;
import com.comasw.model.tables.records.VwProductFeeTypeRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row19;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.LocalDateAsLocalDateTimeBinding;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VwProductFeeType extends TableImpl<VwProductFeeTypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.vw_product_fee_type</code>
     */
    public static final VwProductFeeType VW_PRODUCT_FEE_TYPE = new VwProductFeeType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VwProductFeeTypeRecord> getRecordType() {
        return VwProductFeeTypeRecord.class;
    }

    /**
     * The column <code>public.vw_product_fee_type.prod_fee_type_id</code>.
     */
    public final TableField<VwProductFeeTypeRecord, Integer> PROD_FEE_TYPE_ID = createField(DSL.name("prod_fee_type_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_product_fee_type.prod_fee_type_status_id</code>.
     */
    public final TableField<VwProductFeeTypeRecord, Integer> PROD_FEE_TYPE_STATUS_ID = createField(DSL.name("prod_fee_type_status_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_product_fee_type.prod_fee_type_status_code</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> PROD_FEE_TYPE_STATUS_CODE = createField(DSL.name("prod_fee_type_status_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_product_fee_type.product_type_id</code>.
     */
    public final TableField<VwProductFeeTypeRecord, Integer> PRODUCT_TYPE_ID = createField(DSL.name("product_type_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_product_fee_type.product_type_code</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> PRODUCT_TYPE_CODE = createField(DSL.name("product_type_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_product_fee_type.product_type_name</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> PRODUCT_TYPE_NAME = createField(DSL.name("product_type_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.vw_product_fee_type.product_type_description</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> PRODUCT_TYPE_DESCRIPTION = createField(DSL.name("product_type_description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.vw_product_fee_type.product_type_status_id</code>.
     */
    public final TableField<VwProductFeeTypeRecord, Integer> PRODUCT_TYPE_STATUS_ID = createField(DSL.name("product_type_status_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_product_fee_type.product_type_status_code</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> PRODUCT_TYPE_STATUS_CODE = createField(DSL.name("product_type_status_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_product_fee_type.fee_type_id</code>.
     */
    public final TableField<VwProductFeeTypeRecord, Integer> FEE_TYPE_ID = createField(DSL.name("fee_type_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_product_fee_type.fee_type_start_date</code>.
     */
    public final TableField<VwProductFeeTypeRecord, LocalDateTime> FEE_TYPE_START_DATE = createField(DSL.name("fee_type_start_date"), SQLDataType.LOCALDATETIME(0), this, "", new LocalDateAsLocalDateTimeBinding());

    /**
     * The column <code>public.vw_product_fee_type.fee_type_end_date</code>.
     */
    public final TableField<VwProductFeeTypeRecord, LocalDateTime> FEE_TYPE_END_DATE = createField(DSL.name("fee_type_end_date"), SQLDataType.LOCALDATETIME(0), this, "", new LocalDateAsLocalDateTimeBinding());

    /**
     * The column <code>public.vw_product_fee_type.fee_type_code</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> FEE_TYPE_CODE = createField(DSL.name("fee_type_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_product_fee_type.fee_type_name</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> FEE_TYPE_NAME = createField(DSL.name("fee_type_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.vw_product_fee_type.fee_type_description</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> FEE_TYPE_DESCRIPTION = createField(DSL.name("fee_type_description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.vw_product_fee_type.prorate</code>.
     */
    public final TableField<VwProductFeeTypeRecord, Boolean> PRORATE = createField(DSL.name("prorate"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.vw_product_fee_type.price</code>.
     */
    public final TableField<VwProductFeeTypeRecord, BigDecimal> PRICE = createField(DSL.name("price"), SQLDataType.NUMERIC(10, 4), this, "");

    /**
     * The column <code>public.vw_product_fee_type.fee_type_status_id</code>.
     */
    public final TableField<VwProductFeeTypeRecord, Integer> FEE_TYPE_STATUS_ID = createField(DSL.name("fee_type_status_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_product_fee_type.fee_type_status_code</code>.
     */
    public final TableField<VwProductFeeTypeRecord, String> FEE_TYPE_STATUS_CODE = createField(DSL.name("fee_type_status_code"), SQLDataType.VARCHAR(10), this, "");

    private VwProductFeeType(Name alias, Table<VwProductFeeTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private VwProductFeeType(Name alias, Table<VwProductFeeTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view());
    }

    /**
     * Create an aliased <code>public.vw_product_fee_type</code> table reference
     */
    public VwProductFeeType(String alias) {
        this(DSL.name(alias), VW_PRODUCT_FEE_TYPE);
    }

    /**
     * Create an aliased <code>public.vw_product_fee_type</code> table reference
     */
    public VwProductFeeType(Name alias) {
        this(alias, VW_PRODUCT_FEE_TYPE);
    }

    /**
     * Create a <code>public.vw_product_fee_type</code> table reference
     */
    public VwProductFeeType() {
        this(DSL.name("vw_product_fee_type"), null);
    }

    public <O extends Record> VwProductFeeType(Table<O> child, ForeignKey<O, VwProductFeeTypeRecord> key) {
        super(child, key, VW_PRODUCT_FEE_TYPE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public VwProductFeeType as(String alias) {
        return new VwProductFeeType(DSL.name(alias), this);
    }

    @Override
    public VwProductFeeType as(Name alias) {
        return new VwProductFeeType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VwProductFeeType rename(String name) {
        return new VwProductFeeType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public VwProductFeeType rename(Name name) {
        return new VwProductFeeType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row19 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row19<Integer, Integer, String, Integer, String, String, String, Integer, String, Integer, LocalDateTime, LocalDateTime, String, String, String, Boolean, BigDecimal, Integer, String> fieldsRow() {
        return (Row19) super.fieldsRow();
    }
}