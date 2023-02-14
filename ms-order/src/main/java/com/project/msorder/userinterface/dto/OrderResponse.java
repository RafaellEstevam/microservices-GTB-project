package com.project.msorder.userinterface.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class OrderResponse {

    private Long id;
    private LocalDateTime date;
    private Long customerId;
    private List<ItemResponse> items;
}
