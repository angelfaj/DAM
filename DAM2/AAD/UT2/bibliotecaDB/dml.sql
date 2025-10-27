-- --------------------------------------------------------
-- 2. INSERCIÓN DE DATOS (DML)
-- --------------------------------------------------------

-- 1. AUTORES
INSERT INTO AUTORES VALUES (101, 'Gabriel García Márquez', 'Colombia');
INSERT INTO AUTORES VALUES (102, 'Jane Austen', 'Reino Unido');
INSERT INTO AUTORES VALUES (103, 'George Orwell', 'Reino Unido');
INSERT INTO AUTORES VALUES (104, 'Isabel Allende', 'Chile');

-- 2. LECTORES
INSERT INTO LECTORES (ID_LECTOR, NOMBRE, APELLIDO, EMAIL) VALUES (2001, 'Javier', 'Pérez', 'javier.perez@mail.com');
INSERT INTO LECTORES (ID_LECTOR, NOMBRE, APELLIDO, EMAIL) VALUES (2002, 'Ana', 'Gómez', 'ana.gomez@mail.com');
INSERT INTO LECTORES (ID_LECTOR, NOMBRE, APELLIDO, EMAIL, MULTAS_PENDIENTES) VALUES (2003, 'Carlos', 'Ruiz', 'carlos.ruiz@mail.com', 5.50);

-- 3. LIBROS
-- Libros de García Márquez (101)
INSERT INTO LIBROS VALUES ('9788497592208', 'Cien años de soledad', 1967, 5, 3, 101); -- 3 copias disponibles
INSERT INTO LIBROS VALUES ('9788437604947', 'Crónica de una muerte anunciada', 1981, 2, 2, 101);

-- Libros de Jane Austen (102)
INSERT INTO LIBROS VALUES ('9788491051515', 'Orgullo y prejuicio', 1813, 3, 3, 102);

-- Libros de George Orwell (103)
INSERT INTO LIBROS VALUES ('9788499890901', '1984', 1949, 4, 4, 103);

-- Libros de Isabel Allende (104)
INSERT INTO LIBROS VALUES ('9788401345991', 'La casa de los espíritus', 1982, 1, 0, 104); -- 0 copias disponibles (para prueba)

-- 4. PRÉSTAMOS
-- Préstamos activos (FECHA_DEVOLUCION IS NULL)
-- Préstamo 1: Libro 'Cien años de soledad' para Javier (2001), límite hace 10 días (para prueba de multa)
INSERT INTO PRESTAMOS (ID_PRESTAMO, ID_LECTOR, ISBN, FECHA_PRESTAMO, FECHA_LIMITE) 
VALUES (SEQ_PRESTAMOS.NEXTVAL, 2001, '9788497592208', SYSDATE - 20, SYSDATE - 10); 
-- Préstamo 2: Libro 'Cien años de soledad' para Ana (2002), en plazo
INSERT INTO PRESTAMOS (ID_PRESTAMO, ID_LECTOR, ISBN, FECHA_PRESTAMO, FECHA_LIMITE) 
VALUES (SEQ_PRESTAMOS.NEXTVAL, 2002, '9788497592208', SYSDATE - 5, SYSDATE + 5); 

-- Préstamo 3: Libro devuelto (para prueba de historial)
INSERT INTO PRESTAMOS VALUES (SEQ_PRESTAMOS.NEXTVAL, 2003, '9788437604947', SYSDATE - 30, SYSDATE - 15, SYSDATE - 10);

-- Confirmar todas las inserciones
COMMIT;