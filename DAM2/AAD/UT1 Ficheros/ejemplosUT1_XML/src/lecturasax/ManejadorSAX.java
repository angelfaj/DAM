package lecturasax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorSAX extends DefaultHandler {

    boolean esNombre = false;
    boolean esEdad = false;
    
	// El comienzo y el final de un documento implican llamadas a los métodos
	// startDocument y endDocument
    @Override
	public void startDocument() {
		System.out.println("Ahora empieza el documento...\n");
	}
    @Override
	public void endDocument() {
		System.out.println("...Ahora termina el documento");
	}

    // Método llamado al encontrar una etiqueta de apertura
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("nombre")) {
            esNombre = true;
        }
        if (qName.equalsIgnoreCase("edad")) {
            esEdad = true;
        }
    }

    // Método llamado al encontrar contenido dentro de una etiqueta, es decir,
    //se llama cuando se encuentra texto entre las etiquetas
	/*
	 * La lectura del texto contenido en cada elemento genera una llamada al método
	 * characters, dentro del cual disponemos del texto en un vector de caracteres
	 * acotado con una posición de comienzo y otra de fin.
	 */
	/*
	 * Algunas puntualizaciones sobre este método: No se puede contar con tener
	 * siempre todo el texto de un elemento en una única llamada a este método
	 * (grandes porciones de texto, texto y elementos hijos se entremezclan,
	 * caracteres especiales, distintos analizadores, etc.) Puede recoger los
	 * espacios en blanco al analizar sin validación (los intros)
	 */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (esNombre) {
            System.out.println("Nombre: " + new String(ch, start, length));
            esNombre = false;
        }
        if (esEdad) {
            System.out.println("Edad: " + new String(ch, start, length));
            esEdad = false;
        }
    }

    // Método llamado al encontrar una etiqueta de cierre
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("alumno")) {
			System.out.println("Fin de persona\n");
		}
    }
    
	/*
	 * Los dos métodos que sirven para controlar las declaraciones de espacios de
	 * nombres son startPrefixMapping y endPrefixMapping. El primero se ejecuta al
	 * declarar un espacio de nombres mediante el atributo xmlns, mientras que el
	 * segundo se ejecuta al cerrar el elemento en el que se declaró el espacio
	 * (normalmente el elemento raíz):
	 */
    @Override
	public void startPrefixMapping(String prefijo, String uri) {
		System.out.println("Comienza el uso del prefijo " + (prefijo.equals("") ? "(vacío)" : prefijo)
				+ " correspondiente a la URI " + uri);
	}
    
    @Override
	public void endPrefixMapping(String prefijo) {
		System.out.println("Termina el uso del prefijo " + (prefijo.equals("") ? "(vacío)" : prefijo));
	}
}
