USE sakila;

/*Enunciado: Evento que borre(ponga inactivos) clientes que no hayan comprado o alquilado en los ultimos 2 años*/
-- DROP EVENT IF EXISTS delete_old_customer_event;

-- CREATE EVENT delete_old_customer_event
-- ON SCHEDULE EVERY 3 YEAR
-- DO 
-- 	UPDATE customer SET active = 0
--     WHERE customer_id NOT IN (
-- 		SELECT DISTINCT customer_id FROM (
-- 			SELECT customer_id FROM payment 
--             WHERE payment_date >= DATE_SUB(NOW(), INTERVAL 2 YEAR)
--             UNION					-- UNION COMBINA LOS RESULTADOS DE DOS O MAS CONSULTAS EN UNA SOLA ELIMINANDO DUPLICADOS
--             SELECT customer_id FROM rental 
--             WHERE return_date >= DATE_SUB(NOW(), INTERVAL 2 YEAR)
--             ) AS sub
-- );
-- 	    
-- SELECT COUNT(*) FROM customer where active = 0;

/*Enunciado: Crea el usuario finanzas que solo pueda iniciar sesion desde la maquina local*/
-- CREATE USER 'finanzas'@'localhost';

/*Enunciado: Crea el rol lectura_payment_customer_rental y asignale los permisos de lectura pertinentes*/
-- CREATE ROLE 'lectura_payment';
-- GRANT SELECT ON sakila.payment TO 'lectura_payment';
-- GRANT SELECT ON sakila.rental TO 'lectura_payment';
-- GRANT SELECT ON sakila.customer TO 'lectura_payment';

/*Enunciado: asigna el rol al usuario finanzas*/
-- GRANT 'lectura_payment' TO 'finanzas'@'localhost';
-- SET DEFAULT ROLE 'lectura_payment' TO 'finanzas'@'localhost';

-- SELECT * FROM mysql.user;