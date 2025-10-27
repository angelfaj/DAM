-- --------------------------------------------------------
-- 3. PL/SQL: PROCEDIMIENTOS Y FUNCIONES
-- --------------------------------------------------------

-- PROCEDURE: Para probar el CallableStatement con IN y OUT
-- Registra una devolución, actualiza disponibilidad y devuelve el título.
CREATE OR REPLACE PROCEDURE REGISTRAR_DEVOLUCION (
    p_id_prestamo IN NUMBER,
    p_titulo_devuelto OUT VARCHAR2 -- Parámetro OUT [cite: 154]
)
AS
    v_isbn CHAR(13);
BEGIN
    -- 1. Marcar el préstamo como devuelto
    UPDATE PRESTAMOS
    SET FECHA_DEVOLUCION = SYSDATE
    WHERE ID_PRESTAMO = p_id_prestamo
    RETURNING ISBN INTO v_isbn;

    -- 2. Incrementar la disponibilidad de la copia
    UPDATE LIBROS
    SET NUM_COPIAS_DISP = NUM_COPIAS_DISP + 1
    WHERE ISBN = v_isbn;

    -- 3. Obtener el título devuelto para el OUT
    SELECT TITULO INTO p_titulo_devuelto
    FROM LIBROS
    WHERE ISBN = v_isbn;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_titulo_devuelto := 'Préstamo no encontrado';
END;
/

-- FUNCTION: Para probar la llamada a una función con CallableStatement
-- Calcula la multa total acumulada de un lector, basado en la diferencia de días y 0.50/día
CREATE OR REPLACE FUNCTION CALCULAR_MULTA_LECTOR (
    p_id_lector IN NUMBER -- Parámetro IN [cite: 159]
)
RETURN NUMBER
AS
    v_multa NUMBER(5,2);
BEGIN
    -- La multa se calcula sobre préstamos activos y retrasados
    SELECT SUM(
            0.50 * (TRUNC(SYSDATE) - TRUNC(FECHA_LIMITE))
           ) INTO v_multa
    FROM PRESTAMOS
    WHERE ID_LECTOR = p_id_lector
      AND FECHA_DEVOLUCION IS NULL
      AND TRUNC(SYSDATE) > TRUNC(FECHA_LIMITE);

    RETURN NVL(v_multa, 0);
END;
/

-- PROCEDURE: Para probar el CallableStatement con IN/OUT
-- Actualiza la multa de un lector y devuelve el nuevo valor
CREATE OR REPLACE PROCEDURE ACTUALIZAR_MULTA_INOUT (
    p_id_lector IN NUMBER,
    p_monto_adicional IN OUT NUMBER -- Parámetro IN/OUT [cite: 161]
)
AS
    v_nueva_multa NUMBER(5,2);
BEGIN
    -- 1. Actualizar la multa existente con el monto adicional
    UPDATE LECTORES
    SET MULTAS_PENDIENTES = MULTAS_PENDIENTES + p_monto_adicional
    WHERE ID_LECTOR = p_id_lector
    RETURNING MULTAS_PENDIENTES INTO v_nueva_multa;

    -- 2. Devolver el nuevo valor de la multa a través del parámetro IN/OUT
    p_monto_adicional := v_nueva_multa;
    
    COMMIT;
END;
/