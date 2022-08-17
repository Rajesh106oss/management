package com.example.RestaurantManagement.Controller;

import com.example.RestaurantManagement.Repository.OrderRepository;
import com.example.RestaurantManagement.Validator.CreateOrderInfo;
import com.example.RestaurantManagement.Validator.UpdateOrderInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderInfo orderInfo) {
        return new ResponseEntity<>(orderRepository.createOrder(orderInfo), HttpStatus.OK);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<?> updateOrder(@RequestBody UpdateOrderInfo orderInfo,
                                         @PathVariable  Integer orderId) {
        orderInfo.setOrder_id(orderId);
        return new ResponseEntity<>(orderRepository.updateOrder(orderInfo), HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> viewOrder(@PathVariable Integer orderId){
        return orderRepository.getOrderById(orderId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId){
        return orderRepository.deleteOrder(orderId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
