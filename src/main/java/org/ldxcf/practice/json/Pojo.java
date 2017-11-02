package org.ldxcf.practice.json;

import com.google.gson.annotations.SerializedName;

public class Pojo<T> {
	@SerializedName("code")
	private String name;
	@SerializedName("message")
	private String desc;
	private T data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
