select * from all_tables;
select * from customer;
select * from invoice;
select * from invoiceline;

select * from artist;
select * from album;
select * from genre;
select * from track;
select * from mediatype;

--2.0
--2.1
select * from employee;
select * from EMPLOYEE where LASTNAME='King';
select * from EMPLOYEE where FIRSTNAME='Andrew' and REPORTSTO is null;

--2.2
select * from album order by title desc;
select firstname from customer order by city asc;

--2.3
insert into genre (genreid, name) values (26, 'Electropop');
insert into genre (genreid, name) values (27, 'Piano');
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (9, 'Smith', 'John', 'IT Staff', 6, '06-JUN-93', '12-DEC-17', '924 8 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 458-1234', '+1 (403) 458-4321', 'john@chinookcorp.com');
insert into employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
values (10, 'Doe', 'Alice', 'Sales Support Agent', 2, '25-AUG-94', '07-JUL-15', '688 15 Street SW', 'Calgary', 'AB', 'Canada', 'T2P 5G3', '+1 (403) 123-4567', '+1 (403) 987-6543', 'alice@chinookcorp.com');
select * from customer;
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values (60, 'Char', 'Aznable', 'NaMaiTech', '123 Moon Rd, 107', 'Chicago', 'IL', 'USA', 60185, '+1 (916) 364-2574', null, 'caznable@gmail.com', 3);
insert into customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
values (61, 'Sayla', 'Mass', 'Anaheim Electronics', '123 Moon Rd, 107', 'Anaheim', 'CA', 'USA', 92801, '+1 (916) 123-4567', null, 'saymass@gmail.com', 4);

--2.4 update
update customer set firstname='Robert', lastname='Walter'
where firstname='Aaron' and lastname='Mitchell';
update artist set name='CCR'
where NAME='Creedence Clearwater Revival';

--2.5 like
select * from invoice where billingaddress like 'T%';

--2.6 between
select * from invoice where total between 15 and 50;
select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

--2.7   Robert Walter customerid=32
select customerid from customer where firstname='Robert' and lastname='Walter';
delete from invoiceline where invoiceid in (
    select invoiceid from invoice where customerid=32);
delete from invoice where customerid=(
    select customerid from customer where firstname='Robert' and lastname='Walter');
delete from customer where firstname='Robert' and lastname='Walter';

--3.0 fn's
--3.1 system-defined fn's
create or replace function gettime
return timestamp with time zone 
as vartime timestamp with time zone ;
begin
    select systimestamp into vartime from dual;
    return vartime;
end;
/

select gettime() from dual;

select * from mediatype;
create or replace function getmediatypelength(mediaid Number)
return Number as 
medialength Number;
medianame varchar(50);
begin
    select name into medianame
    from mediatype m 
    where m.mediatypeid=mediaid;
    return length(medianame);
end;
/
select getmediatypelength(2) from dual;

--3.2 sys-defined aggregate fn's
create or replace function getaverageinvoice
return Number as average Number;
begin
    select avg(total) into average from invoice;
    return average;
end;
/
select getaverageinvoice from dual;

select max(unitprice) from track;
create or replace function getmaxtrack
return Number as maxtrack Number;
begin
    select max(unitprice) into maxtrack from track; 
    return maxtrack;
end;
/
select * from track where unitprice=getmaxtrack;

--3.3 userdefined fn
create or replace function getaverageinvoiceline
return Number as avgprice Number;
begin
    select avg(unitprice) into avgprice from invoiceline;
    return avgprice;
end;
/
select getaverageinvoiceline from dual;

