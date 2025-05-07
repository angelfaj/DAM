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


-- 5. Crear un evento que borre registros de payment donde amount = 0 una vez al
-- día.
-- 6. Crear un evento deshabilitado por defecto.
-- 7. Listar todos los eventos definidos en la base de datos Sakila.
-- Nivel Intermedio (8–14) – Uso con tablas Sakila reales
-- 8. Crear un evento que, cada semana, cuente cuántas películas están alquiladas
-- (rental) y lo registre en log_eventos.
-- 9. Crear un evento que actualice el campo last_update de todos los actores una
-- vez por día.
-- 10. Crear un evento que borre registros antiguos de la tabla rental (más de 5
-- años).
-- 11. Crear una tabla log_bajas y un evento que mueva clientes inactivos de
-- customer allí cada mes.
-- 12. Crear un evento que actualice automáticamente el estado de los pagos
-- (payment) con fecha futura a “pendiente”.13. Crear un evento que actualice cada día los precios de películas de más de 10
-- años con un 10% de descuento.
-- 14. Crear un evento que inserte estadísticas de uso (películas más alquiladas)
-- cada semana en una tabla de resumen.
-- Nivel Avanzado (15–20) – Tareas automatizadas más realistas
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