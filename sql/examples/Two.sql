--data types
--char, varchar, varchar2, nvarchar, date, timestampe, number
--blob, clob

--varchar & varchar2
-- varchar - reserved type for future to differntiate null 
-- and empty string
-- varchar2 - doesn't differentiate between null or empty string

--varchar vs nvachar vs char

--bare bone syntax for functions, procedures, views, index, triggers
--create or replace function/view/procedure/triggers/index name(input parameters)
--return variable
--as -- should contain all the variables that you want to initialize
--begin -- this where you code starts
--end -- code ends
--;/
create or replace function multiply(i Number, j Number)
return Number
as myResult Number;
begin
    myResult := i * j;
    return myResult;
end
;
/
--execute function - approach 1
declare
    myVar Number;
begin
    myVar := multiply(10,20);
    DBMS_OUTPUT.PUT_Line(myVar);
end
;
/

-- approach 2
select multiply(20,30) from dual;

create or replace function getPlayerName(playerid Number)
return varchar
as playerName varchar(30);
anotherVariable varchar(20);
begin
    select p.NAME into playerName
    from jta1712.Player p
    where p.PLAYER_ID = playerid;
    anotherVariable := replace(playerName, 'a','e');
    return anotherVariable;
end
;
/
--this function will return player name when player id is available
create or replace function getPlayerID(playername varchar)
return Number
as playerID varchar(30);
begin
    select p.PLAYER_ID into playerID
    from jta1712.Player p
    where p.name = playername;
    return playerID;
end
;
/
--calling a function in select statement
select getplayername(2) from dual;
--calling a function in where clause of select statement
select * from teams join player
    on teams.id = player.TEAM_ID
where 
    teams.ID = getPlayerID('Russel Wilson');

desc dual;
select * from dual;

