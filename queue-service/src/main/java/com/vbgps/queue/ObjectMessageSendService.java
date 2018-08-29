package com.vbgps.queue;

import java.io.Serializable;

public interface ObjectMessageSendService {

	void sendMessage(Serializable msg);
}
