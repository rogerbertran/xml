package xml;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement (name = "Treballador")
@XmlType (propOrder = {"nom", "carrec", "edat", "sexe"})

public class Empleat {
	private int id;
	private String sexe;
	private int edat;
	private String nom;
	private String carrec;
	private String password;
	
	
	
	public Empleat() {
		super();
	}

	public Empleat(int id, String sexe, int edat, String nom, String carrec, String password) {
		super();
		this.id = id;
		this.sexe = sexe;
		this.edat = edat;
		this.nom = nom;
		this.carrec = carrec;
		this.password = password;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCarrec() {
		return carrec;
	}
	public void setCarrec(String carrec) {
		this.carrec = carrec;
	}
	
	@XmlTransient
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}