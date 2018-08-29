package com.vbgps.queue.msg;

import java.io.Serializable;

public class Message<T extends Serializable> {

	private String topic;

	private String key;

	private T msg;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public T getMsg() {
		return msg;
	}

	public void setMsg(T msg) {
		this.msg = msg;
	}

}
