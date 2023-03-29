package com.project.msorder.domain.usecase;

import com.project.msorder.config.avro.OrderAvro;
import com.project.msorder.config.avro.translator.ItemAvroTranslator;
import com.project.msorder.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaUseCase {

    @Value("${topic.name.producer}")
    private String topic;

    private final KafkaTemplate<String, OrderAvro> kafkaTemplate;
    private final ItemAvroTranslator itemAvroTranslator;


    public void producer(Order order){
        OrderAvro orderAvro = OrderAvro.newBuilder()
                .setCustomerId(order.getCustomerId().intValue())
                .setItems(itemAvroTranslator.execute(order.getItems()))
                .build();

        kafkaTemplate.send(topic, orderAvro);
        log.info("c=KafkaUseCase, m=producer, orderAvro={}",orderAvro);
    }
}
