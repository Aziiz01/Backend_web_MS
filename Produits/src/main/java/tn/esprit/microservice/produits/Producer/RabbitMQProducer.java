package tn.esprit.microservice.produits.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private RabbitTemplate rabbitTemplate;
    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQProducer.class);

    private static final String EXCHANGE_NAME = "produits.exchange";
    private static final String ROUTING_KEY = "produits.routingkey";

    public RabbitMQProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(String message) {
     LOGGER.info(String.format("MESSAGE SENT -> %s", message));
     rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
     }
}
