USE sakila;
/*funcion que recibe film_id y devuelve un decimal(10,2). Calcular ingresos por pelicula*/
/*
DROP FUNCTION IF EXISTS calcular_ingresos_por_pelicula;
DELIMITER //
CREATE FUNCTION calcular_ingresos_por_pelicula(film_id_param SMALLINT)
RETURNS DECIMAL(10,2)
READS SQL DATA
BEGIN
	DECLARE total DECIMAL(10,2);
    SET total = (
		SELECT SUM(p.amount) FROM payment p 
        JOIN rental r ON p.rental_id = r.rental_id
        JOIN inventory i ON r.inventory_id = i.inventory_id
        WHERE i.film_id = film_id_param);
	
    RETURN total;
END//
DELIMITER ;

SELECT calcular_ingresos_por_pelicula(2);
*/

/*Funcion que calcule el promedio duracion de alquileres, devuelve un decimal(10,2)*/
DROP FUNCTION IF EXISTS avg_rental_duration;
DELIMITER //
CREATE FUNCTION avg_rental_duration()
RETURNS DECIMAL(10,2)
READS SQL DATA
BEGIN
	DECLARE duration DATETIME;
	SET duration = (
    SELECT AVG(dif) FROM (
		SELECT DATEDIFF(return_date, rental_date) AS dif FROM rental));
	RETURN duration;
END//
DELIMITER ;

SELECT avg_rental_duration;