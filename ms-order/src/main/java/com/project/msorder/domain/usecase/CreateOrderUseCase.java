package com.project.msorder.domain.usecase;

import com.project.msorder.domain.dataprovider.mscustomer.MsCustomerDataProvider;
import com.project.msorder.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final MsCustomerDataProvider msCustomerDataProvider;
    private final KafkaUseCase kafkaUseCase;

    public void execute(Order order){
        msCustomerDataProvider.retrieveById(order.getCustomerId());
        kafkaUseCase.producer(order);
    }
}
