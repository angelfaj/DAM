/*Ejercicio 1: Creación de un Tipo Simple (Spec)
Objetivo: Crear la especificación de un objeto sin cuerpo.
Enunciado: Crea un tipo de objeto llamado T_PRODUCTO que tenga los siguientes
atributos:
• id (numérico)
• nombre (cadena de 30 caracteres)
• precio (numérico de 2 decimales)
Comprobación: recuerda que no puedes inicializar valores con DEFAULT ni usar NOT
NULL en los atributos. Pruébalo.*/
/*
CREATE OR REPLACE TYPE T_PRODUCTO AS OBJECT (
    id NUMBER,
    nombre VARCHAR(30),
    precio NUMBER(2),
    
    MEMBER FUNCTION calcular_precio_iva RETURN NUMBER
);
/
*/
/*Ejercicio 2: Añadir Métodos (Spec y Body)
Objetivo: Implementar lógica encapsulada.
Enunciado: Modifica el tipo T_PRODUCTO. Añade una función miembro llamada
calcular_precio_iva que devuelva el precio incrementado un 21%. Debes crear tanto la
especificación como el cuerpo (BODY).
Ayuda: Recuerda usar SELF.precio para acceder al atributo actual.
Bloque 2: Objetos Anidados y Constructores*/
/*
CREATE OR REPLACE TYPE BODY T_PRODUCTO AS 
    MEMBER FUNCTION calcular_precio_iva RETURN NUMBER IS 
    BEGIN
        RETURN SELF.precio + (SELF.precio * 0.21);
    END calcular_precio_iva;
END;
/ 
*/
/*Ejercicio 3: Objetos Anidados
Objetivo: Crear tipos complejos usando otros tipos.
Enunciado:
1. Crea un tipo T_DIRECCION (calle, ciudad, cp).
2. Crea un tipo T_PROVEEDOR que tenga: id, nombre y un atributo ubicacion que
sea del tipo T_DIRECCION.
Concepto clave: definir objetos dentro de otros objetos.*/

/*
CREATE OR REPLACE TYPE T_DIRECCION AS OBJECT (
    cp NUMBER(5),
    calle VARCHAR(30),
    ciudad VARCHAR(30)
);
/
CREATE OR REPLACE TYPE T_PROVEEDOR AS OBJECT (
    id NUMBER,
    nombre VARCHAR(30),
    ubicacion T_DIRECCION
);
/ 
*/
/*Ejercicio 4: Instanciación en PL/SQL (Constructores)
Objetivo: Probar los objetos en un bloque anónimo y manejar constructores.
Enunciado: Escribe un bloque PL/SQL anónimo que:
1. Declare una variable de tipo T_PROVEEDOR.
2. La inicialice utilizando el constructor por defecto (anidando el constructor de
dirección dentro).
3. Muestre por pantalla la ciudad del proveedor.
Reto: ¿Qué pasa si declaran la variable pero no hacen el := T_PROVEEDOR(...)?
(Deberías recordar el error ACCESS_INTO_NULL).*/
/*
SET SERVEROUTPUT ON;

DECLARE 
    p1 T_PROVEEDOR;
BEGIN 
    p1 := T_PROVEEDOR(1, 'Pepe', T_DIRECCION(28045, 'C/ Alianza 14', 'Madrid'));
    
    DBMS_OUTPUT.PUT_LINE('Ciudad del proveedor: ' || p1.ubicacion.ciudad);    
END;
/
*/

/*Ejercicio 5: Tablas de Objetos vs. Columnas de Objetos
Objetivo: Entender la persistencia física.
Enunciado:
1. Crea una Tabla de Objetos llamada TABLA_PRODUCTOS que almacene
objetos T_PRODUCTO.
2. Crea una Tabla Relacional llamada INVENTARIO que tenga un id_almacen
(number) y una columna mercancia de tipo T_PRODUCTO.
Pregunta: ¿Qué tabla tiene filas con OID propio? (Respuesta: TABLA_PRODUCTOS ).*/

/*
CREATE TABLE TABLA_PRODUCTOS OF T_PRODUCTO;

CREATE TABLE INVENTARIO (
    id_almacen number,
    mercancia ref T_PRODUCTO
);
*/

/*Ejercicio 6: Creación de Tablas con REF y SCOPE
Objetivo: Relacionar tablas sin duplicar datos.
Enunciado: Crea una tabla relacional VENTAS con:
• id_venta (number)
• fecha (date)
• producto_ref: Una referencia (REF) al tipo T_PRODUCTO.
• Restricción: Asegura que esa referencia solo pueda apuntar a la
TABLA_PRODUCTOS creada en el Ejercicio 5 (Usa SCOPE IS).*/
/*
CREATE TABLE VENTAS (
    id_ventas number,
    fecha date,
    producto_ref ref T_PRODUCTO scope is TABLA_PRODUCTOS
);
*/

/*Ejercicio 7: Inserción con REF
Objetivo: Usar INSERT, Constructores y REF().
Enunciado:
1. Inserta un producto en TABLA_PRODUCTOS (ej: 'Monitor', 200€) usando el
constructor.
2. Inserta una fila en la tabla VENTAS. Para el campo producto_ref, debes obtener
el puntero al producto 'Monitor' usando una subconsulta con el operador REF().
Bloque 5: Consultas, DEREF y CRUD*/
/*
INSERT INTO tabla_productos values(1, 'Monnitor', 20);
select * from tabla_productos;

INSERT INTO VENTAS
    SELECT 1, SYSDATE, REF(p)
        FROM tabla_productos p
        WHERE p.id = 1;
        
SELECT * FROM ventas;
*/        

/*Ejercicio 8: Navegación Implícita y Métodos en SQL
Objetivo: Consultar datos a través de punteros y ejecutar métodos.
Enunciado: Haz un SELECT sobre la tabla VENTAS que muestre:
1. El id_venta.
2. El nombre del producto (navegando a través del REF).
3. El precio con IVA (ejecutando el método calcular_precio_iva() del objeto
referenciado).*/
/*
select 
    v.id_ventas, 
    v.producto_ref.nombre, 
    v.producto_ref.calcular_precio_iva() as precio_con_iva
from ventas v;
*/

/*Ejercicio 9: Dereferenciación (DEREF)
Objetivo: Traer el objeto completo, no solo un atributo.
Enunciado: Realiza una consulta a la tabla VENTAS que devuelva el id_venta y el
objeto T_PRODUCTO completo asociado. Debes usar el operador DEREF.*/
/*
select v.id_ventas, deref(v.producto_ref) from ventas v;
*/

/*Ejercicio 10: Update Complejo
Objetivo: Modificar atributos dentro de objetos y tablas de objetos.
Enunciado:
1. Actualiza la TABLA_PRODUCTOS. Sube el precio a 300€ de todos los productos
cuyo nombre sea 'Monitor'.
2. Reto: Comprueba si el cambio se refleja automáticamente al consultar la tabla
VENTAS (Ejercicio 8).*/
/*
update tabla_productos 
set precio = 30 
where nombre = 'Monnitor';
select * from ventas;
*/
