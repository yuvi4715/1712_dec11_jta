--stored procedures
select count(*) from invoice;
select count(*) from invoiceline;

savepoint save_12222017_1118;
--sub query
delete from (select * from INVOICELINE where INVOICEID >= 412);

rollback;
delete from invoice where INVOICEID >= 412;
commit;

create or replace procedure printMessage(actualMessage Varchar2)
as
begin
    DBMS_OUTPUT.PUT_LINE(actualMessage);
end;
/

exec PRINTMESSAGE('hello world');
exec PRINTMESSAGE('another message');

begin
    PRINTMESSAGE('another approach to call stored procedures');
end;
/

create or replace procedure deleteInvoice(invoicenumber Number)
as
begin
    delete from (select * from INVOICELINE where INVOICEID >= invoicenumber);
    delete from invoice where INVOICEID >= invoicenumber;
    commit;
end;
/

--approach 1
exec deleteInvoice(412);

rollback;
--approach 2
begin
    deleteInvoice(410);
end;
/

desc employee;
select * from employee;
select firstname, lastname from employee;
select concat(upper(substr(firstname, 1,3)), lastname) from employee;

create or replace procedure getNames(YuviCursor OUT SYS_Refcursor)
as
begin
    open YuviCursor for select concat(upper(substr(firstname, 1,3)), lastname) 
    from employee;
end
;
/

declare
    anotherCursorVariable Sys_Refcursor;
    FullName varchar2(25);
begin
    getNames(anotherCursorVariable);
    Loop
        Fetch anotherCursorVariable into FullName;
        exit when anotherCursorVariable%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE('Employe full name is ' || FullName );
    End Loop;
end;
/

create sequence seq1
    minvalue 1
    maxvalue 100
    start with 1
    increment by 1;

select seq1.currval, SEQ1.NEXTVAL, seq1.currval, SEQ1.NEXTVAL from dual;

begin
    DBMS_OUTPUT.PUT_LINE(seq1.currval);
    DBMS_OUTPUT.PUT_LINE(seq1.nextval);
    DBMS_OUTPUT.PUT_LINE(seq1.currval);
end;
/

select seq1.currval from dual;
select SEQ1.NEXTVAL from dual;



