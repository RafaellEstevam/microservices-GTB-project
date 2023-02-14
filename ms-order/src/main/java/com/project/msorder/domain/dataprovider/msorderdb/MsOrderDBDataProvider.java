package com.project.msorder.domain.dataprovider.msorderdb;

import com.project.msorder.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface MsOrderDBDataProvider {

    Optional<Order> retrieveOrderById(Long orderId);

    List<Order> retrieveOrderByCustomerId(Long customerId);

    Integer retrieveAmountOfOrdersByCustomer(Long customerId);

}
