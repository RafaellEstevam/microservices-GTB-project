package com.project.msorder.util.translator;

import com.project.msorder.dataprovider.msorderdb.entity.OrderEntity;
import com.project.msorder.domain.model.Order;
import com.project.msorder.userinterface.dto.OrderRequest;
import com.project.msorder.userinterface.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderTranslator {

    private final ItemTranslator itemTranslator;

    public Order fromOrderEntity(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .customerId(orderEntity.getCustomerId())
                .items(itemTranslator.fromItemEntityList(orderEntity.getItems()))
                .build();
    }

    public List<Order> fromOrderEntityList(List<OrderEntity> orderEntityList) {
        return orderEntityList.stream()
                .map(orderEntity -> fromOrderEntity(orderEntity))
                .collect(Collectors.toList());
    }

    public Order fromOrderRequest(OrderRequest orderRequest) {
        return Order.builder()
                .customerId(orderRequest.getCustomerId())
                .items(itemTranslator.fromItemRequestList(orderRequest.getItems()))
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .items(itemTranslator.fromItemList(order.getItems()))
                .build();
    }

    public List<OrderResponse> fromOrderList(List<Order> orders) {
        return orders.stream()
                .map(order -> fromOrder(order))
                .collect(Collectors.toList());
    }

}
