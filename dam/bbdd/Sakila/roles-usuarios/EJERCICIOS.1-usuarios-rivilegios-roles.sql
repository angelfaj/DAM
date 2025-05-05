-- USE sakila;

-- Creación de Usuarios:
-- 1. Crear un usuario llamado analista1 con acceso desde localhost.
CREATE USER IF NOT EXISTS 'analista1'@'localhost';

-- 2. Crear un usuario lector_sakila con permiso solo para leer (SELECT) la base
-- de datos sakila.
CREATE USER IF NOT EXISTS 'lector_sakila'@'localhost';
GRANT SELECT ON sakila.* TO 'lector_sakila'@'localhost';

FLUSH PRIVILEGES;	-- Refresca privilegios para que se apliquen directamente

-- 3. Crear un usuario admin_sakila con todos los privilegios sobre sakila desde
-- cualquier host ('%').
CREATE USER IF NOT EXISTS 'admin_sakila'@'%';
GRANT ALL PRIVILEGES ON *.* TO 'admin_sakila';

FLUSH PRIVILEGES;

-- 4. Crear un usuario empleado_tienda con permiso solo sobre las tablas
-- inventory, rental y payment.
CREATE USER IF NOT EXISTS 'empleado_tienda'@'localhost';
GRANT ALL PRIVILEGES ON sakila.iventory TO 'empleado_tienda'@'localhost';
GRANT ALL PRIVILEGES ON sakila.payment TO 'empleado_tienda'@'localhost';
GRANT ALL PRIVILEGES ON sakila.rental TO 'empleado_tienda'@'localhost';

FLUSH PRIVILEGES;


-- Asignación de Privilegios
-- 5. Otorgar privilegios de INSERT, UPDATE y DELETE sobre la tabla rental al
-- usuario empleado_tienda.
GRANT INSERT, UPDATE, DELETE ON sakila.rental TO 'empleado_tienda'@'localhost';

FLUSH PRIVILEGES;

-- 6. Revocar todos los privilegios del usuario empleado_tienda.
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'empleado_tienda'@'localhost'; -- No permite la revocacion de una unica bbdd

FLUSH PRIVILEGES;

-- 7. Modificar al usuario analista1 para que también tenga acceso remoto
-- ('analista1'@'%').
CREATE USER IF NOT EXISTS 'analista1'@'%';  -- Es necesario crear un usuario nuevo

FLUSH PRIVILEGES;

-- 8. Permitir que lector_sakila solo pueda consultar las tablas film y actor,
-- pero no otras.
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'lector_sakila'@'localhost';
GRANT SELECT ON sakila.film TO 'lector_sakila'@'localhost';
GRANT SELECT ON sakila.actor TO 'lector_sakila'@'localhost';

FLUSH PRIVILEGES;

-- Roles (MySQL 8.0+)
-- 9. Crear un rol llamado rol_lectura con acceso de solo lectura a toda la base
-- sakila.
CREATE ROLE IF NOT EXISTS rol_lectura;
GRANT SELECT ON sakila.* TO rol_lectura;

-- 10. Asignar el rol rol_lectura a los usuarios lector1, lector2 y lector3.
CREATE USER IF NOT EXISTS 'lector1'@'localhost';
CREATE USER IF NOT EXISTS 'lector2'@'localhost';
CREATE USER IF NOT EXISTS 'lector3'@'localhost';
GRANT rol_lectura TO 'lector1'@'localhost', 'lector2'@'localhost', 'lector3'@'localhost';

-- 11. Crear un rol rol_ventas que permita acceso a payment, customer, rental.
CREATE ROLE IF NOT EXISTS rol_ventas;
GRANT ALL PRIVILEGES ON sakila.payment TO rol_ventas;
GRANT ALL PRIVILEGES ON sakila.rental TO rol_ventas;
GRANT ALL PRIVILEGES ON sakila.customer TO rol_ventas;

-- 12. Revocar el rol rol_lectura de lector2.
REVOKE rol_lectura FROM 'lector2'@'localhost';

-- 13. Hacer que el rol rol_ventas se active por defecto al iniciar sesión.
CREATE USER IF NOT EXISTS 'vendedor1'@'localhost';
GRANT rol_ventas TO 'vendedor1'@'localhost';
SET DEFAULT ROLE rol_ventas TO 'vendedor1'@'localhost';

-- Comprobación y Seguridad
-- 14. Listar todos los usuarios creados en el servidor.
SELECT user,host FROM mysql.user WHERE host = 'localhost';

-- 15. Ver los privilegios que tiene lector_sakila.
SHOW GRANTS FOR 'lector_sakila'@'localhost';

-- 16. Eliminar al usuario empleado_tienda del sistema.
DROP USER IF EXISTS 'empleado_tienda'@'localhost';

-- 17. Cambiar la contraseña del usuario admin_sakila.
ALTER USER 'admin_sakila' IDENTIFIED BY 'admin_password';

-- 18. Crear un usuario invitado sin contraseña y luego asignarle una usando
-- ALTER USER.
CREATE USER IF NOT EXISTS 'invitado'@'localhost';
ALTER USER 'invitado'@'localhost' IDENTIFIED BY 'CONTRASEÑA';

-- 19. Mostrar todos los roles y usuarios asociados en el sistema.
SELECT user, host
FROM mysql.user
WHERE mysql.user.account_locked='Y' AND mysql.user.password_expired='Y' AND
mysql.user.authentication_string='';

-- 20. Crear un usuario auditor que solo pueda hacer SELECT en todas las tablas
-- excepto payment.
CREATE USER IF NOT EXISTS 'auditor'@'localhost';
GRANT SELECT ON sakila.* TO 'auditor'@'localhost';
FLUSH PRIVILEGES;

REVOKE SELECT ON sakila.payment FROM 'auditor'@'localhost';