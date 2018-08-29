package com.vbgps.queue;

import java.io.Serializable;

public interface ObjectMessageReceiveService {

	void msgReceived(Serializable msg);
}
