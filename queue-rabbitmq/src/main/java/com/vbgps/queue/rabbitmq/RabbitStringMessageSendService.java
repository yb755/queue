package com.vbgps.queue.rabbitmq;

import java.nio.charset.Charset;

import com.vbgps.queue.StringMessageSendService;
import com.vbgps.queue.msg.Message;

public class RabbitStringMessageSendService extends RabbitMessageSendService implements StringMessageSendService {

	@Override
	public void sendMessage(Message<String> msg, String charset) {
		String data = msg.getMsg();
		sendMessage(data.getBytes(Charset.forName(charset)));
	}

	@Override
	public void sendMessage(Message<String> msg) {
		sendMessage(msg, "utf-8");
	}

}
