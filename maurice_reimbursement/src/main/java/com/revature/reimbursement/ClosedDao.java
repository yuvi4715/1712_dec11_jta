package com.revature.reimbursement;

import java.util.List;

public interface ClosedDao {
	public List<Closed> getAllClosed();
	public Closed getClosed(Closed closed);
	public boolean insertClosed(Closed closed);
	public boolean approveClosed(int rid, String name);
	public boolean denyClosed(int rid, String name);

}
