/*
 * This file is generated by jOOQ.
 */
package com.example.RestaurantManagement.model.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;


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
public class CustomerManagement implements Serializable {

    private static final long serialVersionUID = 61742659;

    private Integer customerId;
    private String  customerName;
    private String  email;
    private Integer phNo;

    public CustomerManagement() {}

    public CustomerManagement(CustomerManagement value) {
        this.customerId = value.customerId;
        this.customerName = value.customerName;
        this.email = value.email;
        this.phNo = value.phNo;
    }

    public CustomerManagement(
        Integer customerId,
        String  customerName,
        String  email,
        Integer phNo
    ) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.phNo = phNo;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhNo() {
        return this.phNo;
    }

    public void setPhNo(Integer phNo) {
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomerManagement (");

        sb.append(customerId);
        sb.append(", ").append(customerName);
        sb.append(", ").append(email);
        sb.append(", ").append(phNo);

        sb.append(")");
        return sb.toString();
    }
}
