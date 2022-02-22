package br.com.mayke.studyspring.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${queue-service.name}")
    private String queue;

    @Value("${queue-service.exchange}")
    private String exchange;

    @Value("${queue-service.route-key}")
    private String routeKey;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routeKey);
    }

}
