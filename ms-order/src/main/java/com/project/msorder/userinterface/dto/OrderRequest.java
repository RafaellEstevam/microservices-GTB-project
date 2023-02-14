package com.project.msorder.userinterface.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderRequest {

    @NotNull(message = "customer id cannot be empty")
    private Long customerId;

    @NotNull(message = "the items list cannot be empty")
    @Size(min = 1)
    @Valid
    private List<ItemRequest> items;
}
