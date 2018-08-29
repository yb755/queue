package com.vbgps.queue;

import java.io.Serializable;

import com.vbgps.queue.msg.Message;

public interface ObjectMessageSendService {

	void sendMessage(Message<Serializable> msg);
}
