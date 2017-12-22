create user testuser IDENTIFIED by p4ssw0rd;
grant connect, resource to testuser;

drop user testuser;
commit;

create user jta1712 IDENTIFIED by jta1712;
grant connect, resource to jta1712;
GRANT new_DBA TO jta1712 WITH ADMIN OPTION;
--drop user jta1712;
commit;


