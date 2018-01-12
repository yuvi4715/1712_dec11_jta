package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Request;

public interface RequestDao {

//	\1-An Employee can submit a reimbursement request\
//	\3-An Employee can view their pending reimbursement requests\
//	\4-An Employee can view their resolved reimbursement requests\

//	\5-A Manager can approve/deny pending reimbursement requests\
//	\6-A Manager can view all pending requests from all employees\
//	\8-A Manager can view all resolved requests from all employees and see which manager resolved it\
//	\9-A Manager can view reimbursement requests from a single Employee\
//  \10-A Manager can do everything an employee can do\

	
//	Optional
//	2-An Employee can upload an image of his/her receipt as part of the reimbursement request (hard / do last) (optional)
//	7-A Manager can view images of the receipts from reimbursement requests (hard /do last) (optional)	
	
	public boolean insertRequest(Request request);				//1
	public boolean insertRequestProcedure(Request request);	//1
	public boolean finalizeProcedure(Request request);	//5
	public Request select(Request request);				//?
	public List<Request> selectOpen(Employee employee);					//3,9
	public List<Request> selectClosed(Employee employee);				//4
	public List<Request> selectAllOpen();				//6
	public List<Request> selectAllClosed();				//7
}
