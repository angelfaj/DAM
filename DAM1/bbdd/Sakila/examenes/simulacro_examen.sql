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
CREATE TABLE staff_revenue (
	staff_revenue_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    staff_id TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY staff_revenue(staff_id) REFERENCES staff(staff_id),
    revenue DECIMAL(10,2) NOT NULL
);

DROP TRIGGER IF EXISTS after_payment_insert;
DELIMITER //
CREATE TRIGGER after_payment_insert
AFTER INSERT ON payment
FOR EACH ROW
BEGIN
	DECLARE id_exists TINYINT UNSIGNED;
    SET id_exists = (
		SELECT staff_id FROM staff_revenue WHERE staff_id = NEW.staff_id);
	
    IF id_exists IS NOT NULL THEN
		UPDATE staff_revenue SET revenue = (revenue + NEW.amount) WHERE staff_id = NEW.staff_id;
	ELSE
		INSERT INTO staff_revenue(staff_id, revenue) VALUES (NEW.staff_id, (SELECT SUM(amount) FROM payment WHERE staff_id = NEW.staff_id));
	END IF;

END//
DELIMITER ;

-- DROP TABLE staff_revenue;
INSERT INTO payment(customer_id, staff_id, rental_id, amount, payment_date) VALUES (1, 2, 1, 10.3, now());
SELECT * FROM staff_revenue;
INSERT INTO payment(customer_id, staff_id, rental_id, amount, payment_date) VALUES (1, 2, 1, 10.3, now());
SELECT * FROM staff_revenue;

*/
/*
—-----------------------------------
Índices 1pts
------------------------------------------
Dime qué índice implementarías en cada tabla. Justifica tu respuesta.
	Tabla rental.
	Tabla customer.
*/
/*
-- La creacion de indices dependera del uso de la base de datos, en nuestro caso veo conveniente crear los siguientes indices:
-- Tabla rental: inventory_id y customer_id con rental_id puesto que acelerarian consultas con las tablas inventory y customer
CREATE INDEX rental_inventory_index ON rental(inventory_id);
CREATE INDEX rental_customer_index ON rental(rental_id, customer_id);
-- Tabla customer: first_name con addres_id para las consultas acerca de la informacion de los clientes y customer_id con active para saber rapidamente si la cuenta esta activa o no
CREATE INDEX customer_info_index ON customer(first_name, address_id);
CREATE INDEX customer_active_index ON customer(customer_id, active);
*/

    
/*
—-----------------------------------
Vistas 2pts
------------------------------------------
Vista: vista_resumen_alquileres
Esta vista mostrará:
	Nombre del cliente
	Título de la película alquilada
	Fecha de alquiler
	Fecha de devolución
	Nombre de la tienda donde se alquiló la película
	Monto pagado por el alquiler
*/
/*
CREATE VIEW vista_resumen_alquileres AS
	SELECT 
		c.first_name AS cliente,
        f.title AS pelicula,
        r.rental_date AS alquiler,
        r.return_date AS devolucion,
        a.address AS tienda,
        p.amount AS pago
	FROM
		customer c 
	JOIN 
		rental r ON c.customer_id = r.customer_id
	JOIN
		inventory i ON r.inventory_id = i.inventory_id
	JOIN 
		film f ON f.film_id = i.film_id
	JOIN 
		store s ON s.manager_staff_id = r.staff_id
	JOIN
		address a ON s.address_id = a.address_id
	JOIN
		payment p ON p.rental_id = r.rental_id;
	
SELECT * FROM vista_resumen_alquileres;
*/		
        
        
        
        
        
	