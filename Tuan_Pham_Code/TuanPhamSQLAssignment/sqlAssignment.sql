/* Select all records from the Employee table. 
The * denotes everything
*/
SELECT * FROM EMPLOYEE;
/

/* Select all records from the Employee table where last name is King. */
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
/

/* Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL. 
Cannot use = NULL. Must use IS NULL when checking if anything is null
*/
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;
/

/* Task – Select all albums in Album table and sort result set in descending order by title. 
DESC for descending ordering
*/
Select * from ALBUM 
ORDER BY TITLE DESC;
/

/* Task – Select first name from Customer and sort result set in ascending order by city 
 ASC for ascending ordering
*/
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;
/

/* Task – Insert two new records into Genre table 
GENRE(GENREID, NAME)
*/
INSERT INTO GENRE
VALUES(26, 'Techno');
INSERT INTO GENRE
VALUES(27, 'Oldies');
/

/* Task – Insert two new records into Employee table 
EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
*/
INSERT INTO EMPLOYEE
VALUES(9, 'Pham', 'Tuan', 'Trainee', '3', '22-Feb-93', '10-Dec-17', '123 Fake St', 'Faketown', 'CA', 'United States', '92680', '+1 (714) 725-5800', '+1 (400) 800-4300', 'tuanemail@gmail.com');
INSERT INTO EMPLOYEE
VALUES(10, 'White', 'Emily', 'Trainee', '3', '02-Apr-93', '11-Dec-17', '70 Fakest St', 'Newtown', 'VA', 'United States', '21790', '+1 (714) 888-8080', '+1 (400) 809-4300', 'emilyemail@gmail.com');
/

/* Task – Insert two new records into Customer table 
CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID
*/
INSERT INTO CUSTOMER
VALUES(60, 'Tuan', 'Pham', NULL, '153 America Plaza Dr', 'VA', 'United States', '8911', '+1 723 233 3232', NULL, 'tuanemail@hotmail.com', 5);
INSERT INTO CUSTOMER
VALUES(61, 'Joseph', 'Brown', NULL, '793 Right St', 'CA', 'United States', '73000', '+1 690 444 1414', NULL, 'jd142@hotmail.com', 3);
/

/* Task – Update Aaron Mitchell in Customer table to Robert Walter */

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
/

--Test to see if row updated
--SELECT FIRSTNAME,LASTNAME 
--FROM CUSTOMER;

/* Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” */
UPDATE ARTIST
SET NAME ='CCR'
WHERE NAME = 'Creedence Clearwater Revival';
--SELECT * FROM ARTIST;
/

/* Task – Select all invoices with a billing address like “T%” */
-- % wildcard to match specific pattern
-- _ wildcard for single character
SELECT * 
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/

/* Task – Select all invoices that have a total between 15 and 50 */
SELECT * 
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
/

/* Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 */
--Date format DD-MM-YY
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';
/

/* Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). */
--The code will not execute because there is a dependency with CUSTOMERID. We need to also remove it from INVOICE because it is a foreign key
DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID
                        FROM (SELECT INVOICEID
                            FROM INVOICE
                            WHERE CUSTOMERID =32));
--However CUSTOMERID is also INVOICE has another foreign key with INVOICELINE so we must find and delete INVOICEID as well
DELETE FROM INVOICE 
WHERE CUSTOMERID = 32;

DELETE FROM CUSTOMER
WHERE FIRSTNAME ='Robert' AND LASTNAME ='Walter';
/

--check to see if Robert Walter has successfully been removed
--select FIRSTNAME, LASTNAME
--FROM CUSTOMER;

/* Task – Create a function that returns the current time */
--Use SYSTIMESTAMP to get the current time, LOCALTIMESTAMP uses the local time based on location
--use toChar to format the time 
     
create or replace function getCurrentTime
return varchar
as theCurrentTime varchar(30);
begin
    SELECT to_char(LOCALTIMESTAMP, 'HH:MI:SS')
    INTO theCurrentTime from dual;
    return theCurrentTime;
end
;
/

--select getCurrentTime from dual;

/* Task – create a function that returns the length of a mediatype from the mediatype table */
create or replace function getLengthMedia(mediaID Number)
return NUMBER
as theLength varchar(50);
lengthvalue NUMBER;

begin
-- Use select into to store the result of a query into a variable
    SELECT NAME INTO theLength FROM MEDIATYPE 
    WHERE MEDIATYPEID = mediaID;
    -- use := to assign a variable
    lengthvalue := length(theLength);
    return lengthvalue;
end
;
/
-- Pass a parameter MEDIATYPEID to find the length of the name corresponding to the ID
select getLengthMedia(3) from dual;

/* Task – Create a function that returns the average total of all invoices */

