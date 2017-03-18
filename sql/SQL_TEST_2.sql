-- 2. Знайдіть працівників, котрі мають найбільшу зарплатню в своєму підрозділі (department).

SELECT dep.NAME,emp.NAME
 FROM DEPARTMENTS dep
  -- join tables (DEPARTMENTS) and (EMPLOYEES) by department
  INNER JOIN EMPLOYEES  emp
   ON dep.DEPARTMENTID=emp.DEPARTMENTID
  WHERE emp.SALARY = ( SELECT MAX(SALARY) FROM EMPLOYEES WHERE DEPARTMENTID=emp.DEPARTMENTID);

