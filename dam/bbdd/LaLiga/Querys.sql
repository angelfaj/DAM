/*USE LaLiga;
INSERT INTO `LaLiga`.`EQUIPO` (nombre, anio_fundacion, estadio, poblacion, pais) VALUES
('Real Madrid', 1902, 'Santiago Bernabéu', 'Madrid', 'España'),
('Barcelona', 1899, 'Camp Nou', 'Barcelona', 'España'),
('Atlético de Madrid', 1903, 'Wanda Metropolitano', 'Madrid', 'España'),
('Sevilla', 1905, 'Ramón Sánchez-Pizjuán', 'Sevilla', 'España'),
('Valencia', 1919, 'Mestalla', 'Valencia', 'España'),
('Real Betis', 1907, 'Benito Villamarín', 'Sevilla', 'España'),
('Villarreal', 1923, 'Estadio de la Cerámica', 'Villarreal', 'España'),
('Real Sociedad', 1909, 'Anoeta', 'San Sebastián', 'España'),
('Athletic Club', 1898, 'San Mamés', 'Bilbao', 'España'),
('Granada', 1931, 'Nuevo Los Cármenes', 'Granada', 'España'),
('Osasuna', 1920, 'El Sadar', 'Pamplona', 'España'),
('Celta Vigo', 1923, 'Balaídos', 'Vigo', 'España'),
('Espanyol', 1900, 'RCDE Stadium', 'Barcelona', 'España'),
('Getafe', 1983, 'Coliseum Alfonso Pérez', 'Getafe', 'España'),
('Alavés', 1921, 'Mendizorroza', 'Vitoria-Gasteiz', 'España'),
('Mallorca', 1916, 'Son Moix', 'Palma', 'España'),
('Elche', 1923, 'Martínez Valero', 'Elche', 'España'),
('Cádiz', 1910, 'Nuevo Mirandilla', 'Cádiz', 'España'),
('Levante', 1909, 'Ciudad de Valencia', 'Valencia', 'España'),
('Rayo Vallecano', 1924, 'Estadio de Vallecas', 'Madrid', 'España');



INSERT INTO `LaLiga`.`JUGADOR` (nombre, primer_apellido, segundo_apellido, fecha_nacimiento, nacionalidad_principal, nacionalidad_secundaria, posicion, equipo, dorsal, valor_mercado) VALUES
('Karim', 'Benzema', NULL, '1987-12-19', 'Francia', NULL, 'Delantero', 1, 9, 40000000),
('Lionel', 'Messi', NULL, '1987-06-24', 'Argentina', 'España', 'Delantero', 2, 10, 100000000),
('Jan', 'Oblak', NULL, '1993-01-07', 'Eslovenia', NULL, 'Portero', 3, 13, 60000000),
('Ivan', 'Rakitic', NULL, '1988-03-10', 'Croacia', NULL, 'Mediocentro', 4, 10, 15000000),
('Carlos', 'Soler', NULL, '1997-01-02', 'España', NULL, 'Mediocentro', 5, 8, 40000000),
('Nabil', 'Fekir', NULL, '1993-07-18', 'Francia', 'Argelia', 'Mediocentro', 6, 8, 30000000),
('Gerard', 'Moreno', NULL, '1992-04-07', 'España', NULL, 'Delantero', 7, 7, 40000000),
('Mikel', 'Oyarzabal', NULL, '1997-04-21', 'España', NULL, 'Delantero', 8, 10, 50000000),
('Iñaki', 'Williams', NULL, '1994-06-15', 'España', 'Ghana', 'Delantero', 9, 9, 30000000),
('Darwin', 'Machís', NULL, '1993-02-07', 'Venezuela', NULL, 'Delantero', 10, 11, 15000000),
('Roberto', 'Torres', NULL, '1989-03-07', 'España', NULL, 'Mediocentro', 11, 10, 10000000),
('Iago', 'Aspas', NULL, '1987-08-01', 'España', NULL, 'Delantero', 12, 10, 5000000),
('Raúl', 'de Tomás', NULL, '1994-10-17', 'España', NULL, 'Delantero', 13, 11, 25000000),
('Mauro', 'Arambarri', NULL, '1995-09-30', 'Uruguay', NULL, 'Mediocentro', 14, 8, 20000000),
('Joselu', 'Mato', NULL, '1990-03-27', 'España', NULL, 'Delantero', 15, 9, 15000000),
('Kang-in', 'Lee', NULL, '2001-02-19', 'Corea del Sur', NULL, 'Mediocentro', 16, 10, 20000000),
('Fidel', 'García', NULL, '1989-10-27', 'España', NULL, 'Extremo', 17, 16, 10000000),
('Álvaro', 'Negredo', NULL, '1985-08-20', 'España', NULL, 'Delantero', 18, 9, 5000000),
('José', 'Campaña', NULL, '1993-05-31', 'España', NULL, 'Mediocentro', 19, 24, 15000000),
('Radamel', 'Falcao', NULL, '1986-02-10', 'Colombia', NULL, 'Delantero', 20, 3, 4000000);



INSERT INTO `LaLiga`.`TEMPORADA` (anio, fecha_inicio, fecha_fin, ganador) VALUES
('2023/2024', '2023-08-11', '2024-05-26', 1),
('2022/2023', '2022-08-12', '2023-06-04', 2),
('2021/2022', '2021-08-13', '2022-05-22', 1),
('2020/2021', '2020-09-12', '2021-05-23', 3),
('2019/2020', '2019-08-16', '2020-07-19', 2),
('2018/2019', '2018-08-17', '2019-05-19', 1),
('2017/2018', '2017-08-18', '2018-05-20', 2),
('2016/2017', '2016-08-19', '2017-05-21', 1),
('2015/2016', '2015-08-21', '2016-05-22', 3),
('2014/2015', '2014-08-22', '2015-05-23', 2);



INSERT INTO `LaLiga`.`PARTIDO` (equipo_local, equipo_visitante, fecha_partido, goles_local, goles_visitante, temporada) VALUES
(1, 2, '2024-01-15 20:00:00', 2, 1, 2024),
(3, 4, '2024-01-20 18:00:00', 1, 1, 2024),
(5, 6, '2024-01-21 18:00:00', 0, 2, 2024),
(7, 8, '2024-01-22 21:00:00', 3, 3, 2024),
(9, 10, '2024-01-23 17:00:00', 2, 0, 2024),
(11, 12, '2024-01-24 20:00:00', 1, 1, 2024),
(13, 14, '2024-01-25 19:00:00', 0, 1, 2024),
(15, 16, '2024-01-26 21:30:00', 2, 2, 2024),
(17, 18, '2024-01-27 16:00:00', 1, 0, 2024),
(19, 20, '2024-01-28 18:30:00', 1, 2, 2024);



INSERT INTO `LaLiga`.`ENTRENADOR` (nombre, primer_apellido, segundo_apellido, nacionalidad, equipo) VALUES
('Carlo', 'Ancelotti', NULL, 'Italia', 1),
('Xavi', 'Hernández', NULL, 'España', 2),
('Diego', 'Simeone', NULL, 'Argentina', 3),
('Jorge', 'Sampaoli', NULL, 'Argentina', 4),
('Rubén', 'Baraja', NULL, 'España', 5),
('Manuel', 'Pellegrini', NULL, 'Chile', 6),
('Quique', 'Setién', NULL, 'España', 7),
('Imanol', 'Alguacil', NULL, 'España', 8),
('Ernesto', 'Valverde', NULL, 'España', 9),
('Paco', 'López', NULL, 'España', 10);





INSERT INTO `LaLiga`.`CLASIFICACION` (equipo, temporada, posicion, puntos, goles_marcados, goles_encajados) VALUES
(1, 1, 1, 87, 80, 30),
(2, 1, 2, 84, 78, 33),
(3, 1, 3, 76, 70, 36),
(4, 1, 4, 68, 60, 45),
(5, 1, 5, 62, 55, 40),
(6, 1, 6, 58, 53, 47),
(7, 1, 7, 54, 48, 42),
(8, 1, 8, 52, 46, 44),
(9, 1, 9, 49, 40, 46),
(10, 1, 10, 46, 38, 48),
(11, 1, 11, 44, 36, 50),
(12, 1, 12, 42, 34, 52),
(13, 1, 13, 40, 32, 54),
(14, 1, 14, 38, 30, 56),
(15, 1, 15, 36, 28, 58),
(16, 1, 16, 34, 26, 60),
(17, 1, 17, 32, 24, 62),
(18, 1, 18, 30, 22, 64),
(19, 1, 19, 28, 20, 66),
(20, 1, 20, 26, 18, 68);




INSERT INTO `LaLiga`.`ESTADISTICA` (jugador, partido, goles, asistencias, tarjetas_amarillas, tarjetas_rojas, minutos_jugados) VALUES
(1, 1, 1, 0, 0, 0, 90),
(2, 1, 0, 1, 0, 0, 85),
(3, 2, 0, 0, 1, 0, 90),
(4, 2, 0, 1, 0, 0, 88),
(5, 3, 0, 0, 1, 0, 90),
(6, 3, 1, 0, 0, 0, 92),
(7, 4, 2, 1, 0, 0, 90),
(8, 4, 1, 0, 0, 0, 90),
(9, 5, 2, 0, 1, 0, 89),
(10, 5, 0, 1, 0, 0, 90),
(11, 6, 1, 0, 0, 0, 92),
(12, 6, 0, 0, 1, 0, 90),
(13, 7, 0, 1, 0, 0, 87),
(14, 7, 1, 0, 0, 0, 90),
(15, 8, 0, 0, 0, 0, 89),
(16, 8, 2, 1, 1, 0, 92),
(17, 9, 0, 0, 1, 0, 88),
(18, 9, 1, 0, 0, 0, 90),
(19, 10, 0, 0, 1, 0, 89),
(20, 10, 2, 0, 0, 0, 90);
*/
/*
1. Seleccionar todos los equipos
SELECT * FROM EQUIPO;

2. Listar todos los jugadores y sus equipos
SELECT JUGADOR.nombre, EQUIPO.nombre FROM JUGADOR JOIN EQUIPO ON JUGADOR.equipo = EQUIPO.id_equipo;

3. Mostrar los partidos con más de 3 goles en total
SELECT * FROM PARTIDO WHERE goles_local + goles_visitante > 3;

4. Obtener el número total de jugadores en la liga
SELECT count(id_jugador) FROM JUGADOR;

5. Listar los equipos fundados antes del año 1900
SELECT nombre, anio_fundacion FROM EQUIPO WHERE anio_fundacion < 1900;

6. Mostrar los entrenadores y el equipo que entrenan
SELECT ENTRENADOR.nombre, ENTRENADOR.primer_apellido, EQUIPO.nombre FROM ENTRENADOR JOIN EQUIPO ON ENTRENADOR.equipo = EQUIPO.id_equipo;

7. Listar los jugadores con un valor de mercado mayor a 50 millones
SELECT nombre, primer_apellido, valor_mercado FROM JUGADOR WHERE valor_mercado > 50000000;

8. Obtener el promedio de goles por partido en la liga
SELECT ROUND(avg(goles_local + goles_visitante), 2) FROM PARTIDO;

9. Mostrar los 5 jugadores más valiosos
SELECT nombre, primer_apellido FROM JUGADOR ORDER BY valor_mercado DESC LIMIT 5;

10. Contar el número de nacionalidades diferentes de jugadores

11. Mostrar las estadísticas de los jugadores en un partido específico

12. Listar los equipos y la cantidad de jugadores que tienen

13. Mostrar el equipo ganador de una temporada específica

14. Mostrar los partidos jugados por un equipo específico como local

15. Mostrar la posición final de un equipo en una temporada específica

*/







