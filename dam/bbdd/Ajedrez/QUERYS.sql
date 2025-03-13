-- USE Ajedrez;
/*
SELECT
 Torneos.nombre AS Torneo,
 Jugadores.nombre, Jugadores.apellidos, 
 Partidas.fecha, Partidas.resultado 
FROM Partidas 
JOIN 
	Torneos ON Torneos.id_torneo = Partidas.id_torneo 
JOIN 
	Jugadores ON Partidas.id_jugador_blanco = Jugadores.id_jugador 
WHERE Jugadores.nombre = 'Magnus' AND Torneos.nombre = 'Torneo Internacional de Ajedrez';
*/
/*
SELECT
 Torneos.nombre AS Torneo,
 J1.nombre AS jugador_blanco,
 J2.nombre AS jugador_negro,
 Partidas.fecha, Partidas.resultado 
FROM Partidas 
JOIN Torneos ON Torneos.id_torneo = Partidas.id_torneo 
JOIN 
	Jugadores J1 ON Partidas.id_jugador_blanco = J1.id_jugador 
JOIN
    Jugadores J2 ON Partidas.id_jugador_negro = J2.id_jugador 
WHERE 'Magnus' IN (J1.nombre, J2.nombre) AND Torneos.nombre = 'Torneo Internacional de Ajedrez';
*/

SELECT
 Torneos.nombre AS Torneo,
 Jugadores.nombre, Jugadores.apellidos, 
 Partidas.fecha, Partidas.resultado 
FROM Partidas 
JOIN 
	Torneos ON Torneos.id_torneo = Partidas.id_torneo 
JOIN 
	Jugadores ON Partidas.id_jugador_blanco = Jugadores.id_jugador 
WHERE Jugadores.nombre = 'Magnus' AND Torneos.nombre = 'Torneo Internacional de Ajedrez';