/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables;


import com.comasw.model.Keys;
import com.comasw.model.Public;
import com.comasw.model.tables.records.CtPromoServTypeRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Table that stores the promotion service relation types of the catalog for 
 * the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtPromoServType extends TableImpl<CtPromoServTypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.ct_promo_serv_type</code>
     */
    public static final CtPromoServType CT_PROMO_SERV_TYPE = new CtPromoServType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CtPromoServTypeRecord> getRecordType() {
        return CtPromoServTypeRecord.class;
    }

    /**
     * The column <code>public.ct_promo_serv_type.promo_serv_type_id</code>. Internal identifier of the promotion-service relation type
     */
    public final TableField<CtPromoServTypeRecord, Integer> PROMO_SERV_TYPE_ID = createField(DSL.name("promo_serv_type_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("nextval('seq_promo_serv_type_id'::regclass)", SQLDataType.INTEGER)), this, "Internal identifier of the promotion-service relation type");

    /**
     * The column <code>public.ct_promo_serv_type.promotion_type_id</code>. Promotion_type_id for the promotion-service relation
     */
    public final TableField<CtPromoServTypeRecord, Integer> PROMOTION_TYPE_ID = createField(DSL.name("promotion_type_id"), SQLDataType.INTEGER.nullable(false), this, "Promotion_type_id for the promotion-service relation");

    /**
     * The column <code>public.ct_promo_serv_type.service_type_id</code>. Service_type_id for the promotion-service relation
     */
    public final TableField<CtPromoServTypeRecord, Integer> SERVICE_TYPE_ID = createField(DSL.name("service_type_id"), SQLDataType.INTEGER.nullable(false), this, "Service_type_id for the promotion-service relation");

    /**
     * The column <code>public.ct_promo_serv_type.status_id</code>. Status id for the promotion-service relation type
     */
    public final TableField<CtPromoServTypeRecord, Integer> STATUS_ID = createField(DSL.name("status_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("1000", SQLDataType.INTEGER)), this, "Status id for the promotion-service relation type");

    /**
     * The column <code>public.ct_promo_serv_type.input_date</code>. Date on which the record was created
     */
    public final TableField<CtPromoServTypeRecord, LocalDateTime> INPUT_DATE = createField(DSL.name("input_date"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("(('now'::text)::timestamp(0) with time zone)::timestamp without time zone", SQLDataType.LOCALDATETIME)), this, "Date on which the record was created");

    /**
     * The column <code>public.ct_promo_serv_type.input_user</code>. User who was modified the record
     */
    public final TableField<CtPromoServTypeRecord, String> INPUT_USER = createField(DSL.name("input_user"), SQLDataType.VARCHAR(10).nullable(false), this, "User who was modified the record");

    /**
     * The column <code>public.ct_promo_serv_type.modif_date</code>. Date of the last modification of the record
     */
    public final TableField<CtPromoServTypeRecord, LocalDateTime> MODIF_DATE = createField(DSL.name("modif_date"), SQLDataType.LOCALDATETIME(6), this, "Date of the last modification of the record");

    /**
     * The column <code>public.ct_promo_serv_type.modif_user</code>.
     */
    public final TableField<CtPromoServTypeRecord, String> MODIF_USER = createField(DSL.name("modif_user"), SQLDataType.VARCHAR(10), this, "");

    private CtPromoServType(Name alias, Table<CtPromoServTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private CtPromoServType(Name alias, Table<CtPromoServTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table that stores the promotion service relation types of the catalog for the application"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.ct_promo_serv_type</code> table reference
     */
    public CtPromoServType(String alias) {
        this(DSL.name(alias), CT_PROMO_SERV_TYPE);
    }

    /**
     * Create an aliased <code>public.ct_promo_serv_type</code> table reference
     */
    public CtPromoServType(Name alias) {
        this(alias, CT_PROMO_SERV_TYPE);
    }

    /**
     * Create a <code>public.ct_promo_serv_type</code> table reference
     */
    public CtPromoServType() {
        this(DSL.name("ct_promo_serv_type"), null);
    }

    public <O extends Record> CtPromoServType(Table<O> child, ForeignKey<O, CtPromoServTypeRecord> key) {
        super(child, key, CT_PROMO_SERV_TYPE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<CtPromoServTypeRecord> getPrimaryKey() {
        return Keys.CT_PROMO_SERV_TYPE_PK;
    }

    @Override
    public List<UniqueKey<CtPromoServTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<CtPromoServTypeRecord>>asList(Keys.CT_PROMO_SERV_TYPE_PK, Keys.CT_PROMO_SERV_TYPE_CODE_U);
    }

    @Override
    public List<ForeignKey<CtPromoServTypeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CtPromoServTypeRecord, ?>>asList(Keys.CT_PROMO_SERV_TYPE__CT_PROMO_SERV_TYPE_PROMO_FK, Keys.CT_PROMO_SERV_TYPE__CT_PROMO_SERV_TYPE_SERV_FK, Keys.CT_PROMO_SERV_TYPE__CT_PROMO_SERV_TYPE_STATUS_FK);
    }

    private transient IdtPromotionType _idtPromotionType;
    private transient CtServiceType _ctServiceType;
    private transient PtStatus _ptStatus;

    public IdtPromotionType idtPromotionType() {
        if (_idtPromotionType == null)
            _idtPromotionType = new IdtPromotionType(this, Keys.CT_PROMO_SERV_TYPE__CT_PROMO_SERV_TYPE_PROMO_FK);

        return _idtPromotionType;
    }

    public CtServiceType ctServiceType() {
        if (_ctServiceType == null)
            _ctServiceType = new CtServiceType(this, Keys.CT_PROMO_SERV_TYPE__CT_PROMO_SERV_TYPE_SERV_FK);

        return _ctServiceType;
    }

    public PtStatus ptStatus() {
        if (_ptStatus == null)
            _ptStatus = new PtStatus(this, Keys.CT_PROMO_SERV_TYPE__CT_PROMO_SERV_TYPE_STATUS_FK);

        return _ptStatus;
    }

    @Override
    public CtPromoServType as(String alias) {
        return new CtPromoServType(DSL.name(alias), this);
    }

    @Override
    public CtPromoServType as(Name alias) {
        return new CtPromoServType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CtPromoServType rename(String name) {
        return new CtPromoServType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CtPromoServType rename(Name name) {
        return new CtPromoServType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, Integer, Integer, Integer, LocalDateTime, String, LocalDateTime, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
