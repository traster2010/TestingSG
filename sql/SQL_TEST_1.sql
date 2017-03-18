--1. Знайдіть імена (name) всіх працівників (employees), зарплата (salary) яких більша за керівника (boss).

-- Перший варіант - реалізація через об'єднання
SELECT emp.NAME
 FROM EMPLOYEES emp
  -- join tables (EMPLOYEES) and (EMPLOYEES) - get boss salary for employee
  INNER JOIN EMPLOYEES bos
   ON emp.BOSSID=bos.EMPLOYEEID
 WHERE emp.SALARY>bos.SALARY;


-- Другий варіант - реалізація через  підзапит
SELECT emp.NAME 
  FROM EMPLOYEES  emp
   WHERE emp.SALARY > (SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEEID=emp.BOSSID);

