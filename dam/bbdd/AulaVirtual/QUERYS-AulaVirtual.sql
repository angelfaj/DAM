/*
USE AulaVirtual;

-- 1. Lista de artículos y sus autores con los comentarios relacionados
SELECT a.titulo AS articulo, a.autor AS autor, c.texto AS comentario
FROM articulo a
JOIN comentario c ON a.id_coment = c.id_comentario;


-- 2. Usuarios y los artículos em los que han participado
SELECT u.nombre, u.apellido_1, u.email, a.titulo
FROM usuario u
JOIN articulo_usuario au ON u.id_usuario = au.id_usuario_articulo_usuario
JOIN articulo a ON au.id_articulo_articulo_usuario = a.id_articulo;


-- 3. Profesores y los cursos que han publicado
SELECT u.nombre AS profesor, c.nombre AS curso, c.dificultad AS dificultad, cp.f_publicacion AS fecha_publicacion
FROM curso_profesor cp
JOIN curso c ON cp.id_curso_curso_profesor = c.id_curso
JOIN profesor p ON cp.id_profesor_curso_profesor = p.id_profesor
JOIN usuario u ON p.id_profesor = u.id_usuario;


-- 4. Alumnos y los cursos en los que están inscritos
SELECT u.nombre AS alumno, u.apellido_1, c.nombre AS curso, c.dificultad AS dificultad
FROM alumno_curso ac
JOIN alumno a ON ac.id_alumno_alumno_curso = a.id_alumno
JOIN usuario u ON a.id_alumno = u.id_usuario
JOIN curso c ON ac.id_curso_alumno_curso = c.id_curso;


-- 5. Lista de usuarios y el plan que han contratado
SELECT u.nombre, u.apellido_1 AS primer_apellido, t.tipo AS suscripcion, s.precio
FROM contrato ct
JOIN usuario u ON ct.id_usuario_contrato = u.id_usuario
JOIN suscripcion s ON ct.id_suscripcion_contrato = s.id_suscripcion
JOIN tipo_suscripcion t ON  s.tipo = t.id_tipo_suscripcion;


-- 6. Cursos con el número de alumnos inscritos ordenados de mayor a menor
SELECT c.nombre AS curso, c.dificultad, 
    (SELECT COUNT(*) 
     FROM alumno_curso ac 
     WHERE ac.id_curso_alumno_curso = c.id_curso) AS alumnos 
FROM curso c ORDER BY alumnos DESC;


-- 7. Artículos que tienen un comentario asociado
SELECT a.titulo AS articulo, COUNT(c.id_comentario) AS num_comentarios
FROM articulo a
JOIN comentario c ON a.id_coment = c.id_comentario
GROUP BY a.id_articulo
HAVING num_comentarios > 0;


-- 8. Cursos en los que ha participado al menos 1 profesor
SELECT c.nombre AS curso, COUNT(cp.id_profesor_curso_profesor) AS num_profesores
FROM curso c
JOIN curso_profesor cp ON c.id_curso = cp.id_curso_curso_profesor
GROUP BY c.id_curso
HAVING num_profesores >= 1;


-- 9. Usuarios que han contratado la suscripción más cara
SELECT u.nombre, u.apellido_1, u.email, t.tipo AS suscripción, s.precio
FROM contrato ct
JOIN usuario u ON ct.id_usuario_contrato = u.id_usuario
JOIN suscripcion s ON ct.id_suscripcion_contrato = s.id_suscripcion
JOIN tipo_suscripcion t ON  s.tipo = t.id_tipo_suscripcion
WHERE s.precio = (SELECT MAX(precio) FROM suscripcion);



-- 10. Los tres dias que mas comentarios se hicieron ordenandos de mayor a menor
SELECT 
    c.f_publicacion AS dia,
    COUNT(c.id_comentario) AS comentarios
FROM 
    comentario c
GROUP BY c.f_publicacion
ORDER BY comentarios DESC, dia DESC LIMIT 3;
*/