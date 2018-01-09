package beans;

public class ReimbOpen
{
	int ridO;
	int amount;
	int eid;
	
	public ReimbOpen(int rid, int amnt, int id)
	{
		this.ridO = rid;
		this.amount = amnt;
		this.eid = id;
	}
	
	public int getRidO()
	{
		return ridO;
	}
	public void setRidO(int ridO)
	{
		this.ridO = ridO;
	}
	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	public int getEid()
	{
		return eid;
	}
	public void setEid(int eid)
	{
		this.eid = eid;
	}
}
