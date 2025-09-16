USE peliculasdb;

-- Crear tabla si no existe
CREATE TABLE IF NOT EXISTS peliculas (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100),
    director VARCHAR(50),
    anio INT,
    duracion INT
);

--Datos de ejemplo
INSERT INTO peliculas (titulo, director, anio, duracion) VALUES
    ('El Padrino', 'Francis Ford Coppola', 1972, 175),
    ('Pulp Fiction', 'Quentin Tarantino', 1994, 154),
    ('El Caballero Oscuro', 'Christopher Nolan', 2008, 152),
    ('Forrest Gump', 'Robert Zemeckis', 1994, 142),
    ('La Lista de Schindler', 'Steven Spielberg', 1993, 195),
    ('El Señor de los Anillos: El Retorno del Rey', 'Peter Jackson', 2003, 201),
    ('Inception', 'Christopher Nolan', 2010, 148),
    ('Titanic', 'James Cameron', 1997, 194),
    ('El Club de la Lucha', 'David Fincher', 1999, 139),
    ('Interestelar', 'Christopher Nolan', 2014, 169);

