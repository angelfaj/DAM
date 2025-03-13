-- Obtener una lista de clientes que han alquilado peliculas que han durado mas de 120 mins y pertenecen a comedy
SELECT 
	r.customer_id
FROM
	rental r
JOIN 
	inventory i ON r.inventory_id = i.inventory_id
JOIN
	film f ON i.film_id = f.film_id
WHERE
	f.film_id IN (
			SELECT 
				fc.film_id
			FROM
				film_category fc
			JOIN
				category c ON fc.category_id = c.category_id
			WHERE 
				(c.name LIKE 'comedy') AND (f.length > 120))
GROUP BY 
	1
ORDER BY 
	1 ASC;


-- Obtener una lista de tiendas que han alquilado peliculas que tienen un costo de reemplazo mayor a 20 y pertenecen a la categoria Sci-Fy
/*store_id, managerstaff_id, addres_id, address, city
subconsulta con 2 condiciones y la padre añade atributos*/
SELECT 
	s.store_id,
	s.manager_staff_id,
	a.address_id,
	a.address,
	ci.city
FROM
	store s
JOIN
	address a ON s.address_id = a.address_id
JOIN 
	city ci ON a.city_id = ci.city_id
JOIN 
	inventory i ON s.store_id = i.store_id
JOIN 
	rental r ON r.inventory_id = i.inventory_id
WHERE
	i.film_id IN (
			SELECT
				f.film_id
			FROM
				film f
			JOIN 
				film_category fc ON f.film_id = fc.film_id
			JOIN
				category c ON fc.category_id = c.category_id
			WHERE
				(f.replacement_cost > 20) AND (c.name LIKE 'Sci-Fi'))
GROUP BY
	1;

