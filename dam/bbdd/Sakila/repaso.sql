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


