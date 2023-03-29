package com.GTB.msordereventsconsumer.domain.usecase;

import com.GTB.msordereventsconsumer.config.avro.translator.ItemAvroTranslator;
import com.GTB.msordereventsconsumer.domain.dataprovider.MsOrderDBDataProvider;
import com.GTB.msordereventsconsumer.domain.model.Order;
import com.project.msorder.config.avro.OrderAvro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaUseCase {

    private final MsOrderDBDataProvider msOrderDBDataProvider;
    private final ItemAvroTranslator itemAvroTranslator;

    @KafkaListener(topics = "${kafka.topic}", groupId = "ms-order-topic-user")
    public void consumer(ConsumerRecord<String, OrderAvro> record){
        OrderAvro orderAvro = record.value();

        Order order = Order.builder()
                .customerId(Long.valueOf(orderAvro.getCustomerId()))
                .items(itemAvroTranslator.execute(orderAvro.getItems()))
                .build();

        msOrderDBDataProvider.save(order);
        log.info("{}", order);
    }
}
