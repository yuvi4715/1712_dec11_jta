--2.1.1

SELECT * 
FROM Employee;


--2.1.2

SELECT * 
FROM Employee
WHERE Lastname = 'King';

--2.1.3

SELECT * 
FROM Employee
WHERE Firstname = 'Andrew' AND Reportsto IS NULL;

--2.2.1

SELECT *
FROM Album
ORDER BY Title DESC;

--2.2.2

SELECT Firstname
FROM Customer
ORDER BY City ASC;

--2.3.1

INSERT INTO Genre (GenreID, Name)
VALUES (26, 'Java');

INSERT INTO Genre (GenreID, Name)
VALUES (27, 'SQL');

--2.3.2

INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, Title, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, city, state, country, postalcode, phone, fax, email)
VALUES (9, 'Manayath','Isaac', 'Trainee', 1, '03-APR-92', '03-APR-93', '27 Washington Dr.', 'Watchung', 'NJ', 'US', 'T1K 333', '+1 (403) 444-4567', '+1(405) 123 4567', 'imanayath@yahoo.com');

INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, Title, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, city, state, country, postalcode, phone, fax, email)
VALUES (10, 'Skywalker','Luke', 'Trainee', 2, '03-APR-60', '03-APR-77', '27 Washington Lane.', 'Tatooine', 'Drake Star System', 'Empire', 'T1K 444', '+1 (503) 444-4567', '+1(605) 123 4567', 'MonkLuke@yahoo.com');

--2.3.3

