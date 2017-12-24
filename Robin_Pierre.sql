--Select
select * from EMPLOYEE; --2.1.2

select * from EMPLOYEE 
where employee.lastname = 'King'; --2.1.2

select * from EMPLOYEE --2.2.2
where employee.firstname = 'Andrew' and
employee.reportsto is null;

--Order by 
select * from ALBUM --2.2.1
order by ALBUM.title desc;

select firstname from customer
order by CUSTOMER.firstname asc; --2.2.2

--Insert into 
desc genre;
select * from genre;
insert into genre values (26, 'Alternate Classic');
insert into genre values (27, 'Real Jazz'); --2.3.1

insert into employee (employeeid, FIRSTNAME, lastname)
values (100, 'Robin', 'Pierre');
insert into employee (employeeid, FIRSTNAME, lastname)
values (101, 'William', 'Gentry'); --2.3.2
rollback;
select * from employee where employeeid = 100;
delete from employee where employeeid = 100;
desc customer;
insert into customer (customerid, firstname, lastname, email)
values (90, 'Robin', 'Pierre', 'robin.pierre16@outlook.com');
insert into customer (customerid, firstname, lastname, email)
values (91, 'William', 'Gentry', 'William.Gentry16@outlook.com');--2.3.3

--Update
Update customer 
set firstname = 'Robert',
    lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';--2.4.1

Update ARTIST
set NAME = 'CCR'
where NAME = 'Creedence Clearwater Revival';--2.4.2

--Like
select * from INVOICE
where BILLINGADDRESS like 'T%';--2.5.1

--Between
select * from invoice --2.6.1
where total between 15 and 50;

desc employee;
select * from employee --2.6.1 
where hiredate between '01-JUN-03' and '01-MAR-04';

--Delete
delete from (select * from customer
inner join invoice on invoice.customerid = customer.customerid
inner join invoiceline on invoiceline.invoiceid = invoice.invoiceid)
where firstname = 'Robert' and lastname = 'Walter';

delete from (select * from customer
inner join invoice on invoice.customerid = customer.customerid)
where firstname = 'Robert' and lastname = 'Walter';

delete from customer where firstname = 'Robert' and lastname = 'Walter';--2.7.1

--System Defined Functions
create or replace function get_time --3.1.1
return timestamp as thetime timestamp;
begin
    thetime := current_timestamp;
    return thetime;
end;
/

create or replace function get_mediatype_length(id Number)--3.1.2
return Number as mediatype_length Number;
tempVar varchar(50);
begin
    SELECT NAME into tempVar 
    FROM mediatype 
    where mediatypeid = id;
    mediatype_length :=  length(tempVar);
    return mediatype_length;
end;
/

--System Defined Aggregate Functions
create or replace function get_invoice_average--3.2.1
return Number as inv_avg Number;
begin
    select avg(total) into inv_avg
    from INVOICE;
    return inv_avg;
end;
/

create or replace function get_most_expensive_track--3.2.2
return Number as highest_cost Number;
begin
    select max(unitprice) into highest_cost
    from track;
    return highest_cost;
end;
/

create or replace function get_average_invoiceline--3.3.1
return Number as total_invoiceline Number;
total_records Number;
begin
    select count(*) into total_records
    from INVOICELINE;
    select sum(UNITPRICE) into total_invoiceline
    from  invoiceline;
    return total_invoiceline / total_records;
end;
/


create or replace function get_employees_after_1968 --3.4
return sys_refcursor
as bd_cursor sys_refcursor;
begin
    open bd_cursor for 
    select firstname, lastname from employee where BIRTHDATE > '31-DEC-68';
    
    return bd_cursor;
end;
/

--Basic Stored Procedure
create or replace procedure get_employee_names(emp_names out sys_refcursor) --4.1 incomplete
as
begin
    open emp_names for select Concat(firstname, ' ') || lastname from employee;
end;
/
declare
    the_names sys_refcursor;
    first_and_last varchar2(30);
begin
    get_employee_names(the_names);
    loop
    fetch the_names into first_and_last;
    exit when the_names%notfound;
    DBMS_OUTPUT.PUt_line(first_and_last);
    end loop;
end;
/

