--4. Знайдіть працівників, котрі не бають керівників в своєму підрозділі 

-- Відображення працівників, в якому не призначено керівника в своєму підрозділі 
SELECT dep.NAME, emp.NAME
 FROM DEPARTMENTS dep
   -- join tables (DEPARTMENTS) and (EMPLOYEES) by department (JOIN 1)
  INNER JOIN EMPLOYEES  emp
   ON dep.DEPARTMENTID=emp.DEPARTMENTID   
   -- join (JOIN 1) and (departments without boss) by department
    INNER JOIN (
     -- get departments without boss
       SELECT empt.DEPARTMENTID,max(empt.BOSSID)
        FROM EMPLOYEES empt
       GROUP BY empt.DEPARTMENTID
       HAVING max(empt.BOSSID) IS NULL) dnl
      ON dep.DEPARTMENTID=dnl.DEPARTMENTID;
    

-- Відображення працівників, по яким призначено керівника з іншого підрозділа
SELECT dep.NAME, emp.NAME
 FROM DEPARTMENTS dep
   -- join tables (DEPARTMENTS) and (EMPLOYEES) by department (JOIN 1)
  INNER JOIN EMPLOYEES  emp
   ON dep.DEPARTMENTID=emp.DEPARTMENTID   
   -- join (JOIN 1) and (departments with boss) by department and wrong boss for employee
    INNER JOIN (
     -- get departments with boss
       SELECT empt.DEPARTMENTID,empt.BOSSID
        FROM EMPLOYEES empt
       WHERE empt.EMPLOYEEID=empt.BOSSID) dnl
      ON dep.DEPARTMENTID=dnl.DEPARTMENTID AND emp.BOSSID <> dnl.BOSSID;
      
      
-- Відображення працівників, по яким не проставлено керівника
SELECT dep.NAME, emp.NAME
 FROM DEPARTMENTS dep
  -- join tables (DEPARTMENTS) and (EMPLOYEES) by department
  INNER JOIN EMPLOYEES  emp
   ON dep.DEPARTMENTID=emp.DEPARTMENTID   
 WHERE emp.BOSSID IS NULL;  
