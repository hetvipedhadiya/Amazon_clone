create trigger tr_person_insert
on person
for insert,update,delete
as
begin
print 'record affected' 
end
insert into person values(1,'krina',30000,'12-1-2023','rajkot',18,'11-12-2004')
select * from person
select * from person_log

--2 --

create trigger tr_person_insert
on person
after insert
as begin 
declare @person_id int
 declare @person_name varchar(100)


select @person_id= inserted.person_id,@person_name=inserted.person_name
from inserted

insert into person_log values (@person_id,@person_name,'insert',getdate())
end


insert into person values(101,'abc',2000,'1-12-2022','rajkot',20,'1-3-2005')

--3--
alter trigger tr_person_update 
on person
after update 
as begin
declare @person_id int,
  @person_name varchar(100),
  @salary decimal(8,2),
  @joining_date datetime,
  @city varchar(100),
  @age int,
  @birth_date datetime
  select @person_id= inserted.person_id,@person_name=inserted.person_name,@salary=inserted.salary,@joining_date=inserted.joining_date,@city=inserted.city,@age=inserted.age,@birth_date=inserted.birth_date
from inserted

insert into person_log values (@person_id,@person_name,'insert',getdate())
end

 update person set person_name='anjali',salary=50000,joining_date='2-4-2023',city='rajkot',age=18,birth_date='27-4-2006'
 where person_id=1
 select * from person_log