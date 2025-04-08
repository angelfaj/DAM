USE saklia;
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
DROP TABLE IF EXISTS gastos_clientes//

CREATE PROCEDURE total_pagos_cliente_proc()
BEGIN
	DECLARE cliente_id SMALLINT UNSIGNED;
    DECLARE done SMALLINT DEFAULT FALSE;
    DECLARE cur CURSOR FOR 
		SELECT customer_id FROM payment GROUP BY 1;
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    CREATE TEMPORARY TABLE IF NOT EXISTS gastos_clientes (
		customer_id SMALLINT UNSIGNED PRIMARY KEY,
        total_gastado DECIMAL(10,2)
	);
    
    OPEN cur;
    WHILE done = FALSE DO
		FETCH cur INTO cliente_id;
        INSERT INTO gastos_clientes 
			SELECT total_pagos_cliente(cliente_id), cliente_id;	-- MODIFICAR PARA EVITAR DUPLICADOS
	END WHILE;
    CLOSE cur;
    
    SELECT * FROM gastos_clientes;
    DROP TABLE gastos_clientes;
    
END//
DELIMITER ;

CALL total_pagos_cliente_proc();