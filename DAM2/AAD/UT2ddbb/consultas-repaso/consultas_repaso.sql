/*CONSULTAS REPASO
1. Mostrar todos los alumnos ordenados por apellidos.
2. Mostrar los cursos con más de 5 créditos.
3. Obtener el nombre y correo de los alumnos nacidos después del
01/01/2003.
4. Mostrar el nombre de los cursos y la especialidad de su profesor.
5. Listar las matrículas con nota superior a 8.
Nivel intermedio (JOIN, GROUP BY, funciones)
6. Mostrar los alumnos y los cursos en los que están matriculados.
7. Obtener la nota media de cada alumno.
8. Mostrar el nombre del profesor y cuántos cursos imparte.
9. Mostrar el número de alumnos matriculados en cada curso.
10. Obtener el curso con la nota media más alta.
11. Mostrar el nombre de los alumnos que no han sacado ninguna nota
inferior a 6.
12. Calcular la edad actual de cada alumno.
13. Mostrar los profesores que imparten cursos de más de 5 créditos.
14. Mostrar el alumno con la nota más alta en el curso “Programación Java”.
Nivel avanzado (subconsultas, DML, HAVING, etc.)
15. Mostrar los alumnos que tienen una nota superior a la media general.
16. Insertar una nueva matrícula para el alumno 3 en el curso 2 con nota
7.5.
17. Actualizar la nota de Pedro Santos en “Sistemas Operativos” a 6.3.
18. Eliminar todas las matrículas con nota menor de 5.
19. Mostrar los cursos que no tienen alumnos matriculados.
20. Crear una vista VISTA_NOTAS con alumno, curso y nota media por
alumno.
*/
--1
select * from alumno order by apellidos;
--2
select * from curso where creditos > 5;
--3
select nombre, email from alumno where fecha_nac > to_date('01/01/2003', 'dd-mm-yyyy');
--4
select c.nombre, p.especialidad from curso c join profesor p on p.id_profesor = c.id_profesor;
--5
select * from matricula where nota > 8;

--6
select a.nombre, c.nombre from alumno a join matricula m on m.id_alumno = a.id_alumno join curso c on c.id_curso = m.id_curso order by a.nombre;
--7
select a.nombre, avg(m.nota) from matricula m 
    join alumno a on a.id_alumno = m.id_alumno 
    group by a.nombre;
--8
select p.nombre, count(c.id_curso) as cursos_impartidos from profesor p
    join curso c on c.id_profesor = p.id_profesor
    group by p.nombre;
--9
select c.nombre as curso, count(m.id_alumno) as alumnos_matriculados 
    from curso c join matricula m on m.id_curso = c.id_curso
    group by c.nombre;
--10
select c.nombre, avg(m.nota) as nota_media from curso c 
    join matricula m on m.id_curso = c.id_curso
    group by c.nombre 
    having avg(m.nota) = (select max(avg(m.nota)) from curso c 
        join matricula m on m.id_curso = c.id_curso
        group by c.nombre);
--11
select a.nombre as alumno from alumno a 
    join matricula m on a.id_alumno = m.id_alumno
    where a.id_alumno not in (
        select id_alumno 
        from matricula 
        where nota < 6)
    group by a.nombre;
    
--12
select nombre as alumno, 
    extract(year from CURRENT_DATE) - extract(year from fecha_nac) as años 
    from alumno;
--13
select distinct p.nombre as profesor, c.nombre as curso, c.creditos as creditos
    from profesor p join curso c on p.id_profesor = c.id_profesor
    where c.creditos > 5;
--14
select a.nombre as alumno, c.nombre as curso, m.nota as nota
    from alumno a join matricula m on a.id_alumno = m.id_alumno
    join curso c on c.id_curso = m.id_curso
    where c.nombre = 'Programación Java'
    and  m.nota = (
        select max(m1.nota) from matricula m1
        join curso c1 on c1.id_curso = m1.id_curso
        where c1.nombre = 'Programación Java');
--15
select a.nombre as alumnos_encima_media, m.nota as notas
    from alumno a join matricula m on a.id_alumno = m.id_alumno
    where m.nota > (
        select avg(nota) from matricula);
--16
insert into matricula(id_matricula, id_alumno, id_curso, nota) values (9, 3, 2, 7.5);
select * from matricula;
--17
update matricula
    set nota = 6.3
    where id_alumno = (
        select id_alumno from alumno where nombre = 'Pedro' and apellidos like 'Santos%')
        and id_curso = (
        select id_curso from curso where nombre = 'Sistemas Operativos');
select * from matricula;
--18
insert into matricula(id_matricula, id_alumno, id_curso, nota) values (10, 3, 2, 4);
select * from matricula;
delete from matricula where nota < 5;
--19
select * from matricula;
select * from curso c left join matricula m on c.id_curso = m.id_curso
    where m.id_alumno is null;
--20
create or replace view VISTA_NOTAS as
    select a.nombre as alumno, c.nombre as curso, avg(m.nota) as media
    from alumno a 
    join matricula m on a.id_alumno = m.id_alumno
    join curso c on m.id_curso = c.id_curso
    group by a.nombre, c.nombre;








