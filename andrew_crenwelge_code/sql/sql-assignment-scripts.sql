--create user testuser IDENTIFIED by p4ssw0rd;
--grant connect, resource to testuser;
--GRANT DBA TO testuser WITH ADMIN OPTION

--SELECT STATEMENTS (2.1)
SELECT * FROM employee;
/
SELECT * FROM employee
  WHERE lastname = 'King';
/
SELECT * FROM employee
  WHERE firstname = 'Andrew' AND reportsto IS NULL;
/
--ORDER BY (2.2)
SELECT * FROM album
  ORDER BY title;
/
SELECT firstname FROM customer
  ORDER BY city DESC;
/
-- INSERT statements (2.3)
INSERT INTO genre
  VALUES (26, 'Soft rock');
INSERT INTO genre
  VALUES (27, 'Top 40');
/
INSERT INTO employee
  VALUES (9, 'Washington','George','President',3,'14-FEB-78','05-JUN-17','123 Main Street','Lexington','CT','USA','12109','+1 (702) 456-1234','+1 (702) 987-6543','gwashington@gmail.com');
INSERT INTO employee
  VALUES (10, 'Jefferson','Thomas','Vice President',9,'04-JUL-76','01-JAN-15','1776 Freedom St','Philadelphia','PA','USA','72409','+1 (109) 845-8712','+1 (109) 897-7140','tjefferson@gmail.com');
/
INSERT INTO customer
  VALUES (60, 'Bob', 'Parker', 'Apple, Inc', '341 Copper St', 'San Jose', 'CA', 'USA','74381','+1 (815) 325-9631','+1 (815) 091-9821','bparker@gmail.com',4);
INSERT INTO customer
  VALUES (61, 'Gabriel', 'Hernandez', 'Oracle', '671 Oracle Dr', 'Austin', 'TX', 'USA','90141','+1 (735) 019-3781','+1 (735) 659-9557','ghernandez@gmail.com',4);
/
-- UPDATE STATEMENTS (2.4)
UPDATE customer
  SET firstname = 'Robert', lastname = 'Walter'
  WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
/
UPDATE artist
  SET name = 'CCR'
  WHERE name = 'Creedence Clearwater Revival';
/
-- USING LIKE KEWORD (2.5)
SELECT * FROM invoice
  WHERE billingaddress LIKE 'T%';
/
-- USING BETWEEN KEWORD (2.6)
SELECT * FROM invoice
  WHERE total BETWEEN 15 AND 20;
/
SELECT * FROM employee
  WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';
/
-- DELETING ENTRY (2.7)
-- first delete dependency in invoice table
DELETE FROM invoice
WHERE customerid = (SELECT customerid FROM customer WHERE firstname = 'Robert' AND lastname= 'Walter');
/ -- now we can delete the customer
DELETE FROM customer WHERE firstname = 'Robert' AND lastname= 'Walter';
/
-- FUNCTIONS
-- System defined functions (3.1)
SELECT Current_Timestamp from DUAL;
/
--get length of mediatype from media table
CREATE OR REPLACE FUNCTION get_mediatype_length(mt_id IN NUMBER)
  RETURN NUMBER
  AS mt_length NUMBER;
BEGIN
  SELECT LENGTH(name) INTO mt_length FROM mediatype WHERE mediatypeid=mt_id;
RETURN mt_length;
END;
/
-- use the function, input mediatype ID and get length of the name
SELECT get_mediatype_length(1) FROM dual;

-- System defined aggregate functions (3.2)
SELECT AVG(total) from invoice;
/
SELECT * FROM track 
  WHERE unitprice=(SELECT MAX(unitprice) from track);
/
-- User defined functions (3.3)
-- create a function that returns the average invoice line price
CREATE or REPLACE FUNCTION avg_invoice_line_price
  RETURN number
  IS ave number;
BEGIN
  SELECT AVG(unitprice) into ave FROM invoiceline;
  RETURN ave;
END;
-- use the function
SELECT avg_invoice_line_price() FROM dual;

-- USER DEFINED TABLE VALUED FUNCTIONS (3.4)
--Create a function that returns all employees who are born after 1968
CREATE or REPLACE FUNCTION get_emp_born_after(dt date)
  RETURN SYS_REFCURSOR
  IS tbl SYS_REFCURSOR;
BEGIN
  SELECT * into tbl FROM employee where birthdate > dt;
  RETURN tbl;
END;
-- use the function
SELECT get_emp_born_after(TO_DATE('31-DEC-68')) from dual;

