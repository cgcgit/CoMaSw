/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables;


import com.comasw.model.Keys;
import com.comasw.model.Public;
import com.comasw.model.tables.records.CtPromoFeeTypeDiscountRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Table that stores the promotion fee discount relation types of the catalog 
 * for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtPromoFeeTypeDiscount extends TableImpl<CtPromoFeeTypeDiscountRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.ct_promo_fee_type_discount</code>
     */
    public static final CtPromoFeeTypeDiscount CT_PROMO_FEE_TYPE_DISCOUNT = new CtPromoFeeTypeDiscount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CtPromoFeeTypeDiscountRecord> getRecordType() {
        return CtPromoFeeTypeDiscountRecord.class;
    }

    /**
     * The column <code>public.ct_promo_fee_type_discount.promo_fee_type_discount_id</code>. Internal identifier of the promotion-fee discount relation type
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, Integer> PROMO_FEE_TYPE_DISCOUNT_ID = createField(DSL.name("promo_fee_type_discount_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("nextval('seq_promo_fee_type_disc_id'::regclass)", SQLDataType.INTEGER)), this, "Internal identifier of the promotion-fee discount relation type");

    /**
     * The column <code>public.ct_promo_fee_type_discount.promotion_type_id</code>. Promotion_type_id for the promotion-fee discount relation
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, Integer> PROMOTION_TYPE_ID = createField(DSL.name("promotion_type_id"), SQLDataType.INTEGER.nullable(false), this, "Promotion_type_id for the promotion-fee discount relation");

    /**
     * The column <code>public.ct_promo_fee_type_discount.fee_type_id</code>. Fee_type_id for the promotion-fee discount relation
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, Integer> FEE_TYPE_ID = createField(DSL.name("fee_type_id"), SQLDataType.INTEGER.nullable(false), this, "Fee_type_id for the promotion-fee discount relation");

    /**
     * The column <code>public.ct_promo_fee_type_discount.application_level_id</code>. Application_level_id for the promotion-fee discount relation
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, Integer> APPLICATION_LEVEL_ID = createField(DSL.name("application_level_id"), SQLDataType.INTEGER.nullable(false), this, "Application_level_id for the promotion-fee discount relation");

    /**
     * The column <code>public.ct_promo_fee_type_discount.status_id</code>. Status id for the promotion-fee discount relation type
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, Integer> STATUS_ID = createField(DSL.name("status_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("1000", SQLDataType.INTEGER)), this, "Status id for the promotion-fee discount relation type");

    /**
     * The column <code>public.ct_promo_fee_type_discount.input_date</code>. Date on which the record was created
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, LocalDateTime> INPUT_DATE = createField(DSL.name("input_date"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("(('now'::text)::timestamp(0) with time zone)::timestamp without time zone", SQLDataType.LOCALDATETIME)), this, "Date on which the record was created");

    /**
     * The column <code>public.ct_promo_fee_type_discount.input_user</code>. User who was modified the record
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, String> INPUT_USER = createField(DSL.name("input_user"), SQLDataType.VARCHAR(10).nullable(false), this, "User who was modified the record");

    /**
     * The column <code>public.ct_promo_fee_type_discount.modif_date</code>. Date of the last modification of the record
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, LocalDateTime> MODIF_DATE = createField(DSL.name("modif_date"), SQLDataType.LOCALDATETIME(6), this, "Date of the last modification of the record");

    /**
     * The column <code>public.ct_promo_fee_type_discount.modif_user</code>.
     */
    public final TableField<CtPromoFeeTypeDiscountRecord, String> MODIF_USER = createField(DSL.name("modif_user"), SQLDataType.VARCHAR(10), this, "");

    private CtPromoFeeTypeDiscount(Name alias, Table<CtPromoFeeTypeDiscountRecord> aliased) {
        this(alias, aliased, null);
    }

    private CtPromoFeeTypeDiscount(Name alias, Table<CtPromoFeeTypeDiscountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table that stores the promotion fee discount relation types of the catalog for the application"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.ct_promo_fee_type_discount</code> table reference
     */
    public CtPromoFeeTypeDiscount(String alias) {
        this(DSL.name(alias), CT_PROMO_FEE_TYPE_DISCOUNT);
    }

    /**
     * Create an aliased <code>public.ct_promo_fee_type_discount</code> table reference
     */
    public CtPromoFeeTypeDiscount(Name alias) {
        this(alias, CT_PROMO_FEE_TYPE_DISCOUNT);
    }

    /**
     * Create a <code>public.ct_promo_fee_type_discount</code> table reference
     */
    public CtPromoFeeTypeDiscount() {
        this(DSL.name("ct_promo_fee_type_discount"), null);
    }

    public <O extends Record> CtPromoFeeTypeDiscount(Table<O> child, ForeignKey<O, CtPromoFeeTypeDiscountRecord> key) {
        super(child, key, CT_PROMO_FEE_TYPE_DISCOUNT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<CtPromoFeeTypeDiscountRecord> getPrimaryKey() {
        return Keys.CT_PROMO_FEE_TYPE_DISCOUNT_PK;
    }

    @Override
    public List<UniqueKey<CtPromoFeeTypeDiscountRecord>> getKeys() {
        return Arrays.<UniqueKey<CtPromoFeeTypeDiscountRecord>>asList(Keys.CT_PROMO_FEE_TYPE_DISCOUNT_PK, Keys.CT_PROMO_FEE_TYPE_DISCOUNT_CODE_U);
    }

    @Override
    public List<ForeignKey<CtPromoFeeTypeDiscountRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CtPromoFeeTypeDiscountRecord, ?>>asList(Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_PROMO_FK, Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_FEE_FK, Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_LEV_FK, Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_STATUS_FK);
    }

    private transient IdtPromotionType _idtPromotionType;
    private transient IdtFeeType _idtFeeType;
    private transient PtApplicationLevel _ptApplicationLevel;
    private transient PtStatus _ptStatus;

    public IdtPromotionType idtPromotionType() {
        if (_idtPromotionType == null)
            _idtPromotionType = new IdtPromotionType(this, Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_PROMO_FK);

        return _idtPromotionType;
    }

    public IdtFeeType idtFeeType() {
        if (_idtFeeType == null)
            _idtFeeType = new IdtFeeType(this, Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_FEE_FK);

        return _idtFeeType;
    }

    public PtApplicationLevel ptApplicationLevel() {
        if (_ptApplicationLevel == null)
            _ptApplicationLevel = new PtApplicationLevel(this, Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_LEV_FK);

        return _ptApplicationLevel;
    }

    public PtStatus ptStatus() {
        if (_ptStatus == null)
            _ptStatus = new PtStatus(this, Keys.CT_PROMO_FEE_TYPE_DISCOUNT__CT_PROMO_FEE_TYPE_DISCOUNT_STATUS_FK);

        return _ptStatus;
    }

    @Override
    public CtPromoFeeTypeDiscount as(String alias) {
        return new CtPromoFeeTypeDiscount(DSL.name(alias), this);
    }

    @Override
    public CtPromoFeeTypeDiscount as(Name alias) {
        return new CtPromoFeeTypeDiscount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CtPromoFeeTypeDiscount rename(String name) {
        return new CtPromoFeeTypeDiscount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CtPromoFeeTypeDiscount rename(Name name) {
        return new CtPromoFeeTypeDiscount(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, Integer, Integer, Integer, LocalDateTime, String, LocalDateTime, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
