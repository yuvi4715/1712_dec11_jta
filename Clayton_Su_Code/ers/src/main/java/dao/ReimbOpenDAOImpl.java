package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReimbOpen;
import ers.Connect;

public class ReimbOpenDAOImpl implements ReimbOpenDAO
{

	@Override
	public List<ReimbOpen> getAllOpenReimb() throws SQLException
	{
		List<ReimbOpen> roList = new ArrayList<ReimbOpen>();
		String sql = "select * from Reimburse_Open order by rido";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		ReimbOpen ro = null;
		
		while (rs.next())
		{
			ro = new ReimbOpen(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			roList.add(ro);
		}
		
		return roList;
	}

	@Override
	public List<ReimbOpen> getAllOpenReimbById(String id) throws SQLException
	{
		List<ReimbOpen> roList = new ArrayList<ReimbOpen>();
		
		String sql = "select * from Reimburse_Open where eid = ?";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		ReimbOpen ro = null;
		while (rs.next())
		{
			ro = new ReimbOpen(rs.getInt(1), rs.getInt(2), rs.getInt(3));
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
	public void deleteReimb(int ridO) throws SQLException
	{
		String sql = "delete from Reimburse_Open where rido = ?";
		PreparedStatement stmt = Connect.getConnection().prepareStatement(sql);
		stmt.setInt(1, ridO);
		
		
		stmt.executeUpdate();
		
	}

}
