/*
alter 
check
al menos 1:
    default
    not null
    ...
*/
ALTER TABLE Jugadores
ADD titulos int;

ALTER TABLE Jugadores
ADD CONSTRAINT CHK_Titulos CHECK (titulos >= 0);

