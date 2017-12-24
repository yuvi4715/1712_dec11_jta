--2.1 select
--Task Select all the records from the employee table
select * from chinook.EMPLOYEE;
--Task Select all the records from the Employee table where LASTNAME is King.
select * from chinook.EMPLOYEE WHERE LASTNAME = 'King';
--Task- Select all the record from the Employee table where FIRSTNAME is
--Andrew and REPORTSTO NULL
select  * from chinook.EMPLOYEE WHERE FIRSTNAME='Andrew';
--2.2 ORDERBY
--Task- Select all albums in album table and sort the result set in descending
--order by title.
select * from chinook.ALBUM ORDER BY TITLE DESC;
--Task-Select first name from Customer and sort result set in ascending
--order by city
select FIRSTNAME from chinook.CUSTOMER ORDER BY CITY ASC;
--2.3 INSERT INTO
--Task- Insert two record into GENRE table
insert INTO chinook.GENRE(GENREID,NAME) VALUES(26,'Country');
insert INTO chinook.GENRE(GENREID,NAME) VALUES(27,'Folk');
--Task- Insert two records into Employee table
insert INTO chinook.EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,
            BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,
            PHONE,FAX,EMAIL) VALUES(9,'Peterson','John','IT STUFF',6,TO_DATE(
            '1970-9-20 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2004-11-9 00
            :00:00','yyyy-mm-dd hh24:mi:ss'),'7th St. N.','Richmond','VA','US',
            '20980','+1(745)-234-8999','+1(889)-999-9878','jpeterson@chinookcorp.com');
insert INTO chinook.EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,
            BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,
            PHONE,FAX,EMAIL) VALUES(10,'Jeremy','Eliot','Sales Support Agent',
            3, TO_DATE('1975-10-25 00:00:00','yyyy-mm-dd hh24:mi:ss'),
            To_DATE('2006-9-24 00:00:00','yyyy-mm-dd hh24:mi:ss'),
            '245 Highland St.','Baltimore','MD','US','20999',
            '+1(899)929-2342','+1(245)939-3424','jeliot@chinookcorp.com');
--Task- Insert two records into Customer table
insert INTO chinook.CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,
            STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) VALUES(60,
            'Sara','Daniel',NULL,'35th ST NW', 'Silver Spring','MD','US',
            '78999','+1(242)567-9299','+1(242)567-9200','sdaniel@aol.com',3);
            
insert INTO chinook.CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,
            STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID) VALUES(61,
            'keith','Johnson','abc','9th Ave W','Virginia Beach','VA','US','20737',
            '+1(877)789-2334','+1(877)789-2300','keJohnson@tm.com',4);
--2.4 UPDATE
--TASK-Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME = 'Robert',LASTNAME ='Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME='Mitchell';
--TASK-– Update name of artist in the Artist table “Creedence Clearwater Revival” 
--to “CCR”
UPDATE chinook.ARTIST
SET NAME = 'CCR'
WHERE NAME='Creedence Clearwater Revival';
--2.5 LIKE
--Task– Select all invoices with a billing address like “T%”
select * from chinook.INVOICE 
WHERE BILLINGADDRESS LIKE 'T%';
--2.6 BETWEEN
--–Task - Select all invoices that have a total between 15 and 50
select * from chinook.INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1
--st of March 2004
select * from chinook.EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') 
AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
--2.7 DELETE
--Task - Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).

delete from CHINOOK.INVOICELINE T3 WHERE T3.INVOICEID IN (
select T1.INVOICEID from chinook.INVOICE T1
WHERE T1.CUSTOMERID = (SELECT T2.CUSTOMERID from
chinook.CUSTOMER T2
WHERE T2.LASTNAME ='Walter' AND T2.FIRSTNAME='Robert'));
delete from chinook.INVOICE T1
WHERE T1.CUSTOMERID = (SELECT T2.CUSTOMERID from
chinook.CUSTOMER T2
WHERE T2.LASTNAME ='Walter' AND T2.FIRSTNAME='Robert');
delete from chinook.CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
--3.0 SQL functions
select SYSTIMESTAMP from dual;
SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') "NOW"
     FROM DUAL;


--Task -create a function that returns the length of a mediatype
--from the mediatype table
create or replace function getmedialength(mediatype_id Number)
return Number
as media_length Number;
begin
    select length(NAME) into media_length
    from chinook.MEDIATYPE
    WHERE MEDIATYPEID = mediatype_id;
    return media_length;
