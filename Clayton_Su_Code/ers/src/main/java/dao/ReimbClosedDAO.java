package dao;

import java.sql.SQLException;
import java.util.List;

import beans.ReimbClosed;

public interface ReimbClosedDAO
{
	public List<ReimbClosed> getAllClosedReimb() throws SQLException;
	public List<ReimbClosed> getAllClosedReimbById(String id)  throws SQLException;
	public void insertReimb(int amount, int eid, int mid, String status) throws SQLException;
}
