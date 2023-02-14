package com.GTB.msordereventsconsumer.dataprovider.msorderdb.translator;

import com.GTB.msordereventsconsumer.dataprovider.msorderdb.entity.ItemEntity;
import com.GTB.msordereventsconsumer.dataprovider.msorderdb.entity.OrderEntity;
import com.GTB.msordereventsconsumer.domain.model.Item;
import com.GTB.msordereventsconsumer.domain.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemEntityTranslator {

    public ItemEntity execute(Item item, Long orderId){
        return ItemEntity.builder()
                .product(item.getProduct())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .order(OrderEntity.builder().id(orderId).build())
                .build();
    }

    public List<ItemEntity> execute(Order order){
        Long orderId = order.getId();
        List<Item> items = order.getItems();

        return items.stream()
                .map(item -> execute(item, orderId))
                .collect(Collectors.toList());
    }

}
