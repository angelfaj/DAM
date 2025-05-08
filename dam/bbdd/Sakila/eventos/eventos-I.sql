-- Crear cutomers_backup_events que sera una copia literal de customer
-- USE sakila;

-- DROP TABLE IF EXISTS customers_backup_events;
-- CREATE TABLE IF NOT EXISTS customers_backup_events (
-- 	customer_id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
--     store_id TINYINT UNSIGNED, 
--     first_name VARCHAR(45),
--     last_name VARCHAR(45),
--     email VARCHAR(50),
--     addres_id SMALLINT UNSIGNED,
--     FOREIGN KEY (addres_id) REFERENCES address(address_id),
--     FOREIGN KEY (store_id) REFERENCES store(store_id),
--     active TINYINT(1),
--     create_date DATETIME,
--     last_update TIMESTAMP
-- );

-- INSERT INTO customers_backup_events SELECT * FROM customer;

-- -- EVENTO QUE BORRE EL ULTIMO USUARIO CADA MINUTO
-- SET GLOBAL event_scheduler = ON; -- Habilitamos la ejecucion de eventos

-- DROP EVENT IF EXISTS last_user_deleter_by_minute;

-- DELIMITER //
-- CREATE EVENT IF NOT EXISTS last_user_deleter_by_minute
-- ON SCHEDULE EVERY 1 MINUTE
-- DO 
-- BEGIN
-- 	DECLARE last_customer SMALLINT UNSIGNED;
-- 	
--     SELECT MAX(customer_id) INTO last_customer 
-- 		FROM customers_backup_events;
--         
-- 	DELETE FROM customers_backup_events WHERE customer_id = last_customer;
-- END//
-- DELIMITER ;

-- SELECT COUNT(customer_id) FROM customers_backup_events;

-- 20 Ejercicios Eventos en MySQL (Sakila)

-- 1. Crear un evento que inserte la fecha y hora actual cada minuto.
-- DROP EVENT IF EXISTS insert_datetime;
-- DELIMITER //
-- CREATE EVENT IF NOT EXISTS insert_datetime
-- ON SCHEDULE EVERY 1 MINUTE
-- DO BEGIN
-- 	UPDATE customers_backup_events SET last_update = NOW();
-- END//
-- DELIMITER ;

-- SELECT last_update FROM customers_backup_events; 

-- 2. Crear un evento que inserte un mensaje en una tabla log_eventos cada hora.
-- DROP EVENT IF EXISTS event_log;
-- DELIMITER //
-- CREATE EVENT IF NOT EXISTS event_log
-- ON SCHEDULE EVERY 1 HOUR
-- DO BEGIN
-- 	CREATE TABLE IF NOT EXISTS log_eventos (
-- 		event_datetime DATETIME
-- 	);
--     
--     INSERT INTO log_eventos VALUES (NOW());
-- END//
-- DELIMITER ;

-- SELECT * FROM log_eventos;

-- 3. Habilitar el programador de eventos (event_scheduler).
-- SET GLOBAL event_scheduler = ON; 

-- 4. Crear un evento que corra una sola vez dentro de 10 minutos e inserte una fila
-- en log_eventos.
DROP EVENT IF EXISTS insert_once_event;

CREATE EVENT IF NOT EXISTS insert_once_event
ON SCHEDULE AT NOW() + INTERVAL 10 MINUTE
DO INSERT INTO log_eventos VALUES (NOW());

-- 5. Crear un evento que borre registros de payment donde amount = 0 una vez al
-- día.
DROP EVENT IF EXISTS delete_payment_with_cero_amount_event;

CREATE EVENT IF NOT EXISTS delete_payment_with_cero_amount_event
ON SCHEDULE EVERY 24 HOUR
DO DELETE FROM payment WHERE amount = 0;

-- 6. Crear un evento deshabilitado por defecto.
DROP EVENT IF EXISTS disable_event;

CREATE EVENT IF NOT EXISTS disable_event
ON SCHEDULE AT NOW() + INTERVAL 20 HOUR 
DISABLE DO DELETE FROM payment WHERE amount = 0;

-- 7. Listar todos los eventos definidos en la base de datos Sakila.
SHOW events;

-- 8. Crear un evento que, cada semana, cuente cuántas películas están alquiladas
-- (rental) y lo registre en log_eventos.
ALTER TABLE log_eventos ADD 
	films_on_rent SMALLINT UNSIGNED;

