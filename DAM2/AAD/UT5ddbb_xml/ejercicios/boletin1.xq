(: EJEMPLO 1 :)
(:
for $x in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/hardware.xml")//componente
return $x/modelo
:)

(: EJEMPLO 2 :)
(:
for $libro in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/biblioteca.xml")/biblioteca/libro
where $libro/precio > 20
order by $libro/titulo
return $libro/titulo/text()
:)

(: EJEMPLO 3 :)
(:
<ul>
{
  for $l in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/biblioteca.xml")//libro
  return <li>{ $l/titulo/text() } - { $l/precio/text() } €</li>
}
</ul>
:)

(: ############### EJERCICIOS 1-3 ############### :)
(: 1. Títulos de la biblioteca Enunciado: Obtén solo el texto de los títulos de todos los libros disponibles en biblioteca.xml.:)
(:
for $libro in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/biblioteca.xml")/biblioteca/libro
return $libro/titulo/text()
:)

(:2. Filtrar por atributo (Hardware en stock) Enunciado: Muestra los modelos de componentes del archivo hardware.xml que tengan el atributo stock en "true".:)
(:
for $componente in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/hardware.xml")//componente
where $componente/@stock = true()
return $componente/modelo
:)

(:3. Buscar alumnos (DAM) Enunciado: Obtén el nombre de todos los alumnos que aparecen en dam_notas.xml.:)
(:
for $alumno in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/dam_notas.xml")//alumno
return $alumno/nombre
:)

(:4. Libros baratos (Menos de 20€) Enunciado: Muestra el título y el precio de los libros que cuesten menos de 20 euros.:)
(:
for $libro in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/biblioteca.xml")//libro
where $libro//precio < 20
return <li>{$libro/titulo/text()} - {$libro//precio/text()}</li>
:)

(:5. Potencia de cálculo (Hardware) Enunciado: Queremos un ordenador
potente. Busca componentes que sean de tipo "procesador" Y que tengan más de 8 núcleos. Devuelve el modelo.:)
(:
for $componente in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/hardware.xml")//componente
where $componente/@tipo = "procesador" and $componente//nucleos > 8
return $componente//modelo
:)

(:6. Suspensos en DAM Enunciado: Busca las asignaturas donde la nota sea inferior a 5. Devuelve el nombre de la asignatura y la nota.:)
(:
for $alumno in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/dam_notas.xml")//alumno
where $alumno//asignatura/nota < 5
return <suspenso>{$alumno//asignatura/nombre/text()} - {$alumno//nota/text()}</suspenso>
:)

(:7. Ordenar por precio Enunciado: Lista todos los componentes de hardware ordenados del más caro al más barato.:)
(:
for $componente in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/hardware.xml")//componente
order by $componente//precio descending
return $componente
:)

(:8. Búsqueda de texto (Contains) Enunciado: Encuentra el libro cuyo autor contiene la palabra "García".:)
(:
for $libro in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/biblioteca.xml")//libro
where contains($libro//autor, "García")
return $libro
:)

(:9. Generar HTML (Lista Web) Enunciado: Genera una lista HTML (<ul>...</ul>)donde cada elemento (<li>) sea el título de un libro.:)
(:
for $libro in doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/biblioteca.xml")//libro
return <ul><li>{$libro//titulo/text()}</li></ul>
:)

(:10. Cálculo de valor total Enunciado (Reto): Calcula la suma total del precio de todos los componentes que hay en el catálogo de hardware.:)

let $total := doc("/home/vespertino/angel-workspace/DAM2/AAD/UT5ddbb_xml/ejercicios/ficherosXML-20260129/hardware.xml")//componente/precio
return sum($total)
 