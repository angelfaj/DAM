/*
USE sakila;
-- 1.- Subconsulta en el WHERE para obtener un cliente con el alquiler más caro.
SELECT 
	c.first_name AS nombre,
    p.amount AS alquiler
FROM customer c
JOIN
	payment p
ON 
	p.customer_id = c.customer_id
WHERE 
	(SELECT 
		MAX(p.amount)
	FROM
		payment p)
ORDER BY 
	2 DESC LIMIT 1; 
*/
/*
-- 2.- Subconsulta en el FROM para calcular el total de alquileres por película.
SELECT 
	COUNT(alquiler) AS total_alquileres,
    f.title AS titulo
FROM (
	SELECT
		r.inventory_id AS alquiler
	FROM 
		rental r) AS subconsulta
 JOIN inventory i ON i.inventory_id = alquiler
 JOIN film f ON f.film_id = i.film_id
GROUP BY
	f.title
ORDER BY 
	1 DESC;
*/
/*
-- 3.- Subconsulta en el SELECT para obtener el total de pagos por cliente.
SELECT 
	c.first_name AS nombre,
    (SELECT 
		COUNT(p.payment_id) AS pago_id
	FROM 
		payment p
	WHERE
		p.customer_id = c.customer_id) AS total_pedidos
FROM 
	customer c
ORDER BY
	2 DESC;
*/
/*
-- 4.- Subconsulta en el WHERE para encontrar los actores que participaron en la película con mayor cantidad de alquileres.
SELECT 
	a.first_name AS nombre_actor,
    a.last_name AS apellido_actor,
	f.title AS pelicula
FROM 
	actor a
JOIN
	film_actor fa ON a.actor_id = fa.actor_id
JOIN
	film f ON f.film_id = fa.film_id
WHERE
	f.film_id = (
		SELECT 
			film_id			-- Si utilizamos MAX(veces_alquilada), el WHERE nos devolvera el id_pelicula que sea igual al ese numero maximo.
		FROM (
			SELECT 
				i.film_id,
				COUNT(r.inventory_id) AS veces_alquilada
			FROM 
				inventory i
			JOIN 
				rental r ON r.inventory_id = i.inventory_id
			GROUP BY
				1
			ORDER BY
				2 DESC LIMIT 1
		) AS subconsulta
	);
*/
-- 5.- Subconsulta en el HAVING para obtener categorías con más de 1000 alquileres.
/*
SELECT 
	c.name AS categoria,
	COUNT(r.inventory_id) AS alquileres
FROM
	category c
JOIN
	film_category fc ON fc.category_id = c.category_id 
JOIN 
	inventory i ON i.film_id = fc.film_id
JOIN 
	rental r ON r.inventory_id = i.inventory_id 
GROUP BY
	c.name 
HAVING
	alquileres IN (
		SELECT	
			COUNT(r.rental_id) AS alquileres_por_categoria 
		FROM 
			rental r
		JOIN 
			inventory i ON i.inventory_id = r.inventory_id
		JOIN
			film f ON f.film_id = i.film_id
		JOIN 
			film_category fc ON fc.film_id = i.film_id
		GROUP BY 
			fc.category_id
		HAVING 
			alquileres_por_categoria > 1000) 
ORDER BY 
	2 DESC;	
*/
-- Extra: categorias con mas alquileres que el promedio de las categorias 
/*
SELECT 
	c.name AS categoria,
	COUNT(r.inventory_id) AS alquileres
FROM
	category c
JOIN
	film_category fc ON fc.category_id = c.category_id 
JOIN 
	inventory i ON i.film_id = fc.film_id
JOIN 
	rental r ON r.inventory_id = i.inventory_id 
GROUP BY
	c.name 
HAVING
	alquileres > (
		SELECT 
			AVG(alquileres_por_categoria)
		FROM
			(SELECT	
				fc.category_id AS id,
				COUNT(r.rental_id) AS alquileres_por_categoria 
			FROM 
				rental r
			JOIN 
				inventory i ON i.inventory_id = r.inventory_id
			JOIN
				film f ON f.film_id = i.film_id
			JOIN 
				film_category fc ON fc.film_id = i.film_id
			GROUP BY 
				fc.category_id) AS s )
ORDER BY 
	2 DESC;	
*/
-- 6.- Subconsulta en el WHERE para encontrar clientes que no han realizado ningún pago.
SELECT 
	c.first_name AS nombre,
	c.last_name AS apellido,
	c.email
FROM
	customer c
JOIN
	rental r ON r.customer_id = c.customer_id
WHERE
	r.rental_id = null;
	
