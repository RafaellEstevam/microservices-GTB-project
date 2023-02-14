package com.project.msorder.userinterface.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ItemRequest {

    @NotEmpty(message = "product name cannot be empty")
    private String product;

    @NotNull(message = "price cannot be empty")
    @DecimalMin(value = "0.1")
    private BigDecimal price;

    @NotNull(message = "quantity cannot be empty")
    @Min(value = 1, message = "The value must be at least one")
    private Integer quantity;
}
