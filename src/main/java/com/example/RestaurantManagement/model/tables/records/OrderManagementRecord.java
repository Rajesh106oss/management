/*
 * This file is generated by jOOQ.
 */
package com.example.RestaurantManagement.model.tables.records;


import com.example.RestaurantManagement.model.tables.OrderManagement;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class OrderManagementRecord extends UpdatableRecordImpl<OrderManagementRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = 987019576;

    /**
     * Setter for <code>public.order_management.order_id</code>.
     */
    public void setOrderId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.order_management.order_id</code>.
     */
    public Integer getOrderId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.order_management.food_name</code>.
     */
    public void setFoodName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.order_management.food_name</code>.
     */
    public String getFoodName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.order_management.quantity</code>.
     */
    public void setQuantity(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.order_management.quantity</code>.
     */
    public String getQuantity() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.order_management.price</code>.
     */
    public void setPrice(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.order_management.price</code>.
     */
    public Integer getPrice() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return OrderManagement.ORDER_MANAGEMENT.ORDER_ID;
    }

    @Override
    public Field<String> field2() {
        return OrderManagement.ORDER_MANAGEMENT.FOOD_NAME;
    }

    @Override
    public Field<String> field3() {
        return OrderManagement.ORDER_MANAGEMENT.QUANTITY;
    }

    @Override
    public Field<Integer> field4() {
        return OrderManagement.ORDER_MANAGEMENT.PRICE;
    }

    @Override
    public Integer component1() {
        return getOrderId();
    }

    @Override
    public String component2() {
        return getFoodName();
    }

    @Override
    public String component3() {
        return getQuantity();
    }

    @Override
    public Integer component4() {
        return getPrice();
    }

    @Override
    public Integer value1() {
        return getOrderId();
    }

    @Override
    public String value2() {
        return getFoodName();
    }

    @Override
    public String value3() {
        return getQuantity();
    }

    @Override
    public Integer value4() {
        return getPrice();
    }

    @Override
    public OrderManagementRecord value1(Integer value) {
        setOrderId(value);
        return this;
    }

    @Override
    public OrderManagementRecord value2(String value) {
        setFoodName(value);
        return this;
    }

    @Override
    public OrderManagementRecord value3(String value) {
        setQuantity(value);
        return this;
    }

    @Override
    public OrderManagementRecord value4(Integer value) {
        setPrice(value);
        return this;
    }

    @Override
    public OrderManagementRecord values(Integer value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderManagementRecord
     */
    public OrderManagementRecord() {
        super(OrderManagement.ORDER_MANAGEMENT);
    }

    /**
     * Create a detached, initialised OrderManagementRecord
     */
    public OrderManagementRecord(Integer orderId, String foodName, String quantity, Integer price) {
        super(OrderManagement.ORDER_MANAGEMENT);

        set(0, orderId);
        set(1, foodName);
        set(2, quantity);
        set(3, price);
    }
}
