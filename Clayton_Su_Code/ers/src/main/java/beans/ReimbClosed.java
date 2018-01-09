package beans;

public class ReimbClosed
{
	int ridC;
	int amount;
	String status;
	int eid;
	int mid;
	
	public ReimbClosed(int rid_clos, int amt, String stts, int emp_id, int mana_id)
	{
		this.ridC = rid_clos;
		this.amount = amt;
		this.status = stts;
		this.eid = emp_id;
		this.mid = mana_id;
	}
	
	public int getRidC()
	{
		return ridC;
	}
	public void setRidC(int ridC)
	{
		this.ridC = ridC;
	}
	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public int getEid()
	{
		return eid;
	}
	public void setEid(int eid)
	{
		this.eid = eid;
	}
	public int getMid()
	{
		return mid;
	}
	public void setMid(int mid)
	{
		this.mid = mid;
	}
	
}
