--1. Execute Chinook

set serveroutput on;
--2.1  Select
SELECT * FROM Employee;
SELECT * FROM Employee WHERE Employee.lastname = 'King';
SELECT * FROM Employee WHERE Employee.firstname = 'Andrew' AND Employee.REPORTSTO IS null;

--2.2 Order by
SELECT * FROM Album ORDER BY Title DESC;
SELECT firstname FROM Customer ORDER BY city ASC;

--2.3 Insert into
INSERT INTO Genre (GenreId,Name) VALUES (26,'GAMES');
INSERT INTO Genre (GenreId,Name) VALUES (27,'INDIE');

INSERT INTO Employee (employeeid,lastname,firstname,title,reportsto,
                        birthdate,hiredate,
                        address,city,state,country,postalcode,
                        phone,fax,email)
    VALUES (9,'Su','Clayton', 'IT Intern',6,
                        '12-DEC-93','1-JAN-2018',
                        '123 Alpha St','Clayton Town','CA','United States','10101',
                        '+1 (123) 123-1234','+1 (123) 123-1234','clayton@gmail.com');

INSERT INTO Employee (employeeid,lastname,firstname,title,reportsto,
                        birthdate,hiredate,
                        address,city,state,country,postalcode,
                        phone,fax,email)
    VALUES (10,'Su2','Clayton2', 'IT Intern',6,
                        '12-DEC-94','1-JAN-2018',
                        '123 Alpha St','ClaytonTown','CA','UnitedStates','10101',
                        '+1 (223) 123-1234','+1 (223) 123-1234','clayton2@gmail.com');
                        
INSERT INTO Customer VALUES(60, 'Clayton','Su','Clay LLC',
        '123 Clayton St','Clayton Town','CA','United States', '10101',
        '+1 (123) 123-1234','+1 (123) 123-1234','clayton@gmail.com',
        3);

INSERT INTO Customer VALUES(61, 'Clayton2','Su','Clay2 LLC',
        '2123 Clayton St','2Clayton Town','2CA','2United States', '210101',
        '2+1 (123) 123-1234','2+1 (123) 123-1234','2clayton@gmail.com',
        3);

--2.4 Update
UPDATE Customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
UPDATE Artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

--2.5 like
select * from INVOICE where BILLINGADDRESS like 'T%';

--2.6 between
select * from INVOICE where TOTAL BETWEEN 15 AND 50;
select * from EMPLOYEE where hiredate BETWEEN '1-JUN-03' AND '1-MAR-04';

--2.7 delete
--doesn't work if you didn't do 2.4
delete from customer where firstname = 'Robert' and lastname = 'Walter';

--3.0 SQL functions
--3.1 system defined functions
create or replace function getSysdate
return date is

  l_sysdate date;

begin

  select CURRENT_TIMESTAMP
    into l_sysdate
    from dual;

  return l_sysdate;

end;
/
select getSysdate() from dual;

create or replace function getLength(fat number)
return number is 
    len number;
begin
    select length(mediatype.name) as mediaName 
        into len from mediatype where mediatype.mediatypeid = fat;
    
    return len;
end;
/
select getLength(1) from dual;

--3.2 system defined aggregate functions
create or replace function getAvg
return number is 
    average number;
begin
    select avg(invoice.total) into average from invoice;
    
    
    return average;
end;
/
select getAvg() from dual;

create or replace function getExpensive
return number is 
    expensive number;
begin
    select max(track.unitprice) into expensive from track;
    
    return expensive;
end;
/
select getExpensive() from dual;

--3.3 User defined functions
create or replace function getAvgInvoiceLine
return number is 
    average number;
begin
    select sum(invoice.total) / count(invoice.total) into average from invoice;
    
    
    return average;
end;
/
select getAvgInvoiceLine() from dual;

--3.4 user defined table valued functions
CREATE OR REPLACE FUNCTION AFTER1968 RETURN SYS_REFCURSOR
IS 
EMPLOYEE_CURSOR SYS_REFCURSOR;
BEGIN
    OPEN EMPLOYEE_CURSOR  FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-1968' ;
    RETURN EMPLOYEE_CURSOR;
END;
/
SELECT AFTER1968 FROM DUAL;

--4.0 stored procedures
--4.1 basic stored procedure
create or replace procedure getEmployees (employeeNames out sys_refcursor)
as
begin
    open employeeNames for 
    select firstname, lastname from employee;
end;
/


--4.2 stored procedure input parameters
create or replace procedure updateEmployeeInfo(

emp_id in number,
last_n in varchar2,
first_n in varchar2,
addr in varchar2,
city_n in varchar2,
--state_n in varchar2,
country_n in varchar2,
postal in varchar2

)
is
begin
    update employee e
    set 
    lastname=last_n,
    firstname=first_n,
    address=addr,
    city=city_n,
    --e.state = state_n,
    country= country_n,
    postalcode = postal
    
    where e.employeeid = emp_id
    ;
