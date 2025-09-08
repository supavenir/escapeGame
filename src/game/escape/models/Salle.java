package game.escape.models;

import java.util.ArrayList;
import java.util.List;

import game.escape.exceptions.NullResponseException;

public class Salle {
	private String nom;
	private List<Enigme> enigmes;
	private int tempsLimite;
	private boolean estTerminee;
	
	public Salle(String nom, int tempsLimite) {
		this.nom = nom;
		this.tempsLimite = tempsLimite;
		this.enigmes=new ArrayList<>();
	}
	
	public void ajouterEnigme(Enigme enigme) {
		if(!enigmes.contains(enigme)) {
			enigmes.add(enigme);
		}
	}
	
	public boolean resoudreEnigme(int index, String reponse) throws NullResponseException {
		if(index < enigmes.size() && index >= 0) {
			return enigmes.get(index).resoudre(reponse);
		}
	return false;
	}
	
	public List<Enigme> getEnigmes() {
		return enigmes;
	}
}
