package com.project.msorder.domain.usecase;

import com.project.msorder.domain.dataprovider.msorderdb.MsOrderDBDataProvider;
import com.project.msorder.domain.model.Item;
import com.project.msorder.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateOrderValueUseCase {

    private BigDecimal total;
    private final MsOrderDBDataProvider msOrderDBDataProvider;

    public BigDecimal execute(Long orderId) {
        total = BigDecimal.ZERO;
        Order order = msOrderDBDataProvider.retrieveOrderById(orderId).get();

        List<Item> items = order.getItems();

        items.stream()
                .forEach(item -> getTotal(item, total));

        return total;
    }

    private void getTotal(Item item, BigDecimal total) {
        BigDecimal multiply = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
        this.total = total.add(multiply);
    }

}
