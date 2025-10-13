-- Funciones
/*1. Funcion que devuelva numero de peliculas asociadas a la categoria pasada por parametro
DROP FUNCTION IF EXISTS films_x_category_function;
DELIMITER //
CREATE FUNCTION films_x_category_function(category VARCHAR(15))
	RETURNS SMALLINT
    READS SQL DATA
BEGIN
	DECLARE total SMALLINT;
    
    SET total = (
		SELECT count(f.film_id) FROM film f 
		JOIN film_category fc ON f.film_id = fc.film_id
		JOIN category c ON fc.category_id = c.category_id
		WHERE c.name = category);
    
    RETURN total;
END //
DELIMITER ;

SELECT name from category;
SELECT films_x_category_function('Animation');
*/
/*
2. Funcion que devuelva un descuento si > 50 pelis alquiladas platino (0,15) si > 20 (0,10) si > 10 (0,05);
*/
/*
DROP FUNCTION IF EXISTS discount_function;
DELIMITER //
CREATE FUNCTION discount_function(customerID smallint)
	RETURNS DECIMAL(3,2)	-- 3 NUMEROS EN TOTAL DE ELLOS 2 DECIMALES
    READS SQL DATA
BEGIN
	DECLARE discount DECIMAL(3,2);
    DECLARE n_films SMALLINT;
    
    SET n_films = ( 
		SELECT COUNT(customer_id)
        FROM rental WHERE customer_id = customerID);

	SET discount = 
		CASE 
			WHEN n_films > 50 THEN 0.15
			WHEN n_films > 20 AND n_films < 50 THEN 0.10
			WHEN n_films > 10 AND n_films < 20 THEN 0.05
		END;
        
    RETURN discount;
END //
DELIMITER ;

SELECT discount_function(7);
*/
/*
3. bucle para obtener la suma de los 100 primeros numeros (5050)
*/
DROP FUNCTION IF EXISTS sum_1_to_100_function;
DELIMITER //
CREATE FUNCTION sum_1_to_100_function()
	RETURNS SMALLINT
    NO SQL
BEGIN
	DECLARE result SMALLINT;
    DECLARE contador SMALLINT;
    DECLARE max_value SMALLINT;
    
    SET max_value = 100;
    SET contador = 0;
    
	bucle: LOOP
		IF contador > max_value THEN
			LEAVE bucle;
		END IF;
		
        SET result = max_value + contador; ¿¿¿¿¿¿
        SET contador = contador + 1;
	END LOOP;
    
    RETURN result;
END //
DELIMITER ;

SELECT sum_1_to_100_function();