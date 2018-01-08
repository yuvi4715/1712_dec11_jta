package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReimburseOpen;
import ers.Connect;

public class ReimbOpenDAOImpl implements ReimbOpenDAO
{

	@Override
	public List<ReimburseOpen> getAllOpenReimb() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimburseOpen> getAllOpenReimbsById(String id) throws SQLException
	{
		List<ReimburseOpen> roList = new ArrayList<ReimburseOpen>();
		
		String sql = "select * from Reimburse_Open where eid = ?";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		ReimburseOpen ro = null;
		while (rs.next())
		{
			ro = new ReimburseOpen(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			roList.add(ro);
		}
		
		
		return roList;
	}

	@Override
	public void approve(String[] idList, int resolverID) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deny(String[] idList, int resolverID) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void insertReimb(String amount, String eid) throws SQLException
	{
		String sql = "insert into Reimburse_Open values (r_open_seq.nextval, ?, ?)";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setDouble(1, Double.parseDouble(amount));
		stmt.setInt(2, Integer.parseInt(eid));
		
		stmt.executeUpdate();
	}

	@Override
	public void deleteReimb(int ridO)
	{
		// TODO Auto-generated method stub

	}

}
