-- 2.1 Select
select *
from Employee;
/
select *
from Employee
where lastname = 'King';
/
select *
from Employee
where firstname = 'Andrew' and reportsto is null;
/

-- 2.2 Order By
select *
from Album
order by title desc;
/
select firstname, city
from Customer
order by city;
/

-- 2.3 Insert Into
savepoint twopointthree;
insert into Genre values (26, 'Shoegaze');
insert into Genre values (27, 'Trip Hop');
insert into Employee values (9, 'Doe', 'John', 'IT Staff', 6, TO_DATE('01/JUN/2004', 'dd/mon/yyyy'), TO_DATE('01/JUN/2005', 'dd/mon/yyyy'));
insert into Employee values (9, 'Doe', 'Jane', 'IT Staff', 6, TO_DATE('01/JAN/2004', 'dd/mon/yyyy'), TO_DATE('01/JAN/2006', 'dd/mon/yyyy'));
insert into Customer(customerid, firstname, lastname, email) values (60, 'John', 'Doe', 'JohnD@email.com');
insert into Customer(customerid, firstname, lastname, email) values (61, 'Jane', 'Doe', 'JaneD@email.com');
/

-- 2.4 Update
savepoint twopointfour;
update Customer
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';
/
update Artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';
/
-- 2.5 Like
select *
from Invoice
where billingaddress like 'T%';
/

-- 2.6 Between
select *
from Invoice
where total between 15 and 50;
/
select *
from Employee
where hiredate between TO_DATE('01/JUN/2003', 'dd/mon/yyyy')
and TO_DATE('01/MAR/2004', 'dd/mon/yyyy');
/

-- 2.7 Delete
savepoint twopointseven;
delete from invoiceline
where invoiceid in (select invoiceid from invoice
                    where customerid in (select customerid from customer
                                        where firstname = 'Robert' and lastname = 'Walter'));
delete from invoice
where customerid in (select customerid from customer
                    where firstname = 'Robert' and lastname = 'Walter');
delete Customer
where firstname = 'Robert' and lastname = 'Walter';
/

-- 3.0 Sql Functions
-- 3.1 System Defined Functions
create or replace function get_time
return timestamp as
begin
    return localtimestamp;
end;
/
create or replace function get_len(mediatype in VARCHAR2)
return number as
begin
    return LENGTH(mediatype);
end;
/

-- 3.2 System Defined Aggregate Functions
create or replace function avg_invoices
return number as
    average number;
begin
    select avg(invoice.total) into average
    from invoice;
    return average;
end;
/
create or replace function most_expensive
return varchar2 as
track_name varchar2(200);
begin
    select name into track_name
    from track
    where unitprice = (select max(unitprice)
    from track) and rownum = 1;
    return track_name;
end;
/

-- 3.3 User Defined Functions
create or replace function avg_invoiceline
return number as
average number;
begin
    select avg(unitprice) into average
    from invoiceline;
    return average;
end;
/

-- 3.4 User Defined Table Valued Functions
create or replace type t_emp as object (
eid number,
fname varchar2(20),
lname varchar2(20),
birthdate date
);
/
create or replace type t_nested_table as table of t_emp;
/
create or replace function return_table return t_nested_table as
v_ret t_nested_table;
begin
    v_ret := t_nested_table();
    for rec in (select employeeid, firstname, lastname, birthdate
                from employee
                where birthdate > to_date('1968', 'yyyy'))
    loop
        v_ret.extend;
        v_ret(v_ret.count) := t_emp(rec.employeeid, rec.firstname, rec.lastname, rec.birthdate);
    end loop;
    return v_ret;
end;
/
select * from table(return_table);
/

-- 4.0 Stored Procedures
-- 4.1 Basic Stored Procedure
create or replace procedure getEmployeeNames(prc out sys_refcursor)
as
begin
    open prc for select firstname, lastname from Employee;
end;
/

-- 4.2 Stored Procedure Input Parameters
create or replace procedure updatePI
(
    id IN Employee.employeeid%type,
    lname IN Employee.lastname%type,
    fname IN Employee.firstname%type
)
as
begin
    savepoint fourpointtwo;
    update employee e
    set e.lastname = lname, e.firstname = fname
    where employeeid = id;
end;
/
create or replace procedure findManager(id IN number, curs OUT sys_refcursor)
as
begin
    open curs for select *
    from Employee
    where employeeid = (select reportsto
                        from employee
                        where employeeid = id);
end;
/

-- 4.3 Stored Procedure Output Parameters
create or replace procedure getCompany(id IN number, curs OUT sys_refcursor)
as
begin
    open curs for 
    select firstname, lastname, company
    from customer
    where customerid = id;
end;
/

-- 5.0 Transactions
create or replace procedure deleteInvoice(id IN invoice.invoiceid%type)
as
begin
    savepoint fivepointzero;
    delete from invoiceline where invoiceid in (select invoiceid from invoice
                                                where invoiceid = id);
    delete invoice
    where invoiceid = id;
end;
/
create or replace procedure createCustomer
(
    fname IN  customer.firstname%type,
    lname IN customer.lastname%type,
    mail IN customer.email%type
)
as 
maxID customer.customerid%type;
begin
    savepoint fivepointzerotwo;
    select max(customerid) into maxID from customer;
    insert into customer (customerid, firstname, lastname, email) values(maxID+1, fname, lname, mail);
end;
/

-- 6.0 Triggers
-- 6.1 After/For
create or replace trigger afterEmployeeInsertTrigger
after insert on employee for each row
begin
    dbms_output.PUT_LINE('employee inserted');
end;
/
create or replace trigger afterAlbumUpdateTrigger
after update on album for each row
begin
    dbms_output.PUT_LINE('album updated');
end;
/
create or replace trigger afterCustomerDeleteTrigger
after delete on customer for each row
begin
    dbms_output.PUT_LINE('customer deleted');
end;
/

-- 7.0 Joins
-- 7.1 Inner
select c.firstname, c.lastname, i.invoiceid
from customer c inner join invoice i on c.customerid = i.customerid;
/

-- 7.2 Outer
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c full outer join invoice i on c.customerid = i.customerid;
/

-- 7.3 Right
select artist.name, album.title
from album right outer join artist on album.artistid = artist.artistid;
/

-- 7.4 Cross
select *
from album cross join artist
order by artist.name asc;
/

-- 7.5 Self
select e1.firstname employee, e2.firstname manager
from employee e1 full outer join employee e2 on e1.reportsto = e2.employeeid;
/

-- 7.6 Complicated Join Assignment
select *
from album inner join artist on album.artistid = artist.artistid
inner join track on album.albumid = track.albumid
inner join genre on genre.genreid = track.genreid
inner join playlisttrack on playlisttrack.trackid = track.trackid
inner join playlist on playlist.playlistid = playlisttrack.playlistid
inner join mediatype on mediatype.mediatypeid = track.mediatypeid
inner join invoiceline on invoiceline.trackid = track.trackid
inner join invoice on invoice.invoiceid = invoiceline.invoiceid
inner join customer on customer.customerid = invoice.customerid
inner join employee on employee.employeeid = customer.supportrepid;
/
commit;
/
-- 9.0 Administration