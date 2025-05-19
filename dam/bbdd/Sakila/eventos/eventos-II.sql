/*Enunciado: Si un cliente está próximo a la fecha de vencimiento de su alquiler (dentro de
los próximos 2 días) y aún no ha devuelto la película, se extiende automáticamente el plazo
por 7 días adicionales.*/
-- ALTER TABLE rental ADD return_period DATETIME DEFAULT NOW() NOT NULL;	-- Fecha en la que devolvera la pelicula

-- DELIMITER //
-- DROP EVENT IF EXISTS extend_return_period_event//

-- CREATE EVENT extend_return_period_event
-- ON SCHEDULE EVERY 1 DAY
-- DO BEGIN
-- 	UPDATE rental 
-- 		SET return_period = DATE_ADD(return_period, INTERVAL 7 DAY) 	-- En esta sentencia no se permite poner tabla.columna
-- 		WHERE DATEDIFF(NOW(), return_period) = 2;
-- END//	
-- DELIMITER ;

-- -- Comprobaciones
-- SELECT DATEDIFF(NOW(), return_period) FROM rental;
-- UPDATE rental SET return_period = DATE_SUB(return_period, interval 2 day);
-- select return_period from rental;

/*Enunciado: Si un cliente no ha devuelto una película en la fecha establecida, se agregará
automáticamente una penalización diaria de $2 al monto total que debe pagar.*/
-- ALTER TABLE rental ADD fee_amount DECIMAL(5,2) DEFAULT 0;

-- DELIMITER // 
-- DROP EVENT IF EXISTS daily_fee_event//

-- CREATE EVENT daily_fee_event
-- ON SCHEDULE EVERY 1 DAY
-- DO BEGIN
-- 	 UPDATE rental SET fee_amount = (fee_amount + 2) 
--      WHERE return_date != now() AND return_period = now();		-- return_date -> fecha devolucion
-- END//															-- return_period -> periodo de alquiler
-- DELIMITER ;


/*Enunciado: Cada semana, los clientes recibirán puntos de recompensa equivalentes al
10% del monto que hayan gastado en ese período. Estos puntos serán almacenados en
una tabla separada.*/
CREATE TABLE IF NOT EXISTS customer_rewards (
	cr_id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    customer_id SMALLINT UNSIGNED,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    reward_points DECIMAL(5,2) NOT NULL
);
SELECT * FROM customer_rewards;
UPDATE payment SET payment_date = now();

DELIMITER //
DROP EVENT IF EXISTS add_reward_points_event//

CREATE EVENT add_reward_points_event
ON SCHEDULE EVERY 1 WEEK
DO BEGIN
	DECLARE client_exists_v SMALLINT UNSIGNED;
	DECLARE client_v SMALLINT UNSIGNED;
    DECLARE points DECIMAL(5,2);
    
    SELECT customer_id INTO client_v FROM payment
    WHERE WEEK(payment_date) = WEEK(NOW());  
    
    SELECT SUM(amount) INTO points FROM payment
    WHERE WEEK(payment_date) = WEEK(NOW())
    GROUP BY customer_id;  
    
    SELECT customer_id INTO client_exists_v FROM customer_rewards
    WHERE customer_id = client_v;  
    
    IF client_exits_v IS NULL THEN
		INSERT INTO customer_rewards VALUES(
	END IF;
    
    
END//
DELIMITER ;

/*Enunciado: Revisar mensualmente los clientes que califican para el nivel VIP (aquellos que
han gastado más de 100 en el mes) y actualizar su estatus. Añadir columna vip_status en
customer.*/