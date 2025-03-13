USE sakila;
/*1. Enunciado:
La tienda de alquiler de películas Sakila necesita un procedimiento para registrar un nuevo
alquiler. Este procedimiento debe:
● Insertar un nuevo alquiler en la tabla rental.
● Registrar el pago correspondiente en la tabla payment, tomando en cuenta la
tarifa de alquiler de la película.
Actualizar el historial de pagos del cliente, devolviendo el total gastado por el
mismo.
●
Parámetros:
● p_customer_id (INT) → ID del cliente que alquila la película.
● p_inventory_id (INT) → ID del inventario de la película a alquilar.
● p_staff_id (INT) → ID del empleado que registra el alquiler.
● p_total_amount (DECIMAL) (SALIDA) → Total gastado por el cliente en alquileres
hasta la fecha.*/
/*
DELIMITER $$
DROP PROCEDURE IF EXISTS add_rental_and_payment;
CREATE PROCEDURE add_rental_and_payment (
	IN p_customer_id INT, 
    IN p_inventory_id INT, 
    IN p_staff_id INT,
    OUT p_total_amount DOUBLE)
BEGIN
	DECLARE v_rent_id INT;
    DECLARE v_rental_rate DOUBLE;
    
    INSERT INTO rental (inventory_id, customer_id, staff_id) VALUES (
		p_inventory_id, p_customer_id, p_staff_id);

    SET v_rent_id = LAST_INSERT_ID(); -- que es el ultimo ide insertado o de manera menos pro ->(SELECT MAX(rental_id) FROM rental); 

	SET v_rental_rate = (
					SELECT 
						rental_rate
					FROM 
						film f
					JOIN 
						inventory i ON i.film_id = f.film_id
					WHERE
						i.inventory_id = p_inventory_id
					LIMIT 1);
	INSERT INTO payment (customer_id, staff_id, amount, rental_id) VALUES (
		p_customer_id, p_staff_id, v_rental_rate, v_rent_id);
	
    SET p_total_amount = (
					SELECT
						SUM(amount)
					FROM
						payment
					WHERE
						customer_id = p_customer_id);
END$$
DELIMITER ;

CALL add_rental_and_payment(1, 1, 1, @total_amount);
SELECT @total_amount; 
*/

/*2. Enunciado:
Cuando un cliente devuelve una película, la tienda debe registrar la fecha de devolución y, si
corresponde, aplicar un recargo por retraso. El procedimiento debe:
Actualizar la fecha de devolución en la tabla rental.
Calcular si hubo retraso comparando la fecha de devolución con la duración del
alquiler.
Aplicar un recargo en caso de devolución tardía y registrar el pago de la multa.
Parámetros:
● p_rental_id (INT) → ID del alquiler que se está devolviendo.
● p_late_fee (DECIMAL) (SALIDA) → Monto de la multa por retraso (0 si no hay
multa).*/

DELIMITER $$
DROP PROCEDURE IF EXISTS add_extra_charge;
CREATE PROCEDURE add_extra_charge (
	IN p_rental_id INT,
    OUT p_late_fee DOUBLE)
BEGIN
	DECLARE **********
    UPDATE TABLE 
		rental 
    SET 
		return_date = now()
	WHERE 
		p_rental_id = rental_id;
	
    

END$$
DELIMITER ;

CALL add_extra_charge(1, @extra_fee);
SELECT @extra_fee; 
