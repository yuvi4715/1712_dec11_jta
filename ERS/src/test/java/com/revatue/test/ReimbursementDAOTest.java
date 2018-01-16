package com.revatue.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.util.FinalUtil;

public final class ReimbursementDAOTest {

	Reimbursement reimbursement;
	@Before
	public void setUp() throws Exception {
		reimbursement = new Reimbursement("Sam", "Tang", 1783, FinalUtil.RESOLVED, FinalUtil.APPROVED, 17.38, "Feels like a good day for reimbursements",
				new Timestamp(46516549), "Robin", "Pierre", 46);
		reimbursement.setManid(1);
	}

	@Test
	public final void testInsertPending() {
		assertTrue(ReimbursementDAO.getInstance().insertPending(reimbursement));
	}

	@Test
	public final void testUpdatePendingStatus() {
		assertTrue(ReimbursementDAO.getInstance().updatePendingStatus(reimbursement));
	}

	@Test
	public final void testGetReimbursementsForEmployee() {
		assertNotNull(ReimbursementDAO.getInstance().getReimbursementsForEmployee(reimbursement.getEid(), reimbursement.getType()));
	}

	@Test
	public final void testGetReimbursements() {
		assertNotNull(ReimbursementDAO.getInstance().getReimbursements(reimbursement.getType()));
	}

	@Test
	public final void testGetAllReimbursements() {
		assertNotNull(ReimbursementDAO.getInstance().getAllReimbursements());
	}

}
