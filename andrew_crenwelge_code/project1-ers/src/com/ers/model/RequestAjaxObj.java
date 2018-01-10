package com.ers.model;

import java.util.List;
import java.util.Map;

public class RequestAjaxObj {
	private Map<Integer,String> empMap;
	private List<Request> requestList;

	public Map<Integer,String> getMap() {
		return empMap;
	}

	public void setMap(Map<Integer,String> map) {
		this.empMap = map;
	}

	public List<Request> getRequestList() {
		return requestList;
	}

	public void setRequestobj(List<Request> reqList) {
		this.requestList = reqList;
	}
}
