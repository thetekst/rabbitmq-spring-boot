package ru.tkachenko.app.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.tkachenko.app.model.Message;

/**
 * Created by Dmitry Tkachenko on 19.04.18
 */
@Component
@Log4j2
public class Consumer {

    @RabbitListener(queues="${rabbitmq.queue}")
    public void recievedMessage(final Message msg) {
        log.info("====================Recieved Message: {}====================", msg);
    }
}