--STORED PROCEDURES
-- Basic stored procedure (4.1)
-- Create a procedure which gets first and last names of all employees
-- first create an object
CREATE TYPE NAMES IS OBJECT (
  ID NUMBER, 
  FIRSTNAME VARCHAR(20),
  LASTNAME VARCHAR(20));
/
CREATE OR REPLACE TYPE NAME_TABLE IS TABLE OF NAMES;
/
CREATE  OR REPLACE PROCEDURE getNames
IS
  localNames NAME_TABLE := NAME_TABLE();
  localidx number := 0;
BEGIN
  FOR i IN (SELECT employeeid, firstname, lastname FROM employee)
  LOOP
      localNames.extend;
      localidx := localidx + 1;
      localNames(localidx):= NAMES(i.employeeid, i.firstname, i.lastname);
  END LOOP;
END;
/
CREATE or REPLACE PROCEDURE get_full_names(emp_cursor OUT SYS_REFCURSOR)
  AS BEGIN OPEN emp_cursor FOR
  SELECT CONCAT(firstname,lastname) from employee;
END;
/
-- use the procedure
DECLARE
  emp_cursor SYS_REFCURSOR;
BEGIN
  get_full_names(emp_cursor);
  SELECT * FROM emp_cursor;
END;
/
-- Stored procedure input parameters(4.2)
  -- Create a stored procedure that updates the personal information of an employee
CREATE or REPLACE PROCEDURE update_emp_info(
  id number,title varchar2,rt number,bd date,hd date,add varchar2,city varchar2,
  state varchar2,ctry varchar2,zip varchar2,phone varchar2,fax varchar2,email varchar2
  )
  AS 
BEGIN
  UPDATE employee e
  SET e.title = title,e.reportsto = rt,e.birthdate=bd,e.hiredate=hd,e.address=add,
      e.city=city,e.state=state,e.country=ctry,e.postalcode=zip,e.phone=phone,e.fax=fax,e.email=email
  WHERE e.employeeid = id;
END;
-- use the procedure to update an employee record
BEGIN
  update_emp_info(10,'President',9,'10-DEC-76','12-APR-07','123 Main St','Newark','NJ','USA','10381','130-1350','130-1035','a@me.com');
END;
/
  -- Create a stored procedure that returns the managers of an employee
  -- write the procedure
CREATE or REPLACE PROCEDURE get_manager_of_emp(eid IN number, mgr OUT varchar2)
  AS
BEGIN
  SELECT (m.firstname || ' ' || m.lastname) -- concatenate first/last name of manager
  INTO mgr
  FROM
    employee e
  INNER JOIN -- self join employees & managers
    employee m ON m.employeeid = e.reportsto --(find the manager's id that matches employee's reportsto number)
  WHERE e.employeeid = eid; -- restrict results to only the employeeID we passed in
END;

-- use the stored procedure to get the manager
DECLARE
  man varchar2(50);
  eid number := 7;
BEGIN
  GET_MANAGER_OF_EMP(eid,man);
  DBMS_OUTPUT.PUT_LINE('Manager of Employee w/ID='|| eid || ': ' || man);
END;

-- Stored procedure output parameters(4.3)
  -- Create a stored procedure that returns the name and company of a customer
CREATE or REPLACE PROCEDURE get_name_comp_of_cust(cid IN number,cname OUT varchar2,company OUT varchar2)
  AS
BEGIN
  -- get customer full name
  SELECT (c.firstname || ' ' || c.lastname)
  INTO cname FROM customer c
  WHERE c.customerid = cid;
  -- get customer company
  SELECT c.company
  INTO company FROM customer c
  WHERE c.customerid = cid;
END;
/
-- use the stored procedure to get the customer info
DECLARE
  custID number := 5;
  cname varchar(50);
  company varchar(50);
BEGIN
  get_name_comp_of_cust(custID,cname,company);
  DBMS_OUTPUT.PUT_LINE('Customer ID = '|| custID);
  DBMS_OUTPUT.PUT_LINE('Customer name = '|| cname);
  DBMS_OUTPUT.PUT_LINE('Customer company = '|| company);
END;
/ 

--TRANSACTIONS (5.0)
  --Create a transaction that given a invoiceId will delete that invoice 
  --There may be constraints that rely on this, find out how to resolve them
CREATE or REPLACE PROCEDURE delete_invoice(ivn IN number)
  AS
BEGIN
  --cascade delete is already enabled, which should delete dependent entries in other tables
  DELETE FROM invoice i
  WHERE i.invoiceid = ivn;
  commit;
END;

BEGIN
  delete_invoice(1);
