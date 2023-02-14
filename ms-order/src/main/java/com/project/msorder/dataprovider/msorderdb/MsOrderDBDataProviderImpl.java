package com.project.msorder.dataprovider.msorderdb;

import com.project.msorder.dataprovider.msorderdb.entity.OrderEntity;
import com.project.msorder.dataprovider.msorderdb.repository.OrderRepository;
import com.project.msorder.domain.dataprovider.msorderdb.MsOrderDBDataProvider;
import com.project.msorder.domain.exception.OrderNotFoundException;
import com.project.msorder.domain.model.Order;
import com.project.msorder.util.translator.OrderTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MsOrderDBDataProviderImpl implements MsOrderDBDataProvider {

    private final OrderRepository orderRepository;
    private final OrderTranslator orderTranslator;;

    @Override
    public Optional<Order> retrieveOrderById(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("order not found"));

        return Optional.of(orderTranslator.fromOrderEntity(orderEntity));
    }

    @Override
    public List<Order> retrieveOrderByCustomerId(Long customerId) {
        List<OrderEntity> orderEntityList = orderRepository.findByCustomerId(customerId);
        return orderTranslator.fromOrderEntityList(orderEntityList);
    }

    @Override
    public Integer retrieveAmountOfOrdersByCustomer(Long customerId) {
        return orderRepository.findAmountOfOrdersByCustomerId(customerId);
    }

}
