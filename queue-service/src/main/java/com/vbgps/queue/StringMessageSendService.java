package com.vbgps.queue;

import com.vbgps.queue.msg.Message;

public interface StringMessageSendService {

	void sendMessage(Message<String> msg, String charset);

	void sendMessage(Message<String> msg);
}