create or replace function invoiceAvg
return NUMBER
as totalAvg NUMBER;
begin
-- Use the aggregate function AVF to easily avg up a column 
    SELECT AVG(i.TOTAL) INTO totalAvg FROM INVOICE i;
    Return totalAvg;
end
;
/
--select invoiceAvg from dual;

/* Task – Create a function that returns the most expensive track */
--Use MAX to find the highest price of tracks
create or replace function expensiveTrack
return NUMBER
as mostExp NUMBER;
begin
    SELECT MAX(y.UNITPRICE) INTO mostExp
    FROM TRACK y;
    
    return mostExp;
end
;
/
select expensiveTrack from dual;

/* Task – Create a function that returns the average price of invoiceline items in the invoiceline table */
create or replace function invoiceLineAvg
return NUMBER
as iTotalAvg NUMBER;
begin
-- Use the aggregate function sum to easily sum up a column 
    SELECT AVG(i.UNITPRICE) INTO iTotalAvg FROM INVOICELINE i;
    Return iTotalAvg;
end
;
/
--select invoiceLineAvg from dual;

/* Task – Create a function that returns all employees who are born after 1968. */
create or replace function afterYear
-- Make a cursor that holds the result of our query
return SYS_REFCURSOR
IS 
    myCursor SYS_REFCURSOR;
begin
    -- Store resultset into cursor
    OPEN myCursor FOR 
        -- Concatenate the first name and last name
        SELECT e.FIRSTNAME || ' ' || e.LASTNAME
        FROM EMPLOYEE e
        WHERE
        --After this date will be after the year 1968
        e.BIRTHDATE > '31-Dec-68';
    
    return myCursor;
end afterYear;
/
-- Print out the resultset
DECLARE
    myNames SYS_REFCURSOR;
    employeeBorn varchar2(32767);
BEGIN
    -- Store the result of the function into a varchar
    myNames := afterYear;
    
    LOOP
        -- Loop through to return multiple rows that match the query
        FETCH myNames INTO employeeBorn;
        EXIT WHEN myNames%NOTFOUND;
        DBMS_OUTPUT.put_line(employeeBorn);
    END LOOP;
    close myNames;
END;
/

    
/* Task – Create a stored procedure that selects the first and last names of all the employees. */
-- Stored procedures don't need a return type or could return more than one
create or replace procedure employeeNames(myCursor OUT SYS_REFCURSOR)
--Pass a cursor as parameter that will be used to display the results of select query
as
begin
    --store query into cursor
    open myCursor FOR SELECT FIRSTNAME, LASTNAME 
    from EMPLOYEE;
end;
/

declare
    empCursor SYS_REFCURSOR;
    fName varchar2(20);
    lName varchar2(20);

begin
    employeeNames(empCursor);
    --retreive the data from query and print
    loop
        FETCH empCursor INTO fName, lName;
        EXIT WHEN empCursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(fName|| ' ' || lName);
    end loop;
end;
/
/* Task – Create a stored procedure that updates the personal information of an employee. */
create or replace procedure updateEmp(id Number, lName varchar2, fName varchar2, title varchar2, rep Number, bDate DATE, hDate DATE,
add varchar2, city varchar2, state varchar2, country varchar2, postal varchar2, phone varchar2, fax varchar2, email varchar2)
as
begin
    UPDATE EMPLOYEE
        SET 
            EMPLOYEEID = id,
            LASTNAME = lName,
            FIRSTNAME = fName,
            TITLE = title,
            REPORTSTO = rep,
            BIRTHDATE = bDate,
            HIREDATE = hDate,
            ADDRESS = add,
            CITY = city,
            STATE = state,
            COUNTRY = country,
            POSTALCODE = postal,
            PHONE = phone,
            FAX = fax,
            EMAIL = email
            
        WHERE id = EMPLOYEEID;
end
;
/
--exec updateEmp(9, 'Pham','John','Trainee',3,'03-Feb-93','12-Dec-17','123 Roundwood St', 'Reston','VA', '97128','714-777-8888', '(800)999-9999', 'myEmail@cpp.edu');

/* Task – Create a stored procedure that returns the managers of an employee. */
create or replace procedure empManager
as
begin

end
;
/

/* Task – Create a stored procedure that returns the name and company of a customer. */


/* Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them). */


/* Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table */


/* Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. */


/* Task – Create an after update trigger on the album table that fires after a row is inserted in the table */


/* Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. */


/*Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. */


/* Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.*/


/* Task – Create a right join that joins album and artist specifying artist name and title. */


/* Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. */


/*Task – Perform a self-join on the employee table, joining on the reportsto column. */


/* Create an inner join between all tables in the chinook database. */


/* Task – Create a .bak file for the Chinook database */

commit;