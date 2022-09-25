package knightly.testgateway.config;

import knightly.testgateway.client.ProductService;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitConfig {

    @Value("${xchange.name}")
    private String directXchangeName;
    @Value("${product.queue.name}")
    private String productQueueName;
    @Value("${routing.key.product.service}")
    private String routingKeyProductService;

    @Bean
    public Queue productQueue() {
        return new Queue(productQueueName);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directXchangeName);
    }

    @Bean
    public Binding productBinding(DirectExchange directExchange, Queue productQueue) {
        return BindingBuilder.bind(productQueue).to(directExchange).with(routingKeyProductService);
    }

    @Bean
    public ProductService productClient() {
        return new ProductService();
    }
}
