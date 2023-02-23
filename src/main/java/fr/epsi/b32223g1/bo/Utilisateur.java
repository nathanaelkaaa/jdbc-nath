package fr.epsi.b32223g1.bo;

public class Utilisateur {
	
	private int id;
	private String nom;
	private String identifiant;
	private String mdp;
	
	public Utilisateur() {
	}
	
	public Utilisateur( String nom, String identifiant, String mdp ) {
		this.nom = nom;
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	
	public Utilisateur( int id, String nom, String identifiant, String mdp ) {
		this.id = id;
		this.nom = nom;
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	public String getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant( String identifiant ) {
		this.identifiant = identifiant;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp( String mdp ) {
		this.mdp = mdp;
	}
	
	@Override
	public String toString() {
		return "Utilisateur{" + "id=" + id + ", nom='" + nom + '\'' + ", identifiant='" + identifiant + '\'' + ", mdp='" + mdp + '\'' + '}';
	}
}
