package com.GTB.msordereventsconsumer.dataprovider.msorderdb;


import com.GTB.msordereventsconsumer.dataprovider.msorderdb.entity.OrderEntity;
import com.GTB.msordereventsconsumer.dataprovider.msorderdb.repository.OrderRepository;
import com.GTB.msordereventsconsumer.dataprovider.msorderdb.translator.OrderEntityTranslator;
import com.GTB.msordereventsconsumer.domain.dataprovider.MsOrderDBDataProvider;
import com.GTB.msordereventsconsumer.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MsOrderDBDataProviderImpl implements MsOrderDBDataProvider {

    private final OrderRepository orderRepository;
    private final OrderEntityTranslator orderEntityTranslator;

    @Override
    public void save(Order order) {
        OrderEntity orderEntity = orderEntityTranslator.execute(order);
        orderRepository.save(orderEntity);
    }
}
