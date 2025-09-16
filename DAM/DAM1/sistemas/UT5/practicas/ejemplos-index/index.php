<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Generar Calendario</title>
<style>
/* Estilos CSS */
table {
border-collapse: collapse;
width: 50%;
margin: 0 auto;
}
table, th, td {
border: 1px solid black;
text-align: center;
}
th, td {
padding: 5px;
}
</style>
</head>
<body>
<h1>Generar Calendario</h1>
<?php
// Verifica si se ha enviado el formulario
if ($_SERVER["REQUEST_METHOD"] == "POST") {
$mes = $_POST["mes"];
$anio = $_POST["anio"];
$primerDia = date("w", mktime(0, 0, 0, $mes, 1, $anio));
$ultimoDia = date("t", mktime(0, 0, 0, $mes, 1, $anio));
$diasSemana = array("Domingo", "Lunes", "Martes",
"Miércoles", "Jueves", "Viernes", "Sábado");
$nombreMes = date("F", mktime(0, 0, 0, $mes, 1, $anio));
?>
<h2><?php echo $nombreMes . " " . $anio; ?></h2><table>
<tr>
<?php
foreach ($diasSemana as $dia) {
echo "<th>$dia</th>";
}
?>
</tr>
<tr>
<?php
$diaActual = 1;
$contador = 0;
while ($contador < $primerDia) {
echo "<td></td>";
$contador++;
}
while ($diaActual <= $ultimoDia) {
echo "<td>$diaActual</td>";
$diaActual++;
$contador++;
if ($contador == 7) {
echo "</tr><tr>";
$contador = 0;
}
}
while ($contador > 0 && $contador < 7) {
echo "<td></td>";
$contador++;
}
?>
</tr>
</table>
<?php
} else {
?>
<form action="index.php" method="POST">
<label for="mes">Selecciona un mes:</label>
<select name="mes" id="mes">
<?php
for ($i = 1; $i <= 12; $i++) {
echo "<option value='$i'>$i</option>";
}
?>
</select>
<label for="anio">Año:</label>
<input type="number" name="anio" id="anio" min="2020"
value="2023">
<input type="submit" value="Generar Calendario">
</form>
<?php
}
?>
</body>
</html>
