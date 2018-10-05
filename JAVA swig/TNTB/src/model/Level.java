package model;

public class Level {

	private int id ;
	private String libelle ;
	private int nbL ;
	private int nbC ;
	
	public Level() {
		id = 0 ;
		libelle = "" ;
		nbL = 0 ;
		nbC = 0 ;
	}

	public Level(String libelle, int nbL, int nbC) {
		super();
		this.libelle = libelle;
		this.nbL = nbL;
		this.nbC = nbC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNbL() {
		return nbL;
	}

	public void setNbL(int nbL) {
		this.nbL = nbL;
	}

	public int getNbC() {
		return nbC;
	}

	public void setNbC(int nbC) {
		this.nbC = nbC;
	}
	
}
