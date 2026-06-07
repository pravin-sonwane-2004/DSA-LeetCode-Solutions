# Write your MySQL query statement below
-- select d.Department, e.name as Employee, max(d.salary) 
-- from Employee e join Department d on e.departmentId = d.id
-- where e.salary <  max(d.salary) group by e.departmentId;

-- this can be for the department wise salary
-- SELECT departmentId, MAX(salary) AS max_salary
-- FROM Employee
-- GROUP BY departmentId;

SELECT
    d.name AS Department,
    e1.name AS Employee,
    e1.salary AS Salary
FROM Employee e1
JOIN Department d
    ON e1.departmentId = d.id
WHERE (
    SELECT COUNT(DISTINCT e2.salary)
    FROM Employee e2
    WHERE e2.departmentId = e1.departmentId
      AND e2.salary > e1.salary
) < 3;