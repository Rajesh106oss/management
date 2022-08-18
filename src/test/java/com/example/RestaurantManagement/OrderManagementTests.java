package com.example.RestaurantManagement;


import com.example.RestaurantManagement.Validator.CreateOrderInfo;
import com.example.RestaurantManagement.Validator.UpdateOrderInfo;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class OrderManagementTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Order(1)
    @Test
    @DisplayName("Create Order")
    void CreateOrder() throws Exception {
        var order = new CreateOrderInfo(1, "Biryani", "more", 120);
        createOrder(order, status().isOk());
        order.setFood_name("Biryani");
        createOrder(order, status().isOk());
    }

    public void createOrder(CreateOrderInfo order, ResultMatcher status)
            throws Exception {
        mockMvc.perform(post("/v1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(order)))
                .andExpect(status)
                .andDo(print());
    }

    @Order(2)
    @Test
    @DisplayName("Update Order")
    void UpdateOrder() throws Exception {
        var CreateOrderInfo = new CreateOrderInfo(null, "Biryani", "more", 120);
        var orderId = storeAndGetOrderId(CreateOrderInfo);
        var updateOrderInfo = new UpdateOrderInfo(null, "idly", "five", 50);
        UpdateOrder(updateOrderInfo, orderId, status().isOk());
        updateOrderInfo.setFood_name("Biryani");
        UpdateOrder(updateOrderInfo, orderId, status().isOk());
        updateOrderInfo.setFood_name(null);
        UpdateOrder(updateOrderInfo, orderId, status().isBadRequest());
        updateOrderInfo.setFood_name("idly");
        UpdateOrder(updateOrderInfo, 0, status().isOk());
    }


    public void UpdateOrder(UpdateOrderInfo order, Integer orderId, ResultMatcher status)
            throws Exception {
        mockMvc.perform(put("/v1/orders/" + orderId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(order)))
                .andExpect(status)
                .andDo(print());
    }

    private Integer storeAndGetOrderId(CreateOrderInfo createOrderInfo) throws Exception {
        return JsonPath.parse(mockMvc.perform(post("/v1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createOrderInfo)))
                .andReturn().getResponse().getContentAsString()).read("id", Integer.class);
    }


}




