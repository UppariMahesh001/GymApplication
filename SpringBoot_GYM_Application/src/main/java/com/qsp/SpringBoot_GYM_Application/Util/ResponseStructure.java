package com.qsp.SpringBoot_GYM_Application.Util;

import java.util.List;
 
public class ResponseStructure <T> {
	
	private int status;
	private String message;
	private T Data;
	
	private List<T> datas;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
	}
	
