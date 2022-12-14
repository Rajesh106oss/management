/*
 * This file is generated by jOOQ.
 */
package com.example.RestaurantManagement.model.tables.daos;


import com.example.RestaurantManagement.model.tables.OrderManagement;
import com.example.RestaurantManagement.model.tables.records.OrderManagementRecord;

import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class OrderManagementDao extends DAOImpl<OrderManagementRecord, com.example.RestaurantManagement.model.tables.pojos.OrderManagement, Integer> {

    /**
     * Create a new OrderManagementDao without any configuration
     */
    public OrderManagementDao() {
        super(OrderManagement.ORDER_MANAGEMENT, com.example.RestaurantManagement.model.tables.pojos.OrderManagement.class);
    }

    /**
     * Create a new OrderManagementDao with an attached configuration
     */
    public OrderManagementDao(Configuration configuration) {
        super(OrderManagement.ORDER_MANAGEMENT, com.example.RestaurantManagement.model.tables.pojos.OrderManagement.class, configuration);
    }

    @Override
    public Integer getId(com.example.RestaurantManagement.model.tables.pojos.OrderManagement object) {
        return object.getOrderId();
    }

    /**
     * Fetch records that have <code>order_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchRangeOfOrderId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(OrderManagement.ORDER_MANAGEMENT.ORDER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>order_id IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchByOrderId(Integer... values) {
        return fetch(OrderManagement.ORDER_MANAGEMENT.ORDER_ID, values);
    }

    /**
     * Fetch a unique record that has <code>order_id = value</code>
     */
    public com.example.RestaurantManagement.model.tables.pojos.OrderManagement fetchOneByOrderId(Integer value) {
        return fetchOne(OrderManagement.ORDER_MANAGEMENT.ORDER_ID, value);
    }

    /**
     * Fetch records that have <code>food_name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchRangeOfFoodName(String lowerInclusive, String upperInclusive) {
        return fetchRange(OrderManagement.ORDER_MANAGEMENT.FOOD_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>food_name IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchByFoodName(String... values) {
        return fetch(OrderManagement.ORDER_MANAGEMENT.FOOD_NAME, values);
    }

    /**
     * Fetch records that have <code>quantity BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchRangeOfQuantity(String lowerInclusive, String upperInclusive) {
        return fetchRange(OrderManagement.ORDER_MANAGEMENT.QUANTITY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>quantity IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchByQuantity(String... values) {
        return fetch(OrderManagement.ORDER_MANAGEMENT.QUANTITY, values);
    }

    /**
     * Fetch records that have <code>price BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchRangeOfPrice(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(OrderManagement.ORDER_MANAGEMENT.PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price IN (values)</code>
     */
    public List<com.example.RestaurantManagement.model.tables.pojos.OrderManagement> fetchByPrice(Integer... values) {
        return fetch(OrderManagement.ORDER_MANAGEMENT.PRICE, values);
    }
}
