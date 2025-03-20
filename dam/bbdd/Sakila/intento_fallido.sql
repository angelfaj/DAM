/*—-----------------------------------
Triggers 7pts
------------------------------------------
Crear el Trigger after_payment_insert (7pts):
1. Crea una tabla que contenga como columnas el staff_id y un staff_revenue.
2. Crea un trigger llamado after_payment_insert que se active después de cada
inserción en la tabla payment.
El trigger debe actualizar la tabla staff_revenue de la siguiente manera:
Si no existe un registro para el staff_id en staff_revenue, se debe insertar
uno nuevo con el amount del nuevo pago.
Si existe un registro, se debe actualizar el total_revenue sumando el amount del
nuevo pago.
*/
/*
USE sakila;
CREATE TABLE staff_stuff (
	ss_id SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,  
	id_staff TINYINT UNSIGNED,
    FOREIGN KEY staff_stuff(id_staff) REFERENCES staff(staff_id),
    staff_revenue LONG);
*/
/*
DROP TRIGGER IF EXISTS after_payment_insert;
DELIMITER //
CREATE TRIGGER after_payment_insert
AFTER INSERT ON payment
FOR EACH ROW
BEGIN
	DECLARE sum_v LONG;
	DECLARE exists_id INT DEFAULT 0;
    SET exists_id = (
		SELECT id_staff FROM staff_stuff WHERE id_staff = (
			SELECT staff_id FROM payment WHERE payment_id = (
				SELECT MAX(payment_id) FROM payment)
			)
		);
    
    IF (SELECT id_staff FROM staff_stuff WHERE id_staff = (SELECT staff_id FROM payment WHERE payment_id = (SELECT MAX(payment_id) FROM payment))) > 0 THEN
    	SELECT staff_revenue INTO sum_v FROM staff_stuff WHERE id_staff = exists_id;
		UPDATE staff_stuff SET staff_revenue =(sum_v + payment);
    END IF;
    
    /*IF exists_id > 0 THEN
    	SELECT staff_revenue INTO sum_v FROM staff_stuff WHERE id_staff = exists_id;
		UPDATE staff_stuff SET staff_revenue =(sum_v + payment);
    END IF;*/
    
    IF exists_id = 0 THEN
		INSERT INTO staff_stuff (id_staff, staff_revenue) VALUES
         (1, 10);
    END IF;

END//
DELIMITER ;

INSERT INTO payment(customer_id, staff_id, rental_id, amount) VALUES
	(3, 1, 3, 40);

SELECT * FROM staff_stuff;
SELECT @exists_id;



/*
—-----------------------------------
Índices 1pts
------------------------------------------
Dime qué índice implementarías en cada tabla. Justifica tu respuesta.
Tabla rental.
Tabla customer.
—-----------------------------------
Vistas 2pts
------------------------------------------
Vista: vista_resumen_alquileres
Esta vista mostrará:
●
●
●
●
●
●
Nombre del cliente
Título de la película alquilada
Fecha de alquiler
Fecha de devolución
Nombre de la tienda donde se alquiló la película
Monto pagado por el alquiler*/