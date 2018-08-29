package com.vbgps.queue.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RabbitMessageSendService {

	@Autowired
	private RabbitTemplate amqpTemplate;

	void sendMessage(byte[] bytes) {
		MessageProperties prop = new MessageProperties();
		Message msg = new Message(bytes, prop);
		amqpTemplate.send(msg);
	}

	public void setAmqpTemplate(RabbitTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

}
