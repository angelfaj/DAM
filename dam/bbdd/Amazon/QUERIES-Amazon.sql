/*USE Amazon;
-- 1. Obtener la cantidad de veces que se han vendido los productos.
SELECT 
	p.nombre, 
    SUM(dp.cantidad) AS veces_comprado 
FROM 
	producto p 
JOIN
	detalle_pedido dp ON p.id_producto = dp.id_producto_detalle 
GROUP BY 
	dp.id_producto_detalle 
ORDER BY 
	SUM(dp.cantidad) DESC;

-- 2. Obtener el total de ventas por cliente (solo aquellos que han realizado más de 3 pedidos.
SELECT 
	c.nombre,
    c.correo, 
    SUM(p.total) as total_gastado 
FROM 
	cliente c
JOIN pedido p ON c.id_cliente = p.id_cliente_pedido
GROUP BY p.id_cliente_pedido HAVING COUNT(p.id_cliente_pedido) > 3 ORDER BY SUM(p.total) DESC;

-- 3. Obtener el total de ingresos por cada categoría de producto.
SELECT p.categoria, SUM(dp.cantidad * dp.precio_unitario) as ingresos FROM producto p
JOIN detalle_pedido dp on p.id_producto = dp.id_producto_detalle 
GROUP BY p.categoria ORDER BY SUM(dp.cantidad * dp.precio_unitario) DESC;

-- 4. Obtener los productos que han recibido más de 5 comentarios, con su promedio de calificación.
SELECT p.nombre, count(c.id_producto_comentario) as numero_comentarios FROM producto p
JOIN comentario c ON p.id_producto = c.id_producto_comentario GROUP BY c.id_producto_comentario HAVING count(c.comentario) > 1; 

-- 5. Obtener los 2 clientes que más han gastado en total (por la suma de todos sus pedidos.
SELECT c.nombre, c.correo, sum(p.total) as total_gastado FROM cliente c 
JOIN pedido p ON c.id_cliente = p.id_cliente_pedido 
GROUP BY 1, 2 ORDER BY  3 DESC LIMIT 2;

-- 6. Obtener los productos que no han sido comprados en ningún pedido.
SELECT p.nombre as producto_no_vendido FROM producto p 
LEFT JOIN detalle_pedido dp ON p.id_producto = dp.id_producto_detalle 
where dp.id_pedido_detalle IS NULL;

-- 7. Obtener el cliente que ha realizado el pedido con el total más alto.
SELECT c.nombre, c.correo, MAX(p.total) as pedido_mas_caro FROM cliente c
join pedido p on c.id_cliente = p.id_cliente_pedido GROUP BY 1, 2 ORDER BY 3 DESC LIMIT 1;

-- 8. Obtener los productos más comprados por cada cliente (por cantidad total en sus pedidos.

SELECT 
    c.nombre AS cliente,            
    p.nombre AS producto,           
    SUM(dp.cantidad) AS cantidad_total 
FROM 
    cliente c
JOIN 
    pedido pd ON c.id_cliente = pd.id_cliente_pedido 
JOIN 
    detalle_pedido dp ON pd.id_pedido = dp.id_pedido_detalle 
JOIN 
    producto p ON dp.id_producto_detalle = p.id_producto 
GROUP BY 
    c.id_cliente,                  
    p.id_producto                  
HAVING 
    SUM(dp.cantidad) = (           						-- Filtramos para encontrar solo el producto más comprado por cada cliente
        SELECT 
            MAX(total_cantidad)   						-- Obtenemos el máximo total de un producto específico por cliente
        FROM (
            SELECT 
                dp.id_producto_detalle,             
                SUM(dp.cantidad) AS total_cantidad  	-- Calculamos el total de cada producto por cliente
            FROM 
                detalle_pedido dp
            JOIN 
                pedido pd ON dp.id_pedido_detalle = pd.id_pedido 
            WHERE 
                pd.id_cliente_pedido = c.id_cliente 
            GROUP BY 
                dp.id_producto_detalle             
        ) AS subquery                              
    )
ORDER BY 
    c.nombre,                     
    cantidad_total DESC;           

-- 9. Obtener el número de productos vendidos por cada pedido.
SELECT 
	dp.id_pedido_detalle AS pedido,
    SUM(dp.cantidad) AS vendidos
FROM 
	producto p
JOIN 
	detalle_pedido dp ON p.id_producto = dp.id_producto_detalle
GROUP BY 
	1
ORDER BY 
	1 ASC;

-- 10. Obtener el ingreso total generado por cada método de pago
SELECT
	p.metodo_pago AS metodo,
    sum(p.cantidad) AS ingresado
FROM
	pago p
GROUP BY 
	metodo
ORDER BY
	ingresado DESC;
  
-- 11. Obtener el nombre del producto más vendido.
SELECT 
	p.nombre AS producto
FROM 
	producto p
JOIN
	detalle_pedido dp ON p.id_producto = dp.id_producto_detalle
GROUP BY 
	producto
ORDER BY
	SUM(dp.cantidad) DESC LIMIT 1;

*/
-- 12. Obtener los clientes que han gastado más que el promedio total de gastos de todos los clientes.
SELECT 
	c.nombre AS cliente,
    SUM(p.total) AS total_gastado
FROM
	cliente c
JOIN 
	pedido p ON c.id_cliente = p.id_cliente_pedido
WHERE 
	p.estado != 'Cancelado'
GROUP BY
	c.id_cliente
HAVING 										-- Mostramos los totales > que la media
	SUM(p.total) > (
		SELECT 
			AVG(gasto_total) 				-- Media sobre el total gastado
		FROM (
			SELECT 							-- Total gastado x cliente
				SUM(p.total) AS gasto_total
			FROM 
				pedido p
			GROUP BY 
				p.id_cliente_pedido
		) AS subconsulta
	) 
ORDER BY 
	total_gastado DESC;
/*
-- 13. Obtener los nombres de los clientes que han realizado pedidos con un total superior a 500.
SELECT
	c.nombre AS cliente
FROM
	cliente c
JOIN 
	pedido p ON c.id_cliente = p.id_cliente_pedido
WHERE 
	p.total > 500
GROUP BY 
	1;

-- 14. Obtener los productos con un precio mayor al promedio de los precios de todos los productos.
SELECT
	p.nombre AS producto,
    p.precio AS precio
FROM
	producto p
WHERE
	p.precio > (
		SELECT 
			AVG(p.precio) 
		FROM 
			producto p
		) 
ORDER BY
	2 DESC;

-- 15. Obtener los clientes que han realizado el pedido más caro.
SELECT 
	c.nombre AS cliente,
    p.total AS total_pedido
FROM
	cliente c
JOIN
	pedido p ON c.id_cliente = p.id_cliente_pedido
ORDER BY
	2 DESC LIMIT 3;
*/