END;
  
  --Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE or REPLACE PROCEDURE insert_customer(
  CUSTOMERID number,FIRSTNAME varchar2,LASTNAME varchar2,COMPANY varchar2,
  ADDRESS varchar2,CITY varchar2,STATE varchar2,COUNTRY varchar2,POSTALCODE varchar2,
  PHONE varchar2,FAX varchar2,EMAIL varchar2,SUPPORTREPID number)
  AS
BEGIN
  INSERT INTO CUSTOMER
  VALUES (CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,
  PHONE,FAX,EMAIL,SUPPORTREPID);
  commit;
END;

-- add a customer using the transaction in the procedure
BEGIN
  insert_customer(62,'Andrew','Crenwelge','Revature','975 Seven Hills Dr','Henderson',
  'NV','USA','89052','702-528-6802','702-528-6802','a@me.com',2);
END;

--TRIGGERS (6.0)
  -- Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER employee_insert_trigger
  AFTER INSERT ON employee
BEGIN
    dbms_output.put_line('A new record was inserted into the employee table!');
END;
/
-- Create an after update trigger on the album table that fires after a row is inserted in the table 
CREATE OR REPLACE TRIGGER album_update_trigger
  AFTER UPDATE ON album
BEGIN
    dbms_output.put_line('The album table was updated!');
END;
/
-- Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER album_update_trigger
  AFTER DELETE ON customer
BEGIN
    dbms_output.put_line('A row was deleted from the customer table!');
END;

--JOINS (7.0)
  --INNER
  -- Create an inner join that joins customers and orders and specifies 
  -- the name of the customer and the invoiceId
  SELECT c.firstname,c.lastname,i.invoiceid FROM customer c
  INNER JOIN invoice i
  ON c.customerid = i.customerid;
  
  --OUTER
  -- Create an outer join that joins the customer and invoice table, 
  -- specifying the CustomerId, firstname, lastname, invoiceId, and total
  SELECT C.CUSTOMERID,C.FIRSTNAME,C.LASTNAME,I.INVOICEID,I.TOTAL FROM CUSTOMER C
  FULL OUTER JOIN INVOICE I
  ON C.CUSTOMERID = I.CUSTOMERID;
  
  --RIGHT
  --Create a right join that joins album and artist specifying artist name and title
  SELECT ART.NAME,ALB.TITLE FROM ALBUM ALB
  RIGHT JOIN ARTIST ART
  ON ALB.ARTISTID = ART.ARTISTID;
  
  --CROSS
  --Create a cross join that joins album and artist and sorts by artist name in ascending order
  SELECT ART.NAME, ALB.TITLE FROM ALBUM ALB
  CROSS JOIN ARTIST ART
  ORDER BY ART.NAME ASC;
  
  --SELF
  --Perform a self-join on the employee table, joining on the reportsto column
  SELECT * FROM EMPLOYEE e1, employee e2
  WHERE E1.REPORTSTO = E2.REPORTSTO;
  
  --COMPLICATED JOIN
  --Create an inner join between all tables in the chinook database
  SELECT * FROM INVOICELINE I1
  INNER JOIN INVOICE I2 ON I1.INVOICEID = I2.INVOICEID
  INNER JOIN CUSTOMER C ON I2.CUSTOMERID = C.CUSTOMERID
  INNER JOIN EMPLOYEE E ON C.SUPPORTREPID = E.EMPLOYEEID
  INNER JOIN TRACK T ON I1.TRACKID = T.TRACKID
  INNER JOIN GENRE G ON T.GENREID = G.GENREID
  INNER JOIN MEDIATYPE M ON T.MEDIATYPEID = M.MEDIATYPEID
  INNER JOIN ALBUM ALB ON T.ALBUMID = ALB.ALBUMID
  INNER JOIN ARTIST ART ON ALB.ARTISTID = ART.ARTISTID
  INNER JOIN PLAYLISTTRACK PLT ON T.TRACKID = PLT.TRACKID
  INNER JOIN PLAYLIST PL ON PLT.PLAYLISTID = PL.PLAYLISTID;
  
--ADMINISTRATION (9.0)
  --Create a .bak file for the Chinook database

SELECT BILLINGCOUNTRY,AVG(total) FROM invoice WHERE TOTAL > 0.99 GROUP BY BILLINGCOUNTRY;
SELECT BILLINGCOUNTRY,ROUND(AVG(total),2) AS AVG_TOTAL 
FROM invoice 
GROUP BY BILLINGCOUNTRY 
HAVING AVG(TOTAL) > 5.5
ORDER BY AVG(TOTAL) DESC;