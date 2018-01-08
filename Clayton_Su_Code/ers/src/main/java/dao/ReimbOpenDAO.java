package dao;

import java.sql.SQLException;
import java.util.List;

import beans.ReimburseOpen;

public interface ReimbOpenDAO
{
	public List<ReimburseOpen> getAllOpenReimb() throws SQLException;
	public List<ReimburseOpen> getAllOpenReimbsById(String id)  throws SQLException;
	public void approve(String[] idList, int resolverID) throws SQLException;
	public void deny(String[] idList, int resolverID) throws SQLException;
	public void insertReimb(String amount, String eid) throws SQLException;
	public void deleteReimb(int ridO)throws SQLException;
}
