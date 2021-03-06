package com.vbgps.queue.kafka;

import java.nio.charset.Charset;

import com.vbgps.queue.StringMessageSendService;
import com.vbgps.queue.msg.Message;

public class KafkaStringMessageSendService extends KafkaMessageSendService implements StringMessageSendService {

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
