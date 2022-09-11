/*
 * This file is generated by jOOQ.
 */
package com.comasw.model;


import com.comasw.model.tables.CtAccountType;
import com.comasw.model.tables.CtBillCycleType;
import com.comasw.model.tables.CtConsumptionType;
import com.comasw.model.tables.CtCustomerType;
import com.comasw.model.tables.CtFeeType;
import com.comasw.model.tables.CtProdFeeType;
import com.comasw.model.tables.CtProdServType;
import com.comasw.model.tables.CtProductType;
import com.comasw.model.tables.CtPromoConsumTypeDiscount;
import com.comasw.model.tables.CtPromoFeeTypeDiscount;
import com.comasw.model.tables.CtPromoProdType;
import com.comasw.model.tables.CtPromoServType;
import com.comasw.model.tables.CtPromotionType;
import com.comasw.model.tables.CtServFeeType;
import com.comasw.model.tables.CtServiceType;
import com.comasw.model.tables.IdtAccount;
import com.comasw.model.tables.IdtCustomer;
import com.comasw.model.tables.IdtFee;
import com.comasw.model.tables.IdtFeeType;
import com.comasw.model.tables.IdtProduct;
import com.comasw.model.tables.IdtProductFee;
import com.comasw.model.tables.IdtProductPromotion;
import com.comasw.model.tables.IdtProductService;
import com.comasw.model.tables.IdtPromotion;
import com.comasw.model.tables.IdtPromotionType;
import com.comasw.model.tables.IdtService;
import com.comasw.model.tables.IdtServiceFee;
import com.comasw.model.tables.IdtServicePromotion;
import com.comasw.model.tables.ItAccount;
import com.comasw.model.tables.ItContract;
import com.comasw.model.tables.ItCustomer;
import com.comasw.model.tables.ItFee;
import com.comasw.model.tables.ItProduct;
import com.comasw.model.tables.ItProfiles;
import com.comasw.model.tables.ItPromotion;
import com.comasw.model.tables.ItService;
import com.comasw.model.tables.ItUsers;
import com.comasw.model.tables.MtApplicationMenu;
import com.comasw.model.tables.PtApplicationLevel;
import com.comasw.model.tables.PtBillingPeriod;
import com.comasw.model.tables.PtConsumptionClass;
import com.comasw.model.tables.PtDiscountType;
import com.comasw.model.tables.PtEntityType;
import com.comasw.model.tables.PtIdentityCardType;
import com.comasw.model.tables.PtPaymentMethod;
import com.comasw.model.tables.PtStatus;
import com.comasw.model.tables.PtTaxType;
import com.comasw.model.tables.VwAccountInstance;
import com.comasw.model.tables.VwCustomerInstance;
import com.comasw.model.tables.VwFeeInstance;
import com.comasw.model.tables.VwFeeInstanceAll;
import com.comasw.model.tables.VwProductFeeType;
import com.comasw.model.tables.VwProductInstance;
import com.comasw.model.tables.VwProductServiceType;
import com.comasw.model.tables.VwPromoConsumTypeDiscount;
import com.comasw.model.tables.VwPromotionFeeTypeDiscount;
import com.comasw.model.tables.VwPromotionInstance;
import com.comasw.model.tables.VwPromotionInstanceAll;
import com.comasw.model.tables.VwPromotionProductType;
import com.comasw.model.tables.VwPromotionServiceType;
import com.comasw.model.tables.VwServiceFeeType;
import com.comasw.model.tables.VwServiceInstance;
import com.comasw.model.tables.VwUsers;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * Table that stores the account types of the catalog for the application
     */
    public static final CtAccountType CT_ACCOUNT_TYPE = CtAccountType.CT_ACCOUNT_TYPE;

    /**
     * Table that stores the bill cycle type of the application
     */
    public static final CtBillCycleType CT_BILL_CYCLE_TYPE = CtBillCycleType.CT_BILL_CYCLE_TYPE;

    /**
     * Table that stores the consumption types of the catalog for the application
     */
    public static final CtConsumptionType CT_CONSUMPTION_TYPE = CtConsumptionType.CT_CONSUMPTION_TYPE;

    /**
     * Table that stores the customer types of the catalog for the application
     */
    public static final CtCustomerType CT_CUSTOMER_TYPE = CtCustomerType.CT_CUSTOMER_TYPE;

    /**
     * Table that stores the fee types of the catalog for the application
     */
    public static final CtFeeType CT_FEE_TYPE = CtFeeType.CT_FEE_TYPE;

    /**
     * Table that stores the fee product relation types of the catalog for the application
     */
    public static final CtProdFeeType CT_PROD_FEE_TYPE = CtProdFeeType.CT_PROD_FEE_TYPE;

    /**
     * Table that stores the promotion product relation types of the catalog for the application
     */
    public static final CtProdServType CT_PROD_SERV_TYPE = CtProdServType.CT_PROD_SERV_TYPE;

    /**
     * Table that stores the product types of the catalog for the application
     */
    public static final CtProductType CT_PRODUCT_TYPE = CtProductType.CT_PRODUCT_TYPE;

    /**
     * Table that stores the promotion fee discount relation types of the catalog for the application
     */
    public static final CtPromoConsumTypeDiscount CT_PROMO_CONSUM_TYPE_DISCOUNT = CtPromoConsumTypeDiscount.CT_PROMO_CONSUM_TYPE_DISCOUNT;

    /**
     * Table that stores the promotion fee discount relation types of the catalog for the application
     */
    public static final CtPromoFeeTypeDiscount CT_PROMO_FEE_TYPE_DISCOUNT = CtPromoFeeTypeDiscount.CT_PROMO_FEE_TYPE_DISCOUNT;

    /**
     * Table that stores the promotion product relation types of the catalog for the application
     */
    public static final CtPromoProdType CT_PROMO_PROD_TYPE = CtPromoProdType.CT_PROMO_PROD_TYPE;

    /**
     * Table that stores the promotion service relation types of the catalog for the application
     */
    public static final CtPromoServType CT_PROMO_SERV_TYPE = CtPromoServType.CT_PROMO_SERV_TYPE;

    /**
     * The table <code>public.ct_promotion_type</code>.
     */
    public static final CtPromotionType CT_PROMOTION_TYPE = CtPromotionType.CT_PROMOTION_TYPE;

    /**
     * Table that stores the fee service relation types of the catalog for the application
     */
    public static final CtServFeeType CT_SERV_FEE_TYPE = CtServFeeType.CT_SERV_FEE_TYPE;

    /**
     * Table that stores the service types of the catalog for the application
     */
    public static final CtServiceType CT_SERVICE_TYPE = CtServiceType.CT_SERVICE_TYPE;

    /**
     * Table that stores the account instance ids referenced by account table
     */
    public static final IdtAccount IDT_ACCOUNT = IdtAccount.IDT_ACCOUNT;

    /**
     * Table that stores the customer instance ids referenced by customer table
     */
    public static final IdtCustomer IDT_CUSTOMER = IdtCustomer.IDT_CUSTOMER;

    /**
     * Table that stores the fee instance ids
     */
    public static final IdtFee IDT_FEE = IdtFee.IDT_FEE;

    /**
     * Table that stores the fee_type_id for the fee types of the catalog for the application
     */
    public static final IdtFeeType IDT_FEE_TYPE = IdtFeeType.IDT_FEE_TYPE;

    /**
     * Table that stores the product instance ids referenced by product table
     */
    public static final IdtProduct IDT_PRODUCT = IdtProduct.IDT_PRODUCT;

    /**
     * Table that stores the product-fee instance relation ids referenced by product_fee table
     */
    public static final IdtProductFee IDT_PRODUCT_FEE = IdtProductFee.IDT_PRODUCT_FEE;

    /**
     * Table that stores the product-promotion instance relation ids referenced by product_promotion table
     */
    public static final IdtProductPromotion IDT_PRODUCT_PROMOTION = IdtProductPromotion.IDT_PRODUCT_PROMOTION;

    /**
     * Table that stores the product-service instance relation ids referenced by product_service table
     */
    public static final IdtProductService IDT_PRODUCT_SERVICE = IdtProductService.IDT_PRODUCT_SERVICE;

    /**
     * Table that stores the promotion instance ids referenced by promotion table
     */
    public static final IdtPromotion IDT_PROMOTION = IdtPromotion.IDT_PROMOTION;

    /**
     * The table <code>public.idt_promotion_type</code>.
     */
    public static final IdtPromotionType IDT_PROMOTION_TYPE = IdtPromotionType.IDT_PROMOTION_TYPE;

    /**
     * Table that stores the service instance ids referenced by service table
     */
    public static final IdtService IDT_SERVICE = IdtService.IDT_SERVICE;

    /**
     * Table that stores the service-fee instance relation ids referenced by service_fee table
     */
    public static final IdtServiceFee IDT_SERVICE_FEE = IdtServiceFee.IDT_SERVICE_FEE;

    /**
     * Table that stores the service-promotion instance relation ids referenced by service_promotion table
     */
    public static final IdtServicePromotion IDT_SERVICE_PROMOTION = IdtServicePromotion.IDT_SERVICE_PROMOTION;

    /**
     * Table that stores the account instance data
     */
    public static final ItAccount IT_ACCOUNT = ItAccount.IT_ACCOUNT;

    /**
     * Table that stores the contract instance data
     */
    public static final ItContract IT_CONTRACT = ItContract.IT_CONTRACT;

    /**
     * Table that stores the customer instance data
     */
    public static final ItCustomer IT_CUSTOMER = ItCustomer.IT_CUSTOMER;

    /**
     * Table that stores the fee instance data
     */
    public static final ItFee IT_FEE = ItFee.IT_FEE;

    /**
     * Table that stores the product instance data
     */
    public static final ItProduct IT_PRODUCT = ItProduct.IT_PRODUCT;

    /**
     * Table that stores application profiles
     */
    public static final ItProfiles IT_PROFILES = ItProfiles.IT_PROFILES;

    /**
     * Table that stores the promotion instance data
     */
    public static final ItPromotion IT_PROMOTION = ItPromotion.IT_PROMOTION;

    /**
     * Table that stores the service instance data
     */
    public static final ItService IT_SERVICE = ItService.IT_SERVICE;

    /**
     * Table that stores application users
     */
    public static final ItUsers IT_USERS = ItUsers.IT_USERS;

    /**
     * Table that stores the application's menu
     */
    public static final MtApplicationMenu MT_APPLICATION_MENU = MtApplicationMenu.MT_APPLICATION_MENU;

    /**
     * Table that stores the application level for the application
     */
    public static final PtApplicationLevel PT_APPLICATION_LEVEL = PtApplicationLevel.PT_APPLICATION_LEVEL;

    /**
     * Table that stores the billing period types for the application
     */
    public static final PtBillingPeriod PT_BILLING_PERIOD = PtBillingPeriod.PT_BILLING_PERIOD;

    /**
     * Table that stores the consumtion class of the application
     */
    public static final PtConsumptionClass PT_CONSUMPTION_CLASS = PtConsumptionClass.PT_CONSUMPTION_CLASS;

    /**
     * Table that stores the discount types for the application
     */
    public static final PtDiscountType PT_DISCOUNT_TYPE = PtDiscountType.PT_DISCOUNT_TYPE;

    /**
     * Table that stores the entity type of the application
     */
    public static final PtEntityType PT_ENTITY_TYPE = PtEntityType.PT_ENTITY_TYPE;

    /**
     * Table that stores the posible types of the the identity card
     */
    public static final PtIdentityCardType PT_IDENTITY_CARD_TYPE = PtIdentityCardType.PT_IDENTITY_CARD_TYPE;

    /**
     * Table that stores the payment types for the application
     */
    public static final PtPaymentMethod PT_PAYMENT_METHOD = PtPaymentMethod.PT_PAYMENT_METHOD;

    /**
     * Table that stores the status for the entities of the application
     */
    public static final PtStatus PT_STATUS = PtStatus.PT_STATUS;

    /**
     * Table that stores the tax type of the application
     */
    public static final PtTaxType PT_TAX_TYPE = PtTaxType.PT_TAX_TYPE;

    /**
     * The table <code>public.vw_account_instance</code>.
     */
    public static final VwAccountInstance VW_ACCOUNT_INSTANCE = VwAccountInstance.VW_ACCOUNT_INSTANCE;

    /**
     * The table <code>public.vw_customer_instance</code>.
     */
    public static final VwCustomerInstance VW_CUSTOMER_INSTANCE = VwCustomerInstance.VW_CUSTOMER_INSTANCE;

    /**
     * The table <code>public.vw_fee_instance</code>.
     */
    public static final VwFeeInstance VW_FEE_INSTANCE = VwFeeInstance.VW_FEE_INSTANCE;

    /**
     * The table <code>public.vw_fee_instance_all</code>.
     */
    public static final VwFeeInstanceAll VW_FEE_INSTANCE_ALL = VwFeeInstanceAll.VW_FEE_INSTANCE_ALL;

    /**
     * The table <code>public.vw_product_fee_type</code>.
     */
    public static final VwProductFeeType VW_PRODUCT_FEE_TYPE = VwProductFeeType.VW_PRODUCT_FEE_TYPE;

    /**
     * The table <code>public.vw_product_instance</code>.
     */
    public static final VwProductInstance VW_PRODUCT_INSTANCE = VwProductInstance.VW_PRODUCT_INSTANCE;

    /**
     * View showing the relationship between product types and the service types associated with them - related to ct_prod_serv_type
     */
    public static final VwProductServiceType VW_PRODUCT_SERVICE_TYPE = VwProductServiceType.VW_PRODUCT_SERVICE_TYPE;

    /**
     * The table <code>public.vw_promo_consum_type_discount</code>.
     */
    public static final VwPromoConsumTypeDiscount VW_PROMO_CONSUM_TYPE_DISCOUNT = VwPromoConsumTypeDiscount.VW_PROMO_CONSUM_TYPE_DISCOUNT;

    /**
     * The table <code>public.vw_promotion_fee_type_discount</code>.
     */
    public static final VwPromotionFeeTypeDiscount VW_PROMOTION_FEE_TYPE_DISCOUNT = VwPromotionFeeTypeDiscount.VW_PROMOTION_FEE_TYPE_DISCOUNT;

    /**
     * The table <code>public.vw_promotion_instance</code>.
     */
    public static final VwPromotionInstance VW_PROMOTION_INSTANCE = VwPromotionInstance.VW_PROMOTION_INSTANCE;

    /**
     * The table <code>public.vw_promotion_instance_all</code>.
     */
    public static final VwPromotionInstanceAll VW_PROMOTION_INSTANCE_ALL = VwPromotionInstanceAll.VW_PROMOTION_INSTANCE_ALL;

    /**
     * The table <code>public.vw_promotion_product_type</code>.
     */
    public static final VwPromotionProductType VW_PROMOTION_PRODUCT_TYPE = VwPromotionProductType.VW_PROMOTION_PRODUCT_TYPE;

    /**
     * The table <code>public.vw_promotion_service_type</code>.
     */
    public static final VwPromotionServiceType VW_PROMOTION_SERVICE_TYPE = VwPromotionServiceType.VW_PROMOTION_SERVICE_TYPE;

    /**
     * The table <code>public.vw_service_fee_type</code>.
     */
    public static final VwServiceFeeType VW_SERVICE_FEE_TYPE = VwServiceFeeType.VW_SERVICE_FEE_TYPE;

    /**
     * The table <code>public.vw_service_instance</code>.
     */
    public static final VwServiceInstance VW_SERVICE_INSTANCE = VwServiceInstance.VW_SERVICE_INSTANCE;

    /**
     * The table <code>public.vw_users</code>.
     */
    public static final VwUsers VW_USERS = VwUsers.VW_USERS;
}
