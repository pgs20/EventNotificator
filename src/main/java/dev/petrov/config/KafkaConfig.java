package dev.petrov.config;

import dev.petrov.kafka.EventKafkaNotification;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ConsumerFactory<Integer, EventKafkaNotification> consumerFactory() {
        Map<String, Object> configProperties = Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                ConsumerConfig.GROUP_ID_CONFIG, "notificator-group",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);

        var factory = new DefaultKafkaConsumerFactory<Integer, EventKafkaNotification>(configProperties);

        factory.setValueDeserializer(new JsonDeserializer<>(EventKafkaNotification.class, false));

        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, EventKafkaNotification> containerFactory(
            ConsumerFactory<Integer, EventKafkaNotification> consumerFactory
    ) {
        var factory = new ConcurrentKafkaListenerContainerFactory<Integer, EventKafkaNotification>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
