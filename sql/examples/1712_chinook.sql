select * from all_tables;

select * from invoice;

select sum(i.TOTAL), i.customerid from invoice i
group by (i.customerid)
order by i.customerid
;

create or replace function retrieveTotalCost(cid Number)
return number
as totalCost Number(30);
begin
    select sum(i.TOTAL) into totalCost from invoice i
    where i.customerid = cid
        group by (i.customerid)
        order by i.customerid;
    return totalCost;
end
;
/

select retrieveTotalCost(1) from dual;

select * from all_tables;
desc invoice;

select * from all_constraints where table_name = 'INVOICE';

SELECT COUNT(*) FROM INVOICE;
desc invoice;

select count(i.CUSTOMERID) from invoice i;
select count(distinct(i.CUSTOMERID)) from invoice i;

select * from employee;
select firstname, lastname from employee;
select sum(total) from invoice; 

--first charcter of first name and all characters from last name should be
--merged and displayed in 1 column
select upper(substr(firstname, 1,1) || lastname) as name from employee;
select concat(substr(firstname, 1,1), lastname) as name from employee;

--aggregate vs scalar function 
--math functions are aggregate functions
--aggregate is for all rows
--scalar is for each row of a column

SELECT
     c.FIRSTNAME,  sum(il.quantity), sum(il.UNITPRICE)
FROM
    invoice i
    INNER JOIN invoiceline il ON i.invoiceid = il.invoiceid
    inner join customer c on c.customerid = i.customerid 
    where i.CUSTOMERID > 10
    group by c.FIRSTNAME, il.quantity
    having sum(il.quantity) > 30
    order by c.FIRSTNAME
;

select * from invoice where invoiceid between 10 and 50;

select count(TOTAL), invoiceid from invoice 
    group by INVOICEID
    having invoiceid between 10 and 50;

select sum(i1.total), i1.invoiceid from invoice i1 
    join INVOICELINE i2 on i1.INVOICEID = i2.INVOICEID
    join CUSTOMER c on c.customerid = i1.CUSTOMERID
    where c.customerid > 10
    group by i1.invoiceid
    having i1.invoiceid between 10 and 50
    ;
    




