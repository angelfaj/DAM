import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class AppCliente {

	// Asegúrate de que tu servidor Spring Boot está corriendo en el puerto 8080
	private static final String URL_API = "http://localhost:8080/api/productos";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		System.out.println("--- GESTIÓN INTEGRAL TECHSTORE (CLIENTE) ---");

		// Bucle principal del menú
		while (opcion != 9) {
			System.out.println("\n-----------------------------------------");
			System.out.println(" ACCIONES INDIVIDUALES");
			System.out.println("-----------------------------------------");
			System.out.println("1. Ver todo el catálogo (GET)");
			System.out.println("2. Buscar producto por ID (GET)");
			System.out.println("3. Crear nuevo producto (POST)");
			System.out.println("4. Actualizar producto por ID (PUT)");
			System.out.println("5. Eliminar producto por ID (DELETE)");

			System.out.println("\n-----------------------------------------");
			System.out.println(" ACCIONES POR LOTES (MARCA)");
			System.out.println("-----------------------------------------");
			System.out.println("6. Buscar productos por Marca (GET)");
			System.out.println("7. Actualizar toda una Marca (PUT Masivo)");
			System.out.println("8. Eliminar toda una Marca (DELETE Masivo)");

			System.out.println("\n9. Salir");
			System.out.print(">> Elige una opción: ");

			try {
				// Usamos nextLine y parseInt para evitar problemas con el buffer del scanner
				String input = scanner.nextLine();
				if (input.isEmpty())
					continue;
				opcion = Integer.parseInt(input);
			} catch (Exception e) {
				opcion = 0;
				System.out.println("Error: Introduce un número válido.");
			}

			switch (opcion) {
			case 1:
				hacerGet(null); // Null indica que queremos TODOS
				break;

			case 2:
				System.out.print("Introduce el ID a buscar: ");
				long idBusqueda = Long.parseLong(scanner.nextLine());
				hacerGetPorId(idBusqueda);
				break;

			case 3:
				System.out.println("--- NUEVO PRODUCTO ---");
				System.out.print("Nombre: ");
				String nombre = scanner.nextLine();
				System.out.print("Marca: ");
				String marca = scanner.nextLine();
				System.out.print("Precio (usa punto para decimales): ");
				double precio = Double.parseDouble(scanner.nextLine());
				System.out.print("Stock: ");
				int stock = Integer.parseInt(scanner.nextLine());
				hacerPost(nombre, marca, precio, stock);
				break;

			case 4:
				System.out.print("ID del producto a actualizar: ");
				long idPut = Long.parseLong(scanner.nextLine());
				System.out.print("Nuevo Precio: ");
				double nPrecio = Double.parseDouble(scanner.nextLine());
				System.out.print("Nuevo Stock: ");
				int nStock = Integer.parseInt(scanner.nextLine());
				hacerPut(idPut, nPrecio, nStock);
				break;

			case 5:
				System.out.print("ID del producto a eliminar: ");
				long idDel = Long.parseLong(scanner.nextLine());
				hacerDelete(idDel);
				break;

			case 6:
				System.out.print("Introduce la marca a buscar: ");
				String marcaBusqueda = scanner.nextLine();
				hacerGet(marcaBusqueda);
				break;

			case 7:
				System.out.println("--- ACTUALIZACIÓN MASIVA ---");
				System.out.print("Marca a actualizar: ");
				String marcaUpd = scanner.nextLine();
				System.out.print("Nuevo Precio General (0 para no cambiar): ");
				double precioM = Double.parseDouble(scanner.nextLine());
				System.out.print("Nuevo Stock General (-1 para no cambiar): ");
				int stockM = Integer.parseInt(scanner.nextLine());
				hacerPutPorMarca(marcaUpd, precioM, stockM);
				break;

			case 8:
				System.out.println("--- BORRADO MASIVO ---");
				System.out.print("Marca a eliminar COMPLETAMENTE: ");
				String marcaBorrar = scanner.nextLine();
				System.out.print("¿Estás seguro? Escribe 'SI' para confirmar: ");
				if (scanner.nextLine().equalsIgnoreCase("SI")) {
					hacerDeletePorMarca(marcaBorrar);
				} else {
					System.out.println("Operación cancelada.");
				}
				break;

			case 9:
				System.out.println("Cerrando aplicación...");
				break;

			default:
				System.out.println("Opción no válida.");
			}
		}
		scanner.close();
	}

	// ==========================================
	// MÉTODOS DE CONEXIÓN HTTP
	// ==========================================

	// 1. GET (Sirve para Todos o Filtro por Marca)
	private static void hacerGet(String filtroMarca) {
		try {
			String urlFinal = URL_API;
			// Si hay marca, añadimos el parámetro query string
			if (filtroMarca != null && !filtroMarca.isBlank()) {
				// Reemplazamos espacios por %20 para que la URL sea válida
				urlFinal += "?marca=" + filtroMarca.replace(" ", "%20");
			}

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal)).GET().build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String json = response.body();

			if (json.equals("[]")) {
				System.out.println(">> No se encontraron resultados.");
			} else {
				System.out.println("\n--- RESULTADOS ---");
				// Truco visual para separar los objetos JSON
				System.out.println(json.replace("},{", "},\n{"));
			}
		} catch (Exception e) {
			System.err.println("Error de conexión: " + e.getMessage());
		}
	}

	// 2. GET POR ID (Individual)
	private static void hacerGetPorId(long id) {
		try {
			String urlFinal = URL_API + "/" + id;
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal)).GET().build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() == 200) {
				System.out.println("\n--- PRODUCTO ENCONTRADO ---");
				System.out.println(response.body());
			} else if (response.statusCode() == 404) {
				System.out.println(">> Error 404: Producto no encontrado.");
			} else {
				System.out.println(">> Estado desconocido: " + response.statusCode());
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// 3. POST (Crear)
	private static void hacerPost(String nombre, String marca, double precio, int stock) {
		try {
			String json = String.format("{\"nombre\":\"%s\", \"marca\":\"%s\", \"precio\":%s, \"stock\":%d}", nombre,
					marca, String.valueOf(precio), stock);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_API))
					.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(">> Producto creado: " + response.body());
		} catch (Exception e) {
			System.err.println("Error al crear: " + e.getMessage());
		}
	}

	// 4. PUT (Actualizar Individual)
	private static void hacerPut(long id, double precio, int stock) {
		try {
			String json = String.format("{\"precio\":%s, \"stock\":%d}", String.valueOf(precio), stock);

			String url = URL_API + "/" + id;
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
					.header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(json)).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200 && !response.body().isEmpty()) {
				System.out.println(">> Actualizado correctamente: " + response.body());
			} else {
				System.out.println(">> No se pudo actualizar (quizás el ID no existe).");
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar: " + e.getMessage());
		}
	}

	// 5. DELETE (Borrar Individual)
	private static void hacerDelete(long id) {
		try {
			String url = URL_API + "/" + id;
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).DELETE().build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			// Verificamos si la respuesta contiene el mensaje de éxito
			if (response.statusCode() == 200) {
				System.out.println(">> Respuesta del servidor: " + response.body());
			} else {
				System.out.println(">> Error al borrar. Código: " + response.statusCode());
			}
		} catch (Exception e) {
			System.err.println("Error al borrar: " + e.getMessage());
		}
	}

	// 6. PUT POR MARCA (Actualización Masiva - VERSIÓN QUERY PARAM)
	private static void hacerPutPorMarca(String marca, double precio, int stock) {
		try {
			String json = String.format("{\"precio\":%s, \"stock\":%d}", String.valueOf(precio), stock);

			// CAMBIO: Ahora usamos ?marca= en lugar de /marca/
			String marcaUrl = marca.replace(" ", "%20");
			String url = URL_API + "?marca=" + marcaUrl;

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
					.header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(json)).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			// ... resto del código igual ...
			System.out.println("Respuesta: " + response.body());

		} catch (Exception e) {
			System.err.println("Error masivo: " + e.getMessage());
		}
	}

	// 7. DELETE POR MARCA (Borrado Masivo - VERSIÓN QUERY PARAM)
	private static void hacerDeletePorMarca(String marca) {
		try {
			// CAMBIO: Ahora usamos ?marca= en lugar de /marca/
			String marcaUrl = marca.replace(" ", "%20");
			String url = URL_API + "?marca=" + marcaUrl;

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).DELETE() // Ojo: DELETE con Query Params
																							// es válido en HTTP
					.build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Resultado: " + response.body());

		} catch (Exception e) {
			System.err.println("Error al borrar marca: " + e.getMessage());
		}
	}
}