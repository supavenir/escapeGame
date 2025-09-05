package game.escape.models;

import java.util.List;

public class Salle {
	private String nom;
	private List<Enigme> enigmes;
	private int tempsLimite;
	private boolean estTerminee;
	
	public Salle(String nom, int tempsLimite) {
		this.nom = nom;
		this.tempsLimite = tempsLimite;
	}
	
	public void ajouterEnigme(Enigme enigme) {
		enigmes.add(enigme);
	}
	
	public boolean resoudreEnigme(int index, String reponse) {
		if(index < enigmes.size() && index >= 0) {
			return enigmes.get(index).resoudre(reponse);
		}
	return false;
	}
}
