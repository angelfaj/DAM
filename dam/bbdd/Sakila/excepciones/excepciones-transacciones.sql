-- procedimiento para capturar excepciones y realizar las gestiones sobre una transaccion
DELIMITER //
CREATE PROCEDURE error_handler()
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
		SELECT 'Ocurrio un error, ejecutando rollback' AS MESSAGE;
        ROLLBACK;
    END;
    
    DECLARE CONTINUE HANDLER FOR SQLWARNING
    BEGIN
		SELECT 'Ocurrio una advertencia, ejecutando rollback' AS MESSAGE;
        ROLLBACK;
    END;
    
    START TRANSACTION;
    INSERT INTO actor VALUES (1, 'paco', 'perez', NOW());
    INSERT INTO actor (first_name, last_name, last_update) VALUES ('paco', 'perez', NOW());
    COMMIT;
    
END//
DELIMITER ;
