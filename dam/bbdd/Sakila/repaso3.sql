CREATE VIEW nombre_vista AS
	SELECT * FROM tabla;

CREATE INDEX nombre_index ON tabla(columna1, columna2);



DROP TRIGGER IF EXISTS nombre_trigger;
DELIMITER //
CREATE TRIGGER nombre_trigger
BEFORE INSERT ON tabla
FOR EACH ROW
	IF new.nota > 10 then
		set new.nota = 10;
	ELSEIF new.nota < 0 then
		set new.nota = 0;
	END IF;
BEGIN
END//
DELIMITER ;


CREATE TABLE tabla (
	tabla_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nombre_id TINYINT UNSIGNED,
    FOREIGN KEY tabla(nombre) REFERENCES tabla2(nombre)
);
 
INSERT INTO tabla(columna1, columna2) VALUES ('dato1', 'dato2');

UPDATE tabla SET columna1 = 'nuevoDATO1', columna2 = 'nuevodato2' WHERE condicion;

DELETE FROM tabla WHERE columna1 = 'algo';
    
    
    
    
    