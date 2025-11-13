-- --------------------------------------------------------
-- 1. CREACIÓN DE TABLAS
-- --------------------------------------------------------

-- Tabla LECTORES
CREATE TABLE LECTORES (
    ID_LECTOR NUMBER(5) PRIMARY KEY,
    NOMBRE VARCHAR2(100) NOT NULL,
    APELLIDO VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(100) UNIQUE,
    MULTAS_PENDIENTES NUMBER(5,2) DEFAULT 0 CHECK (MULTAS_PENDIENTES >= 0)
);

-- Tabla AUTORES
CREATE TABLE AUTORES (
    ID_AUTOR NUMBER(4) PRIMARY KEY,
    NOMBRE_AUTOR VARCHAR2(100) NOT NULL,
    NACIONALIDAD VARCHAR2(50)
);

-- Tabla LIBROS
CREATE TABLE LIBROS (
    ISBN CHAR(13) PRIMARY KEY, -- Usamos CHAR(13) para ISBN-13
    TITULO VARCHAR2(200) NOT NULL,
    ANIO_PUBLICACION NUMBER(4),
    NUM_COPIAS_TOTALES NUMBER(3) DEFAULT 1 CHECK (NUM_COPIAS_TOTALES >= 1),
    NUM_COPIAS_DISP NUMBER(3) DEFAULT 1, -- Copias disponibles para préstamo
    ID_AUTOR NUMBER(4) REFERENCES AUTORES(ID_AUTOR) NOT NULL
);

-- Tabla PRESTAMOS
CREATE TABLE PRESTAMOS (
    ID_PRESTAMO NUMBER(8) PRIMARY KEY,
    ID_LECTOR NUMBER(5) REFERENCES LECTORES(ID_LECTOR),
    ISBN CHAR(13) REFERENCES LIBROS(ISBN),
    FECHA_PRESTAMO DATE DEFAULT SYSDATE,
    FECHA_DEVOLUCION DATE, -- NULL si el libro sigue prestado
    FECHA_LIMITE DATE NOT NULL
);

-- Secuencia para el ID de los préstamos
CREATE SEQUENCE SEQ_PRESTAMOS START WITH 1 INCREMENT BY 1;

-- --------------------------------------------------------
-- CONFIGURACIÓN INICIAL PARA TRANSACCIONES JDBC
-- Los apuntes mencionan deshabilitar el auto-commit[cite: 168, 169].
-- Esto se hace en Java, pero puedes forzarlo a nivel de sesión si es necesario para pruebas iniciales.
-- ALTER SESSION SET COMMIT_WRITE = IMMEDIATE;
-- --------------------------------------------------------