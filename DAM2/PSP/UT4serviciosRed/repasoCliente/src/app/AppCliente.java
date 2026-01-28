package app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class AppCliente {
	private static final String URL_API = "http://localhost:8080/api/producto";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("--- GESTIÓN DE STOCK 'TECHSTORE' ---");

        while (opcion != 6) {
            System.out.println("\n1. Ver Catálogo (GET)");
            System.out.println("2. Nuevo Producto (POST)");
            System.out.println("3. Actualizar Stock/Precio (PUT)");
            System.out.println("4. Descatalogar (DELETE)");
            System.out.println("5. Buscar por Marca ");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) { opcion = 0; }

            switch (opcion) {
                case 1:
                    hacerGet(null);
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    // Leemos como String y parseamos para evitar problemas con el scanner
                    System.out.print("Precio (con punto): ");
                    double precio = Double.parseDouble(scanner.nextLine());
                    System.out.print("Stock: ");
                    int stock = Integer.parseInt(scanner.nextLine());
                    hacerPost(nombre, marca, precio, stock);
                    break;
                case 3:
                    System.out.print("ID del producto a modificar: ");
                    long idPut = Long.parseLong(scanner.nextLine());
                    System.out.print("Nuevo Precio: ");
                    double nPrecio = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nuevo Stock: ");
                    int nStock = Integer.parseInt(scanner.nextLine());
                    hacerPut(idPut, nPrecio, nStock);
                    break;
                case 4:
                    System.out.print("ID del producto a borrar: ");
                    long idDel = Long.parseLong(scanner.nextLine());
                    hacerDelete(idDel);
                    break;
                case 5:
                    System.out.print("Introduce la marca a buscar: ");
                    String marcaBusqueda = scanner.nextLine();
                    hacerGet(marcaBusqueda);
                    break;
                case 6:
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();

	}

	private static void hacerDelete(long idDel) {
		try {
			String urlFinal = URL_API + "/" + idDel;
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal))
					.DELETE()
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			System.out.println(response.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void hacerPut(long idPut, double nPrecio, int nStock) {
		try {
			String urlFinal = URL_API + "/" + idPut;
			String json = "{\"precio\": " + nPrecio + ", " +
					"\"stock\": " + nStock + "}";
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal))
					.header("Content-Type", "application/json")
					.PUT(HttpRequest.BodyPublishers.ofString(json))
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.body().equals("[]")) {
				System.out.println("No se ha encontrado el producto");
			}else {
				System.out.println(response.body());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void hacerPost(String nombre, String marca, double precio, int stock) {
		try {
			String json = "{\"nombre\": \"" + nombre + "\", " +
					"\"marca\": \"" + marca + "\", " +
					"\"precio\": " + precio + ", " +
					"\"stock\": " + stock + "}";
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_API))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(json))
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void hacerGet(String marca) {
		try {
			String urlFinal = URL_API;
			
			if (marca != null) {
				urlFinal += "?marca=" + marca;
			}
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal))
					.GET()
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if (response.body().equals("[]")) {
				System.out.println("No hay productos guardados");
			}else {
				System.out.println(response.body().replace("},{", "}, \n{"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
//	private static void hacerGet(String marcaBusqueda) {
//		try {
//			String urlFinal = URL_API;
//			
//			if (marcaBusqueda != null) {
//				 urlFinal += "?marca=" + marcaBusqueda;
//			}
//			
//			HttpClient cliente = HttpClient.newHttpClient();
//			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal))
//					.GET()
//					.build();
//			HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
//			String json = response.body();
//
//			if (json.equals("[]")) {
//				System.out.println("No hay productos en el inventario");
//			}else System.out.println(json.replace("},{", "},\n{"));
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private static void hacerDelete(long idDel) {
//		try {
//			String urlFinal = URL_API + "/" + idDel;
//			
//			HttpClient client = HttpClient.newHttpClient();
//			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal))
//					.DELETE()
//					.build();
//			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//			
//			System.out.println(response.body());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//	private static void hacerPut(long idPut, double nPrecio, int nStock) {
//		try {
//			String urlFinal = URL_API + "/" + idPut;
//			String json = "{\"precio\": " + nPrecio + ", \"stock\": " + nStock + "}";
//
//			HttpClient client = HttpClient.newHttpClient();
//			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlFinal))
//					.header("Content-Type", "application/json")
//					.PUT(HttpRequest.BodyPublishers.ofString(json))
//					.build();
//			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//			
//			json = response.body();
//			if (json.equals("[]")) {
//				System.out.println("No se pudo actualizar el objeto");
//			}else {
//				System.out.println(json);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//	private static void hacerPost(String nombre, String marca, double precio, int stock) {
//		try {
//			String json =  "{\"nombre\": \"" + nombre + "\", " + 
//					"\"marca\": \"" + marca + "\", " + 
//					"\"precio\": " + precio + ", " + 
//					"\"stock\": " + stock + 
//					"}"; 
//
//			HttpClient client = HttpClient.newHttpClient();
//			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL_API))
//					.header("Content-Type", "application/json")
//					.POST(HttpRequest.BodyPublishers.ofString(json))
//					.build();
//			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//			
//			if (response.body().equals("[]")) {
//				System.out.println("Ocurrio un error");
//			}else {
//				System.out.println(response.body());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}


