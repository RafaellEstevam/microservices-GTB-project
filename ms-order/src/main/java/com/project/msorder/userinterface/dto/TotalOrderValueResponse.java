package com.project.msorder.userinterface.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TotalOrderValueResponse {

    private BigDecimal totalOrderValue;
}
