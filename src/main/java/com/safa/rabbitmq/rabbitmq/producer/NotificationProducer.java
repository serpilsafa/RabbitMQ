package com.safa.rabbitmq.rabbitmq.producer;

import com.safa.rabbitmq.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate; //Connection object

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init(){
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedDate(new Date());
        notification.setMessage("Welcome to Safa Software");
        notification.setSeen(Boolean.FALSE);

        sendToQueue(notification);
    }

    public void sendToQueue(Notification notification){
        System.out.println("Notification Sent ID: "+ notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }
}
