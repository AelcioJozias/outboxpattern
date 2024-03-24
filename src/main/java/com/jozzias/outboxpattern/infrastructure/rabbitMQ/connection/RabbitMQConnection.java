package com.jozzias.outboxpattern.infrastructure.rabbitMQ.connection;

import com.jozzias.outboxpattern.infrastructure.rabbitMQ.QueueName;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {
    private static final String NOME_EXCHANGE = "amq.direct";

    private AmqpAdmin amqpAdmin;

        public RabbitMQConnection(AmqpAdmin amqpAdmin){
            this.amqpAdmin = amqpAdmin;
        }

        private Queue queue(String queueName){
            return new Queue(queueName, true, false, false);
        }

        private DirectExchange directExchange() {
            return new DirectExchange(NOME_EXCHANGE);
        }

        private Binding binding(Queue queue, DirectExchange directExchange){
            return new Binding(queue.getName(), Binding.DestinationType.QUEUE, directExchange.getName(), queue.getName(), null);
        }

        // This function is executed when our class is instantiated by Spring, due to the @Component annotation.
        @PostConstruct
        private void adiciona(){
            Queue bookQueue = this.queue(QueueName.BOOKS_QUEUE);

            DirectExchange directExchange = this.directExchange();

            Binding binding = this.binding(bookQueue, directExchange);

            //Creating queues in RabbitMQ
            this.amqpAdmin.declareQueue(bookQueue);

            // Create exchange if not exist
            this.amqpAdmin.declareExchange(directExchange);

            this.amqpAdmin.declareBinding(binding);
        }
}
