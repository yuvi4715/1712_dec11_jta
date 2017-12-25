-- SQL QUERIES
SELECT * from EMPLOYEE;
SELECT * from EMPLOYEE where LastName = 'King';
SELECT * from EMPLOYEE where FirstName = 'Andrew' and REPORTSTO = null;

SELECT * from ALBUM order by TITLE DESC;
SELECT * from CUSTOMER order by CITY;

INSERT INTO GENRE VALUES ('26', 'Touhou');
INSERT INTO GENRE VALUES ('27', 'Kajiura');

INSERT INTO EMPLOYEE VALUES (9, 'Miki', 'Sayaka', 'Blue Magical Girl', '9', '17-DEC-97', '17-DEC-11', 
    '1337 Mitakihara St', 'Mitakihara', 'Tokyo', 'Japan', 'L1O L1I', '+1 (123) 456-7890', '1+ (123) 456-7890', 'sayaka@gmail.com');
INSERT INTO EMPLOYEE VALUES (10, 'Tomoe', 'Mami', 'Yellow Magical Girl', '1', '07-DEC-97', '17-DEC-11', 
    '1337 Mitakihara St', 'Mitakihara', 'Tokyo', 'Japan', 'L1O L1I', '+1 (123) 222-3333', '1+ (123) 222-3333', 'mami@gmail.com');

INSERT INTO CUSTOMER VALUES (60, 'Madoka', 'Kaname', 'Magica Quartet', 
    '1337 Mitakihara St', 'Mitakihara', 'Tokyo', 'Japan', 'L1O L1I', '+1 (111) 222-3333', '+1 (111) 222-3333', 'madoka@gmail.com', 1);
    INSERT INTO CUSTOMER VALUES (61, 'Kyouko', 'Sakura', 'Magica Quartet', 
    '1337 Mitakihara St', 'Mitakihara', 'Tokyo', 'Japan', 'L1O L1I', '+1 (123) 999-0000', '+1 (123) 999-0000', 'kyouko@gmail.com', 1);
    
UPDATE CUSTOMER SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' and LastName = 'Mitchell';
UPDATE ARTIST SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';

SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%'; 

SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 30;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID_CASCADE
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;

ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID_CASCADE
    FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;


DELETE FROM INVOICE WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER WHERE FirstName = 'Robert' AND LastName = 'Walter');
DELETE FROM INVOICELINE WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER WHERE FirstName = 'Robert' AND LastName = 'Walter');
DELETE FROM CUSTOMER WHERE FirstName = 'Robert' AND LastName = 'Walter';

*/

-- FUNCTIONS
CREATE OR REPLACE FUNCTION getCurrentTime
    RETURN date
    AS current_time date;
BEGIN
    SELECT Current_Timestamp INTO current_time FROM Dual;
    RETURN current_time;
END;

CREATE OR REPLACE FUNCTION getMediatypeLength(mt_id IN number)
    RETURN number
    AS mt_length number;
BEGIN
    SELECT length(Name) INTO mt_length FROM Mediatype WHERE MediatypeID = mt_id;
    RETURN mt_length;
END;

CREATE OR REPLACE FUNCTION averageTotal(average OUT number)
    RETURN number
    AS average number;
BEGIN
    SELECT ave(Total) INTO average FROM Invoice;
    RETURN average;
END;

CREATE OR REPLACE FUNCTION maxTotal(highest OUT text)
    RETURN text
    AS highest text;
BEGIN
    SELECT Title INTO highest FROM Track 
        WHERE UnitPrice IN (SELECT max(UnitPrice) FROM Track);
    RETURN highest;
END;

CREATE OR REPLACE FUNCTION averagePrice(average OUT number)
    RETURN number
    AS average number;
BEGIN
    SELECT ave(UnitPrice) INTO average FROM InvoiceLine;
    RETURN average;
END;

CREATE OR REPLACE FUNCTION getEmployeeAfter1968
    RETURN SYS_REFCURSOR
    IS result SYS_REFCURSOR;
BEGIN
    SELECT * INTO result FROM Employee WHERE Birthdate > TO_DATE('31-DEC-68');
    RETURN result;
END;



-- STORED PROCEDURES
CREATE OR REPLACE PROCEDURE getFirstLast
    AS
BEGIN
    SELECT FirstName, LastName FROM Employee;
END;

CREATE OR REPLACE PROCEDURE updateEmployee(EmployeeID in number, LastName in varchar2, Firstname in varchar2, 
    Title in varchar2, ReportsTo in number, Birthdate in date, Hiredate in date, 
    Address in varchar2, City in varchar2, State in varchar2, Country in varchar2, Postalcode in varchar2, 
    Phone in varchar2, Email in varchar2, Fax in varchar2)
    AS
