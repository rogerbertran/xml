package xml;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ExempleJAXB {
	
	private static final String NOM_FITXER = "exemple.xml";
	private static final String NOM_FITXER2 = "exemple2.xml";
	
	public static void main(String[] args) {
		Empleat currito = new Empleat(12,"man",35,"Pepe","123","Boss");
		Empleat pepon = new Empleat();
		
		/**
		 * try {
		 * 	objecteXml(currito);
		 * } catch (Exception e) {
		 * 	e.printStackTrace();
		 * }
		 */
		try {
			pepon = XmlAObjecte();
			System.out.println(pepon);
		} catch (Exception e) {
			e.printStackTrace();
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
}
