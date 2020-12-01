package com.safa.rabbitmq.rabbitmq;

import com.safa.rabbitmq.rabbitmq.model.Notification;
import com.safa.rabbitmq.rabbitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class RabbitMqApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}
}
