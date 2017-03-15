--1. Знайдіть імена (name) всіх працівників (employees), зарплата (salary) яких більша за керівника (boss).

SELECT emp.NAME
 FROM EMPLOYEES emp
  -- join tables (EMPLOYEES) and (EMPLOYEES) - get boss salary for employee
  INNER JOIN EMPLOYEES bos
   ON emp.BOSSID=bos.EMPLOYEEID
 WHERE emp.SALARY>bos.SALARY;

 --  ,emp.SALARY,bos.NAME,bos.SALARY,emp.SALARY-bos.SALARY

SELECT emp.NAME 
  FROM EMPLOYEES  emp
   WHERE emp.SALARY > (SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEEID=emp.BOSSID);

SELECT dep.NAME, emp.NAME 
  FROM DEPARTMENTS dep
   INNER JOIN EMPLOYEES  emp
    ON dep.DEPARTMENTID=emp.DEPARTMENTID
   WHERE emp.SALARY > (SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEEID=emp.BOSSID);

