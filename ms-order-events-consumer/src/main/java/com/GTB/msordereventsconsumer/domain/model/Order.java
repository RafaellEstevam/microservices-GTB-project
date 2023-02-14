package com.GTB.msordereventsconsumer.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {

    private Long id;
    private Long customerId;
    private List<Item> items;
}
