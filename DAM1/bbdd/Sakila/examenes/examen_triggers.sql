/*
USE sakila;
ALTER TABLE customer
ADD COLUMN num_rentals INT DEFAULT 0,
ADD COLUMN sum_payments DECIMAL(10,2) DEFAULT 0.00,
ADD COLUMN balance DECIMAL(10,2) DEFAULT 0.00;
*/
/*
-- EL trigger funciona correctamente
DROP TRIGGER IF EXISTS exam_trigger;

DELIMITER //
CREATE TRIGGER exam_trigger
AFTER INSERT ON rental
FOR EACH ROW
BEGIN
	DECLARE total_pagos DECIMAL(10,2);
    DECLARE total_alquileres INT;
    DECLARE balance_v DECIMAL(10,2);
    
    SELECT SUM(amount) INTO total_pagos FROM payment WHERE customer_id = new.customer_id;
    SELECT SUM(rental_id) INTO total_alquileres FROM rental WHERE customer_id = new.customer_id;
    SELECT COUNT(r.rental_id) - COUNT(p.payment_id) INTO balance_v FROM rental r JOIN payment p ON p.rental_id = r.rental_id WHERE r.customer_id = new.customer_id;
    
    UPDATE customer SET sum_payments = total_pagos, num_rentals = total_alquileres, balance = balance_v, last_update = now() WHERE customer_id = new.customer_id;
 
END//
DELIMITER ;

INSERT INTO rental(inventory_id, customer_id, staff_id) VALUES (3, 4, 1);
INSERT INTO rental(inventory_id, customer_id, staff_id) VALUES (4, 5, 1);
select * from customer where customer_id = 4;
select * from customer where customer_id = 5;
*/

/*INDICES:
Tabla payment, (rental_id), ya que rental_id suele ser condicion de muchas consultas y ademas es una clave foranea, 
(amount, customer_id) por otro lado amount es un dato bastante recursivo en nuestras consultas y por ello lo incluyo junto con el customer_id para identificar el pago con el cliente
Tabla film (title, description) para acceder rapidamente a los datos mas importantes y otro con (film_id, rental_rate) ya que consultar el precio de la pelicula por su id sera algo bastante recursivo tambien
*/
/*
-- sintaxis indice
CREATE INDEX rental_index ON payment(amount, customer_id);
*/
/*VISTA*/
-- lA VISTA FUNCIONA
/*
CREATE VIEW resumen_pagos_cliente AS
	SELECT 
		c.customer_id,
        c.first_name, 
        c.last_name,
        sum(p.amount) as total_pagos, 
        MAX(p.payment_date), 
        COUNT(p.payment_id) as numero_pagos,
        avg(p.amount) as media_pagos
	FROM 
		customer c
	JOIN
		payment p ON p.customer_id = c.customer_id
	GROUP BY 1, 2, 3;
*/
    