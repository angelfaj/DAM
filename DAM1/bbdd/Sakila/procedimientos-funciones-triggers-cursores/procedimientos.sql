USE saklia;
-- procedimiento en sakila calcular_max_min_media que reciba como parametro id_customer y devuelva su pago maximo, minimo y media de pagos de la tabla payments
DELIMITER $$
CREATE PROCEDURE calcular_max_min_media (
	IN id INT, 
    OUT max_payment DOUBLE, 
    OUT min_payment DOUBLE, 
    OUT avg_payment DOUBLE)
BEGIN
	set max_payment = (SELECT max(amount) from payment where customer_id = id);
    set min_payment = (SELECT min(amount) from payment where customer_id = id);
    set avg_payment = (SELECT avg(amount) from payment where customer_id = id);
END$$
DELIMITER ;

CALL calcular_max_min_media(1, @max, @min, @aveg);
SELECT @max, @min, @aveg;

-- update que actualice en todas las filas de rental el return date a 19 años despues 
DELIMITER $$
CREATE PROCEDURE update_return_date()
BEGIN
	UPDATE rental
    SET retur_date !!!!!!!!!!!!!!!!1
END$$
DELIMITER ;