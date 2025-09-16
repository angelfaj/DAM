<?php
// Usamos las variables de entorno para configurar la conexión
$dbHost = getenv('DB_HOST');
$dbUser = getenv('DB_USER');
$dbPassword = getenv('DB_PASSWORD');
$dbName = getenv('DB_NAME'); 
$mysqli = new mysqli($dbHost, $dbUser, $dbPassword, $dbName);

// Verificar conexión a la base de datos
if ($mysqli->connect_error) {
    die("Conexión fallida: " . $mysqli->connect_error);
}

// Manejar el envío del formulario
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $titulo = $_POST['titulo'];
    $director = $_POST['director'];
    $anio = filter_var($_POST['anio'], FILTER_VALIDATE_INT);
    $duracion = filter_var($_POST['duracion'], FILTER_VALIDATE_INT);

    if ($anio && $duracion) {
        $query = "INSERT INTO peliculas (titulo, director, anio, duracion) VALUES (?, ?, ?, ?)";
        $stmt = $mysqli->prepare($query);
        $stmt->bind_param("ssii", $titulo, $director, $anio, $duracion);
        $stmt->execute();
    } else {
        echo "Por favor, ingrese valores válidos.";
    }
}

// Ordenar los títulos
$orden = 'id'; // Orden por defecto
$orden_valido = ['titulo', 'director', 'anio', 'duracion']; // Campos válidos
if (isset($_GET['orden']) && in_array($_GET['orden'], $orden_valido)) {
    $orden = $_GET['orden'];
} 
$query = "SELECT * FROM peliculas ORDER BY $orden";
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
        <h2>Añadir pelicula</h2>
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

