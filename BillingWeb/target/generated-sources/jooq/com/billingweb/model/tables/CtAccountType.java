/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables;


import com.billingweb.model.Keys;
import com.billingweb.model.Public;
import com.billingweb.model.tables.records.CtAccountTypeRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row13;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Table that stores the account types of the catalog for the application
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CtAccountType extends TableImpl<CtAccountTypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.ct_account_type</code>
     */
    public static final CtAccountType CT_ACCOUNT_TYPE = new CtAccountType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CtAccountTypeRecord> getRecordType() {
        return CtAccountTypeRecord.class;
    }

    /**
     * The column <code>public.ct_account_type.account_type_id</code>. Internal identifier of the account type
     */
    public final TableField<CtAccountTypeRecord, Integer> ACCOUNT_TYPE_ID = createField(DSL.name("account_type_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("nextval('seq_account_type_id'::regclass)", SQLDataType.INTEGER)), this, "Internal identifier of the account type");

    /**
     * The column <code>public.ct_account_type.entity_type_id</code>. Entity_id for the account type
     */
    public final TableField<CtAccountTypeRecord, Integer> ENTITY_TYPE_ID = createField(DSL.name("entity_type_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("1009", SQLDataType.INTEGER)), this, "Entity_id for the account type");

    /**
     * The column <code>public.ct_account_type.code</code>. Code of the account type
     */
    public final TableField<CtAccountTypeRecord, String> CODE = createField(DSL.name("code"), SQLDataType.VARCHAR(10).nullable(false), this, "Code of the account type");

    /**
     * The column <code>public.ct_account_type.name</code>. Name of the account type
     */
    public final TableField<CtAccountTypeRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "Name of the account type");

    /**
     * The column <code>public.ct_account_type.description</code>. Description for the account type
     */
    public final TableField<CtAccountTypeRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(500).nullable(false), this, "Description for the account type");

    /**
     * The column <code>public.ct_account_type.ordinary_bill_cycle_type_id</code>. Ordinary cycle type id for the ordinary billing of the account
     */
    public final TableField<CtAccountTypeRecord, Integer> ORDINARY_BILL_CYCLE_TYPE_ID = createField(DSL.name("ordinary_bill_cycle_type_id"), SQLDataType.INTEGER.nullable(false), this, "Ordinary cycle type id for the ordinary billing of the account");

    /**
     * The column <code>public.ct_account_type.corrective_bill_cycle_type_id</code>. Bill cycle type id for the ordinary billing of the account
     */
    public final TableField<CtAccountTypeRecord, Integer> CORRECTIVE_BILL_CYCLE_TYPE_ID = createField(DSL.name("corrective_bill_cycle_type_id"), SQLDataType.INTEGER.nullable(false), this, "Bill cycle type id for the ordinary billing of the account");

    /**
     * The column <code>public.ct_account_type.status_id</code>. Status id for the account type
     */
    public final TableField<CtAccountTypeRecord, Integer> STATUS_ID = createField(DSL.name("status_id"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.field("1000", SQLDataType.INTEGER)), this, "Status id for the account type");

    /**
     * The column <code>public.ct_account_type.input_date</code>. Date on which the record was created
     */
    public final TableField<CtAccountTypeRecord, LocalDateTime> INPUT_DATE = createField(DSL.name("input_date"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field("(('now'::text)::timestamp(0) with time zone)::timestamp without time zone", SQLDataType.LOCALDATETIME)), this, "Date on which the record was created");

    /**
     * The column <code>public.ct_account_type.input_user</code>. User who was modified the record
     */
    public final TableField<CtAccountTypeRecord, String> INPUT_USER = createField(DSL.name("input_user"), SQLDataType.VARCHAR(10).nullable(false), this, "User who was modified the record");

    /**
     * The column <code>public.ct_account_type.modif_date</code>. Date of the last modification of the record
     */
    public final TableField<CtAccountTypeRecord, LocalDateTime> MODIF_DATE = createField(DSL.name("modif_date"), SQLDataType.LOCALDATETIME(6), this, "Date of the last modification of the record");

    /**
     * The column <code>public.ct_account_type.modif_user</code>. User who was modified the record
     */
    public final TableField<CtAccountTypeRecord, String> MODIF_USER = createField(DSL.name("modif_user"), SQLDataType.VARCHAR(10), this, "User who was modified the record");

    /**
     * The column <code>public.ct_account_type.payment_method_id</code>. Payment method associated with the account type
     */
    public final TableField<CtAccountTypeRecord, Integer> PAYMENT_METHOD_ID = createField(DSL.name("payment_method_id"), SQLDataType.INTEGER, this, "Payment method associated with the account type");

    private CtAccountType(Name alias, Table<CtAccountTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private CtAccountType(Name alias, Table<CtAccountTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Table that stores the account types of the catalog for the application"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.ct_account_type</code> table reference
     */
    public CtAccountType(String alias) {
        this(DSL.name(alias), CT_ACCOUNT_TYPE);
    }

    /**
     * Create an aliased <code>public.ct_account_type</code> table reference
     */
    public CtAccountType(Name alias) {
        this(alias, CT_ACCOUNT_TYPE);
    }

    /**
     * Create a <code>public.ct_account_type</code> table reference
     */
    public CtAccountType() {
        this(DSL.name("ct_account_type"), null);
    }

    public <O extends Record> CtAccountType(Table<O> child, ForeignKey<O, CtAccountTypeRecord> key) {
        super(child, key, CT_ACCOUNT_TYPE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<CtAccountTypeRecord> getPrimaryKey() {
        return Keys.CT_ACCOUNT_TYPE_PK;
    }

    @Override
    public List<UniqueKey<CtAccountTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<CtAccountTypeRecord>>asList(Keys.CT_ACCOUNT_TYPE_PK, Keys.CT_ACCOUNT_TYPE_CODE_U, Keys.CT_ACCOUNT_TYPE_NAME_U);
    }

    @Override
    public List<ForeignKey<CtAccountTypeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CtAccountTypeRecord, ?>>asList(Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_ENTITY_FK, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_OBC_FK, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_CBC_FK, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_STATUS_FK, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_PAYMENT_FK);
    }

    private transient PtEntityType _ptEntityType;
    private transient CtBillCycleType _ctAccountTypeObcFk;
    private transient CtBillCycleType _ctAccountTypeCbcFk;
    private transient PtStatus _ptStatus;
    private transient PtPaymentMethod _ptPaymentMethod;

    public PtEntityType ptEntityType() {
        if (_ptEntityType == null)
            _ptEntityType = new PtEntityType(this, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_ENTITY_FK);

        return _ptEntityType;
    }

    public CtBillCycleType ctAccountTypeObcFk() {
        if (_ctAccountTypeObcFk == null)
            _ctAccountTypeObcFk = new CtBillCycleType(this, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_OBC_FK);

        return _ctAccountTypeObcFk;
    }

    public CtBillCycleType ctAccountTypeCbcFk() {
        if (_ctAccountTypeCbcFk == null)
            _ctAccountTypeCbcFk = new CtBillCycleType(this, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_CBC_FK);

        return _ctAccountTypeCbcFk;
    }

    public PtStatus ptStatus() {
        if (_ptStatus == null)
            _ptStatus = new PtStatus(this, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_STATUS_FK);

        return _ptStatus;
    }

    public PtPaymentMethod ptPaymentMethod() {
        if (_ptPaymentMethod == null)
            _ptPaymentMethod = new PtPaymentMethod(this, Keys.CT_ACCOUNT_TYPE__CT_ACCOUNT_TYPE_PAYMENT_FK);

        return _ptPaymentMethod;
    }

    @Override
    public CtAccountType as(String alias) {
        return new CtAccountType(DSL.name(alias), this);
    }

    @Override
    public CtAccountType as(Name alias) {
        return new CtAccountType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CtAccountType rename(String name) {
        return new CtAccountType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CtAccountType rename(Name name) {
        return new CtAccountType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, Integer, String, String, String, Integer, Integer, Integer, LocalDateTime, String, LocalDateTime, String, Integer> fieldsRow() {
        return (Row13) super.fieldsRow();
    }
}