-- 7.- Subconsulta en el SELECT para mostrar la cantidad total de alquileres por cada tienda.
-- 8.- Subconsulta en el FROM para mostrar las películas con su cantidad de alquileres,ordenadas.
-- 9.- Subconsulta en el WHERE para obtener clientes que alquilaron películas de una categoríaespecífica.
-- 10.- Subconsulta en el SELECT para mostrar los pagos de clientes junto con su última fechade alquiler.
-- Con DATES:
-- 11.- Subconsulta para obtener los alquileres del mes actual.
-- 12.- Subconsulta para encontrar los pagos realizados en el último año.
-- 13.- Subconsulta para mostrar los clientes que no han alquilado en el último mes.
-- 14.- Subconsulta para encontrar el total de pagos realizados este año.
-- 15.- Subconsulta para obtener las películas alquiladas en el mes actual y su cantidad dealquileres.
/*
-- Calcular los alquileres por encima de la media
SELECT 
	r.rental_id,
    p.amount
FROM 
	rental r
JOIN 
	payment p ON r.rental_id = p.rental_id
WHERE
	p.amount > (
		SELECT 
			AVG(p.amount) 
		FROM 
			payment p)
ORDER BY 
	2 DESC;
*/
/*
-- CLIENTES CON MAS PELIS ALQUILADAS QUE ALGUNOS DE LOS QUE EMPIEZAN POR A
SELECT 
	c.first_name AS nombre,
	COUNT(r.customer_id) AS peliculas_alquiladas
	FROM
		customer c
	JOIN 
		rental r ON c.customer_id = r.customer_id
    GROUP BY 
		c.first_name
	HAVING 
		COUNT(r.customer_id) > ANY (			-- Ojo que la subconsulta devuelva solo una columna para compararlo correctamente
			SELECT 
				COUNT(r.customer_id) AS peliculas_alquiladas
			FROM
				customer c
			JOIN 
				rental r ON c.customer_id = r.customer_id
			WHERE
				c.first_name LIKE "a%"
			GROUP BY 
				c.customer_id
			ORDER BY 
				1 DESC LIMIT 1)
	ORDER BY 
		2 DESC
;
*/
/*
-- Clientes con mas peliculas alquiladas que todos los que empiezan por A
SELECT 
	c.first_name AS nombre,
	COUNT(r.customer_id) AS peliculas_alquiladas
	FROM
		customer c
	JOIN 
		rental r ON c.customer_id = r.customer_id
    GROUP BY 
		c.first_name
	HAVING 
		COUNT(r.customer_id) > ALL (			-- Ojo que la subconsulta devuelva solo una columna para compararlo correctamente
			SELECT 
				COUNT(r.customer_id) AS peliculas_alquiladas
			FROM
				customer c
			JOIN 
				rental r ON c.customer_id = r.customer_id
			WHERE
				c.first_name LIKE "a%"
			GROUP BY 
				c.customer_id
			ORDER BY 
				1 DESC LIMIT 1)
	ORDER BY 
		2 DESC
;
*/
-- las consultas anteriores ANY coge el minimo y devuelve todos los que son mayores, ALL el maximo

/*
-- Actores que no hayan trabajado en peliculas de accion
SELECT
	a.first_name AS actor
FROM 
	actor a
WHERE
	a.actor_id NOT IN (
		SELECT
			fa.actor_id
		FROM
			film_actor fa
		JOIN 
			film_category fc ON fa.film_id = fc.film_id
		JOIN 
			category c ON fc.category_id = c.category_id
		WHERE 
			c.name LIKE "action")
;
*/
/*
-- actores con mas peliculas que el actor con el id 1
SELECT 
	a.first_name AS actor,
    COUNT(fa.actor_id) AS peliculas
FROM 
	actor a
JOIN 
	film_actor fa ON fa.actor_id = a.actor_id
GROUP BY 
	actor
HAVING
	COUNT(fa.actor_id) > (
		SELECT 
			COUNT(*)
		FROM
			film_actor fa
		WHERE 
			fa.actor_id = 1
		GROUP BY
			fa.actor_id)

ORDER BY
	2 DESC
;
*/
/*
-- ACTORES QUE NO HAN TRABAJADO EN PELICULAS CON RATING R
SELECT
	a.first_name AS actor
FROM 
	actor a
JOIN 
	film_actor fa ON fa.actor_id = a.actor_id
WHERE 
	fa.film_id NOT IN (
			SELECT 
			f.film_id
			FROM 
				film f
			WHERE 
				f.rating = "R")
GROUP BY 							-- PODEMOS SUPRIMIR EL GROUP BY POR DISTINCT EN EL SELECT
	actor;
*/
/*
-- LOS CLIENTES QUE HAN VISTO A LOS ACTORES CON ID 1, 4 Y 5 en alguna de las peliculas que han alquilado
SELECT 
	c.first_name AS nombre,
    f.title AS pelicula
FROM
	customer c
JOIN
	rental r ON r.customer_id = c.customer_id
JOIN 
	inventory i ON i.inventory_id = r.inventory_id
JOIN
	film f ON i.film_id = f.film_id
WHERE
	i.film_id IN
			(SELECT 
				 DISTINCT fa.film_id
			FROM
				film_actor fa
			WHERE 
				fa.actor_id = 1 OR fa.actor_id = 4 OR fa.actor_id = 5); -- podemos escribir menos haciendo fa.factor_id IN (1,4,5)
*/
/*
-- nombre y ape y numero de pelis de los clientes que han alquilado mas de 10 pelis sin group by
SELECT
 DISTINCT
 c.first_name AS nombre,
 c.last_name AS apellido,
	(SELECT 
		COUNT(r.customer_id) AS pelis_alquiladas
	FROM 
		rental r
	WHERE 
		r.customer_id = c.customer_id) AS pelis_vistas
FROM 
	customer c
JOIN 
	rental r ON r.customer_id = c.customer_id
HAVING 
	pelis_vistas > 10
ORDER BY
	3 DESC;
*/
-- peliculas con mayor duracion que el promedio de duracion de las peliculas

/* 
SELECT 
	* 
FROM
	sales_by_film_category sbfc ;
*/












