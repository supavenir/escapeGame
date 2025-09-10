package game.escape.models;

import java.util.ArrayList;
import java.util.List;

import game.escape.exceptions.NullResponseException;

public class Salle {
	private String nom;
	protected List<Enigme> enigmes;
	private int tempsLimite;
	private boolean estTerminee;
	private Salle salleSuivante;
	
	public Salle(String nom, int tempsLimite) {
		this.nom = nom;
		this.tempsLimite = tempsLimite;
		this.enigmes=new ArrayList<>();
	}
	
	public void initialize() {
		
	}
	
	public boolean ajouterEnigme(Enigme enigme) {
		if(!enigmes.contains(enigme)) {
			return enigmes.add(enigme);
		}
		return false;
	}
	
	public boolean resoudreEnigme(int index, String reponse) throws NullResponseException {
		if(index < enigmes.size() && index >= 0) {
			return enigmes.get(index).resoudre(reponse);
		}
	return false;
	}
	
	/**
	 * Retourne la liste des enigmes non résolues
	 * @return les énigmes non résolues
	 */
	public List<Enigme> getEnigmesNonResolues(){
		List<Enigme> nonResolues=new ArrayList<>();
		for(Enigme e:enigmes) {
			if(!e.isResolue()) {
				nonResolues.add(e);
			}
		}
		return nonResolues;
	}
	
	public List<Enigme> getEnigmes() {
		return enigmes;
	}
	
	public Salle getSalleSuivante() {
		return salleSuivante;
	}
	
	public boolean estTerminee() {
		return getEnigmesNonResolues().isEmpty();
	}
	
	public boolean estSalleDeFin() {
		return salleSuivante==null;
	}
}
