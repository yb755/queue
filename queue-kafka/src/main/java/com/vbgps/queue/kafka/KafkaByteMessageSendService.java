package com.vbgps.queue.kafka;

import com.vbgps.queue.ByteMessageSendService;
import com.vbgps.queue.msg.Message;

public class KafkaByteMessageSendService extends KafkaMessageSendService implements ByteMessageSendService {

	@Override
	public void sendMessage(Message<byte[]> msg) {
		byte[] data = msg.getMsg();
		sendMessage(data);
	}

}
