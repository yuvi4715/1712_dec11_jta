package com.ers.util;

public class RtnMsg {
	private String successMsg;
	private String errMsg;
	private Boolean success;
	
	public String getSuccessMsg() {
		return successMsg;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setSuccessMsg(String s) {
		this.successMsg = s;
	}
	public void setErrMsg(String s) {
		this.errMsg = s;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
