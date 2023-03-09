package com.example.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Log
@Service
public class SenderService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${nombreTopic}")
    String nombreTopic;

    public void enviarMensaje(String request)
    {
        log.info("Cliente - mensaje enviado. Mensaje: " + request);
        rabbitTemplate.convertAndSend(nombreTopic, request);
    }
    
}
