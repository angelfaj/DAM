package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModeloBuscador {
	private static final File txt = new File("texto.txt");
	
	public int countOcurrences(char c) throws IOException {
		if (!txt.exists()) {
			createAndFillTxt();
		}
		int ocurrencias = 0;
		int aux = 0;
		try(FileReader reader = new FileReader(txt)) {
			while ((aux = reader.read()) != -1) {
				if (aux == c) {
					ocurrencias++;
				}
			}
		}
		return ocurrencias;
	}
	
	public int countOcurrences(String cadena) throws IOException {
		if (!txt.exists()) {
			createAndFillTxt();
		}
		int ocurrencias = 0;
		String line = "";
		
		try(FileReader reader = new FileReader(txt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				for (String s : line.split(" ")) {
					if (s.equalsIgnoreCase(cadena)) {
						ocurrencias++;
					}
				}
			}
		}
		
		return ocurrencias;
	}
	
	public int countChars() throws FileNotFoundException, IOException {
		if (!txt.exists()) {
			createAndFillTxt();
		}
		int ocurrencias = 0;
		int aux = 0;
		try(FileReader reader = new FileReader(txt)) {
			while ((aux = reader.read()) != -1) {
				ocurrencias++;
			}
		}
		
		return ocurrencias;
	}
	
	public int countWords() throws FileNotFoundException, IOException {
		if (!txt.exists()) {
			createAndFillTxt();
		}
		int ocurrencias = 0;
		String line = "";
		
		try(FileReader reader = new FileReader(txt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				for (String s : line.split(" ")) {
						ocurrencias++;
				}			
			}
		}
		
		return ocurrencias;
	}
	
	public int countLines() throws IOException {
		if (!txt.exists()) {
			createAndFillTxt();
		}
		int ocurrencias = 0;
		String line = "";
		
		try(FileReader reader = new FileReader(txt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null) {
				ocurrencias++;
			}
		}
		
		return ocurrencias;
	}
	
	public String getTxtContent() throws FileNotFoundException, IOException {
		String content = "", line = "";
		
		try (FileReader reader = new FileReader(txt); BufferedReader buffer = new BufferedReader(reader)) {
			while ((line = buffer.readLine()) != null ) {
				content += line + "\n";
			}
		}
		return content;
	}
	
	public void createAndFillTxt() throws IOException {
		String contenido = "El taoísmo o daoísmo (en chino, 道教; pinyin, dàojiào; literalmente, ‘enseñanza del camino’) es una tradición filosófica y espiritual de origen chino la cual enfatiza vivir en armonía con el tao (la ‘vía’ o el ‘camino’).\r\n"
				+ "El tao es una idea fundamental en la mayoría de las escuelas que forman parte de la filosofía china; sin embargo, para el taoísmo es referido como el principio de unidad absoluta, y al mismo tiempo mutable, que conforma la realidad suprema y el principio cosmogónico y ontológico de todas las cosas.[2]​ Así, para los taoístas el tao constituye la fuente, el patrón y la sustancia de todo lo existente.[3]​[4]​\r"
				+ "El Dào Dé Jīng (en chino: 道德經) también conocido como Tao Te King o Tao Te Ching, es el libro que condensa las enseñanzas atribuidas al filósofo Lao-Tse, también llamado Lao Tzu, Lao Zi, Laozi (en chino simplificado y tradicional: 老子; en pinyin: lǎozǐ; literalmente 'viejo maestro') o Laocio.[5]​ Y aunque la existencia histórica de tal personalidad aún se debate, el libro es considerado como clave para la tradición taoísta. Junto con el Zhuangzi se consideran los textos clave de la tradición.[6]​\r"
				+ "Y aunque los valores éticos taoístas varían dependiendo de las distintas escuelas, por lo general tienden a enfatizar el wu wei («la no acción» o acción sin intención), la naturalidad, la simplicidad, la espontaneidad, y sobre todo, los «Tres Tesoros»: 慈 «la compasión», 儉 «la frugalidad», y 不敢為天下先 «la humildad», mientras que pone menos énfasis en las normas y el ritual (en oposición al confucianismo).\r"
				+ "El objetivo fundamental de los taoístas es alcanzar la inmortalidad, si bien, a veces no se entiende esta literalmente, sino como longevidad en plenitud. De la misma manera, se decía que las personas que vivían en armonía con la naturaleza eran inmortales. Lao-Tse fue deificado como dios taoísta ―un inmortal― encabezando un enorme panteón de héroes folclóricos., generales famosos y sabios, todos los cuales alcanzaron la inmortalidad. Así como la representación de uno de Tres Puros. Por otra parte, el logro de la inmortalidad a través de la alquimia externa (waidan) y la alquimia interna (neidan) fue un objetivo importante para muchos taoístas históricamente.[7]​\r"
				+ "Las primeras formas del taoísmo se desarrollaron en el siglo IV a. C., influenciadas por las teorías cosmológicas de la Escuela de Naturalistas y el I Ching. La Escuela de Naturalistas fue una escuela filosófica que sintetizó los conceptos de yin-yang y los Cinco Elementos; Zou Yan es considerado el fundador.[8]​ La primera forma organizada de taoísmo, la escuela Tianshi («Maestros Celestiales») surgió en el siglo II a. C. Xuanxue («aprendizaje profundo», también «neo-taoísmo») fue un importante movimiento filosófico influenciado por el confucianismo, que se centró en la interpretación del I Ching, el Dào Dé Jīng y el Zhuangzi y que floreció durante los siglos III a VI d. C.[9]​ Los filósofos más importantes de este movimiento fueron He Yan, Wang Bi, Los siete sabios del bosque de bambú, Ge Hong y Guo Xiang.[10]​ Los pensadores como He Yan y Wang Bi se centraron en la naturaleza profunda del Tao, que vieron como mejor ejemplificado por el término «Wu» (nada, no-ser, negatividad).[11]​ Otras escuelas alcanzaron prominencia a lo largo de la historia de China, como la escuela Shangqing durante la dinastía Tang (618-907), la escuela Lingbao durante la dinastía Song (960-1279) y la escuela Quanzhen, que se desarrolló durante los siglos XIII-XIV y durante la dinastía Yuan.[10]​\r"
				+ "Posteriormente, el taoísmo se mezcló con elementos del confucianismo, el budismo y la religión tradicional china. La forma concreta de religión taoísta que fue llevada a Taiwán en el siglo XVII es típica de esta tradición. La característica más distintiva de la práctica actual es la veneración de los antepasados.\r"
				+ "Los conceptos taoístas influyeron en la medicina tradicional china y en distintas disciplinas como el taichí chuan, el chi-kung y diversas formas de artes marciales. Las tradiciones taoístas posteriores también fueron influidas por el budismo chino.[10]​ ";
		
		try(FileWriter writer = new FileWriter(txt)) {
			writer.write(contenido);
		}
	}
	
}