DROP EVENT IF EXISTS count_films_on_rent;

CREATE EVENT IF NOT EXISTS count_films_on_rent
ON SCHEDULE EVERY 1 WEEK DO
INSERT INTO log_eventos (films_on_rent)
	SELECT COUNT(film_id) FROM inventory i
    JOIN rental r ON i.inventory_id = r.inventory_id 
	WHERE r.return_date IS NULL;
    
-- 9. Crear un evento que actualice el campo last_update de todos los actores una
-- vez por día.
DROP EVENT IF EXISTS update_actor_last_update_event;

CREATE EVENT IF NOT EXISTS update_actor_last_update_event
ON SCHEDULE EVERY 1 DAY
DO UPDATE actor SET last_update = NOW();

-- 10. Crear un evento que borre registros antiguos de la tabla rental (más de 5
-- años).
DROP EVENT IF EXISTS delete_old_rental_records;

CREATE EVENT IF NOT EXISTS delete_old_rental_records
ON SCHEDULE AT NOW + INTERVAL 5 YEAR
DO DELETE FROM rental WHERE (YEAR(last_update) - YEAR(NOW())) >= 5;

-- 11. Crear una tabla log_bajas y un evento que mueva clientes inactivos de
-- customer allí cada mes.
DROP TABLE IF EXISTS log_bajas;
CREATE TABLE IF NOT EXISTS log_bajas (
  `customer_id` smallint unsigned NOT NULL PRIMARY KEY,
  `store_id` tinyint unsigned NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address_id` smallint unsigned NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL,
  `last_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP EVENT IF EXISTS move_inactive_customer_event;
DELIMITER //
CREATE EVENT IF NOT EXISTS move_inactive_customer_event
ON SCHEDULE AT NOW() + INTERVAL EVERY MONTH
DO BEGIN
	INSERT INTO log_bajas SELECT * FROM customer WHERE active = false;
    DELETE FROM customer WHERE active = false;    
END//
DELIMITER ;

-- 12. Crear un evento que actualice automáticamente el estado de los pagos (payment) 
-- con fecha futura a “pendiente”.
-- OMITIDO

-- 13. Crear un evento que actualice cada día los precios de películas de más de 10
-- años con un 10% de descuento.
DROP EVENT IF EXISTS update_rental_rate_to_old_film_event;

CREATE EVENT IF NOT EXISTS update_rental_rate_to_old_film_event
ON SCHEDULE AT NOW() + INTERVAL EVERY DAY
DO UPDATE film SET rental_rate = rental_rate*0.9 
WHERE (SELECT * FROM film 
		WHERE (YEAR(NOW()) - release_year) >= 10);


-- 14. Crear un evento que inserte estadísticas de uso (películas más alquiladas)
-- cada semana en una tabla de resumen.
ALTER TABLE log_eventos ADD most_rented_film SMALLINT UNSIGNED;

DROP EVENT IF EXISTS save_most_rented_film_event;

CREATE EVENT IF NOT EXISTS save_most_rented_film_event
ON SCHEDULE AT NOW() + INTERVAL EVERY WEEK
DO 
INSERT INTO log_eventos(most_rented_film) 
	SELECT i.film_id FROM inventory i 
    JOIN rental r ON r.inventory_id = i.inventory_id
    WHERE i.film_id IN (
		SELECT i.film_id as film_id, COUNT(i.film_id) FROM inventory i 
		JOIN rental r ON r.inventory_id = i.inventory_id 

!!SELECT SOBRE LA SUBCONSULTA PARA NO REPETIR CODIGO 


-- 15. Crear un evento que ejecute un procedimiento almacenado que calcula
-- ingresos mensuales y lo guarda en una tabla reporte_mensual.
-- 16. Crear un evento que, al finalizar el mes, archive la tabla payment y vacíe los
-- registros.
-- 17. Crear un evento que corra cada 5 minutos y verifique si hay nuevos clientes
-- registrados hoy. Si hay, guarda un log.
-- 18. Crear un evento que desactive cuentas de clientes inactivos por más de 1 año.
-- 19. Crear un evento que revise el inventario de cada tienda y registre si el stock de
-- una categoría baja de 10 unidades.
-- 20. Crear un evento que cada día revise los actores sin películas activas y los
-- marque como inactivos en una tabla auxiliar.