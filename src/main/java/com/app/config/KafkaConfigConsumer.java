package com.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.app.model.Item;

@EnableKafka
@Configuration
public class KafkaConfigConsumer {
	 @Bean
	    public ConsumerFactory<String,Item> consumerFactory(){
	        Map<String,Object> config = new HashMap<>();
	        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"128.21.32.6:9092");
	        config.put(ConsumerConfig.GROUP_ID_CONFIG,"sample-group");
	        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
	                new JsonDeserializer<>(Item.class));
	    }

	    @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, Item> kafkaListener(){
	        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
}
