/*
 * This file is generated by jOOQ.
 */
package com.example.RestaurantManagement.model;


import com.example.RestaurantManagement.model.tables.CustomerManagement;
import com.example.RestaurantManagement.model.tables.OrderManagement;
import com.example.RestaurantManagement.model.tables.RecipeManagement;

import javax.annotation.processing.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.customer_management</code>.
     */
    public static final CustomerManagement CUSTOMER_MANAGEMENT = CustomerManagement.CUSTOMER_MANAGEMENT;

    /**
     * The table <code>public.order_management</code>.
     */
    public static final OrderManagement ORDER_MANAGEMENT = OrderManagement.ORDER_MANAGEMENT;

    /**
     * The table <code>public.recipe_management</code>.
     */
    public static final RecipeManagement RECIPE_MANAGEMENT = RecipeManagement.RECIPE_MANAGEMENT;
}
