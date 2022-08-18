package com.example.RestaurantManagement.Repository;


import com.example.RestaurantManagement.Validator.CreateOrderInfo;
import com.example.RestaurantManagement.Validator.UpdateOrderInfo;
import com.example.RestaurantManagement.model.tables.pojos.OrderManagement;
import com.example.RestaurantManagement.model.tables.records.OrderManagementRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.RestaurantManagement.model.Tables.ORDER_MANAGEMENT;


@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final DSLContext db;

    public OrderManagement createOrder(CreateOrderInfo orderInfo) {
        var record = db.newRecord(ORDER_MANAGEMENT, new OrderManagementRecord(null,
                orderInfo.getFood_name(), orderInfo.getQuantity(), orderInfo.getPrice()));
        record.store();
        return record.into(OrderManagement.class);
    }

    public OrderManagement updateOrder(UpdateOrderInfo orderInfo) {
        return db.update(ORDER_MANAGEMENT)
                .set(ORDER_MANAGEMENT.FOOD_NAME, orderInfo.getFood_name())
                .set(ORDER_MANAGEMENT.QUANTITY, orderInfo.getQuantity())
                .set(ORDER_MANAGEMENT.PRICE, orderInfo.getPrice())
                .where(ORDER_MANAGEMENT.ORDER_ID.eq(orderInfo.getOrder_id()))
                .returning()
                .fetchOne()
                .map(o -> o.into(OrderManagement.class));
    }

    public  Optional<OrderManagement> getOrderById(Integer orderId) {
        return db.selectFrom(ORDER_MANAGEMENT)
                .where(ORDER_MANAGEMENT.ORDER_ID.eq(orderId))
                .fetchOptionalInto(OrderManagement.class);
    }


    public Optional<OrderManagement> deleteOrder(Integer orderId) {
        var isValidOrderManagement = getOrderById(orderId);
        if (isValidOrderManagement.isPresent()) {
            db.deleteFrom(ORDER_MANAGEMENT)
                    .where(ORDER_MANAGEMENT.ORDER_ID.eq(orderId))
                    .execute();
            return isValidOrderManagement;
        } else
            return Optional.empty();
    }
}

