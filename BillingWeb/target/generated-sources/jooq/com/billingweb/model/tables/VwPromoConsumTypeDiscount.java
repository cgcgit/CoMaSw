/*
 * This file is generated by jOOQ.
 */
package com.billingweb.model.tables;


import com.billingweb.model.Public;
import com.billingweb.model.tables.records.VwPromoConsumTypeDiscountRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
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
     * The column <code>public.vw_promo_consum_type_discount.promo_consum_disc_status_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> PROMO_CONSUM_DISC_STATUS_CODE = createField(DSL.name("promo_consum_disc_status_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> PROMOTION_TYPE_ID = createField(DSL.name("promotion_type_id"), SQLDataType.INTEGER, this, "");

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
     * The column <code>public.vw_promo_consum_type_discount.application_level_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> APPLICATION_LEVEL_ID = createField(DSL.name("application_level_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.application_level_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> APPLICATION_LEVEL_CODE = createField(DSL.name("application_level_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.application_level_description</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> APPLICATION_LEVEL_DESCRIPTION = createField(DSL.name("application_level_description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.promotion_type_discount_value</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> PROMOTION_TYPE_DISCOUNT_VALUE = createField(DSL.name("promotion_type_discount_value"), SQLDataType.INTEGER, this, "");

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
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_status_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> CONSUMPTION_TYPE_STATUS_ID = createField(DSL.name("consumption_type_status_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_status_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_TYPE_STATUS_CODE = createField(DSL.name("consumption_type_status_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumtion_type_class_id</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, Integer> CONSUMTION_TYPE_CLASS_ID = createField(DSL.name("consumtion_type_class_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_class_code</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_TYPE_CLASS_CODE = createField(DSL.name("consumption_type_class_code"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.vw_promo_consum_type_discount.consumption_type_class_description</code>.
     */
    public final TableField<VwPromoConsumTypeDiscountRecord, String> CONSUMPTION_TYPE_CLASS_DESCRIPTION = createField(DSL.name("consumption_type_class_description"), SQLDataType.VARCHAR(500), this, "");

    private VwPromoConsumTypeDiscount(Name alias, Table<VwPromoConsumTypeDiscountRecord> aliased) {
        this(alias, aliased, null);
    }

    private VwPromoConsumTypeDiscount(Name alias, Table<VwPromoConsumTypeDiscountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("create view \"vw_promo_consum_type_discount\" as  SELECT cpcdt.promo_consum_type_discount_id,\n    cpcdt.status_id AS promo_consum_type_disc_status_id,\n    psr.code AS promo_consum_disc_status_code,\n    cpt.promotion_type_id,\n    cpt.code AS promotion_type_code,\n    cpt.name AS promotion_type_name,\n    cpt.description AS promotion_type_description,\n    cpt.discount_type_id,\n    pdt.code AS discount_type_code,\n    pdt.name AS discount_type_name,\n    pdt.description AS discount_type_description,\n    cpt.application_level_id,\n    pal.code AS application_level_code,\n    pal.description AS application_level_description,\n    cpt.discount_value AS promotion_type_discount_value,\n    cpt.status_id AS promotion_type_status_id,\n    psp.code AS promotion_type_status_code,\n    cct.consumption_type_id,\n    cct.code AS consumption_type_code,\n    cct.name AS consumption_type_name,\n    cct.description AS consumption_type_description,\n    cct.status_id AS consumption_type_status_id,\n    psc.code AS consumption_type_status_code,\n    cct.entity_type_id AS consumtion_type_class_id,\n    pet.code AS consumption_type_class_code,\n    pet.description AS consumption_type_class_description\n   FROM ((((((((ct_promotion_type cpt\n     JOIN pt_status psp ON ((cpt.status_id = psp.status_id)))\n     JOIN pt_application_level pal ON ((cpt.application_level_id = pal.application_level_id)))\n     JOIN pt_discount_type pdt ON ((pdt.discount_type_id = cpt.discount_type_id)))\n     JOIN ct_promo_consum_type_discount cpcdt ON ((cpcdt.promotion_type_id = cpt.promotion_type_id)))\n     JOIN pt_status psr ON ((cpcdt.status_id = psr.status_id)))\n     JOIN pt_entity_type pet ON ((pet.entity_type_id = cpcdt.consum_type_discount_class_id)))\n     JOIN ct_consumption_type cct ON (((cct.consumption_type_id = cpcdt.consumption_type_id) AND (cct.entity_type_id = cpcdt.consum_type_discount_class_id))))\n     JOIN pt_status psc ON ((cct.status_id = psc.status_id)))\n  WHERE (cpt.application_level_id IN ( SELECT pal2.application_level_id\n           FROM pt_application_level pal2\n          WHERE ((pal2.code)::text = 'SERV'::text)));"));
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