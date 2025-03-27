-- procedimiento para capturar excepciones y realizar las gestiones sobre una transaccion
/*
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
*/

/*
0 FALSO, 1 TRUE. Los clientes que no haya alquilado peliculas en el ultimo año, lo ponemos en inativo(0)*/
DROP PROCEDURE IF EXISTS inactive_customer;
DELIMITER //
CREATE PROCEDURE inactive_customer()
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
    IF DATEDIFF(NOW(), (SELECT return_date FROM rental)) > 365 THEN
		UPDATE customer SET active = 0 where customer_id = new.customer_id;
	END IF;
    COMMIT;
    
END//
DELIMITER ;
call inactive_customer();
SELECT active from customer;
FOR EACH ROW SELECT DATEDIFF(NOW(), return_date)  FROM rental;


/* rEALIZAR REBAJA DEL 10% A AQUELLAS PELIS NO ALQUILADAS EN LOS 6 ULTIMOS MESES