DROP MATERIALIZED VIEW IF exists department_salary_summary;
DROP TABLE IF exists employee;

CREATE TABLE IF NOT EXISTS employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary NUMERIC
);


CREATE MATERIALIZED VIEW IF NOT EXISTS department_salary_summary AS
SELECT department, SUM(salary) AS total_salary
FROM employee
GROUP BY department;