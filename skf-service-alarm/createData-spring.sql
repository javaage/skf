delimiter //
CREATE PROCEDURE `createData`()
BEGIN
DECLARE i INT DEFAULT 0;  
DECLARE v DOUBLE DEFAULT 0; 
DECLARE d timestamp DEFAULT CURRENT_TIMESTAMP();
WHILE i <= 200000	DO    
	select RAND()*5 into v;  
	insert into measurement(IDNode, MeasDate, MeasValue) values(6, DATE_SUB(d,INTERVAL i*4 MINUTE), v);  
	SET i = i + 1;   
END WHILE;  
END;

