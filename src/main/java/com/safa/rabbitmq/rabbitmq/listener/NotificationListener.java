package com.safa.rabbitmq.rabbitmq.listener;

import com.safa.rabbitmq.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "safa-rabbitmq-queue")
    public void handleMessage(Notification notification){
        System.out.println("message received...");
        System.out.println(notification.toString());
    }
}
