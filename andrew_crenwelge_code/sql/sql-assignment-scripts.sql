--create user testuser IDENTIFIED by p4ssw0rd;
--grant connect, resource to testuser;
--GRANT DBA TO testuser WITH ADMIN OPTION

--SELECT STATEMENTS (2.1)
SELECT * FROM CHINOOK.employee;
/
SELECT * FROM chinook.employee
  WHERE lastname = 'King';
/
SELECT * FROM chinook.employee
  WHERE firstname = 'Andrew' AND reportsto IS NULL;

--ORDER BY (2.2)
SELECT * FROM chinook.album
  ORDER BY title;
/
SELECT firstname FROM chinook.customer
  ORDER BY city DESC;

-- INSERT statements (2.3)
INSERT INTO chinook.genre
  VALUES (26, 'Soft rock');
INSERT INTO chinook.genre
  VALUES (27, 'Top 40');
/
INSERT INTO chinook.employee
  VALUES (9, 'Washington','George','President',3,'14-FEB-78','05-JUN-17','123 Main Street','Lexington','CT','USA','12109','+1 (702) 456-1234','+1 (702) 987-6543','gwashington@gmail.com');
INSERT INTO chinook.employee
  VALUES (10, 'Jefferson','Thomas','Vice President',9,'04-JUL-76','01-JAN-15','1776 Freedom St','Philadelphia','PA','USA','72409','+1 (109) 845-8712','+1 (109) 897-7140','tjefferson@gmail.com');
/
INSERT INTO chinook.customer
  VALUES (60, 'Bob', 'Parker', 'Apple, Inc', '341 Copper St', 'San Jose', 'CA', 'USA','74381','+1 (815) 325-9631','+1 (815) 091-9821','bparker@gmail.com',4);
INSERT INTO chinook.customer
  VALUES (61, 'Gabriel', 'Hernandez', 'Oracle', '671 Oracle Dr', 'Austin', 'TX', 'USA','90141','+1 (735) 019-3781','+1 (735) 659-9557','ghernandez@gmail.com',4);

-- UPDATE STATEMENTS (2.4)
UPDATE chinook.customer
  SET firstname = 'Robert', lastname = 'Walter'
  WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
/
UPDATE chinook.artist
  SET name = 'CCR'
  WHERE name = 'Creedence Clearwater Revival';

-- USING LIKE KEWORD (2.5)
SELECT * FROM chinook.invoice
  WHERE billingaddress LIKE 'T%';

-- USING BETWEEN KEWORD (2.6)
SELECT * FROM chinook.invoice
  WHERE total BETWEEN 15 AND 20;
/
SELECT * FROM chinook.employee
  WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- DELETING ENTRY (2.7)
-- first we must dropping constraints and re-adding with cascade delete
ALTER TABLE chinook.invoice
  DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE chinook.invoice
  ADD CONSTRAINT FK_INVOICECUSTOMERID_Cascade
  FOREIGN KEY (CustomerID) REFERENCES chinook.customer(CustomerID) ON DELETE CASCADE;

ALTER TABLE chinook.invoiceline
  DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE chinook.invoiceline
  ADD CONSTRAINT FK_IVLINVOICEID_Cascade
  FOREIGN KEY (InvoiceID) REFERENCES chinook.invoice(InvoiceID) ON DELETE CASCADE;

-- now we can delete a customer and it will delete their invoices
DELETE FROM chinook.customer
  WHERE firstname = 'Robert' AND lastname= 'Walter';

-- FUNCTIONS

-- System defined functions (3.1)
SELECT Current_Timestamp from DUAL;

--get length of mediatype from media table
CREATE OR REPLACE FUNCTION get_mediatype_length(mt_id IN NUMBER)
RETURN NUMBER
AS mt_length NUMBER;
BEGIN
SELECT LENGTH(name) INTO mt_length FROM chinook.mediatype WHERE mediatypeid=mt_id;
RETURN mt_length;
END;
-- use the function
SELECT LENGTH(name) FROM chinook.mediatype WHERE mediatypeid=1;
DECLARE
  l NUMBER;
BEGIN
  l := get_mediatype_length(1);
  dbms_output.put_line('Mediatype length: ' || l);
END;

-- System defined aggregate functions (3.2)
SELECT AVG(total) from chinook.invoice;
/
SELECT * FROM chinook.track 
  WHERE unitprice=(SELECT MAX(unitprice) from chinook.track);
  
-- User defined functions (3.3)
-- create the function here
CREATE or REPLACE FUNCTION avg_invoice_line_price
  RETURN number
  IS ave number;
BEGIN
  SELECT AVG(unitprice) into ave FROM chinook.INVOICELINE;
  RETURN ave;
END;
-- use the function
DECLARE
  c NUMBER(4,2);
BEGIN
  c := avg_invoice_line_price();
  dbms_output.put_line('Average invoice line price: ' || c);
END;

-- USER DEFINED TABLE VALUED FUNCTIONS (3.4)
--Create a function that returns all employees who are born after 1968
SELECT * FROM chinook.employee WHERE birthdate > '31-DEC-68';
  
--STORED PROCEDURES
-- Basic stored procedure (4.1)
-- procedure which gets first and last names of all employees