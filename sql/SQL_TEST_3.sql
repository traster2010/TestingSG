--3. Знайдіть назви всіх підрозділи, котрі мають менш ніж 3-х працівників

SELECT dep.NAME 
 FROM DEPARTMENTS dep
  -- join tables (DEPARTMENTS) and (EMPLOYEES) by department
  INNER JOIN EMPLOYEES  emp
   ON dep.DEPARTMENTID=emp.DEPARTMENTID
 GROUP BY dep.NAME
 HAVING COUNT(emp.EMPLOYEEID)<3;
