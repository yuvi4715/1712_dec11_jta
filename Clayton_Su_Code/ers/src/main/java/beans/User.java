package beans;

public class User
{
	int eid;
	String username;
	String password;
	String firstname;
	String lastname;
	String isManager;
	
	public User(int emp_id, String usr, String pss, String frstnme, String lstnme, String isMana)
	{
		this.eid = emp_id;
		this.username = usr;
		this.password = pss;
		this.firstname = frstnme;
		this.lastname = lstnme;
		this.isManager = isMana;
	}
	
	public int getEid()
	{
		return eid;
	}
	public void setEid(int eid)
	{
		this.eid = eid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public String getLastname()
	{
		return lastname;
	}
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	public String getIsManager()
	{
		return isManager;
	}
	public void setIsManager(String isManager)
	{
		this.isManager = isManager;
	}
	
}

