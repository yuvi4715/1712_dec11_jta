package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReimbClosed;
import ers.Connect;

public class ReimbClosedDAOImpl implements ReimbClosedDAO
{

	@Override
	public List<ReimbClosed> getAllClosedReimb() throws SQLException
	{
		List<ReimbClosed> roList = new ArrayList<ReimbClosed>();
		String sql = "select * from Reimburse_closed order by ridc";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		ReimbClosed ro = null;
		
		while (rs.next())
		{
			ro = new ReimbClosed(rs.getInt(1), rs.getInt(2), rs.getString(3), 
					rs.getInt(4), rs.getInt(5));
			roList.add(ro);
		}
		
		return roList;
	}

	@Override
	public List<ReimbClosed> getAllClosedReimbById(String id) throws SQLException
	{
		List<ReimbClosed> rcList = new ArrayList<ReimbClosed>();
		
		String sql = "select * from Reimburse_Closed where eid = ?";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		ReimbClosed rc = null;
		while (rs.next())
		{
			rc = new ReimbClosed(rs.getInt(1),
					rs.getInt(2), rs.getString(3),
					rs.getInt(4), rs.getInt(5));
			rcList.add(rc);
		}
		
		
		return rcList;
	}

	@Override
	public void insertReimb(int amount, int eid, int mid, String status) throws SQLException
	{
		String sql = "insert into Reimburse_closed values (r_closed_seq.nextval, ?, ?, ? , ?)";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setInt(1, amount);
		stmt.setString(2, status);
		stmt.setInt(3, eid);
		stmt.setInt(4, mid);
		
		stmt.executeUpdate();
	}

}
