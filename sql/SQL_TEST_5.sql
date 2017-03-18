--5. Знайдіть котру загальну суму зарплатні отримує кожен підрозділ.

SELECT dep.NAME,SUM(emp.SALARY)
 FROM TMP_DEPARTMENTS dep
  -- join tables (DEPARTMENTS) and (EMPLOYEES) by department
  INNER JOIN TMP_EMPLOYEES  emp
   ON dep.DEPARTMENTID=emp.DEPARTMENTID
 GROUP BY dep.NAME;







