package com.example.RestaurantManagement.Repository;


import com.example.RestaurantManagement.Validator.CreateCustomerInfo;
import com.example.RestaurantManagement.Validator.UpdateCustomerInfo;
import com.example.RestaurantManagement.model.tables.pojos.CustomerManagement;
import com.example.RestaurantManagement.model.tables.records.CustomerManagementRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;


import java.util.Optional;

import static com.example.RestaurantManagement.model.Tables.CUSTOMER_MANAGEMENT;

@Repository
public class CustomerRepository {

    private DSLContext db;

    public CustomerManagement createCustomer(CreateCustomerInfo customerInfo) {
        var record = db.newRecord(CUSTOMER_MANAGEMENT, new CustomerManagementRecord(
                null, customerInfo.getCustomer_name(),
                customerInfo.getEmail(), customerInfo.getPh_no()));
        record.store();
        return record.into(CustomerManagement.class);
    }

    public CustomerManagement updateCustomer(UpdateCustomerInfo customerInfo){
        return db.update(CUSTOMER_MANAGEMENT)
                .set(CUSTOMER_MANAGEMENT.CUSTOMER_NAME,customerInfo.getCustomer_name())
                .set(CUSTOMER_MANAGEMENT.EMAIL,customerInfo.getEmail())
                .set(CUSTOMER_MANAGEMENT.PH_NO,customerInfo.getPh_no())
                .where(CUSTOMER_MANAGEMENT.CUSTOMER_ID.eq(customerInfo.getCustomer_id()))
                .returning()
                .fetchOne()
                .map(c ->c.into(CustomerManagement.class));
    }


    public Optional<CustomerManagement> getCustomerById(Integer customerId) {
        return db.selectFrom(CUSTOMER_MANAGEMENT)
                .where(CUSTOMER_MANAGEMENT.CUSTOMER_ID.eq(customerId))
                .fetchOptionalInto(CustomerManagement.class);
    }

    public Optional<CustomerManagement> deleteCustomer(Integer customerId) {
        var isValidCustomerManagement = getCustomerById(customerId);
        if (isValidCustomerManagement.isPresent()) {
            db.deleteFrom(CUSTOMER_MANAGEMENT)
                    .where(CUSTOMER_MANAGEMENT.CUSTOMER_ID.eq(customerId))
                    .execute();
            return isValidCustomerManagement;
        } else
            return Optional.empty();
    }
}
