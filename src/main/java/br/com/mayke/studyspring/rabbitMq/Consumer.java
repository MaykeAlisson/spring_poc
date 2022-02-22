package br.com.mayke.studyspring.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = {"${queue-service.name}"})
    public void receive(@Payload String fileBody){
        System.out.println("Message " + fileBody);
    }
}
