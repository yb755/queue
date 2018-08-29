package com.vbgps.queue;

import com.vbgps.queue.msg.Message;

public interface ByteMessageSendService {

	void sendMessage(Message<byte[]> msg);
}
