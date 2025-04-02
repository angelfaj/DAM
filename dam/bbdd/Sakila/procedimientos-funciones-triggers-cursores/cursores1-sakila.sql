USE sakila;
/*Procedimiento que cotenga un cursor recorriendo la consulta film_id, title from film. Consultar el stock y si es inferior a 3 metemos en una tabla temporal*/
DROP PROCEDURE IF EXISTS procedimiento_cursor;
DELIMITER //
CREATE PROCEDURE procedimiento_cursor()
BEGIN 
	DECLARE id SMALLINT;
    DECLARE tit VARCHAR(128);
    DECLARE stock SMALLINT;
    DECLARE done INT DEFAULT FALSE;
	DECLARE mi_primer_cursor CURSOR FOR 
		SELECT film_id, title FROM film;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS stock_menor_3 (
				film_id SMALLINT,
                title VARCHAR(128), 
                stock SMALLINT
	);
    
    OPEN mi_primer_cursor;
	
    WHILE done = FALSE DO
		FETCH mi_primer_cursor INTO id, tit;
        SELECT COUNT(inventory_id) INTO stock FROM inventory WHERE film_id = id;	-- lo mas rapido seria incluir esta consulta en la declaracion del cursor
        IF stock < 3 THEN
			INSERT INTO stock_menor_3 VALUES (id, tit, stock);
		END IF;
	END WHILE;
    
    CLOSE mi_primer_cursor;
    
    select * from stock_menor_3;
    drop table stock_menor_3;
END//
DELIMITER ;

CALL procedimiento_cursor();
