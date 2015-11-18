package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "Company_Staff")
public class Staff {
	
	@XmlElement(name = "Pencaire", type = Empleat.class)
	private ArrayList<Empleat> currantes = new ArrayList<Empleat>();

	public ArrayList<Empleat> getCurrantes() {
		return currantes;
	}
	
	public void add(Empleat currante) {
		currantes.add(currante);
	}
	
	public void setCurrantes(ArrayList<Empleat> currantes) {
		this.currantes = currantes;
	}

	public Staff(ArrayList<Empleat> currantes) {
		super();
		this.currantes = currantes;
	}
	
	public Staff() {
		super();
	}
}
