USE sakila;
/*Procedimiento que cotenga un cursor recorriendo la consulta film_id, title from film. Consultar el stock y si es inferior a 3 metemos en una tabla temporal*/
/*
DROP PROCEDURE IF EXISTS procedimiento_cursor;
DELIMITER //
CREATE PROCEDURE procedimiento_cursor()
BEGIN 
	DECLARE id SMALLINT;
    DECLARE tit VARCHAR(128);
    DECLARE stock SMALLINT;
    DECLARE done INT DEFAULT FALSE;
	DECLARE mi_primer_cursor CURSOR FOR 
		SELECT f.film_id, f.title, COUNT(i.film_id) 
        FROM film f LEFT JOIN inventory i ON f.film_id = i.film_id 		-- es necesario el left join para tener en cuenta las peliculas que no estan en inventory 
        GROUP BY 1 HAVING COUNT(i.film_id) < 3;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS stock_menor_3 (
				film_id SMALLINT,
                title VARCHAR(128), 
                stock SMALLINT
	);
    
    OPEN mi_primer_cursor;
	
    WHILE done = FALSE DO
		FETCH mi_primer_cursor INTO id, tit, stock;
        INSERT INTO stock_menor_3 VALUES (id, tit, stock);
	END WHILE;
    
    CLOSE mi_primer_cursor;
    
    select * from stock_menor_3;
    drop table stock_menor_3;
END//
DELIMITER ;

CALL procedimiento_cursor();
*/

-- Procesar payment par detectar transacciones sospechosas(pagos > 50% del promedio de pagos) guardando en una tabla nueva (creada en el procedimiento) con los atributos: payment_id primary key, customer_id, amount, promedio anterior, fecha de deteccion/now()
-- CURSOR CON SELECT payment_id, customer_id, amount from payment order by customer_id, payment_date
DROP PROCEDURE IF EXISTS transaction_snitcher;
DELIMITER //
CREATE PROCEDURE transaction_snitcher()
BEGIN
		DECLARE done INT DEFAULT FALSE;
		DECLARE p_id SMALLINT;
        DECLARE c_id SMALLINT;
        DECLARE am DECIMAL(5,2);
        DECLARE avg_am DECIMAL(5,2);
        DECLARE cursor_snitcher CURSOR FOR 
			SELECT payment_id, customer_id, amount FROM payment;
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
        
        SELECT AVG(amount) INTO avg_am FROM payment;
        
        CREATE TABLE IF NOT EXISTS suspicius_payments (
			payment_id SMALLINT PRIMARY KEY NOT NULL, 
            customer_id SMALLINT NOT NULL,
            amount DECIMAL(5,2) NOT NULL,
            avg_payment DECIMAL(5,2) NOT NULL,
            d_date DATETIME DEFAULT NOW()
		);
        
        OPEN cursor_snitcher;
        insert_loop: LOOP
        
        IF done THEN
			LEAVE insert_loop;
		END IF;
        
        FETCH cursor_snitcher INTO p_id, c_id, am;
        IF am > (avg_am * 1.5) THEN
			INSERT INTO suspicius_payments VALUES (p_id, c_id, am, avg_am, NOW());
		END IF;
        
        END LOOP;
        
        CLOSE cursor_snitcher;
END//
DELIMITER ;

-- drop table if exists suspicius_payments;
CALL transaction_snitcher();
select * from suspicius_payments;
SET GLOBAL wait_timeout = 28800;
SET GLOBAL interactive_timeout = 28800;
SET GLOBAL net_read_timeout = 600;
SET GLOBAL net_write_timeout = 600;

/* Rehacer sin cursores*/