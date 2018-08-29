package com.vbgps.queue.rabbitmq.converter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.utils.SerializationUtils;

public class CustomerMessageConverter extends AbstractMessageConverter {

	private Integer deliveryMode = 2;

	private String serializType = "object";

	private Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();

	@Override
	protected Message createMessage(Object object, MessageProperties messageProperties) {
		byte[] body = null;
		String contentType = messageProperties.getContentType();
		messageProperties.setContentEncoding("urf-8");
		if (deliveryMode == null) {
			messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
		} else {
			messageProperties.setDeliveryMode(MessageDeliveryMode.fromInt(deliveryMode));
		}
		if (contentType == null) {
			if (serializType == null) {
				messageProperties.setContentType(MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT);
				body = SerializationUtils.serialize(object);
			}
			if ("object".equals(serializType)) {
				messageProperties.setContentType(MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT);
				body = SerializationUtils.serialize(object);
			} else if ("json".equals(serializType)) {
				messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
				return converter.toMessage(object, messageProperties);
			} else {
				messageProperties.setContentType(MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT);
				body = SerializationUtils.serialize(object);
			}
		} else if (contentType.contains("json")) {
			messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
			return converter.toMessage(object, messageProperties);
		} else if (MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT.equals(contentType)) {
			body = SerializationUtils.serialize(object);
		} else if (MessageProperties.CONTENT_TYPE_TEXT_PLAIN.equals(contentType)) {
			try {
				body = ((String) object).getBytes("urf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			body = SerializationUtils.serialize(object);
		}
		return new Message(body, messageProperties);
	}

	@Override
	public Object fromMessage(Message message) throws MessageConversionException {
		MessageProperties messageProperties = message.getMessageProperties();
		if (messageProperties != null) {
			String contentType = messageProperties.getContentType();
			if (contentType != null && contentType.contains("json")) {
				return converter.fromMessage(message);
			} else if (contentType != null && MessageProperties.CONTENT_TYPE_SERIALIZED_OBJECT.equals(contentType)) {
				return SerializationUtils.deserialize(message.getBody());
			} else if (contentType != null && MessageProperties.CONTENT_TYPE_TEXT_PLAIN.equals(contentType)) {
				return new String(message.getBody());
			} else {
				try {
					return SerializationUtils.deserialize(message.getBody());
				} catch (IllegalArgumentException e) {
					return new String(message.getBody());
				}
			}
		}
		return new String(message.getBody(), Charset.defaultCharset());
	}

	public Integer getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(Integer deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public String getSerializType() {
		return serializType;
	}

	public void setSerializType(String serializType) {
		this.serializType = serializType;
	}

	public static MessageProperties buildMessageProperties(String contentType, Integer modeAsNumber) {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setContentType(contentType);
		messageProperties.setDeliveryMode(MessageDeliveryMode.fromInt(modeAsNumber));
		messageProperties.setMessageId(UUID.randomUUID().toString());
		messageProperties.setContentEncoding("utf-8");
		return messageProperties;
	}
}
