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