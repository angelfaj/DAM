------------------------------------------------------
-- DROP de tablas (orden correcto por dependencias)
------------------------------------------------------

-- Primero las tablas hijas
DROP TABLE FICHA_TECNICA CASCADE CONSTRAINTS;

-- Luego las tablas padres
DROP TABLE PROFESOR CASCADE CONSTRAINTS;

------------------------------------------------------
-- DROP de secuencias
------------------------------------------------------
DROP SEQUENCE SEQ_PROFESOR;
DROP SEQUENCE SEQ_FICHA_TECNICA;

------------------------------------------------------
---CREACION
------------------------------------------------------
CREATE SEQUENCE SEQ_PROFESOR START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE SEQ_FICHA_TECNICA START WITH 1 INCREMENT BY 1;


------------------------------------------------------
-- 1. ONE-TO-ONE (Profesor ↔ FichaTecnica)
------------------------------------------------------
CREATE TABLE PROFESOR (
    ID NUMBER PRIMARY KEY,
    NOMBRE VARCHAR2(100)
);

CREATE TABLE FICHA_TECNICA (
    ID NUMBER PRIMARY KEY,
    PROFESOR_ID NUMBER UNIQUE NOT NULL,
    CONSTRAINT FK_FT_PROF FOREIGN KEY (PROFESOR_ID)
        REFERENCES PROFESOR(ID)
);

