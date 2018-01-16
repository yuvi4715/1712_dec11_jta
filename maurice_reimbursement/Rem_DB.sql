CREATE TABLE EMPLOYEE (
  EID int NOT NULL,
  FIRSTNAME VARCHAR2(20) NOT NULL,
  LASTNAME VARCHAR2(20) NOT NULL,
  EMAIL VARCHAR2(30) NOT NULL,
  ROLEID VARCHAR2(100) NOT NULL,
  TITLE VARCHAR2(20) NOT NULL,
  
  PRIMARY KEY (EID)   --set up within software, along with autoincrement sequence
);

CREATE TABLE CLOSED
(
  RID int NOT NULL,
  AMT NUMBER NOT NULL,
  EID NUMBER NOT NULL,   --foreign key constraint set up within SQL developer
  STATUS VARCHAR2(20) NOT NULL,
  STARTTIME DATE DEFAULT (sysdate), --application will automatically fill the dates in
  ENDTIME DATE DEFAULT (sysdate), 
  DESCRIPTION VARCHAR2(20) NOT NULL,
  RESOLVEDBY VARCHAR2(20) NOT NULL
  
  --primary key and foreign keys have been mapped through the menus
);

CREATE TABLE R_USER (
  EID  int,
  USERNAME VARCHAR2(20) NOT NULL,
  PASSWORD VARCHAR2(20) NOT NULL,
  LOGSTATUS VARCHAR2(20) NOT NULL,
  ADMIN VARCHAR2(100) NOT NULL
  
--contraints configured from the menues instead of down down here

--  --CONSTRAINT EID PRIMARY KEY,  
--  CONSTRAINT USERNAME UNIQUE,
--  CONSTRAINT EID FOREIGN KEY (EID) 
--  REFERENCES EMPLOYEE(EID)
);

--EMPLOYEE inserts

insert into EMPLOYEE (FIRSTNAME, LASTNAME, EMAIL, ROLEID, TITLE)
VALUES ('Marty', 'Robertson', 'mrobertson@cooldomain.com', 'Manager', 'Senior Accountant');

insert into EMPLOYEE (FIRSTNAME, LASTNAME, EMAIL, ROLEID, TITLE)
VALUES ('Murry', 'Albert', 'malbert@cooldomain.com', 'Manager', 'Head Chef');

insert into EMPLOYEE (FIRSTNAME, LASTNAME, EMAIL, ROLEID, TITLE)
VALUES ('Edward', 'Polic', 'PolicE@nifyemail.net', 'Employee', 'Intern');

insert into EMPLOYEE (FIRSTNAME, LASTNAME, EMAIL, ROLEID, TITLE)
VALUES ('Tito', 'Jackson', 'jackson@reeducationcamp.edu', 'Employee', 'IT support');

insert into EMPLOYEE (FIRSTNAME, LASTNAME, EMAIL, ROLEID, TITLE)
VALUES ('India', 'Arie', 'Arie@Gdomain.com', 'Employee', 'Resident Cool person');

insert into EMPLOYEE (FIRSTNAME, LASTNAME, EMAIL, ROLEID, TITLE)
VALUES ('Tony', 'Jah', 'JahMercy@martialarts.com', 'Manager', 'Campus Security');



--CLOSED INSERTS May need to enter these from within the application to allow system time to fill in the blanks
insert into CLOSED (AMT, EID, STATUS, DESCRIPTION, RESOLVEDBY)
VALUES (24, 4, 'PENDING', 'dinner', 'Head Chef');




--R_USER
insert into R_USER (EID, USERNAME, PASSWORD, LOGSTATUS, ADMIN)
VALUES (1, 'MRobertson', 'iluvcheese', ' ', 'Y');

insert into R_USER (EID, USERNAME, PASSWORD, LOGSTATUS, ADMIN)
VALUES (2, 'MAlbert', 'rockon', ' ', 'Y');

insert into R_USER (EID, USERNAME, PASSWORD, LOGSTATUS, ADMIN)
VALUES (3, 'PolicE', 'plenty', ' ', 'N');

insert into R_USER (EID, USERNAME, PASSWORD, LOGSTATUS, ADMIN)
VALUES (4, 'TJackson', 'cyborg88', ' ', 'N');

insert into R_USER (EID, USERNAME, PASSWORD, LOGSTATUS, ADMIN)
VALUES (5, 'ArieI', 'toastytoast', ' ', 'N');

insert into R_USER (EID, USERNAME, PASSWORD, LOGSTATUS, ADMIN)
VALUES (6, 'TJah', 'password', ' ', 'Y');







SELECT * FROM EMPLOYEE;
SELECT * FROM CLOSED;
SELECT * FROM R_USER;





DROP TABLE CLOSED;
DROP TABLE R_USER;
DROP TABLE EMPLOYEE;

commit;
