package com.project.msorder.config.avro.translator;

import com.project.msorder.config.avro.ItemAvro;
import com.project.msorder.domain.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemAvroTranslator {


    public ItemAvro execute(Item item){
        return ItemAvro.newBuilder()
                .setProduct(item.getProduct())
                .setPrice(item.getPrice().floatValue())
                .setQuantity(item.getQuantity())
                .build();
    }

    public List<ItemAvro> execute(List<Item>items){
        return items.stream()
                .map(item -> execute(item))
                .collect(Collectors.toList());
    }
}
