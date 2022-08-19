package com.example.RestaurantManagement;


import com.example.RestaurantManagement.Validator.CreateCustomerInfo;
import com.example.RestaurantManagement.Validator.UpdateCustomerInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CustomerManagementTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Order(1)
    @Test
    @DisplayName("Create Customer")
    void CreateCustomer() throws Exception {
        var customer = new CreateCustomerInfo(4, "Arun", "adhi@gmail.com", 345678);
        createCustomer(customer, status().isOk());
        customer.setCustomer_name("Arun");
        createCustomer(customer, status().isOk());
    }

    public void createCustomer(CreateCustomerInfo customer, ResultMatcher status)
            throws Exception {
        mockMvc.perform(post("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status)
                .andDo(print());
    }

    @Order(2)
    @Test
    @DisplayName("Update Customer")
    void updateLibrary() throws Exception {
        var customer = new CreateCustomerInfo(4, "Arun", "adhi@gmail.com", 345678);
        var customerId = storeAndGetCustomerId(customer);
        var updateCustomerInfo = new UpdateCustomerInfo(5, "Akash", "AJ@gmail.com", 324567);
        updateCustomer(updateCustomerInfo, customerId, status().isOk());
        updateCustomerInfo.setCustomer_name("arun");
        updateCustomer(updateCustomerInfo, customerId, status().isBadRequest());
        updateCustomerInfo.setCustomer_name(null);
        updateCustomer(updateCustomerInfo, customerId, status().isBadRequest());
        updateCustomerInfo.setCustomer_name("Mani");
        updateCustomer(updateCustomerInfo, 0, status().isBadRequest());
    }

    public void updateCustomer(UpdateCustomerInfo customer, Integer customerId, ResultMatcher status)
            throws Exception {
        mockMvc.perform(put("/v1/customers/" + customerId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status)
                .andDo(print());
    }

    private Integer storeAndGetCustomerId(CreateCustomerInfo createCustomerInfo) throws Exception {
        return JsonPath.parse(mockMvc.perform(post("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createCustomerInfo)))
                .andReturn().getResponse().getContentAsString()).read("id", Integer.class);
    }

    @Order(3)
    @Test
    @DisplayName("Get Customer")
    void GetLibraryInfo() throws Exception {
        var createCustomerInfo = new CreateCustomerInfo(4, "Arun", "adhi@gmail.com", 345678);
        var customerId = storeAndGetCustomerId(createCustomerInfo);
        getCustomerInfo(customerId, status().isOk());
        getCustomerInfo(0, status().isNotFound());
    }

    private void getCustomerInfo(Integer customerId, ResultMatcher status) throws Exception {
        mockMvc.perform(get("/v1/customers/" + customerId))
                .andExpect(status)
                .andDo(print());
    }

    @Order(4)
    @Test
    @DisplayName("Delete Customer")
    void deleteCustomer() throws Exception {
        var createCustomerInfo = new CreateCustomerInfo(4, "Arun", "adhi@gmail.com", 3455678);
        var customerId = storeAndGetCustomerId(createCustomerInfo);
        deleteCustomer(customerId, status().isOk());
        deleteCustomer(customerId, status().isNotFound());
    }

    public void deleteCustomer(Integer customerId, ResultMatcher status) throws Exception {
        mockMvc.perform(delete("/v1/customers/" + customerId))
                .andExpect(status)
                .andDo(print());
    }
}
