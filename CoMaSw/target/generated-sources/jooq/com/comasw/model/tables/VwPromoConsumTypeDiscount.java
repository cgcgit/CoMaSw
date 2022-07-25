/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables;


import com.comasw.model.Public;
import com.comasw.model.tables.records.VwPromoConsumTypeDiscountRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
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
public class VwPromoConsumTypeDiscount extends TableImpl<VwPromoConsumTypeDiscountRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.vw_promo_consum_type_discount</code>
     */
    public static final VwPromoConsumTypeDiscount VW_PROMO_CONSUM_TYPE_DISCOUNT = new VwPromoConsumTypeDiscount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VwPromoConsumTypeDiscountRecord> getRecordType() {
        return VwPromoConsumTypeDiscountRecord.class;
    }

    /**
     * The column <code>public.vw_promo_consum_type_discount.promo_consum_type_discount_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> PROMO_CONSUM_TYPE_DISCOUNT_ID = createField(DSL.name("promo_consum_type_discount_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promo_consum_type_disc_status_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> PROMO_CONSUM_TYPE_DISC_STATUS_ID = createField(DSL.name("promo_consum_type_disc_status_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promo_consum_type_disc_status_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> PROMO_CONSUM_TYPE_DISC_STATUS_CODE = createField(DSL.name("promo_consum_type_disc_status_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> PROMOTION_TYPE_ID = createField(DSL.name("promotion_type_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_start_date</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, LocalDateTime> PROMOTION_TYPE_START_DATE = createField(DSL.name("promotion_type_start_date"), SQLDataType.LOCALDATETIME(0), this, "", new LocalDateAsLocalDateTimeBinding());

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_end_date</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, LocalDateTime> PROMOTION_TYPE_END_DATE = createField(DSL.name("promotion_type_end_date"), SQLDataType.LOCALDATETIME(0), this, "", new LocalDateAsLocalDateTimeBinding());

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> PROMOTION_TYPE_CODE = createField(DSL.name("promotion_type_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_name</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> PROMOTION_TYPE_NAME = createField(DSL.name("promotion_type_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_description</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> PROMOTION_TYPE_DESCRIPTION = createField(DSL.name("promotion_type_description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.discount_type_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> DISCOUNT_TYPE_ID = createField(DSL.name("discount_type_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.discount_type_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> DISCOUNT_TYPE_CODE = createField(DSL.name("discount_type_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.discount_type_name</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> DISCOUNT_TYPE_NAME = createField(DSL.name("discount_type_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.discount_type_description</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> DISCOUNT_TYPE_DESCRIPTION = createField(DSL.name("discount_type_description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_discount_value</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, BigDecimal> PROMOTION_TYPE_DISCOUNT_VALUE = createField(DSL.name("promotion_type_discount_value"), SQLDataType.NUMERIC(10, 4), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_status_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> PROMOTION_TYPE_STATUS_ID = createField(DSL.name("promotion_type_status_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_status_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> PROMOTION_TYPE_STATUS_CODE = createField(DSL.name("promotion_type_status_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> CONSUMPTION_TYPE_ID = createField(DSL.name("consumption_type_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_TYPE_CODE = createField(DSL.name("consumption_type_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_name</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_TYPE_NAME = createField(DSL.name("consumption_type_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_description</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_TYPE_DESCRIPTION = createField(DSL.name("consumption_type_description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_class_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> CONSUMPTION_CLASS_ID = createField(DSL.name("consumption_class_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_class_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_CLASS_CODE = createField(DSL.name("consumption_class_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_class_name</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_CLASS_NAME = createField(DSL.name("consumption_class_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_class_description</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_CLASS_DESCRIPTION = createField(DSL.name("consumption_class_description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_status_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> CONSUMPTION_TYPE_STATUS_ID = createField(DSL.name("consumption_type_status_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_status_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_TYPE_STATUS_CODE = createField(DSL.name("consumption_type_status_code"), SQLDataType.VARCHAR(10), this, "");

    private VwPromoConsumTypeDiscount(Name alias, Table<VwPromoConsumTypeDiscountRecord> aliased) {
        this(alias, aliased, null);
    }

    private VwPromoConsumTypeDiscount(Name alias, Table<VwPromoConsumTypeDiscountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view());
    }

    /**
     * Create an aliased <code>public.vw_promo_consum_type_discount</code> table reference
     */
    public VwPromoConsumTypeDiscount(String alias) {
        this(DSL.name(alias), VW_PROMO_CONSUM_TYPE_DISCOUNT);
    }

    /**
     * Create an aliased <code>public.vw_promo_consum_type_discount</code> table reference
     */
    public VwPromoConsumTypeDiscount(Name alias) {
        this(alias, VW_PROMO_CONSUM_TYPE_DISCOUNT);
    }

    /**
     * Create a <code>public.vw_promo_consum_type_discount</code> table reference
     */
    public VwPromoConsumTypeDiscount() {
        this(DSL.name("vw_promo_consum_type_discount"), null);
    }

    public <O extends Record> VwPromoConsumTypeDiscount(Table<O> child, ForeignKey<O, VwPromoConsumTypeDiscountRecord> key) {
        super(child, key, VW_PROMO_CONSUM_TYPE_DISCOUNT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public VwPromoConsumTypeDiscount as(String alias) {
        return new VwPromoConsumTypeDiscount(DSL.name(alias), this);
    }

    @Override
    public VwPromoConsumTypeDiscount as(Name alias) {
        return new VwPromoConsumTypeDiscount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VwPromoConsumTypeDiscount rename(String name) {
        return new VwPromoConsumTypeDiscount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public VwPromoConsumTypeDiscount rename(Name name) {
        return new VwPromoConsumTypeDiscount(name, null);
    }
}
