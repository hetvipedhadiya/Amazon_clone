--Scalar valued functions


--1. Write a function to print "hello world".
alter function p_helloworld()
returns varchar(100)
as 
begin
	return 'Hello World'
end
select dbo.p_helloworld();

-------------------------------------------------------------------------------

--2. Write a function which returns addition of two numbers.
alter function addno(@a int,@b int)
returns int
as
begin
	return @a+@b
end
select dbo.addno(3,5);

-------------------------------------------------------------------------------

--3. Write a function to print cube of given number.
alter function cube(@a int)
returns int
as
begin
	return @a*@a*@a
end
select dbo.cube(2);

------------------------------------------------------------------------------

--4. Write a function to check where given number is ODD or EVEN.
alter function odd_even_no(@a int)
returns varchar(30)
as
begin
	declare @s as varchar(50)
	if(@a%2=0)
		set @s='even'
	else
		set @s='odd'
	return @s
end
select dbo.odd_even_no(3);

-------------------------------------------------------------------------------

--5. Write a function to compare two integers and returns the comparison result. (Using Case statement)
alter function compareno(@a int,@b int)
returns varchar(50)
as
begin
	declare @s as varchar(50)
	set @s=case
			when @a>@b then convert(varchar(50),@a)+' is greater then'+ convert(varchar(50),@b) 
			when @b>@a then convert(varchar(50),@a)+' is less then'+ convert(varchar(50),@b) 
			else 'both are equal'
		   end
	return @s
end
select dbo.compareno(3,4);

-----------------------------------------------------------------------------

--6. Write a function to print number from 1 to N. (Using while loop)
create function oneton(@n int)
returns varchar(1000)
as
begin	
	declare @i as int
	set @i=1;
	declare @s as varchar(1000)
	set @s=''
	while(@i<=@n)
	begin
	set @s=@s+convert(varchar,@i)+' ';
	set @i=@i+1;
	end
	return @s
end
select dbo.oneton(10);

-------------------------------------------------------------------------------

--7. Write a function to print sum of even numbers between 1 to 20.
alter function sumOfEvenNo()
returns varchar(10)
as 
begin
	declare @a as int 
	set @a=1;
	declare @b as int 
	set @b=20;
	declare @sum as int 
	set @sum=0;
	while(@a<=@b)
		begin
			if(@a%2=0)
			set @sum=@sum+@a;
			set @a=@a+1;
		end
	return @sum;
end
select dbo.sumOfEvenNO()

--------------------------------------------------------------------------

--8. Write a function to check weather given number is prime or not.
alter function primeNo(@a int)
returns varchar(30)
as
	begin
		declare @s1 as varchar(30)
		set @s1='Number is Prime' 
		declare @s2 as varchar(30)
		set @s2='Number is not Prime' 
		declare @i as int
		set @i=2
		declare @count as int
		set @count=0
		while(@i<@a)
			begin
				if(@a%@i=0)
				set @count=@count+1
				set @i=@i+1
			end
		if(@count=0)
			return @s1
		return @s2
	end
select dbo.primeNO(9)

--------------------------------------------------------------------------------

--9. Write a function which accepts two parameters start date & end date, and returns a difference in days.
alter function dateDif(@d1 datetime,@d2 datetime)
returns int
as
begin
	declare @a as datetime
	return datediff(year,@d1,@d2)
end
select dbo.dateDif('01-02-2004',getdate())

-------------------------------------------------------------------------------

--10. Write a function which accepts year & month in integer and returns total days in given month & year.
alter function totalDays(@y int,@m int)
returns int
as
begin
	return datediff(day,datefromparts(@y,@m,1),eomonth(datefromparts(@y,@m,1)))+1
end
select dbo.totalDays(2023,1)

-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------

--Table valued functions (Use tables of lab-2)

--11. Write a function which returns a table with detail of person whose first name starts with B.
--12. Write a function which returns a table with unique first names from person table.
--13. Write a function which accepts department ID as a parameter & returns a detail of the person