end;
/
select getmedialength(1) from dual;
--3.2 System defined aggregate functions
--Task – Create a function that returns the average total of all invoices
select AVG(TOTAL) from chinook.INVOICE;
--Task – Create a function that returns the most expensive track
select MAX(UNITPRICE) from CHINOOK.TRACK;
--3.3 User Defined Functions
--Task – Create a function that returns the average price of 
--invoiceline items in the invoiceline table
create or replace function getaverage
return Number
as average Number;
pricesum Number;
invoicesize Number;
begin
    select SUM(I.UNITPRICE) into pricesum
    from chinook.INVOICELINE I;
    select count(*) into invoicesize 
    from chinook.INVOICELINE;
    average := pricesum/invoicesize;
    return average;
end
;
/
select getaverage() from dual;
--3.4 User defined table valued functions
--Task-Create a function that returns all employees who are born after 1968.
create or replace type employeelist as object
(
FIRSTNAME VARCHAR(50),
LASTNAME VARCHAR(50))
/
create type employeelist_t is table of employeelist;
create or replace function getEmployee  return employeelist_t
as listofemployee employeelist_t ;
begin
     select employeelist(FIRSTNAME,LASTNAME)bulk collect
     into listofemployee
     from chinook.EMPLOYEE E1
     WHERE E1.BIRTHDATE > TO_DATE('1968','YYYY');
     return listofemployee;
end
;
/
select * from table( getEmployee());
--4.0 Stored Procedures  
--In this section you will be creating and executing stored procedures. 
--You will be creating various types of stored procedures that take input 
--and output parameters.
--4.1 Basic Stored Procedure 
--Task – Create a stored procedure that selects the first and last names of 
--all the employees. 
create or replace procedure getNames(temp_cursor out SYS_REFCURSOR)
as

begin
  OPEN temp_cursor for select E.FIRSTNAME,E.LASTNAME 
   from chinook.EMPLOYEE E;
end;
/
declare
   emp_cursor SYS_REFCURSOR;
   FIRST_NAME VARCHAR(30);
   LAST_NAME VARCHAR(30);
begin
    getNames(emp_cursor);
    loop
       fetch emp_cursor into FIRST_NAME,lAST_NAME;
       EXIT WHEN emp_cursor%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE(UPPER(LAST_NAME)||','||UPPER(FIRST_NAME));
      
    end loop;
end;
/
   
     
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information 
--of an employee.
create or replace procedure updateEmployee(
                            employee_id in  NUMBER,
                            last_name in VARCHAR,
                            first_name in VARCHAR,
                            tit in VARCHAR,
                            reports_to in NUMBER,
                            birth_date  in DATE,
                            hire_date in DATE,
                            addr in VARCHAR,
                            cty in VARCHAR,
                            st in VARCHAR,
                            ctry in VARCHAR,
                            postal_code in VARCHAR,
                            phone_number in VARCHAR,
                            fax_number in VARCHAR,
                            e_mail in VARCHAR) 
as
begin
    UPDATE CHINOOK.EMPLOYEE 
    SET EmployeeId = employee_id,
        LastName = last_name,
        FirstName = first_name,
        Title = tit,
        ReportsTo = reports_to,
        BirthDate = birth_date,
        HireDate = hire_date,
        Address = addr,
        City = cty,
        State = st,
        Country = ctry,
        PostalCode = postal_code,
        Phone = phone_number,
        Fax = fax_number,
        Email = e_mail WHERE EmployeeId = employee_id;
end;
/
 begin
    updateEmplyee(8,'Randolph','Jone','Sales agent',
                  2,TO_DATE('1969-11-26 00:00:00','YYYY-MM-DD HH24:MI:SS'),
                  TO_DATE('2007-8-12 00:00:00','YYYY-MM-DD HH24:MI:SS'),
                  '13TH ST. N.','SEATTLE','WA','US','99999','+1(877)889-9923',
                  '+1(877)889-9900','GGGG@NMAIL.COM');
end;
/                       
                                           
--Task – Create a stored procedure that returns the managers of an employee. 
create or replace procedure getManager( employee_id NUMBER)
as
my_cursor SYS_REFCURSOR;
first_name varchar(30);
last_name varchar(30);
begin
  open my_cursor for select FIRSTNAME,LASTNAME 
   FROM CHINOOK.EMPLOYEE 
   WHERE REPORTSTO =(
   select REPORTSTO FROM chinook.EMPLOYEE 
   WHERE EMPLOYEEID = employee_id);
   FETCH my_cursor into first_name,last_name;
   DBMS_OUTPUT.PUT_LINE(first_name||' '||last_name);
