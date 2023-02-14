package com.GTB.msordereventsconsumer.dataprovider.msorderdb.translator;

import com.GTB.msordereventsconsumer.dataprovider.msorderdb.entity.OrderEntity;
import com.GTB.msordereventsconsumer.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEntityTranslator {

    private final ItemEntityTranslator itemEntityTranslator;

    public OrderEntity execute(Order order){

        return OrderEntity.builder()
                .customerId(order.getCustomerId())
                .items(itemEntityTranslator.execute(order))
                .build();
    }
}