--3.4 table valued fn's
--https://stackoverflow.com/questions/22988049/oracle-table-valued-function
--https://stackoverflow.com/questions/2059299/table-valued-functions-in-oracle-11g-parameterized-views
--select * from employee where birthdate>'30-DEC-68';
--Select COLUMN_NAME, DATA_TYPE, NULLABLE from all_tab_columns where table_name='EMPLOYEE';
/* test employee table
CREATE TABLE EmployeeTable(
    EMPLOYEEID NUMBER NOT NULL, PRIMARY KEY (EMPLOYEEID),
    LASTNAME VARCHAR2(50) NOT NULL,
    FIRSTNAME VARCHAR2(50) NOT NULL,
    TITLE VARCHAR2(50) NULL,
    REPORTSTO NUMBER NULL,
    BIRTHDATE DATE NULL,
    HIREDATE DATE NULL,
    ADDRESS VARCHAR2(50) NULL,
    CITY VARCHAR(50) NULL,
    STATE VARCHAR2(50) NULL,
    COUNTRY VARCHAR2(250) NULL,
    POSTALCODE VARCHAR2(50) NULL,
    PHONE VARCHAR2(50) NULL,
    FAX VARCHAR2(50) NULL,
    EMAIL VARCHAR2(50) NULL);
/
*/
create type employeeType is object (
    EMPLOYEEID NUMBER,
    LASTNAME VARCHAR2(50),
    FIRSTNAME VARCHAR2(50),
    TITLE VARCHAR2(50),
    REPORTSTO NUMBER,
    BIRTHDATE DATE,
    HIREDATE DATE,
    ADDRESS VARCHAR2(50),
    CITY VARCHAR(50),
    STATE VARCHAR2(50),
    COUNTRY VARCHAR2(250),
    POSTALCODE VARCHAR2(50),
    PHONE VARCHAR2(50),
    FAX VARCHAR2(50),
    EMAIL VARCHAR2(50));
/
create type EmployeeTypeCollection is table of employeeType;
/
create or replace function getyoungemployees
return EmployeeTypeCollection pipelined is 
begin
    for i in (select * from employee where birthdate>'30-DEC-68') loop
        pipe row(employeeType(
            i.EMPLOYEEID,
            i.LASTNAME,
            i.FIRSTNAME,
            i.TITLE,
            i.REPORTSTO,
            i.BIRTHDATE,
            i.HIREDATE,
            i.ADDRESS,
            i.CITY,
            i.STATE,
            i.COUNTRY,
            i.POSTALCODE,
            i.PHONE,
            i.FAX,
            i.EMAIL));
    end loop;   
    return;
end;
/

select * from table(getyoungemployees);

--4.0 Stored procedures
--4.1
SET SERVEROUTPUT ON;
/
/*
DECLARE
    (TYPE employees_collection IS TABLE OF employee%ROWTYPE;
    employee_names employees_collection);
BEGIN
    SELECT *
    BULK COLLECT INTO employee_names
    FROM employee;

    FOR i IN 1 .. employee_names.COUNT LOOP
        DBMS_OUTPUT.put_line (employee_names(i).lastname||' '||employee_names(i).firstname);
    END LOOP;
END;
/
*/
create or replace procedure get_employee_names
(employee_cursor out sys_refcursor) 
as
begin
    open employee_cursor for select lastname, firstname from employee;
end;
/
declare
    employee_cursor sys_refcursor;  --cursor pass by ref
    lastname varchar2(30);
    firstname varchar2(30);
BEGIN
    get_employee_names(employee_cursor);
    loop
        fetch employee_cursor into lastname, firstname;
        exit when employee_cursor%NOTFOUND;
        dbms_output.put_line(lastname||' '||firstname);
    end loop;
end;
/

--4.2
create or replace procedure update_employee
    (ID in NUMBER,
    LNAME in VARCHAR2,
    FNAME in VARCHAR2,
    TTL in VARCHAR2,
    REPORTS_TO in NUMBER,
    BIRTH_DATE in DATE,
    HIRE_DATE in DATE,
    ADDR in VARCHAR2,
    CTY in VARCHAR,
    ST in VARCHAR2,
    CTRY in VARCHAR2,
    POSTAL_CODE in VARCHAR2,
    PHONE_NUM in VARCHAR2,
    FAX_NUM in VARCHAR2,
    EMAIL_ADDR in VARCHAR2)
as
begin
    update employee
    set employeeid = ID,
        lastname = LNAME,
        firstname = FNAME,
        title = ttl,
        reportsto = reports_to,
        birthdate = birth_date,
        hiredate = hire_date,
        address = addr,
        city = cty,
        state = st,
        postalcode = postal_code,
        phone = phone_num,
        fax = fax_num,
        email = email_addr
    where employeeid = ID;
end;
/
declare
begin
    update_employee(1, 'Adams', 'Andrew', 'General Manager', null, '18-FEB-62', 
    '14-AUG-02', '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', 
    '+1 (780) 428-9482', '+1 (780) 428-9482', 'andrew@chinookcorp.com');
end;
/

