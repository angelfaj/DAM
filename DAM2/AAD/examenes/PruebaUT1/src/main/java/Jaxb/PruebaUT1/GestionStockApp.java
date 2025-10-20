package Jaxb.PruebaUT1;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GestionStockApp {

    // --- Rutas de Ficheros ---
    private static final String RUTA_CSV = "recursos/stock_catalogo.csv";
    private static final String RUTA_PRECIOS_BIN = "recursos/precios.dat";
    private static final String RUTA_STOCK_OBJ = "recursos/stock.dat";
    private static final String RUTA_XML = "recursos/catalogo.xml";
    private static final String RUTA_RESUMEN = "recursos/resumen.txt";


    public static void main(String[] args) {
        // 1. Datos de prueba
        List<Articulo> stockInicial = new ArrayList<>();
        stockInicial.add(new Articulo("P001", "Monitor Curvo 27", 15, 299.99));
        stockInicial.add(new Articulo("P002", "Teclado Mecánico", 0, 75.50)); // Precio a modificar en Tarea 5
        stockInicial.add(new Articulo("P003", "Disco SSD 1TB", 30, 89.90));
        stockInicial.add(new Articulo("P004", "Webcam 4K", 5, 120.00));


        // Crear directorio de recursos si no existe
        new File("recursos").mkdirs();

        System.out.println("--- INICIANDO FLUJO DE PRUEBA COMPLETO ---\n");

        // --- I. Ficheros de Texto ---
        exportarA_CSV(stockInicial, RUTA_CSV); // Tarea 1
        System.out.println("[T.2] Artículos con stock 0: " + contarLineasNoVacias(RUTA_CSV) + "\n"); // Tarea 2

        // --- II. Ficheros Binarios Primitivos y Aleatorio ---
        guardarID_Precio(stockInicial, RUTA_PRECIOS_BIN); // Tarea 3 (Ahora con RandomAccessFile)

        System.out.println("--- [T.4] VERIFICACIÓN BINARIO (ANTES DE MODIFICAR) ---");
        leerFicheroPreciosBinario(RUTA_PRECIOS_BIN); // Tarea 4 (Con RandomAccessFile)

        modificarPrecioPorPosicion(RUTA_PRECIOS_BIN, 2, 85.00); // Tarea 5
        System.out.println("\n[T.5] Precio del artículo 2 modificado a 85.00€ con RandomAccessFile.");

        System.out.println("--- [T.4] VERIFICACIÓN BINARIO (DESPUÉS DE MODIFICAR) ---");
        leerFicheroPreciosBinario(RUTA_PRECIOS_BIN); // Tarea 4 (Verificación pos-modificación)

        // --- III. Serialización y JAXB ---
        System.out.println("\n--- INICIANDO SERIALIZACIÓN (T.6) ---");
        // Primero, creamos el fichero
        guardarSerializado(stockInicial, RUTA_STOCK_OBJ); // Tarea 6
        // Luego, añadimos un nuevo artículo 
        List<Articulo> nuevoArticulo = new ArrayList<>();
        nuevoArticulo.add(new Articulo("P005", "Ratón Inalámbrico", 12, 25.00));
        guardarSerializado(nuevoArticulo, RUTA_STOCK_OBJ);

        System.out.println("--- [T.7] VERIFICACIÓN DE OBJETOS SERIALIZADOS ---");
        leerFicheroObjetos(RUTA_STOCK_OBJ); // Tarea 7

        convertirBinarioA_XML(RUTA_STOCK_OBJ, RUTA_XML); // Tarea 8

        generarResumen(RUTA_XML, RUTA_RESUMEN); // Tarea 9
        System.out.println("--- [T.9] Reporte final generado en: " + RUTA_RESUMEN);
        System.out.println("\n--- FIN DEL EXAMEN ---");
    }

    // =========================================================================
    // I. FICHEROS DE TEXTO
    // =========================================================================

    // Tarea 1: Exportación a Fichero de Texto (CSV)
    public static void exportarA_CSV(List<Articulo> lista, String ruta) {
        File txt = new File (ruta);
        
        try(FileWriter writer = new FileWriter(txt)) {
        	//Cabecera
        	writer.write("CODIGO;NOMBRE;STOCK;PRECIO");
        	
        	for (Articulo articulo:lista) {
        		//Recogemos los datos 
        		String codigo = articulo.getCodigo();
        		String nombre = articulo.getNombre();
        		int stock = articulo.getStock();
        		double precio = articulo.getPrecio();
        		//Escribimos con el formato deseado
        		writer.write(codigo + ";" + nombre + ";" + stock + ";" + precio + "\n");
        	}
        } catch (IOException e) {
			e.printStackTrace();
		}

    }

    // Tarea 2: Recuperación de Texto y Documentación (Contar Stock 0)
    public static int contarLineasNoVacias(String rutaFichero) {
    	//Contador de lineas y objeto file con la ruta del fichero
        int stockCero = 0;
        File txt = new File(rutaFichero);
        
        try(FileReader fr = new FileReader(txt); BufferedReader bufer = new BufferedReader(fr)) {
        	String linea;
        	//Flag para consumir la primera linea y que no arroje error al intentar parsear STOCK
        	boolean primeraLinea = true;
        	while ((linea = bufer.readLine()) != null) {
        		if (!primeraLinea) {
        			//Dividimos la linea con split, cogemos el stock que se encuentra en la posicion 2 del arreglo y lo convertimos a entero para saber si es 0
        			if (Integer.parseInt(linea.split(";")[2]) == 0) {
        				stockCero++;
        			}
        		}
        		primeraLinea = false;
        	}
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NumberFormatException e) {
		}
    	return stockCero;
    }

    // =========================================================================
    // II. FICHEROS BINARIOS PRIMITIVOS Y ACCESO ALEATORIO (TODO RandomAccessFile)
    // =========================================================================

    // Tarea 3: Almacenamiento de Datos Primitivos
    public static void guardarID_Precio(List<Articulo> lista, String rutaFichero) {
        File rafFile = new File(rutaFichero);
        
        try(RandomAccessFile raf = new RandomAccessFile(rafFile, "rw")) {
        	for (Articulo articulo:lista) {
        		StringBuilder sb = new StringBuilder();
        		sb.append(articulo.getCodigo());
        		sb.setLength(10);
        		double precio = articulo.getPrecio();
        		
        		raf.writeChars(sb.toString());
        		raf.writeDouble(precio);
        	}
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Tarea 4: Verificación de Fichero Binario
    public static void leerFicheroPreciosBinario(String rutaFichero) {
    	//Creamos el objeto file
    	File rafFile = new File(rutaFichero);
        
    	//Establecemos el acceso en solo lectura con 'r'
        try(RandomAccessFile raf = new RandomAccessFile(rafFile, "r")) {
        	//Bucle para recorrer todo el fichero
        	while (raf.getFilePointer() < raf.length()) {
        		char[] codigo = new char[10];
        		double precio;
        		//Volcamos en un arreglo los 10 caracteres
        		for (int i = 0; i < codigo.length; i++) {
        			codigo[i] = raf.readChar();
        		}
        		//Convertimo a string
        		String codigoS = new String(codigo);
        		//Leemos el precio
        		precio = raf.readDouble();
        		//Eliminamos los espacios e imprimos
        		System.out.println(codigoS.trim() + ";" + precio);
        	}
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    // Tarea 5: Modificación con Posicionamiento Aleatorio
    public static void modificarPrecioPorPosicion(String rutaFichero, int posicion, double nuevoPrecio) {
        //Lo que ocupa cada registro de nuestro fichero aleatorio
    	int tamanioRegistro = 28; //El string 20 el double 8
        File rafFile= new File(rutaFichero);
        
        try(RandomAccessFile raf = new RandomAccessFile(rafFile, "rw")) {
        	//Nos posicionamos al principio del registro deseado, necesario restar 1 sino nos colocaria al final del registro que deseamos modificar
        	raf.seek((posicion - 1) * tamanioRegistro);
        	//Saltamos los bytes que ocupa la cadena para posicionarnos al principio del precio 
        	raf.skipBytes(20);
        	//Sobreescribimos el precio
        	raf.writeDouble(nuevoPrecio);
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }

    // =========================================================================
    // III. SERIALIZACIÓN DE OBJETOS Y CONVERSIÓN JAXB
    // =========================================================================

    // Tarea 6: Almacenamiento y Añadido de Objetos
    public static void guardarSerializado(List<Articulo> articulos, String ruta) {
        File file = new File(ruta);
    	FileOutputStream fo = null;
        ObjectOutputStream datos = null;
        
        try {
	        if (!file.exists()) {
				fo = new FileOutputStream(file);
	        	datos = new ObjectOutputStream(fo);
	        }else {
	        	fo = new FileOutputStream(file, true);
	        	datos = new ObjectStreamAppender(fo);
	        }
	        
	        for(Articulo articulo:articulos) {
	        	datos.writeObject(articulo);
	        }
        } catch (FileNotFoundException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				datos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

    // Tarea 7: Verificación de Serialización
    public static void leerFicheroObjetos(String rutaFichero) {
    	File file = new File(rutaFichero);
    	
    	try(FileInputStream fo = new FileInputStream(file);ObjectInputStream datos = new ObjectInputStream(fo)) {
    		while (true) {
    			Articulo art =(Articulo) datos.readObject();
    			System.out.println(art);
    		}
    	}catch (EOFException e) {
    		
    	}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Método auxiliar para Tarea 8 (reutiliza lógica de Tarea 7)
    private static List<Articulo> leerTodosLosObjetos(String rutaFichero) {
        List<Articulo> articulos = new ArrayList<Articulo>();
        File file = new File(rutaFichero);
        
        try(FileInputStream fo = new FileInputStream(file);ObjectInputStream datos = new ObjectInputStream(fo)) {
    		while (true) {
    			Articulo art =(Articulo) datos.readObject();
    			articulos.add(art);
    		}
    	}catch (EOFException e) {
    		
    	}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	return articulos;
    }

    // Tarea 8: Conversión Objeto Serializado a XML
    public static void convertirBinarioA_XML(String rutaBinario, String rutaXML) {
    	//Recogemos la lista de objetos
    	List<Articulo> articulos = leerTodosLosObjetos(rutaBinario);
    	//Lo pasamos al constructor de almacen que será el contenedor padre de nuestro XML
    	Almacen almacen = new Almacen(articulos);
    	File xml = new File(rutaXML);
    	
    	try {
    		//Creamos contexto y marshaller
			JAXBContext context = JAXBContext.newInstance(Almacen.class);
			Marshaller mar = context.createMarshaller();
			//Formateamos la salida
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			//Guardamos en el fichero
			mar.marshal(almacen, xml);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Tarea 9: Conversión XML a Reporte Final
    public static void generarResumen(String rutaXML, String rutaSalida) {
    	File xml = new File(rutaXML);
    	File resumenSalida = new File(rutaSalida);
    	try {
    		//Creamos contexto y unmarshaller
			JAXBContext context = JAXBContext.newInstance(Almacen.class);
			Unmarshaller un = context.createUnmarshaller();
			
			//Volcamos el contenido en almacen
			Almacen almacen = (Almacen) un.unmarshal(xml);
			List<Articulo> articulos = almacen.getArticulos();
			
			//Calculamos el promedio de los articulos
			double promedio = 0;
			for (Articulo a:articulos) {
				promedio += a.getPrecio();
			}
			promedio = promedio / articulos.size();
			
			//Abrimos flujo hacia el txt de salida
			try(FileWriter fr = new FileWriter(resumenSalida); BufferedWriter writer = new BufferedWriter(fr)) {
				//Escribimos el título y el promedio
				String articulosCaros = "--- REPORTE DE ARTÍCULOS CON PRECIO SUPERIOR AL PROMEDIO ---" + "\n" + "Precio promedio del catálogo: " + promedio + "€" + "\n" + "\n" + "Artículos por encima del promedio:" + "\n";
				for (Articulo a:articulos) {
						//Almacenamos solo los caros
						if (a.getPrecio() > promedio) {
							articulosCaros += "[" + a.getCodigo() + "] " + a.getNombre() + ": " + a.getPrecio() + "€" + "\n";
						}
					}
				writer.write(articulosCaros);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
        
}