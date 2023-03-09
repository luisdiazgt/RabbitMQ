package com.example.servidor.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service
public class ReceiverService {
    
    //Receivers RabbitMQ
    @RabbitListener(queues="${nombreTopic}")
    public void receiveMessageFormsRR(String  message) {

        log.info("Servidor - Mensaje procesado RabbitMQ. Mensaje: " + message);
        
    } 

}
