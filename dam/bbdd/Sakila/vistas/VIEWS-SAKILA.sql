-- Práctica - Vistas
-- USE sakila;
-- Enunciado: Crea una vista que muestre todos los campos de la tabla film.
/*
CREATE VIEW
	film_view AS
		SELECT 
			*
		FROM 
			film;
*/
-- Enunciado: Crea una vista que muestre solo el film_id, title, y release_year de la tabla film.
/*
CREATE VIEW
	film_lessInfo AS
		SELECT
			film_id,
			title,
			release_year
		FROM
			film;
*/
-- Enunciado: Crea una vista que muestre solo las películas (film) que tienen una calificación (rating) de 'PG'.
/*
CREATE VIEW
	film_pg_rating AS
		SELECT 
			title, 
			rating
		FROM
			film
		WHERE 
			rating = 'PG';
*/
-- ESTA NO: Crea una vista que muestre el title de la película, el name del actor y el role del actor en esa película. Para esto, necesitarás unir las tablas film, film_actor, y actor.
-- Enunciado: Crea una vista que muestre el número total de películas (film) por cada categoría (category).
/*
CREATE VIEW
	film_total_by_category AS
		SELECT
			COUNT(fc.film_id) AS total_peliculas,
			c.name AS categoria
		FROM 
			film_category fc
		JOIN
			category c ON c.category_id = fc.category_id
		GROUP BY
			2;
*/
-- Enunciado: Crea una vista que muestre las películas que tienen un costo de reemplazo (replacement_cost) mayor que el promedio de todos los costos de reemplazo.
/*
CREATE VIEW
	film_high_replacement_cost AS
		SELECT 
			*
		FROM
			film
		WHERE
			replacement_cost > (
				SELECT 
					AVG(replacement_cost) 
				FROM
					film);
*/
-- Enunciado: Crea una vista que muestre el title de la película en mayúsculas y el description de la película en minúsculas.
/*
CREATE VIEW 
	film_mayus_minus AS
		SELECT
			UCASE(title),
			LCASE(description)
		FROM
			film;
*/			
-- Enunciado: Crea una vista que muestre una lista combinada de todos los actores (actor) y todos los clientes (customer).
/*CREATE VIEW 
	actor_customer AS
*/		SELECT 
			first_name
		FROM
			actor
		UNION
		SELECT 
			first_name
		FROM
			customer;

-- Enunciado: Crea una vista que muestre el title de la película y el número de actores en esa película, ordenado por el número de actores en orden descendente.
-- Enunciado: Crea una vista materializada que almacene el número total de alquileres (rental) por cada tienda (store).
