# Write your MySQL query statement below
select event_day  as day, emp_id,
-- out_time - in_time  as total_time 
-- this is it
    SUM(out_time - in_time) AS total_time
from 
Employees
group by emp_id,day;
