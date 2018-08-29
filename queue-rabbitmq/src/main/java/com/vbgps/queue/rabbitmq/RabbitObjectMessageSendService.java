package com.vbgps.queue.rabbitmq;

import java.io.Serializable;

import com.vbgps.queue.ObjectMessageSendService;
import com.vbgps.queue.msg.Message;
import com.vbgps.queue.rabbitmq.util.ObjectByteUtil;

public class RabbitObjectMessageSendService extends RabbitMessageSendService implements ObjectMessageSendService {

	@Override
	public void sendMessage(Message<Serializable> msg) {
		Serializable obj = msg.getMsg();
		sendMessage(ObjectByteUtil.toByteArray(obj));
	}

}
