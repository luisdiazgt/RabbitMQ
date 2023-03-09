package com.example.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente.service.SenderService;
import com.example.cliente.model.RabbitMQMensaje;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitmqController {

	@Autowired
    SenderService senderService;

    @PostMapping(value = "/text")
	public ResponseEntity<?> sendMessageToKafkaTopic(@RequestBody RabbitMQMensaje message) {
		this.senderService.enviarMensaje(message.getMensaje());
		return ResponseEntity.ok().body("true");
	}
    
}
