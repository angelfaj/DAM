/*
CREATE DATABASE Ajedrez;
USE Ajedrez;

CREATE TABLE Jugadores (
	id_jugador int PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50),
    apellidos varchar(50),
    fecha_nacimiento date,
    pais varchar(50),
    ranking int
);

CREATE TABLE Torneos (
	id_torneo int PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(100),
    fecha_inicio date,
    fecha_fin date,
    lugar varchar(50)
);

CREATE TABLE Partidas (
	id_partida int PRIMARY KEY AUTO_INCREMENT,
    id_jugador_blanco int,
    FOREIGN KEY (id_jugador_blanco) REFERENCES Jugadores(id_jugador),
    id_jugador_negro int,
    FOREIGN KEY (id_jugador_negro) REFERENCES Jugadores(id_jugador),
    nombre varchar(100),
    fecha date,
    resultado varchar(40),
    id_torneo int,
    FOREIGN KEY (id_torneo) REFERENCES Torneos(id_torneo)
);

CREATE TABLE Movimientos (
	id_movimiento int PRIMARY KEY AUTO_INCREMENT,
    id_partida int,
    FOREIGN KEY (id_partida) REFERENCES Partidas(id_partida),
    turno int,
    movimiento varchar(20),
    id_jugador int,
    FOREIGN KEY (id_jugador) REFERENCES Jugadores(id_jugador)
);

CREATE TABLE Categorias (
	id_categoria int PRIMARY KEY AUTO_INCREMENT,
	nombre varchar(20),
    descripcion varchar(120)
);

CREATE TABLE Torneo_Partidas (
	id_torneo int,
    id_partida int,
    FOREIGN KEY (id_partida) REFERENCES Partidas(id_partida),
    FOREIGN KEY (id_torneo) REFERENCES Torneos(id_torneo)
);

CREATE TABLE Estadisticas (
	id_jugador int PRIMARY KEY AUTO_INCREMENT,
    FOREIGN KEY (id_jugador) REFERENCES Jugadores(id_jugador),
    victorias int,
    empates int,
    derrotas int
);
*/
