USE ClientePedido;

INSERT INTO cliente (nombre, apellido, fecha_nacimiento, correo, pais, direccion) VALUES 
    ('Laura', 'Perez', '1990-02-02', 'lauraperez@mail.com', 'España', 'Calle laurel 2, Madrid'),
    ('Carlos', 'Gomez', '1985-06-15', 'carlosgomez@mail.com', 'España', 'Avenida del Sol 10, Barcelona'),
    ('Marta', 'Lopez', '1992-11-22', 'martalopez@mail.com', 'España', 'Calle Luna 5, Valencia'),
    ('Javier', 'Fernandez', '1988-03-08', 'javierfernandez@mail.com', 'España', 'Paseo de la Castellana 20, Madrid'),
    ('Ana', 'Sanchez', '1995-09-30', 'anasanchez@mail.com', 'España', 'Calle Mayor 15, Sevilla'),
    ('David', 'Martinez', '1980-07-12', 'davidmartinez@mail.com', 'España', 'Gran Vía 8, Bilbao'),
    ('Isabel', 'Ruiz', '1993-05-25', 'isabelruiz@mail.com', 'España', 'Calle del Río 3, Zaragoza'),
    ('Sergio', 'Torres', '1987-01-19', 'sergiotorres@mail.com', 'España', 'Avenida Libertad 12, Málaga'),
    ('Patricia', 'Ramirez', '1991-08-05', 'patriciaramirez@mail.com', 'España', 'Calle Primavera 7, Murcia'),
    ('Alejandro', 'Hernandez', '1984-12-10', 'alejandrohernandez@mail.com', 'España', 'Paseo del Mar 22, Alicante');

INSERT INTO producto (nombre, stock, precio) VALUES 
	('Zapatillas XE', 50, 30.99),
    ('Camiseta Sport', 100, 15.50),
    ('Pantalón Deportivo', 75, 25.99),
    ('Sudadera Running', 60, 40.00),
    ('Mochila Trekking', 30, 55.75),
    ('Reloj Inteligente', 20, 120.49),
    ('Auriculares Bluetooth', 45, 35.99),
    ('Balón de Fútbol', 80, 22.50),
    ('Gafas de Sol Deportivas', 25, 18.75),
    ('Guantes de Ciclismo', 90, 12.99);
    
INSERT INTO pedido (id_producto, id_cliente, fecha_pedido, total) VALUES
    (1, 1, '2024-04-05', 250.75),
    (2, 2, '2023-04-05', 150.75),
    (3, 3, '2023-04-10', 220.40),
    (4, 4, '2023-04-15', 500.90),
    (5, 5, '2023-04-20', 320.00),
    (6, 6, '2023-04-25', 410.30),
    (7, 7, '2023-04-30', 275.25),
    (8, 8, '2023-05-05', 199.99),
    (9, 9, '2023-05-10', 350.80),
    (10, 10, '2023-05-15', 420.50);
