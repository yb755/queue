package com.vbgps.queue.kafka;

import java.io.Serializable;

import com.vbgps.queue.ObjectMessageSendService;
import com.vbgps.queue.kafka.util.ObjectByteUtil;
import com.vbgps.queue.msg.Message;

public class KafkaObjectMessageSendService extends KafkaMessageSendService implements ObjectMessageSendService {

	@Override
	public void sendMessage(Message<Serializable> msg) {
		Serializable data = msg.getMsg();
		sendMessage(ObjectByteUtil.toByteArray(data));
	}

}
