package tn.esprit.microservice.produits.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "produits.queue";
    public static final String EXCHANGE_NAME = "produits.exchange";
    public static final String ROUTING_KEY = "produits.routingkey";

    // Declare the queue
    @Bean
    public Queue avisQueue() {
        return new Queue(QUEUE_NAME, true); // Durable queue
    }

    // Declare the exchange (Direct Exchange)
    @Bean
    public DirectExchange avisExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    // Declare the binding between queue and exchange
    @Bean
    public Binding binding(Queue avisQueue, DirectExchange avisExchange) {
        return BindingBuilder.bind(avisQueue).to(avisExchange).with(ROUTING_KEY);
    }
}