END;
/


EXEC getManager(7);--caling the procedure with input
   

--4.3 Stored Procedure Output Parameters 
--Task–Create a stored procedure that returns the name and company of a customer. 
create or replace procedure getCustomer( customer_id number)
as 
customer_cursor SYS_REFCURSOR;
first_name VARCHAR(30);
last_name VARCHAR(30);
cmpny VARCHAR(20);
begin
    open customer_cursor for select FIRSTNAME,
    LASTNAME,COMPANY FROM CHINOOK.CUSTOMER
    WHERE CUSTOMERID = customer_id;
    fetch customer_cursor into first_name,
    last_name, cmpny;
    DBMS_OUTPUT.PUT_LINE(UPPER(first_name)||' '||UPPER(last_name)||' '||cmpny);
end;
/
exec getCustomer(10);
--5.0 Transactions 
--In this section you will be working with transactions.
--Transactions are usually nested within a stored procedure. 
--Task – Create a transaction that given a invoiceId will delete
--that invoice (There may be constraints that rely on this,
--find out how to resolve them). 
create or replace procedure DeleteEnvoice( invoice_id NUMBER)
AS
BEGIN
  SET TRANSACTION NAME 'invoice-delete';
   delete from chinook.INOVOICLINE
   WHERE CHINOOK.INVOICELINE.INVOICEID = invoice_id;
   delete from CHINOOK.INVOICE 
   WHERE  INVOICEID = invoice_id;
   commit;
END;
/
--Task – Create a transaction nested within a stored procedure that 
--inserts a new record in the Customer table 
 create or replace procedure inserttable(customer_id NUMBER,
                                        first_name VARCHAR,
                                        last_name VARCHAR,
                                        cmpny VARCHAR,
                                        addrs VARCHAR,
                                        cty VARCHAR,
                                        st VARCHAR,
                                        ctry VARCHAR,
                                        postal_code VARCHAR,
                                        phone_number VARCHAR,
                                        fax_number VARCHAR,
                                        e_mail VARCHAR,
                                        support_repid VARCHAR)
as 
begin
    SET TRANSACTION NAME 'insert_new_record';
    insert into chinook.CUSTOMER VALUES(customer_id ,
                                        first_name ,
                                        last_name ,
                                        cmpny ,
                                        addrs,
                                        cty,
                                        st,
                                        ctry,
                                        postal_code ,
                                        phone_number ,
                                        fax_number,
                                        e_mail ,
                                        support_repid);
        COMMIT;
END;
/
--6.0 Triggers In this section you will create various kinds of triggers 
--that work when certain DML statements are executed on a table. 
--6.1 AFTER/FOR 
--Task - Create an after insert trigger on the employee
--table fired after a new record is inserted into the table.
create table employee_hire_history(
    employee_id NUMBER,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    reports_to NUMBER,
    hire_date DATE
    );
create or replace trigger insert_employee
after insert on CHINOOK.EMPLOYEE for each row
begin
    insert into employee_hire_history values
    (:new.EMPLOYEEID,:NEW.FIRSTNAME,:NEW.LASTNAME,
     :NEW.REPORTSTO,:new.HIREDATE);
END;
/
--checking contents of employee_hire_history
select * from employee_hire_history;
--Task – Create an after update trigger on the album table that fires 
--after a row is inserted in the table 
create table album_history(
    album_title VARCHAR(30)
    );
create or replace trigger check_album_history
after update on chinook.ALBUM for each row
begin
    insert into album_history values(
        :new.TITLE);
end;
/
insert into chinook.ALBUM values(348,'Live(Disc 3)',137);
insert into chinook.ALBUM values(349,'Live(Disc 4)',137);
insert into chinook.ALBUM values(350,'Live(Disc 5)',137);
insert into chinook.ALBUM values(352,'Live(Disc 7)',137);
--checking content of the albu_history table
select * from album_history;


