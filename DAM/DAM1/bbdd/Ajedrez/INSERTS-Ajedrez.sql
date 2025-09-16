/*USE Ajedrez;

INSERT INTO Jugadores (nombre, apellidos, fecha_nacimiento, pais, ranking) 
VALUES
 ('Magnus', 'Carlsen', '1990-11-30', 'Noruega', 1),
 ('Fabiano', 'Caruana', '1992-07-30', 'EE.UU', 2),
 ('Levon', 'Aronian', '1982-10-06', 'Armenia', 3);

INSERT INTO Torneos (nombre, fecha_inicio, fecha_fin, lugar) 
VALUES
 ('Torneo Internacional de Ajedrez', '2024-05-03', '2024-05-15', 'Madrid'),
 ('Campeonato Mundial de Ajedrez', '2024-11-01', '2024-11-20', 'Dubai');

INSERT INTO Partidas (id_jugador_blanco, id_jugador_negro, fecha, resultado, id_torneo) 
VALUES
 ('1', '2', '2024-05-03', 'blanco', 1),
 ('2', '3', '2024-05-04', 'empate', 1),
 ('3', '1', '2024-11-02', 'negro', 2);
 
 INSERT INTO Movimientos (id_partida, turno, movimiento, id_jugador) 
VALUES
 (1, 1, 'e2-e4', 1),
 (1, 2, 'e7-e5', 2),
 (1, 3, 'g1-f3', 1),
 (1, 4, 'b8-c6', 2);
 
 INSERT INTO Categorias (nombre, descripcion) 
VALUES
 ('Abierto', 'Torneo para jugadores de cualquier edad.'),
 ('Femenino', 'Torneo exclusivamente para jugadoras.'),
 ('Abierto', 'Torneo para jugadores menores de 18 años.');

 INSERT INTO Torneo_Partidas (id_torneo, id_partida) 
VALUES
 (1, 1),
 (1, 2),
 (2, 3);
 
 INSERT INTO Estadisticas (victorias, empates, derrotas) 
VALUES
 (10, 5, 3),
 (8, 7, 3),
 (12, 3, 4);
 */