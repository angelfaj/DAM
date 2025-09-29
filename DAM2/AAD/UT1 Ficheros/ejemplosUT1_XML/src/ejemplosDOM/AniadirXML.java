package ejemplosDOM;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 *
 * @author Patricia
 */
public class AniadirXML {

    //Constructor vacio
    public AniadirXML() {
    }

    //Abrir un fichero XML pasado por parámetro y cargarlo en arbol DOM
    public Document abrir_XML_DOM(File f) {
        Document doc = null;//Representa al árbol DOM
        try {
            //Se crea un objeto DocumentBuiderFactory.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Indica que el modelo DOM no debe contemplar los comentarios     //que tenga  el XML. 
            factory.setIgnoringComments(true);
            //Ignora los espacios en blanco que tenga el documento
            factory.setIgnoringElementContentWhitespace(true);
            //Se crea un objeto DocumentBuilder para cargar en él la //estructura de árbol DOM a partir del XML  
            //seleccionado.
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Interpreta (parsear) el documento XML (file) y genera el DOM //equivalente.
            doc = builder.parse(f);
            
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            return doc;
        }
    }

    //Recorrer arbl DOM y escribir su contenido por pantalla
    public String recorrerDOMyMostrar(Document doc) {
        String datos_nodo[] = null;
        String salida = "";
        Node node;
        
        //Obtiene el primero nodo del DOM (primer hijo)
        Node raiz = doc.getFirstChild();
        //Obtiene una lista de nodos con todos los nodos hijo del raíz.
        NodeList nodelist = raiz.getChildNodes();
        //Procesa los nodos hijo
        for (int i = 0; i < nodelist.getLength(); i++) {
            node = nodelist.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Es un nodo libro 
                datos_nodo = procesarLibro(node);
                salida = salida + "\n " + "Publicado en: " + datos_nodo[0];
                salida = salida + "\n " + "El autor es: " + datos_nodo[2];
                salida = salida + "\n " + "El título es: " + datos_nodo[1];
                salida = salida + "\n ------------------------------------------------";
            }
        }
        return salida;
    }

    //Procesar información del nodo pasado por parametro
    protected String[] procesarLibro(Node n) {
        String datos[] = new String[3];
        Node ntemp = null;
        int contador = 1;
        //Obtiene el valor del primer atributo del nodo (uno en este ejemplo) 
        datos[0] = n.getAttributes().item(0).getNodeValue();
        //Obtiene los hijos del Libro (titulo y autor)
        NodeList nodos = n.getChildNodes();
        for (int i = 0; i < nodos.getLength(); i++) {
            ntemp = nodos.item(i);
            if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                //IMPORTANTE: para obtener el texto con el título y autor se accede al nodo //TEXT hijo de ntemp y se 
                //saca su valor.
                datos[contador] = ntemp.getChildNodes().item(0).getNodeValue();
                contador++;
            }
        }
        return datos;
    }

    public int annadirDOM(Document doc, String titulo, String autor, String anno) {
        try {
            //Se crea un nodo tipo Element  y nombre ‘titulo’ 
            Node ntitulo = doc.createElement("Titulo");
            //Se crea un nodo tipo texto con el título del libro
            Node ntitulo_text = doc.createTextNode(titulo);
            //Se añade el nodo de texto con el título como 
            //hijo del elemento Titulo 
            ntitulo.appendChild(ntitulo_text);

            //Se crea un nodo tipo Element  y nombre ‘autor’ 
            Node nautor = doc.createElement("Autor");
            //Se crea un nodo tipo texto con el título del libro
            Node nautor_text = doc.createTextNode(autor);
            //Se añade el nodo de texto con el título como hijo del elemento Titulo 
            nautor.appendChild(nautor_text);

            //Se crea un nodo de tipo elemento para libro
            Node nlibro = doc.createElement("Libro");
            ((Element) nlibro).setAttribute("publicado_en", anno);

            //Se añade a libro el nodo autor y titulo creados antes
            nlibro.appendChild(ntitulo);
            nlibro.appendChild(nautor);

            //Finalmente, se obtiene el primer nodo del documento y a él se le añade como hijo el nodo 
            //libro que ya tiene colgando todos sus hijos y atributos creados antes.
            Node raiz = doc.getChildNodes().item(0);
            raiz.appendChild(nlibro);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    
    public void guardarDOMcomoFILE(Document doc,File fsalida) throws TransformerConfigurationException, IOException, TransformerException  {
        
       //Creamos las clases para realizar la transformación del Docuement a XML
       TransformerFactory factoria = TransformerFactory.newDefaultInstance();
       Transformer transformer=factoria.newTransformer();
       //Para habilitar la sangría y los saltos de línea, se establece la propiedad OutputKeys.INDENT a "yes".
       transformer.setOutputProperty(OutputKeys.INDENT, "yes");

       //La cantidad de espacios para la sangría se configura con la propiedad específica de Apache indent-amount.
       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Cantidad de espacios para la sangría

       //Prepararmos la entrada y salida para la transformacion
       DOMSource source = new DOMSource(doc);
      
//       FileWriter fw = new FileWriter(fsalida);
//       PrintWriter pw = new PrintWriter(fw);
//       Result result = new StreamResult(pw);
       // Definir el archivo de salida
       StreamResult result = new StreamResult(fsalida);

       
       //Transformamos el DOM en fichero XML en salida.xml
       transformer.transform(source,result);
       
    }
    
    public void hacerCopiaFicheroXML(File origen, File destino) throws TransformerException, SAXException, IOException, ParserConfigurationException {
    	//Copiamos el fichero libros.xml en fichero_destino.xml
  
            // Lectura de origen.xml
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(origen);

            // Ahora documento es el XML leido en memoria.
            // Escritura de destino.xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Para habilitar la sangría y los saltos de línea, se establece la propiedad OutputKeys.INDENT a "yes".
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            //La cantidad de espacios para la sangría se configura con la propiedad específica de Apache indent-amount.
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Cantidad de espacios para la sangría
            
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(destino);
            transformer.transform(source, result);
    }
    
    public static void main(String[] args) {
		AniadirXML aniadirxml= new AniadirXML();
		File f=new File("res/libros.xml");
		Document documentoXML=aniadirxml.abrir_XML_DOM(f);
		//Ahora doc apunta al árbol DOM listo para ser recorrido.

        System.out.println("Recorriendo el arbol DOM");
        //Pintamos por pantalla la salida
        System.out.println(aniadirxml.recorrerDOMyMostrar(documentoXML));

        System.out.println("Añadiendo nuevo libro");
        //Añado nuevo libro
        aniadirxml.annadirDOM(documentoXML, "Los pilares de la Tierra", "Ken Follett", "1989");

        System.out.println("Recorriendo el arbol DOM");
        //Pintamos por pantalla la salida
        System.out.println(aniadirxml.recorrerDOMyMostrar(documentoXML));
        
        try {
        	System.out.println("Guardando en salida.xml el nuevo resultado del DOM tras añadir nodo");
        	File fsal = new File ("res/salida.xml");
			aniadirxml.guardarDOMcomoFILE(documentoXML,fsal);
			
	        System.out.println("Haciando copia de libros.xml en libros_copia.xml");
	        aniadirxml.hacerCopiaFicheroXML(new File ("res/libros.xml"), new File("res/libros_copia.xml"));
	        System.out.println("Haciando copia de salida.xml en salida_copia.xml");
	        aniadirxml.hacerCopiaFicheroXML(new File ("res/salida.xml"), new File("res/salida_copia.xml"));

		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

                
	}


}
