package com.vbgps.queue.msg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message<T extends Serializable> {

	private Map<String, Object> params = new HashMap<String, Object>();

	private T msg;

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
