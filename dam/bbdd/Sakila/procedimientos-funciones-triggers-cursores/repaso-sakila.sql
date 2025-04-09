USE sakila;
/*Procedimiento con cursor para para recorrer todos los actores de la tabla actor
 y devuelva su nombre completo junto con el título de las películas en las que han participado.*/
DELIMITER //
DROP PROCEDURE IF EXISTS procedimiento1//
CREATE PROCEDURE procedimiento1()
BEGIN
	DECLARE done SMALLINT DEFAULT FALSE;
	DECLARE first_name VARCHAR(45);
    DECLARE last_name VARCHAR(45);
    DECLARE title VARCHAR(128);
    DECLARE cur CURSOR FOR
		SELECT a.first_name, a.last_name, f.title FROM actor a 
        JOIN film_actor fa ON fa.actor_id = a.actor_id
        JOIN film f ON f.film_id = fa.film_id;
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE actor_film (
		firs_name VARCHAR(45),
		last_name VARCHAR(45),
		title VARCHAR(128)
	);
    
	OPEN cur;
    WHILE done = FALSE DO
		FETCH cur INTO first_name, last_name, title;
        INSERT INTO actor_film VALUES (first_name, last_name, title);
    END WHILE;
    CLOSE cur;
    
    SELECT * FROM actor_film;
    DROP TABLE actor_film;
END//
DELIMITER ;

call procedimiento1();


/* Crear una función que calcule el total de pagos realizados por un cliente, usando la tabla payment. RECIBIRA EL ID CLIENTE COMO PARAMETRO*/
DELIMITER //
DROP FUNCTION IF EXISTS total_pagos_cliente//
CREATE FUNCTION total_pagos_cliente(id_cliente SMALLINT UNSIGNED)
	RETURNS DECIMAL(10,2)
	READS SQL DATA
BEGIN
	DECLARE pagos DECIMAL(10,2);
    
    SELECT SUM(amount) into pagos FROM payment WHERE customer_id = id_cliente;
    
    RETURN pagos;
END//
DELIMITER ;

SELECT total_pagos_cliente(1) AS total_gastado; 

/* Crear un procedimiento que use un cursor para recorrer todos los clientes y
 calcular el total de pagos realizados por cada uno Y LO ALMACENE EN UNA TABLA TEMPORAL, usando la función total_pagos_cliente.*/
 
DELIMITER //
DROP PROCEDURE IF EXISTS total_pagos_cliente_proc//

CREATE PROCEDURE total_pagos_cliente_proc()
BEGIN
	DECLARE cliente_id SMALLINT UNSIGNED;
    DECLARE done SMALLINT DEFAULT FALSE;
    
    DECLARE cur CURSOR FOR 
		SELECT DISTINCT customer_id FROM payment GROUP BY 1;
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS gastos_clientes (
		customer_id SMALLINT UNSIGNED PRIMARY KEY,
        total_gastado DECIMAL(10,2)
	);
    
    TRUNCATE TABLE gastos_clientes;
    
    OPEN cur;
    WHILE done = FALSE DO
		FETCH cur INTO cliente_id;
        
    IF NOT done THEN
		INSERT INTO gastos_clientes (customer_id, total_gastado)
        VALUES (cliente_id, total_pagos_cliente(cliente_id));
	END IF;
        
	END WHILE;
    CLOSE cur;
    
    SELECT * FROM gastos_clientes;
    DROP TABLE gastos_clientes;
    
END//
DELIMITER ;

CALL total_pagos_cliente_proc();

/*Crear una función que calcule el total de ventas por cada tienda utilizando la tabla store y payment 
y posteriormente un procedimiento que recorra cada tienda usando la funcion y guardando los datos en una tabla temporal */
DELIMITER // 
DROP FUNCTION IF EXISTS total_ventas_tienda//
CREATE FUNCTION total_ventas_tienda(p_store_id TINYINT UNSIGNED)
	RETURNS DECIMAL(10,2)
    READS SQL DATA
