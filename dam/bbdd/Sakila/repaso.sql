-- Repaso
/* 1. Indices
Índices Compuestos:
Crea un índice compuesto en las columnas first_name y last_name de la tabla actor.
USE sakila;
CREATE INDEX actor_names on actor (first_name, last_name);
*/
/*
Crea un índice compuesto en las columnas amount y customer_id de la tabla payment.
CREATE INDEX payment_customer_index ON payment(amount, customer_id);
*/
/*Índice Único:
Crea un índice único en la columna email de la tabla customer para asegurar que no haya
correos electrónicos duplicados.
CREATE UNIQUE INDEX email_index ON customer (email);
*/

/* 2. Vistas
Crea una vista que muestre todos los campos de la tabla film.
CREATE VIEW film_view AS 
	SELECT * FROM film;
*/
/* Crea una vista que muestre las películas que tienen un costo de reemplazo (replacement_cost) mayor que el promedio de todos los costos de reemplazo.
CREATE VIEW bigger_replacement_cost_view AS
	SELECT film_id FROM film WHERE replacement_cost > (SELECT AVG(replacement_cost) FROM film);
*/
/*Crea una vista que muestre una lista combinada de todos los actores (actor) y todos los clientes (customer).*/
/*CREATE VIEW actor_and_customer_view AS
	SELECT a.first_name, a.last_name FROM actor a UNION SELECT c.first_name, c.last_name FROM customer c;
*/

/* 3. TRIGGERS
 trigger que no permita alquilar a customers cuyo nombre no empiece por a, ademas debe mostrar un mensaje y enviar la señal de estado 45000
 */
 /*
 DROP TRIGGER IF EXISTS customer_without_a_cant_rent;
 DELIMITER //
 CREATE TRIGGER customer_without_a_cant_rent 
 BEFORE INSERT ON rental
 FOR EACH ROW
 BEGIN
	DECLARE customer_name VARCHAR(1);
    SET customer_name = (
		SELECT SUBSTRING(first_name, 1, 1) FROM customer WHERE customer_id = new.customer_id);
    
    if !STRCMP(customer_name, 'A') then 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Customer name must start with A';
	end if;
 END//
 DELIMITER ;
 
 INSERT INTO rental (customer_id, inventory_id, staff_id) values (29, 3, 2);
 	SELECT customer_id, first_name FROM customer WHERE SUBSTRING(first_name, 1, 1) like 'A';
 */
 
 /*trigger que controle la insercion en payment para que el amount sea positivo con mismo mensaje que el anterior*/
 /*
 DROP TRIGGER IF EXISTS positive_amount_trigger;
 DELIMITER //
 CREATE TRIGGER positive_amount_trigger
 BEFORE INSERT ON payment
 FOR EACH ROW
 BEGIN
	if new.amount < 0 then 
		signal sqlstate '45000' set MESSAGE_TEXT = 'Amount must be a positive number';
	end if;
 END//
 DELIMITER ;
 
 INSERT INTO payment (customer_id, staff_id, rental_id, amount)
	VALUES (4, 2, 5, -1);
*/

/*trigger que desactive las cuentas con inactividad mayor o igual a seis meses(180dias).*/
/*
DROP TRIGGER IF EXISTS disable_acount_trigger;
DELIMITER //
CREATE TRIGGER disable_acount_trigger
BEFORE UPDATE ON customer
FOR EACH ROW
BEGIN	
    if NOW() - INTERVAL 6 MONTH > old.last_update then
		SET new.active = 0;
	end if;
END//
DELIMITER ;

update customer set last_name='pure' where customer_id = 1;
select * from customer where customer_id = 1;
*/