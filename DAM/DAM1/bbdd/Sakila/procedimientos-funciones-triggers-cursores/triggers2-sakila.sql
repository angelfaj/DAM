-- Trigger para tabla rental que antes de insertar compruebe si la pelicula esta en stock
DELIMITER //
CREATE TRIGGER stock_film_rental
BEFORE INSERT ON rental
FOR EACH ROW
BEGIN	
    
    if (SELECT count(*) from inventory i
    join rental r on r.inventory_id = i.inventory_id 
    where i.inventory_id = new.inventory_id and r.return_date is null) > 0 then 
    signal sqlstate '45000'			-- Lo que mata el insert es el envio de la señal de estado 45000
    set message_text = 'La pelicula no se encuentra en stock';
    end if;
    
END//
DELIMITER ;

