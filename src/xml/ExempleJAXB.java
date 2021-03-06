package xml;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ExempleJAXB {
	
	private static final String NOM_FITXER = "exemple.xml";
	private static final String NOM_FITXER2 = "exemple2.xml";
	private static final String NOM_FITXER3 = "exemple3.xml";

	public static void main(String[] args) {
		Empleat currito = new Empleat(12,"man",35,"Pepe","123","Boss");
		Empleat chema = new Empleat(13,"man",32,"Chema","Delegat","Boss");
		Empleat juan = new Empleat(14,"man",35,"Juan","PENELARGO","jefote");
	try {	
		Staff myStaff = new Staff();
		myStaff.add(chema);
		myStaff.add(juan);
		
		marshalLlista(myStaff, new File("llistaEmpleats.xml"));
		/**
		 * try {
		 * 	objecteXml(currito);
		 * } catch (Exception e) {
		 * 	e.printStackTrace();
		 * }
		 */
			chema = XmlAObjecte();
			System.out.println(chema);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void marshalLlista(Staff myStaff, File file) {
		try {
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(file));
			Marshaller m = contexte.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(myStaff, writer);
			writer.close();
		} catch (JAXBException | IOException j) {
			j.printStackTrace();
		}
	}
	
	private static void objecteAXml(Empleat currante) {
		try {
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
			Marshaller m = contexte.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(currante, new File(NOM_FITXER));
		} catch (JAXBException j) {
			j.printStackTrace();
		}
	}
	
	private static Empleat XmlAObjecte() {
		try {
			JAXBContext contexte = JAXBContext.newInstance(Empleat.class);
			Unmarshaller um = contexte.createUnmarshaller();
			Empleat currante = (Empleat) um.unmarshal(new File(NOM_FITXER2));
			return currante;
		} catch (JAXBException j) {
			j.printStackTrace();
		}
		return null;
	}
	
	private static Staff unMarsalLista(File file) {
		try {
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(file));
			JAXBContext contexte = JAXBContext.newInstance(Staff.class);
			Unmarshaller um = contexte.createUnmarshaller();
			Staff lista = (Staff) um.unmarshal(new File(NOM_FITXER3));
			return lista;
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
