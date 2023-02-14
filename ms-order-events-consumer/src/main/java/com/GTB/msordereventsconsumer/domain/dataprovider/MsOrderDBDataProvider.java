package com.GTB.msordereventsconsumer.domain.dataprovider;

import com.GTB.msordereventsconsumer.domain.model.Order;

public interface MsOrderDBDataProvider {

    void save(Order order);
}
