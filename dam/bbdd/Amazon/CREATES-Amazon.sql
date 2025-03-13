CREATE DATABASE Amazon;
USE Amazon;

CREATE TABLE cliente (
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    correo VARCHAR(50),
    telefono VARCHAR(20),
    direccion VARCHAR(150)
);

CREATE TABLE producto (
	id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    categoria VARCHAR(15),
    precio FLOAT,
    stock INT
);

CREATE TABLE pedido (
	id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente_pedido int, 
    FOREIGN KEY (id_cliente_pedido) REFERENCES cliente(id_cliente),
    fecha DATE,
    estado VARCHAR(15),
    total FLOAT
);

CREATE TABLE detalle_pedido (
	id_detalle INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido_Detalle int,
    id_producto_Detalle int,
    FOREIGN KEY (id_pedido_Detalle ) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto_Detalle) REFERENCES producto(id_producto),
    cantidad INT,
    precio_unitario FLOAT
);

CREATE TABLE pago (
	id_pago INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido_pago INT,
    FOREIGN KEY (id_pedido_pago) REFERENCES pedido(id_pedido),
    metodo_pago VARCHAR(15),
    cantidad FLOAT,
    fecha DATE
);

CREATE TABLE envio (
	id_envio INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido_envio INT,
    FOREIGN KEY (id_pedido_envio) REFERENCES pedido(id_pedido),
    direccion_envio VARCHAR(100),
    fecha_envio DATE,
    estado_envio VARCHAR(15)
);

CREATE TABLE comentario (
	id_comentario INT PRIMARY KEY AUTO_INCREMENT,
	id_cliente_comentario INT,
    id_producto_comentario INT,
    FOREIGN KEY (id_cliente_comentario) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_producto_comentario) REFERENCES producto(id_producto),
    comentario VARCHAR(255),
    fecha_comentario DATE
);