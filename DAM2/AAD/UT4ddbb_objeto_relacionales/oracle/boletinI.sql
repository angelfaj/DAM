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

/*Ejercicio 11: La Cuenta Bancaria (Modificando el estado con SELF)
• Objetivo: Diferenciar entre una función (retorna dato, SELF es IN) y un
procedimiento (realiza acción, SELF es IN OUT).
• Enunciado:
1. Crea la especificación y el cuerpo de un tipo T_CUENTA con
atributos titular (VARCHAR2) y saldo (NUMBER).
2. Define un Procedimiento llamado ingresar que reciba una
cantidad y modifique el atributo saldo sumándole dicha cantidad.
(Nota: Recuerda que aquí SELF es modificable).
3. Define una Función llamada obtener_estado que devuelva un
VARCHAR2. Si el saldo es negativo, debe devolver 'ROJOS', si es
positivo 'VERDES'.
• Ayuda: En el procedimiento debes usar una asignación tipo SELF.saldo
:= SELF.saldo + cantidad;.*/
/*
CREATE OR REPLACE TYPE T_CUENTA AS OBJECT (
    titular VARCHAR2(20),
    saldo NUMBER,
    
    MEMBER PROCEDURE ingresar(incremento NUMBER),
    MEMBER FUNCTION obtener_estado RETURN VARCHAR2
);
/

CREATE OR REPLACE TYPE BODY T_CUENTA AS 
    MEMBER FUNCTION obtener_estado RETURN VARCHAR2 IS
    BEGIN
        IF SELF.saldo < 0 THEN
            RETURN 'ROJOS';
        ELSE 
            RETURN 'VERDES';
        END IF;
    END obtener_estado;
    
    MEMBER PROCEDURE ingresar(incremento NUMBER) IS
    BEGIN
        SELF.saldo := SELF.saldo + incremento;
    END ingresar;
END;
/
*/

/*Ejercicio 12: Bloque PL/SQL e Persistencia
• Objetivo: Manipular objetos en memoria dentro de un bloque anónimo
antes de guardarlos en disco.
• Enunciado:
1. Crea una Tabla de Objetos llamada TABLA_CUENTAS del tipo
T_CUENTA.
2. Escribe un bloque anónimo (DECLARE-BEGIN-END) que haga lo
siguiente:
▪ Declare una variable v_cta de tipo T_CUENTA
inicializándola con un saldo de 100€ usando el constructor.
▪ Llame al método ingresar para sumar 50€ a la variable en
memoria.
▪ Imprima por pantalla el resultado del método
obtener_estado.
▪ Finalmente, inserte la variable v_cta (que ya tendrá 150€)
en la TABLA_CUENTAS.
• Reto: Comprueba con un SELECT si se guardó 100 o 150.*/
/*
CREATE TABLE TABLA_CUENTAS OF T_CUENTA;

SET SERVEROUTPUT ON;
DECLARE
    v_cta T_CUENTA;
BEGIN
    v_cta := T_CUENTA('Raquel Munoz', 100);
    
    v_cta.ingresar(50);
    
    DBMS_OUTPUT.PUT_LINE('Estado de la cuenta: ' || v_cta.obtener_estado());
    DBMS_OUTPUT.PUT_LINE('Saldo de la cuenta: ' || v_cta.saldo);
    
    INSERT INTO TABLA_CUENTAS VALUES(v_cta);
    
    COMMIT;
    
END;
/
*/

/*Bloque 7: Manipulación de Objetos Anidados
Ejercicio 13: Updates sobre Atributos Anidados
• Objetivo: Aprender a actualizar un campo específico que está "enterrado"
dentro de otro objeto sin reemplazar toda la fila.
• Enunciado:
1. Utiliza los tipos T_PROVEEDOR y T_DIRECCION (creados en el
boletín anterior).
2. Crea una tabla de objetos TABLA_PROVEEDORES of
T_PROVEEDOR.
3. Inserta un proveedor (ej: 'Logística SL') que esté ubicado en
'Madrid'.
4. Realiza una sentencia UPDATE que cambie solamente la ciudad
de ese proveedor a 'Barcelona', accediendo a través de la notación
punto (p.ubicacion.ciudad).*/
/*
CREATE TABLE TABLA_PROVEEDORES OF T_PROVEEDOR;

INSERT INTO TABLA_PROVEEDORES VALUES(T_PROVEEDOR(1, 'Raton Perez', T_DIRECCION(28045, 'Alianza', 'Madrid')));

UPDATE TABLA_PROVEEDORES p
    SET p.ubicacion.ciudad = 'Barcelona'
    WHERE p.nombre = 'Raton Perez';

commit;
*/

/*Ejercicio 14: Copia de Objetos entre Tablas
• Objetivo: Entender la diferencia entre seleccionar columnas sueltas y
seleccionar el objeto completo con VALUE().
• Enunciado:
1. Crea una tabla relacional (normal) llamada
HISTORICO_PROVEEDORES que tenga una columna fecha_baja
(DATE) y una columna datos_prov de tipo T_PROVEEDOR.
2. Realiza un INSERT en esta tabla histórica seleccionando datos de
la TABLA_PROVEEDORES (del Ejercicio 13).
Clave: En el SELECT del insert, debes usar el operador VALUE(p) para tomar el
objeto completo de la tabla origen y guardarlo en la columna de la tabla destino.*/


/*Ejercicio 15: Restricción de Ámbito (SCOPE IS)
• Objetivo: Crear punteros robustos que solo apunten a una tabla
específica para mejorar el rendimiento y la integridad.
• Enunciado:
1. Crea una tabla relacional PEDIDOS con:
▪ id_pedido (NUMBER)
▪ proveedor_ref: Una referencia (REF) al tipo
T_PROVEEDOR.
2. Al definir la tabla, añade la restricción SCOPE IS para obligar a que
las referencias apunten exclusivamente a tu tabla de objetos
principal (TABLA_PROVEEDORES).
3. Inserta una fila obteniendo el puntero con REF() a partir de una
subconsulta.
4. Consulta la tabla PEDIDOS mostrando el id_pedido y el nombre
del cliente/proveedor, usando DEREF para traer el objeto
completo*/

CREATE TABLE pedidos (
    id_pedido NUMBER PRIMARY KEY,
    proveedor_ref ref T_PROVEEDOR scope is TABLA_PROVEEDORES
);






