package com.vbgps.queue.rabbitmq;

import com.vbgps.queue.ByteMessageSendService;
import com.vbgps.queue.msg.Message;

public class RabbitByteMessageSendService extends RabbitMessageSendService implements ByteMessageSendService {

	@Override
	public void sendMessage(Message<byte[]> msg) {
		sendMessage(msg.getMsg());
	}

}
