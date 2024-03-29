package com.GTB.msordereventsconsumer.config.avro.translator;

import com.GTB.msordereventsconsumer.domain.model.Item;
import com.project.msorder.config.avro.ItemAvro;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemAvroTranslator {


    public Item execute(ItemAvro itemAvro){
        return Item.builder()
                .product((String) itemAvro.getProduct())
                .quantity(itemAvro.getQuantity())
                .price(BigDecimal.valueOf(itemAvro.getPrice()))
                .build();
    }

    public List<Item> execute(List<ItemAvro>itemAvroList){
        return itemAvroList.stream()
                .map(item -> execute(item))
                .collect(Collectors.toList());
    }
}
