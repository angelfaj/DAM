<?php
//usamos las variables de entorno para configurar la conexión
$dbHost = getenv('DB_HOST');
$dbUser = getenv('DB_USER');
$dbPassword = getenv('DB_PASSWORD');
$dbName = getenv('DB_NAME'); mysqli = new mysqli($dbHost, $dbUser, $dbPassword, $dbName);
 
// Manejar el envío del formulario
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $titulo = $_POST['titulo'];
    $director = $_POST['director'];
    $anio = (int)$_POST['anio'];
    $duracion = (int)$_POST['duracion'];
    $query = "INSERT INTO peliculas (titulo, director,
    anio, duracion) VALUES (?, ?, ?, ?)";
    $stmt = $mysqli->prepare($query);
    $stmt->bind_param("ssii",$titulo, $director, $anio,
    $duracion);
    $stmt->execute();
}

// Ordenar los tituloes
$orden = 'id'; // Orden por defecto
if (isset($_GET['orden'])) {
    $orden = $_GET['orden'];
} 
$query = "SELECT * FROM tituloes ORDER BY $orden";
$result = $mysqli->query($query);
?> 

<!DOCTYPE html>
<html>
    <head>
        <title>Peliculas</title>
        <style>
            table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            }
            th, td {
            padding: 5px;
            text-align: left;
            }
        </style>
    </head>
    <body>
        <h2>Lista de peliculas</h2>
        <table>
            <tr>
                <th><a href="?orden=titulo">titulo</a></th>
                <th><a href="?orden=director">director</a></th>
                <th><a href="?orden=anio">anio</a></th>
                <th><a href="?orden=duracion">duracion</a></th>
            </tr>
            <?php while($row = $result->fetch_assoc()): ?>
            <tr>
                <td><?php echo htmlspecialchars($row['titulo']); ?></td>
                <td><?php echo htmlspecialchars($row['director']); ?></td>
                <td><?php echo htmlspecialchars($row['anio']); ?></td>
                <td><?php echo htmlspecialchars($row['duracion']); ?></td>
            </tr>
            <?php endwhile; ?>
        </table> 
        <h2>Añadir titulo</h2>
        <form method="post" action="">
            <label for="titulo">titulo:</label><br>
            <input type="text" id="titulo" name="titulo" required><br>
            <label for="director">director:</label><br>
            <input type="text" id="director" name="director" required><br>
            <label for="anio">anio:</label><br> 
            <input type="number" id="anio" name="anio" required><br>
            <label for="duracion">duracion:</label><br>
            <input type="number" id="duracion" name="duracion" required><br><br>
            <input type="submit" value="Añadir">
        </form>
    </body>
</html>