BEGIN
	DECLARE amount DECIMAL(10,2);
    
	SELECT SUM(p.amount) INTO amount FROM payment p 
    JOIN store s ON p.staff_id = s.manager_staff_id
    WHERE s.store_id = p_store_id;
    
    RETURN amount;
END//
DELIMITER ;

-- SELECT total_ventas_tienda(2);

DELIMITER //
DROP PROCEDURE IF EXISTS total_ventas_tienda_proc//
CREATE PROCEDURE total_ventas_tienda_proc()
BEGIN
	DECLARE done INT DEFAULT FALSE;
    DECLARE id TINYINT UNSIGNED;
    DECLARE cur CURSOR FOR 
		SELECT store_id FROM store;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS total_ventas (
		store_id TINYINT UNSIGNED,
        amount DECIMAL(10,2)
	);
    
    TRUNCATE TABLE total_ventas;	-- Limpiamos la tabla antes de empezar 
    
    OPEN cur;
    
    -- IMPORTANTISIMO!! While evalua la condicion solo al inicio, si la excepcion se produce durante la ejecucion iteraremos una vuelta de mas:
    WHILE done = FALSE DO 	-- Evaluamos
		FETCH cur INTO id;	-- Se produce la excepcion que cambia done a TRUE pero nuestro bucle continua 
        IF done = FALSE THEN	-- Cortamos la ejecucion aqui
			INSERT INTO total_ventas VALUES (id, total_ventas_tienda(id));
		END IF;
    END WHILE;
    
    CLOSE cur;
    
    SELECT * FROM total_ventas;
    DROP TABLE total_ventas;
    
END//
DELIMITER ;

CALL total_ventas_tienda_proc();

/*
### Ejercicio 1:  
Crear un procedimiento que recorra los empleados de la tienda `staff` y 
calcule el total de ventas realizadas por cada uno. 
Usar un cursor para recorrer la tabla `staff` y calcular las ventas realizadas a través de la tabla `payment`. 
El procedimiento debe aceptar un parámetro de entrada para filtrar los empleados por su `store_id` y 
debe devolver un parámetro de salida con el total general de ventas realizadas por los empleados de esa tienda.
*/
DELIMITER //
DROP PROCEDURE IF EXISTS ventas_empleado_proc//
CREATE PROCEDURE ventas_empleado_proc(IN p_store_id TINYINT UNSIGNED, OUT total DECIMAL(10,2))
BEGIN
	DECLARE done SMALLINT DEFAULT FALSE;
    DECLARE v_staff_id TINYINT UNSIGNED;
    DECLARE suma DECIMAL(10,2);
    DECLARE cur CURSOR FOR 
		SELECT staff_id FROM staff;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = TRUE;
    
    SET total = 0;	-- DEBEMOS INICIALIZAR LA VARIABLE ANTES DE SUMAR EN EL CURSOR
    
    OPEN cur;
    WHILE done = FALSE DO
		FETCH cur INTO v_staff_id;
        IF done = FALSE THEN
			SELECT SUM(p.amount) INTO suma FROM payment p 
            JOIN store s ON p.staff_id = s.manager_staff_id
            WHERE p.staff_id = v_staff_id AND s.store_id = p_store_id;
            
            IF suma IS NOT NULL THEN		-- CUALQUIER OPERACION CON NULL DEVOLVERA NULL COMO RESULTADO!
				SET total = (total + suma);
			END IF;
            
        END IF;
    END WHILE;
    CLOSE cur;
    
END//
DELIMITER ;

CALL ventas_empleado_proc(1, @tot);
SELECT @tot;
/*
### Ejercicio 2:  
Crear un procedimiento que recorra los clientes de la base de datos y 
calcule el promedio de alquileres de películas por cada uno. 
El procedimiento debe aceptar un parámetro de entrada para filtrar los clientes por su `store_id` y
debe devolver un parámetro de salida con el promedio general de alquileres de películas de todos los clientes de la tienda.


### Ejercicio 3:  
Crear una función que reciba un `store_id` y calcule el total de los pagos realizados en esa tienda. 
La función debe manejar excepciones en caso de que ocurra algún error al calcular el total.*/