<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Expense Reimbursement System</h1>
	<div>
	  <button type="button">Add New Reimbursement Request</button>
	  <form>
	    <label for="name">Request name</label>
	    <input name="name" type="text" />
	    <label for="amount">Amount</label>
	    <input name="amount" type="number" />
	    <label for="description">Description</label>
	    <input name="description" type="text" />
	    <label for="imagefile">Upload Receipt Picture</label>
	    <input name="imagefile" type="file"/>
	    <button type="submit">Submit Request</button>
	  </form>
	</div>
	<div>
		<h2>Existing Reimbursement Requests</h2>
		<div>
		  <table>
		    <caption>Pending Requests</caption>
			  <thead><tr>
			    <th>Reimbursement Request No.</th>
			    <th>Name</th>
			    <th>Description</th>
			    <th>Amount</th>
			    <th>Date Submitted</th></tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>Test</td>
			      <td>Test</td>
			      <td>Test</td>
			      <td>Test</td>
			      <td>Test</td>
			    </tr>
			  </tbody>
		  </table>
		</div>
		<div>
		  <table>
		    <caption>Resolved Requests</caption>
			  <thead><tr>
			    <th>Reimbursement Request No.</th>
			    <th>Name</th>
			    <th>Description</th>
			    <th>Status</th>
			    <th>Amount</th>
			    <th>Date Submitted</th></tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>Test</td>
			      <td>Test</td>
			      <td>Test</td>
			      <td>Test</td>
			      <td>Test</td>
			      <td>Test</td>
			    </tr>
			  </tbody>
		  </table>
		</div>
	</div>
</body>
</html>