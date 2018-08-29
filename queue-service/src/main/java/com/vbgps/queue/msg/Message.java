package com.vbgps.queue.msg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message<T extends Serializable> {

	private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 *  Kafka对应主题,Rabbit对应交换机,ActiveMQ对应队列
	 */
	private String topic;

	/**
	 *  Kafka对应分区字段值,Rabbit对应RoutingKey
	 */
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

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public T getMsg() {
		return msg;
	}

	public void setMsg(T msg) {
		this.msg = msg;
	}

}
