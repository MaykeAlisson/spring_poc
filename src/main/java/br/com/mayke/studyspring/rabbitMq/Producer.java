package br.com.mayke.studyspring.rabbitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Binding binding;

    public void send(String body) {
        rabbitTemplate.convertAndSend(this.binding.getExchange(), this.binding.getRoutingKey(), body);
    }

}
