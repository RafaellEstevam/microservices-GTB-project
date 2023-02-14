package com.project.msorder.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Item {

    private String product;
    private BigDecimal price;
    private Integer quantity;
}