--Task – Create an after delete trigger on the customer table that 
--fires after a row is deleted from the table. 
create table customerhistorytable(
    CustomerId NUMBER,
    FirstName VARCHAR2(40),
    LastName VARCHAR2(20),
    Company VARCHAR2(80),
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60),
    SupportRepId NUMBER
);
  create or replace trigger delete_customer 
  after delete on CHINOOK.CUSTOMER FOR EACH ROW
  BEGIN
    insert into customerhistorytable values(:old.customerid,
                                        :old.firstname,
                                        :OLD.LASTNAME,
                                        :OLD.COMPANY,
                                        :OLD.ADDRESS,
                                        :OLD.CITY,
                                        :OLD.STATE,
                                        :OLD.COUNTRY,
                                        :OLD.POSTALCODE,
                                        :OLD.PHONE,
                                        :OLD.FAX,
                                        :OLD.EMAIL,
                                        :OLD.SUPPORTREPID);
END;
/
  delete from chinook.CUSTOMER
  WHERE CUSTOMERID = 61;
 delete from chinook.CUSTOMER
  WHERE CUSTOMERID = 60;
 --checking contents of customerhistorytable
 select * from customerhistorytable;
--7.0 JOINS In this section you will be working with combing various tables 
--through the use of joins. You will work with outer, inner, right, left, cross,
--and self joins. 
--7.1 INNER 
--Task – Create an inner join that joins customers and orders and
--specifies the name of the customer and the invoiceId. 
select FIRSTNAME, LASTNAME,INVOICEID from
CHINOOK.CUSTOMER C1 inner join  CHINOOK.INVOICE I1
ON C1.CUSTOMERID = I1.CUSTOMERID;

--7.2 OUTER 
--Task – Create an outer join that joins the customer and invoice table,
--specifying the CustomerId, firstname, lastname, invoiceId, and total. 
select C2.CUSTOMERID, FIRSTNAME,LASTNAME,INVOICEID,TOTAL
from CHINOOK.CUSTOMER C2 full outer join CHINOOK.INVOICE I2 
on C2.CUSTOMERID = I2.CUSTOMERID;

--7.3 RIGHT 
--Task – Create a right join that joins album and artist specifying 
--artist name and title
select NAME ,TITLE FROM CHINOOK.ALBUM A1
RIGHT JOIN CHINOOK.ARTIST AR ON A1.ARTISTID = AR.ARTISTID;
--7.4 CROSS 
--Task – Create a cross join that joins album and artist and 
--sorts by artist name in ascending order. 
select NAME, TITLE FROM CHINOOK.ALBUM 
CROSS JOIN CHINOOK.ARTIST ORDER BY NAME ASC;
--7.5 SELF 
--Task – Perform a self-join on the employee table, 
--joining on the reportsto column. 
select E1.FIRSTNAME,E1.LASTNAME,E2.FIRSTNAME AS REPORTS_TO_FIRSTNAME,
E2.LASTNAME AS REPORTS_TO_LASTNAME from CHINOOK.EMPLOYEE E1 INNER JOIN
CHINOOK.EMPLOYEE E2 ON E1.REPORTSTO = E2.EMPLOYEEID;
--7.6 Complicated Join assignment 
--Create an inner join between all tables in the chinook database. 
select C1.FIRSTNAME AS CUSTOMER_FNAME ,C1.LASTNAME AS CUSTOMER_LNAME,
E1.FIRSTNAME AS EMPLOYEE_FNAME,E1.LASTNAME AS EMPLOYEE_LNAME,
T.NAME AS TRACKNAME,I.TOTAL FROM CHINOOK.EMPLOYEE E1 INNER JOIN
CHINOOK.CUSTOMER C1 ON E1.EMPLOYEEID = C1.SUPPORTREPID INNER JOIN
CHINOOK.INVOICE I ON C1.CUSTOMERID = I.CUSTOMERID INNER JOIN
CHINOOK.INVOICELINE L ON I.INVOICEID = L.INVOICEID INNER JOIN
CHINOOK.TRACK T ON L.TRACKID = T.TRACKID INNER JOIN 
CHINOOK.MEDIATYPE M ON T.MEDIATYPEID = M.MEDIATYPEID;

select G.NAME AS GENRENAME,AL.TITLE AS ALBUMTITLE,AR.NAME AS ARTISTNAME
FROM CHINOOK.GENRE G INNER JOIN CHINOOK.TRACK T ON T.GENREID = G.GENREID
INNER JOIN CHINOOK.ALBUM AL ON AL.ALBUMID = T.ALBUMID INNER JOIN
CHINOOK.ARTIST AR ON AR.ARTISTID = AL.ARTISTID;


     

--9.0 Administration 
--In this section you will be creating backup files of your database. 
--After you create the backup file you will also restore the database. 
--Task – Create a .bak file for the Chinook database 

     
