CREATE DATABASE ClientePedido;
USE ClientePedido;

CREATE TABLE cliente (
	id_cliente int primary key auto_increment,
    nombre varchar(20),
    apellido varchar(20),
    fecha_nacimiento date,
    correo varchar(50),
    pais VARCHAR(20),
    direccion varchar(50)
);

CREATE TABLE producto (
	id_producto int primary key auto_increment,
    nombre varchar(40),
    stock int,
    precio float
);

CREATE TABLE pedido (
	id_pedido int primary key auto_increment,
    id_producto int,
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    id_cliente int,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    fecha_pedido date,
    total float
);