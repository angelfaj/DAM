package appCliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestCliente {
	private static final String URL_API = "http://localhost:8080/api/incidencias";
	
	public static int registrarIncidencia(String descripcion, int prioridad, boolean resuelta) {
		try {
			String json = "{\"descripcion\": \"" + descripcion + "\", " +
					"\"prioridad\": " + prioridad + ", " +
					"\"resuelta\": \"" + resuelta + "\"}";
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_API))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(json))
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			return response.statusCode();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void mostrarIncidencias() {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_API))
					.GET()
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.body().equals("[]")) {
				System.out.println("No hay incidencias pendientes");
			}else {
				System.out.println("#######Incidencias guardadas#######\n" + response.body().replace("},{", "}, \n{"));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void marcarResuelta(long id) {  
		try {
			String urlFinal = URL_API + "/" + id;
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal))
					.header("Content-Type", "application/json")
					.PUT(HttpRequest.BodyPublishers.ofString(""))
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			//System.out.println(response.body());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// PASO 1 Y 2:Registrar incidencias y mostrar status code
		int statusCode = registrarIncidencia("Pantalla azul", 4, false);
		System.out.println("Incidencia enviada. Código de respuesta: " + statusCode);
		
		statusCode = registrarIncidencia("No enciende", 5, false);
		System.out.println("Incidencia enviada. Código de respuesta: " + statusCode);

		// PASO 3: Mostrar incidencias guardadas
		mostrarIncidencias();
		
		// PASO 4: Marcar una incidencia como resuelta
		System.out.println("Marcamos incidencia con id 1 como resuelta");
		marcarResuelta(1); 
		
		// PASO 5: Mostrar nuevamente las incidencias guardadas
		mostrarIncidencias();
		
	}

}
