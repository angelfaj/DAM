/*
USE sakila;

DROP TRIGGER IF EXISTS mi_trigger;
DELIMITER //
CREATE TRIGGER mi_trigger 
BEFORE UPDATE ON customer
FOR EACH ROW 
BEGIN
	
    if strcmp(new.first_name, 'manolo') = 0 then
		signal sqlstate '45000' set message_text = 'Manolo is banned';
	end if;
    
END //
DELIMITER ;

UPDATE customer 
	set last_name = 'ok' WHERE customer_id = 2;

select first_name from customer WHERE customer_id = 2;
*/
/*
DROP TRIGGER IF EXISTS mi_trigger2;
DELIMITER //
CREATE TRIGGER mi_trigger2
BEFORE UPDATE ON customer
FOR EACH ROW 
BEGIN
	DECLARE v_name VARCHAR(1);
    SET v_name = (
		SELECT SUBSTR(first_name, 1, 1) FROM customer WHERE customer_id = new.customer_id);
    
    if strcmp(v_name, 'm') = 0 then
		signal sqlstate '45000' set message_text = 'Customer whos firs name letter is M cant rent';
	end if;
    
END //
DELIMITER ;

UPDATE customer SET last_name = 'an' WHERE customer_id = 3;
*/

/*
CREATE VIEW customer_view AS
	SELECT * FROM customer;
    
    
CREATE INDEX customer_index ON customer (first_name, last_name);

CREATE UNIQUE INDEX customer_id_index ON customer (customer_id);
*/

SELECT AVG(price) FROM rental WHERE price > (SELECT AVG(price) FROM rental);


SELECT DATEDIFF(now(), '2011-04-01') / 30;
SELECT STRCMP('HOLA', 'HOLA');
SELECT SUBSTR('HOLA', 1, 1);