/*
select * from employee 
where employeeid=(
    select reportsto from employee 
    where (employeeid=2 and lastname='Edwards' and firstname='Nancy')
);
*/
create or replace procedure get_boss(boss_cursor out sys_refcursor)
as
begin
    open boss_cursor for select employeeid, lastname, firstname, title from employee;
end;
/
declare
    boss_cursor sys_refcursor;
    EMPLOYEEID NUMBER;
    LASTNAME VARCHAR2(50);
    FIRSTNAME VARCHAR2(50);
    TITLE VARCHAR2(50);
begin
    get_boss(boss_cursor);
    fetch boss_cursor into EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE;
    dbms_output.put_line(EMPLOYEEID||' '||LASTNAME||' '||FIRSTNAME||':'||TITLE);
end;
/

select * from customer;
--4.3
create or replace procedure get_name_company(
cid in number,
nc_cursor out sys_refcursor)
as
begin
    open nc_cursor for 
    select firstname, lastname, company from customer
    where customerid=cid;
end;
/
declare
    nc_cursor sys_refcursor;
    firstname varchar2(50);
    lastname varchar2(50);
    company varchar2(50);
begin
    get_name_company(1, nc_cursor);
    fetch nc_cursor into firstname, lastname, company;
    dbms_output.put_line(firstname||' '||lastname||', '||company);
end;
/

--5.0 transactions
create or replace procedure delete_invoice(iid in number)
as
begin
    delete from invoiceline where invoiceid=iid;
    delete from invoice where invoiceid=iid;
    commit;
end;
/
exec delete_invoice(2);

create or replace procedure insert_customer
    (customerid in number,
    firstname in varchar2,
    lastname in varchar2,
    company in varchar2, 
    address in varchar2, 
    city in varchar2, 
    state in varchar2, 
    country in varchar2, 
    postalcode in varchar2, 
    phone in varchar2, 
    fax in varchar2, 
    email in varchar2, 
    supportrepid in number)
as
begin
    insert into customer
    values (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid);
    commit;
end;
/
exec insert_customer(60, 'Char', 'Aznable', 'NaMaiTech', '123 Moon Rd, 107', 'Chicago', 'IL', 'USA', 60185,'+1 (916) 364-2574', null, 'caznable@gmail.com', 3);

--6.0 triggers
--6.1 after/for
create table trigger_table (
    name varchar(100),
    createduser varchar(25)
);
/

create or replace trigger insert_employee_trigger
after insert on employee for each row
begin
    insert into trigger_table values 
    (:new.firstname||' '||:new.lastname, user );
end;
/

create or replace trigger insert_album_trigger
after update on album for each row
begin
    insert into trigger_table values 
    (:new.title, user );
end;
/

create or replace trigger insert_customer_trigger
after delete on customer for each row
begin
    insert into trigger_table values 
    (:old.firstname||' '||:old.lastname, user );
end;
/
/*
drop trigger insert_customer_trigger;
delete from customer where customerid=60;
select * from trigger_table;
*/

--7.0 joins
--7.1 inner join
select c.firstname, c.lastname, i.invoiceid
from customer c inner join invoice i
on c.customerid = i.customerid;

--7.2 outer join
select c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
from customer c full outer join invoice i
on c.customerid = i.customerid;

--7.3 right join
select album.title, artist.name
from album right join artist
on artist.artistid = album.artistid;

--7.4
select *
from album cross join artist
order by artist.name asc;

--7.5
select a.employeeid as "bossid", a.lastname as "bosslname", a.firstname as "bossfname", a.title as "bosstitle",
b.employeeid, b.lastname, b.firstname, b.title
from employee a, employee b
where a.employeeid = b.reportsto;

--7.6 getting a customer and displaying all his invoices(all track information) and support rep
select  c.firstname||' '||c.lastname as "Customer Name",    --customer
        e.firstname||' '||e.lastname as "Support Name",     --employee
        i.invoiceid, i.invoicedate, i.total,                --invoice
        t.name as "Track", alb.title as "Album", art.name as "Artist", 
        g.name as "Genre", m.name as "MEDIATYPE"    --music stuffs
from customer c join employee e 
on c.supportrepid = e.employeeid 
join invoice i 
on c.customerid = i.customerid
join invoiceline il
on i.invoiceid = il.invoiceid
join track t
on t.trackid=il.trackid
join album alb
on t.albumid=alb.albumid
join artist art
on alb.artistid=art.artistid
join genre g
on t.genreid=g.genreid
join mediatype m
on t.mediatypeid=m.mediatypeid;
