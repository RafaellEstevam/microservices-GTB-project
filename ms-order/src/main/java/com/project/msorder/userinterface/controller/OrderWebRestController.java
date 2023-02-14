package com.project.msorder.userinterface.controller;

import com.project.msorder.domain.model.Order;
import com.project.msorder.domain.usecase.CalculateOrderValueUseCase;
import com.project.msorder.domain.usecase.CreateOrderUseCase;
import com.project.msorder.domain.usecase.RetrieveOrderUseCase;
import com.project.msorder.userinterface.dto.OrderRequest;
import com.project.msorder.userinterface.dto.OrderResponse;
import com.project.msorder.userinterface.dto.OrdersQuantityByCustomerResponse;
import com.project.msorder.userinterface.dto.TotalOrderValueResponse;
import com.project.msorder.util.translator.OrderTranslator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderWebRestController {

    private final OrderTranslator orderTranslator;
    private final RetrieveOrderUseCase retrieveOrderUseCase;
    private final CalculateOrderValueUseCase calculateOrderValueUseCase;
    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody OrderRequest orderRequest) {
        Order order = orderTranslator.fromOrderRequest(orderRequest);
        createOrderUseCase.execute(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> retrieveByCustomer(@RequestParam("customerId") Long customerId) {
        List<Order> orders = retrieveOrderUseCase.retrieveByCustomer(customerId);
        return ResponseEntity.ok(orderTranslator.fromOrderList(orders));
    }

    @GetMapping("/amountByCustomer")
    public ResponseEntity<OrdersQuantityByCustomerResponse> retrieveAmountByCustomer(@RequestParam("customerId") Long customerId) {
        Integer amount = retrieveOrderUseCase.retrieveAmountByCustomer(customerId);
        return ResponseEntity.ok(OrdersQuantityByCustomerResponse.builder().QuantityOfOrdersForThisCustomer(amount).build());
    }

    @GetMapping("/totalOrderValue")
    private ResponseEntity<TotalOrderValueResponse> getTotalOrderValue(@RequestParam("orderId") Long orderId) {

        TotalOrderValueResponse response = TotalOrderValueResponse.builder()
                .totalOrderValue(calculateOrderValueUseCase.execute(orderId))
                .build();

        return ResponseEntity.ok(response);
    }
}
