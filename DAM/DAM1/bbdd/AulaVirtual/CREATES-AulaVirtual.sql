/*
CREATE DATABASE AulaVirtual;
USE AulaVirtual; 

CREATE TABLE comentario (
	id_comentario int PRIMARY KEY AUTO_INCREMENT,
    autor VARCHAR(50),
    f_publicacion DATE,
    texto VARCHAR(255)
);

CREATE TABLE articulo (
	id_articulo int PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(250),
    autor VARCHAR(50),
    f_publicacion DATE,
    id_coment int,
    FOREIGN KEY (id_coment) REFERENCES comentario(id_comentario)
);

CREATE TABLE art_ciberseguridad (
	id_art_ciberseguridad int,
    FOREIGN KEY (id_art_ciberseguridad) REFERENCES articulo(id_articulo),
    cve VARCHAR(13)
);

CREATE TABLE art_contrasenia (
	id_art_contrasenia int,
    FOREIGN KEY (id_art_contrasenia) REFERENCES articulo(id_articulo)
);

CREATE TABLE evaluacion (
	id_evaluacion int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20)
);

CREATE TABLE curso (
	id_curso int PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    dificultad VARCHAR(20),
    duracion TIME,
    compuesto int,
	FOREIGN KEY (compuesto) REFERENCES curso(id_curso),  
	id_evaluacion_curso int,
    FOREIGN KEY (id_evaluacion_curso) REFERENCES evaluacion(id_evaluacion)
);

CREATE TABLE tipo_suscripcion (
	id_tipo_suscripcion INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(20)
);

CREATE TABLE suscripcion (
	id_suscripcion INT PRIMARY KEY AUTO_INCREMENT,
    precio FLOAT,
    tipo int,
    FOREIGN KEY (tipo) REFERENCES tipo_suscripcion(id_tipo_suscripcion)
);

CREATE TABLE usuario (
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(20),
    apellido_1 VARCHAR(20),
    apellido_2 VARCHAR(20),
    telefono INT,
    ciudad VARCHAR(255),
    dni VARCHAR(9),
    email VARCHAR(30)
);

CREATE TABLE profesor (
	id_profesor INT,
    FOREIGN KEY (id_profesor) REFERENCES usuario(id_usuario)
);

CREATE TABLE alumno (
	id_alumno INT,
    FOREIGN KEY (id_alumno) REFERENCES usuario(id_usuario)
);

CREATE TABLE articulo_usuario (
	id_articulo_articulo_usuario int,
    id_usuario_articulo_usuario int,
    FOREIGN KEY (id_articulo_articulo_usuario) REFERENCES articulo(id_articulo),
    FOREIGN KEY (id_usuario_articulo_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE curso_profesor (
	id_curso_curso_profesor INT,
    id_profesor_curso_profesor INT,
    FOREIGN KEY (id_profesor_curso_profesor) REFERENCES profesor(id_profesor),
    FOREIGN KEY (id_curso_curso_profesor) REFERENCES curso(id_curso),
    f_publicacion DATE
);

CREATE TABLE alumno_curso (
	id_alumno_alumno_curso INT,
    id_curso_alumno_curso INT,
    FOREIGN KEY (id_alumno_alumno_curso) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_curso_alumno_curso) REFERENCES curso(id_curso)
);

CREATE TABLE alumno_evaluacion (
	id_alumno_alumno_evaluacion int,
    id_evaluacion_alumno_evaluacion int,
    FOREIGN KEY (id_alumno_alumno_evaluacion) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_evaluacion_alumno_evaluacion) REFERENCES evaluacion(id_evaluacion),
    intentos int
);

CREATE TABLE contrato (
	id_contrato int PRIMARY KEY AUTO_INCREMENT,
    f_inicio DATE,
    f_fin DATE,
    id_usuario_contrato INT,
    FOREIGN KEY (id_usuario_contrato) REFERENCES usuario(id_usuario),
    id_suscripcion_contrato INT,
    FOREIGN KEY (id_suscripcion_contrato) REFERENCES suscripcion(id_suscripcion)
);
*/