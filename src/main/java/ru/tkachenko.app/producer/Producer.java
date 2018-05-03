package ru.tkachenko.app.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tkachenko.app.model.Message;

/**
 * Created by Dmitry Tkachenko on 19.04.18
 */
@Component
@Log4j2
public class Producer {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        log.info("====================Sending message...====================");

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) ->
                log.info("confirmedMessage. correlationData: {}, ack: {}, cause: {}", correlationData, ack, cause));

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) ->
                log.info("Returned Message. message: {}, replyCode: {}, replyText: {}, exchange: {}, routingKey: {}",
                        message, replyCode, replyText, exchange, routingKey));

        rabbitTemplate.convertAndSend(exchange, routingkey, new Message("OK"));
    }

    public void send(final String msg) {
        log.info("====================Sending message...====================");
        rabbitTemplate.convertAndSend(exchange, routingkey, new Message(msg));
    }
}
