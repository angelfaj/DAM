/*
USE sakila;

-- Funciones:

DELIMITER //
DROP FUNCTION IF EXISTS total_rentals_by_film//
CREATE FUNCTION total_rentals_by_film(p_film_id SMALLINT UNSIGNED)
	RETURNS INT
    READS SQL DATA
    DETERMINISTIC
BEGIN
	DECLARE total INT;
    
    SELECT COUNT(r.inventory_id) INTO total FROM rental r
    JOIN inventory i ON i.inventory_id = r.inventory_id 
    WHERE i.film_id = p_film_id;
    
    RETURN total;
END//
DELIMITER ;

DELIMITER //
DROP FUNCTION IF EXISTS total_income_by_film//
CREATE FUNCTION total_income_by_film(p_film_id SMALLINT UNSIGNED)
	RETURNS DECIMAL(10,2)
    READS SQL DATA
    DETERMINISTIC
BEGIN
	DECLARE total DECIMAL(10,2);
    
    SELECT SUM(p.amount) INTO total FROM payment p
    JOIN rental r ON p.rental_id = r.rental_id
    JOIN inventory i ON r.inventory_id = i.inventory_id
    WHERE i.film_id = p_film_id;
    
    RETURN total;
END//
DELIMITER ;

DELIMITER //
DROP FUNCTION IF EXISTS total_rentals_by_store//
CREATE FUNCTION total_rentals_by_store(p_store_id TINYINT UNSIGNED)
	RETURNS INT
    READS SQL DATA
    DETERMINISTIC
BEGIN
	DECLARE total INT;
    
    SELECT COUNT(r.rental_id) INTO total FROM rental r
    JOIN store s ON s.manager_staff_id = r.staff_id
    WHERE s.store_id = p_store_id;
    
    RETURN total;
END//
DELIMITER ;


DELIMITER //
DROP FUNCTION IF EXISTS total_income_by_store//
CREATE FUNCTION total_income_by_store(p_store_id TINYINT UNSIGNED)
	RETURNS DECIMAL(15,2)
    READS SQL DATA
    DETERMINISTIC
BEGIN
	DECLARE total DECIMAL(15,2);
    
    SELECT SUM(p.amount) INTO total FROM payment p
    JOIN rental r ON r.staff_id = p.staff_id
    JOIN store s ON r.staff_id = s.manager_staff_id
    WHERE s.store_id = p_store_id;
    
    RETURN total;
END//
DELIMITER ;

SELECT total_rentals_by_film(1), total_income_by_film(1), total_rentals_by_store(1), total_income_by_store(1);
*/


-- Procedimiento
DELIMITER //
DROP PROCEDURE IF EXISTS save_statistics//
CREATE PROCEDURE save_statistics()
BEGIN
	DECLARE done SMALLINT DEFAULT FALSE;
    DECLARE id_pelicula SMALLINT UNSIGNED;
    DECLARE id_store TINYINT UNSIGNED;
    DECLARE contador_id SMALLINT UNSIGNED DEFAULT 1;
   
   DECLARE film_cursor CURSOR FOR
		SELECT film_id FROM film;
	DECLARE store_cursor CURSOR FOR
		SELECT store_id FROM store;
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
	CREATE TABLE IF NOT EXISTS statistics (
		statistics_id SMALLINT UNSIGNED PRIMARY KEY,
		entity_tipe ENUM('film', 'store') NOT NULL,
		entity_id SMALLINT UNSIGNED NOT NULL,
		total_rentals INT,
		total_income DECIMAL(15,2),
		date_recorded TIMESTAMP DEFAULT NOW()
	);
	
    OPEN film_cursor;
    WHILE NOT done DO 
		FETCH film_cursor INTO id_pelicula;
		
		IF NOT done THEN 
			INSERT INTO statistics SELECT contador_id, 'film', id_pelicula, total_rentals_by_film(id_pelicula), total_income_by_film(id_pelicula), now();
            SET contador_id = contador_id + 1;
		END IF;
    END WHILE;
    CLOSE film_cursor;
    
    SET done = FALSE; -- Reseteamos el valor de done a false para utilizarlo el siguiente cursor
    
    OPEN store_cursor;
    WHILE NOT done DO 
		FETCH store_cursor INTO id_store;
		
		IF NOT done THEN 
			INSERT INTO statistics SELECT contador_id, 'store', id_store, total_rentals_by_store(id_store), total_income_by_store(id_store), now();
            SET contador_id = contador_id + 1;
		END IF;
    END WHILE;
    CLOSE store_cursor;

END//
DELIMITER ;

CALL save_statistics();

SELECT * FROM statistics;
-- TRUNCATE TABLE statistics;
-- DROP TABLE statistics;
