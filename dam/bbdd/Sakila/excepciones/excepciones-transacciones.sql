usE sakila;
-- procedimiento para capturar excepciones y realizar las gestiones sobre una transaccion
/*
DELIMITER //
CREATE PROCEDURE error_handler()
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'Ocurrio un error, ejecutando rollback' AS MESSAGE;
        ROLLBACK;
    END;
    
    DECLARE CONTINUE HANDLER FOR SQLWARNING
    BEGIN
		SELECT 'Ocurrio una advertencia, ejecutando rollback' AS MESSAGE;
        ROLLBACK;
    END;
    
    START TRANSACTION;
    INSERT INTO actor VALUES (1, 'paco', 'perez', NOW());
    INSERT INTO actor (first_name, last_name, last_update) VALUES ('paco', 'perez', NOW());
    COMMIT;
    
END//
DELIMITER ;
*/

/*
0 FALSO, 1 TRUE. Los clientes que no haya alquilado peliculas en el ultimo año, lo ponemos en inactivo(0)*/
/*
DROP PROCEDURE IF EXISTS inactive_customer;
DELIMITER //
CREATE PROCEDURE inactive_customer()
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'Ocurrio un error, ejecutando rollback' AS MESSAGE;
        ROLLBACK;
    END;
    
    DECLARE CONTINUE HANDLER FOR SQLWARNING
    BEGIN
		SELECT 'Ocurrio una advertencia, ejecutando rollback' AS MESSAGE;
        ROLLBACK;
    END;
    
    START TRANSACTION;
	UPDATE customer 
		SET active = 0 
		where customer_id in (
				SELECT customer_id 
				FROM rental 
				WHERE DATEDIFF(NOW(), return_date) >= 365);
	
    COMMIT;
    
END//
DELIMITER ;
SET SQL_SAFE_UPDATES = 0;	-- Desactivamos el modo seguro para poder ejecutar querys que no tengan primary keys como condicion en el where como la de arriba

call inactive_customer();
SELECT active from customer;
*/


/* REALIZAR REBAJA DEL 10% A AQUELLAS PELIS NO ALQUILADAS EN LOS 6 ULTIMOS MESES*/
DROP PROCEDURE IF EXISTS films_discount_procedure;
DELIMITER //
CREATE PROCEDURE films_discount_procedure()
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		SELECT 'Ocurrió una excepción, ejecutando rollback' AS MESSAGE;
        ROLLBACK;
    END;
    
    DECLARE CONTINUE HANDLER FOR SQLWARNING				-- continue pq lal aplicar el descuento saltara el arning de truncar, en este caso queremos que siga asi que continue y sin rollback
    BEGIN
		SELECT 'Alerta - Se han truncado los datos' AS MESSAGE;
    END;
    
    START TRANSACTION;
    /*
    NO PUEDES HACER UN UPDATE QUE CONTENGA UNA SUBCONSULTA SOBRE LA TABLA OBJETIVO DEL UPDATE
    UPDATE film SET rental_rate = (rental_rate * 0.9) WHERE film_id IN (
		select DISTINCT f.film_id 
			from film f 
			join inventory i on f.film_id = i.film_id
			join rental r on i.inventory_id = r.inventory_id
			where datediff(now(), r.return_date) > 180);
	*/
    UPDATE film SET rental_rate = (rental_rate * 9) WHERE film_id IN (
		select DISTINCT i.film_id 
			FROM inventory i
			join rental r on i.inventory_id = r.inventory_id
			where datediff(now(), r.return_date) > 180);
    COMMIT;
END//
DELIMITER ;

CALL films_discount_procedure();
SELECT * FROM film;