INSERT INTO Customer (Customerid, FIRSTNAME, LASTNAME, Company, ADDRESS, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES (60, 'Isaac', 'Manayath', 'Revature', '27 Washington Dr.', 'Watchung', 'NJ', 'US', '07069', '+1 (403) 444-4567', '+1(405) 123 4567', 'imanayath@yahoo.com',3);

INSERT INTO Customer (Customerid, FIRSTNAME, LASTNAME, Company, ADDRESS, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES (61, 'Darth', 'Vader', 'Empire', '27 Washington Dr.', 'Tatooine', 'NJ', 'Empire', '07069', '+1 (403) 444-4567', '+1(405) 123 4567', 'DarthVader@yahoo.com',3);

--2.4.1

UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

--2.4.2

UPDATE Artist
SET name = 'CCR'
WHERE artistid = 76;

--2.5.1

SELECT *
FROM Invoice
WHERE BILLINGADDRESS LIKE 'T%';

--2.6.1

SELECT * 
FROM INVOICE
WHERE Total BETWEEN 15 AND 50;

--2.6.2

SELECT * 
FROM Employee
WHERE Hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';


--2.7.1


SELECT * FROM USER_CONSTRAINTS;

Alter table invoiceline
DISABLE constraint FK_INVOICELINEINVOICEID;

delete from invoice
where invoiceid in(342, 50, 61, 116, 245, 269, 290);


SELECT * FROM USER_CONSTRAINTS;

Alter table invoice
DISABLE constraint FK_INVOICECUSTOMERID;

DELETE FROM Customer
WHERE customerid = 32;

--3.1.1

CREATE OR REPLACE FUNCTION getCurrentTimeToday

RETURN VARCHAR2 IS current_time_today varchar2(130);

BEGIN

SELECT to_char(CURRENT_TIMESTAMP,'hh:mi:ss pm') 
INTO current_time_today
FROM dual;
RETURN current_time_today;
END getCurrentTimeToday;
/
 
 select GETCURRENTTIMETODAY from dual;
 
--3.1.2

CREATE OR REPLACE FUNCTION get_Media_Type_Length(mediatype_name IN NUMBER) 
   RETURN NUMBER 
   IS media_length NUMBER;
   BEGIN 
      SELECT length(mediatype.name) 
      INTO media_length
      FROM mediatype
      WHERE mediatype.mediatypeid = mediatype_name; 
      RETURN(media_length); 
    END;
/

select get_Media_Type_Length(1) from DUAL;

--3.2.1

create or replace function retrieveAvgTotalInvoice
return number
as avgTotalInvoice Number(30);
begin
    select avg(sum(i.TOTAL)) 
    into avgTotalInvoice 
    from invoice i
    group by invoiceid;
    return avgTotalInvoice;
end;
/

select retrieveAvgTotalInvoice from dual;

--3.2.2

create or replace function expTrack
return varchar is expTrack varchar(200);
Begin
    SELECT name
    into expTrack
    from track
    where rownum <= 1
    order by unitprice desc;
    return expTrack;
End;
/

select expTrack from dual;

--3.3.1

create or replace function retrieveAvgPriceInvoiceLine
return number
as avgPriceInvoiceItem Number(30);
begin
    select avg(sum(i.unitprice)) 
    into avgPriceInvoiceItem
    from invoiceline i
    group by invoiceid;
    return avgPriceInvoiceItem;
end;
/

select retrieveAvgPriceInvoiceLine from dual;

--3.4.1

CREATE OR REPLACE FUNCTION BORNAFTER1968 RETURN SYS_REFCURSOR
IS 
EMPLOYEE_CURSOR SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_CURSOR  FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968' ;
    RETURN EMPLOYEE_CURSOR;
END;
/
SELECT BornAFTER1968 FROM DUAL;

--4.1

Set ServerOutput on

SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;

CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES(JOHN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN JOHN_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE
    EMPLOYEE_CURSOR SYS_REFCURSOR;
    FIRST_NAME VARCHAR2(30);
    LAST_NAME VARCHAR2(30);
BEGIN
    EMPLOYEE_NAMES(EMPLOYEE_CURSOR);
    LOOP
        FETCH EMPLOYEE_CURSOR INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN EMPLOYEE_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(UPPER(LAST_NAME)|| ',' || UPPER(FIRST_NAME));
    END LOOP;
END;
/

--4.2.1

CREATE OR REPLACE PROCEDURE updateDB(
	   p_employeeid IN employee.employeeid%TYPE,
	   p_firstname IN employee.firstname%TYPE)
IS
BEGIN

  UPDATE employee SET firstname = p_firstname where employeeid = p_employeeid;

  COMMIT;

END;
/

BEGIN
   updateDB(8,'b');
END;

--4.2.2

create or replace procedure getManagerEmployee(managerCursor out sys_refcursor)
as
begin
    open managerCursor for select employeeid, lastname, firstname, title from employee;
end;
/
declare
    managerCursor sys_refcursor;
    EMPLOYEEID NUMBER;
    LASTNAME VARCHAR2(50);
    FIRSTNAME VARCHAR2(50);
    TITLE VARCHAR2(50);
begin
    getManagerEmployee(managerCursor);
    fetch managerCursor into EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE;
    dbms_output.put_line(EMPLOYEEID||' '||LASTNAME||' '||FIRSTNAME||':'||TITLE);
end;
/

--4.3.1

create or replace procedure getInfo(
cid in number,
getInfoCursor out sys_refcursor)
as
begin
    open getInfoCursor for 
    select firstname, lastname, company from customer
    where customerid=cid;
end;
/
declare
    getInfoCursor sys_refcursor;
    firstname varchar2(50);
    lastname varchar2(50);
    company varchar2(50);
begin
    getInfo(3, getInfoCursor);
    fetch getInfoCursor into firstname, lastname, company;
    dbms_output.put_line(firstname||' '||lastname||', '||company);
end;

--5.1.1

CREATE OR REPLACE PROCEDURE deleteinvoice(
p_invoice in INVOICE.INVOICEID%TYPE)
AS
BEGIN
DELETE FROM INVOICE WHERE INVOICEID = p_invoice;
COMMIT;
END;
/

GRANT ALL ON INVOICE to PUBLIC;

alter table INVOICELINE DISABLE constraint FK_INVOICELINEINVOICEID;
BEGIN
deleteinvoice(120);
End;
/

--5.1.2

CREATE OR REPLACE PROCEDURE insertCustInfo(
custid in CUSTOMER.CUSTOMERID%TYPE,
firstname in CUSTOMER.FIRSTNAME%TYPE,
lastname in CUSTOMER.LASTNAME%TYPE,
mail in CUSTOMER.EMAIL%TYPE)AS
BEGIN
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME,EMAIL) 
VALUES (custid,firstname,lastname,mail);
COMMIT;
END;
/
--Must be performed prior to compilation and execution of procedure
--grant all necessay privileges
GRANT ALL ON CHINOOK.CUSTOMER to PUBLIC;

BEGIN 
insertCustInfo(1600,'Isaac','Manayath','isaac@yahoo.com');
End;
/

--6.1.1

create table employee_audit_trail(
    employeeid number,
    creationtime TIMESTAMP
);


create or replace trigger employee_audits
after insert on employee for each row
begin
    insert into employee_AUDIT_TRAIL values(:NEW.employeeid, SYSTIMESTAMP);
end;
/

insert into employee VALUES (11, 'Manayath','Isaac', 'Trainee', 1, '03-APR-92', '03-APR-93', '27 Washington Dr.', 'Watchung', 'NJ', 'US', 'T1K 333', '+1 (403) 444-4567', '+1(405) 123 4567', 'imanayath@yahoo.com');

--6.1.2

create table album_audit_trail(
    albumid number,
    creationtime TIMESTAMP
);

create or replace trigger update_album
BEFORE update on album for each row
begin
    insert into album_AUDIT_TRAIL values 
    (:new.albumid, SYSTIMESTAMP);
end;
/

UPDATE album
SET title = 'Isaac'
WHERE albumID = 1;

--6.1.3

create table customer_audit_trail(
    customerid number,
    creationtime TIMESTAMP
);

create or replace trigger DELETE_customer
BEFORE DELETE on customer for each row
begin
    insert into customer_AUDIT_TRAIL values 
    (:new.customerid, SYSTIMESTAMP);
end;
/

INSERT INTO Customer (Customerid, FIRSTNAME, LASTNAME, Company, ADDRESS, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES (72, 'Isaac', 'Manayath', 'Revature', '27 Washington Dr.', 'Watchung', 'NJ', 'US', '07069', '+1 (403) 444-4567', '+1(405) 123 4567', 'imanayath@yahoo.com',3);

DELETE FROM Customer
WHERE Customerid=72;


--7.1

select customer.firstname, invoice.invoiceid
from customer
inner join
invoice on
customer.customerid = invoice.customerid;

--7.2

select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
full outer join
invoice on
customer.customerid = invoice.customerid;

--7.3

select artist.name, album.title
from album
right join
artist on
album.ARTISTID = artist.ARTISTID;

--7,4
--only 5000 results resulted

select artist.NAME
from album
cross join
artist 
order by artist.name asc;

--7.5

SELECT a.firstname AS Employee1, b.firstname AS Employee2
FROM employee a, employee b
WHERE a.employeeID = b.REPORTSTO;

--7.6

select album.albumid, artist.artistid, customer.customerid, employee.employeeid, genre.genreid, invoice.invoiceid, invoiceline.invoicelineid, mediatype.mediatypeid, playlist.playlistid, playlisttrack.playlistid, track.trackid
from album
inner join artist
on
album.artistid = artist.artistid
inner join track on
TRACK.ALBUMID = album.artistid
inner join genre on
track.genreid = genre.genreid
inner join mediatype on
mediatype.mediatypeid = track.mediatypeid
inner join playlisttrack on
playlisttrack.trackid = track.trackid
inner join playlist on
playlist.PLAYLISTID = playlisttrack.PLAYLISTID
inner join INVOICELINE on
INVOICELINE.TRACKID = track.trackid
inner join INVOICE on
invoice.invoiceid = INVOICELINE.INVOICEID
inner join CUSTOMER on
customer.customerid = invoice.customerid
inner join employee on
employee.firstname =customer.firstname;