--Stored Procedure Input Parameters
create or replace procedure update_employee_email(emp_firstname varchar2,
                            emp_lastname varchar2,
                            update_value varchar2) --4.2.1 
as
begin
    update employee
    set email = update_value
    where firstname = emp_firstname and lastname = emp_lastname;
end;
/
--exec update_employee_email('Andrew', 'Adams', 'testemail@provider.com');
--select firstname, lastname, email from employee where employeeid = 1;

create or replace procedure get_manager(emp_id Number, mgr_name out sys_refcursor) --4.2.2
is
begin
    open mgr_name for select Concat(firstname, ' ') || lastname from employee where employeeid = 
    (select reportsto from employee where employeeid = emp_id);
end;
/

create or replace procedure get_customer_info(cus_id Number, cus_name out sys_refcursor) --4.3
is
begin
    open cus_name for select concat(Concat(firstname, ' ') || lastname, ' ') || COMPANY from CUSTOMER where customerid = cus_id; 
end;
/
savepoint delete_invoice_savepoint;
delete from (select * from invoice
    inner join invoiceline
    on invoice.invoiceid = invoiceline.invoiceid
    where invoice.invoiceid = 404);
    delete from invoice where invoiceid = 404;
    select * from INVOICE where invoiceid = 404;
    select * from INVOICELINE where invoiceid = 404;
--Transactions
create or replace procedure delete_invoice(inv_id Number)--5.0.1
is
begin
    savepoint delete_invoice_savepoint;
    delete from (select * from invoice
    inner join invoiceline
    on invoice.invoiceid = invoiceline.invoiceid
    where invoice.invoiceid = inv_id);
    delete from invoice where invoiceid = inv_id;
    commit;
    exception
    when others then
    rollback to delete_invoice_savepoint;
end;
/

create or replace procedure insert_customer_record(
cust_id Number,
_first varchar2,
_last varchar2,
_company varchar2,
_address varchar2,
_city varchar2,
_state varchar2,
_country varchar2,
_postalcode varchar2,
_phone varchar2,
_fax varchar2,
_email varchar2,
_supportrepid number)--5.0.2
as
begin
    savepoint insert_customer_savepoint;
    insert into customer values(
cust_id, _first, _last, _company, _address, _city, _state, _country,
_postalcode, _phone, _fax, _email, _supportrepid);
    commit;
    exception when others then
    rollback to insert_customer_saveoint;
end;
/

--Triggers
create or replace trigger trigger_after_insert_employee--6.1.1
after insert on employee for each row
begin
    DBMS_OUTPUT.PUT_LINE('A new employee has been added to the employee table.');
end;
/

create or replace trigger trigger_after_delete_album--6.1.2
after delete on album for each row
begin
    DBMS_OUTPUT.PUT_LINE('An album has been deleted from the album table.');
end;
/

-- Joins

select customer.firstname, customer.lastname, invoice.invoiceid from customer
inner join invoice
on customer.customerid = invoice.customerid; --7.1

select customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer left outer join invoice
on customer.customerid = invoice.customerid; --7.2

select artist.name, album.title
from album right outer join artist
on album.artistid = artist.artistid; --7.3

select customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer cross join invoice; --7.4

select emp.employeeid, emp.firstname, emp.lastname, emp.reportsto, mgr.firstname, mgr.lastname
from employee emp, employee mgr
where emp.reportsto = mgr.employeeid
order by employeeid;--7.5


select customer.firstname, customer.lastname, invoice.total, track.name as track,
artist.name as artist, album.title, genre.name as genre, invoiceline.unitprice, invoiceline.quantity,
employee.firstname as emp_firstname, employee.lastname as emp_lastname
from customer
inner join employee on customer.supportrepid = employee.EMPLOYEEID
inner join invoice on customer.customerid = invoice.customerid
inner join INVOICELINE on invoiceline.invoiceid = invoice.invoiceid
inner join track on invoiceline.trackid = track.trackid
inner join album on track.albumid = album.ALBUMID
inner join genre on track.genreid = genre.genreid
inner join mediatype on track.mediatypeid = mediatype.mediatypeid
inner join artist on album.artistid = artist.ARTISTID
order by customer.firstname;--7.6

