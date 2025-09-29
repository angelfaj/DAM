package lecturasax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class LeerXMLSAX {

    public static void main(String[] args) {
        try {
            // Crear una fábrica de parseadores SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            // Crear un nuevo parseador SAX
            SAXParser saxParser = factory.newSAXParser();
            
            // Crear una instancia del manejador de eventos personalizado
            ManejadorSAX handler = new ManejadorSAX();

            // Ruta del archivo XML
            String xmlPath = "res/Alumnos.xml"; // Ruta del fichero xml a leer
            
            // Parsear el archivo XML
            saxParser.parse(xmlPath, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
