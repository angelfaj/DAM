-- Procedimiento que cotenga un cursor recorriendo la consulta film_id, title from film. Consultar el stock y si es inferior a 3 metemos en una tabla temporal*/
use sakila;
DROP PROCEDURE IF EXISTS repaso;
DELIMITER //
CREATE PROCEDURE repaso()
BEGIN
	DECLARE done SMALLINT DEFAULT FALSE; -- Condicion de parada del bucle
    -- Variable donde se volcarán los datos del cursor
    DECLARE id SMALLINT UNSIGNED;
    DECLARE tit VARCHAR (128);
    DECLARE st MEDIUMINT UNSIGNED;
    -- Cursor
    DECLARE cur CURSOR FOR
		SELECT f.film_id, f.title, COUNT(i.inventory_id) FROM film f
        JOIN inventory i ON i.film_id = f.film_id GROUP BY 1 HAVING COUNT(i.inventory_id) < 3;
	-- Excepción que arrojará una vez finalice la lectura de todos los valores
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
        
	CREATE TEMPORARY TABLE IF NOT EXISTS stock_menor_3 (
				film_id SMALLINT,
                title VARCHAR(128), 
                stock MEDIUMINT UNSIGNED
	);
    
    -- Ejecución del cursor
    OPEN cur;
    WHILE done = FALSE DO
		FETCH cur INTO id, tit, st;
        INSERT INTO stock_menor_3 VALUES (id, tit, st);
	END WHILE;
    CLOSE cur;
    
    -- Mostramos los datos y eliminamos la tabla 
    SELECT * FROM stock_menor_3;
    DROP TABLE stock_menor_3;
    
END//
DELIMITER ;
call repaso();
DROP PROCEDURE IF EXISTS repaso;