BEGIN
    UPDATE Employee e 
    SET e.EmployeeID = EmployeeID, e.LastName = LastName, e.FirstName = FirstName, 
    e.Title = Title, e.ReportsTo = ReportsTo, e.Birthdate = Birthdate, e.Hiredate = Hiredate, 
    e.Address = Address, e.City = City, e.State = State, e.Country = Country, e.Postalcode = Postalcode, 
    e.Phone = Phone, e.Email = Email, e.Fax = Fax
    WHERE e.EmployeeID = EmployeeID;
END;

CREATE OR REPLACE PROCEDURE getManager(EmployeeID IN number, man OUT varchar2)
    AS
BEGIN
    SELECT (m.FirstName || ' ' || m.Lastname) INTO man FROM Employee e
    INNER JOIN Employee m ON m.EmployeeID = e.ReportsTo
    WHERE e.EmployeeID = EmployeeID;
END;

CREATE OR REPLACE PROCEDURE getNameCompany(CustomerID IN number, Customername OUT varchar2, CustomerCompany OUT varchar2)
    AS
BEGIN
    SELECT ( c.FirstName || ' ' || c.LastName) INTo CustomerName FROM Customer
    WHERE c.CustomerID = CustomerID;
    SELECT c.Company INTO CustomerCompany FROM Customer c
    WHERE c.CustomerID = CustomerID;
END;


-- TRANSACTIONS
CREATE OR REPLACE PROCEDURE deleteInvoice(InvoiceID IN number)
    AS
BEGIN
    DELETE FROM Invoice i
    WHERE i.InvoiceID = InvoiceID;
    commit;
END;

CREATE OR REPLACE PROCEDURE insertCustomer(CustomerID number,FirstName varchar2,LastName varchar2,Company varchar2,
  Address varchar2,City varchar2, St varchar2,Country varchar2,PostalCode varchar2,
  Phone varchar2,Fax varchar2,Email varchar2, SupportRepID number)
    AS
BEGIN
    INSERT INTO Customer
    Values (CustomerID, FirstName, LastName, Company, Address, City, St, Country, PostalCode, Phone, Fax, Email, SupportRepID);
    commit;
END;

-- TRIGGERS
CREATE OR REPLACE TRIGGER insertEmployee
    AFTER INSERT ON Employee
BEGIN
    dbms_output.put_line('You inserted a new Employee record!');
END;

CREATE OR REPLACE TRIGGER updateAlbum
    AFTER UPDATE ON Album
BEGIN
    dbms_output.put_line('You updated an Album!');
END;

CREATE OR REPLACE TRIGGER deleteCustomer
    AFTER DELETE ON Customer
BEGIN
    dbms_output.put_line('You deleted a Customer!');
END;



-- JOINS
SELECT Customer.FirstName, Customer.LastName, Invoice.InvoiceID FROM Customer
INNER JOIN Invoice
ON Customer.CustomerID = Invoice.CustomerID;

SELECT Customer.CustomerID, Customer.FirstName, Customer.LastName, Invoice.InvoiceID, Invoice.Total FROM CUSTOMER
FULL OUTER JOIN Invoice
ON Customer.CustomerID = Invoice.CustomerID;

SELECT Artist.Name, Album.Title FROM Album
RIGHT JOIN Artist
ON Album.ArtistID = Artist.ArtistID;

SELECT Artist.Name FROM Artist
CROSS JOIN Album
ON Album.ArtistID = Artist.ArtistID
ORDER BY Artist.Name ASC;

SELECT * FROM Employee A, Employee B
WHERE A.EmployeeID <> B.EmployeeID
AND A.ReportsTo = B.ReportsTo;

SELECT * FROM InvoiceLine IL
    INNER JOIN Invoice I ON IL.InvoiceID = I.InvoiceID
        INNER JOIN Customer C ON I.CustomerID = C.CustomerID
            INNER JOIN Employee E ON C.SupportRepID = E.EmployeeID
    INNER JOIN Track T ON IL.TrackID = T.TrackID
        INNER JOIN Genre G ON T.GenreID = G.GenreID
        INNER JOIN Mediatype M ON T.MediatypeID = M.MediatypeID
        INNER JOIN Album Al ON T.AlbumID = Al.AlbumID
            INNER JOIN Artist Ar ON Al.ArtistID = Ar.ArtistID
        INNER JOIN Playlisttrack Plt ON T.TrackID = Plt.TrackID
            INNER JOIN Playlist Pl ON Plt.PlaylistID = Pl.PlaylistID;


-- Administration
-- BACKUP DATABASE MyDatabase TO DISK = 'C:\my_git_repos\1712_dec11_jta\MyDatabase.bak'