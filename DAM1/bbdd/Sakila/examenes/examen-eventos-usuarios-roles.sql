USE sakila;
-- EVENTOS
/*Evento 1: evento que marque inactivos los customer que no han alquilado en mas de un año*/
-- DROP EVENT IF EXISTS set_inactive_customer_event;

-- CREATE EVENT set_inactive_customer_event
-- ON SCHEDULE EVERY 1 YEAR 
-- DO 
-- 	UPDATE customer SET active = 0 WHERE customer_id IN (
-- 		SELECT DISTINCT customer_id FROM rental 
--         WHERE rental_date < DATE_SUB(NOW(), INTERVAL 1 YEAR)
-- 	);

-- -- Pruebas
-- SELECT COUNT(*) FROM customer WHERE active = 0;
        
        
/*Evento 2: evento para hoy a las 23:59 inserte en una tabla llamada daily_store_revenue el total de ingresos por tienda, atributos: store_id, revenue_date, total_revenue*/
-- CREATE TABLE IF NOT EXISTS daily_store_revenue (
-- 	table_id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
--     store_id TINYINT UNSIGNED NOT NULL,
--     revenue_date DATETIME DEFAULT NOW(),
--     total_revenue DECIMAL(10,2) NOT NULL
-- );

-- DROP EVENT IF EXISTS daily_revenue_event;

-- DELIMITER //
-- CREATE EVENT daily_revenue_event
-- ON SCHEDULE AT '2025-05-22 23:59:00'
-- ON COMPLETION PRESERVE					-- Como solo se ejecuta una vez evitamos su borrado para futuros usos
-- DO BEGIN
-- 	-- Declaramos las variables que almacenaran los ingresos de cada tienda
-- 	DECLARE amount_s1 DECIMAL(10,2);
--     DECLARE amount_s2 DECIMAL(10,2); 
--     
--     -- Guardamos la cantidad en la variable1
-- 	SELECT SUM(p.amount) INTO amount_s1 FROM payment p 
--     JOIN staff s ON s.staff_id = p.staff_id
--     JOIN store st ON s.store_id = st.store_id
--     WHERE st.store_id = 1;
--     
--     -- Guardamos la cantidad en la variable2
--     SELECT SUM(p.amount) INTO amount_s2 FROM payment p 
--     JOIN staff s ON s.staff_id = p.staff_id
--     JOIN store st ON s.store_id = st.store_id
--     WHERE st.store_id = 2;
--     
--     -- INSERTAMOS LOS DATOS
--     INSERT INTO daily_store_revenue(store_id, revenue_date, total_revenue) VALUES (1, NOW(), amount_s1);
--     INSERT INTO daily_store_revenue(store_id, revenue_date, total_revenue) VALUES (2, NOW(), amount_s2);
--     
-- END//
-- DELIMITER ;

-- -- Comprobación
-- SELECT * FROM daily_store_revenue;


-- USUARIOS
/*Ej 1: crear un usuario usuario_consulta con contraseña Consulta123! que solo pueda consultar (SELECT) la tabla customer de sakila*/
-- DROP USER IF EXISTS 'usuario_consulta'@'localhost';
-- CREATE USER 'usuario_consulta'@'localhost' IDENTIFIED BY 'Consulta123!';
-- GRANT SELECT ON sakila.customer TO 'usuario_consulta'@'localhost';

-- SELECT * FROM mysql.user WHERE User LIKE 'usuario_consulta';

/*Ej 2: Crear usuario cajero1, un rol rol_cajero con permisos para insertar y consultar datos en payment y rental. Por ultimo asignar el rol al cajero*/
-- DROP USER IF EXISTS 'cajero1'@'localhost';
-- CREATE USER 'cajero1'@'localhost';
-- CREATE ROLE 'rol_cajero';
-- GRANT INSERT, SELECT ON sakila.payment TO 'rol_cajero';
-- GRANT INSERT, SELECT ON sakila.rental TO 'rol_cajero';
-- GRANT 'rol_cajero' TO 'cajero1'@'localhost';

-- Comprobamos
-- SELECT * FROM mysql.user WHERE User LIKE 'cajero1';
-- SHOW GRANTS FOR 'rol_cajero';


/*Ej 3: revoca todos los permisos de modificacion excepto el de lectura al usuario existente editor_datos*/
-- DROP USER IF EXISTS 'editor_datos'@'localhost';
-- CREATE USER 'editor_datos'@'localhost';
-- GRANT INSERT, UPDATE, DELETE, SELECT ON sakila.film TO 'editor_datos'@'localhost';

-- REVOKE INSERT, UPDATE, DELETE ON sakila.film FROM 'editor_datos'@'localhost';
-- SHOW GRANTS FOR 'editor_datos'@'localhost';