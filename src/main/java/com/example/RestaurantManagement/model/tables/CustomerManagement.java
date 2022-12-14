/*
 * This file is generated by jOOQ.
 */
package com.example.RestaurantManagement.model.tables;


import com.example.RestaurantManagement.model.Indexes;
import com.example.RestaurantManagement.model.Keys;
import com.example.RestaurantManagement.model.Public;
import com.example.RestaurantManagement.model.tables.records.CustomerManagementRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerManagement extends TableImpl<CustomerManagementRecord> {

    private static final long serialVersionUID = 861280017;

    /**
     * The reference instance of <code>public.customer_management</code>
     */
    public static final CustomerManagement CUSTOMER_MANAGEMENT = new CustomerManagement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomerManagementRecord> getRecordType() {
        return CustomerManagementRecord.class;
    }

    /**
     * The column <code>public.customer_management.customer_id</code>.
     */
    public final TableField<CustomerManagementRecord, Integer> CUSTOMER_ID = createField(DSL.name("customer_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('customer_customer_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.customer_management.customer_name</code>.
     */
    public final TableField<CustomerManagementRecord, String> CUSTOMER_NAME = createField(DSL.name("customer_name"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.customer_management.email</code>.
     */
    public final TableField<CustomerManagementRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.customer_management.ph_no</code>.
     */
    public final TableField<CustomerManagementRecord, Integer> PH_NO = createField(DSL.name("ph_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.customer_management</code> table reference
     */
    public CustomerManagement() {
        this(DSL.name("customer_management"), null);
    }

    /**
     * Create an aliased <code>public.customer_management</code> table reference
     */
    public CustomerManagement(String alias) {
        this(DSL.name(alias), CUSTOMER_MANAGEMENT);
    }

    /**
     * Create an aliased <code>public.customer_management</code> table reference
     */
    public CustomerManagement(Name alias) {
        this(alias, CUSTOMER_MANAGEMENT);
    }

    private CustomerManagement(Name alias, Table<CustomerManagementRecord> aliased) {
        this(alias, aliased, null);
    }

    private CustomerManagement(Name alias, Table<CustomerManagementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> CustomerManagement(Table<O> child, ForeignKey<O, CustomerManagementRecord> key) {
        super(child, key, CUSTOMER_MANAGEMENT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CUSTOMER_PKEY);
    }

    @Override
    public Identity<CustomerManagementRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CUSTOMER_MANAGEMENT;
    }

    @Override
    public UniqueKey<CustomerManagementRecord> getPrimaryKey() {
        return Keys.CUSTOMER_PKEY;
    }

    @Override
    public List<UniqueKey<CustomerManagementRecord>> getKeys() {
        return Arrays.<UniqueKey<CustomerManagementRecord>>asList(Keys.CUSTOMER_PKEY);
    }

    @Override
    public CustomerManagement as(String alias) {
        return new CustomerManagement(DSL.name(alias), this);
    }

    @Override
    public CustomerManagement as(Name alias) {
        return new CustomerManagement(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerManagement rename(String name) {
        return new CustomerManagement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerManagement rename(Name name) {
        return new CustomerManagement(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
