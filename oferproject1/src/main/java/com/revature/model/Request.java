package com.revature.model;

public class Request {
	
	private int rid;		//Request ID
	private int eid;		//Employee ID
	private String amount;	//Amount
	private String sdate;	//Start Date
	private String edate;	//End Date
	private String status;	//Status = Pending, Approved, Denied
	private String type;	//Type = Travel, Training, Lodging, Other
	private String type2;	//Details (optional)
	private int resid;		//Request resolved by ID
	private int rflag;		//0 - no receipt attached, 1 - receipt attached
	private String rurl;	//Receipt URL
	
	public Request() {
		this.rid=0;
		this.eid=0;
		this.amount = "";
		this.sdate = "";
		this.edate = "";
		this.status = "";
		this.type = "";
		this.type2 = "";
		this.resid=0;
		this.rflag = 0;
		this.rurl = "";	
	}
	public Request(int eid,String amount) {
		this.eid=eid;
		this.amount=amount;
	}
	
	public Request(int eid, String amount, String type) {
		this.eid=eid;
		this.amount = amount;
		this.type = type;
	}
	
	public Request(int rid, int resid, String status) {
		this.rid=rid;
		this.resid=resid;
		this.status = status;
	}
	
	public Request(int eid, String amount, String type, String type2, int rflag, String rurl) {
		super();
		this.eid=eid;
		this.amount = amount;
		this.type = type;
		this.type2 = type2;
		this.rflag = rflag;
		this.rurl = rurl;
	}
	
	public Request(int rid, int eid, String amount, String sdate, String edate,String status,String type, String type2, 
			int resid, int rflag, String rurl) {
		super();
		this.rid=rid;
		this.eid=eid;
		this.amount = amount;
		this.sdate = sdate;
		this.edate = edate;
		this.status=status;
		this.type = type;
		this.type2 = type2;
		this.resid=resid;
		this.rflag = rflag;
		this.rurl = rurl;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public int getResid() {
		return resid;
	}

	public void setResid(int resid) {
		this.resid = resid;
	}
	
	public int getRflag() {
		return rflag;
	}

	public void setRflag(int rflag) {
		this.rflag = rflag;
	}

	public String getRurl() {
		return rurl;
	}

	public void setRurl(String rurl) {
		this.rurl = rurl;
	}
	
	public String toString() {
		
			
			return rid + "|" + eid + "|" + amount + "|" + sdate+ "|" + edate+ "|" + status
					+ "|" + type+ "|" + type2+"|" + resid+"|" + rflag +"|"+rurl+"\n";
	}

}