end
;
/
exec updateEmployeeInfo(8,'Su','Clayton','123 Clayton St','Clayton Town', 'USA', '91763');

--TODO 4.2.2

--4.3 Stored procedure output parameter
create or replace procedure nameOfCustomer(

cust_id in number,
first_n out varchar2,
last_n out varchar2,
cmpny out varchar2
)
is
begin
    select c.firstname, c.lastname, c.company 
    into first_n, last_n, cmpny 
    from customer c
    where cust_id = c.customerid
    ;
end;
/

set serveroutput on;
declare
    first_name1 varchar2(80);
    last_name1 varchar2(80);
    c_name varchar2(80);
begin
    nameOfCustomer(1,first_name1,last_name1,c_name);
    dbms_output.put_line(first_name1);
    dbms_output.put_line(last_name1);
    dbms_output.put_line(c_name);
end;

--5.0 transactions
create or replace procedure deleteInvoice(invoi number)
as
begin
    delete from invoiceline where invoiceid = invoi;
    delete from invoice where invoiceid = invoi;
    --commit; 
    --commit to actually complete the transaction, i don't
        --want to complete the transaction for purposes of training
end;
/

exec deleteInvoice(69);

create or replace procedure insertCustomer(

cust_id in number,
f_name in varchar2,
l_name in varchar2,
cmpny in varchar2,
addr in varchar2,
cty in varchar2,
state_name in varchar2,
cntry in varchar2,
postal_c in varchar2,
phone_num in varchar2,
fax_num in varchar2,
email_addr in varchar2,
supportID in number

)
as 
begin

    insert into customer 
    values(
    cust_id, f_name, l_name, cmpny,
    addr, cty, state_name, cntry, postal_c,
    phone_num, fax_num, email_addr,
    supportID
    );
    --commit
    --no commit so I don't change the table for purposes of training
END
;
/
exec insertCustomer(1000,'Clayton','Su','Clayton LLC','123 Clayton St', 'Clayton Town', 'CA', 'USA','91763','123-123-1234', '123-123-1234', 'clayton@gmail.com',3);

--6.0 triggers
--create a trigger that fires after an insert on employee

create or replace trigger insertOnEmployee
after insert on EMPLOYEE
begin
    DBMS_OUTPUT.PUT_LINE('Record inserted into employee table');  
    update employee set firstname = 'CHANGED HERE' where employeeid = 1;
end;
/
insert into employee(employeeid,firstname,lastname) values(1112,'Jack2','ZeRipper2');


create or replace trigger updateOnAlbum
after update on Album
begin
    
    DBMS_OUTPUT.PUT_LINE('UPDATE COMPLETE');
end;
/

set serveroutput on;
update album set title='HelloWorld' WHERE title='Balls to the Wall'; 
--album id = 5
begin 
    DBMS_OUTPUT.PUT_LINE('');
    --i need this to get output from the trigger for some reason.
end;
/

create or replace trigger afterDeleteCustomer
after delete on Customer
begin
    DBMS_OUTPUT.PUT_LINE('DELETE COMPLETE');
end;
/

delete from Customer where customerid = 1000;

begin
    DBMS_OUTPUT.PUT_LINE('DELETE COMPLETE2');
end;

--7.0 joins
--7.1 inner
Select customer.firstname,customer.lastname, invoice.invoiceid 
from customer
inner join invoice
on customer.customerid = invoice.customerid;

--7.2 outer
select c.customerid,c.firstname,c.lastname,i.invoiceid,i.total
from customer c
left join invoice i
on c.customerid = i.customerid;

--7.3 right join
select t.name,a.TITLE
from album a
right join artist t
on a.artistid = t.artistid;
--some of the artists don't have albums in the album database, such as ben harper
--right (or left) join is needed to keep artist names that do not have an album in 
    --the database

--7.4 cross join
select t.name, a.title
from album a
cross join artist t
order by t.name ASC;

--7.5 self join
select a.lastname,b.lastname as ReportsTo
from employee a
join employee b
on a.reportsto = b.employeeid; 

--7.6 complicated join
select *
from invoice i
inner join invoiceline iv on i.invoiceid = iv.invoiceid
inner join customer c on i.customerid = c.customerid
inner join employee e on c.supportrepid = e.employeeid

inner join track t on t.trackid = iv.TRACKID
inner join genre g on t.genreid = g.genreid
inner join mediatype m on t.mediatypeid = m.mediatypeid
inner join playlisttrack plt on plt.trackid = t.trackid
inner join playlist p on plt.playlistid = p.playlistid

inner join album a on t.albumid = a.albumid
inner join artist art on art.artistid = a.artistid
;

--9.0 administration
--tools -> export database