-- # Write your MySQL query statement below
-- select u.name, t.amount 
-- from 
-- Users u join 
-- Transactions t 
-- on 
-- u.account = t.account 
-- where t.amount > 10000 and t.amount = sum(t.amount);

select u.name, sum(t.amount) as balance
from Users u
join Transactions t
on u.account = t.account
group by u.account, u.name
having sum(t.amount) > 10000;