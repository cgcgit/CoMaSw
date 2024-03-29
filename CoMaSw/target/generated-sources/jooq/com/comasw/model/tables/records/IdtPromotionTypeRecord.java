/*
 * This file is generated by jOOQ.
 */
package com.comasw.model.tables.records;


import com.comasw.model.tables.IdtPromotionType;
import com.comasw.model.tables.interfaces.IIdtPromotionType;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IdtPromotionTypeRecord extends UpdatableRecordImpl<IdtPromotionTypeRecord> implements Record1<Integer>, IIdtPromotionType {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.idt_promotion_type.promotion_type_id</code>.
     */
    @Override
    public void setPromotionTypeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.idt_promotion_type.promotion_type_id</code>.
     */
    @Override
    public Integer getPromotionTypeId() {
        return (Integer) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    @Override
    public Row1<Integer> valuesRow() {
        return (Row1) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return IdtPromotionType.IDT_PROMOTION_TYPE.PROMOTION_TYPE_ID;
    }

    @Override
    public Integer component1() {
        return getPromotionTypeId();
    }

    @Override
    public Integer value1() {
        return getPromotionTypeId();
    }

    @Override
    public IdtPromotionTypeRecord value1(Integer value) {
        setPromotionTypeId(value);
        return this;
    }

    @Override
    public IdtPromotionTypeRecord values(Integer value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IIdtPromotionType from) {
        setPromotionTypeId(from.getPromotionTypeId());
    }

    @Override
    public <E extends IIdtPromotionType> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached IdtPromotionTypeRecord
     */
    public IdtPromotionTypeRecord() {
        super(IdtPromotionType.IDT_PROMOTION_TYPE);
    }

    /**
     * Create a detached, initialised IdtPromotionTypeRecord
     */
    public IdtPromotionTypeRecord(Integer promotionTypeId) {
        super(IdtPromotionType.IDT_PROMOTION_TYPE);

        setPromotionTypeId(promotionTypeId);
    }
}
