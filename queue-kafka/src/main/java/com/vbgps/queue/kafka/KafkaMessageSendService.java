package com.vbgps.queue.kafka;

public abstract class KafkaMessageSendService {

	private String topic;

	/**
	 * 所有的发送数据最终都转化为byte[]进行发送
	 * @param bytes
	 */
	protected void sendMessage(byte[] bytes) {
		
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
