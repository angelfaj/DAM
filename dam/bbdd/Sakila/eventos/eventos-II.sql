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
	reward_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id smallint UNSIGNED,
    week_start DATE,
    week_end DATE,
    amount_spent DECIMAL(10,2),
    reward_points DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
SELECT * FROM customer_rewards;
UPDATE payment SET payment_date = now();


DROP EVENT IF EXISTS add_reward_points_event;

CREATE EVENT add_reward_points_event
ON SCHEDULE EVERY 1 WEEK -- STARTS CURRENT_DATE + INTERVAL (7 - DAYOFWEEK(CURRENT_DATE)) DAY
DO
  INSERT INTO rewards (customer_id, week_start, week_end, amount_spent, reward_points)
  SELECT p.customer_id,
         DATE_SUB(CURDATE(), INTERVAL 7 DAY),
         CURDATE(),
         SUM(p.amount),
         ROUND(SUM(p.amount) * 0.10, 2)
  FROM payment p
  WHERE p.payment_date BETWEEN DATE_SUB(CURDATE(), INTERVAL 7 DAY) AND CURDATE()
  GROUP BY p.customer_id;

/*Enunciado: Revisar mensualmente los clientes que califican para el nivel VIP (aquellos que
han gastado más de 100 en el mes) y actualizar su estatus. Añadir columna vip_status en
customer.*/

/*cada domingo a las dos y media de la noche se muevan los lquileres ya pagados a una tabla nueva rental_payments y */
CREATE TABLE rental_payments AS SELECT * FROM payment;
DELETE FROM rental_payments;

DROP EVENT IF EXISTS move_paid_rentals_event;

CREATE EVENT move_paid_rentals_event
ON SCHEDULE 