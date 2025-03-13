1. trigger que no permita alquilar a customers cuyo nombre no empiece por a, ademas debe mostrar un mensaje y enviar la señal de estado 45000

CREATE TRIGGER
	customer_name_start_without_a_cant_rent
BEFORE INSERT ON
	rental
FOR EACH ROW
BEGIN
	DECLARE first_leter VARCHAR(1);
	SET first_leter =(
			SELECT 
				SUBSTRING(c.first_name, 1, 1)
			FROM 
				customer c
			WHERE
				c.customer_id = NEW.customer_id);
	 IF first_leter IS NULL OR first_leter = '' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Customer name cannot be empty or NULL';
    ELSEIF !STRCMP(first_leter, 'A') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Customer name must start with A to rent this film';
    END IF;
END

2. trigger que controle la insercion en payment para que el amount sea positivo con mismo mensaje que el anterior

3. crear tabla rental_audit (ra_id, rental_id, action_time(datetime), message ) y añadir la columna       rental_duration(int default 14) a rental
   crear trigger before update rental que calcule rentalduration a partir del antinguo rental_date y return_date y seteara el rentalduration con ese valor.
   si la duracion es mayor a 7 dias inserte en la tabla rental_audit; rental_id, action_time(hora actual), message   

4. trigger que desactive las cuentas con inactividad mayor o igual a seis meses.

DELIMITER //
CREATE TRIGGER
	before_update_customer
BEFORE UPDATE ON 
	customer
FOR EACH ROW
BEGIN
	IF OLD.last_update <= DATE_SUB(NOW(), INTERVAL 6 MONTH) THEN
		SET 
			new.active = 0;
	END IF;
END//
DELIMITER ;