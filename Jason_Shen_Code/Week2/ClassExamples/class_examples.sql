--BARE BONE STRUCTURE FOR FUNCTIONS/VIEWS/PROCEDURES/TRIGGERS/INDEXES
--create or replace {insert function/view/procedure/triggers/indexname} (parameters)
create or replace function multiply(i Number, j Number)
--return type (for functions)
return Number
--contail all variables that you want to initialize
as
    myresult number;
--your actual code logic here
begin
    myresult := i*j;
    return myresult;
end;
/

--EXAMPLE OF HOW TO CALL THE FUNCTION
declare 
    myvar Number;
begin
    myvar := multiply(10,20);
    DBMS_OUTPUT.PUT_LINE(myvar);
end;
/

--EXAMPLE OF CALLING A QUERY WITHIN A FUNCTION
create or replace function getPlayerName(playerid Number)
return varchar

as playerName varchar(30);

begin
    select p.name into playerName from player p where p.PLAYER_ID = playerid;
    return playerName;
end;
/
desc player;
desc teams;

