-- Ejercicio 1
SELECT
	DISTINCT *
FROM
	(SELECT 
		c.customer_id,
		c.first_name,
		c.last_name,
		c.email,
		a.address,
		ci.city AS ciudad
	FROM
		customer c
	JOIN
		address a ON a.address_id = c.address_id
	JOIN
		city ci ON a.city_id = ci.city_id
	JOIN 
		rental r ON c.customer_id = r.customer_id
	JOIN
		inventory i ON i.inventory_id = r.inventory_id
	JOIN
		film_category fc ON fc.film_id = i.film_id
	JOIN
		category ca ON ca.category_id = fc.category_id
	WHERE 
		ca.name LIKE 'Action') as sub
WHERE
	sub.ciudad LIKE 'London';


-- Ejercicio 2
SELECT
	f.film_id,
	f.title,
	f.description,
	c.name
FROM
	film f
JOIN
	film_category fc ON f.film_id = fc.film_id
JOIN
	category c ON fc.category_id = c.category_id
WHERE
	(f.film_id IN (
				SELECT 
					i.film_id
				FROM
					rental r 
				JOIN 
					inventory i ON i.inventory_id = r.inventory_id
				GROUP BY 
					1
				HAVING
					COUNT(r.inventory_id) > 10))
	AND (c.name LIKE 'Drama');
