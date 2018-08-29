package com.vbgps.queue.msg;

public enum RabbitMessageParamKey {

	RABBIT_CONTENT_TYPE("rabbit_content_type"),

	RABBIT_CONTENT_ENCODING("rabbit_content_encoding"),

	RABBIT_PRIORITY("rabbit_priority"),

	RABBIT_CORRELATION_ID("rabbit_correlation_id"),

	RABBIT_REPLY_TO("rabbit_reply_to"),

	RABBIT_EXPIRATION("rabbit_expiration"),

	RABBIT_MESSAGE_ID("rabbit_message_id"),

	RABBIT_TIMESTAMP("rabbit_timestamp"),

	RABBIT_TYPE("rabbit_type"),

	RABBIT_USER_ID("rabbit_user_id"),

	RABBIT_APP_ID("rabbit_app_id"),

	RABBIT_CLUSTER_ID("rabbit_cluster_id");

	private RabbitMessageParamKey(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
