package com.project.msorder.util.translator;

import com.project.msorder.dataprovider.msorderdb.entity.ItemEntity;
import com.project.msorder.domain.model.Item;
import com.project.msorder.userinterface.dto.ItemRequest;
import com.project.msorder.userinterface.dto.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemTranslator {

    public Item fromItemRequest(ItemRequest itemRequest){
        return Item.builder()
                .product(itemRequest.getProduct())
                .price(itemRequest.getPrice())
                .quantity(itemRequest.getQuantity())
                .build();
    }

    public List<Item> fromItemRequestList(List<ItemRequest> itemRequestList){
        return itemRequestList.stream()
                .map(itemRequest -> fromItemRequest(itemRequest))
                .collect(Collectors.toList());
    }

    public Item fromItemEntity(ItemEntity itemEntity){
        return Item.builder()
                .product(itemEntity.getProduct())
                .price(itemEntity.getPrice())
                .quantity(itemEntity.getQuantity())
                .build();
    }

    public List<Item> fromItemEntityList(List<ItemEntity> itemEntityList){
        return itemEntityList.stream()
                .map(itemEntity -> fromItemEntity(itemEntity))
                .collect(Collectors.toList());
    }


    public ItemResponse fromItem(Item item){
        return ItemResponse.builder()
                .product(item.getProduct())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }

    public List<ItemResponse> fromItemList(List<Item> items){
        return items.stream()
                .map(item -> fromItem(item))
                .collect(Collectors.toList());
    }

}
