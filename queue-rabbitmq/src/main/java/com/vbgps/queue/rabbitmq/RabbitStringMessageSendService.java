package com.vbgps.queue.rabbitmq;

import java.nio.charset.Charset;

import org.springframework.util.StringUtils;

import com.vbgps.queue.StringMessageSendService;
import com.vbgps.queue.msg.Message;

public class RabbitStringMessageSendService extends RabbitMessageSendService implements StringMessageSendService {

	@Override
	public void sendMessage(Message<String> msg, String charset) {
		String data = msg.getMsg();
		if (StringUtils.isEmpty(data)) {
			throw new RuntimeException("发送内容不能为空");
		}
		String exchange = msg.getTopic();
		String routingKey = msg.getKey();
		if (StringUtils.isEmpty(exchange)) {
			exchange = "exchange_default";
		}
		if (StringUtils.isEmpty(routingKey)) {
			routingKey = "routing_default";
		}
		sendMessage(data.getBytes(Charset.forName(charset)));
	}

	@Override
	public void sendMessage(Message<String> msg) {
		sendMessage(msg, "utf-8");
	}

}
