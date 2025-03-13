/*
-- Ejercicios Básicos
Comparar Consultas con y sin Índice:
Ejecuta una consulta que busque películas por título antes y después de crear un índice en
la columna title. Compara los tiempos de ejecución.
-- Antes de crear el índice
EXPLAIN ANALYZE SELECT * FROM film WHERE title = 'ACADEMY DINOSAUR';
Añadir índice.
-- Después de crear el índice
EXPLAIN ANALYZE SELECT * FROM film WHERE title = 'ACADEMY DINOSAUR';


Crear un Índice Compuesto:
Crea un índice compuesto en las columnas first_name y last_name de la tabla actor.


Índice en Columnas de Búsqueda Frecuente:
Identifica una columna que se usa frecuentemente en consultas de búsqueda y crea un
índice en ella. Por ejemplo, la columna rental_date en la tabla rental.


Índice Único:
Crea un índice único en la columna email de la tabla customer para asegurar que no haya
correos electrónicos duplicados.


Índice Parcial:
Crea un índice parcial en la tabla payment para índices solo las filas donde amount es
mayor que 5.
Un índice parcial, también conocido como índice filtrado, es una característica en algunos
sistemas de gestión de bases de datos (DBMS) que permite crear índices solo para un
subconjunto de las filas de una tabla. Esto puede ser muy útil en ciertas situaciones para
mejorar el rendimiento de las consultas y reducir el uso de espacio en disco.
Propósito de un Índice Parcial
Mejora del Rendimiento: Al indexar solo un subconjunto de las filas, las consultas que se
benefician del índice parcial pueden ser más rápidas porque el índice es más pequeño y,
por lo tanto, más rápido de escanear.
Reducción del Uso de Espacio: Los índices parciales ocupan menos espacio en disco
porque no indexan todas las filas de la tabla. Esto puede ser beneficioso en tablas muy
grandes donde solo un pequeño subconjunto de filas es relevante para ciertas consultas.
Optimización de Consultas Específicas: Si tienes consultas que siempre filtran por ciertas
condiciones, un índice parcial puede ser más eficiente que un índice completo.


Índice en Columnas de Texto Largo:
Crea un índice en una columna de texto largo, como la columna description de la tabla film,
utilizando solo los primeros 100 caracteres.



Ejercicios de Rendimiento
Medir el Impacto del Índice en Inserciones:
Enunciado: Mide el tiempo que tarda en insertar 1000 registros en la tabla rental antes y
después de crear un índice en la columna rental_date.
*/


hola

