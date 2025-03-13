
USE ClientePedido;
/*
-- 1. Borrar los clientes en cascada
SELECT * FROM cliente;
SELECT * FROM pedido;
DELETE FROM cliente WHERE id_cliente = 1;
SELECT * FROM cliente;
SELECT * FROM pedido;

-- 2. Actualizar los clientes en cascada
UPDATE cliente SET id_cliente = 3000 WHERE id_cliente = 2;
SELECT * FROM pedido;

-- 3. Realizar una consulta con disticnt
SELECT DISTINCT c.pais FROM cliente c;

-- Vista de cuantos pedidos tiene cada cliente
CREATE VIEW pedidos_cliente AS
	SELECT 
		c.nombre AS cliente,
        COUNT(p.id_cliente) AS pedidos
	FROM
		cliente c 
	JOIN 
		pedido p ON c.id_cliente = p.id_cliente
	GROUP BY
		p.id_cliente
	ORDER BY
		2 DESC;

-- Añadir varios pedidos por cliente
INSERT INTO pedido (id_producto, id_cliente, fecha_pedido, total) VALUES
    (1, 1, '2024-09-05', 250.75),
    (2, 1, '2024-07-06', 250.75),
    (3, 1, '2024-07-08', 250.75),
    (4, 2, '2024-05-02', 250.75),
    (5, 2, '2024-04-01', 250.75),
    (6, 2, '2024-09-07', 250.75),
    (7, 3, '2024-06-11', 250.75),
    (8, 3, '2024-02-10', 250.75),
    (9, 3, '2024-01-09', 250.75);
SELECT * FROM pedidos_cliente;

-- Intervalo de fechas fijo
SELECT fecha_pedido 
FROM pedido
WHERE fecha_pedido BETWEEN '2020-01-01' AND '2026-01-01'; 

-- Intervalo de fechas variable
SELECT fecha_pedido 
FROM pedido
WHERE fecha_pedido BETWEEN '2020-01-01' AND curdate(); 

-- Insertar timestamp en pedidos
ALTER TABLE pedido 
ADD fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

SELECT * FROM pedido;
*/
-- Sacar las fechas por meses
SELECT 
	fecha_pedido AS fecha,
    MONTHNAME(fecha_pedido) AS mes
FROM pedido;

/*
SELECT 
	fecha_pedido,
CASE
	WHEN fecha_pedido LIKE '%-01-%' THEN 'Enero'
    WHEN fecha_pedido LIKE '%-02-%' THEN 'Febrero'
    WHEN fecha_pedido LIKE '%-03-%' THEN 'Marzo'
    WHEN fecha_pedido LIKE '%-04-%' THEN 'Abril'
    WHEN fecha_pedido LIKE '%-05-%' THEN 'Mayo'
    WHEN fecha_pedido LIKE '%-06-%' THEN 'Junio'
    WHEN fecha_pedido LIKE '%-07-%' THEN 'Julio'
    WHEN fecha_pedido LIKE '%-08-%' THEN 'Agosto'
    WHEN fecha_pedido LIKE '%-09-%' THEN 'Septiembre'
    WHEN fecha_pedido LIKE '%-10-%' THEN 'Octubre'
    WHEN fecha_pedido LIKE '%-11-%' THEN 'Noviembre'
    WHEN fecha_pedido LIKE'%-12-%' THEN 'Diciembre'
    ELSE 'Ha habido un problema'
FROM 
	pedido;
*/