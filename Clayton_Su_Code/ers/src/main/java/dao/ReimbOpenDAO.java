package dao;

import java.sql.SQLException;
import java.util.List;

import beans.ReimbOpen;

public interface ReimbOpenDAO
{
	public List<ReimbOpen> getAllOpenReimb() throws SQLException;
	public List<ReimbOpen> getAllOpenReimbById(String id)  throws SQLException;
	public void approve(String[] idList, int resolverID) throws SQLException;
	public void deny(String[] idList, int resolverID) throws SQLException;
	public void insertReimb(String amount, String eid) throws SQLException;
	public void deleteReimb(int ridO)throws SQLException;
}
