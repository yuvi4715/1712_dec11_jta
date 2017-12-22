--good to know only
select * from all_tables;
select * from all_constraints where table_name = 'TEAMS';
desc dual; --not descending order
--desc in the front means describe
--desc at the end of query is descending order
desc SYSTEM_PRIVILEGE_MAP;
select * from SYSTEM_PRIVILEGE_MAP;

--create table with no primary key
create table Player (name VARCHAR2(50),position VARCHAR2(50));

-- disadvantage of not having primary key
insert into Player values('Tom Brady', 'Quarter Back');

-- to retreive data from player table run the below line
select * from player;
--* refers to all records in a table

--try to insert duplicate records in a table
-- insert tom brady's with same position
insert into Player values('Tom Brady', 'Quarter Back');

--delete all records or truncate and then add primary key
delete from Player;
commit;
rollback;

alter table Player 
add player_id Number(10) Primary KEY;

desc Player;

alter table Player modify name Not null;

--primary key - unique identifier and also its not null
--contains uniqueness and not null feature (both unique key constraint 
--and not null constraint)
--primary can't be null. unique can have one null value

--insert records now
insert into Player (PLAYER_ID,NAME, POSITION, team_id) 
values(1, 'Tom Brady', 'QB', 1);
insert into Player values ('Russel Wilson', 'QB', 2, 2);
insert into Player values ('Deshaun Watson', 'QB', 3, 6);
insert into Player values ('Aaron Rodgers', 'QB', 4, 10);
insert into Player values ('Cam Newton', 'QB', 5, 11);
insert into Player values ('Colin Capernick', 'QB', 6, 12);
insert into Player values ('Matt Ryan', 'QB', 7, 4);
insert into Player values ('Kirk Cousins', 'QB', 8, 8);
insert into Player values ('Jarred Gof', 'QB', 9, 10);
insert into Player values ('Peyton Manning', 'QB', 10,9);
insert into Player values ('Eli Manning', 'QB', 11, 3);
insert into Player values ('Drew Brees', 'QB', 12, 5);
insert into Player values ('Ben Rothilsberg', 'QB', 13, 10);
insert into Player values ('Jay Cutler', 'QB', 14, 10);
insert into Player values ('Matt Stafford', 'QB', 15, 10);
insert into Player values ('Joe Flacco', 'QB', 16, 7);

select * from Player;

create table Teams (
id number(10) Primary key, 
team_name varchar2(50),
city varchar2(20)
);

delete from Player;

alter table Player
add team_id number(10);

ALTER table Player
ADD FOREIGN KEY (team_id) References Teams(id);

ALTER table Player
modify team_id NOT NULL ;

select * from Player;
select * from Teams;

insert into Teams values (1,'Patriots','New England');
insert into Teams values (2,'Sea Hawks','Seattle');
insert into Teams values (3,'Giants','New York');
insert into Teams values (4,'Falcons','Atlanta');
insert into Teams values (5,'Saints','New Orleans');
insert into Teams values (6,'Texans','Houston');
insert into Teams values (7,'Ravens','Baltimore');
insert into Teams values (8,'Red Skins','DC');
insert into Teams values (9,'Broncos','Denver');

--join is another way to say inner join
--aliases can be used for table name or column names
select * from player p join teams t 
on p.TEAM_ID = t.ID;

select * from player p inner join teams t 
on p.TEAM_ID = t.ID;
--rename column name in the result set (query result)
--Selected only the columns that we needed
--aliases for the table
-- inner join
--chose the order in column names were displayed
select 
    p.TEAM_ID as TEAMID,
    p.NAME as Player_Name,
    T.CITY as Playing_FOR,
    t.TEAM_NAME as Favorite_Teams
from player p join teams t 
    on p.TEAM_ID = t.ID;
--outer join
select *
from player p right join teams t 
    on p.TEAM_ID = t.ID;
    
select *
from teams t left join player p  
    on p.TEAM_ID = t.ID;
    
delete from player where player.PLAYER_ID = 8;
commit;
-- default order is ascending
-- we can modify it to descending or mention explicitly ascending too
-- order by - display the records in the order we specify for the field
select count(p.position),p.POSITION
from teams t left join player p  
    on p.TEAM_ID = t.ID
group by p.position
order by p.POSITION
;

insert into Player values('AJ Green', 'WR', 17, 1);
insert into Player values ('Antonio Brown', 'WR', 18, 2);
insert into Player values ('Julio Jones', 'WR', 19, 3);
insert into Player values ('Levon Bell', 'RB', 20, 4);
insert into Player values ('Marshawn Lynch', 'RB', 21, 5);

--scalar & aggreegate functions
--scalar - TRIM, LTRIM, RTRIM, Round, ABS, Trunc, Length, RPad, LPad,
-- String functions, Substr, to_char, Inst, replace

-- aggregate - sum, max, min, count, avg, 


--inner join vs outer join
--inner join vs intersect
--right vs left outer join
--union vs union all
--scalar vs aggregate
--order by vs group by
--where vs having
--join vs sub query
--function vs stored procedures
--count vs sum
